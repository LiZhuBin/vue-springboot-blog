<template>
<div>
        <PageHeader header-name="写博客"></PageHeader>
    <el-card>
        <el-form ref="form" :model="form" label-width="80px" prop="name"  >
            <el-form-item label="标题">
                <el-input v-model="form.name" ></el-input>
            </el-form-item>
            <el-form-item label="标签">
                <TagSelect></TagSelect>
            </el-form-item>
            <el-form-item label="内容">
                <el-tabs :tab-position="tabPosition" >
                    <el-tab-pane label="markdown">、
                        <MarkdownEditor></MarkdownEditor>
                    </el-tab-pane>
                    <el-tab-pane label="富文本">
                        <Tinymce></Tinymce>
                    </el-tab-pane>

                </el-tabs>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">立即创建</el-button>
                <el-button @click="resetForm('form')">重置</el-button>
            </el-form-item>
        </el-form>




    </el-card>
</div>
</template>

<script>
        import PageHeader from "../../../../../components/detail/PageHeader";
        import MarkdownEditor from "../../../../../components/MarkdownEditor/index.vue"
        import Tinymce from "../../../../../components/Tinymce/index"
        import TagSelect from "./TagSelect";
    export default {
        name: "WriteArticle",
        components:{
            PageHeader,
            MarkdownEditor,
            Tinymce,
            TagSelect
        },
        data(){
            return{
                tabPosition: 'top',
                textType:0 ,//0 -markdown;1 -富文体
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },

            }
        },
        methods:{
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert(this.Markdown.content);
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>