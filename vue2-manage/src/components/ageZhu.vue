<template>
    <div class="ageZhu">
        <div id="ageZhu" class="" style="width: 90%;height:450px;"></div>
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
            this.myChart = echarts.init(document.getElementById('ageZhu'));
            this.initData();
        },
        props: ['age18', 'age19', 'age20', 'age21', 'age22'],
        methods: {
            initData() {

                const option = {
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    title: {
                        text: '年龄柱状图',
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
                        data: ['18', '19', '20', '21', '22'],
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
                            name: '18',
                            data: this.age18,
                            type: 'bar',
                            barWidth: 15,
                        },
                        {
                            name: '19',
                            data: this.age19,
                            type: 'bar',
                            barWidth: 15,
                        },
                        {
                            name: '20',
                            data: this.age20,
                            type: 'bar',
                            barWidth: 15,
                        },
                        {
                            name: '21',
                            data: this.age21,
                            type: 'bar',
                            barWidth: 15,
                        },
                        {
                            name: '22',
                            data: this.age22,
                            type: 'bar',
                            barWidth: 15,
                        }]
                };
                this.myChart.setOption(option);
            }
        },
        watch: {
            age18: function () {
                this.initData()
            },
            age19: function () {
                this.initData()
            },
            age20: function () {
                this.initData()
            },
            age21: function () {
                this.initData()
            },
            age22: function () {
                this.initData()
            }
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

    .ageZhu {
        display: flex;
        justify-content: center;
    }
</style>
