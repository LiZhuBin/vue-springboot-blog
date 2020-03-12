<template>
    <url-iframe :html="html"></url-iframe>
</template>

<script>
    import UrlIframe from "../../../components/iframe/UrlIframe";
    export default {

        name: "Index",
        data() {
            return {
                html: 'http://localhost:9877/druid/index.html'
            }
        },
        components: {UrlIframe}

    }
</script>

<style scoped>

</style>