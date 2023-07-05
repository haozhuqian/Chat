<template>
  <div class="userlist-info-box">
    <div class="userlist-info-top">
      <div>
        <input type="text" v-model="userMessage.name" class="isInput" />
      </div>
      <img :src="userMessage.avatar" alt="" />
      <input
        type="file"
        class="isInput"
        id="uploadFile"
        @change="updateAvatar"
      />
    </div>
    <div class="userlist-info-main">
      <div class="message-item">
        <div>性 别</div>
        <div>
          <input type="text" class="isInput" v-model="userMessage.gender" />
        </div>
      </div>
      <div class="message-item">
        <div>地 区</div>
        <div>
          <input type="text" class="isInput" v-model="userMessage.region" />
        </div>
      </div>
      <div class="message-item">
        <div>邮 箱</div>
        <div>
          <input type="text" disabled="disabled" v-model="userMessage.email" />
        </div>
      </div>
    </div>
    <div class="send-message" @click="isDisable">
      {{ isRevise ? "修 改" : "完 成" }}
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  mounted() {
    console.log("userInfo is mounted");
    [...document.getElementsByClassName("isInput")].forEach((e) => {
      e.setAttribute("disabled", "disabled");
    });
    this.userMessage = this.$store.state.user.Me;
    console.log();
  },
  methods: {
    updateAvatar() {
      let formData = new FormData();
      formData.append("file", document.getElementById("uploadFile").files[0]);
      let config = {
        headers: { "Content-Type": "multipart/form-data" },
      }; //添加请求头
      axios
        .post("http://localhost:8080/upload", formData, config)
        .then((res) => {
          console.log(res);
          this.userMessage.avatar = res;
          console.log(this.userMessage);
        });
    },
    isDisable() {
      this.isRevise = !this.isRevise;
      let nodeList = [...document.getElementsByClassName("isInput")];
      if (this.isRevise) {
        // 确认提交
        nodeList.forEach((e) => {
          e.setAttribute("disabled", "disabled");
        });
        this.$api.userApi.updateUserInfo(this.userMessage).then((res) => {
          if (res == "success") {
            this.$message({
              message: "修改成功",
              type: "success",
            });
          }
        });
      } else {
        // 修改信息
        nodeList.forEach((e) => {
          e.removeAttribute("disabled");
        });
      }
    },
    handlePreview(file) {
      window.open(file.response.url);
      console.log(file.response.url);
    },
  },
  data() {
    return {
      isRevise: true,
      userMessage: {
        name: "渣男本茶",
        avatar:
          "https://tse1-mm.cn.bing.net/th/id/R-C.d1c70e819588207bed6fba871c2d47dd?rik=6P9u%2b7JBZVikQQ&riu=http%3a%2f%2ffile.qqtouxiang.com%2fnansheng%2f2019-12-24%2f156cd442c68a0e20030c0fe72efe7dc9.jpeg&ehk=75MR%2fJ%2bxSvpra0%2btzVMowB%2b4h5cXfcv5U0K2e3xFYfY%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
        gender: "男",
        region: "山西临汾",
        email: "3094969938@qq.com",
        id: 0,
      },
    };
  },
};
</script>

<style lang="less" scoped>
#uploadFile {
  position: absolute;
  left: 320px;
  top: 10px;
  font-size: 35px;
  display: block;
  opacity: 0;
}
.userlist-info-box {
  position: relative;
  width: 900px;
  height: 700px;
  .userlist-info-top {
    width: 400px;
    position: absolute;
    transform: translate(-50%);
    left: 50%;
    top: 100px;
    display: flex;
    justify-content: space-between;
    input {
      font-size: 20px;
    }
    div {
      word-wrap: break-word;
      font-size: 20px;
      width: 300px;
    }
    img {
      width: 70px;
      height: 70px;
    }
  }
  .userlist-info-main {
    width: 400px;
    height: 200px;
    position: absolute;
    transform: translate(-50%);
    left: 50%;
    top: 220px;
    border-top: 2px solid #c2c1c1;
    border-bottom: 2px solid #c2c1c1;
    .message-item {
      display: flex;
      width: 300px;
      margin-top: 30px;
      font-size: 18px;
      justify-content: space-between;
      input {
        color: black !important;
        font-size: 18px;
      }
    }
    .message-item :nth-child(1) {
      color: #c2c1c1;
    }
    .message-item :nth-child(2) {
      width: 200px;
    }
  }
}
.send-message {
  position: absolute;
  transform: translate(-50%);
  left: 50%;
  top: 490px;
  width: 150px;
  height: 40px;
  background-color: #2ba245;
  color: white;
  text-align: center;
  line-height: 40px;
}
</style>
