<template>
    <div>
        <div slot="header" class="me-category-header">
            <span>{{cardHeader}}</span>
        </div>

        <ul class="me-category-list">

            <li v-for="a in articles.slice(0,5)" @click="view(a.id)"   :style="itemStyle" :key="a.id" class="me-category-item"><a>{{a.article_title}}</a>


                <i class="el-icon-view"></i>&nbsp;{{a.article_read_count}}
            </li>
        </ul>
    </div>
</template>

<script>

    export default {
        name: "HotArticles",
        props: {

            articles: {
                type: Array,
                required: true
            },

        },
        methods: {

            view(id) {

                this.$router.push({path: `/blog/home/article/${id}`})

            }
        }
    }
</script>

<style scoped>
    .me-category-header {
        font-weight: 600;
    }

    .me-category-list {
        list-style-type: none;
    }

    .me-category-item {
        padding: 4px;
        font-size: 14px;
        color: #5FB878;
    }

    .me-category-item a:hover {
        text-decoration: underline;
    }
</style>