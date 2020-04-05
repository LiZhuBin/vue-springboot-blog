<template>
  <div>
    <PageHeader :header-name="headName"></PageHeader>
    <el-row :gutter="20">
      <el-col :span="6" v-for="c in labels" :key="c">
        <el-tag @click="go(c)">{{c}}</el-tag>
      </el-col>

    </el-row>
  </div>
</template>

<script>
  import ClassifyItem from "../components/ClassifyItem";
  import PageHeader from "../../../../components/detail/PageHeader";
  export default {

    name: "Index",
    data(){
      return{
        labels:[],
        headName:"标签"
      }
    },
    components:{
      ClassifyItem,
      PageHeader
    },
    mounted() {
      this.init();
    },
    methods:{

      init(){
        this.$api.label.getLabels({'accountId':this.$store.state.accountData.id})
          .then((response)=>{

            this.labels= response.data.data;

          })
          .catch((error)=>{
            alert(error)
          })
      },
      go(name){
        this.$router.push({path: '/blog/article-classify/labels/'+name})
      }
    }
  }
</script>

<style scoped>

</style>
