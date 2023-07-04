import axios from "./http";

function toLogin(params) {
  return axios.post("/toLogin", params);
}
function Register(params) {
  return axios.post("/Register", params);
}

export default {
  //在这里导出所有函数
  toLogin,
  Register,
};
