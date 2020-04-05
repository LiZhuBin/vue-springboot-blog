<template>
    <div>
        <PageHeader :header-name="headName"></PageHeader>
        <el-row :gutter="20">
            <el-col :span="6" v-for="c in classify" :key="c">
                <el-badge :value="c.num" class="item" type="primary">
                    <ClassifyItem  :image="c" ></ClassifyItem>
                </el-badge>
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
                classify:[],
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
                let param = {
                    "accountId": this.$store.state.accountData.id
                };
                this.$http({
                    method:'post',
                    url:'account-sumaries',
                    data:this.$qs.stringify(param)
                })

                    .then((response) => {
                        this.classify = response.data.data.labels;
                    })
                    .catch((error) => {
                    })
            }
        }
    }
</script>

<style scoped>

</style>