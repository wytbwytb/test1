<template>
    <div class="fillcontain">
        <head-top></head-top>
        <div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过编号或课程名称查询..."
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
                    label="课程编号"
                    prop="courseId">
                </el-table-column>
                <el-table-column
                    label="课程名称"
                    prop="courseName">
                </el-table-column>
                <el-table-column
                    label="学分"
                    prop="courseCredit">
                </el-table-column>
                <el-table-column
                    label="开课院系"
                    prop="courseDept">
                </el-table-column>
                <el-table-column label="操作" width="160">
                    <template slot-scope="scope">
                        <el-button
                            size="small"
                            @click="handleEdit(scope.row)">编辑
                        </el-button>
                        <el-button
                            size="small"
                            type="danger"
                            @click="deletenb(scope.row.courseId)">删除
                        </el-button>
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
            <div style="text-align:center">
                <el-button class="el-icon-plus" @click="handleEdit(-1)">新增课程</el-button>
            </div>
            <el-dialog title="添加/修改课程信息" v-model="dialogFormVisible">
                <el-form :model="selectTable">
                    <el-form-item label="课程编号" label-width="100px">
                        <el-input v-model="selectTable.courseId" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="课程名称" label-width="100px">
                        <el-input v-model="selectTable.courseName"></el-input>
                    </el-form-item>
                    <el-form-item label="学分" label-width="100px">
                        <el-input v-model="selectTable.courseCredit"></el-input>
                    </el-form-item>
                    <el-form-item label="开设院系" label-width="100px">
                        <el-input v-model="selectTable.courseDept"></el-input>
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
    import headTop from "../components/headTop";
    export default {
        data() {
            return {
                keywords: '',
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
        created() {
            this.initData();
        },
        components:{
            headTop,
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
                var i, len, l, r;
                len = this.allData.length
                this.count = len
                l = (this.currentPage - 1) * this.limit
                r = l + this.limit
                for (i = l; i < r && i < len; i++) {
                    this.tableData.push({
                        courseId: this.allData[i].courseId,
                        courseName: this.allData[i].name,
                        courseCredit: this.allData[i].credit,
                        courseDept: this.allData[i].department
                    })
                }
            },
            searchClick() {
                this.$axios
                    .post('/course/selectByIdOrName', {
                        courseId: "%" + this.keywords + "%",
                        name: "%" + this.keywords + "%"
                    })
                    .then(successResponse => {
                        this.allData = successResponse.data
                        this.showAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '查询课程信息失败'});
                    })
            },
            selectAll() {
                this.$axios
                    .get('/course/selectAll')
                    .then(successResponse => {
                        this.allData = successResponse.data
                        this.showAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '获取课程信息失败'});
                    })
            },
            insertOrUpdate() {
                if (this.addMode === 0) this.update();
                else this.insert();
            },
            insert() {
                this.dialogFormVisible = false;
                this.$axios
                    .post('/course/insert', {
                            courseId: this.selectTable.courseId,
                            name: this.selectTable.courseName,
                            credit: this.selectTable.courseCredit,
                            department: this.selectTable.courseDept
                        }
                    )
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success', message: '添加课程信息成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '添加课程信息失败'});
                        this.showAll();
                    })
            },
            update() {
                this.dialogFormVisible = false;
                this.$axios
                    .put('/course/update', {
                            courseId: this.selectTable.courseId,
                            name: this.selectTable.courseName,
                            credit: this.selectTable.courseCredit,
                            department: this.selectTable.courseDept
                        }
                    )
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success', message: '更新课程信息成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '更新课程信息失败'});
                        this.showAll();
                    })
            },
            deletenb(name) {
                this.$axios
                    .post('/course/delete', {courseId: name})
                    .then(successResponse => {
                        //console.log(successResponse);
                        this.$message({type: 'success', message: '删除成功'});
                        this.selectAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '删除失败'});
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
