<template>
	<el-container>
		<index-main></index-main>
	</el-container>
</template>
<script>
	import IndexMain from '@/components/index/IndexMain'
	import payrecorddata from '../static/payment_data.json'
	import studydata from '../static/study_data.json'
	export default {
		components: {
			IndexMain
		},
		data() {
		  return{
			ruleForm:{}
		  }  
		},
		mounted() {
			console.log("sdsdsadadasdasdasd")
			console.log(payrecorddata)
			// 将payrecorddata，studydata分别存入到vuex
			this.$store.commit("syncPayRecords", payrecorddata);
			this.$store.commit("syncreadRecords", studydata);
			console.log(studydata)
			console.log(this.$store.state.readRecords);
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get",
				}).then(({ data }) => {
				if (data && data.code === 0) {
					this.ruleForm = data.data;
					//上传数据到vuex
					this.$store.commit('identitytable',this.ruleForm);
				} else {
					this.$message.error(data.msg);
				}
				});
			
		},
		methods: {
		    loadRecords(){
				

			}
		}
	}
</script>

<style lang="scss" scoped>
	// 铺满全屏
	.el-container {
		position: absolute;
		width: 100%;
		top: 0;
		left: 0;
		bottom: 0;
		display: block;
	}
</style>
