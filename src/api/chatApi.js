import axios from "./http";

function getChatHistory(sendUserId,receiveUserId) {
  return axios.get("/chat/getChatHistory?sendUserId=" + sendUserId + "&receiveUserId=" + receiveUserId);
}

function getmsg(params) {
  console.log(params);
  return axios.post("/hello", { params });
}

export default {
  //在这里导出所有函数
  getChatHistory,
  getmsg,
};

// 登录（邮箱，密码->用户id/失败）
// 注册（邮箱，密码->成功/失败）

// 查询用户
// 获取详细信息（id->姓名，头像，性别，地区，邮箱）
// 修改信息（姓名，头像，性别，地区，邮箱）
//通过邮箱添加用户
// 获取近期聊天好友列表（id->姓名，头像，最后聊天时间，按最后聊天时间排序）
// 获取全部好友列表（按时间排序）（id->姓名，头像，id）

// 添加好友（邮箱->信息）
// 聊天
