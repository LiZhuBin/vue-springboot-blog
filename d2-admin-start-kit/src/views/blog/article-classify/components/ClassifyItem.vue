<template>
<div @click="go(image.name)" >
    <el-card :body-style="{ padding: '0px' }" >
        <el-image class="me-author-image"

                :src="image.path"
               ></el-image>
        <div style="padding: 9px;">
            <span>{{image.name}}</span>
            <i class="el-icon-view">{{image.view}}</i>&nbsp;
        </div>

    </el-card>
</div>
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
                this.$router.push({path: '/blog/article-classify/classify/'+name})
            }
        }
    }
</script>

<style scoped>

</style>
