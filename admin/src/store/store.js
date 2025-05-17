import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const store = new Vuex.Store({
    state: {
      count: 0,
      payRecords: {
          name: "教工",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-01-15 09:16",
      },
      transferRecords:{
          Name:"王sd1",
          account:"用户1",
          tel:"13712340001",
          oldName: "张三",
          oldContact: "13812340001",
          newName: "李四",
          newContact: "13912340001",
          transferDate: "2025-04-20 10:00:00",
          shenhe_huifu: "ssd",
          shenhe_zhuangtai: "是",
      }
      
    },
    mutations: {
      increment (state) {
        state.count++
      }
    },
    actions: {
      incrementAsync ({ commit }) {
        setTimeout(() => {
          commit('increment')
        }, 1000)
      }
    },
    getters: {
      doubleCount: state => state.count * 2,
      payRecords:state=>{
        return state.payRecords
      }
    }
  })
  
  export default store