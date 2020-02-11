<template>
    <div>
        <page-header :header-name="this.headName"></page-header>
        <el-row :gutter="20" v-for="group in imgGroups" :key="group">
            <el-col :span="6">
                <el-badge :value="group.detail.length" class="item" type="primary">
               <ImageGroupItem  :image="group"></ImageGroupItem>
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
                headName:"相册集",
                imgGroups:[]
            }
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
                this.$http.post('/resources',this.$qs.stringify({'way':'images','accountId':this.$store.state.accountData.id}))
                .then((response)=>{
                    this.imgGroups= response.data.data;
                }).catch((error)=>{
                    alert(error);
                })
            },
            itemImage(group){
                return group.description
            }
        }
    }
</script>

<style scoped>

</style>