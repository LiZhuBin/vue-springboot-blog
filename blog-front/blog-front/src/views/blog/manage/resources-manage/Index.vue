<template>
    <div>
        <el-tabs :tab-position="tabPosition" style="height: 200px;">
            <el-tab-pane label="相册">
                <ImagesView></ImagesView>
            </el-tab-pane>
            <el-tab-pane label="视频">
                <VideosView></VideosView>
            </el-tab-pane>
            <el-tab-pane label="文件">
                <FilesView></FilesView>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import FilesView from './files/Index'
    import ImagesView from './images/Index'
    import VideosView from './videos/Index'
    export default {
        name: "Index",
        data(){
            return{
                tabPosition:"left"
            }
        },
        components:{
            FilesView,
            ImagesView,
            VideosView
        }
    }
</script>

<style scoped>

</style>