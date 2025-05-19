import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
      count: 0,
      payRecords: [{
          name: "教工姓名1",
          account: "教工账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-01-15 09:16",
      },
      {
          name: "学生姓名1",
          account: "学生账号1",
          type: "微信支付",
          amount: "166",
          ispay: "已支付",
          payTime: "2025-01-15 09:16",
      }],
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
      },
      readRecords: [],
      identitytable:{},
    },
    mutations: {
      increment (state) {
        state.count++
      },
      // 同步记录
      syncPayRecords(state,records){
        state.payRecords = records;
      },
      syncreadRecords(state,records){
        state.readRecords = records;
      },


      // 增加记录
      addPayRecord(state,record){
        state.payRecords.push(record);
      },
      readRecords(state,record){
        state.readRecords.push(record);
      },
      identitytable(state,record){
        state.identitytable=record;
      }

    },
    actions: {
      incrementAsync ({ commit }) {
        setTimeout(() => {
          commit('increment')
        }, 1000)
      },
      addPayRecordAsync({commit},record){
        setTimeout(()=>{
          commit('addPayRecord',record)
        },500)
      },
      readRecordsAsync({commit},record){
        setTimeout(()=>{
          commit('readRecords',record)
        },500)
      },
      identitytableAsync({commit},record){
        setTimeout(()=>{
          commit('identitytable',record)
        },500)
      },
      syncPayRecordsAsync({commit},records){
        setTimeout(()=>{
          commit('syncPayRecords',records)
        },500)
      },
      syncreadRecordsAsync({commit},records){
        setTimeout(()=>{
          commit('syncreadRecords',records)
        },500)
      }
    },
    getters: {
      doubleCount: state => state.count * 2,
      payRecords:state=>{
        return state.payRecords
      },
      readRecords:state=>{
        return state.readRecords
      },
      identitytable:state=>{
        return state.identitytable
      },
      syncPayRecords:state=>{
        return state.PayRecords
      },
      syncreadRecords:state=>{
        return state.readRecords
      }
    }
  })
  
  export default store