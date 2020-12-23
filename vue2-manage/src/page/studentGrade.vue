<template>
    <div class="fillcontain">
        <stu-top></stu-top>
        <div class="data_list"><span class="data_num">平均分 ：{{avegrade}}</span></div>
        <div class="table_container">
            <el-table
                :data="tableData"
                highlight-current-row
                style="width: 100%">

                <el-table-column
                    label="课程号"
                    prop="courseId">
                </el-table-column>
                <el-table-column
                    label="课程名称"
                    prop="courseName">
                </el-table-column>
                <el-table-column
                    label="教师编号"
                    prop="teacherId">
                </el-table-column>
                <el-table-column
                    label="成绩"
                    prop="grade">
                </el-table-column>

            </el-table>
            <div class="Pagination">
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
    import stuTop from "../components/stuTop";
    import common from '@/components/common';
    export default {
        data() {
            return {
                keywords: '',
                offset: 0,
                limit: 20,
                count: 0,
                tableData: [],
                allData: [],
                currentPage: 1,
                addMode: 0,
                selectTable: {},
                dialogFormVisible: false,
                avegrade : 0
            }
        },
        components:{
            stuTop,
        },
        created() {
            this.initData();
        },
        methods: {
            async initData() {
                try {
                    this.selectAll();
                } catch (err) {
                    console.log('获取数据失败', err);
                }
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1) * this.limit;
                this.showAll()
            },
            handleEdit(row) {
                if (row === -1) {
                    this.addMode = 1;
                    this.selectTable = {};
                } else {
                    this.addMode = 0;
                    this.selectTable = row
                }
                this.dialogFormVisible = true;
            },
            showAll() {
                this.tableData = [];
                var i, len, l, r, tg;
                len = this.allData.length
                this.count = len
                l = (this.currentPage - 1) * this.limit
                r = l + this.limit
                tg=0;
                for (i = 0; i < len; i++) {
                    tg+=this.allData[i].grade
                }
                if(len>0) this.avegrade=(tg/len).toFixed(2);
                for (i = l; i < r && i < len; i++) {
                    this.tableData.push({
                        courseId: this.allData[i].course,
                        courseName: this.allData[i].student,
                        teacherId: this.allData[i].teacher,
                        grade: this.allData[i].grade
                    })
                }

            },
            selectAll() {
                this.$axios
                    .post('/studentcourse/selectByStudent',{student: common.userId})
                    .then(successResponse => {
                        this.allData = successResponse.data
                        this.showAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '获取成绩失败'});
                    })
            }
        },
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .data_list{
        text-align: center;
        font-size: 14px;
        color: #666;
        border-radius: 6px;
        background: #E5E9F2;
        .data_num{
            color: #333;
            font-size: 26px;

        }
        .head{
            border-radius: 6px;
            font-size: 22px;
            padding: 4px 0;
            color: #fff;
            display: inline-block;
        }
    }
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

    .table_container {
        padding: 20px;
    }

    .Pagination {
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
