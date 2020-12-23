<template>
    <div>
        <libHead-top></libHead-top>
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
    import libHeadTop from "../components/libHeadTop";
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
            libHeadTop,
            visitorPie,
            bookBorrowTendency,
            tendency,
        },
        mounted(){
            this.initData();
        },
        methods: {
            async initData(){
                this.$axios
                     .get('/studentbook/selectAll')
                     .then(successResponse => {
                         var allData,i,len;
                         allData=successResponse.data
                         len=allData.length
                         this.twDate=[[0,0,0,0,0,0,0,0,0,0,0,0]]
                         this.allBorrow = len;
                         this.newBorrow = len - 101;
                         for(i=0;i<len;i++)
                         {
                            if(allData[i].borrowDate=="1001") this.twDate[0][0]+=1;
                            else if(allData[i].borrowDate=="1002") this.twDate[0][1]+=1;
                            else if(allData[i].borrowDate=="1003") this.twDate[0][2]+=1;
                            else if(allData[i].borrowDate=="1004") this.twDate[0][3]+=1;
                            else if(allData[i].borrowDate=="1005") this.twDate[0][4]+=1;
                            else if(allData[i].borrowDate=="1006") this.twDate[0][5]+=1;
                            else if(allData[i].borrowDate=="1007") this.twDate[0][6]+=1;
                            else if(allData[i].borrowDate=="1008") this.twDate[0][7]+=1;
                            else if(allData[i].borrowDate=="1009") this.twDate[0][8]+=1;
                            else if(allData[i].borrowDate=="1010") this.twDate[0][9]+=1;
                            else if(allData[i].borrowDate=="1011") this.twDate[0][10]+=1;
                            else if(allData[i].borrowDate=="1012") this.twDate[0][11]+=1;
                         }
                     })
                     .catch(failResponse => {
                         this.$message({type: 'error',message: '获取借阅信息失败'});
                     })
                this.newBorrow = 0;
                this.newReturn = 0;
                /*this.twDate = [
                    [1,2,3,4,5,6,7,8,9,10,11,12]
                    ,[1,2,3,4,5,6,7,8,9,10,11,12]
                    ,[1,2,3,4,5,6,7,8,9,10,11,12]];*/
                /*const res = await getUserCity();
                if (res.status == 1) {
                    this.pieData = res.user_city;
                }else{
                    throw new Error(res)
                }*/
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
