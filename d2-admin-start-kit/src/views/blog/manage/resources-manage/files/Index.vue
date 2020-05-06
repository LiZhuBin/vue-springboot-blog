<template>
    <div>


      <vue-input-file
        v-slot="fileData"
      >
        文件-><br>
        {{ fileData.file && fileData.file.name }}<br>
        {{ fileData.blobUrl }}<br>
        {{ fileData.base64 }}
      </vue-input-file>
    </div>
</template>

<script>
  import vueInputFile from 'vue-input-file'
    export default {
        name: "Index",
      data () {
        return {
          src1: {
            file: '',
            blobUrl: '',
            base64: ''
          },
          src2: {
            file: '',
            blobUrl: '',
            base64: ''
          }
        }
      },
      components: {
        // 局部注册
        InputFile: vueInputFile
      },
      methods: {
        error1 (data) {
          console.error('error1', data)
        },
        update1 (data) {
          console.info('update1', data)
          this.src1 = data
        },
        update2 (data) {
          console.info('update2', data)
          this.src2 = data
        }
    }}
</script>

<style scoped>

</style>
