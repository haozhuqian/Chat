import Login from "../page/Login/Login.vue";
import {
  createRouter,
  createWebHistory,
  createWebHashHistory,
} from "vue-router";
const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
    children: [],
  },
  {
    path: "/home",
    name: "Home",
    component: () => import("../page/Home/Home.vue"),
    children: [
      {
        path: "/chat",
        name: "Chat",
        component: () => import("../page/Home/Chat/Chat.vue"),
      },
      {
        path: "/userList",
        name: "UserList",
        component: () => import("../page/Home/UserList/UserList.vue"),
      },
      {
        path: "/info",
        name: "Info",
        component: () => import("../page/Home/UserInfo/UserInfo.vue"),
      },
    ],
  },
];

const router = createRouter({
  // history: createWebHistory(process.env.BASE_URL),
  history: createWebHashHistory(),
  routes,
});

export default router;
