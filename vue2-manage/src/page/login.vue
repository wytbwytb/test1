<template>
    <div class="login_page fillcontain">
        <transition name="form-fade" mode="in-out">
            <section class="form_contianer" v-show="showLogin">
                <div class="manage_tip">
                    <p>数据库课设系统</p>
                </div>
                <el-form :model="loginForm" :rules="rules" ref="loginForm">

                    <el-form-item label="身份信息" prop="identify" class="is-justify-center">
                        <el-select v-model="loginForm.identify" placeholder="请选择身份信息" style="width:100%">
                            <el-option label="系管理员" value="deptAdmin"></el-option>
                            <el-option label="图书馆管理员" value="libAdmin"></el-option>
                            <el-option label="杂项管理员" value="otherAdmin"></el-option>
                            <el-option label="教师" value="teacher"></el-option>
                            <el-option label="学生" value="student"></el-option>
                        </el-select>
                    </el-form-item>
                    <!--el-form-item prop="identify">
                        <el-input v-model="loginForm.identify" placeholder="身份信息"><span>dsff</span></el-input>
                    </el-form-item-->
                    <el-form-item prop="username">
                        <el-input v-model="loginForm.username" placeholder="用户名"><span>dsfsf</span></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input type="password" placeholder="密码" v-model="loginForm.password"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('loginForm')" class="submit_btn">登陆</el-button>
                    </el-form-item>
                </el-form>
                <p class="tip">温馨提示：</p>
                <p class="tip">选择相应身份信息后使用统一认证账号登录</p>
            </section>
        </transition>
    </div>
</template>

<script>
    import {login, getAdminInfo} from '@/api/getData'
    import {mapActions, mapState} from 'vuex'

    export default {
        data() {
            return {
                loginForm: {
                    identify: '',
                    username: '',
                    password: '',
                },
                rules: {
                    identify: [
                        {required: true, message: '请输入身份信息', trigger: 'blur'},
                    ],
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ],
                },
                showLogin: false,
            }
        },
        mounted() {
            this.showLogin = true;
            if (!this.adminInfo.id) {
                this.getAdminData()
            }
        },

        computed: {
            ...mapState(['adminInfo']),
        },
        methods: {
            ...mapActions(['getAdminData']),
            async submitForm(formName) {
                this.$refs[formName].validate(async (valid) => {
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
                            }/*else {
                                this.$router.push('manage')
                            }*/
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
            },
        },
        watch: {
            adminInfo: function (newValue) {
                /*if (newValue.id) {
                    this.$message({
                        type: 'success',
                        message: '检测到您之前登录过，将自动登录'
                    });
                    //this.$router.push('manage')
                }*/
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../style/mixin';

    .login_page {

        background-image: url("../assets/img/fantasy.png");
        //background-color: #324057;
    }

    .manage_tip {
        position: absolute;
        width: 100%;
        top: -100px;
        left: 0;

        p {
            font-size: 34px;
            color: #fff;
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
