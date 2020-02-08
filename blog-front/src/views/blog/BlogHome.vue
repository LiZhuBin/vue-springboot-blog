<template >
  <div >

      <el-container style="height: 100%; border: 1px solid #eee">



          <el-aside width="280px" >
          <BlogSlide></BlogSlide>
        </el-aside>
        <el-container>



          <el-main style="height: 100%" >

           <router-view>

           </router-view>

          </el-main>
<!--              <el-footer>Heacxcder</el-footer>-->

            <el-aside width="280px">
                <BlogRightSlide></BlogRightSlide>
            </el-aside>
        </el-container>

      </el-container>



  </div>

</template>



<script>
  import BlogSlide from "@/views/blog/BlogSlide"
  import BlogRightSlide from "./BlogRightSlide";


// @ is an alias to /src


export default {
  name: 'home',
  components: {

      BlogSlide,
      BlogRightSlide

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
  },

}
</script>
<style>
  /*.el-container{*/
  /*  margin-left: 30px;*/
  /*  margin-right: 30px;*/
  /*}*/
</style>
