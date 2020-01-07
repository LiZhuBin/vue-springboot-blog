<template >
  <div style="background-image: url('https://source.unsplash.com/user/erondu/1600x900');">

    <el-container >
      <el-header>
        <Head></Head>
      </el-header>
      <el-container>
        <el-aside width="300px">
          <Slide></Slide>
        </el-aside>
        <el-container>
          <el-main>Main</el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>

</template>



<script>
  import Slide from "@/views/Slide.vue"
  import Head from "@/views/Head.vue"

// @ is an alias to /src


export default {
  name: 'home',
  components: {
    Slide,
    Head
  },
  data(){
  return{
    note: {

      backgroundPosition: "center center",
      backgroundRepeat: "no-repeat",
      backgroundSize: "cover",
    },

  }
  }
}
</script>
<style>
  .el-container{
    margin-left: 30px;
    margin-right: 30px;
  }
</style>
