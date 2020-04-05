<template>
    <div>


        <el-page-header @back="goBack" :content="headerName" >

        </el-page-header>

        <el-divider></el-divider>

    </div>
</template>

<script>
    export default {
        props:{
            headerName:{
                type:String,
                default:"详情页"
            },
            lastPath:{
                type:String,
                default: ""
            }
        },
        name: "PageHeader",
        methods:{
            goBack() {
                if(this.lastPath){
                    this.$router.push(lastPath);
                }else{
                    this.$router.go(-1);
                }

            },
        }
    }
</script>

<style scoped>

</style>
