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
                            @click="handleEdit(scope.row)">借阅</el-button>
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
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return {
            keywords:'',
            offset: 0,
            limit: 10,
            count: 0,
            tableData: [],
            allData: [],
            currentPage: 1,
            addMode: 0,
            selectTable: {},
            dialogFormVisible: false,
        }
    },
    created(){
        this.initData();
    },
    methods: {
        async initData(){
            try{
                this.selectAll();
            }catch(err){
                console.log('获取数据失败', err);
            }
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
            this.currentPage = val;
            this.offset = (val - 1)*this.limit;
            this.showAll()
        },
        handleEdit(row) {
            if(row === -1) {
                this.addMode = 1;
                this.selectTable={};
            }
            else {
                this.addMode=0;
                this.selectTable=row
            }
            this.dialogFormVisible = true;
        },
        showAll() {
            this.tableData=[];
            var i,len,l,r;
            len=this.allData.length
            this.count=len
            l=(this.currentPage-1)*this.limit
            r=l+this.limit
            for(i=l;i<r&&i<len;i++)
            {
                this.tableData.push({
                    bookId: this.allData[i].bookId,
                    bookName: this.allData[i].name,
                    bookWriter: this.allData[i].author,
                    bookPublisher: this.allData[i].publisher,
                    bookPublishYear: this.allData[i].publishDate,
                    bookStatus: this.allData[i].state
                })
            }
        },
        searchClick(){
            this.$axios
                .post('/book/selectByIdOrName',{bookId: "%"+this.keywords+"%",
                    name:"%"+this.keywords+"%"})
                .then(successResponse => {
                    this.allData=successResponse.data
                    this.showAll();
                })
                .catch(failResponse => {
                    this.$message({type: 'error',message: '查询课程信息失败'});
                })
        },
        selectAll () {
            this.$axios
                .get('/book/selectAll')
                .then(successResponse => {
                    this.allData=successResponse.data
                    this.showAll();
                })
                .catch(failResponse => {
                    this.$message({type: 'error',message: '获取课程信息失败'});
                })
        },
        insertOrUpdate() {
            if(this.addMode===0) this.update();
            else this.insert();
        },
        insert() {
            this.dialogFormVisible = false;
            this.$axios
                .post('/book/insert', {
                    bookId: this.selectTable.bookId,
                    name: this.selectTable.bookName,
                    author: this.selectTable.bookWriter,
                    publisher: this.selectTable.bookPublisher,
                    publishDate: this.selectTable.bookPublishYear,
                    state: this.selectTable.bookStatus}
                )
                .then(successResponse => {
                    //console.log(successResponse);
                    this.$message({type: 'success',message: '添加课程信息成功'});
                    this.selectAll();
                })
                .catch(failResponse => {
                    this.$message({type: 'error',message: '添加课程信息失败'});
                    this.showAll();
                })
        },
        update() {
            this.dialogFormVisible = false;
            this.$axios
                .put('/book/update', {
                    bookId: this.selectTable.bookId,
                    name: this.selectTable.bookName,
                    author: this.selectTable.bookWriter,
                    publisher: this.selectTable.bookPublisher,
                    publishDate: this.selectTable.bookPublishYear,
                    state: this.selectTable.bookStatus}
                )
                .then(successResponse => {
                    //console.log(successResponse);
                    this.$message({type: 'success',message: '更新课程信息成功'});
                    this.selectAll();
                })
                .catch(failResponse => {
                    this.$message({type: 'error',message: '更新课程信息失败'});
                    this.showAll();
                })
        },
        deletenb(name) {
            this.$axios
                .post('/book/delete', {bookId: name})
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
