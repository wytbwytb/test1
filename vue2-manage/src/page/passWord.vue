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
                        <el-button type="primary" @click="submitForm()" class="submit_btn">确认修改</el-button>
                    </el-form-item>
                </el-form>
                <p class="tip">温馨提示：</p>
                <p class="tip">请记住您改的密码哟</p>
            </section>
        </transition>
    </div>
</template>

<script>
    import common from '@/components/common';

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
        methods: {
            async submitForm() {
            if(this.passData.newpass==this.passData.newpass1)
            {
                this.$axios
                    .post('/user/loginCheck', {
                        userName: common.userName,
                        passwords: this.passData.oldpass
                    })
                    .then(successResponse => {
            console.log(successResponse);
                        if(successResponse.data.length==0)
                        this.$message({type: 'error', message: '密码错误'})
                        else
                        {
                            this.$axios
                                .put('/user/update', {
                                    userName: common.userName,
                                    passwords: this.passData.newpass,
                                    type: successResponse.data[0].type,
                                    id: successResponse.data[0].id
                                })
                                .then(successResponse2 => {
                                    this.$message({type: 'success', message: '修改密码成功'});
                                    this.$router.push('/');
                                })
                                .catch(failResponse2 => {
                                    this.$message({type: 'error', message: '修改密码失败'});
                                })
                        }
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error', message: '修改密码失败'});
                    })
            }
            else
            {
                this.$message({type: 'error', message: '两次输入密码不一致'});
            }}
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
