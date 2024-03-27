import axios from "./http";

function updateUserInfo(params) {
  console.log("updateUserInfo");
  return axios.post("/updateUserInfo", params);
}
function getChats(params) {
  console.log("getChats");
  return axios.get("/getChats?id=" + params);
}
function getAllFriends(params) {
  console.log("getAllFriends");
  return axios.get("/getAllFriends?id=" + params);
}
function getUserInfoById(params) {
  console.log("getUserInfoById");
  return axios.get("/getUserInfoById?id=" + params);
}
function getUserInfoByEmail(params) {
  console.log("getUserInfoByEmail");
  return axios.get("/getUserInfoByEmail?email=" + params);
}
function setChats(params) {
  console.log("setChats");
  return axios.post("/setChats", params);
}
function addFriend(params) {
  console.log("addFriend");
  return axios.post("/addFriend", params);
}
function isFriend(params) {
  console.log("isFriend");
  return axios.post("/isFriend",params);
}

export default {
  //在这里导出所有函数
  updateUserInfo,
  getChats,
  getAllFriends,
  getUserInfoById,
  getUserInfoByEmail,
  setChats,
  addFriend,
  isFriend,
};
