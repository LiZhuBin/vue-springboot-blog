<template>
    <div>

        <page-header :header-name="this.$route.params.classify"></page-header>

        <el-row :gutter="20" v-for="group in imgGroups" :key="group">
            <el-col :span="6">
                <el-badge  class="item" type="primary">
                    <div  @click="go(group.name)">
                    <ImageGroupItem  :image="group"></ImageGroupItem>
                    </div>
                </el-badge>
            </el-col>

        </el-row>
    </div>
</template>

<script>
    import PageHeader from "../../../../components/detail/PageHeader";
    import ImageGroupItem from "./components/ImageGroupItem";
    export default {
        name: "Index",
        data(){
            return{
                imgGroups:[]
            }
        },
      watch: {
        '$route': function (to, from) {
          this.init()
        }
      },
        props:{

        },
        mounted() {
            this.init();
        },
        components:{
            ImageGroupItem,
            PageHeader
        },
        methods:{
            init(){
                this.$api.resource.byClassify(this.$route.params.way,this.$route.params.classify,{'accountId':this.$store.state.accountData.id})
                .then((response)=>{

                    this.imgGroups= response.data.data;
                })
                .catch((error)=>{
                    alert(error)
                })

            },
            itemImage(group){
                return group.description
            },
            go(description){
                this.$router.push(this.$route.params.classify+'/'+description);
            }
        }
    }

</script>

<style scoped>

</style>
