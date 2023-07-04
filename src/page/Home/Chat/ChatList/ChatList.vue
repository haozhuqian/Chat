<template>
  <div class="chatlist-box">
    <div class="chatlist-input">
      <input type="text" placeholder=" 搜索" v-model="searchUser" />
    </div>
    <div class="message-box">
      <div
        class="message-item"
        v-for="item in showList"
        @click="selectChatUser(item)"
      >
        <img :src="item.avatar" alt="" />
        <div class="name-box">{{ item.name }}</div>
        <div class="time-box">{{ item.lastTime }}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    console.log("chatList is mounted");
    this.$api.userApi
      .getAllFriends(this.$store.state.user.userMessage.userId)
      .then((res) => {
        console.log("get all friends");
        res.forEach((e) => {
          let arr = e?.lastTime.split("-");
          e.lastTime = arr[0].slice(0, 2) + "/" + arr[1] + "/" + arr[2];
        });
        this.userList = res;
      });
  },
  computed: {
    showList() {
      return this.searchUser === "" ? this.userList : this.searchList;
    },
    searchList() {
      let val = this.searchUser;
      let arr = this.userList.filter((item) => {
        return item.name.indexOf(val) != -1;
      });
      return arr;
    },
  },
  methods: {
    selectChatUser(e) {
      this.$store.commit("chat/changeUser", e);
      console.log(this.$store.state.chat.chatUser.userId);
    },
  },
  data() {
    return {
      searchUser: "",
      userList: [
        {
          name: "正宫",
          avatar:
            "https://tse1-mm.cn.bing.net/th/id/R-C.1a9d433a22667c6c6d6efbf62813912f?rik=Fx8X42YAcP2jVA&riu=http%3a%2f%2ffile.qqtouxiang.com%2fqinglv%2f2020-06-05%2f9737315e4f6a72e89a1e9ea4223fd34a.jpg&ehk=%2fuNqDi0KYfHWCuZ2yhjcH%2b8VVrehNZFnWAvekVZvhUw%3d&risl=&pid=ImgRaw&r=0",
          id: "12345",
          lastTime: "20/1/02",
        },
        {
          name: "备胎一号",
          avatar:
            "https://img2.woyaogexing.com/2020/10/09/222a2de17e87421285c352b050f2c47d!400x400.jpeg",
          id: "12345",
          lastTime: "20/1/02",
        },
        {
          name: "备胎二号",
          avatar:
            "https://tse4-mm.cn.bing.net/th/id/OIP-C.TQcBnO20xnfq0rGqNdZdJQAAAA?pid=ImgDet&rs=1",
          id: "12345",
          lastTime: "20/1/02",
        },
        {
          name: "备胎三号",
          avatar:
            "https://tse1-mm.cn.bing.net/th/id/R-C.65a32f211b1e8a3a1540d96953618005?rik=KRp9q8QRwCuHhA&riu=http%3a%2f%2fscimg.jianbihuadq.com%2f202007%2f20200707170327105.jpg&ehk=YqgAZ9O6rbO1vgEfVvcbDxMWjtnbEFOrT%2baLGamBssg%3d&risl=&pid=ImgRaw&r=0",
          id: "12345",
          lastTime: "20/1/02",
        },
      ],
    };
  },
};
</script>

<style lang="less" scoped>
.time-box {
  position: absolute;
  left: 220px;
  font-size: 12px;
  color: #888888;
}
.chatlist-box {
  position: relative;
  width: 280px;
  height: 700px;
  background-color: #f7f7f7;
  .chatlist-input {
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
        font-size: 18px;
        width: 200px;
        margin-left: 5px;
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
</style>
