<template>
    <div class="libraryManage_page fillcontain">

        <el-row style="height: 100%;">
            <el-col :span="4" style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
                    <el-menu-item index="studentView"><i class="el-icon-menu"></i>学生主页</el-menu-item>
                    <el-menu-item index="studentRelation"><i class="el-icon-search"></i>相近关系查询</el-menu-item>
                    <el-menu-item index="studentSelectCourse"><i class="el-icon-star-on"></i>课程选择</el-menu-item>
                    <el-menu-item index="studentBorrowBook"><i class="el-icon-document"></i>图书借阅</el-menu-item>
                    <el-menu-item index="studentGrade"><i class="el-icon-circle-check"></i>成绩查询</el-menu-item>
                    <el-menu-item index="studentClub"><i class="el-icon-arrow-right"></i>社团查询</el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span="20" style="height: 100%;overflow: auto;">
                <keep-alive>
                    <router-view></router-view>
                </keep-alive>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        computed: {
            defaultActive: function () {
                return this.$route.path.replace('/', '');
            }
        },
    }
</script>


<style lang="less" scoped>
    @import '../style/mixin';

    .libraryManage_page {

    }
</style>
