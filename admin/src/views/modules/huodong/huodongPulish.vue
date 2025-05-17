  
<template>
    <el-card>
      <el-page-header content="发布组织活动" class="mb-4" />
  
      <el-form
        :model="form"
        :rules="rules"
        ref="formRef"
        label-width="100px"
        size="default"
      >
        <el-form-item label="活动标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入活动标题" />
        </el-form-item>
  
        <el-form-item label="活动内容" prop="content">
          <el-input
            type="textarea"
            v-model="form.content"
            placeholder="请输入活动说明"
            rows="4"
          />
        </el-form-item>
  
        <el-form-item label="活动时间" prop="date">
          <el-date-picker
            v-model="form.date"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择活动时间"
          />
        </el-form-item>
  
        <el-form-item label="活动地点" prop="location">
          <el-input v-model="form.location" placeholder="请输入活动地点" />
        </el-form-item>
  
        <el-form-item label="发布单位" prop="publisher">
          <el-select v-model="form.publisher" placeholder="选择发布单位">
            <el-option label="党支部A" value="党支部A" />
            <el-option label="二级学院B" value="二级学院B" />
            <el-option label="组织部" value="组织部" />
          </el-select>
        </el-form-item>
  
        <el-form-item>
          <el-button type="primary" @click="submit">提交发布</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </template>
  
  <script>
  export default {
    data() {
      return {
        form: {
          title: "",
          content: "",
          date: "",
          location: "",
          publisher: "",
        },
        rules: {
          title: [{ required: true, message: "请输入标题", trigger: "blur" }],
          content: [{ required: true, message: "请输入内容", trigger: "blur" }],
          date: [{ required: true, message: "请选择时间", trigger: "change" }],
          location: [{ required: true, message: "请输入地点", trigger: "blur" }],
          publisher: [{ required: true, message: "请选择发布单位", trigger: "change" }],
        },
      };
    },
    methods: {
      submit() {
        this.$refs.formRef.validate((valid) => {
          if (valid) {
            // 模拟提交，可以替换成 axios.post('/api/huodong/save', this.form)
            this.$message.success("活动发布成功");
            console.log("提交表单内容：", this.form);
            // this.reset();
          } else {
            this.$message.error("请完整填写表单");
            return false;
          }
        });
      },
      reset() {
        this.$refs.formRef.resetFields();
      },
    },
  };
  </script>
  
  <style scoped>
  .mb-4 {
    margin-bottom: 24px;
  }
  </style>
  