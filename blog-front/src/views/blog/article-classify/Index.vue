<template>
    <div id="app">
        <el-container style="height: 600px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <Slide></Slide>
            </el-aside>
            <el-container>


                <el-main>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<script>
    import Slide from "./Slide";
    export default {
        name: "Index",
        components:{
            Slide
        },
        data(){
            return{
                accountSumary
            }
        },
        mounted() {
            this.init();
        },
        methods:{

        }

    }
</script>

<style scoped>

</style>