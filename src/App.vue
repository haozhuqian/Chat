<template>
  <div class="root">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>

<style>
@keyframes gradient {
  0% {
    background-position: 0% 0%;
  }

  20% {
    background-position: 50% 0%;
  }

  40% {
    background-position: 100% 0%;
  }

  60% {
    background-position: 100% 100%;
  }

  80% {
    background-position: 0% 100%;
  }

  100% {
    background-position: 0% 0%;
  }
}

html,
body {
  height: 100%;
}

.root {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(60deg, #bbfff0, #e1fffc, #92f1e3, #9be7c6, #67e9d1, #b5ffdb, #a6f8c4, #8efbe0);
  background-size: 800% 800%;
  animation: gradient 35s ease infinite;
}

* {
  margin: 0;
  padding: 0;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;

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
  width: 8px;
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
}</style>
