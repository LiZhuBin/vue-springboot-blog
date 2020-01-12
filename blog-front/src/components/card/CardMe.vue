<template>
  <el-card>
    <el-image id="pic"
            style="width: 100px; height: 100px"
            v-bind:src="url"
            >
    </el-image>
    <h2 class="me-author-name">{{name}}</h2>
    <h3 >{{sign}}</h3>
    <div class="me-author-description">
      <span><i class="el-icon-location-outline"></i> &nbsp;{{site}}</span>
      <span><i class="me-icon-job"></i> &nbsp;{{company}}</span>
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

        url:this.$store.state.accountData.accountHead,
        name:this.$store.state.accountData.accountName,
        sign:this.$store.state.accountData.accountSign,
        site:this.$store.state.accountData.accountSite,
        company:this.$store.state.accountData.accountCompany,

        qq: {title: 'QQ', message: '919431514'},
        github: {
          title: 'github',
          message: '<a target="_blank" href="https://github.com/shimh-develop">https://github.com/shimh-develop</a>'
        }
      }
    },
    methods: {
      showTool(tool) {
        this.$message({
          duration: 0,
          showClose: true,
          dangerouslyUseHTMLString: true,
          message: '<strong>' + tool.message + '</strong>'
        });
      }
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
