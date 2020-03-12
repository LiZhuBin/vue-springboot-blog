<template>
    <url-iframe :html="html"></url-iframe>
</template>

<script>
    import UrlIframe from "../../../components/iframe/UrlIframe";
    export default {

        name: "Index",
        data() {
            return {
                html: 'http://localhost:15672'
            }
        },
        components: {UrlIframe}

    }
</script>

<style scoped>

</style>