<template> <div>

    <iframe
            id="iframeContain"
            name="iframeContain"
            seamless
            scrolling="yes"
            :src="html"
    >
        您当前的浏览器不支持页面上的功能，请升级您当前的浏览器版本或使用谷歌浏览器访问当前页面
    </iframe>

</div></template>

<script>
    export default {
        name: "UrlIframe",
        props:{
          html:{
              default:"www.baidu.com"
          }
        },
        components:{


        },
        data(){
            return{
            }
        }
    }
</script>

<style scoped>

    /** iframe样式 */
    #iframeContain{
        width: 100%;
        height: 800px;
    }
</style>