<template>
  <div>
    <div class="login-box-outer">
      <div class="login-box-top">
        <img src="../../assets/img/Login/logo.png" alt="" />
        <span class="name">微信·WeChat</span>
        <div class="header-icon-box">
          <img src="../../assets/img/Login/header.png" alt="" />
        </div>
      </div>
      <div class="login-box-buttom" v-if="isLogin">
        <input type="text" ref="loginEmail" placeholder="请输入邮箱" /><br />
        <input type="password" ref="loginPassword" placeholder="请输入密码" /><br />
        <div class="login-button" @click="toLogin">登 录</div>
        <div class="word-link" @click="changeMode">立即注册</div>
      </div>
      <div class="login-box-buttom" v-if="!isLogin">
        <input type="text" ref="enrollEmail" placeholder="请输入邮箱" /><br />
        <input type="password" ref="enrollPassword" placeholder="请输入密码" /><br />
        <input type="password" ref="enrollRePassword" placeholder="请确认密码" /><br />
        <div class="login-button" @click="toEnroll">确 定</div>
        <div class="word-link" @click="changeMode">返回登录</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    toLogin() {
      const email = this.$refs.loginEmail.value;
      const password = this.$refs.loginPassword.value;
      this.$api.loginApi.toLogin({ email, password }).then(
        (res) => {
          console.log(res);
          if (res.state) {
            this.$message.error(res.fail);
          } 
          if (res.success) {
            this.$store.commit("user/changeInfo", res.success);
            this.$router.push("/chat");
          }
        },
        function (err) {
          this.$message.error("网络好像有点问题哦~");
        }
      );
    },
    changeMode() {
      this.isLogin = !this.isLogin;
    },
    toEnroll() {
      const email = this.$refs.enrollEmail.value;
      const password = this.$refs.enrollPassword.value;
      const rePassword = this.$refs.enrollRePassword.value;
      if (String(password) !== String(rePassword)) {
        this.$message.error("两次密码不一致哦！");
        return;
      }
      this.$api.loginApi.Register({ email, password }).then(
        (res) => {
          if ((res = "success")) {
            this.$message({
              message: "注册成功",
              type: "success",
            });
          }
        },
        (err) => {
          this.$message.error("网络好像有点问题哦~");
        }
      );
    },
  },
  data() {
    return {
      isLogin: true,
    };
  },
};
</script>

<style lang="less" scoped>
.word-link {
  color: #afacac;
  position: absolute;
  top: 190px;
  left: -150px;
}

@keyframes gradient {
  0% {
    background-position: 0% 50%;
  }

  50% {
    background-position: 100% 50%;
  }

  100% {
    background-position: 0% 50%;
  }
}

.name {
  position: relative;
  color: white;
  top: -20px;
}

.login-box-outer {
  width: 600px;
  height: 450px;
  background-color: rgba(0, 0, 0, 0.01);
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  position: absolute;
  transform: translate(-50%, -50%);
  left: 50%;
  top: 45%;

  .login-box-top {
    width: 100%;
    height: 150px;
    background: linear-gradient(-45deg, #134b02, #88f58d, #249b1f, #76d69b);
    /* background: linear-gradient(-45deg, #c4f1f1, #ec1303, #040257, #f85515); */
    background-size: 800% 800%;
    animation: gradient 35s ease infinite;

    img {
      margin: 10px;
      width: 40px;
      height: 40px;
    }

    .header-icon-box img {
      position: absolute;
      transform: translate(-50%, -50%);
      left: 50%;
      top: 150px;
      width: 80px;
      height: 80px;
      border-radius: 100px;
      background-color: white;
    }
  }

  .login-box-buttom {
    height: 200px;
    position: absolute;
    transform: translate(-50%, -50%);
    left: 50%;
    top: 320px;
    text-align: center;

    input {
      font-size: 16px;
      width: 250px;
      border-bottom: 2px #06c160 solid;
      margin-bottom: 30px;
    }

    .login-button {
      width: 250px;
      height: 40px;
      line-height: 40px;
      background-color: #06c160;
      color: white;
      font-size: 20px;
      border-radius: 5px;
    }

    .login-button:hover {
      opacity: 0.9;
    }
  }
}
</style>
