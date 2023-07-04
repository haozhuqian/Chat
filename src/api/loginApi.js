import axios from "./http";

function toLogin(params) {
  console.log("to login", params);
  return axios.post("/toLogin", params);
}
function Register(params) {
  console.log("register", params);
  return axios.post("/Register", params);
}

export default {
  //在这里导出所有函数
  toLogin,
  Register,
};
