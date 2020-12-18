<template>
    <div class="line2">
        <div id="line2" class="" style="width: 90%;height:450px;"></div>
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
            this.myChart = echarts.init(document.getElementById('line2'));
            this.initData();
        },
        props: ['twDate', 'twDay'],
        methods: {
            initData(){
                const colors = ['#5793f3', '#675bba', '#d14a61'];
                const option = {
                    color: colors,
                    title: {
                        text: '图书借阅月份走势图',
                        subtext: ''
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['借书次数', '低年级学生借阅次数', '高年级学生借阅次数']
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
                        //data: this.twDay
                        data : [1,2,3,4,5,6,7,8,9,10,11,12],
                    },
                    yAxis: [
                        {
                            type: 'value',
                            name: '次数',
                            min: 0,
                            max: 200,
                            position: 'left',
                            axisLine: {
                                lineStyle: {
                                    color: '#999'
                                }
                            },
                            axisLabel: {
                                formatter: '{value}'
                            }
                        },
                    ],
                    series: [
                        {
                            name:'借书次数',
                            type:'line',
                            //data:this.twDate[0],
                            data :[1,2,8,4,5,6,7,8,9,10,11,12],
                            yAxisIndex: 0,
                            markPoint: {
                                data: [
                                    {type: 'max', name: '最大值'},
                                    {type: 'min', name: '最小值'}
                                ]
                            },
                        },
                        {
                            name:'低年级学生借阅次数',
                            type:'line',
                            //data:this.twDate[1],
                            data:[1,2,3,4,5,6,7,8,9,10,11,12],
                            yAxisIndex: 0,
                            markPoint: {
                                data: [
                                    {type: 'max', name: '最大值'},
                                    {type: 'min', name: '最小值'}
                                ]
                            },
                        },
                        {
                            name:'高年级学生借阅次数',
                            type:'line',
                            //data:this.twDate[2],
                            data:[1,2,3,4,5,2,7,8,9,10,11,12],
                            yAxisIndex: 0,
                            markPoint: {
                                data: [
                                    {type: 'max', name: '最大值'},
                                    {type: 'min', name: '最小值'}
                                ]
                            },
                        }
                    ]
                };
                this.myChart.setOption(option);
            }
        },
        watch: {
            twDate: function (){
                this.initData()
            },
            twDay: function (){
                this.initData()
            }
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .line2{
        display: flex;
        justify-content: center;
    }
</style>
