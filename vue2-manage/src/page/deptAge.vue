<template xmlns:el-col="http://www.w3.org/1999/html">

    <div>
        <head-top></head-top>
        <div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过系编号查询..."
                prefix-icon="el-icon-search"
                size="small"
                style="width: 400px;margin-right: 10px"
                v-model="keywords">
            </el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>

        </div>
        <!--head-top></head-top-->
        <el-row>
            <el-col class="is-justify-center">
                <age-pie :pieData="pieData"></age-pie>
            </el-col>
            <hr style="background: dimgray;height: 5px">
            <el-col class="is-justify-center ">
                <age-zhu :age18="age18" :age19="age19" :age20="age20" :age21="age21" :age22="age22"></age-zhu>
            </el-col>

        </el-row>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import agePie from '@/components/agePie'
    import ageZhu from "../components/ageZhu";

    export default {
        data() {
            return {
                keywords:'',
                pieData: {},
                age18: [],
                age19: [],
                age20: [],
                age21: [],
                age22: [],
            }
        },
        components: {
            headTop,
            agePie,
            ageZhu,
        },

        mounted() {
            this.initData();
        },
        methods: {
            searchClick(){
                this.$axios
                    .post('/department/queryDepartmentAllAge',{departmentId: this.keywords})
                    .then(successResponse => {
                        this.pieData = [
                            {value: successResponse.data.c18, name: '18'},
                            {value: successResponse.data.c19, name: '19'},
                            {value: successResponse.data.c20, name: '20'},
                            {value: successResponse.data.c21, name: '21'},
                            {value: successResponse.data.c22, name: '22'}
                        ];
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '查询失败'});
                    })
            },
            async initData() {

                this.$axios
                    .get('/student/selectAll')
                    .then(successResponse => {
                        var i,len,a18,a19,a20,a21,a22;
                        len=successResponse.data.length
                        a18=0;
                        a19=0;
                        a20=0;
                        a21=0;
                        a22=0;
                        for(i=0;i<len;i++)
                        {
                            if(successResponse.data[i].age==18) a18+=1;
                            else if(successResponse.data[i].age==19) a19+=1;
                            else if(successResponse.data[i].age==20) a20+=1;
                            else if(successResponse.data[i].age==21) a21+=1;
                            else if(successResponse.data[i].age==22) a22+=1;
                        }
                        this.pieData = [
                            {value: a18, name: '18'},
                            {value: a19, name: '19'},
                            {value: a20, name: '20'},
                            {value: a21, name: '21'},
                            {value: a22, name: '22'},
                        ];
                        console.log(this.pieData)
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '获取学生信息失败'});
                        console.log(failResponse);
                    })

                this.$axios
                    .get('/department/queryAllDepartmentAge')
                    .then(successResponse => {
                        this.age18=[0,0,0,0,0,0,0];
                        this.age19=[0,0,0,0,0,0,0];
                        this.age20=[0,0,0,0,0,0,0];
                        this.age21=[0,0,0,0,0,0,0];
                        this.age22=[0,0,0,0,0,0,0];
                        var i;
                        for(i=0;i<7;i++)
                        {
                            this.age18[i]=successResponse.data[i].c18
                            this.age19[i]=successResponse.data[i].c19
                            this.age20[i]=successResponse.data[i].c20
                            this.age21[i]=successResponse.data[i].c21
                            this.age22[i]=successResponse.data[i].c22
                        }
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '获取学生信息失败'});
                        console.log("failResponse");
                        console.log(failResponse);
                        console.log("failResponse");
                    })

            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

</style>
