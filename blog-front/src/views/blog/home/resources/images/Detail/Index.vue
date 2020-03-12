<template>
    <div>

        <page-header :header-name="this.$route.params.classify"></page-header>
        <div class="demo-image__lazy">
            <el-image v-for="url in imgGroups" :key="url" :src="url" lazy></el-image>
        </div>
    </div>
</template>

<script>
    import PageHeader from "../../../../../../components/detail/PageHeader";

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
            PageHeader
        },
        methods:{
            init(){
                this.$http.post('/resources/images/'+this.$route.params.classify+'/'+this.$route.params.description,this.$qs.stringify({'accountId':this.$store.state.accountData.id}))
                    .then((response)=>{

                        this.imgGroups= response.data.data;
                        alert(this.imgGroups)
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