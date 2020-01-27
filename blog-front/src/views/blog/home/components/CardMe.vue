<template>
  <el-card>
    <el-image id="pic"
            style="width: 100px; height: 100px"
            v-bind:src="account.accountHead"
            >
    </el-image>
    <h2 class="me-author-name">{{account.accountName}}</h2>
    <h3 >{{account.accountSign}}</h3>
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
    props:{
      "account": {
        "id": 1,
        "accountName": "Wendy Wilkinson",
        "accountHead": "https://source.unsplash.com/user/erondu/100x100",
        "accountSign": "我的标签我做主",
        "communicationId": 1,
        "accountCompany": "A Company",
        "accountSite": "Gonnosnò"
      },
    },
    data() {
      return {


      }
    },
    methods: {

    }
  }
</script>

<style scoped>
  .me-author-name {
    text-align: center;
    font-size: 30px;
    border-bottom: 1px solid #5FB878;
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
