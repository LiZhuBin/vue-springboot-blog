<template>

    <el-card :body-style="{ padding: '0px' }" @click="go(image.name)" >
        <el-image class="me-author-image"

                :src="image.path"
               ></el-image>
        <div style="padding: 9px;">
            <span>{{image.name}}</span>
            <i class="el-icon-view">{{image.view}}</i>&nbsp;
        </div>

    </el-card>
</template>

<script>
    export default {
        name: "ClassifyItem",
        props:{
            image:{
                request: String,

            },

        },
        methods:{
            go(name){
                alert("ff")
                this.$router.push({path: `/blog/home`})
            }
        }
    }
</script>

<style scoped>

</style>