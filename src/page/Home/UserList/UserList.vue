<template>
  <div class="flex-box">
    <div class="userlist-box">
      <div class="userlist-input">
        <input type="text" ref="findUserInput" placeholder="输入邮箱添加新的好友" />
        <div class="addUser" @click="findUser">+</div>
      </div>
      <div class="message-box">
        <div class="sum">我的好友（{{ userList.length }}）</div>
        <div class="message-item" v-for="item in userList" @click="selectUser(item)">
          <img :src="item.avatar" alt="" />
          <div class="name-box">{{ item.name }}</div>
        </div>
      </div>
    </div>
    <div class="empty-box" v-if="!isEmpty">
      <el-empty description="好像什么都没有哦~"></el-empty>
    </div>
    <div class="userlist-info-box" v-if="isEmpty">
      <div class="userlist-info-top">
        <div>{{ userMessage.name }}</div>
        <img :src="userMessage.avatar" alt="" />
      </div>
      <div class="userlist-info-main">
        <div class="message-item">
          <div>性 别</div>
          <div>{{ userMessage.gender }}</div>
        </div>
        <div class="message-item">
          <div>地 区</div>
          <div>{{ userMessage.region }}</div>
        </div>
        <div class="message-item">
          <div>邮 箱</div>
          <div>{{ userMessage.email }}</div>
        </div>
      </div>
      <div class="send-message" @click="sendMessage(userMessage.id)">
        {{ getFriendState }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    this.fetchList();
  },
  computed: {
    isEmpty() {
      return !this.userMessage == "";
    },
    getFriendState() {
      return !this.Friend ? "发消息" : "加好友";
    },
  },
  methods: {
    fetchList() {
      this.$api.userApi
        .getAllFriends(this.$store.state.user.userMessage.id)
        .then((res) => {
          this.userList = res;
          console.log(res);
        });
    },
    isFriend(id) {
      this.friend = this.userList.every((item) => {
        return item.id != id;
      });
    },
    findUser() {
      let str = this.$refs.findUserInput.value;
      this.$api.userApi.getUserInfoByEmail(str).then((res) => {
        this.isFriend(res.id);
        this.userMessage = res;
        console.log(res);
      });
    },
    addFriend(obj) {
      this.$api.userApi.addFriend(obj).then((res) => {
        this.$message({
          message: "添加成功",
          type: "success",
        });
        this.$api.userApi
          .getAllFriends(this.$store.state.user.userMessage.id)
          .then((res) => {
            this.userList = res;
          });
      });
    },
    setChats(receiveId, sendId) {
      let time = new Date();
      time = `${time.getFullYear()}-${time.getMonth() + 1}-${time.getDate()}`;
      this.$api.userApi.setChats({ receiveId, sendId, time, word: "" });
      this.$store.commit("chat/changeUser", this.userMessage);
      this.$router.push("/chat");
    },
    sendMessage(receiveId) {
      let sendId = this.$store.state.user.userMessage.id;
      if (!this.Friend) {
        this.setChats(receiveId, sendId);
      } else {
        this.addFriend({ receiveId, sendId })
      }
    },
    selectUser(e) {
      this.userMessage = e;
      this.isFriend(e.id);
    },
  },
  data() {
    return {
      userMessage: "",
      friend: true,
      userList: [
        {
          name: "正宫",
          avatar:
            "https://tse1-mm.cn.bing.net/th/id/R-C.1a9d433a22667c6c6d6efbf62813912f?rik=Fx8X42YAcP2jVA&riu=http%3a%2f%2ffile.qqtouxiang.com%2fqinglv%2f2020-06-05%2f9737315e4f6a72e89a1e9ea4223fd34a.jpg&ehk=%2fuNqDi0KYfHWCuZ2yhjcH%2b8VVrehNZFnWAvekVZvhUw%3d&risl=&pid=ImgRaw&r=0",
          id: "12345",
          time: "20/1/02",
        },
        {
          name: "备胎一号",
          avatar:
            "https://img2.woyaogexing.com/2020/10/09/222a2de17e87421285c352b050f2c47d!400x400.jpeg",
          id: "12345",
          time: "20/1/02",
        },
        {
          name: "备胎二号",
          avatar:
            "https://tse4-mm.cn.bing.net/th/id/OIP-C.TQcBnO20xnfq0rGqNdZdJQAAAA?pid=ImgDet&rs=1",
          id: "12345",
          time: "20/1/02",
        },
      ],
    };
  },
};
</script>

<style lang="less" scoped>
.sum {
  height: 50px;
  text-align: center;
  line-height: 50px;
  background-color: #dedede;
}

.empty-box {
  position: absolute;
  left: 55%;
  top: 150px;
}

.addUser {
  position: relative;
  left: 50px;
  display: inline-block;
  background-color: #e2e2e2;
  height: 25px;
  width: 25px;
  font-size: 20px;
  font-weight: bold;
  text-align: center;
  line-height: 25px;
  color: #2ba245;
  cursor: default;
}

.time-box {
  position: absolute;
  left: 220px;
  font-size: 12px;
  color: #888888;
}

.flex-box {
  display: flex;
}

.userlist-box {
  position: relative;
  width: 280px;
  height: 700px;
  background-color: #f7f7f7;

  .userlist-input {
    width: 200px;
    background-color: #e2e2e2;
    height: 25px;
    border-radius: 5px;
    margin: 10px;
    margin-top: 20px;

    input {
      position: relative;
      left: 30px;
    }
  }

  .message-box {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 630px;
    background-color: #f7f7f7;
    overflow-y: scroll;

    .message-item {
      display: flex;
      justify-content: space-around;
      width: 100%;
      height: 65px;
      line-height: 65px;
      background-color: #dedede;

      img {
        position: relative;
        top: 10px;
        left: 10px;
        width: 45px;
        height: 45px;
        display: block;
      }

      .name-box {
        margin-left: 5px;
        font-size: 18px;
        width: 200px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
      }
    }

    .message-item:hover {
      background-color: #c9c6c6;
    }
  }
}

.userlist-info-box {
  position: relative;
  width: 660px;
  height: 700px;

  .userlist-info-top {
    width: 400px;
    position: absolute;
    transform: translate(-50%);
    left: 50%;
    top: 100px;
    display: flex;
    justify-content: space-between;

    div {
      word-wrap: break-word;
      font-size: 20px;
      width: 300px;
    }

    img {
      width: 70px;
      height: 70px;
    }
  }

  .userlist-info-main {
    width: 400px;
    height: 200px;
    position: absolute;
    transform: translate(-50%);
    left: 50%;
    top: 220px;
    border-top: 2px solid #c2c1c1;
    border-bottom: 2px solid #c2c1c1;

    .message-item {
      display: flex;
      width: 300px;
      margin-top: 30px;
      font-size: 18px;
      justify-content: space-between;
    }

    .message-item :nth-child(1) {
      color: #c2c1c1;
    }

    .message-item :nth-child(2) {
      width: 200px;
    }
  }
}

.send-message {
  position: absolute;
  transform: translate(-50%);
  left: 50%;
  top: 490px;
  width: 150px;
  height: 40px;
  background-color: #2ba245;
  color: white;
  text-align: center;
  line-height: 40px;
}
</style>
