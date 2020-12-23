<template>
    <div class="login_page fillcontain">
        <transition name="form-fade" mode="in-out">
            <section class="form_contianer" v-show="showLogin">
                <div class="manage_tip">
                    <p class="tip">密码修改</p>
                </div>


                <el-form :model="passData" :rules="rules" ref="loginForm">
                    <el-form-item label="旧密码" prop="oldpass">
                        <el-input v-model="passData.oldpass"><span>dsfsf</span></el-input>
                    </el-form-item>
                    <el-form-item label="新密码" prop="newpass">
                        <el-input type="password" v-model="passData.newpass"><span>dsfsf</span></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="newpass1">
                        <el-input type="password" v-model="passData.newpass1"><span>dsfsf</span></el-input>
                    </el-form-item>

                    <el-form-item class="button_submit">
                        <el-button type="primary" @click="submitForm('passData')" class="submit_btn">确认修改</el-button>
                    </el-form-item>
                </el-form>
                <p class="tip">温馨提示：</p>
                <p class="tip">请记住您改的密码哟</p>
            </section>
        </transition>
    </div>
</template>

<script>
    import libHeadTop from "../components/libHeadTop";
    import {cityGuess, addShop, searchplace, foodCategory} from '@/api/getData'
    import {baseUrl, baseImgPath} from '@/config/env'
    import {mapActions} from "vuex";

    export default {
        data() {
            return {
                passData: {
                    oldpass: '',
                    newpass: '',
                    newpass1: '',
                },
                rules: {
                    oldpass: [
                        {required: true, message: '请输入原密码', trigger: 'blur'},
                    ],
                    newpass: [
                        {required: true, message: '请输入新密码', trigger: 'blur'}
                    ],
                    newpass1: [
                        {required: true, message: '请再次输入新密码', trigger: 'blur'}
                    ],
                },
                showLogin: true,
            }
        },
        components: {
            libHeadTop,
        },
        mounted() {
            this.initData();
        },
        methods: {
            ...mapActions(['getAdminData']),
            async submitForm(formName) {
                this.$router.push("/");
                /*this.$refs[formName].validate(async (valid) => {
                    if (valid) {
                        const res = await login({
                            identify: this.loginForm.identify,
                            user_name: this.loginForm.username,
                            password: this.loginForm.password
                        })
                        if (res.status == 1) {
                            this.$message({
                                type: 'success',
                                message: '登录成功'
                            });
                            if (this.loginForm.identify == "libAdmin") {
                                this.$router.push('libraryManage');
                            } else if (this.loginForm.identify == "deptAdmin") {
                                this.$router.push("deptManage");
                            } else if (this.loginForm.identify == "otherAdmin") {
                                this.$router.push("otherManage");
                            } else if (this.loginForm.identify == "teacher") {
                                this.$router.push("deptManage");
                            } else if (this.loginForm.identify == "student") {
                                this.$router.push("studentView");
                            } else if (this.loginForm.identify == "superAdmin") {
                                this.$router.push("superMan");
                            }

                        } else {
                            this.$message({
                                type: 'error',
                                message: res.message
                            });
                        }
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: '请输入正确的用户名密码',
                            offset: 100
                        });
                        return false;
                    }
                });
            },*/
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../style/mixin';

    .login_page {

        background-image: url("../assets/img/沙河主楼日落.jpg");
        width: 100%;
        height: 100%;

        background-size: 100% 100%;
        //background-color: #324057;
    }

    .manage_tip {
        position: absolute;
        width: 100%;
        top: -100px;
        left: 0;

        p {
            font-size: 34px;
            color: #2c4aff;
        }
    }

    .form_contianer {
        .wh(320px, 300px);
        .ctp(320px, 210px);
        padding: 25px;
        border-radius: 5px;
        text-align: center;
        background-color: #fff;

        .submit_btn {
            width: 100%;
            font-size: 16px;
        }
    }

    .tip {
        font-size: 12px;
        color: red;
    }

    .form-fade-enter-active, .form-fade-leave-active {
        transition: all 1s;
    }

    .form-fade-enter, .form-fade-leave-active {
        transform: translate3d(0, -50px, 0);
        opacity: 0;
    }
</style>
