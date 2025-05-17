<template>
  <div class="menu-preview">
    <!-- 横向 -->
    <el-menu
      :unique-opened="true"
      :style="{
        border: 0,
        padding: '0px 40px',
        listStyle: 'none',
        margin: '20px auto 0',
        position: 'relative',
        background: 'rgba(255,255,255,.6)',
      }"
      default-active="0"
      class="el-menu-horizontal-demo"
      mode="horizontal"
    >
      <el-image
        v-if="false"
        :style="{
          width: '44px',
          margin: '8px',
          objectFit: 'cover',
          borderRadius: '100%',
          float: 'left',
          height: '44px',
        }"
        src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"
        fit="cover"
      ></el-image>
      <!-- <el-menu-item index="0" @click="menuHandler('')">
			<i v-if='true' :style='{"verticalAlign":"middle","margin":"0 3px","color":"inherit","textAlign":"center","display":"none","width":"34px","fontSize":"18px"}' class="el-icon-menu el-icon-s-home" />
			<span :style='{"color":"inherit","verticalAlign":"middle","fontSize":"14px"}'>系统首页</span>
		  </el-menu-item> -->

      <el-submenu
        :popper-append-to-body="false"
        index="0"
        @click.native="menuHandler('')"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-s-home"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >系统首页</span
          >
        </template>
      </el-submenu>
      <!-- 交党费模块 -->
      <el-submenu
        v-if="role === '学生' || role === '教工'"
        :popper-append-to-body="false"
        index="0"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-s-home"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >党费管理</span
          >
        </template>
        <el-menu-item index="1-1" @click.native="payPartyDues('')"
          >缴纳党费</el-menu-item
        >
        <el-menu-item index="1-2" @click="paymentRecord('')"
          >缴费记录</el-menu-item
        >
      </el-submenu>

      <el-submenu
        v-if="role === '二级学院' || role === '管理员'"
        :popper-append-to-body="false"
        index="0"
        @click.native="transfer('')"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-s-home"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >关系转接处理</span
          >
        </template>
      </el-submenu>

      <el-submenu
        :popper-append-to-body="false"
        index="10"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-s-home"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >组织活动</span
          >
        </template>
        <el-menu-item index="1-1" @click.native="huodonglist('')"
            >组织活动浏览</el-menu-item
          >
        <el-menu-item v-if="role==='管理员' || role === '二级学院'" index="1-2" @click.native="huodongmanage('')"
            >组织活动管理</el-menu-item
          >
          <el-menu-item v-if="role==='管理员' || role === '二级学院'" index="1-3" @click.native="huodongpulish('')"
            >组织活动发布</el-menu-item
          >
      </el-submenu>

      <el-submenu :popper-append-to-body="false" index="1">
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-user-solid"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >个人中心</span
          >
        </template>
        <el-menu-item index="1-1" @click="menuHandler('updatePassword')"
          >修改密码</el-menu-item
        >
        <el-menu-item index="1-2" @click="menuHandler('center')"
          >个人信息</el-menu-item
        >
      </el-submenu>
      <el-submenu
        :popper-append-to-body="false"
        v-for="(menu, index) in menuList.backMenu"
        :key="menu.menu"
        :index="index + 2 + ''"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu"
            :class="icons[index]"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >{{ menu.menu }}</span
          >
        </template>
        <el-menu-item
          v-for="(child, sort) in menu.child"
          :key="sort"
          :index="index + 2 + '-' + sort"
          @click="menuHandler(child.tableName)"
          >{{ child.menu }}</el-menu-item
        >
      </el-submenu>
      <el-submenu
        v-if="role === '二级学院' || role === '管理员'"
        :popper-append-to-body="false"
        index="0"
        @click.native="readRecord()"
      >
        <template slot="title">
          <i
            v-if="true"
            :style="{
              verticalAlign: 'middle',
              margin: '0 3px',
              color: 'inherit',
              textAlign: 'center',
              display: 'none',
              width: '34px',
              fontSize: '18px',
            }"
            class="el-icon-menu el-icon-s-home"
          />
          <span
            :style="{
              color: 'inherit',
              verticalAlign: 'middle',
              fontSize: '14px',
            }"
            >学习记录</span
          >
        </template>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
      menuList: [],
      dynamicMenuRoutes: [],
      role: "",
      icons: [
        "el-icon-s-cooperation",
        "el-icon-s-order",
        "el-icon-s-platform",
        "el-icon-s-fold",
        "el-icon-s-unfold",
        "el-icon-s-operation",
        "el-icon-s-promotion",
        "el-icon-s-release",
        "el-icon-s-ticket",
        "el-icon-s-management",
        "el-icon-s-open",
        "el-icon-s-shop",
        "el-icon-s-marketing",
        "el-icon-s-flag",
        "el-icon-s-comment",
        "el-icon-s-finance",
        "el-icon-s-claim",
        "el-icon-s-custom",
        "el-icon-s-opportunity",
        "el-icon-s-data",
        "el-icon-s-check",
        "el-icon-s-grid",
        "el-icon-menu",
        "el-icon-chat-dot-square",
        "el-icon-message",
        "el-icon-postcard",
        "el-icon-position",
        "el-icon-microphone",
        "el-icon-close-notification",
        "el-icon-bangzhu",
        "el-icon-time",
        "el-icon-odometer",
        "el-icon-crop",
        "el-icon-aim",
        "el-icon-switch-button",
        "el-icon-full-screen",
        "el-icon-copy-document",
        "el-icon-mic",
        "el-icon-stopwatch",
      ],
      menulistBorderBottom: {},
    };
  },
  mounted() {
    const menus = menu.list();
    if (menus) {
      this.menuList = menus;
    } else {
      let params = {
        page: 1,
        limit: 1,
        sort: "id",
      };

      this.$http({
        url: "menu/list",
        method: "get",
        params: params,
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.menuList = JSON.parse(data.data.list[0].menujson);

          this.$storage.set("menus", this.menuList);
        }
      });
    }
    this.role = this.$storage.get("role");
    console.log(this.role);

    for (let i = 0; i < this.menuList.length; i++) {
      if (this.menuList[i].roleName == this.role) {
        this.menuList = this.menuList[i];
        break;
      }
    }
    this.styleChange();
  },
  created() {
    this.icons.sort(() => {
      return 0.5 - Math.random();
    });
  },
  methods: {
    styleChange() {
      this.$nextTick(() => {
        document
          .querySelectorAll(".el-menu-horizontal-demo .el-submenu .el-menu")
          .forEach((el) => {
            el.removeAttribute("style");
            const icon = {
              border: "1px solid #ddd",
              padding: "0",
              margin: "0",
            };
            Object.keys(icon).forEach((key) => {
              el.style[key] = icon[key];
            });
          });
      });
    },
    menuHandler(name) {
      let router = this.$router;
      name = "/" + name;
      console.log(name);
      router.push(name);
    },
    transfer() {
      this.$router.push({ path: "/transfer" });
    },
    payPartyDues() {
      console.log(this.role);
      console.log("缴纳党费成功");
      this.$storage.set("pageFlag", "pay");
      this.$router.push({ path: "/pay" });
    },
    paymentRecord() {
      console.log("你已经缴费");
      this.$storage.set("pageFlag", "pay");
      this.$router.push({ path: "/payrecord" });
    },
    readRecord() {
      console.log("查看学习记录");
      this.$storage.set("pageFlag", "pay");
      this.$router.push({ path: "/studyrecord" });
    },
    huodonglist() {
      console.log("查看组织活动");
      // this.$storage.set("pageFlag", "pay");
      this.$router.push({ path: "/huodonglist" });
    },
    huodongmanage(){
      this.$router.push({ path: "/huodongmanage" });
    },
    huodongpulish(){
      this.$router.push({ path: "/huodongpulish" });
    }
  },
};
</script>
<style lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & ::v-deep .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
		
			  }
	  	  // --- 横向 ---
	  .el-menu-horizontal-demo {
	    .el-submenu:first-of-type ::v-deep .el-submenu__title .el-submenu__icon-arrow {
	      display: none;
	    }
	  }
	  
	  .el-menu-horizontal-demo>.el-menu-item {
		  		  border: 0;
		  		  cursor: pointer;
		  		  padding: 0px 30px 0px 30px;
		  		  color: #555;
		  		  white-space: nowrap;
		  		  background: url(http://codegen.caihongy.cn/20230215/9570c51990754731a71614eb6af13706.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230215/89c95b0d956b4a5badeb8bee368f62c5.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230215/e0b47b66b4f34b13b2fa88799c815eca.png) repeat-x center top / auto 100%;
		  		  font-size: 14px;
		  		  line-height: 50px;
		  		  list-style: none;
		  		  text-align: center;
		  		  min-width: 150px;
		  		  height: 50px;
		  	  }
	  
	  .el-menu-horizontal-demo>.el-menu-item:hover {
	  		  	color: #555;
	  		  	background: url(http://codegen.caihongy.cn/20230215/899443df91a7410f92b2d30ef8af3d42.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230215/b515d244a4404bbd85aad5c87f6a5fd5.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230215/5937f1f6097443778a6d1155c5d50359.png) repeat-x center top / auto 100%;
	  		  }
	  
	  .el-menu-horizontal-demo .el-submenu {
		  		  padding: 0;
		  		  margin: 0 10px 10px 0;
		  		  float: left;
		  		  list-style: none;
		  	  }
	  
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-submenu__title {
	  		  	border: 0;
	  		  	cursor: pointer;
	  		  	padding: 0px 30px 0px 30px;
	  		  	color: #555;
	  		  	white-space: nowrap;
	  		  	background: url(http://codegen.caihongy.cn/20230215/9570c51990754731a71614eb6af13706.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230215/89c95b0d956b4a5badeb8bee368f62c5.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230215/e0b47b66b4f34b13b2fa88799c815eca.png) repeat-x center top / auto 100%;
	  		  	font-size: 14px;
	  		  	line-height: 50px;
	  		  	list-style: none;
	  		  	text-align: center;
	  		  	min-width: 150px;
	  		  	height: 50px;
	  		  }
	  
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-submenu__title:hover {
	  		  	color: #555;
	  		  	background: url(http://codegen.caihongy.cn/20230215/899443df91a7410f92b2d30ef8af3d42.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230215/b515d244a4404bbd85aad5c87f6a5fd5.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230215/5937f1f6097443778a6d1155c5d50359.png) repeat-x center top / auto 100%;
	  		  }
	  
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-submenu__title .el-submenu__icon-arrow {
	  		  	margin: -3px 0 0 8px;
	  		  	color: inherit;
	  		  	vertical-align: middle;
	  		  	font-size: 12px;
	  		  	position: static;
	  		  }
	  // .el-menu-horizontal-demo .el-submenu ::v-deep .el-menu {
	  // 		  // 	border: 1px solid #ddd;
	  // 		  // 	padding: 0;
	  // 		  // 	margin: 0;
	  // 		  // } 
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-menu .el-menu-item {
	  		  	padding: 0 10px;
	  		  	color: #666;
	  		  	background: #fff;
	  		  	border-color: #ddd;
	  		  	border-width: 0 0 1px;
	  		  	line-height: 40px;
	  		  	border-style: solid;
	  		  	height: 40px;
	  		  }
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-menu .el-menu-item:hover {
	  		  	padding: 0 10px;
	  		  	color: #333;
	  		  	background: #eee;
	  		  	line-height: 40px;
	  		  	height: 40px;
	  		  }
	  .el-menu-horizontal-demo .el-submenu ::v-deep .el-menu .el-menu-item.is-active {
	  		  	padding: 0 10px;
	  		  	color: #333;
	  		  	background: #eee;
	  		  	line-height: 40px;
	  		  	height: 40px;
	  		  }
	  // --- 横向 ---
	  	}
</style>
