<template>
  <div :style='{"padding":"0 0 200px","flexWrap":"wrap","background":"none","display":"flex"}'>
    <el-form
	  :style='{"padding":"30px 40px","boxShadow":"0 0px 0px #999","borderRadius":"6px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="150px"
    >  
     <el-row>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='xuesheng'"  label="学生账号" prop="xueshengzhanghao">
          <el-input v-model="ruleForm.xueshengzhanghao" readonly              placeholder="学生账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='xuesheng'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming"               placeholder="学生姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='xuesheng'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in xueshengxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='xuesheng'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="xueshengtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='xuesheng'"  label="班级" prop="banji">
          <el-input v-model="ruleForm.banji"               placeholder="班级" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='xuesheng'"  label="学生电话" prop="xueshengdianhua">
          <el-input v-model="ruleForm.xueshengdianhua"               placeholder="学生电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='xuesheng'"  label="身份" prop="shenfen">
          <el-input v-model="ruleForm.shenfen" readonly              placeholder="身份" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='jiaogong'"  label="教工账号" prop="jiaogongzhanghao">
          <el-input v-model="ruleForm.jiaogongzhanghao" readonly              placeholder="教工账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='jiaogong'"  label="教工姓名" prop="jiaogongxingming">
          <el-input v-model="ruleForm.jiaogongxingming"               placeholder="教工姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='jiaogong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in jiaogongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='jiaogong'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="jiaogongtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='jiaogong'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='jiaogong'"  label="身份" prop="shenfen">
          <el-input v-model="ruleForm.shenfen" readonly              placeholder="身份" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='erjixueyuan'"  label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='erjixueyuan'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='erjixueyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in erjixueyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}'   v-if="flag=='erjixueyuan'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi"               placeholder="联系方式" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='erjixueyuan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="erjixueyuantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0px solid #40ecde","cursor":"pointer","padding":"0 20px 0 40px","boxShadow":"0px 16px 9px -12px #aaa","margin":"20px 20px 0 0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"30px","background":"url(http://codegen.caihongy.cn/20221217/9516b0de6d644d9cb181babab8b1ea92.png) no-repeat 16px,linear-gradient(270deg, rgba(238,149,42,1) 0%, rgba(205,55,10,1) 100%)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      xueshengxingbieOptions: [],
      jiaogongxingbieOptions: [],
      erjixueyuanxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
        console.log(this.ruleForm)
      } else {
        this.$message.error(data.msg);
      }
    });
    this.xueshengxingbieOptions = "男,女".split(',')
    this.jiaogongxingbieOptions = "男,女".split(',')
    this.erjixueyuanxingbieOptions = "男,女".split(',')
  },
  methods: {
    xueshengtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    jiaogongtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    erjixueyuantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.xueshengzhanghao)&& 'xuesheng'==this.flag){
        this.$message.error('学生账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'xuesheng'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.xueshengxingming)&& 'xuesheng'==this.flag){
        this.$message.error('学生姓名不能为空');
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'xuesheng' ==this.flag && this.ruleForm.xueshengdianhua&&(!isMobile(this.ruleForm.xueshengdianhua))){
        this.$message.error(`学生电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.jiaogongzhanghao)&& 'jiaogong'==this.flag){
        this.$message.error('教工账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'jiaogong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.jiaogongxingming)&& 'jiaogong'==this.flag){
        this.$message.error('教工姓名不能为空');
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'jiaogong' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.zhanghao)&& 'erjixueyuan'==this.flag){
        this.$message.error('账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'erjixueyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.xingming)&& 'erjixueyuan'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
      if( 'erjixueyuan' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
        this.$message.error(`联系方式应输入手机格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  text-shadow: 0 1px 10px #fff;
	  	  color: #666;
	  	  background: none;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  	  border: 1px solid #f3ce9d;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  display: inline-block;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  	  border: 1px solid #f3ce9d;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  	  border: 1px solid #f3ce9d;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #f3ce9d;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  	  border: 1px solid #f3ce9d;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  	  border: 1px solid #f3ce9d;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: 98%;
	  	  font-size: 14px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
