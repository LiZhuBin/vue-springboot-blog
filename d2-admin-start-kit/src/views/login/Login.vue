<template>
    <div id="login" v-title data-title="登录 - For Fun">
        <!--<video preload="auto" class="me-video-player" autoplay="autoplay" loop="loop">
              <source src="../../static/vedio/sea.mp4" type="video/mp4">
          </video>-->

        <div class="me-login-box me-login-box-radius">
            <h1> 登录</h1>

            <el-form ref="userForm" :model="userForm" :rules="rules">
                <el-form-item prop="account">
                    <el-input placeholder="用户名" v-model="userForm.account"></el-input>
                </el-form-item>

                <el-form-item prop="password">
                    <el-input placeholder="密码" type="password" v-model="userForm.password"></el-input>
                </el-form-item>

                <el-form-item size="small" class="me-login-button">

                    <el-button type="primary" @click.native.prevent="login()">登录</el-button>
                    <div>
                        <el-button  @click="pass()">游客登录</el-button>
                    </div>
                </el-form-item>

                <div class="me-go-register-button">
                    <el-button  @click="go()">注册</el-button>
                </div>
            </el-form>



        </div>
    </div>
</template>

<script>

    import util from "../../libs/util";

    export default {
        name: 'Login',
        data() {
            return {
                userForm: {
                    account: 'Wendy Wilkinson',
                    password: 'NOL53HNU8LZ'
                },
                rules: {
                    account: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {max: 15, message: '不能大于10个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {max: 15, message: '不能大于10个字符', trigger: 'blur'}
                    ]
                }
            }
        },

        methods: {
            login() {
                this.$api.account.checkAccount({accountName:this.userForm.account,accountPassword:this.userForm.password})
                    .then((response) => {

                        if (response.data.data.id) {
                            this.$store.dispatch("userLogin", true);
                            //Vuex在用户刷新的时候userLogin会回到默认值false，所以我们需要用到HTML5储存
                            //我们设置一个名为Flag，值为isLogin的字段，作用是如果Flag有值且为isLogin的时候，证明用户已经登录了。
                            localStorage.setItem("Flag", "isLogin");
                            this.$store.state.accountData = response.data.data;
                            this.$router.push('/blog');

                        } else {
                            alert(response.data.message);
                        }
                    });
            },
            pass(){
                this.$router.push('/blog');
            },
            go(){
                this.$router.push('/register')
            }

        }
    }
</script>

<style scoped>
    #login {
        min-width: 100%;
        min-height: 100%;
    }

    .me-video-player {
        background-color: transparent;
        width: 100%;
        height: 100%;
        object-fit: fill;
        display: block;
        position: absolute;
        left: 0;
        z-index: 0;
        top: 0;
    }

    .me-login-box {
        position: absolute;
        width: 300px;
        height: 260px;
        background-color: white;
        margin-top: 150px;
        margin-left: -180px;
        left: 50%;
        padding: 30px;
    }

    .me-login-box-radius {
        border-radius: 10px;
        box-shadow: 0px 0px 1px 1px rgba(161, 159, 159, 0.1);
    }

    .me-login-box h1 {
        text-align: center;
        font-size: 24px;
        margin-bottom: 20px;
        vertical-align: middle;
    }

    .me-login-design {
        text-align: center;
        font-family: 'Open Sans', sans-serif;
        font-size: 18px;
    }

    .me-login-design-color {
        color: #5FB878 !important;
    }

    .me-login-button {
        text-align: center;
    }

    .me-login-button button {
        width: 100%;
    }
    .me-go-register-button{
        text-align: right;
    }
</style>
