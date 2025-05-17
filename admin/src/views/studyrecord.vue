<template>
  <div class="container" :style="{ margin: '0 100px 20px' }">
    <el-alert title="学习记录" type="info" :closable="false"></el-alert>
    <el-table
      :data="records"
      stripe
      border
      style="width: 100%; margin-top: 20px"
    >
    <el-table-column type="index" label="序号" width="60" />
      <el-table-column prop="name" label="姓名" width="150"></el-table-column>
      <el-table-column
        prop="account"
        label="账号"
        width="200"
      ></el-table-column>
      <el-table-column
        prop="type"
        label="用户类型"
        width="150"
      ></el-table-column>
      <el-table-column prop="title" label="标题" width="150"></el-table-column>
      
      <el-table-column prop="id" label="id" width="150">
      </el-table-column>
      <el-table-column prop="studyTime" label="学习时间"></el-table-column>
      <el-table-column prop="unit" label="发布单位" width="150" />
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
          name: "学生",
          account: "学生账号1",
          type: "学生",
          title: "文章标题",
          id: "文章id",
          studyTime: "2025-04-28 14:00",
          unit:"组织名称8"
        },
      ], // 存放缴费记录列表
      ruleForm: {},
    };
  },
  mounted() {
    var table2 = this.$storage.get("sessionTable");
    console.log(table2);
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
      console.log(this.ruleForm);
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
    