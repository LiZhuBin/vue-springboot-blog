<template>
<div>
<div>

  <div>
    <label style="color:gray">请勿发表与本片无关的主题</label>
  </div>
  <textarea class="form-control" style="resize:none;" rows="5" placeholder="说点什么吧..." maxlength="200" v-model="input_comment"> </textarea>

  <el-button  class="pull-right btn btn-primary"   @click="insert()">发表</el-button>

</div>
  <el-divider></el-divider>
  <el-collapse accordion v-for="comment in comments" :key="comment">
    <el-collapse-item>
      <template slot="title">

        <div slot="header" >
          <div class="pull-right btn btn-primary">
              <el-avatar class="me-view-picture" :src="comment.avatarImgUrl"></el-avatar>


              <span>{{comment.username}}</span>




          </div>

        </div>
        <div class="my-comment-content">
          {{comment.commentContent}}
        </div>
      </template>

      <div class="edit">


        <el-button type="primary" icon="el-icon-edit" circle @click="open(comment.id)"></el-button>
      </div>

<el-divider></el-divider>
    <el-card class="box-card">
        <div v-for="reply in comment.Replys" :key="o" class="text item">
          <el-avatar :src="reply.replyImgUrl"></el-avatar>
          <div class="me-view-info">{{reply.replyName}}</div>
          <div>{{reply.replyContent}}</div>


        </div>
      </el-card>
    </el-collapse-item>
  </el-collapse>
<div >


</div>
</div>
</template>

<script>
  // import {publishComment} from '@/api/comment'

  import util from "../../../../libs/util";

  export default {
    name: "CommentItem",
    props: {

    },
    mounted() {
      this.init();
    },

    data() {
      return {
          comments:[],
        input_comment:"",
      }
    },
    methods: {
      init(){
        this.$api.article.articleComments(this.$route.params.id)
        .then((response)=>{
          this.comments = response.data.data;
        })
        .catch((error)=>{
        alert(error)
        })
      },

      insert(){
        this.$api.article.insertComment({'commentContent':this.input_comment,'fromId':util.cookies.get('id'),'toId':this.$store.state.accountData.id})
        .then((response)=>{
          this.init();
        })
        .catch((error)=>{
          alert(error)
        })
      },
      reply(value,id){
        this.$api.article.insertReply({'replyContent':value,'fromId':util.cookies.get('id'),'toId':id})
          .then((response)=>{
            alert(response.data)
            this.init();
          })
          .catch((error)=>{
            alert(error)
          })
      },
      open(id){
        this.$prompt('请输入评论', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',

        }).then(({ value }) => {
          this.$message({
            type: 'success',

          });
          this.reply(value,id);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
      }
    }
  }
</script>

<style>
  .my-comment-content{
    text-align: center;
  }
  .me-view-author {
    /*margin: 30px 0;*/
    margin-top: 30px;
    vertical-align: middle;
  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }
  .edit{
    float: right;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
  .me-view-info {
    display: inline-block;
    vertical-align: middle;
    margin-left: 8px;
  }
</style>
