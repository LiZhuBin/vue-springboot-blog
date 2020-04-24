<template>
    <div>
      <el-upload
        ref="uploadVideo"
        :action="uploadVideoUrl"
      accept='.mp4,.flv'
      :data="uploadVideo"
      :multiple="false"
      :limit="1"
      :show-file-list="false"
      :before-upload="beforeUploadVideo"
      :on-success="handleUploadVideoSuccess"
      :on-progress="uploadVideoProcess">
      <el-button size="small" type="primary" class="uploadButton">上传视频文件</el-button>
      </el-upload>

    </div>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>
