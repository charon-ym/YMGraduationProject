<template>
  <div class="container" :style="{ margin: '0 200px 20px' }">
    <el-alert
      title="确认支付前请先核对订单信息"
      type="success"
      :closable="false"
    ></el-alert>
    <div class="pay-type-content">
      <div class="pay-type-item">
        <el-radio v-model="type" label="微信支付"></el-radio>
        <img src="@/assets/img/test/weixin.png" alt />
        <!-- <span>微信支付</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="支付宝支付"></el-radio>
        <img src="@/assets/img/test/zhifubao.png" alt />
        <!-- <span>支付宝支付</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="建设银行"></el-radio>
        <img src="@/assets/img/test/jianshe.png" alt />
        <!-- <span>建设银行</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="农业银行"></el-radio>
        <img src="@/assets/img/test/nongye.png" alt />
        <!-- <span>农业银行</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="中国银行"></el-radio>
        <img src="@/assets/img/test/zhongguo.png" alt />
        <!-- <span>中国银行</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="交通银行"></el-radio>
        <img src="@/assets/img/test/jiaotong.png" alt />
        <!-- <span>交通银行</span> -->
      </div>
    </div>
    <div class="buton-content">
      <el-button @click="submitTap" type="primary">确认支付</el-button>
      <el-button @click="back()">返回</el-button>
    </div>
  </div>
</template>
<script>
// import { Message } from "element-ui";
export default {
  data() {
    return {
      name: "",
      account: "",
      type: "",
      table: "",
      obj: "",
      ruleForm: {},
      payForm: {
          name: "",
          account: "",
          type: "",
          amount: "",
          ispay: "",
          payTime: "",
      },
    };
  },
  computed: {
    // 获取 state
        count() {
          return this.$store.state.count
        },
        
  },
  mounted() {
    let table = this.$storage.get("paytable");
    let obj = this.$storage.getObj("payObject");
    this.role = this.$storage.get("role");
    console.log(this.role);
    // 打印payRecords
    console.log("vuex的使用：");
    console.log('count:', this.$store.state.count);
    this.table = table;
    this.obj = obj;

    var table2 = this.$storage.get("sessionTable");
    this.flag = table2;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get",
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
  
      } else {
        this.$message.error(data.msg);
      }
    });
    
  },
  methods: {
    submitTap() {
      this.role = this.$storage.get("role");
      console.log(this.ruleForm);
      // this.payForm = this.ruleForm;
      console.log("支付成功",new Date());

      if (!this.type) {
        this.$message.error("请选择支付方式");
        return;
      }
      this.$confirm(`确定支付?`, "提示", {
  confirmButtonText: "确定",
  cancelButtonText: "取消",
  type: "warning",
}).then(() => {
  // 用户点击“确定” → 显示支付成功
  this.$alert("党费交纳成功", "提示", {
    confirmButtonText: "确定",
    callback: () => {
      const now = new Date();
      const formatted = now.toLocaleString('zh-CN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        hour12: false // 24小时制
      }).replace(/\//g, '-').replace(/,/, '');
      console.log("当前用户数据",this.ruleForm);
      if(this.role === '学生'){
        console.log("学生是对的嘛");
          this.payForm = {
          name: this.ruleForm.xueshengxingming,
          account: this.ruleForm.xueshengzhanghao,
          type: this.type,
          amount: '191',
          ispay:  "已支付",
          payTime: formatted,
        }
      }
      console.log(this.role);
      if(this.role === '教工'){
        console.log("教工是对的嘛");
        this.payForm = {
          name: this.ruleForm.jiaogongxingming,
          account: this.ruleForm.jiaogongzhanghao,
          type: this.type,
          amount: '191',
          ispay:  "已支付",
          payTime: formatted,
        }
      }
      console.log(this.payForm);
      this.$store.commit('addPayRecord', this.payForm);

      console.log("支付成功:",this.$store.state.payRecords);
      // this.$router.go(-1); // 返回上一页
    },
  });
}).catch(() => {
  // 用户点击“取消” → 显示余额不足
  this.$alert("选择支付方式后金额不足", "提示", {
    cancelButtonText: "取消",
  });
});
    },
    back() {
      // this.$router.go(-1);
    },
  },
};
</script>
<style lang="scss" scoped>
.container {
  margin: 10px;
  font-size: 14px;
  span {
    width: 60px;
  }
  .top-content {
    display: flex;
    align-items: center;
    padding: 20px;
  }
  .price-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    padding-bottom: 20px;
    padding: 20px;
    border-bottom: 1px solid #eeeeee;
    font-size: 20px;
    font-weight: bold;
    color: red;
  }
  .pay-type-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    flex-wrap: wrap;
    span {
      width: 100px;
    }
    .pay-type-item {
      display: flex;
      align-items: center;
      justify-content: space-between;
      width: 300px;
      margin: 20px;
      border: 1px solid #eeeeee;
      padding: 20px;
    }
  }
  .buton-content {
    margin: 20px;
  }
}
</style>
