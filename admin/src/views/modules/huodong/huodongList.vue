<template>
    <div>
      <el-page-header content="组织活动浏览" style="margin-bottom: 20px;" />
  
      <el-card v-for="item in currentPageData" :key="item.id" class="mb-3">
        <h3>{{ item.title }}</h3>
        <p>{{ item.content }}</p>
        <p>
          <el-icon></el-icon> 活动时间：{{ item.date }}<br />
          <el-icon></el-icon> 活动地点：{{ item.location }}
        </p>
        <el-tag type="info">发布人：{{ item.publisher }}</el-tag>
        <div style="margin-top: 10px">
          <el-button
            type="primary"
            size="small"
            :disabled="joinedIds.includes(item.id)"
            @click="join(item.id)"
          >
            {{ joinedIds.includes(item.id) ? "已参加" : "参加" }}
          </el-button>
        </div>
      </el-card>
  
      <el-pagination
        layout="prev, pager, next"
        :page-size="pageSize"
        :total="huodongList.length"
        @current-change="changePage"
        class="text-center"
      />
    </div>
  </template>
  
  <script>
//   import { ElMessage } from "element-plus";
//   import { Calendar, Location } from "@element-plus/icons-vue";
  
  export default {

    data() {
      return {
        huodongList: [
          {
            id: 1,
            title: "组织生活会",
            content: "加强理论学习，提升政治素养...",
            publisher: "党支部A",
            date: "2025-04-10",
            location: "思政楼105",
          },
          {
            id: 2,
            title: "志愿服务活动",
            content: "前往敬老院为老人提供服务...",
            publisher: "二级学院B",
            date: "2025-05-01",
            location: "幸福养老院",
          },
          {
            id: 3,
            title: "党建培训",
            content: "邀请党委讲师开展党建培训...",
            publisher: "组织部",
            date: "2025-05-06",
            location: "行政楼301",
          },
        ],
        joinedIds: [],
        pageSize: 2,
        currentPage: 1,
      };
    },
    computed: {
      currentPageData() {
        const start = (this.currentPage - 1) * this.pageSize;
        return this.huodongList.slice(start, start + this.pageSize);
      },
    },
    methods: {
      join(id) {
        if (!this.joinedIds.includes(id)) {
          this.joinedIds.push(id);
        //   ElMessage.success(`已成功报名活动 ID：${id}`);
          // TODO: 可接入 axios.post('/api/huodong/join', { id })
        }
      },
      changePage(val) {
        this.currentPage = val;
      },
    },
  };
  </script>
  
  <style scoped>
  .mb-3 {
    margin-bottom: 20px;
  }
  .text-center {
    text-align: center;
    margin-top: 20px;
  }
  </style>
  