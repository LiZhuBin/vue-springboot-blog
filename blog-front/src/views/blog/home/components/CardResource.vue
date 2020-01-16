<template>
    <el-card :body-style="{ padding: '8px 18px' }">
        <div slot="header" class="me-category-header">
            <span>{{cardHeader}}</span>
        </div>

    <div v-for="select in selects" :key="select" >
        <el-tag>{{select.name}}</el-tag>
    </div>
    </el-card>
</template>

<script>
    export default {
        name: "CardResource",
        data(){
            return{
                cardHeader:"资源",
                selects:[{id:'file', name:"文件"},{id:'rideo',name:"视频"},{id:'picture',name:'相册'}]
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
        display: inline-block;
        width: 40%;
        padding: 4px;
        font-size: 14px;
        color: #5FB878;
    }

    .me-category-item a:hover {
        text-decoration: underline;
    }
</style>