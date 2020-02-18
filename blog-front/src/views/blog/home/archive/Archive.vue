<template>
    <div>
        <PageHeader :headerName="this.$route.params.year+'/'+this.$route.params.month"></PageHeader>
        <ArchiveList :articles="articles"></ArchiveList>
    </div>
</template>

<script>
    import PageHeader from "../../../../components/detail/PageHeader";
    import ArchiveList from "../../../../components/ArchiveList/ArchiveList";
    export default {
        name: "Archive",
        props: {},
        components:{
            ArchiveList,
            PageHeader
        },
        watch: {
            '$route': function (to, from) {

                //this.$store.dispatch('updateActiveTemplateId', this.$route.params.id)

                this.init()
            }
        },
        data() {
            return {
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
        }
    }

</script>

<style scoped>

</style>