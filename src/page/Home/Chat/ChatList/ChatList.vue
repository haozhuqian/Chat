<template>
  <div class="chatlist-box">
    <div class="chatlist-input">
      <input type="text" placeholder="没做好功能的搜索" v-model="searchUser"/>
    </div>
    <div class="message-box">
      <div class="message-item" v-for="item in showList" @click="selectYou(item)">
        <img :src="item.avatar" alt="" />
        <div class="name-box">{{ item.name }}</div>
        <div class="time-box">{{ item.time }}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    this.$api.userApi
      .getChats(this.$store.state.user.Me.id)
      .then((res) => {
        console.log(res);
        res.forEach((e) => {
          let arr = e?.time.split("-");
          e.time = arr[0].slice(0, 2) + "/" + arr[1] + "/" + arr[2];
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
    selectYou(e) {
        console.log("selectYou", e);
        this.$store.commit("chat/setYou", e);
        console.log(this.$store.state.chat.You);
    },
  },
  data() {
    return {
      searchUser: "",
      userList: [
        {
          name: "错误，没有收到信息",
          avatar:
            "https://tse1-mm.cn.bing.net/th/id/R-C.1a9d433a22667c6c6d6efbf62813912f?rik=Fx8X42YAcP2jVA&riu=http%3a%2f%2ffile.qqtouxiang.com%2fqinglv%2f2020-06-05%2f9737315e4f6a72e89a1e9ea4223fd34a.jpg&ehk=%2fuNqDi0KYfHWCuZ2yhjcH%2b8VVrehNZFnWAvekVZvhUw%3d&risl=&pid=ImgRaw&r=0",
          id: "12345",
          lastTime: "20/1/02",
        }
      ],
    };
  },
};
</script>

<style lang="less" scoped>
::-webkit-scrollbar {
  width: 0px;
}
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
    margin: 22px auto;
    input {
      height: 25px;
      line-height: 25px;
      padding: 0px 20px;
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
        border-radius: 100%;
      }

      .name-box {
        font-size: 18px;
        width: 200px;
        margin-left: 25px;
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
}</style>
