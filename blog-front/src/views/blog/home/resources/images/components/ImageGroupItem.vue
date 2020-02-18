<template>
    <el-card :body-style="{ padding: '0px' }" @click="go()">
        <el-image

                :src="image.detail[0].url"
                :fit="cover" ></el-image>
        <div style="padding: 9px;">
            <span>{{image.description}}</span>
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
            go(){
                this.$router.push('/aa')
            }
        }

    }
</script>

<style scoped>

</style>