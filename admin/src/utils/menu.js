let sdssds = [{
    "backMenu": [
        // { "child": [{ "appFrontIcon": "cuIcon-pic", "buttons": ["新增", "查看", "修改", "删除"], "menu": "学生", "menuJump": "列表", "tableName": "xuesheng" }], "menu": "学生管理" },
        // { "child": [{ "appFrontIcon": "cuIcon-copy", "buttons": ["新增", "查看", "修改", "删除"], "menu": "教工", "menuJump": "列表", "tableName": "jiaogong" }], "menu": "教工管理" },
        // { "child": [{ "appFrontIcon": "cuIcon-present", "buttons": ["新增", "查看", "修改", "删除"], "menu": "二级学院", "menuJump": "列表", "tableName": "erjixueyuan" }], "menu": "二级学院管理" },
        {
      "menu": "信息管理",
      "child": [
        { "appFrontIcon": "cuIcon-pic", "buttons": ["新增", "查看", "修改", "删除"], "menu": "学生", "menuJump": "列表", "tableName": "xuesheng" },
        { "appFrontIcon": "cuIcon-copy", "buttons": ["新增", "查看", "修改", "删除"], "menu": "教工", "menuJump": "列表", "tableName": "jiaogong" },
        { "appFrontIcon": "cuIcon-present", "buttons": ["新增", "查看", "修改", "删除"], "menu": "二级学院", "menuJump": "列表", "tableName": "erjixueyuan" },
        { "appFrontIcon": "cuIcon-album", "buttons": ["新增", "查看", "修改", "删除"], "menu": "党组织信息", "menuJump": "列表", "tableName": "dangzuzhixinxi" }
      ]
    },
        {
        "menu": "入党管理",
        "child": [
            { "appFrontIcon": "cuIcon-addressbook",
            "buttons": ["查看", "修改", "删除", "打印", "学生入党统计", "首页总数", "首页统计", "导出"],
            "menu": "学生入党",
            "menuJump": "列表",
            "tableName": "xueshengrudang"
            },
            {
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "修改", "删除", "打印", "首页总数", "首页统计", "教工入党统计", "导出"],
            "menu": "教工入党",
            "menuJump": "列表",
            "tableName": "jiaogongrudang"
            },
            {
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "修改", "删除", "打印", "首页总数", "首页统计", "教工入党统计", "导出"],
            "menu": "关系转接",
            "menuJump": "列表",
            "tableName": "transfer"
            },
            
        ]
        },
            {
            "child": [
                {
                "appFrontIcon": "cuIcon-news",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "新闻列表",
                "menuJump": "列表",
                "tableName": "news"
                },
                {
                "appFrontIcon": "cuIcon-form",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "学习记录",
                "menuJump": "列表",
                "tableName": "studyrecord"
                }
            ],
            "menu": "新闻学习"
            }
    ],
         "frontMenu": [], "hasBackLogin": "是", "hasBackRegister": "否", "hasFrontLogin": "否", "hasFrontRegister": "否", "roleName": "管理员", "tableName": "users"},
    
    { "backMenu": [], "frontMenu": [], "hasBackLogin": "是", "hasBackRegister": "否", "hasFrontLogin": "否", "hasFrontRegister": "否", "roleName": "党支部管理员", "tableName": "users" },

    { "backMenu": [
        // { "child": [{ "appFrontIcon": "cuIcon-album", "buttons": ["查看", "学生申请"], "menu": "党组织信息", "menuJump": "列表", "tableName": "dangzuzhixinxi" }], "menu": "党组织信息管理" }, 
        {
        "menu": "组织生活",
        "child": [
            {
            "appFrontIcon": "cuIcon-album",
            "buttons": ["查看", "学生申请"],
            "menu": "党组织信息",
            "menuJump": "列表",
            "tableName": "dangzuzhixinxi"
            },
            {
            "appFrontIcon": "cuIcon-activity",  // 你可以换成合适的图标名
            "buttons": ["查看", "新增", "修改", "删除"],
            "menu": "组织活动",
            "menuJump": "列表",
            "tableName": "huodonglist"
            }
        ]
        },
        { "child": [{ "appFrontIcon": "cuIcon-addressbook", "buttons": ["查看", "删除"], "menu": "学生入党", "menuJump": "列表", "tableName": "xueshengrudang" }], "menu": "学生入党管理" }, 
        // { "child": [{ "appFrontIcon": "cuIcon-news", "buttons": ["查看"], "menu": "党建宣传", "tableName": "news" }], "menu": "新闻学习" },
        {
            "child": [
                {
                "appFrontIcon": "cuIcon-news",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "新闻列表",
                "menuJump": "列表",
                "tableName": "news"
                },
                {
                "appFrontIcon": "cuIcon-form",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "学习记录",
                "menuJump": "列表",
                "tableName": "studyrecord"
                }
            ],
            "menu": "党建宣传"
            }

    ],
         "frontMenu": [], "hasBackLogin": "是", "hasBackRegister": "是", "hasFrontLogin": "否", "hasFrontRegister": "否", "roleName": "学生", "tableName": "xuesheng" }, 
    

    { "backMenu": [
        // { "child": [{ "appFrontIcon": "cuIcon-album", "buttons": ["查看", "教工入党"], "menu": "党组织信息", "menuJump": "列表", "tableName": "dangzuzhixinxi" }], "menu": "党组织信息管理" }, 
        {
        "menu": "组织生活",
        "child": [
            {
            "appFrontIcon": "cuIcon-album",
            "buttons": ["查看", "学生申请"],
            "menu": "党组织信息",
            "menuJump": "列表",
            "tableName": "dangzuzhixinxi"
            },
            {
            "appFrontIcon": "cuIcon-activity",  // 你可以换成合适的图标名
            "buttons": ["查看", "新增", "修改", "删除"],
            "menu": "组织活动",
            "menuJump": "列表",
            "tableName": "huodonglist"
            }
        ]
        },
        { "child": [{ "appFrontIcon": "cuIcon-list", "buttons": ["查看", "删除"], "menu": "教工入党", "menuJump": "列表", "tableName": "jiaogongrudang" }], "menu": "教工入党管理" }, 
        // { "child": [{ "appFrontIcon": "cuIcon-news", "buttons": ["查看"], "menu": "党建宣传", "tableName": "news" }], "menu": "新闻学习" }
        {
            "child": [
                {
                "appFrontIcon": "cuIcon-news",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "新闻列表",
                "menuJump": "列表",
                "tableName": "news"
                },
                {
                "appFrontIcon": "cuIcon-form",
                "buttons": ["新增", "查看", "修改", "删除"],
                "menu": "学习记录",
                "menuJump": "列表",
                "tableName": "studyrecord"
                }
            ],
            "menu": "党建宣传"
            }
    ], 
        "frontMenu": [], "hasBackLogin": "是", "hasBackRegister": "是", "hasFrontLogin": "否", "hasFrontRegister": "否", "roleName": "教工", "tableName": "jiaogong" }, 
    


    { "backMenu": [
        { "child": [{ "appFrontIcon": "cuIcon-album", "buttons": ["查看"], "menu": "党组织信息", "menuJump": "列表", "tableName": "dangzuzhixinxi" }], "menu": "党组织信息管理" }, 
    {
        "menu": "入党管理",
        "child": [
            { "appFrontIcon": "cuIcon-addressbook",
            "buttons": ["查看", "修改", "删除", "打印", "学生入党统计", "首页总数", "首页统计", "导出"],
            "menu": "学生入党",
            "menuJump": "列表",
            "tableName": "xueshengrudang"
            },
            {
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "修改", "删除", "打印", "首页总数", "首页统计", "教工入党统计", "导出"],
            "menu": "教工入党",
            "menuJump": "列表",
            "tableName": "jiaogongrudang"
            },
            {
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "修改", "删除", "打印", "首页总数", "首页统计", "教工入党统计", "导出"],
            "menu": "关系转接",
            "menuJump": "列表",
            "tableName": "transfer"
            },
            
        ]
        },
    {
    "child": [
        {
        "appFrontIcon": "cuIcon-news",
        "buttons": ["新增", "查看", "修改", "删除"],
        "menu": "新闻列表",
        "menuJump": "列表",
        "tableName": "news"
        },
        {
        "appFrontIcon": "cuIcon-form",
        "buttons": ["新增", "查看", "修改", "删除"],
        "menu": "学习记录",
        "menuJump": "列表",
        "tableName": "studyrecord"
        }
    ],
    "menu": "新闻学习"
    }
        // { "child": [{ "appFrontIcon": "cuIcon-news", "buttons": ["新增", "查看", "修改", "删除"], "menu": "党建宣传", "tableName": "news" }], "menu": "新闻学习" }
    ],
        "frontMenu": [], "hasBackLogin": "是", "hasBackRegister": "是", "hasFrontLogin": "否", "hasFrontRegister": "否", "roleName": "二级学院", "tableName": "erjixueyuan" }]
const menu = {

    list() {
        return sdssds    
    }
}
export default menu;
