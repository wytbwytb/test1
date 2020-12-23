<template xmlns:el-col="http://www.w3.org/1999/html">
    <div>
        <head-top></head-top>
        <div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过课程编号查询..."
                prefix-icon="el-icon-search"
                size="small"
                style="width: 400px;margin-right: 10px"
                v-model="keywords">
            </el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>

        </div>
        <!--head-top></head-top-->
        <el-row>
            <el-col class="is-justify-center" >
                <grade-pie :pieData="pieData"></grade-pie>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import gradePie from '@/components/gradePie'

    export default {
        data() {
            return {
                keywords:'',
                pieData: {},
                allData: []

            }
        },
        components: {
            headTop,
            gradePie,

        },
        mounted() {
            this.initData();
        },
        methods: {
            aaa() {
                var i,len,a18,a19,a20,a21,a22;
                len=this.allData.length
                a18=0;
                a19=0;
                a20=0;
                a21=0;
                a22=0;
                for(i=0;i<len;i++)
                {
                    if(this.allData[i].grade<60) a18+=1;
                    else if(this.allData[i].grade<70) a19+=1;
                    else if(this.allData[i].grade<80) a20+=1;
                    else if(this.allData[i].grade<90) a21+=1;
                    else a22+=1;
                }
                this.pieData = [
                    {value: a18, name: "<60"},
                    {value: a19, name: "60-69"},
                    {value: a20, name: "70-79"},
                    {value: a21, name: "80-89"},
                    {value: a22, name: ">=90"},
                ];
                //console.log(this.pieData);
            },
            searchClick(){
                this.$axios
                    .post('/studentcourse/selectByCourse',{course: this.keywords})
                    .then(successResponse => {
                        this.allData=successResponse.data
                        this.aaa();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '查询失败'});
                    })
                if(this.keywords=="") this.initData()
            },
            async initData() {
                this.$axios
                    .get('/studentcourse/selectAll')
                    .then(successResponse => {
                        this.allData=successResponse.data
                        this.aaa();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '获取信息失败'});
                    })
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

</style>
