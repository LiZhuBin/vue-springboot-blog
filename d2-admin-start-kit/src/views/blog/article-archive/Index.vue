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
                <div class="me-month-title"></div>

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
      mounted() {
          this.init();
      },
      data() {

            return {
                headName:"时间 ",
                "articleDate":[],
                archives:[],
                "articles": [
                ]
            }
        },

        methods:{

            init() {

              this.$api.archive.archives(this.$store.state.accountData.id)
                .then((response)=>{
                  this.archives = response.data.data
                })
            },

          changeArchive(year,month){
            this.$api.archive.archivesDetail(year,month,this.$qs.stringify({"accountId": this.$store.state.accountData.id}))

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
