<template>
    <div class="login_page fillcontain">
        <transition name="form-fade" mode="in-out">
            <section class="form_contianer" v-show="showLogin">
                <div class="manage_tip">
                    <p>校园服务通</p>
                </div>
                <el-form :model="loginForm" :rules="rules" ref="loginForm">

                    <el-form-item label="身份信息" prop="identify" class="is-justify-center">
                        <el-select v-model="loginForm.identify" placeholder="请选择身份信息" style="width:100%">
                            <el-option label="超级管理员" value="superAdmin"></el-option>
                            <el-option label="系管理员" value="deptAdmin"></el-option>
                            <el-option label="图书管理员" value="libAdmin"></el-option>
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
    },
    methods: {
        submitForm(formName) {
            if(this.loginForm.username!=""&&this.loginForm.password!=""&&this.loginForm.identify!="")
            {
            this.$axios
                .post('/user/loginCheck', {
                    userName: this.loginForm.username,
                    passwords: this.loginForm.password,
                    type: this.loginForm.identify
                })
                .then(successResponse => {
                    if(successResponse.data.length==0)
                    this.$message({type: 'error', message: '用户名或密码错误'})
                    else
                    {
                        if(successResponse.data[0].type=="超级管理员")
                        {
                            if(this.loginForm.identify=="superAdmin") this.$router.push('/superManage');
                            else if(this.loginForm.identify=="deptAdmin") this.$router.push('/deptManage');
                            else if(this.loginForm.identify=="libAdmin") this.$router.push('/libraryManage');
                            else if(this.loginForm.identify=="otherAdmin") this.$router.push('/otherManage');
                            else if(this.loginForm.identify=="teacher") this.$router.push('/deptManage');
                            else if(this.loginForm.identify=="student") this.$router.push('/studentView');
                        }
                        else if(successResponse.data[0].type=="系管理员"&&this.loginForm.identify=="deptAdmin")
                            this.$router.push('/deptManage');
                        else if(successResponse.data[0].type=="图书管理员"&&this.loginForm.identify=="libAdmin")
                            this.$router.push('/libraryManage');
                        else if(successResponse.data[0].type=="其他管理员"&&this.loginForm.identify=="otherAdmin")
                            this.$router.push('/otherManage');
                        else if(successResponse.data[0].type=="老师"&&this.loginForm.identify=="teacher")
                            this.$router.push('/deptManage');
                        else if(successResponse.data[0].type=="学生"&&this.loginForm.identify=="student")
                            this.$router.push('/studentView');
                        else
                            this.$message({type: 'error', message: '身份不一致'});
                    }
                })
                .catch(failResponse => {
                    this.$message({type: 'error', message: '服务器异常'});
                })
            }
        }
    },
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
