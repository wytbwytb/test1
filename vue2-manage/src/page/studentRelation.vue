<template>
    <div>
        <div style="margin-top: 10px;display: flex;justify-content: center;align-items: center">
            <el-input
                @keyup.enter.native="searchClick"
                placeholder="通过学号或姓名查询..."
                prefix-icon="el-icon-search"
                size="small"
                style="width: 400px;margin-right: 10px"
                v-model="keywords">
            </el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>

        </div>
        <section class="data_section">
            <header class="section_title">缘-妙不可言</header>

            <el-row :gutter="5">
                <el-col :span="4"><div class="data_list all_head"><span class="data_num head">total缘：{{totaly}}</span></div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameCourse}}</span> 相同课程</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameT}}</span> 相同老师</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameClub}}</span> 相同社团</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameDorm}}</span> 相同公寓</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameArea}}</span> 相同区域</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameBorrow}}</span> 相似借阅</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameClass}}</span> 相同班级</div></el-col>
                <el-col :span="2"><div class="data_list"><span class="data_num">{{sameDept}}</span> 相同院系</div></el-col>


                <!--el-col :span="4"><div class="data_list"><span class="data_num">{{allOrderCount}}</span> 订单</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allAdminCount}}</span> 管理员</div></el-col-->
            </el-row>
        </section>
        <stuRelationTen :eightItem="eightItem"></stuRelationTen>
        <!--visitor-pie :pieData="pieData"></visitor-pie-->
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import bookBorrowTendency from "../components/bookBorrowTendency"
    import visitorPie from '@/components/visitorPie'
    import stuRelationTen from "../components/stuRelationTen"
    import {getUserCity} from '@/api/getData'
    export default {
        data(){
            return {
                totaly:8,
                sameCourse:1,
                sameT:2,
                sameClub:5,
                sameDorm:1,
                sameArea:4,
                sameBorrow:5,
                sameClass:5,
                sameDept:2,
                twDay:[],
                eightItem:[],
                pieData: {},
            }
        },
        components: {
            headTop,
            stuRelationTen,
        },
        mounted(){
            this.initData();
        },
        methods: {
            async initData(){
                try{
                    this.newBorrow = 10;
                    this.newReturn = 10;
                    this.allBorrow = 100;
                    /*this.twDay = [1,2,3,4,5,6,7,8,9,10,11,12];
                    this.twDate = [
                        [1,2,3,4,5,6,7,8,9,10,11,12]
                        ,[1,2,3,4,5,6,7,8,9,10,11,12]
                        ,[1,2,3,4,5,6,7,8,9,10,11,12]];*/
                    /*const res = await getUserCity();
                    if (res.status == 1) {
                        this.pieData = res.user_city;
                    }else{
                        throw new Error(res)
                    }*/
                }catch(err){
                    console.log('获取用户分布信息失败',err);
                }
            },
            searchClick(){
                this.$axios
                    .post('/studentbook/selectById',{student: "%"+this.keywords+"%",
                        book:"%"+this.keywords+"%"})
                    .then(successResponse => {
                        this.allData=successResponse.data
                        this.showAll();
                    })
                    .catch(failResponse => {
                        this.$message({type: 'error',message: '查询借阅信息失败'});
                    })
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .data_section{
        padding: 20px;
        margin-bottom: 40px;
        .section_title{
            text-align: center;
            font-size: 30px;
            margin-bottom: 10px;
        }
        .data_list{
            text-align: center;
            font-size: 14px;
            color: #666;
            border-radius: 6px;
            background: #E5E9F2;
            .data_num{
                color: #333;
                font-size: 26px;

            }
            .head{
                border-radius: 6px;
                font-size: 22px;
                padding: 4px 0;
                color: #fff;
                display: inline-block;
            }
        }
        .today_head{
            background: #FF9800;
        }
        .all_head{
            background: #20A0FF;
        }
    }
    .wan{
        .sc(16px, #333)
    }
</style>
