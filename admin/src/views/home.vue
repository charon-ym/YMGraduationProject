<template>
    <div  class="content" :style='{"padding":"0 40px 200px","textAlign":"center","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
        <div v-if="role==='学生'||role==='教工'" class="text" :style='{"margin":"40px auto 0","color":"#333","textAlign":"center","width":"100%","fontSize":"32px","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
        <div v-if="role==='管理员'" ref="chartDiv" class="cardView">
            <div  class="cards" :style='{"width":"100%","margin":"20px 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
                <div :style='{"border":"0px solid #ccc","margin":"0 10px","borderRadius":"4px","background":"none","display":"flex"}'>
                    <div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","borderRadius":"50px 0 0 50px","background":"#fff","borderWidth":"1px","width":"180px","background":"url(http://codegen.caihongy.cn/20230215/ddfd7bd52f04451c9e034bc40d977d9b.png) no-repeat center center / 80% 80%,#fff","borderStyle":"solid","height":"158px"}'></div>
                    <div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"0 50px 50px 0","flexDirection":"column","background":"#fff","borderWidth":"1px 1px 1px 0","display":"flex","width":"160px","borderStyle":"solid","justifyContent":"center"}'>
                        <div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#666","fontWeight":"bold","height":"24px"}'>{{xueshengrudangCount}}</div>
                        <div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#666","height":"24px"}'>学生入党总数</div>
                    </div>
                </div>
                <div :style='{"border":"0px solid #ccc","margin":"0 10px","borderRadius":"4px","background":"none","display":"flex"}'>
                    <div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","borderRadius":"50px 0 0 50px","background":"#fff","borderWidth":"1px","width":"180px","background":"url(http://codegen.caihongy.cn/20230215/ddfd7bd52f04451c9e034bc40d977d9b.png) no-repeat center center / 80% 80%,#fff","borderStyle":"solid","height":"158px"}'></div>
                    <div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"0 50px 50px 0","flexDirection":"column","background":"#fff","borderWidth":"1px 1px 1px 0","display":"flex","width":"160px","borderStyle":"solid","justifyContent":"center"}'>
                        <div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#666","fontWeight":"bold","height":"24px"}'>{{jiaogongrudangCount}}</div>
                        <div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#666","height":"24px"}'>教工入党总数</div>
                    </div>
                </div>
            </div>
            <div style="display: flex;flex-wrap: wrap;align-items: stretch;width: 100%;margin-bottom: 10px;">
                <el-card style="flex: 1;margin: 0 10px;margin-bottom: 20px;">
                    <div id="xueshengrudangChart1" style="width:100%;height:400px;"></div>
                </el-card>
                <el-card style="flex: 1;margin: 0 10px;margin-bottom: 20px;">
                    <div id="jiaogongrudangChart1" style="width:100%;height:400px;"></div>
                </el-card>
                <el-card style="flex: 1;margin: 0 10px;margin-bottom: 20px;">
                    <div id="collegePieChart" style="width:100%;height:400px;"></div>
                </el-card>
                <el-card style="width: 100%;margin: 0 10px;">
                    <div id="collegeLineChart" style="width:100%;height:400px;"></div>
                </el-card>
            </div>
        </div>
    </div>
    </template>
    
    <script>
    import * as echarts from 'echarts';
    export default {
      data() {
        return {
          role:"",
          xueshengrudangCount: 120,
          jiaogongrudangCount: 45,
        };
      },
      watch: {
        role(newRole) {
          if (newRole === "管理员") {
            this.$nextTick(() => {
              this.renderCharts();
              });
            }
          }
        },

      computed: {
      // 获取 state
        count() {
          return this.$store.state.count
        },
        // 获取 getters
        doubleCount() {
          return this.$store.getters.doubleCount
        },
      },
      mounted() {
        
        this.role = this.$storage.get("role");
        
        this.renderCharts();
        this.increment();
        
      },
      methods: {
         // 调用 mutation
        increment() {
          console.log("vuex的使用：");
          console.log("vuex的使用：",this.$store.state.count);
          this.$store.commit("increment");
        },
        renderCharts() {
          const studentChart = echarts.init(document.getElementById("xueshengrudangChart1"));
          studentChart.setOption({
            title: { text: '学生入党统计', left: 'center' },
            tooltip: {},
            xAxis: { type: 'category', data: ['1月','2月','3月','4月','5月'] },
            yAxis: { type: 'value' },
            series: [{
              name: '人数',
              type: 'bar',
              data: [20, 25, 22, 18, 35],
              itemStyle:{
                color:'#e84545'
              }
            }]
          });
    
          const teacherChart = echarts.init(document.getElementById("jiaogongrudangChart1"));
          teacherChart.setOption({
            title: { text: '教工入党统计', left: 'center' },
            tooltip: {},
            xAxis: { type: 'category', data: ['1月','2月','3月','4月','5月'] },
            yAxis: { type: 'value' },
            series: [{
              name: '人数',
              type: 'bar',
              data: [5, 8, 7, 10, 15],
              itemStyle:{
                color:'#e84545'
              }
            }]
          });
    
          const pieChart = echarts.init(document.getElementById("collegePieChart"));
          pieChart.setOption({
            title: { text: '各二级学院入党人数占比', left: 'center' },
            tooltip: { trigger: 'item' },
            color:['#e84545','#fc5185','#ffde7d','#ff5722','#f08a5d','#6a2c70'],
            series: [{
              name: '人数',
              type: 'pie',
              radius: '50%',
              data: [
                { value: 40, name: '计算机学院' },
                { value: 30, name: '材料学院' },
                { value: 20, name: '经管学院' },
                { value: 15, name: '外语学院' },
                { value: 10, name: '艺术学院' }
              ]
            }]
          });
    
          const lineChart = echarts.init(document.getElementById("collegeLineChart"));
          lineChart.setOption({
            title: { text: '各月各二级学院党员人数变化', left: 'center' },
            tooltip: { trigger: 'axis' },
            color: ['#e84545', '#fc5185', '#ffde7d', '#ff5722', '#f08a5d', '#6a2c70'],
            legend: { data: ['计算机学院', '材料学院', '经管学院'] ,left:'right'},
            xAxis: { type: 'category', data: ['1月','2月','3月','4月','5月'] },
            yAxis: { type: 'value' },
            series: [
              { name: '计算机学院', type: 'line', data: [10, 15, 20, 18, 22] },
              { name: '材料学院', type: 'line', data: [8, 12, 14, 10, 16] },
              { name: '经管学院', type: 'line', data: [6, 8, 10, 12, 14] }
            ]
          });
        }
      }
    }
    </script>
    
    <style lang="scss" scoped>
    .cardView {
      display: flex;
      flex-wrap: wrap;
      width: 100%;
      .cards {
        display: flex;
        align-items: center;
        width: 100%;
        margin-bottom: 10px;
        justify-content: center;
        .card {
          width: calc(25% - 20px);
          margin: 0 10px;
          ::v-deep.el-card__body {
            padding: 0;
          }
        }
      }
    }
    </style>
    