<template>

    <el-row class="me-header">

      <el-col :span="4" class="me-header-left">
        <router-link to="/" class="me-title">

        </router-link>
      </el-col>

      <el-col  :span="16">
        <el-menu :router=true menu-trigger="click" active-text-color="#5FB878" :default-active="activeIndex"
                 mode="horizontal">
          <el-menu-item index="/blog">首页</el-menu-item>
          <el-menu-item index="/blog/article-classify">文章分类</el-menu-item>
          <el-menu-item index="/blog/article-archive">文章归档</el-menu-item>


          <el-menu-item index="/messageBoard">留言板</el-menu-item>
          <el-menu-item index="/blog/info">个人信息</el-menu-item>
          <el-menu-item index="/blog/manage">博客管理</el-menu-item>
          <el-menu-item index="/developer/">开发者</el-menu-item>


        </el-menu>
      </el-col>


      <el-col :span="4">
        <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#5FB878">

          <template v-if="this.$store.state.userLogin">
            <el-menu-item index="/login" >
              <el-button type="text">登录</el-button>
            </el-menu-item>
          </template>

          <template v-else>

            <el-submenu index>

              <el-menu-item index @click="registerEvent"><i class="el-icon-back"></i>退出</el-menu-item>
            </el-submenu>
            <div>{{auth()}}</div>
          </template>
        </el-menu>
      </el-col>



    </el-row>

</template>

<script>
  export default {
    name: 'BaseHeader',
    props: {

    },
    data() {
      return {
        user:{
          login:false,
          auth:'游客',
        },

      }
    },
    mounted() {
      auth()
    },
    computed: {

    },
    methods: {
      registerEvent(){
        alert(this.$store.state.userLogin)
        this.$store.state.userLogin = false;
      },
      auth(){

        if(this.$store.state.isLogin){
          this.user.auth = this.$store.state.accountData.name;
        }
      }
    }
  }
</script>

<style>



  .me-title {
    margin-top: 10px;
    font-size: 24px;
  }

  .me-header-left {
    margin-top: 10px;
  }

  .me-title img {
    max-height: 2.4rem;
    max-width: 100%;
  }

  .me-header-picture {
    width: 36px;
    height: 36px;
    border: 1px solid #ddd;
    border-radius: 50%;
    vertical-align: middle;
    background-color: #5fb878;
  }
</style>
