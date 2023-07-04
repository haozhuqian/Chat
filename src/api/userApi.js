import axios from "./http";

function updateUserInfo(params) {
  return axios.post("/updateUserInfo", params);
}
function getChats(params) {
  return axios.get("/getChats?id=" + params);
}
function getUserInfoById(params) {
  return axios.get("/getUserInfoById?id=" + params);
}
function getUserInfoByEmail(params) {
  return axios.get("/getUserInfoByEmail?email=" + params);
}
function addFriend(params) {
  return axios.post("/addFriend", params);
}

export default {
  //在这里导出所有函数
  updateUserInfo,
  getAllFriends,
  getUserInfoById,
  getUserInfoByEmail,
  addFriend,
};
