<template>
    <div id="app">
        <el-container style="height: 600px; border: 1px solid #eee">

            <el-container>


                <el-main>
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<script>

    export default {
        name: "Home",
        components:{

        }

    }
</script>

<style scoped>

</style>
