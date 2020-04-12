<template>
  <div id="messageboard">
    <el-form ref="form" label-width="100px">
      <el-form-item label="标题">
        <el-input v-model="title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="content" placeholder="请输入内容"></el-input>
      </el-form-item>
      <el-form-item label="私密发送">
        <el-switch v-model="power"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button @click="add()">添加</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
      <el-table border :data="mydata">
        <el-table-column label="编号" inline-template :context="_self">
          <span>{{$index+1}}</span>
        </el-table-column>
        <el-table-column prop="title" label="标题">
        </el-table-column>
        <el-table-column prop="content" label="内容">
        </el-table-column>
        <el-table-column label="操作" inline-template :context="_self">
          <span><el-button size="small" @click="showDialog()">删除</el-button></span>
        </el-table-column>
      </el-table>
      <div style="text-align:right" v-show="mydata.length>0">
        <el-button size="small" @click="showDelallDialog()">全部删除</el-button>
      </div>
    </el-form>

  </div>

</template>

<script>
    export default {
        name: "Index",
      data(){
          return{
            title: '',
            content: '',
            mydata: [],
            dialogVisible: false,
            nowIndex: -100,
            power:1
          }
      },
      methods: {
        add() {
          if (this.title == '' || this.content == '') {
            this.$message.error('请填写完整');
          } else {
            this.mydata.push({
              title: this.title,
              content: this.content,
            });
            this.title = '';
            this.content = '';
          }
        },
        showDialog() {
          this.dialogVisible = true;
        },
        showDelallDialog() {
          this.dialogVisible = true;
          this.nowIndex = -2;
        },
        del(n) {
          if (n == -2) {
            this.mydata = [];
          } else {
            this.mydata.splice(n, 1);
          }
          this.nowIndex = -100;
          this.dialogVisible = false;
        },
        handleReset() {
          this.title = '';
          this.content = '';
        }
      },


    }
</script>

<style scoped>

</style>
