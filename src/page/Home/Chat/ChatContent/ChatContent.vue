<template>
  <div class="chat-box">
    <div class="isempty" v-if="!showChatBox">
      <el-empty description="请先选择好友哦"></el-empty>
    </div>
    <div v-if="showChatBox">
      <div class="chat-top-box">
        <div class="chat-name-box">{{ $store.state.chat.You.name }}</div>
      </div>
      <div>
        <div>
          <div class="get-chat-history" @click="getChatHistory">获取历史聊天记录</div>
        </div>
        <div class="chat-main-box">
          <chat-item :msg="item" v-for="item in messageList"></chat-item>
        </div>
      </div>
      <div class="chat-input-box">
        <textarea name="" id="chat-input" cols="30" rows="2" ref="chatInput"></textarea>
        <div class="send-btn" @click="sendMessage">发送(S)</div>
      </div>
    </div>
  </div>
</template>

<script>
import ChatItem from "./ChatItem.vue";
export default {
  mounted() {
    this.conectWebSocket();
  },
  unmounted() {
    this.conectWebSocket();

  },
  computed: {
    showChatBox() {
      return this.$store.state.chat.You.receiveId != undefined;
    },
    getChatState() {
      return this.$store.state.chat.You.receiveId;
    },
  },
  components: {
    ChatItem,
  },
  watch: {
    getChatState(newName, oldName) {
      this.messageList = [];
    },
  },
  methods: {
    conectWebSocket() {
      let nickname = this.$store.state.user.Me.name;
      let that = this;
      //判断当前浏览器是否支持WebSocket
      if ("WebSocket" in window) {
        this.websocket = new WebSocket(
          "ws://localhost:8080/websocket/" + nickname
        );
      } else {
        alert("Not support websocket");
      }
      //连接发生错误的回调方法
      this.websocket.onerror = function () {
        console.log("err");
      };
      //连接成功建立的回调方法
      this.websocket.onopen = function (event) {
        console.log(event);
      };
      //接收到消息的回调方法
      this.websocket.onmessage = function (event) {
        console.log('接收到消息的回调方法', event);
        let message = JSON.parse(event.data);
        console.log(message);
        console.log(that.$store.state.user.Me.id);
        if (message.receiveId == that.$store.state.user.Me.id && message.sendId == that.$store.state.chat.You.receiveId) {
          that.messageList.push(message);
          console.log("我是that.messageList啦啦啦啦啦", that.messageList);
        }
      };
      //连接关闭的回调方法
      this.websocket.onclose = function () {
        console.log("close");
      };
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function () {
        this.websocket.close();
      };
    },
    sendMessage() {
      let userInfo = this.$store.state.user.Me;
      console.log(userInfo);

      let obj = {
        receiveId: this.$store.state.chat.You.receiveId,
        sendId: userInfo.id,
        message: this.$refs.chatInput.value,
      };
      this.websocket.send(JSON.stringify(obj));
      console.log(this.messageList);
      console.log("sendMessage");
      this.messageList.push(obj);
      console.log(this.messageList);
      this.$refs.chatInput.value = "";
    },
    getChatHistory() {
      let sendId = this.$store.state.user.Me.id;
      let receiveId = this.$store.state.chat.You.receiveId;
      this.$api.chatApi.getChatHistory(sendId, receiveId).then((res) => {
        console.log(res);
        res.forEach(i => {
          let historyChatObj = {
            receiveId: i.receiveId,
            sendId: i.sendId,
            message: i.message,
          }
          this.messageList.unshift(historyChatObj);
        });
        console.log(this.messageList);
      }).catch((err) => {
        console.log(err);
      });
    }
  },
  data() {
    return {
      websocket: null,
      messageList: [
        {
          /*  sendUserName: "备胎一号",
           sendUserAvatar:
             "https://img2.woyaogexing.com/2020/10/09/222a2de17e87421285c352b050f2c47d!400x400.jpeg",
           sendUserId: "123456",
           toUserId:'6',
           sendContent: "嘤嘤嘤", */
        },
      ],
    };
  },
};
</script>

<style lang="less" scoped>
.isempty {
  position: absolute;
  left: 42%;
  top: 150px;
}

.chat-box {
  position: relative;
  width: 660px;
  height: 700px;
}

.chat-top-box {
  width: 100%;
  height: 70px;
  background-color: #f5f5f5;
  border-bottom: 1px solid #e6e5e5;
  border-left: 1px solid #e6e5e5;
}

.chat-name-box {
  width: 450px;
  height: 70px;
  line-height: 70px;
  font-size: 22px;
  margin-left: 40px;
}

.chat-main-box {
  width: 100%;
  height: 468px;
  overflow-y: scroll;
  overflow-x: hidden;
}

.chat-input-box {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 160px;
  border-top: 1px solid #e6e5e5;

  #chat-input {
    margin-top: 20px;
    margin-left: 30px;
    width: 90%;
    font-size: 18px;
    height: 80px;
    background-color: transparent;
    border: none;
    outline: none;
    resize: none;
  }

  .send-btn {
    position: absolute;
    right: 40px;
    margin: 10px;
    width: 100px;
    height: 35px;
    background-color: #e9e9e9;
    text-align: center;
    line-height: 35px;
    color: #5fc160;
    border-radius: 5px;
  }

  .get-chat-history {
    width: 20px;
    height: 8px;
    margin-left: auto;
    margin-right: auto;
    background-color: red;
    color: aquamarine;
    font-size: 8px;
  }
}
</style>
