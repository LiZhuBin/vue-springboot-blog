<template>
<div>
  <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="el-form-item__label">
    <el-form-item label="称号" >
      <el-input v-model="ruleForm.name" ></el-input>
    </el-form-item>
    <el-form-item label="住址">
      <el-input v-model="ruleForm.site"></el-input>
    </el-form-item>
    <el-form-item label="公司">
      <el-input v-model="ruleForm.company"></el-input>
    </el-form-item>

    <el-form-item>

    </el-form-item>
    <el-form-item label="签名">
      <el-input v-model="ruleForm.sign"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button @click="updateData()">确定</el-button>
      <el-button >修改密码</el-button>
    </el-form-item>

  </el-form>
</div>
</template>

<script>
    export default {
        name: "Index",
      data(){
          return{
            ruleForm: {
              name:"",
              site:"",
              company:"",
              sign:""
            }
          }
      },
      mounted() {
        let accountData;
        this.$api.account.getAccount(this.$store.state.accountData.id)
          .then((res)=>{
            accountData = res.data.data.account;
            this.ruleForm.name = accountData.accountName;

               this.ruleForm.site = accountData.accountSite;
               this.ruleForm.company = accountData.accountCompany;
               this.ruleForm.sign = accountData.accountSign;
          })
          .catch((error)=>{
            alert(error)
          })

      },
      methods:{
          updateData(){
            this.$api.account.update(this.$store.state.accountData.id,this.$qs.stringify({name:this.ruleForm.name,site:this.ruleForm.site,company:this.ruleForm.company,sign:this.ruleForm.sign}))
          .then((res)=>{
              this.$message({
                type:"success",
                message:"更新成功"
              })
          })
            .catch((error)=>{
              alert(error)
            })
        }
      }
    }
</script>

<style >
  .el-form-item__label{color:black}
</style>
