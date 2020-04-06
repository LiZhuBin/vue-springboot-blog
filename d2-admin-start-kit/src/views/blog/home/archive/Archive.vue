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

                ]
            }
        },
        methods:{
            init() {
                let param = {
                    "accountId": this.$store.state.accountData.id
                };
                this.$api.archive.archivesDetail(this.$route.params.year,this.$route.params.month,this.$qs.stringify(param))

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
