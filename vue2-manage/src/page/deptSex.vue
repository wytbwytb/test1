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
        mounted() {
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
            async initData() {

                    /*this.pieData2 = [
                        {value: 1000, name: 'wtbnb'},
                        {value: 300, name: 'xysnb'},
                        {value: 300, name: 'yshnb'}
                    ]*/
                try{
                    this.pieData = [
                        {value: 1000, name: 'wtbnb'},
                        {value: 300, name: 'xysnb'},
                        {value: 300, name: 'yshnb'}
                    ];
                    this.woman = [10,50,20,30];
                    this.man = [10,60,50,80];

                }catch(err){
                    console.log('获取用户分布信息失败',err);
                }
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

</style>
