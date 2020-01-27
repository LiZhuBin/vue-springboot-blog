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
                <el-button @click="handleClick(scope.$index+1)" type="text" size="small"> 查看</el-button>
                <el-button type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>
    </el-table></div>
</template>

<script>
    export default {
        data() {

            return {
                inputVisible: false,
                inputValue: '',
                tableHead:[{
                    label:"Date",
                    prop:"article.article_create_time"
                },{
                    label: "Title",
                    prop: "article.article_title"
                },{
                    label:"SeeCount",
                    prop:"article.article_read_count"
                },{
                    label: "CommentCount",
                    prop: "commentCount"
                }],

                tableData: [ { "account": {
                "account_head": "https://images.unsplash.com/photo-1578539046812-74308e093283?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=400&ixlib=rb-1.2.1&q=80&w=400",
                    "account_name": "彬"
            },
            "article": {
                "id": 11,
                    "account_id": 1,
                    "article_title": "faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis",
                    "article_create_time": "2019-05-25 00:21:15",
                    "article_detail_type": 1,
                    "article_detail": "Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies",
                    "article_picture": "https://source.unsplash.com/random/900x300",
                    "article_read_count": 9
            },
            "labels": [
                {
                    "id": 9,
                    "label_name": "springmvc"
                }
            ]}],
                search: ''
            }
        },
        name: "BlogManageHome",
        mounted() {
          this.init();
        },
        methods: {

            handleClick(row) {
                alert(row);
            },
            init(){
                this.$api.article.recentArticles(this.$store.state.accountData.id)
                    .then((response)=>{
                        this.tableData = response.data.data;

                    })
            }
        },
    }
</script>

<style scoped>

</style>