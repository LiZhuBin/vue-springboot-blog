<template>
  <el-card  >
    <div  class="me-author-image">
      <el-image id="pic"
                v-bind:src="account.accountHead"
      >
      </el-image>
    </div>

    <h2 class="me-author-name">{{account.accountName}}</h2>
    <h3 class="me-author-sign">{{account.accountSign}}</h3>
    <div style="text-align: center">
      <span>文章数{{accountSumary.articleNum}}</span>
      <el-divider  direction="vertical" ></el-divider>
      <span>阅读数{{accountSumary.readNum}}</span>
    </div>
    <div class="me-author-description">
      <span><i class="el-icon-location-outline"></i> &nbsp;{{account.accountSite}}</span>
      <span><i class="me-icon-job"></i> &nbsp;{{account.accountCompany}}</span>
    </div>
    <div class="me-author-tool">


      <i class="el-icon-message" ></i>
      <i class="el-icon-phone"></i>
    </div>

  </el-card>

</template>

<script>

  export default {
    name: 'CardMe',
    data() {
      return {


      }
    },
    methods: {

    }
  }
</script>

<style scoped>
  .me-author-image{
    text-align: center;
    width: 100px;
    height: 100px
  }
  .me-author-name {
    text-align: center;
    font-size: 30px;
    border-bottom: 1px solid #5FB878;
  }
  .me-author-sign{
    text-align: center;
  }
  .me-author-description {
    padding: 8px 0;
  }

  .me-icon-job {
    padding-left: 16px;
  }

  .me-author-tool {
    text-align: center;
    padding-top: 10px;
  }

  .me-author-tool i {
    cursor: pointer;
    padding: 4px 10px;
    font-size: 30px;
  }
</style>
