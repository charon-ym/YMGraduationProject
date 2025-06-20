<template>
	<div class="main-content" :style='{"padding":"0 0 200px","flexWrap":"wrap","background":"none","display":"flex"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"100%","padding":"0","margin":"0px 40px 0px","flexWrap":"wrap","background":"none","display":"flex"}' :inline="true" :model="searchForm">
				<el-row :style='{"width":"100%","padding":"0px 0 30px","flexWrap":"wrap","background":"linear-gradient(180deg, rgba(255,255,255,0) 0%, rgba(255,230,223,.3) 80%, rgba(255,129,93,1) 100%)","justifyContent":"center","display":"flex"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#333","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">组织名称</label>
						<el-input v-model="searchForm.zuzhimingcheng" placeholder="组织名称" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select">
						<label :style='{"margin":"0 10px 0 0","color":"#333","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">是否通过</label>
						<el-select  @change="sfshChange" clearable v-model="searchForm.sfsh" placeholder="是否通过">
							<el-option v-for="(item,index) in sfshOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button :style='{"border":"0px solid #999","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #ccc","outline":"none","margin":"0 0 0 10px","color":"#fff","borderRadius":"4px","background":"url(http://codegen.caihongy.cn/20230215/f3cc6b6274624f66a5a14667d6f68181.png) no-repeat center top / 100% 100%,#fe9000","width":"185px","fontSize":"14px","height":"44px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"padding":"30px 0 0","margin":"0 0px 24px","flexWrap":"wrap","background":"linear-gradient(0deg, rgba(255,255,255,0) 0%, rgba(255,230,223,.6) 80%, rgba(205,55,10,.9) 100%)","display":"flex","width":"100%","justifyContent":"center"}'>
					<el-button :style='{"cursor":"pointer","padding":"0 16px","boxShadow":"1px 2px 4px #91c5da","margin":"0 10px 4px 0","borderColor":"#1098d0","color":"#1098d0","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"0 0 4px","width":"auto","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-if="isAuth('jiaogongrudang','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"cursor":"pointer","padding":"0 16px","boxShadow":"1px 2px 4px #da9891","margin":"0 10px 0 0","borderColor":"#f07062","color":"#f07062","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"0 0 4px","width":"auto","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-if="isAuth('jiaogongrudang','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>


					<download-excel v-if="isAuth('jiaogongrudang','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "教工入党.xls">
						<!-- 导出excel -->
						<el-button :style='{"cursor":"pointer","padding":"0 12px","boxShadow":"1px 2px 4px #dabe90","margin":"0 10px 0 0","borderColor":"#c9a160","color":"#c9a160","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"0 0 4px","width":"auto","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="danger">导出</el-button>
					</download-excel>
					<el-button :style='{"cursor":"pointer","padding":"0 12px","boxShadow":"1px 2px 4px #dabe90","margin":"0 10px 0 0","borderColor":"#c9a160","color":"#c9a160","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"0 0 4px","width":"auto","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-if="isAuth('jiaogongrudang','打印')" type="success" @click="printJson">打印</el-button>


					<el-button :style='{"cursor":"pointer","padding":"0 12px","boxShadow":"1px 2px 4px #dabe90","margin":"0 10px 0 0","borderColor":"#c9a160","color":"#c9a160","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","borderWidth":"0 0 4px","width":"auto","fontSize":"14px","borderStyle":"solid","height":"40px"}' v-if="isAuth('jiaogongrudang','教工入党统计')" type="warning" @click="chartDialog1()">教工入党统计</el-button>
				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#e6a491 #d37a61 #cd370a","margin":"0 40px 20px","borderRadius":"0px","borderWidth":"8px","background":"#fff","width":"calc(100% - 80px)","borderStyle":"solid"}' 
					v-if="isAuth('jiaogongrudang','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="shenqingbianhao"
					label="申请编号">
						<template slot-scope="scope">
							{{scope.row.shenqingbianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zuzhimingcheng"
					label="组织名称">
						<template slot-scope="scope">
							{{scope.row.zuzhimingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zuzhidizhi"
					label="组织地址">
						<template slot-scope="scope">
							{{scope.row.zuzhidizhi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="cailiao" label="材料">
						<template slot-scope="scope">
							<el-button v-if="scope.row.cailiao" type="text" size="small" @click="download($base.url+scope.row.cailiao)">下载</el-button>
                            <span v-else >无</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shenqingshijian"
					label="申请时间">
						<template slot-scope="scope">
							{{scope.row.shenqingshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jiaogongzhanghao"
					label="教工账号">
						<template slot-scope="scope">
							{{scope.row.jiaogongzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="jiaogongxingming"
					label="教工姓名">
						<template slot-scope="scope">
							{{scope.row.jiaogongxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shenfen"
					label="身份">
						<template slot-scope="scope">
							{{scope.row.shenfen}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="shhf" label="审核回复"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="sfsh" label="审核状态">
						<template slot-scope="scope">
							<span style="margin-right:10px" v-if="scope.row.sfsh=='是'">通过</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='否'">未通过</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='待审核'">待审核</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' v-if="isAuth('jiaogongrudang','审核')" prop="sfsh" label="审核">
						<template slot-scope="scope">
							<el-button  type="text" size="small" @click="shDialog(scope.row)">审核</el-button>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"cursor":"pointer","padding":"6px 20px","margin":"3px 6px 3px 0","borderColor":"#cff296 #6bad01 #63a100","color":"#6bad01","outline":"none","borderRadius":"20px","background":"#fff","borderWidth":"1px 1px 4px","width":"auto","fontSize":"14px","borderStyle":"solid","textShadow":"0 0px 0 rgba(0,0,0,.25)","height":"32px"}' v-if=" isAuth('jiaogongrudang','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"cursor":"pointer","padding":"6px 20px","margin":"3px 6px 3px 0","borderColor":"#c3f2ef #18c3b9 #18c3b9","color":"#24d7cd","outline":"none","borderRadius":"20px","background":"none","borderWidth":"1px 1px 4px","width":"auto","fontSize":"14px","borderStyle":"solid","textShadow":"0 0px 0 rgba(0,0,0,.25)","height":"32px"}' v-if=" isAuth('jiaogongrudang','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"cursor":"pointer","padding":"6px 20px","margin":"3px 6px 3px 0","borderColor":"#f4d2d9 #cc0f38 #cc0f38","color":"#cc0f38","outline":"none","borderRadius":"20px","background":"#fff","borderWidth":"1px 1px 4px","width":"auto","fontSize":"14px","borderStyle":"solid","textShadow":"0 0px 0 rgba(0,0,0,.25)","height":"32px"}' v-if="isAuth('jiaogongrudang','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"padding":"0 40px","margin":"20px 0 0","whiteSpace":"nowrap","color":"#eee","textAlign":"center","width":"100%","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


		<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.sfsh" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="shDialog">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</span>
		</el-dialog>



		<el-dialog
		  title="教工入党统计"
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="shenqingshijianChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],
//导出excel
      json_fields: {
      "申请编号": "shenqingbianhao",    //常规字段
      "组织名称": "zuzhimingcheng",    //常规字段
      "组织地址": "zuzhidizhi",    //常规字段
      "材料": "cailiao",    //常规字段
      "申请时间": "shenqingshijian",    //常规字段
      "教工账号": "jiaogongzhanghao",    //常规字段
      "教工姓名": "jiaogongxingming",    //常规字段
      "身份": "shenfen",    //常规字段
      "申请内容": "shenqingneirong",    //常规字段
      "是否审核": "sfsh",    //常规字段
      "审核回复": "shhf",    //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 "
          }
        ]
      ]

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },



//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{

        var shenqingshijianChart1 = echarts.init(document.getElementById("shenqingshijianChart1"),'macarons');
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
                shenqingshijianChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    shenqingshijianChart1.resize();
                };
            }
        });
      })
    },





    init () {
        this.sfshOptions = "是,否,待审核".split(',');
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.zuzhimingcheng!='' && this.searchForm.zuzhimingcheng!=undefined){
            params['zuzhimingcheng'] = '%' + this.searchForm.zuzhimingcheng + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
      this.$http({
        url: "jiaogongrudang/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 审核窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
          shenqingbianhao: row.shenqingbianhao,
          zuzhimingcheng: row.zuzhimingcheng,
          zuzhidizhi: row.zuzhidizhi,
          cailiao: row.cailiao,
          shenqingshijian: row.shenqingshijian,
          jiaogongzhanghao: row.jiaogongzhanghao,
          jiaogongxingming: row.jiaogongxingming,
          shenfen: row.shenfen,
          shenqingneirong: row.shenqingneirong,
          sfsh: row.sfsh,
          shhf: row.shhf,
          id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`确定操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "jiaogongrudang/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "jiaogongrudang/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          shenqingbianhao: this.list[i].shenqingbianhao,
          zuzhimingcheng: this.list[i].zuzhimingcheng,
          zuzhidizhi: this.list[i].zuzhidizhi,
          shenqingshijian: this.list[i].shenqingshijian,
          jiaogongzhanghao: this.list[i].jiaogongzhanghao,
          jiaogongxingming: this.list[i].jiaogongxingming,
          shenfen: this.list[i].shenfen,
          sfsh: this.list[i].sfsh,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'shenqingbianhao',
		displayName: '申请编号', 
		columnSize: 1
	  },
	  {
		field: 'zuzhimingcheng',
		displayName: '组织名称',
		columnSize: 1
	  },
	  {
		field: 'zuzhidizhi',
		displayName: '组织地址',
		columnSize: 1
	  },
	  {
		field: 'shenqingshijian',
		displayName: '申请时间',
		columnSize: 1
	  },
	  {
		field: 'jiaogongzhanghao',
		displayName: '教工账号',
		columnSize: 1
	  },
	  {
		field: 'jiaogongxingming',
		displayName: '教工姓名',
		columnSize: 1
	  },
	  {
		field: 'shenfen',
		displayName: '身份',
		columnSize: 1
	  },
	  {
		field: 'sfsh',
		displayName: '是否审核',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '教工入党',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }

};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input ::v-deep .el-input__inner {
				border: 1px solid #ccc;
				border-radius: 4px;
				padding: 0 12px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-select ::v-deep .el-input__inner {
				border: 1px solid #ccc;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor ::v-deep .el-input__inner {
				border: 1px solid #ccc;
				border-radius: 4px;
				padding: 0 10px 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	// table
	.el-table ::v-deep .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table ::v-deep .el-table__header-wrapper thead tr {
				background: linear-gradient(270deg, rgba(238,149,42,1) 0%, rgba(205,55,10,1) 100%);
			}
	
	.el-table ::v-deep .el-table__header-wrapper thead tr th {
				padding: 10px;
				color: #fff;
				background: none;
				border-color: #fcd0ac #fbecd9 #fcd0ac;
				border-width: 0;
				border-style: solid;
				text-align: left;
			}

	.el-table ::v-deep .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table ::v-deep .el-table__body-wrapper tbody {
				border: 0;
				width: 100%;
			}

	.el-table ::v-deep .el-table__body-wrapper tbody tr {
				border: 0;
				background: none;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: none;
				border-color: #f1cdca;
				border-width: 0px 0px 4px;
				border-style: dotted;
				text-align: left;
			}
	
		
	.el-table ::v-deep .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #666;
				background: none;
				border-color: #e79982;
				border-width: 0px 0px 4px;
				border-style: dotted;
				text-align: left;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: none;
				border-color: #f1cdca;
				border-width: 0px 0px 4px;
				border-style: dotted;
				text-align: left;
			}

	.el-table ::v-deep .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination ::v-deep .el-pagination__total {
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .btn-prev {
				border: 1px solid #fcd0ac;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #fe9000;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .btn-next {
				border: 1px solid #fcd0ac;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #fe9000;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .btn-prev:disabled {
				border: 1px solid #fcd0ac;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #fe9000;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .btn-next:disabled {
				border: 1px solid #fcd0ac;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #fe9000;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination ::v-deep .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination ::v-deep .el-pager .number {
				cursor: pointer;
				border: 1px solid #fcd0ac;
				padding: 0 4px;
				margin: 0 5px;
				color: #fe9000;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #fff;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #f9bba9;
				line-height: 28px;
				border-radius: 2px;
				background: #f9bba9;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #f9bba9;
				line-height: 28px;
				border-radius: 2px;
				background: #f9bba9;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #fcd0ac;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #fe9000;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #fff;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #fe9000;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #333;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #fcd0ac;
				cursor: pointer;
				padding: 0 3px;
				color: #fe9000;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #fff;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
