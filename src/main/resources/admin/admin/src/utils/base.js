const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot87or2/",
            name: "springboot87or2",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "高校党建基本数据管理系统的设计与实现"
        } 
    }
}
export default base
