
const label = {

    getLabels(param){

        return this.$http({
            method:'post',
            url:'/labels',
            data:this.$qs.stringify(param)
        })
    },

};
export default label;