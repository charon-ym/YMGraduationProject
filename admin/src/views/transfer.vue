<template>
  <div
    class="main-content"
    :style="{
      padding: '0 0 200px',
      flexWrap: 'wrap',
      background: 'none',
      display: 'flex',
    }"
  >
    <!-- 列表页面 -->
    <template v-if="showFlag">
      <el-form
        class="center-form-pv"
        :style="{
          width: '100%',
          padding: '0',
          margin: '0px 40px 0px',
          flexWrap: 'wrap',
          background: 'none',
          display: 'flex',
        }"
        :inline="true"
        :model="searchForm"
      >
        <el-row
          :style="{
            width: '100%',
            padding: '0px 0 30px',
            flexWrap: 'wrap',
            background:
              'linear-gradient(180deg, rgba(255,255,255,0) 0%, rgba(255,230,223,.3) 80%, rgba(255,129,93,1) 100%)',
            justifyContent: 'center',
            display: 'flex',
          }"
        >
          <div :style="{ margin: '0 10px 0 0', display: 'inline-block' }">
            <label
              :style="{
                margin: '0 10px 0 0',
                color: '#333',
                display: 'inline-block',
                lineHeight: '40px',
                fontSize: '14px',
                fontWeight: '500',
                height: '40px', 
              }"
              >原关系人姓名</label
            >
            <el-input
              v-model="searchForm.oldName"
              placeholder="原关系人姓名"
              clearable
            ></el-input>
          </div>

          <div :style="{ margin: '0 10px 0 0', display: 'inline-block' }">
            <label
              :style="{
                margin: '0 10px 0 0',
                color: '#333',
                display: 'inline-block',
                lineHeight: '40px',
                fontSize: '14px',
                fontWeight: '500',
                height: '40px',
              }"
              >新关系人姓名</label
            >
            <el-input
              v-model="searchForm.newName"
              placeholder="新关系人姓名"
              clearable
            ></el-input>
          </div>

          <el-button
            :style="{
              border: '0px solid #999',
              cursor: 'pointer',
              padding: '0px',
              boxShadow: '0px 0px 0px #ccc',
              outline: 'none',
              margin: '0 0 0 10px',
              color: '#fff',
              borderRadius: '4px',
              background:
                'url(http://codegen.caihongy.cn/20230215/f3cc6b6274624f66a5a14667d6f68181.png) no-repeat center top / 100% 100%,#fe9000',
              width: '185px',
              fontSize: '14px',
              height: '44px',
            }"
            type="success"
            @click="search()"
            >查询</el-button
          >
        </el-row>

        <el-row
          :style="{
            padding: '30px 0 0',
            margin: '0 0px 24px',
            flexWrap: 'wrap',
            background:
              'linear-gradient(0deg, rgba(255,255,255,0) 0%, rgba(255,230,223,.6) 80%, rgba(205,55,10,.9) 100%)',
            display: 'flex',
            width: '100%',
            justifyContent: 'center',
          }"
        >
          <!-- <el-button :style='{"cursor":"pointer","padding":"0 16px","boxShadow":"1px 2px 4px #9acfea","margin":"0 10px 4px 0","borderColor":"#1d90ff","color":"#1d90ff","background":"#fff","borderRadius":"4px","borderWidth":"0 0 4px","borderStyle":"solid","fontSize":"14px","height":"40px"}' v-if="isAuth('guanxizhuanjie','新增')" @click="addOrUpdateHandler()">新增</el-button>
  
            <el-button :style='{"cursor":"pointer","padding":"0 16px","boxShadow":"1px 2px 4px #ea9a9a","margin":"0 10px 0 0","borderColor":"#ff4d4f","color":"#ff4d4f","background":"#fff","borderRadius":"4px","borderWidth":"0 0 4px","borderStyle":"solid","fontSize":"14px","height":"40px"}' v-if="isAuth('guanxizhuanjie','删除')" :disabled="dataListSelections.length <= 0" @click="deleteHandler()">删除</el-button>
   -->
        </el-row>
      </el-form>

      <!-- 表格 -->
      <el-table
        class="tables"
        :stripe="false"
        :style="{
          padding: '0',
          borderColor: '#e6a491 #d37a61 #cd370a',
          margin: '0 50px 20px',
          borderRadius: '0px',
          borderWidth: '8px',
          background: '#fff',
          width: 'calc(100% - 80px)',
          borderStyle: 'solid',
        }"
        :data="dataList"
        v-loading="dataListLoading"
        @selection-change="selectionChangeHandler"
      >
        <el-table-column
          type="selection"
          align="center"
          width="50"
        ></el-table-column>
        <el-table-column type="index" label="序号" width="50" />
        <el-table-column prop="Name" label="姓名"></el-table-column>
        <el-table-column prop="account" label="账号"></el-table-column>
        <el-table-column prop="tel" label="电话"></el-table-column>
        <el-table-column prop="oldName" label="原组织"></el-table-column>
        <el-table-column
          prop="oldContact"
          label="原组织联系方式"
        ></el-table-column>
        <el-table-column prop="newName" label="新组织"></el-table-column>
        <el-table-column
          prop="newContact"
          label="新组织联系方式"
        ></el-table-column>
        <el-table-column prop="transferDate" label="转接时间"></el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="shenhe_huifu"
          label="审核回复"
        ></el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          prop="shenhe_zhuangtai"
          label="审核状态"
        >
          <template slot-scope="scope">
            <span style="margin-right: 10px;color: #67C23A;font-weight: bold;" v-if="scope.row.shenhe_zhuangtai === '是'"
              >通过</span
            >
            <span style="margin-right: 10px;color: #F56C6C;font-weight: bold;" v-if="scope.row.shenhe_zhuangtai == '否'"
              >未通过</span
            >
            <span style="margin-right: 10px;color: #E6A23C;font-weight: bold;" v-if="scope.row.shenhe_zhuangtai == '待审核'"
              >待审核</span
            >
          </template>
        </el-table-column>
        <el-table-column
          :resizable="true"
          :sortable="false"
          v-if="isAuth('xueshengrudang', '审核')"
          prop="shenhe_zhuangtai"
          label="审核"
        >
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="shDialog(scope.row)"
              >审核</el-button
            >
          </template>
        </el-table-column>
        <el-table-column width="100" label="操作">
          <template slot-scope="scope">
            <el-button
              :style="{
                cursor: 'pointer',
                padding: '6px 10px',
                margin: '3px 6px 3px 0',
                borderColor: '#cff296 #6bad01 #63a100',
                color: '#6bad01',
                outline: 'none',
                borderRadius: '20px',
                background: '#fff',
                borderWidth: '1px 1px 4px',
                width: 'auto',
                fontSize: '14px',
                borderStyle: 'solid',
                textShadow: '0 0px 0 rgba(0,0,0,.25)',
                height: '32px',
              }"
              v-if="isAuth('xueshengrudang', '查看')"
              type="success"
              size="mini"
              
              @click="addOrUpdateHandler(scope.row.id, 'info')"
              >详情</el-button
            >
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
        :style="{
          padding: '0 40px',
          margin: '20px 0 0',
          textAlign: 'center',
          fontWeight: '500',
        }"
      ></el-pagination>
    </template>

    <!-- 新增/修改子页面 -->
    <!-- <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update> -->

    <el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.jieguo" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.neirong"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="shDialog">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</span>
		</el-dialog>
  </div>
