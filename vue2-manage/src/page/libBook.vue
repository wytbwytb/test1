<template>
    <div class="fillcontain">
        <libHead-top></libHead-top>
        <div class="table_container">
            <el-table
                :data="bookData"
                highlight-current-row
                style="width: 100%">
                <el-table-column
                    type="index"
                    label="index"
                    width="100">
                </el-table-column>
                <el-table-column
                    property="bookId"
                    label="图书编号"
                    width="180">
                </el-table-column>
                <el-table-column
                    property="bookName"
                    label="书名"
                    width="180">
                </el-table-column>
                <el-table-column
                    property="bookAuthor"
                    label="图书作者"
                    width="180">
                </el-table-column>
                <el-table-column
                    property="bookPublish"
                    label="出版社"
                    width="180">
                </el-table-column>
                <el-table-column
                    property="bookPublishYear"
                    label="出版年份"
                    width="180">
                </el-table-column>
                <el-table-column
                    property="bookStatus"
                    label="借阅状态">
                </el-table-column>
            </el-table>
            <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-size="20"
                    layout="total, prev, pager, next"
                    :total="count">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import libHeadTop from "../components/libHeadTop";
    //import {getUserList, getUserCount} from '@/api/getData'
    export default {
        data(){
            return {
                bookData: [{
                    bookId: '2016-05-02',
                    bookName: '王小虎',
                    bookAuthor: 'wtb',
                    bookPublish: 'wtb',
                    bookPublishYear: '2020',
                    bookStatus: '已借出',
                }, {
                    bookId: '2016-05-02',
                    bookName: '王小虎1',
                    bookAuthor: 'wtbnb',
                    bookPublish: '',
                    bookPublishYear: '',
                    bookStatus: '',
                }, {
                    bookId: '2016-05-02',
                    bookName: '王小虎2',
                    bookAuthor: 'wtbnb',
                    bookPublish: '',
                    bookPublishYear: '',
                    bookStatus: '',
                }, {
                    bookId: '2016-05-02',
                    bookName: '王小虎3',
                    bookAuthor: 'wtbnb',
                    bookPublish: '',
                    bookPublishYear: '',
                    bookStatus: '',
                }],
                currentRow: null,
                offset: 0,
                limit: 20,
                count: 0,
                currentPage: 1,
            }
        },
        components: {
            libHeadTop,
        },
        created(){
            this.initData();
        },
        methods: {
            async initData(){
                /*try{
                    const countData = await getUserCount();
                    if (countData.status == 1) {
                        this.count = countData.count;
                    }else{
                        throw new Error('获取数据失败');
                    }
                    this.getUsers();
                }catch(err){
                    console.log('获取数据失败', err);
                }*/
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.getUsers()
            },
            async getUsers(){
                /*const Users = await getUserList({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Users.forEach(item => {
                    const tableData = {};
                    tableData.username = item.username;
                    tableData.registe_time = item.registe_time;
                    tableData.city = item.city;
                    this.tableData.push(tableData);
                })*/
            }
        },
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .table_container{
        padding: 20px;
    }
</style>
