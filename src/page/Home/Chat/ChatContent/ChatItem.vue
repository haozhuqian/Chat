<template>
  <div class="outer-box" :class="{ self: isSelf }">
    <div class="chat-item-box" v-if="!isSelf">
      <img :src="msg.sendUserAvatar" alt="" />
      <div class="message-box">{{ msg.message }}</div>
    </div>
    <div class="chat-item-box-self" v-if="isSelf">
      <div>
        <div class="message-box">{{ msg.message }}</div>

      </div>

      <img :src="msg.sendUserAvatar" alt="" />
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
      return this.msg.sendId == this.$store.state.user.Me.id;
    },

  },

};
</script>

<style lang="less" scoped>
.self {
  flex-direction: row-reverse;
}

.outer-box {
  display: flex;
  width: 630px;
  height: auto;
  margin: 5px auto;

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

    .message-box {
      font-size: 14px;
      position: relative;
      display: inline-block;
      max-width: 300px;
      border-radius: 5px;
      padding: 11px;
      word-wrap: break-word;
    }
  }

  .chat-item-box {
    img {
      left: 0;
    }

    .message-box {
      left: 10px;

      background-color: white;
    }
  }

  .chat-item-box-self {
    img {
      right: 0;
    }

    .message-box {
      right: 10px;
      display: flex;
      flex-direction: row-reverse;
      background-color: #95ec69;

    }
  }
}</style>