</template>
  
  <script>
//   import AddOrUpdate from "./add-or-update";
export default {
  // components: { AddOrUpdate },
  data() {
    return {
      searchForm: {
        oldName: "",
        newName: "",
      },
      shForm: {
        jieguo:"",
        neirong:""

      },
      dataList: [],
      sfshVisiable: false,
      currentRow: null, // 当前审核的行
      dataListSelections: [],
      dataListLoading: false,
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      showFlag: true,
      addOrUpdateFlag: false,
      layouts: ["total", "prev", "pager", "next", "sizes", "jumper"],
    };
  },
  created() {
    this.getDataList();
  },
  methods: {
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    getDataList() {
      this.dataList = [
        {
          Name:"王sd1",
          account:"用户1",
          tel:"13712340001",
          oldName: "张三",
          oldContact: "13812340001",
          newName: "李四",
          newContact: "13912340001",
          transferDate: "2025-04-20 10:00:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd2",
            account:"用户2",
          tel:"13712340002",
          oldName: "王五",
          oldContact: "13812340002",
          newName: "赵六",
          newContact: "13912340002",
          transferDate: "2025-04-21 11:30:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "否",
        },
        {
            Name:"王sd3",
            account:"用户3",
          tel:"13712340003",
          oldName: "孙七",
          oldContact: "13812340003",
          newName: "周八",
          newContact: "13912340003",
          transferDate: "2025-04-22 09:15:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "待审核",
        },
        {
            Name:"王sd4",
            account:"用户4",
          tel:"13712340004",
          oldName: "吴九",
          oldContact: "13812340004",
          newName: "郑十",
          newContact: "13912340004",
          transferDate: "2025-04-23 14:45:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd5",
            account:"用户5",
          tel:"13712340005",
          oldName: "钱一",
          oldContact: "13812340005",
          newName: "孙二",
          newContact: "13912340005",
          transferDate: "2025-04-24 16:20:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd6",
            account:"用户6",
          tel:"13712340006",
          oldName: "李三",
          oldContact: "13812340006",
          newName: "王四",
          newContact: "13912340006",
          transferDate: "2025-04-25 08:50:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd7",
            account:"用户7",
          tel:"13712340007",
          oldName: "赵五",
          oldContact: "13812340007",
          newName: "钱六",
          newContact: "13912340007",
          transferDate: "2025-04-26 12:10:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd8",
            account:"用户8",
          tel:"13712340008",
          oldName: "周七",
          oldContact: "13812340008",
          newName: "吴八",
          newContact: "13912340008",
          transferDate: "2025-04-27 17:30:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd9",
            account:"用户9",
          tel:"13712340009",
          oldName: "郑九",
          oldContact: "13812340009",
          newName: "冯十",
          newContact: "13912340009",
          transferDate: "2025-04-28 13:00:00",

          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
        {
            Name:"王sd10",
            account:"用户10",
          tel:"13712340010",
          oldName: "陈一",
          oldContact: "13812340010",
          newName: "褚二",
          newContact: "13912340010",
          transferDate: "2025-04-29 15:40:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
        },
      ];

      //     this.dataListLoading = true;
      //     let params = {
      //       page: this.pageIndex,
      //       limit: this.pageSize,
      //       oldName: this.searchForm.oldName,
      //       newName: this.searchForm.newName
      //     };
      //     this.$http({ url: "guanxizhuanjie/page", method: "get", params })
      //       .then(({ data }) => {
      //         if (data.code === 0) {
      //           this.dataList = data.data.list;
      //           this.totalPage = data.data.total;
      //         } else {
      //           this.dataList = [];
      //           this.totalPage = 0;
      //         }
      //         this.dataListLoading = false;
      //       });
    },
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    addOrUpdateHandler(id, type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id, type || "edit");
      });
    },
    deleteHandler(id) {
      const ids = id ? [id] : this.dataListSelections.map((item) => item.id);
      this.$confirm(`确定要删除所选记录？`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.$http({
          url: "guanxizhuanjie/delete",
          method: "post",
          data: ids,
        }).then(({ data }) => {
          if (data.code === 0) {
            this.$message.success("删除成功");
            this.search();
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // 审核
    shHandler(){
        console.log("审核成功",this.shForm)
        if (!this.currentRow) return;
        // 更新当前行数据
        console.log(this.dataList)
        this.currentRow.shenhe_zhuangtai = this.shForm.jieguo;
        this.currentRow.shenhe_neirong = this.shForm.neirong;
        console.log(this.dataList)
        this.sfshVisiable = false

    },
    // 审核窗口
    shDialog(row) {
      this.sfshVisiable = !this.sfshVisiable;
      this.currentRow = row;
      console.log(row)
      this.shForm = {
      jieguo: row.shenhe_zhuangtai || '待审核',
      neirong: row.shenhe_neirong || ''
    };

    //   if (row) {
    //     this.shForm = {
    //       shenqingbianhao: row.shenqingbianhao,
    //       zuzhimingcheng: row.zuzhimingcheng,
    //       zuzhidizhi: row.zuzhidizhi,
    //       cailiao: row.cailiao,
    //       xueqi: row.xueqi,
    //       xuexipaiming: row.xuexipaiming,
    //       shenqingshijian: row.shenqingshijian,
    //       xueshengzhanghao: row.xueshengzhanghao,
    //       xueshengxingming: row.xueshengxingming,
    //       banji: row.banji,
    //       shenfen: row.shenfen,
    //       shenqingneirong: row.shenqingneirong,
    //       sfsh: row.sfsh,
    //       shhf: row.shhf,
    //       id: row.id,
    //     };
    //   }
    },
    isAuth(module, action) {
      // 权限判断函数，实际项目中替换
      return true;
    },
  },
};
</script>
  
  <style lang="scss" scoped>
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
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
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
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
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
  box-shadow: 0 0 0px rgba(64, 158, 255, 0.5);
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
  background: linear-gradient(
    270deg,
    rgba(238, 149, 42, 1) 0%,
    rgba(205, 55, 10, 1) 100%
  );
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

.main-content
  .el-pagination
  ::v-deep
  .el-pagination__sizes
  .el-input
  .el-input__inner {
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

.main-content
  .el-pagination
  ::v-deep
  .el-pagination__sizes
  .el-input
  span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

.main-content
  .el-pagination
  ::v-deep
  .el-pagination__sizes
  .el-input
  .el-input__suffix
  .el-select__caret {
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

.main-content
  .el-pagination
  ::v-deep
  .el-pagination__jump
  .el-input
  .el-input__inner {
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
