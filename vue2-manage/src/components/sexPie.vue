<template>
    <div class="sexPie">
        <div id="sexPie" class="" style="width: 90%;height:450px;"></div>
    </div>
</template>

<script>
    import echarts from 'echarts/lib/echarts';
    // 引入柱状图
    import 'echarts/lib/chart/pie';
    import 'echarts/lib/component/title';
    import 'echarts/lib/component/legend';
	export default {
        mounted(){
            this.myChart = echarts.init(document.getElementById('sexPie'));
            this.initData();
        },
        props: ['pieData'],
        methods: {
            initData(){
                const option = {
                    title : {
                        text: '分布',
                        subtext: '',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['女','男']
                    },
                    series : [
                        {
                            name: '性别',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value:this.pieData[0].value, name:this.pieData[0].name},
                                {value:this.pieData[1].value, name:this.pieData[1].name}

                            ],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                this.myChart.setOption(option);
            }
        },
        watch: {
            pieData: function (){
                this.initData()
            }
        }
	}
</script>

<style lang="less">
    @import '../style/mixin';
    .sexPie{
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
</style>
