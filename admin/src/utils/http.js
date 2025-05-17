import axios from 'axios'
import router from '@/router/router-static'
import storage from '@/utils/storage'
// 创建axios实例
const http = axios.create({
    // 超时
    timeout: 1000 * 86400,
    // 允许请求时带上 cookie，通常是跨域登录验证时需要。
    withCredentials: true,
    // 所有请求地址自动加上前缀，比如发 /user/list，实际上请求的是 /springboot87or2/user/list
    baseURL: '/springboot87or2',
    // 默认请求头是 application/json，告诉服务器我是发 JSON 格式的数据。
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})
// 请求拦截
http.interceptors.request.use(config => {
    // 从本地 storage 里取出 Token，放到请求头的 Token 字段中，用于身份认证
    config.headers['Token'] = storage.get('Token') // 请求头带上token
    return config
}, error => {
    // 如果取不到（比如用户没登录），就不会加 token。
    // 如果拦截出错（比如配置异常），返回一个 Promise.reject(error)。
    return Promise.reject(error)
})
// 响应拦截
// 每次收到服务器返回数据后都会先经过这里。
http.interceptors.response.use(response => {
    // 判断服务器返回的 data.code 是否是 401（未授权 / token失效）。
    if (response.data && response.data.code === 401) { // 401, token失效
        // 如果是，自动跳转到登录页：
        router.push({ name: 'login' })
    }
    // 其他正常的 response，直接返回。
    return response
}, error => {
    // 如果遇到错误（如网络断开、服务器出错），统一返回 Promise.reject(error)，让调用方自己处理异常。
    return Promise.reject(error)
})
export default http