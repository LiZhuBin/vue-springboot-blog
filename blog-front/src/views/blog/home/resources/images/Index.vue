<template>
    <div>

        <page-header :header-name="this.$route.params.classify"></page-header>
        <el-row :gutter="20" v-for="group in imgGroups" :key="group">
            <el-col :span="6">
                <el-badge :value="group.detail.length" class="item" type="primary">
                    <div  @click="go(group.classify,group.description)">
                    <ImageGroupItem  :image="group"></ImageGroupItem>
                    </div>
                </el-badge>
            </el-col>

        </el-row>
    </div>
</template>

<script>
    import PageHeader from "../../../../../components/detail/PageHeader";
    import ImageGroupItem from "./components/ImageGroupItem";
    export default {
        name: "Index",
        data(){
            return{
                imgGroups:[]
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
                this.$http.post('/resources/images/'+this.$route.params.classify,this.$qs.stringify({'accountId':this.$store.state.accountData.id}))
                    .then((response)=>{

                        this.imgGroups= response.data.data;
                    }).catch((error)=>{
                    alert(error);
                })
            },
            itemImage(group){
                return group.description
            },
            go(classify,description){
                this.$router.push(classify+'/'+description);
            }
        }
    }

</script>

<style scoped>

</style>