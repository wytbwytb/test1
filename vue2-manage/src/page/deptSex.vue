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
            <el-col class="is-justify-center" >
                <sex-pie :pieData="pieData"></sex-pie>
            </el-col>
            <hr style="background: dimgray;height: 5px">
            <el-col class="is-justify-center ">
                <sex-zhu :man="man" :woman="woman"></sex-zhu>
            </el-col>

        </el-row>
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import sexPie from '@/components/sexPie'
    import sexZhu  from "../components/sexZhu";

    export default {
        data() {
            return {
                keywords:'',
                pieData: {},
                man: [],
                woman:[],
            }
        },
        components: {
            headTop,
            sexPie,
            sexZhu,
        },
        created() {
            this.initData();
        },
        methods: {
            searchClick(){
                this.$axios
                    .post('/class/selectByClassId',{classId: "%"+this.keywords+"%"})
                    .then(successResponse => {
                        this.allData=successResponse.data
                        this.showAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '查询班级信息失败'});
                    })
            },
            initData() {
                this.$axios
                    .get('/student/selectAll')
                    .then(successResponse => {
                        var i,len,male,female;
                        len=successResponse.data.length
                        male=0
                        female=0
                        for(i=0;i<len;i++)
                        {
                            if(successResponse.data[i].gender=="男") male+=1;
                            else female+=1;
                        }
                        this.pieData = [
                            {value: female, name: '女'},
                            {value: male, name: '男'}
                        ];
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '获取学生信息失败'});
                        console.log(failResponse);
                    })
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

</style>
