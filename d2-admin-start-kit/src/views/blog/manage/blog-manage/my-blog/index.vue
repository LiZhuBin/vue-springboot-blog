<template>

    <url-iframe :html="html"></url-iframe>
</template>

<script>
    import UrlIframe from "../../../../../components/iframe/UrlIframe";
    export default {
        name: "index",
        data() {
            return {
                html: 'http://localhost:8080/blog/articleslist'
            }
        },
        components:{
            UrlIframe
        }
    }
</script>

<style scoped>

</style>