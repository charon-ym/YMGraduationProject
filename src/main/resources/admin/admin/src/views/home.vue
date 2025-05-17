<template>
<div class="content" :style='{"padding":"0 40px 250px","textAlign":"center","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
	<div class="text" :style='{"margin":"40px auto 0","color":"#333","textAlign":"center","background":"url() no-repeat center top","width":"100%","fontSize":"32px","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"width":"100%","margin":"50px 0 40px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"0px solid #ccc","margin":"0 10px","borderRadius":"4px","background":"none","display":"flex"}' v-if="isAuth('xueshengrudang','首页总数')">
				<div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","borderRadius":"50px 0 0 50px","background":"url(http://codegen.caihongy.cn/20230215/ddfd7bd52f04451c9e034bc40d977d9b.png) no-repeat center center / 80% 80%,#fff","borderWidth":"1px","width":"180px","borderStyle":"solid","height":"158px"}'></div>
				<div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"0 50px 50px 0","flexDirection":"column","background":"#fff","borderWidth":"1px 1px 1px 0","display":"flex","width":"160px","borderStyle":"solid","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#666","fontWeight":"bold","height":"24px"}'>{{xueshengrudangCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#666","height":"24px"}'>学生入党总数</div>
				</div>
			</div>
			<div :style='{"border":"0px solid #ccc","margin":"0 10px","borderRadius":"4px","background":"none","display":"flex"}' v-if="isAuth('jiaogongrudang','首页总数')">
				<div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","borderRadius":"50px 0 0 50px","background":"url(http://codegen.caihongy.cn/20230215/ddfd7bd52f04451c9e034bc40d977d9b.png) no-repeat center center / 80% 80%,#fff","borderWidth":"1px","width":"180px","borderStyle":"solid","height":"158px"}'></div>
				<div :style='{"boxShadow":"0px 9px 9px -12px #bbb","borderColor":"#e8e8e8","alignItems":"center","borderRadius":"0 50px 50px 0","flexDirection":"column","background":"#fff","borderWidth":"1px 1px 1px 0","display":"flex","width":"160px","borderStyle":"solid","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#666","fontWeight":"bold","height":"24px"}'>{{jiaogongrudangCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#666","height":"24px"}'>教工入党总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 50%;margin: 0 10px;" v-if="isAuth('xueshengrudang','首页统计')">
                <div id="xueshengrudangChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 50%;margin: 0 10px;" v-if="isAuth('jiaogongrudang','首页统计')">
                <div id="jiaogongrudangChart1" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//2
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            xueshengrudangCount: 0,
            jiaogongrudangCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getxueshengrudangCount();
    this.xueshengrudangChat1();
    this.getjiaogongrudangCount();
    this.jiaogongrudangChat1();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getxueshengrudangCount() {
        this.$http({
            url: `xueshengrudang/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.xueshengrudangCount = data.data
            }
        })
    },

    xueshengrudangChat1() {
      this.$nextTick(()=>{

        var xueshengrudangChart1 = echarts.init(document.getElementById("xueshengrudangChart1"),'macarons');
        this.$http({
            url: "xueshengrudang/group/shenqingshijian",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].shenqingshijian);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].shenqingshijian
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '学生入党统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        areaStyle: {},
                        smooth: true
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                xueshengrudangChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    xueshengrudangChart1.resize();
                };
            }
        });
      })
    },






    getjiaogongrudangCount() {
        this.$http({
            url: `jiaogongrudang/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.jiaogongrudangCount = data.data
            }
        })
    },

    jiaogongrudangChat1() {
      this.$nextTick(()=>{

        var jiaogongrudangChart1 = echarts.init(document.getElementById("jiaogongrudangChart1"),'macarons');
        this.$http({
            url: "jiaogongrudang/group/shenqingshijian",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].shenqingshijian);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].shenqingshijian
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '教工入党统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                jiaogongrudangChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    jiaogongrudangChart1.resize();
                };
            }
        });
      })
    },






  }
};
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
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
