<template>
    <div class="libraryManage_page fillcontain">
        <el-row style="height: 100%;">
            <el-col :span="4"  style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
                    <el-menu-item index="otherManage"><i class="el-icon-menu"></i>杂项管理</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-document"></i>数据管理</template>
                        <el-menu-item index="otherAssociation">社团列表</el-menu-item>
                        <el-menu-item index="otherDormBuilding">公寓楼列表</el-menu-item>
                        <el-menu-item index="otherDormitory">寝室列表</el-menu-item>
                        <el-menu-item index="otherStaff">职工列表</el-menu-item>
                    </el-submenu>
                    <!--
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-edit"></i>关系管理</template>
                        <el-menu-item index="otherStuDormClub">学生杂项管理</el-menu-item>
                        <el-menu-item index="otherStaffDormBuilding">职工杂项管理</el-menu-item>
                    </el-submenu>-->
                    <!--el-submenu index="4">
                        <template slot="title"><i class="el-icon-star-on"></i>图表</template>
                        <el-menu-item index="libVisitor">不会做报表分析</el-menu-item>
                        < <el-menu-item index="newMember">用户数据</el-menu-item>>
                    </el-submenu-->
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
