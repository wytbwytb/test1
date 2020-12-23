<template>
    <div class="gradePie">
        <div id="gradePie" class="" style="width: 90%;height:450px;"></div>
    </div>
</template>

<script>
    import echarts from 'echarts/lib/echarts';
    // 引入柱状图
    import 'echarts/lib/chart/pie';
    import 'echarts/lib/component/title';
    import 'echarts/lib/component/legend';

    export default {
        mounted() {
            this.myChart = echarts.init(document.getElementById('gradePie'));
            this.initData();
        },
        props: ['pieData'],
        methods: {
            initData() {
                const option = {
                    title: {
                        text: '分数分布',
                        subtext: '',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',

                        data: ["<60","60-69","70-79","80-89",">=90"]

                    },
                    series: [
                        {
                            name: '成绩',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data:this.pieData/*[
                                {value:10, name:'<60'},
                                {value:50, name:'60-70'},
                                {value:70, name:'70-80'},
                                {value:60, name:'80-90'},
                                {value:10, name:'>=90'},
                                /*{value:this.pieData.hangzhou, name:'杭州'},
                                {value:this.pieData.qita, name:'其他'}

                            ]*/,
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
            pieData: function () {
                this.initData()
            }
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';

    .gradePie {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
</style>
