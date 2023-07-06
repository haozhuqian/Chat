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

        <div class="chat-main-box">
          <chat-item :msg="item" v-for="item in messageList"></chat-item>
          <div class="chat-history" @click="getChatHistory">点击获取历史聊天记录</div>
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
      return this.$store.state.chat.You.id != undefined;
    },
    getChatState() {
      return this.$store.state.chat.You.id;
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
        if (message.receiveId == that.$store.state.user.Me.id && message.sendId == that.$store.state.chat.You.id) {
          that.messageList.unshift(message);
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
        receiveId: this.$store.state.chat.You.id,
        sendId: userInfo.id,
        message: this.$refs.chatInput.value,
      };
      this.websocket.send(JSON.stringify(obj));
      console.log(this.messageList);
      console.log("sendMessage");
      this.messageList.unshift(obj);
      console.log(this.messageList);
      this.$refs.chatInput.value = "";
    },
    getChatHistory() {
      let sendId = this.$store.state.user.Me.id;
      let receiveId = this.$store.state.chat.You.id;
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
  box-sizing: border-box;
  position: relative;
  width: 660px;
  height: 700px;
  border-left: 2px solid #cccccc;
}

.chat-top-box {
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  background-color: #f5f5f5;
  border-bottom: 2px solid #dddddd;
}

.chat-name-box {
  width: 450px;
  height: 70px;
  line-height: 70px;
  font-size: 24px;
  margin-left: 24px;
}

.chat-main-box {
  width: 100%;
  height: 468px;
  overflow-y: scroll;
  overflow-x: hidden;
  scroll-behavior: smooth;

  display: flex;
  flex-direction: column-reverse;

  .chat-history {
    height: 20px;
    line-height: 20px;
    font-size: 10px;
    text-align: center;
    background-color: transparent;
    color: #666666;
    font-size: 8px;
  }
}

.chat-input-box {
  box-sizing: border-box;
  height: 160px;
  border-top: 2px solid #dddddd;
  padding: 20px 30px;

  #chat-input {
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
    right: 20px;
    bottom: 10px;
    width: 100px;
    height: 35px;
    background-color: #e9e9e9;
    text-align: center;
    line-height: 35px;
    color: #5fc160;
    border-radius: 5px;
  }

 
}
</style>
