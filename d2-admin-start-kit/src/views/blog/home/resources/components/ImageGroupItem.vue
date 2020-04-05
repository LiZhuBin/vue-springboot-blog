<template>

    <el-card :body-style="{ padding: '0px' }">

<!--        <el-image-->

<!--                :src="image.detail[0].url"-->
<!--                :fit="cover" ></el-image>-->
        <div style="padding: 9px;">
          <span>{{image.name}}</span>
            <span>{{image.text}}</span>
            <i class="el-icon-view">{{image.view}}</i>&nbsp;
        </div>

    </el-card>
</template>

<script>
    export default {
        name: "ImageGroupItem",
        props:{
            image:{
                request: String,

            },

        },
        methods:{

        }

    }
</script>

<style scoped>

</style>
