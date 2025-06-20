<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","padding":"210px 0 210px","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230215/d4dc8ceea34b422aa24289ba152f557b.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20230214/c40bf62556ca43b7a29ed0b2e8d23a68.png) no-repeat center bottom,#fff","display":"flex","width":"100%","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"10px solid #f4ca93","padding":"0 0 40px","margin":"0px 0 0px 0","borderRadius":"0px","background":"#fff","width":"800px","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"margin":"20px auto 20px","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230215/84a340a9e2e2435cbca947c7ccd12820.png) no-repeat left top / auto 100%,linear-gradient(120deg, rgba(238,149,42,1) 0%, rgba(205,55,10,1) 100%)","width":"86%","lineHeight":"44px","fontSize":"16px"}' class="title">高校党建基本数据管理系统的设计与实现注册</div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学生账号</div>
					<el-input  v-model="ruleForm.xueshengzhanghao"  autocomplete="off" placeholder="学生账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学生姓名</div>
					<el-input  v-model="ruleForm.xueshengxingming"  autocomplete="off" placeholder="学生姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in xueshengxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="xueshengtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">班级</div>
					<el-input  v-model="ruleForm.banji"  autocomplete="off" placeholder="班级"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">学生电话</div>
					<el-input  v-model="ruleForm.xueshengdianhua"  autocomplete="off" placeholder="学生电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xuesheng'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">身份</div>
					<el-input  v-model="ruleForm.shenfen" readonly autocomplete="off" placeholder="身份"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">教工账号</div>
					<el-input  v-model="ruleForm.jiaogongzhanghao"  autocomplete="off" placeholder="教工账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">教工姓名</div>
					<el-input  v-model="ruleForm.jiaogongxingming"  autocomplete="off" placeholder="教工姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in jiaogongxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="jiaogongtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系电话</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaogong'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">身份</div>
					<el-input  v-model="ruleForm.shenfen" readonly autocomplete="off" placeholder="身份"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">账号</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">姓名</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in erjixueyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">联系方式</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 4px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='erjixueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="erjixueyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0px solid #f4ca93","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","color":"#fff","bottom":"50%","display":"block","minWidth":"200px","right":"-240px","outline":"none","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230215/f3cc6b6274624f66a5a14667d6f68181.png) no-repeat center top / 100% 100%,#fe9000","width":"auto","fontSize":"16px","position":"absolute","height":"44px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"20px auto 0","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"block","width":"80%","lineHeight":"1","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
                xingbie: '',
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            xueshengxingbieOptions: [],
            jiaogongxingbieOptions: [],
            erjixueyuanxingbieOptions: [],
		};  
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.xueshengxingbieOptions = "男,女".split(',')
        this.jiaogongxingbieOptions = "男,女".split(',')
        this.erjixueyuanxingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        xueshengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiaogongtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        erjixueyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.xueshengzhanghao) && `xuesheng` == this.tableName){
						this.$message.error(`学生账号不能为空`);
						return
					}			
					if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `xuesheng` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
						this.$message.error(`学生姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`xuesheng` == this.tableName && this.ruleForm.xueshengdianhua&&(!this.$validate.isMobile(this.ruleForm.xueshengdianhua))){
						this.$message.error(`学生电话应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.jiaogongzhanghao) && `jiaogong` == this.tableName){
						this.$message.error(`教工账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `jiaogong` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaogong` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.jiaogongxingming) && `jiaogong` == this.tableName){
						this.$message.error(`教工姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`jiaogong` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.zhanghao) && `erjixueyuan` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `erjixueyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `erjixueyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `erjixueyuan` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`erjixueyuan` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
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
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230215/d4dc8ceea34b422aa24289ba152f557b.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20230214/c40bf62556ca43b7a29ed0b2e8d23a68.png) no-repeat center bottom,#fff;

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						margin: 0;
						color: #999;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #edeef0;
						border-width: 0 0 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border: 0px solid #333;
						padding: 0 10px;
						color: #999;
						font-size: 14px;
						border-color: #edeef0;
						border-radius: 0px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						background: none;
						width: 100%;
						border-width: 0 0 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #edeef0;
						border-width:  0 0 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #edeef0;
						border-width:  0 0 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form ::v-deep .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form ::v-deep .upload .upload-img {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  margin: 10px 0;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  margin: 10px 0;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  margin: 10px 0;
		  		  color: #999;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
