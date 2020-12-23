<template>
    <div class="sexZhu">
        <div id="sexZhu" class="" style="width: 90%;height:450px;"></div>
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
        mounted() {
            this.myChart = echarts.init(document.getElementById('sexZhu'));
            this.initData();
        },
        props: ['man', 'woman'],
        methods: {
            initData() {
                const colors = ['#5793f3', '#675bba', '#d14a61'];
                const option = {
                    //color: colors,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    title: {
                        text: '男女比例图',
                        left: 'center'
                    },
                    xAxis: {
                        type: 'category',
                        data: ['1系', '2系', '3系', '4系', '5系', '6系', '73系']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    legend: {
                        left: 'center',
                        data: ['男', '女'],
                        bottom: 0
                    },
                    grid: {
                        left: '1%',
                        right: '2%',
                        bottom: '8%',
                        containLabel: true
                    },
                    series: [
                        {
                            name: '男',
                            data: [this.man[0], 200, 150, 80],
                            type: 'bar',
                            barWidth: 50,
                        },
                        {
                            name: '女',
                            data: [120, 200, 150, 80],
                            type: 'bar',
                            barWidth: 50,
                        }]
                };
                this.myChart.setOption(option);
            }
        },
        watch: {
            man: function () {
                this.initData()
            },
            woman: function () {
                this.initData()
            }
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

    .sexZhu {
        display: flex;
        justify-content: center;
    }
</style>
