<template>
    <div class="fillcontain">
        <div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过图书名查询..."
                prefix-icon="el-icon-search"
                size="small"
                style="width: 400px;margin-right: 10px"
                v-model="keywords">
            </el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>

        </div>

        <div class="table_container">

            <el-table
                :data="tableData"
                highlight-current-row
                style="width: 100%">
                <el-table-column
                    label="图书编号"
                    prop="bookId">
                </el-table-column>
                <el-table-column
                    label="书名"
                    prop="bookName">
                </el-table-column>
                <el-table-column
                    label="作者"
                    prop="bookWriter">
                </el-table-column>
                <el-table-column
                    label="出版社"
                    prop="bookPublisher">
                </el-table-column>
                <el-table-column
                    label="出版年份"
                    prop="bookPublishYear">
                </el-table-column>
                <el-table-column
                    label="借阅状态"
                    prop="bookStatus">
                </el-table-column>
                <el-table-column label="操作" width="160">
                    <template slot-scope="scope">
                        <el-button
                            size="small"
                            @click="handleEdit(scope.row)">编辑</el-button>
                        <el-button
                            size="small"
                            type="danger"
                            @click="deletenb(scope.row.name)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <div class="Pagination">
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-size="10"
                    layout="total, prev, pager, next"
                    :total="count">
                </el-pagination>
            </div>
            <div  style="text-align:center">
                <el-button class="el-icon-plus"  @click="handleEdit(-1)">添加书籍</el-button>
            </div>
            <el-dialog title="修改书籍信息" v-model="dialogFormVisible">
                <el-form :model="selectTable">
                    <el-form-item label="图书编号" label-width="100px">
                        <el-input v-model="selectTable.bookId" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="图书名称" label-width="100px">
                        <el-input v-model="selectTable.bookName"></el-input>
                    </el-form-item>
                    <el-form-item label="作者" label-width="100px">
                        <el-input v-model="selectTable.bookWriter"></el-input>
                    </el-form-item>
                    <el-form-item label="出版社" label-width="100px">
                        <el-input v-model="selectTable.bookPublisher"></el-input>
                    </el-form-item>
                    <el-form-item label="出版年份" label-width="100px">
                        <el-input v-model="selectTable.bookPublishYear"></el-input>
                    </el-form-item>
                    <el-form-item label="借阅状态" label-width="100px">
                        <el-input v-model="selectTable.bookStatus"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="insertOrUpdate">确 定</el-button>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import {baseUrl, baseImgPath} from '@/config/env'
    import {getFoods, getFoodsCount, getMenu, updateFood, deleteFood, getResturantDetail, getMenuById} from '@/api/getData'
    export default {
        data(){
            return {
                baseUrl,
                baseImgPath,
                keywords:'',
                restaurant_id: null,
                offset: 0,
                limit: 10,
                count: 0,
                tableData: [],
                currentPage: 1,
                addMode: 0,
                selectTable: {},
                dialogFormVisible: false,
                menuOptions: [],
                selectMenu: {},
                selectIndex: null,
                expendRow: [],
            }
        },
        created(){
            this.initData();
        },
        computed: {
            specs: function (){
                let specs = [];
                if (this.selectTable.specfoods) {
                    this.selectTable.specfoods.forEach(item => {
                        specs.push({
                            specs: item.specs_name,
                            packing_fee: item.packing_fee,
                            price: item.price,
                        })
                    })
                }
                return specs
            }
        },
        components: {
            headTop,
        },
        methods: {
            async initData(){
                try{
                    /*const countData = await getFoodsCount({restaurant_id: this.restaurant_id});
                    if (countData.status == 1) {
                        this.count = countData.count;
                    }else{
                        throw new Error('获取数据失败');
                    }
                    this.getFoods();*/
                    this.selectAll();
                }catch(err){
                    console.log('获取数据失败', err);
                }
            },
            async getMenu(){
                this.menuOptions = [];
                try{
                    const menu = await getMenu({restaurant_id: this.selectTable.restaurant_id, allMenu: true});
                    menu.forEach((item, index) => {
                        this.menuOptions.push({
                            label: item.name,
                            value: item.id,
                            index,
                        })
                    })
                }catch(err){
                    console.log('获取食品种类失败', err);
                }
            },
            /*async getFoods(){
                const Foods = await getFoods({offset: this.offset, limit: this.limit, restaurant_id: this.restaurant_id});
                this.tableData = [];
                Foods.forEach((item, index) => {
                    const tableData = {};
                    tableData.name = item.name;
                    tableData.item_id = item.item_id;
                    tableData.description = item.description;
                    tableData.rating = item.rating;
                    tableData.month_sales = item.month_sales;
                    tableData.restaurant_id = item.restaurant_id;
                    tableData.category_id = item.category_id;
                    tableData.image_path = item.image_path;
                    tableData.specfoods = item.specfoods;
                    tableData.index = index;
                    this.tableData.push(tableData);
                })
            },*/
            tableRowClassName(row, index) {
                if (index === 1) {
                    return 'info-row';
                } else if (index === 3) {
                    return 'positive-row';
                }
                return '';
            },

            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.getFoods()
            },

            handleEdit(row) {
                if(row === -1) {
                    this.addMode = 1;
                    this.selectTable={};
                }
                else {
                    this.addMode=0;
                    this.getSelectItemData(row, 'edit')
                }
                this.dialogFormVisible = true;
            },
            async getSelectItemData(row, type){
                const restaurant = await getResturantDetail(row.restaurant_id);
                const category = await getMenuById(row.category_id)
                this.selectTable = {...row, ...{restaurant_name: restaurant.name, restaurant_address: restaurant.address, category_name: category.name,classHelper:restaurant}};

                this.selectMenu = {label: category.name, value: row.category_id}
                this.tableData.splice(row.index, 1, {...this.selectTable});
                this.$nextTick(() => {
                    this.expendRow.push(row.index);
                })
                if (type == 'edit' && this.restaurant_id != row.restaurant_id) {
                    this.getMenu();
                }
            },
            handleSelect(index){
                this.selectIndex = index;
                this.selectMenu = this.menuOptions[index];
            },
            async handleDelete(index, row) {
                try{
                    const res = await deleteFood(row.item_id);
                    if (res.status == 1) {
                        this.$message({
                            type: 'success',
                            message: '删除食品成功'
                        });
                        this.tableData.splice(index, 1);
                    }else{
                        throw new Error(res.message)
                    }
                }catch(err){
                    this.$message({
                        type: 'error',
                        message: err.message
                    });
                    console.log('删除食品失败')
                }
            },

            async updateFood(){
                this.dialogFormVisible = false;
                try{
                    const subData = {new_category_id: this.selectMenu.value, specs: this.specs};
                    const postData = {...this.selectTable, ...subData};
                    const res = await updateFood(postData)
                    if (res.status == 1) {
                        this.$message({
                            type: 'success',
                            message: '更新食品信息成功'
                        });
                        this.getFoods();
                    }else{
                        this.$message({
                            type: 'error',
                            message: res.message
                        });
                    }
                }catch(err){
                    console.log('更新餐馆信息失败', err);
                }
            },
            searchClick(){
                //wdnmd
            },
            selectAll () {
                this.$axios
                    .get('/class/selectAll', {})
                    .then(successResponse => {
                        console.log(successResponse);
                        this.tableData=[];
                        var i;
                        for(i=0;i<successResponse.data.length;i++)
                        {
                            //console.log(successResponse.data[i]);
                            this.tableData.push({
                                classId: successResponse.data[i].classId,
                                className: successResponse.data[i].department,
                                classMaster: successResponse.data[i].header,
                                classHelper: successResponse.data[i].classMaster,
                                //wdnmd classHelper
                            })
                        }
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '获取班级信息失败'});
                    })
            },
            insertOrUpdate() {
                if(this.addMode===0) this.update();
                else this.insert();
            },
            insert() {
                this.dialogFormVisible = false;
                this.$axios
                    .post('/class/insert', {
                        classId: this.selectTable.classId,
                        department: this.selectTable.className,
                        header: this.selectTable.classMaster,
                        helper:this.selectTable.classHelper,
                        counsellor: "wdnmd2"}
                    )
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success',message: '添加班级信息成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '添加班级信息失败'});
                    })
            },
            update() {
                this.dialogFormVisible = false;
                this.$axios
                    .put('/class/update', {
                        classId: this.selectTable.name,
                        department: this.selectTable.description,
                        header: this.selectTable.rating,
                        counsellor: "wdnmd"}
                    )
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success',message: '更新班级信息成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '更新班级信息失败'});
                    })
            },
            deletenb(name) {
                console.log(name);
                this.$axios
                    .post('/class/delete', {classId: name})
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success',message: '删除成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '删除失败'});
                    })
            }
        },
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .demo-table-expand {
        font-size: 0;
    }
    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }
    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
    .table_container{
        padding: 20px;
    }
    .Pagination{
        display: flex;
        justify-content: flex-start;
        margin-top: 8px;
    }
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #20a0ff;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 120px;
        height: 120px;
        line-height: 120px;
        text-align: center;
    }
    .avatar {
        width: 120px;
        height: 120px;
        display: block;
    }
</style>
