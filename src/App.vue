<template>
  <router-view></router-view>
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
a {
  color: black;
  text-decoration: none;
}
input {
  border: none;
  outline: none;
  background: transparent;
}
::-webkit-scrollbar {
  width: 2px;
}
::-webkit-scrollbar-thumb {
  background-color: rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  height: 3px;
}
::-webkit-scrollbar-track {
  height: 3px;
  max-height: 5px;
}
::-webkit-scrollbar-track-piece {
  background-color: transparent;
}
</style>
