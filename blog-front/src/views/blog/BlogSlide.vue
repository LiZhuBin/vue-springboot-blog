<template>
    <div >
        <card-me ></card-me>
        <card-tag></card-tag>
        <card-archive></card-archive>
        <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
            <el-menu-item index="1">
                <i class="el-icon-menu"></i>
                <span slot="title">首页</span>
            </el-menu-item>
            <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3" >
                <i class="el-icon-document"></i>
                <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">导航四</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    import CardMe from "./home/components/CardMe";
    import CardArchive from "./home/components/CardArchive";
    import CardTag from "./home/components/CardTag";
    export default {
        name: "Slide",
        components:{
            CardMe,
            CardArchive,
            CardTag
        }
    }
</script>

<style scoped>

</style>