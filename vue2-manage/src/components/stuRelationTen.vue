<template>
    <div class="line3">
        <div id="line3" class="" style="width: 90%;height:450px;"></div>
    </div>
</template>

<script>
    import echarts from 'echarts/lib/echarts';
    // 引入柱状图
    import 'echarts/lib/chart/bar';
    import 'echarts/lib/chart/line';
    import 'echarts/lib/component/title';
    import 'echarts/lib/component/legend';
    import 'echarts/lib/component/toolbox';
    import 'echarts/lib/component/markPoint';
    import 'echarts/lib/component/tooltip';
    export default {
        mounted(){
            this.myChart = echarts.init(document.getElementById('line3'));
            this.initData();
        },
        props: ['eightItem'],
        methods: {
            initData(){
                const colors = ['#5793f3', '#675bba', '#d14a61'];
                const option = {
                    color: colors,
                    title: {
                        text: '缘',
                        subtext: ''
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            dataView: {readOnly: false},
                            magicType: {type: ['bar', 'line']},
                            restore: {},
                        }
                    },
                    xAxis:  {
                        type: 'category',
                        boundaryGap: false,
                        data: ["相同课程","相同老师","相同社团","相同公寓","相同区域","相似借阅","相同班级","相同院系"],
                    },
                    yAxis: [
                        {
                            type: 'value',
                            name: '缘',
                            min: 0,
                            max: 8,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: '#999'
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }
                    ],
                    series: [
                        {
                            //name:'新增管理员',
                            name:'value',
                            type:'line',
                            data:this.eightItem,
                            yAxisIndex: 0,
                        }
                    ]
                };
                this.myChart.setOption(option);
            }
        },
        watch: {
            eightItem: function (){
                this.initData()
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .line3{
        display: flex;
        justify-content: center;
    }
</style>
