<template>
    <div>
        <!---top></head-top-->
        <!--tendency :sevenDate='twDate' :sevenDay='twDay'></tendency-->
        <section class="data_section">
            <header class="section_title">数据统计</header>
            <el-row :gutter="20" style="margin-bottom: 10px;">
                <el-col :span="4"><div class="data_list today_head"><span class="data_num head">当日数据：</span></div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{newBorrow}}</span> 新增借阅</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{newReturn}}</span> 新增还书</div></el-col>
                <!--el-col :span="4"><div class="data_list"><span class="data_num">{{adminCount}}</span> 新增管理员</div></el-col-->
            </el-row>
            <el-row :gutter="20">
                <el-col :span="4"><div class="data_list all_head"><span class="data_num head">总数据：</span></div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allBorrow}}</span> 总借阅次数</div></el-col>
                <!--el-col :span="4"><div class="data_list"><span class="data_num">{{allOrderCount}}</span> 订单</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{allAdminCount}}</span> 管理员</div></el-col-->
            </el-row>
        </section>
        <bookBorrowTendency :twDate='twDate' :twDay='twDay'></bookBorrowTendency>
        <!--visitor-pie :pieData="pieData"></visitor-pie-->
    </div>
</template>

<script>
    import headTop from '../components/headTop'
    import bookBorrowTendency from "../components/bookBorrowTendency"
    import visitorPie from '@/components/visitorPie'
    import tendency from "../components/tendency";
    import {getUserCity} from '@/api/getData'
    export default {
        data(){
            return {
                newBorrow:null,
                newReturn:null,
                allBorrow:null,
                twDay:[],
                twDate:[[],[],[]],
                pieData: {},
            }
        },
        components: {
            headTop,
            visitorPie,
            bookBorrowTendency,
            tendency,
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
