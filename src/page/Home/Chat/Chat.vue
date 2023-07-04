<template>
  <div style="display: flex">
      <chat-list></chat-list> 
    <chat-content></chat-content>
    
  </div>
</template>

<script>
import ChatList from "./ChatList/ChatList.vue";
import ChatContent from "./ChatContent/ChatContent.vue";
export default {
  components: {
    ChatList,
    ChatContent,
  },
};
</script>

<style></style>
