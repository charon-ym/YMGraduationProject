<template>
	<div class="addEdit-block" :style='{"padding":"0 0 200px","flexWrap":"wrap","background":"none","display":"flex"}' style="width: 100%;">
		<el-form
			:style='{"padding":"30px 40px","boxShadow":"0 0px 0px #999","borderRadius":"6px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'" label="申请编号" prop="shenqingbianhao">
					<el-input v-model="ruleForm.shenqingbianhao" placeholder="申请编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-else-if="ruleForm.shenqingbianhao" label="申请编号" prop="shenqingbianhao">
					<el-input v-model="ruleForm.shenqingbianhao" placeholder="申请编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="组织名称" prop="zuzhimingcheng">
					<el-input v-model="ruleForm.zuzhimingcheng" placeholder="组织名称" clearable  :readonly="ro.zuzhimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="组织名称" prop="zuzhimingcheng">
					<el-input v-model="ruleForm.zuzhimingcheng" placeholder="组织名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="组织地址" prop="zuzhidizhi">
					<el-input v-model="ruleForm.zuzhidizhi" placeholder="组织地址" clearable  :readonly="ro.zuzhidizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="组织地址" prop="zuzhidizhi">
					<el-input v-model="ruleForm.zuzhidizhi" placeholder="组织地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="upload" v-if="type!='info'&& !ro.cailiao" label="材料" prop="cailiao">
					<file-upload
						tip="点击上传材料"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.cailiao?ruleForm.cailiao:''"
						@change="cailiaoUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else-if="ruleForm.cailiao" label="材料" prop="cailiao">
					<el-button :style='{"border":"1px solid #f3ce9d","cursor":"pointer","padding":"0 12px","margin":"0 20px 0 0","color":"#333","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="text" size="small" @click="download($base.url+ruleForm.cailiao)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else-if="!ruleForm.cailiao" label="材料" prop="cailiao">
					<el-button :style='{"border":"1px solid #f3ce9d","cursor":"pointer","padding":"0 12px","margin":"0 20px 0 0","color":"#333","minWidth":"80px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="学期" prop="xueqi">
					<el-input v-model="ruleForm.xueqi" placeholder="学期" clearable  :readonly="ro.xueqi"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="学期" prop="xueqi">
					<el-input v-model="ruleForm.xueqi" placeholder="学期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="学习排名" prop="xuexipaiming">
					<el-input v-model="ruleForm.xuexipaiming" placeholder="学习排名" clearable  :readonly="ro.xuexipaiming"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="学习排名" prop="xuexipaiming">
					<el-input v-model="ruleForm.xuexipaiming" placeholder="学习排名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="date" v-if="type!='info'" label="申请时间" prop="shenqingshijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shenqingshijian" 
						type="date"
						:readonly="ro.shenqingshijian"
						placeholder="申请时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-else-if="ruleForm.shenqingshijian" label="申请时间" prop="shenqingshijian">
					<el-input v-model="ruleForm.shenqingshijian" placeholder="申请时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="学生账号" prop="xueshengzhanghao">
					<el-input v-model="ruleForm.xueshengzhanghao" placeholder="学生账号" clearable  :readonly="ro.xueshengzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="学生账号" prop="xueshengzhanghao">
					<el-input v-model="ruleForm.xueshengzhanghao" placeholder="学生账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengxingming">
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" clearable  :readonly="ro.xueshengxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="学生姓名" prop="xueshengxingming">
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="班级" prop="banji">
					<el-input v-model="ruleForm.banji" placeholder="班级" clearable  :readonly="ro.banji"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="班级" prop="banji">
					<el-input v-model="ruleForm.banji" placeholder="班级" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="身份" prop="shenfen">
					<el-input v-model="ruleForm.shenfen" placeholder="身份" clearable  :readonly="ro.shenfen"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="身份" prop="shenfen">
					<el-input v-model="ruleForm.shenfen" placeholder="身份" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-if="type!='info'"  label="申请内容" prop="shenqingneirong">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.shenqingneirong" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"padding":"10px 20px","boxShadow":"0px 16px 6px -9px #d2b3aa","margin":"0 0 40px 0","borderColor":"#f7e2dc","borderRadius":"30px","background":"linear-gradient(120deg, rgba(255,255,255,1) 0%, rgba(255,245,242,1) 100%)","borderWidth":"1px","display":"block","width":"48%","minWidth":"500px","borderStyle":"solid"}' v-else-if="ruleForm.shenqingneirong" label="申请内容" prop="shenqingneirong">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.shenqingneirong"></span>
                </el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0px solid #40ecde","cursor":"pointer","padding":"0 20px 0 40px","boxShadow":"0px 16px 9px -12px #aaa","margin":"20px 20px 0 0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"30px","background":"url(http://codegen.caihongy.cn/20221217/9516b0de6d644d9cb181babab8b1ea92.png) no-repeat 16px,linear-gradient(270deg, rgba(238,149,42,1) 0%, rgba(205,55,10,1) 100%)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid #999","cursor":"pointer","padding":"0 20px 0 40px","boxShadow":"0px 16px 9px -12px #aaa","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"30px","background":"url(http://codegen.caihongy.cn/20221217/fbde16c3f93f4467aea813357cd195da.png) no-repeat 16px,linear-gradient(270deg, rgba(204,204,204,1) 0%, rgba(153,153,153,1) 100%)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid #999","cursor":"pointer","padding":"0 20px 0 40px","boxShadow":"0px 16px 9px -12px #aaa","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"30px","background":"url(http://codegen.caihongy.cn/20221217/fbde16c3f93f4467aea813357cd195da.png) no-repeat 16px,linear-gradient(270deg, rgba(204,204,204,1) 0%, rgba(153,153,153,1) 100%)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				shenqingbianhao : false,
				zuzhimingcheng : false,
				zuzhidizhi : false,
				cailiao : false,
				xueqi : false,
				xuexipaiming : false,
				shenqingshijian : false,
				xueshengzhanghao : false,
				xueshengxingming : false,
				banji : false,
				shenfen : false,
				shenqingneirong : false,
				sfsh : false,
				shhf : false,
			},
			
			
			ruleForm: {
				shenqingbianhao: this.getUUID(),
				zuzhimingcheng: '',
				zuzhidizhi: '',
				cailiao: '',
				xueqi: '',
				xuexipaiming: '',
				shenqingshijian: '',
				xueshengzhanghao: '',
				xueshengxingming: '',
				banji: '',
				shenfen: '',
				shenqingneirong: '',
				shhf: '',
			},
		
			
			rules: {
				shenqingbianhao: [
				],
				zuzhimingcheng: [
				],
				zuzhidizhi: [
				],
				cailiao: [
				],
				xueqi: [
				],
				xuexipaiming: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				shenqingshijian: [
				],
				xueshengzhanghao: [
				],
				xueshengxingming: [
				],
				banji: [
				],
				shenfen: [
				],
				shenqingneirong: [
				],
				sfsh: [
				],
				shhf: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.shenqingshijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='shenqingbianhao'){
							this.ruleForm.shenqingbianhao = obj[o];
							this.ro.shenqingbianhao = true;
							continue;
						}
						if(o=='zuzhimingcheng'){
							this.ruleForm.zuzhimingcheng = obj[o];
							this.ro.zuzhimingcheng = true;
							continue;
						}
						if(o=='zuzhidizhi'){
							this.ruleForm.zuzhidizhi = obj[o];
							this.ro.zuzhidizhi = true;
							continue;
						}
						if(o=='cailiao'){
							this.ruleForm.cailiao = obj[o];
							this.ro.cailiao = true;
							continue;
						}
						if(o=='xueqi'){
							this.ruleForm.xueqi = obj[o];
							this.ro.xueqi = true;
							continue;
						}
						if(o=='xuexipaiming'){
							this.ruleForm.xuexipaiming = obj[o];
							this.ro.xuexipaiming = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}
						if(o=='xueshengzhanghao'){
							this.ruleForm.xueshengzhanghao = obj[o];
							this.ro.xueshengzhanghao = true;
							continue;
						}
						if(o=='xueshengxingming'){
							this.ruleForm.xueshengxingming = obj[o];
							this.ro.xueshengxingming = true;
							continue;
						}
						if(o=='banji'){
							this.ruleForm.banji = obj[o];
							this.ro.banji = true;
							continue;
						}
						if(o=='shenfen'){
							this.ruleForm.shenfen = obj[o];
							this.ro.shenfen = true;
							continue;
						}
						if(o=='shenqingneirong'){
							this.ruleForm.shenqingneirong = obj[o];
							this.ro.shenqingneirong = true;
							continue;
						}
				}
				














			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.xueshengzhanghao!=''&&json.xueshengzhanghao) || json.xueshengzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xueshengzhanghao = json.xueshengzhanghao
						this.ro.xueshengzhanghao = true;
					}
					if(((json.xueshengxingming!=''&&json.xueshengxingming) || json.xueshengxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xueshengxingming = json.xueshengxingming
						this.ro.xueshengxingming = true;
					}
					if(((json.banji!=''&&json.banji) || json.banji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.banji = json.banji
						this.ro.banji = true;
					}
					if(((json.shenfen!=''&&json.shenfen) || json.shenfen==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shenfen = json.shenfen
						this.ro.shenfen = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `xueshengrudang/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.shenqingneirong = this.ruleForm.shenqingneirong.replace(reg,'../../../springboot87or2/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {








	if(this.ruleForm.cailiao!=null) {
		this.ruleForm.cailiao = this.ruleForm.cailiao.replace(new RegExp(this.$base.url,"g"),"");
	}





















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "xueshengrudang/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `xueshengrudang/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.xueshengrudangCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `xueshengrudang/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.xueshengrudangCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.xueshengrudangCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    cailiaoUploadChange(fileUrls) {
	    this.ruleForm.cailiao = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
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
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
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
	
	.add-update-preview .el-select /deep/ .el-input__inner {
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
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
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
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
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
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
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
