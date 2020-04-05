<template>
    <div>

        <el-table
                :data="tableData"
        >
            <el-table-column label="序号">
                <template slot-scope="scope">
                    {{scope.$index+1}}
                </template>
            </el-table-column>
            <el-table-column v-for="head in tableHead" :key="head"
                             :label=head.label
                             :prop=head.prop>
            </el-table-column>


            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.$index)" type="text" size="small"> 查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        data() {

            return {
                inputVisible: false,
                inputValue: '',
                tableHead: [{
                    label: "Date",
                    prop: "article.articleCreateTime"
                }, {
                    label: "Title",
                    prop: "article.articleTitle"
                }, {
                    label: "SeeCount",
                    prop: "article.articleReadCount"
                }, {
                    label: "CommentCount",
                    prop: "commentCount"
                }],

                tableData: [ {
                    "article": {
                        "id": 3,
                        "articleCreateTime": "2019-01-13 22:18:14",
                        "articleReadCount": 14,
                        "articleTitle": "Integer vulputate, risus a ultricies adipiscing, enim mi tempor lorem,",
                        "articlePicture": "https://images.unsplash.com/photo-1579606629359-304b021e7cb9?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=300&ixlib=rb-1.2.1&q=80&w=900",
                        "accountId": 1,
                        "articleDetail": "faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor",
                        "articleDetailType": 1
                    },
                    "account": {
                        "accountCompany": "Vel Consulting",
                        "accountBirthDate": "2019-10-10 08:17:49",
                        "accountName": "Inga Fitzpatrick",
                        "accountSign": "我的标签我做主",
                        "accountHead": "https://source.unsplash.com/random/400x400",
                        "communicationId": 3,
                        "accountSite": "Piła",
                        "id": 3,
                        "accountPassword": "EIN70JCE0XV",
                        "accountCreateDate": "2020-10-27 18:42:53"
                    },
                    "labels": [
                        {
                            "label_name": "maven",
                            "id": 11
                        }
                    ]
                }],
                search: ''
            }
        },
        name: "BlogManageHome",
        created() {
            this.init();
        },
        methods: {

            handleClick(row) {
                // alert(this.tableData[row].article.id)
                this.$router.push('blog-detail/'+this.tableData[row].article.id);
            },
            init() {
                this.$api.article.recentArticles(this.$store.state.accountData.id)
                    .then((response) => {
                        this.tableData = response.data.data;

                    })
            },
            writeArticle() {
                this.$router.push("blog/manage/write-article");
            }
        },
    }
</script>

<style scoped>

</style>