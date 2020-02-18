<template>
    <url-iframe :html="html"></url-iframe>
</template>

<script>
    import UrlIframe from "../../../components/iframe/UrlIframe";
    export default {

        name: "index",
        data() {
            return {
                html: 'http://127.0.0.1:1234/app/dd'
            }
        },
        components: {UrlIframe}

    }
</script>

<style scoped>

</style>