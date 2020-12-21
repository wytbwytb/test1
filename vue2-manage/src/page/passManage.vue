<template>
    <div  class="libraryManage_page fillcontain" >

        <el-row style="height: 100%;">
            <el-col :span="4"  style="min-height: 100%; background-color: #324057;">
                <el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
                    <el-menu-item index="libraryManage"><i class="el-icon-menu"></i>个人管理</el-menu-item>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-document"></i>数据管理</template>
                        <el-menu-item index="passWord">密码修改</el-menu-item>

                        <!--el-menu-item index="libAdminList">管理员列表</--el-menu-item-->
                    </el-submenu>
                    <!--el-submenu index="3">
                        <template slot="title"><i class="el-icon-edit"></i>修改</template>
                        <el-menu-item index="libAddBook">添加图书</el-menu-item>
                        <el-menu-item index="addShop">修改密码</el-menu-item>
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
        data(){
            bannerimg=require('../assets/img/图书馆.jpg')
        },
        /*data() {
            return {
                backgroundDiv: {
                    backgroundImage: 'url('+require('../assets/img/图书馆.jpg')+')',
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: '100% 100%'
                }
            }
        },*/
        computed: {
            defaultActive: function(){
                //backgroundDiv = {};
                /*if(this.$router.path.contain("libraryManage")){
                    backgroundDiv =  {
                        backgroundImage: 'url('+require('../assets/img/图书馆.jpg')+')',
                            backgroundRepeat: 'no-repeat',
                            backgroundSize: '100% 100%'
                    }
                }*/
                console.debug(this.$route.path);
                return this.$route.path.replace('/', '');
            }
        },
        created(){

        },
        beforeCreate(){
            // console.log("注册组件创建");
            document.querySelector("item").classList.add("libraryManage_page");
        },
        beforeDestroy(){
            // console.log("注册组件销毁");
            document.querySelector("body").classList.remove("libraryManage_page");
        },
        //DOM挂载完毕
        mounted() {

        }
    }
</script>


<style lang="less" scoped>
    @import '../style/mixin';


    .libraryManage_page{
        /*background-image: url("../assets/img/图书馆.jpg");
        width: 100%;
        height: 100%;
        position: fixed;
        background-size: 100% 100%;*/
    }

</style>
