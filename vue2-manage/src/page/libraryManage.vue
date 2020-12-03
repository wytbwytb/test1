<template>
    <div class="libraryManage_page fillcontain">
        <el-row style="height: 100%;">
            <el-col :span="4"  style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
                    <el-menu-item index="libraryManage"><i class="el-icon-menu"></i>图书管理</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-document"></i>数据管理</template>
                        <el-menu-item index="libBook">图书列表</el-menu-item>
                        <el-menu-item index="libBookBorrow">学生借阅列表</el-menu-item>
                        <!--el-menu-item index="libAdminList">管理员列表</--el-menu-item-->
                    </el-submenu>
                    <!--el-submenu index="3">
                        <template slot="title"><i class="el-icon-edit"></i>修改</template>
                        <el-menu-item index="libAddBook">添加图书</el-menu-item>
                        <el-menu-item index="addShop">修改密码</el-menu-item>
                    </el-submenu-->
                    <el-submenu index="4">
                        <template slot="title"><i class="el-icon-star-on"></i>报表分析</template>
                        <el-menu-item index="libVisitor">用户借阅分布</el-menu-item>
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
