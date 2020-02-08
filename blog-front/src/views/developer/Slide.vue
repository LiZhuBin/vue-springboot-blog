<template>
    <el-menu :default-openeds="['1', '3']" :router=true >
        <el-menu-item index="/developer/admin-mongo"  >
            <i class="el-icon-s-order"></i>
            <span slot="title">admin-mongo</span>
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