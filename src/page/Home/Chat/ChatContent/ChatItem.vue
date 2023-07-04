<template>
  <div class="outer-box">
    <div class="chat-item-box" v-if="!isSelf">
      <img :src="msg.sendUserAvatar" alt="" />
      <div>
        <div class="userName">{{ msg.sendUserName }}</div>
        <div class="message-box">{{ msg.sendContent }}</div>
      </div>
    </div>
    <div class="chat-item-box-self" v-if="isSelf">
      <img :src="msg.sendUserAvatar" alt="" />
      <div>
        <div class="userName">{{ msg.sendUserName }}</div>
        <div class="message-box">
          <div class="inner-box">{{ msg.sendContent }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    msg: {
      type: Object,
      required: true,
    },
  },
  computed: {
    isSelf() {
      return this.msg.sendUserId == this.$store.state.user.userMessage.userId;
    },

  },
  
};
</script>

<style lang="less" scoped>
.outer-box {
  position: relative;
  width: 600px;
  height: auto;
  margin: 15px auto;
  .chat-item-box,
  .chat-item-box-self {
    position: relative;
    display: flex;
    img {
      position: relative;
      top: 0;
      width: 40px;
      height: 40px;
      display: block;
    }
    .userName {
      position: relative;
      width: 200px;
      left: 10px;
      top: 0px;
      font-size: 14px;
      color: #9b9a9a;
      // color: red;
    }
    .message-box {
      position: relative;
      top: 5px;
      left: 10px;
      display: inline-block;
      max-width: 300px;
      border-radius: 5px;
      background-color: white;
      padding: 10px;
      word-wrap: break-word;
    }
  }
  .chat-item-box-self {
    img {
      position: absolute;
      right: 0rem;
    }
    .userName {
      left: 350px;
      text-align: right;
    }
    .message-box {
      left: 240px;
      width: 300px;
      display: flex;
      flex-direction: row-reverse;
      background-color: transparent;
      word-wrap: break-word;
      .inner-box {
        position: relative;
        top: -10px;
        background-color: #95ec69;
        word-break: break-all;
        display: inline-block;
        padding: 10px;
        border-radius: 5px;
      }
    }
  }
}
</style>
