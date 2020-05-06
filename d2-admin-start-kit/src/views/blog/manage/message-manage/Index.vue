<template>
  <div id="messageboard">
    <el-form ref="form" label-width="100px">

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

                <el-table-column label="操作" >
                  <template slot-scope="scope">
                    <span><el-button size="small" @click="del(scope.$index)">删除</el-button></span>
                    <span><el-button size="small" @click="reply(scope.$index)">回复</el-button></span>
                    <span><el-button size="small" @click="detail(scope.$index)">查看</el-button></span>
                  </template>

                </el-table-column>

      </el-table>

    </el-form>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
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
      <el-button @click="dialogVisible = false">取 消</el-button>
    </el-form-item>
  </el-form>
</el-dialog>
  </div>

</template>

<script>


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



      showDelallDialog() {
        this.dialogVisible = true;
        this.nowIndex = -2;
      },
      add(){
        this.dialogVisible = false;
      },
      del(index) {
        this.$api.message.deleteMsg(this.mydata[index].id)
        .then(res=>{
          this.init();
        })
        .catch(error=>{
          alert(error)
        })
      },
      reply(index){
        this.dialogVisible = true;
      },
      detail(index){

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
        dialogFormVisible:false
      }
    },


  }
</script>

<style scoped>

</style>
