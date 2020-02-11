<template>
    <div>
        <page-header :header-name="this.headName"></page-header>
        <el-row :gutter="20" v-for="group in imgGroups" :key="group">
            <el-col :span="6">
                <ImageGroupItem  :image="group"></ImageGroupItem>
            </el-col>

        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Content"
    }
</script>

<style scoped>

</style>