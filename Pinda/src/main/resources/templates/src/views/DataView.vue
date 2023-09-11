<template>
  <div class="chart-container">
    <div class="row">
      <div ref="userCount" class="chart"></div>
      <div ref="topTenGoods" class="chart"></div>
      <div ref="adStatus" class="chart"></div>
    </div>
    <div class="row">
      <div ref="weekData" class="chart"></div>
      <div ref="windowRadio" class="chart"></div>
    </div>
  </div>

</template>

<script>
import * as echarts from 'echarts';
import axios from 'axios';
import 'echarts/extension/bmap/bmap';

export default {
  name: 'DataView',
  data() {
    return {
      chartData: {},
      chartLoaded: false,
      loginVisible: true,
      username: '',
      password: '',
    }
  },


  setup() {

  },

  mounted() {
    axios.get('/api/driver/count')
        .then(response => {
          this.chartData = response.data;
          this.numberOfDriver = this.chartData.extend.numberOfDriver
          this.chartLoaded = true;
        })
        .catch(error => {
          console.log(error);
        });
    this.renderChart()

  },
  methods:{
    login(){
      console.log("login...")
      this.loginVisible = false
    },
    submitForm() {
      if (!this.username || !this.password) {
        alert('用户名和密码不能为空');
        return;
      }
      // 在这里提交表单
      // console.log(`用户名：${this.username}，密码：${this.password}`);
    },
    renderChart(){
      // console.log("render Chart...")
      const userCount = echarts.init(this.$refs.userCount);
      const weekData = echarts.init(this.$refs.weekData);
      const topTenGoods = echarts.init(this.$refs.topTenGoods);
      const windowRadio = echarts.init(this.$refs.windowRadio);
      const adStatus = echarts.init(this.$refs.adStatus);

      const option1 ={
        title: {
          text: '用户数量',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: '用户数量',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false,
            },
            data: [
              { value: 432, name: '司机数量' },
              { value: 2439, name: '乘客数量' },
              { value: 135, name: '站点数量' },
            ]
          }
        ]
      };

      /**/
      const option2 = {
        title: {
          text: '本周数据',
          left: 'center'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        // toolbox: {
        //   feature: {
        //     dataView: { show: true, readOnly: false },
        //     magicType: { show: true, type: ['line', 'bar'] },
        //     restore: { show: true },
        //     saveAsImage: { show: true }
        //   }
        // },
        legend: {
          data: ['销售量', '销售额'],
          bottom: 'left'
        },
        xAxis: [
          {
            type: 'category',
            data: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '销售额',
            min: 0,
            max: 80,
            interval: 20,
            axisLabel: {
              formatter: '{value} 千元'
            }
          },
          {
            type: 'value',
            name: '销售量',
            min: 0,
            max: 10,
            interval: 2,
            axisLabel: {
              formatter: '{value} 千件'
            }
          }
        ],
        series: [
          {
            name: '销售额',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value + ' 千元';
              }
            },
            data: [
              53.9, 34.9, 27.0, 44.2, 45.6, 26.7, 75.6
            ]
          },
          {
            name: '销售量',
            type: 'line',
            tooltip: {
              valueFormatter: function (value) {
                return value + ' 千件';
              }
            },
            data: [
              62.6, 39.9, 32.0, 50.4, 52.7, 30.7, 78.6
            ]
          }
        ]
      };

      const option3 = {
        title: {
          text: '本周销量前十商品',
          subtext: '仅统计成功交易商品',
          left: 'center'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01]
        },
        yAxis: {
          type: 'category',
          data: [ '旺仔小馒头', '旺旺仙贝','纸巾','湿巾','青梅绿茶', '王老吉', '薄荷糖', '口香糖', '雪碧', '可口可乐',],
        },
        series: [
          {
            type: 'bar',
            data: [784, 1744, 2620, 3309, 3439, 4970, 5034, 5489, 6302, 7589],
            tooltip: {
              valueFormatter: function (value) {
                return value + ' 件';
              }
            },
          }
        ]
      };

      const option4 = {
        title: {
          text: '当前在线设备占比',
          subtext: '在线设备 / 激活设备',
          left: 'center'
        },
        series: [
          {
            type: 'gauge',
            progress: {
              show: true,
              width: 18
            },
            axisLine: {
              lineStyle: {
                width: 18
              }
            },
            axisTick: {
              show: false
            },
            splitLine: {
              length: 15,
              lineStyle: {
                width: 2,
                color: '#999'
              }
            },
            axisLabel: {
              distance: 25,
              color: '#999',
              fontSize: 20
            },
            anchor: {
              show: true,
              showAbove: true,
              size: 25,
              itemStyle: {
                borderWidth: 10
              }
            },
            title: {
              show: false
            },
            detail: {
              valueAnimation: true,
              fontSize: 60,
              offsetCenter: [0, '70%'],
              formatter: '{value}%',
            },
            data: [
              {
                value: 67
              }
            ]
          }
        ]
      };

      const option5 = {
        color: ['#56A3F1', '#FFE434'],
        title: {
          text: '广告投送状况',
          left: 'center'
        },
        legend: {bottom: 'left'},
        radar: {
          // shape: 'circle',
          indicator: [
            { name: '搜索广告', max: 100 },
            { name: '显示广告', max: 100 },
            { name: '社交广告', max: 100 },
            { name: '视频广告', max: 100 },
            { name: '公益广告', max: 100 },
            { name: '弹窗广告', max: 100 }
          ]
        },

        series: [
          {
            name: '广告投送状况',
            type: 'radar',
            data: [
              {
                value: [91, 98, 83, 76, 59, 70],
                name: '收益比',
                symbol: 'rect',
                symbolSize: 12,
                lineStyle: {
                  type: 'dashed'
                },
                label: {
                  show: true,
                  formatter: function (params) {
                    return params.value;
                  }
                }
              },
              {
                value: [80, 93, 70, 90, 70, 60],
                name: '投放数量',
                areaStyle: {
                  color: new echarts.graphic.RadialGradient(0.1, 0.6, 1, [
                    {
                      color: 'rgba(255, 145, 124, 0.1)',
                      offset: 0
                    },
                    {
                      color: 'rgba(255, 145, 124, 0.9)',
                      offset: 1
                    }
                  ])
                }
              }
            ]
          }
        ]
      };

      userCount.setOption(option1);
      weekData.setOption(option2);
      topTenGoods.setOption(option3);
      windowRadio.setOption(option4);
      adStatus.setOption(option5);
    }
  }
};
</script>

<style>
.chart-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
}

.row {
  display: flex;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
}

.chart {
  width: calc(50% - 10px);
  height: 420px;
}
</style>