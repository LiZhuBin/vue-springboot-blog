<template>
    <div v-title :data-title="title">
        <el-container>

            <el-aside class="me-area">
                <ul class="me-month-list">
                    <li v-for="a in archives" :key="a.year + a.month" class="me-month-item">
                        <el-badge :value="a.count">
                            <el-button @click="changeArchive(a.year, a.month)" size="small">{{a.year +'年' + a.month + '月'}}
                            </el-button>
                        </el-badge>
                    </li>
                </ul>

            </el-aside>


            <el-main class="me-articles">
                <div class="me-month-title">{{currentArchive}}</div>

                <archive-list :articles="articles"></archive-list>

            </el-main>
        </el-container>
    </div>

</template>

<script>
    import ArchiveList from "../../../components/ArchiveList/ArchiveList";
    export default {

        name: "Index",

        components:{
          ArchiveList
        },


        watch: {
            '$route': function (to, from) {

                //this.$store.dispatch('updateActiveTemplateId', this.$route.params.id)

                this.init()
            }
        },
        data() {

            return {
                headName:"时间 ",
                "articleDate":[],
                archives:[],
                "articles": [
                    {
                        "id": 46,
                        "articleCreateTime": "2019-10-13 18:30:53",
                        "articleReadCount": 1,
                        "articleTitle": "at, nisi. Cum sociis natoque penatibus et magnis dis parturient",
                        "articlePicture": "https://source.unsplash.com/random/900x300",
                        "accountId": 1
                    }
                ]
            }
        },
        methods:{
            init() {

                    this.$api.account.getAccount(this.$store.state.accountData.id)
                        .then((response)=>{
                            this.archives = response.data.data.accountSumary.articleDate;
                        });

                let param = {
                    "accountId": this.$store.state.accountData.id
                };
                this.$http({
                    method:'post',
                    url:'archive/'+this.$route.params.year+'/'+this.$route.params.month,
                    data:this.$qs.stringify(param)
                })
                    .then((response) => {
                        this.articles = response.data.data;
                    })
                    .catch((error) => {
                    })
            },
            view(year, month) {
                this.$router.push({path: `/blog/home/archive/${year}/${month}`})
            }
        }
    }
</script>

<style scoped>

</style>