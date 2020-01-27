<template>
    <div>
        <el-page-header @back="goBack" content="详情页面">
        </el-page-header>
    </div>
</template>

<script>
    export default {
        name: "PageHeader",
        methods:{
            goBack() {
                this.$router.push('/blog/articleslist')
            },
        }
    }
</script>

<style scoped>

</style>