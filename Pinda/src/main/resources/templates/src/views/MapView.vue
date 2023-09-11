<template>
  <div class="chart-container">
    <div ref="chart6" class="chart-map"></div>
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
      chartLoaded: false
    }
  },

  created() {

  },

  mounted() {
    axios.get('/api/driver/count')
        .then(response => {
          this.chartData = response.data;
          this.numberOfDriver = this.chartData.extend.numberOfDriver
          this.renderChart();
          this.chartLoaded = true;
        })
        .catch(error => {
          console.log(error);
        });
  },
  methods:{
    renderChart(){
      const chart6 = echarts.init(this.$refs.chart6);

      /*装机分布地图*/
      const data = [
        { name: '北京', value: 1324 },
        { name: '西安', value: 2138 },
        { name: '广州', value: 315 },
        { name: '上海', value: 763 },
        { name: '天津', value: 376 },
        { name: '武汉', value: 645 },
        { name: '南京', value: 432 },
        { name: '杭州', value: 616 },
        { name: '成都', value: 239 },
      ];
      const geoCoordMap = {
        上海: [121.48, 31.22],
        北京: [116.46, 39.92],
        西安: [108.95, 34.27],
        广州: [113.23, 23.16],
        天津: [117.2, 39.13],
        武汉: [114.31, 30.52],
        南京: [118.78, 32.04],
        成都: [104.06, 30.67],
        杭州: [120.19, 30.26]
      };
      const convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
          var geoCoord = geoCoordMap[data[i].name];
          if (geoCoord) {
            res.push({
              name: data[i].name,
              value: geoCoord.concat(data[i].value)
            });
          }
        }
        return res;
      };
      const option6 = {
        title: {
          text: '全国主要城市装机量',
          left: 'center',
          textStyle: {
            color: '#fff'
          }
        },
        tooltip: {
          trigger: 'item'
        },
        bmap: {
          center: [114.114129, 37.550339],
          zoom: 5,
          roam: true,
          mapStyle: {
            styleJson: [
              {
                featureType: 'water',
                elementType: 'all',
                stylers: {
                  color: '#044161'
                }
              },
              {
                featureType: 'land',
                elementType: 'all',
                stylers: {
                  color: '#004981'
                }
              },
              {
                featureType: 'boundary',
                elementType: 'geometry',
                stylers: {
                  color: '#064f85'
                }
              },
              {
                featureType: 'railway',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'highway',
                elementType: 'geometry',
                stylers: {
                  color: '#004981'
                }
              },
              {
                featureType: 'highway',
                elementType: 'geometry.fill',
                stylers: {
                  color: '#005b96',
                  lightness: 1
                }
              },
              {
                featureType: 'highway',
                elementType: 'labels',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'arterial',
                elementType: 'geometry',
                stylers: {
                  color: '#004981'
                }
              },
              {
                featureType: 'arterial',
                elementType: 'geometry.fill',
                stylers: {
                  color: '#00508b'
                }
              },
              {
                featureType: 'poi',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'green',
                elementType: 'all',
                stylers: {
                  color: '#056197',
                  visibility: 'off'
                }
              },
              {
                featureType: 'subway',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'manmade',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'local',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'arterial',
                elementType: 'labels',
                stylers: {
                  visibility: 'off'
                }
              },
              {
                featureType: 'boundary',
                elementType: 'geometry.fill',
                stylers: {
                  color: '#029fd4'
                }
              },
              {
                featureType: 'building',
                elementType: 'all',
                stylers: {
                  color: '#1a5787'
                }
              },
              {
                featureType: 'label',
                elementType: 'all',
                stylers: {
                  visibility: 'off'
                }
              }
            ]
          }
        },
        series: [
          {
            name: '装机量',
            type: 'scatter',
            coordinateSystem: 'bmap',
            data: convertData(data),
            symbolSize: function (val) {
              return val[2] / 40;
            },
            encode: {
              value: 2
            },
            label: {
              formatter: '{b}',
              position: 'right',
              show: false
            },
            emphasis: {
              label: {
                show: true
              }
            }
          },
          {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'bmap',
            data: convertData(
                data
                    .sort(function (a, b) {
                      return b.value - a.value;
                    })
                    .slice(0, 6)
            ),
            symbolSize: function (val) {
              return val[2] / 40;
            },
            encode: {
              value: 2
            },
            showEffectOn: 'render',
            rippleEffect: {
              brushType: 'stroke'
            },
            label: {
              formatter: '{b}',
              position: 'right',
              show: true
            },
            itemStyle: {
              shadowBlur: 10,
              shadowColor: '#333'
            },
            emphasis: {
              scale: true
            },
            zlevel: 1
          }
        ]
      };
      chart6.setOption(option6);
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

.chart-map {
  width: calc(100% - 10px);
  height: 900px;
}
</style>