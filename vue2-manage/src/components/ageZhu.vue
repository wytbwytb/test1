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
                //const colors = ['#f36fd1', '#56bab4', '#d14a61','#208ad1','#ccd160'];
                //const colors = rgba(0, 0, 0, 0.5);
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
                        text: '年龄比例图',
                        left: 'center'
                    },
                    xAxis: {
                        type: 'category',
                        data: ['大一', '大二', '大三', '大四']
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
                            data: [this.age18[0], 50, 60, 70],
                            type: 'bar',
                            barWidth: 30,
                        },
                        {
                            name: '19',
                            data: [10, 20, 30, 40],
                            type: 'bar',
                            barWidth: 30,
                        },
                        {
                            name: '20',
                            data: [120, 200, 150, 80],
                            type: 'bar',
                            barWidth: 30,
                        },
                        {
                            name: '21',
                            data: [120, 200, 150, 80],
                            type: 'bar',
                            barWidth: 30,
                        },
                        {
                            name: '22',
                            data: [33, 40, 5, 10],
                            type: 'bar',
                            barWidth: 30,
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
