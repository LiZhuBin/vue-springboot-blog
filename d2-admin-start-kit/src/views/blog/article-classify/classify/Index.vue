<template>
    <div>
        <PageHeader :header-name="headName"></PageHeader>
        <el-row :gutter="20">
            <el-col :span="6" v-for="c in classifies" :key="c">
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
                classifies:[],
                headName:"分类"
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
              this.$api.article.classifies(this.$store.state.accountData.id)
                .then((response)=>{
                  this.classifies = response.data.data;
                })
            },
          go(name){
            this.$router.push({path: '/blog/article-classify/classify/'+name})
          }
        }
    }
</script>

<style scoped>

</style>
