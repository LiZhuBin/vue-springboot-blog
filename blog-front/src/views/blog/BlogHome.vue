<template >
  <div >

    <el-container >



        <el-aside width="280px">
          <Slide></Slide>
        </el-aside>

        <el-container >

          <el-main>
           <router-view>

           </router-view>

          </el-main>

        </el-container>

      </el-container>



  </div>

</template>



<script>
  import Slide from "@/views/blog/BlogSlide"


// @ is an alias to /src


export default {
  name: 'home',
  components: {

    Slide,

  },
  mounted() {
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
  /*.el-container{*/
  /*  margin-left: 30px;*/
  /*  margin-right: 30px;*/
  /*}*/
</style>
