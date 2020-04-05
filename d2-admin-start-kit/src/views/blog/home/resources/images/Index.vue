<template>
    <div>

        <page-header :header-name="this.$route.params.description"></page-header>

        <div class="demo-image__lazy">
            <el-image v-for="group in imgGroups" :key="group.id" :src="group.url" lazy>
              {{group.url}}
            </el-image>
        </div>
    </div>
</template>

<script>
    import PageHeader from "../../../../../components/detail/PageHeader";

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
              this.$api.resource.byDescription("images",this.$route.params.classify,this.$route.params.description,{'accountId':this.$store.state.accountData.id})
                .then((response)=>{

                  this.imgGroups= response.data.data;

                })
                .catch((error)=>{
                  alert("Ff")
                })

            },


        }
    }

</script>

<style scoped>

</style>
