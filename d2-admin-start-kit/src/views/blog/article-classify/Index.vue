<template>
    <div id="app">
        <el-container style="height: 600px; border: 1px solid #eee">

            <el-container>


                <el-main>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<script>

    export default {
        name: "Index",
        components:{

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
