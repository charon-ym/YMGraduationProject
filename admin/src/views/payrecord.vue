<template>
  <div class="container" :style="{ margin: '0 200px 20px' }">
    <el-alert title="缴费记录" type="info" :closable="false"></el-alert>
    <el-table
      :data="records"
      stripe
      border
      style="width: 100%; margin-top: 20px"
    >
      <el-table-column prop="name" label="姓名" width="120"></el-table-column>
      <el-table-column
        prop="account"
        label="账号"
        width="200"
      ></el-table-column>
      <el-table-column
        prop="type"
        label="支付方式"
        width="150"
      ></el-table-column>
      <el-table-column prop="amount" label="金额" width="100"></el-table-column>
      <el-table-column prop="ispay" label="支付状态" width="120">
        <template v-slot="scope">
          <el-tag :type="scope.row.ispay === '已支付' ? 'success' : 'warning'">
            {{ scope.row.ispay }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="payTime" label="支付时间"></el-table-column>
    </el-table>

    <div class="button-content">
      <el-button @click="back()" style="margin-top: 20px">返回</el-button>
    </div>
  </div>
</template>
  
  <script>
export default {
  data() {
    return {
      records: [
        {
          name: "教工",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-01-15 09:16",
        },
        {
          name: "教工",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-02-10 14:21",
        },
        {
          name: "教工",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-03-13 11:36",
        },
        {
          name: "教工",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-04-11 17:21",
        },
      ], // 存放缴费记录列表
      ruleForm:{}
    };
  },
  mounted() {
    var table2 = this.$storage.get("sessionTable");
    console.log(table2)
    this.flag = table2;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get",
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
        this.loadRecords();
        
      } else {
        this.$message.error(data.msg);
      }
    });

    
  },
  methods: {
    loadRecords() {
        console.log(this.ruleForm)
      // 这里假设从 paytable 表中获取所有记录
    //   let table = this.$storage.get("paytable") || "paytable"; // 默认值，防止为空
    //   console.log(table);
    
      
      //     this.$http({
      //       url: `${table}/list`,
      //       method: "get",
      //       params: {
      //         page: 1,
      //         limit: 100  // 拉取最多100条记录，可按需调整
      //       }
      //     }).then(({ data }) => {
      //       if (data && data.code === 0) {
      //         this.records = data.data.list || [];
      //       } else {
      //         this.$message.error(data.msg || "加载记录失败");
      //       }
      //     }).catch(() => {
      //       this.$message.error("服务器异常，无法加载缴费记录");
      //     });
    },
    back() {
      this.$router.go(-1);
    },
  },
};
</script>
  
  <style lang="scss" scoped>
.container {
  margin: 10px;
  font-size: 14px;
  .button-content {
    text-align: center;
  }
}
</style>
  