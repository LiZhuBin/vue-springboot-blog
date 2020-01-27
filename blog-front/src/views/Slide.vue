<template>
    <el-menu :default-openeds="['1', '3']" :router=true >
        <el-menu-item index="/blog/articleslist"  >
            <i class="el-icon-s-order"></i>
            <span slot="title">博客</span>
        </el-menu-item>

        <el-menu-item index="/blog-manage">
            <i class="el-icon-edit"></i>
            <span slot="title">博客管理</span>
        </el-menu-item>
        <el-menu-item index="3">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "Slide"
    }
</script>

<style scoped>

</style>