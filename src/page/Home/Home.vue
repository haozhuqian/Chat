<template>
  <div class="home-outer-box">
    <div class="left-tab-box">
      <img src="../../assets/img/Login/header.png" alt="" />
      <div class="icon-box">
        <router-link to="/chat"
          ><icon iconClass="liaotian_jihuo" color="#07c160"></icon
        ></router-link>
        <router-link to="/userList"
          ><icon iconClass="tongxunlu" color="#07c160"></icon
        ></router-link>
        <router-link to="/info"
          ><icon iconClass="shezhi" color="#07c160"></icon
        ></router-link>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  mounted() {
    if(this.$store.state.user.Me.id<0){
      this.$router.push({name: "Login"});
    }
  }
};
</script>

<style lang="less" scoped>
.home-outer-box {
  width: 1000px;
  height: 700px;
  background-color: #f5f5f5;
  position: absolute;
  transform: translate(-50%, -50%);
  left: 50%;
  top: 50%;
  display: flex;
  .left-tab-box {
    width: 60px;
    height: 700px;
    background-color: #2e2e2e;
    text-align: center;
    .icon-box {
      margin-top: 30px;
      height: 150px;
      display: flex;
      flex-direction: column;
      justify-content: space-around;
      align-items: center;
      svg {
        display: block;
      }
    }
    img {
      margin-top: 30px;
      width: 50px;
      height: 50px;
    }
  }
}
</style>
