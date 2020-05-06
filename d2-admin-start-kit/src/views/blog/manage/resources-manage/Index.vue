<template>
    <div >
      <el-card>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="类型" prop="name">
          <el-input v-model="ruleForm.inputClassify"></el-input>
        </el-form-item>
        <el-form-item label="集名">
          <el-input v-model="ruleForm.inputDescription" ></el-input>
        </el-form-item>
        <el-form-item label="名字">
          <el-input v-model="ruleForm.inputName" ></el-input>
        </el-form-item>
        <el-form-item label="私密" >
          <el-switch v-model="ruleForm.power"></el-switch>
        </el-form-item>

<el-form-item>
  <el-upload
    class="upload-demo"
    ref="upload"
    action="https://jsonplaceholder.typicode.com/posts/"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :file-list="fileList"
    :auto-upload="false">
    <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
    <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
  </el-upload>
</el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
      </el-card>
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
                tabPosition:"top",
              fileList: [ {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
              ruleForm:{
                inputDescription:"",
                inputClassify:"",
                inputName:"",
                power:0
              },
            }
        },
        components:{
            FilesView,
            ImagesView,
            VideosView
        },
      methods:{
        submitUpload() {
          this.$refs.upload.submit();
        },
        handleRemove(file, fileList) {
          this.$message({
            message: '删除'+file.name,
            type: 'success'
          });
        },
        handlePreview(file) {
          console.log(file);
        }
      }
    }
</script>

<style scoped>

</style>
