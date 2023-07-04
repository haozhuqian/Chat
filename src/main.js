import { createApp } from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
// echart图标
import * as echarts from "echarts";
// less
import less from "less";
// 引入组件库
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
// axios封装
import api from "./api/api";
// iconfont组件封装
import "./assets/icon/iconfoot";
import component from "./components/components";
// 引入字体
import "./assets/font/font.css";
const app = createApp(App);
//将axios的二次封装（api）挂载到全局
app.config.globalProperties.$api = api;
app
  .use(store)
  .use(router)
  .use(less)
  .use(echarts)
  .use(component)
  .use(ElementPlus)
  // .use(icon)
  .mount("#app");
