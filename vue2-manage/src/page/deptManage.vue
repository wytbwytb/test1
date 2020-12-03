<template>
    <div class="libraryManage_page fillcontain">
        <el-row style="height: 100%;">
            <el-col :span="4"  style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
                    <el-menu-item index="deptManage"><i class="el-icon-menu"></i>系管理</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-document"></i>数据管理</template>
                        <el-menu-item index="deptList">院系列表</el-menu-item>
                        <el-menu-item index="deptClassList">班级列表</el-menu-item>
                        <el-menu-item index="deptStudentList">学生列表</el-menu-item>
                        <el-menu-item index="deptClassroomList">教室列表</el-menu-item>
                        <el-menu-item index="deptCourseList">课程列表</el-menu-item>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-edit"></i>关系管理</template>
                        <el-menu-item index="deptClassStudent">班级-学生管理</el-menu-item>
                        <el-menu-item index="deptClassStudent">学生-课程管理</el-menu-item>
                        <el-menu-item index="deptClassStudent">教师-课程管理</el-menu-item>
                    </el-submenu>
                    <el-submenu index="4">
                        <template slot="title"><i class="el-icon-star-on"></i>图表</template>
                        <el-menu-item index="libVisitor">报表分析</el-menu-item>
                        <!-- <el-menu-item index="newMember">用户数据</el-menu-item> -->
                    </el-submenu>
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
            defaultActive: function(){
                return this.$route.path.replace('/', '');
            }
        },
    }
</script>


<style lang="less" scoped>
    @import '../style/mixin';
    .libraryManage_page{

    }
</style>
