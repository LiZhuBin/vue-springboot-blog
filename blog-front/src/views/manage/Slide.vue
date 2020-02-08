<template>
    <el-menu :default-openeds="['1', '3']" :router=true >
        <el-menu-item index="/manage/my-blog"  >
            <i class="el-icon-s-order"></i>
            <span slot="title">博客</span>
        </el-menu-item>

        <el-menu-item index="/manage/blog-manage">
            <i class="el-icon-edit"></i>
            <span slot="title">博客管理</span>
        </el-menu-item>
        <el-menu-item index="/manage/write-article">
            <i class="el-icon-edit"></i>
            <span slot="title">写博客</span>
        </el-menu-item>
        <el-menu-item index="/manage/info-manage">
            <i class="el-icon-setting"></i>
            <span slot="title">个人信息</span>
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