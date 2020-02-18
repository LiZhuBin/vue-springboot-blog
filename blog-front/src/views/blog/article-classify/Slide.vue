<template>
    <el-menu :default-openeds="['1', '3']" :router=true >
        <el-menu-item index="classify"  >
            <i class="el-icon-s-order"></i>
            <span slot="title">分类</span>
        </el-menu-item>

        <el-menu-item index="labels">
            <i class="el-icon-edit"></i>
            <span slot="title">标签</span>
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