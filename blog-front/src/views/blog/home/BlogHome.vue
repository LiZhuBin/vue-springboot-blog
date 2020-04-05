<template >
  <div >

      <el-container >



          <el-aside width="250px" >
          <BlogSlide></BlogSlide>
        </el-aside>

        <el-container >



          <el-main  >

           <router-view>

           </router-view>

          </el-main>
<!--              <el-footer>Heacxcder</el-footer>-->

            <el-aside width="250px">
                <BlogRightSlide></BlogRightSlide>
            </el-aside>
        </el-container>

      </el-container>



  </div>

</template>



<script>
  import BlogSlide from "./BlogSlide"
  import BlogRightSlide from "./BlogRightSlide";


// @ is an alias to /src


export default {
  name: 'home',
  components: {

      BlogSlide,
      BlogRightSlide,
  },

  data(){
  return{
      clientHeight:'',
    note: {

      backgroundPosition: "center center",
      backgroundRepeat: "no-repeat",
      backgroundSize: "cover",
    },

  }
  },
    mounted(){
        // 获取浏览器可视区域高度
        this.clientHeight =   `${document.documentElement.clientHeight}`
        //document.body.clientWidth;
        //console.log(self.clientHeight);
        window.onresize = function temp() {
            this.clientHeight = `${document.documentElement.clientHeight}`;
        };
    },
    watch: {
        // 如果 `clientHeight` 发生改变，这个函数就会运行
        clientHeight: function () {
            this.changeFixed(this.clientHeight)
        }
    },
    methods:{

        changeFixed(clientHeight){ //动态修改样式
            // console.log(clientHeight);
            // console.log(this.$refs.homePage.$el.style.height);
            this.$refs.homePage.$el.style.height = clientHeight-20+'px';
        },
    },
}
</script>
<style>
  /*.el-container{*/
  /*  margin-left: 30px;*/
  /*  margin-right: 30px;*/
  /*}*/
</style>
