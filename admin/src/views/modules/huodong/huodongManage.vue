<template>
    <el-card>
      <el-page-header content="活动管理" class="mb-4" />
      
      <el-table
        :data="huodongList"
        border
        style="width: 100%"
      >
        <el-table-column prop="title" label="标题" />
        <el-table-column prop="publisher" label="发布单位" />
        <el-table-column prop="date" label="时间" />
        <el-table-column prop="location" label="地点" />
        <el-table-column label="操作" width="180">
          <template #default="{ row }">
            <el-button size="small" @click="edit(row)">编辑</el-button>
            <el-button size="small" type="danger" @click="confirmDel(row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <el-pagination
        class="mt-4"
        background
        layout="prev, pager, next"
        :total="huodongList.length"
        :page-size="5"
      />
    </el-card>
  </template>
  
  <script>
  export default {
    data() {
      return {
        huodongList: [
          {
            id: 1,
            title: "组织生活会",
            publisher: "党支部A",
            date: "2025-05-01 09:00",
            location: "教学楼A101"
          },
          {
            id: 2,
            title: "志愿服务活动",
            publisher: "学院X",
            date: "2025-05-05 14:00",
            location: "社区敬老院"
          }
        ]
      };
    },
    methods: {
      edit(row) {
        // 可以跳转到编辑页面或弹窗
        this.$message.info(`编辑活动：${row.title}（模拟）`);
        // this.$router.push({ name: 'HuodongEdit', query: { id: row.id } });
      },
      confirmDel(id) {
        this.$confirm('确定要删除该活动吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.del(id);
        }).catch(() => {
          this.$message.info('已取消删除');
        });
      },
      del(id) {
        this.huodongList = this.huodongList.filter(item => item.id !== id);
        this.$message.success(`已删除活动 ID：${id}（模拟）`);
      }
    }
  };
  </script>
  
  <style scoped>
  .mb-4 {
    margin-bottom: 24px;
  }
  .mt-4 {
    margin-top: 20px;
  }
  </style>
  