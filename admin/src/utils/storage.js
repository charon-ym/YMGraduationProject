const storage = {
    // 存数据
    set(key, value) {
        localStorage.setItem(key, JSON.stringify(value));
    },
    // 去字符串数据
    get(key) {
        return localStorage.getItem(key)?localStorage.getItem(key).replace('"','').replace('"',''):"";
    },
    // 取对象数据
    getObj(key) {
        return localStorage.getItem(key)?JSON.parse(localStorage.getItem(key)):null;
    },
    // 删某个key
    remove(key) {
        localStorage.removeItem(key);
    },
    // 清空全部数据
    clear() {
	localStorage.clear();
    }
}
export default storage;
