<template>

    <el-card :body-style="{ padding: '0px' }">

        <el-image

                :src="videos.detail[0].url"
                :fit="cover" ></el-image>
        <div style="padding: 9px;">
            <span>{{videos.description}}</span>
            <i class="el-icon-view">{{videos.view}}</i>&nbsp;
        </div>

    </el-card>
</template>

<script>
    export default {
        name: "ImageGroupItem",
        props:{
            videos:{
                request: String,

            },

        },
        methods:{

        }

    }
</script>

<style scoped>

</style>