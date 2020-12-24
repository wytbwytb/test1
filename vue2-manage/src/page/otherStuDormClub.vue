<template>
    <div class="fillcontain">
        <!--div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过编号查询..."
                prefix-icon="el-icon-search"
                size="small"
                style="width: 400px;margin-right: 10px"
                v-model="keywords">
            </el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>

        </div-->

        <div class="table_container">

            <el-table
                :data="tableData"
                highlight-current-row
                style="width: 100%">
                <el-table-column
                    label="学号"
                    prop="stuId">
                </el-table-column>
                <el-table-column
                    label="寝室号"
                    prop="dormId">
                </el-table-column>
                <el-table-column
                    label="社团名称"
                    prop="clubName">
                </el-table-column>
                <el-table-column
                    label="社团职位"
                    prop="clubPos">
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
                <el-button class="el-icon-plus"  @click="handleEdit(-1)">学生杂项管理</el-button>
            </div>
            <el-dialog title="修改学生杂项信息" v-model="dialogFormVisible">
                <el-form :model="selectTable">
                    <el-form-item label="学号" label-width="100px">
                        <el-input v-model="selectTable.stuId" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="寝室号" label-width="100px">
                        <el-input v-model="selectTable.dormId"></el-input>
                    </el-form-item>
                    <el-form-item label="社团名称" label-width="100px">
                        <el-input v-model="selectTable.clubName"></el-input>
                    </el-form-item>
                    <el-form-item label="社团职位" label-width="100px">
                        <el-input v-model="selectTable.clubPos"></el-input>
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
