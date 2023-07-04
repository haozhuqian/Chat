import axios from "axios";
import qs from "qs";

// 根据环境变量区分接口默认地址
// switch(process.env.NODE_ENV){
//     case 'production'  :
//         axios.defaults.baseURL = '';
//         break;
//     case 'test':
//         axios.defaults.baseURL = '';
//         break;
//     default:
//         axios.defaults.baseURL = '';
// }
// 设置默认参数
axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.timeout = 3000;
// axios.defaults.headers["Content-Type"] = "application/x-www-form-urlencoded";
// 根据后端返回格式确定是否开启序列化
// axios.defaults.transformRequest = data => qs.stringify(data);

// 设置拦截器

//请求拦截器
axios.interceptors.request.use(
  (config) => {
    // 登录功能扩展时携带token，这个token需要自己存入localstorage
    let token = localStorage.getItem("token");
    // 如果携带token
    token && (config.headers.Authorization = token);
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

//响应拦截器
axios.interceptors.response.use(
  (response) => {
    return response.data;
  },
  (error) => {
    let { response } = error;
    if (response) {
      //请求不成功但返回结果
      switch (response.status) {
        case 401:
          console.log("权限不足，请登录");
          break;
        case 403:
          console.log("登录已过期");
          break;
        case 404:
          console.log("当前接口不存在");
          break;
      }
    } else {
      //服务器完全没有返回结果（网络问题或服务器崩溃）
      if (!window.navigator.onLine) {
        //断网处理，跳转404页面
        console.log("断网了！");
      }
      return Promise.reject(error);
    }
  }
);

export default axios;
