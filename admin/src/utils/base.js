const base = {
    get() {
        return {
            // 后端服务器接口的基础地址。
            url : "http://localhost:8080/springboot87or2/",
            // 项目的简短名字，一般是后端接口系统的名字，或者是代码目录名。
            name: "springboot87or2",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        // 返回一个详细的项目中文名字。
        return {
            projectName: "高校党建基本数据管理系统的设计与实现"
        } 
    }
}
export default base
