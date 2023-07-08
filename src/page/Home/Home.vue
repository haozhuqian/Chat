<template>
  <div class="home-outer-box">
    <div class="left-tab-box">
      <img :src="this.$store.state.user.Me.avatar" alt=""/>
      <div class="icon-box">
        <router-link to="/chat"
          ><icon iconClass="liaotian_jihuo" color="#07c160" size="40px"></icon
        ></router-link>
        <router-link to="/userList"
          ><icon iconClass="tongxunlu" color="#07c160" size="40px"></icon
        ></router-link>
        <router-link to="/info"
          ><icon iconClass="shezhi" color="#07c160" size="40px"></icon
        ></router-link>
      </div>
    </div>
    <div class="right-tab-box"> 
      <router-view></router-view>
    </div>
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
  width: 1200px;
  height: 700px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 1);
  background-color: #f5f5f5;
  position: absolute;
  transform: translate(-50%, -50%);
  left: 50%;
  top: 50%;
  display: flex;
  .left-tab-box {
    width: 120px;
    height: 700px;
    background-color: #2e2e2e;
    text-align: center;
    .icon-box {
      margin-top: 30px;
      height: 200px;
      display: flex;
      flex-direction: column;
      justify-content: space-around;
      align-items: center;
      svg {
        display: block;
        width: 60px;
        height: 60px;
      }
      
    }
    img {
      margin-top: 30px;
      border-radius: 100%;
      width: 80px;
      height: 80px;
    }
  }
  .right-tab-box {
    width: 1080px;
    height: 700px;
    overflow: hidden;
  }
}
</style>
