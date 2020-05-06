<template>
  <div id="messageboard">
    <el-card>
    <el-form ref="form" label-width="100px">

      <el-form-item label="内容">
        <el-input v-model="content" placeholder="请输入内容"></el-input>
      </el-form-item>
      <el-form-item label="私密发送(不公开)">
        <el-switch v-model="power"></el-switch>
      </el-form-item>
      <el-form-item label="匿名">
        <el-switch v-model="anonymous"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button @click="add()">添加</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
      <div>公开的留言</div>
      <el-table border :data="mydata">
        <el-table-column
          type="index"
          width="50">
        </el-table-column>
        <el-table-column
          property="createTime"
          label="日期"
          width="120">
        </el-table-column>
        <el-table-column prop="fromName" label="留言人">
        </el-table-column>
        <el-table-column prop="messageContent" label="内容">
        </el-table-column>
<!--        <el-table-column label="操作" v-if="check()">-->
<!--          <span><el-button size="small" @click="showDialog()">删除</el-button></span>-->
<!--        </el-table-column>-->
      </el-table>
<!--      <div style="text-align:right" v-show="mydata.length>0" v-if="check()">-->
<!--        <el-button size="small" @click="showDelallDialog()">全部删除</el-button>-->
<!--      </div>-->
    </el-form>
    </el-card>
  </div>

</template>

<script>
    import util from "../../../libs/util";

    export default {
      mounted() {
        this.init();
      },
      methods: {
        init(){
          this.$api.message.openLMsg({accountId:this.$store.state.accountData.id,power:true})
          .then((response)=>{
            this.mydata = response.data.data;

          })
          .catch((error)=>{
            alert(error)
          })
        },
        check(){
          return this.$store.state.accountData.name=!!util.cookies.get('uuid');
        },

        add() {
          var name = this.anonymous?"匿名":  util.cookies.get('uuid');

          var param = {'fromId':util.cookies.get('id'),'toId':this.$store.state.accountData.id,'messagePower':!this.power,'fromName':name,'messageContent':this.content}

          if ( this.content == '') {
            this.$message.error('请填写完整');
          } else {
            this.$api.message.insertMsg(param)
              .then((response)=>{
                alert(response)
              })
              .catch((error)=>{
              })
            if(!this.power){
              this.init();
            }else{
              this.$message("私密发送了！")
            }

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
      name: "Index",
      data(){
          return{
            title: '',
            content: '',
            mydata: [],
            anonymous:1,
            dialogVisible: false,
            nowIndex: -100,
            power:1,
            msg :[],
          }
      },


    }
</script>

<style scoped>

</style>
