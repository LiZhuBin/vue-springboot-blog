<template>
    <el-card :body-style="{ padding: '8px 18px' }">
        <el-collapse  >
            <el-collapse-item title="图片" name="1"  v-for="image in resource.images" :key="image.name" >
                <el-link @click="go('images',image.name)">
                    {{image.name}}
                </el-link>
<!--                <div>{{image.name}}</div>-->
            </el-collapse-item>
            <el-collapse-item title="视频" name="2" v-for="video in resource.video" :key="video.name" >
                <el-link @click="go('video',video.name)">
                    {{video.name}}
                </el-link>
            </el-collapse-item>
            <el-collapse-item title="文件" name="3" v-for="file in resource.files" :key="file.name" >
                <el-link @click="go('file',file.name)">
                    {{file.name}}
                </el-link>
            </el-collapse-item>

        </el-collapse>




        <div slot="header" class="me-category-header">
            <span>{{cardHeader}}</span>
        </div>


    </el-card>
</template>

<script>
    export default {
        name: "CardResource",
        props:{
            resource:{

            }
        },
        created() {

        },
        data(){
            return{
                cardHeader:"资源",
                selects:[{id:'files', name:"文件"},{id:'video',name:"视频"},{id:'images',name:'相册'}]
            }
        },
        methods:{
            go(way,classify){
                this.$router.push('/blog/home/resources/'+way+'/'+classify);
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
