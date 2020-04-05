<template>
    <div class="me-container-main">
        <el-container ref="homePage" style=" border: 1px solid #eee">

            <el-main style=" background-color: rgba(200,200,200,0.3)">

                <router-view ></router-view>

            </el-main>
        </el-container>
    </div>
</template>

<script>


    export default {
        name: "Index",
        components: {

        },
        data(){
            return {

                clientHeight:'',
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

<style scoped>
    .me-container-main{

    }
</style>
