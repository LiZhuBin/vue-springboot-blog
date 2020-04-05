<template>
    <el-card :body-style="{ padding: '8px 18px' }">

        <div slot="header" class="me-tag-header">
            <span>{{cardName}}</span>

        </div>

        <ul class="me-tag-list">
            <li class="me-tag-item" v-for="t in classify" :key="t">
                <!--type="primary"-->
                <el-button @click="go(t)" size="mini" type="primary" round plain>{{t}}</el-button>
            </li>
        </ul>
    </el-card>

</template>

<script>
    export default {
        name: 'CardClassify',
        props: {
            classify: Array
        },
        data() {
            return {
                cardName:"分类"
            }
        },
        mounted() {

        },
        methods: {


            go(name) {

                this.$router.push({path: `/blog/home/classify/${name}`})


            }}
    }
</script>

<style scoped>

    .me-tag-header {
        font-weight: 600;
    }

    .me-tag-more {
        font-size: 14px;
        color: #78b6f7;
    }

    .me-tag-list {
        list-style-type: none;
    }

    .me-tag-item {
        display: inline-block;
        padding: 4px;
        font-size: 14px;
        color: #5FB878;
    }

    .me-tag-item a:hover {
        text-decoration: underline;
    }
</style>
