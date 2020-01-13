<template>
    <el-menu :default-openeds="['1', '3']">
        <el-menu-item index="1" route="/">
            <i class="el-icon-setting"></i>
            <span slot="title">博客</span>
        </el-menu-item>
        <el-menu-item index="2">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
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