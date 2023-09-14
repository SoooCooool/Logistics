<template>
  <div class="parent">
    <div class="login-card">
      <h2 class="title">用户登录</h2>
      <form class="form" @submit.prevent="submitForm">
        <div class="form-group">
          <label class="label" for="username">用户名：</label>
          <input class="input" type="text" id="username" v-model="username">
        </div>
        <div class="form-group">
          <label class="label" for="password">密码：</label>
          <input class="input" type="password" id="password" v-model="password">
        </div>

        <div>
          <h3>选择身份</h3>
          <select v-model="selectedOption">
            <option value="admin">管理员</option>
            <option value="employee">雇员</option>
            <option value="user">用户</option>
          </select>
        </div>
        <button @click="submit">登录</button>
        <div>
          <!-- 其他登录页面内容 -->
          <button @click="goToRegister">点击去注册</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import store from "@/store";
import Header from "@/components/Header";
import Aside from "@/components/Aside";


export default {
  data() {
    return {
      username: '',
      password: '',
      selectedOption: '' // 添加了一个属性来存储选择的身份
    };
  },
  methods: {
    submitForm() {
      if (!this.username || !this.password || !this.selectedOption) {
        alert('用户名、密码和身份不能为空');
        return;
      }
      const data = {
        username: this.username,
        password: this.password,
        type: this.selectedOption
      };

      axios.post('/api/log/login',data)
          .then(response => {
           if(response.data.code===1){
            console.log('Backend response:', response.data.code);
              console.log('Backend response:', response.data);
              this.$store.commit('login', this.username);
              if(store.state.userid[0]==='U'){
                this.$router.push('/userset');}
              else if(store.state.userid[0]==='E'){
                this.$router.push('/employeeset');
              }
              else if (store.state.userid[0]==='M'){
                this.$router.push('/adminset');
              }


           }
            else if (response.data.code===0){
             this.$message.error('登陆失败！');
              console.log('Backend response:', response.data);
            }
          })
          .catch(error => {
            // 处理错误响应或网络错误
            console.error('Error:', error);
          });
    },
    goToRegister() {
      // 使用编程式导航跳转到注册页面
      this.$router.push('/logon');
    },
  },
};
</script>

<style scoped>
.parent {
  display: flex;
  justify-content: center;
}

.login-card {
  max-width: 400px;
  padding: 50px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0px 0px 10px #ccc;
  margin: 50px;
}

.title {
  margin-top: 0;
  text-align: center;
}

.form-group {
  margin-bottom: 20px;
}

.label {
  display: block;
  margin-bottom: 5px;
}

.input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  box-sizing: border-box;
}

.button-container {
  display: flex; /* 使用Flex布局 */
  justify-content: space-between; /* 两个按钮之间的间距 */
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>





<!--<style scoped>
.parent {
  display: flex;
  justify-content: center;
}

.login-card {
  max-width: 400px;
  padding: 50px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0px 0px 10px #ccc;
  margin: 50px;
}

.title {
  margin-top: 0;
  text-align: center;
}

.form-group {
  margin-bottom: 20px;
}

.label {
  display: block;
  margin-bottom: 5px;
}

.input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  box-sizing: border-box;
}
button {
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button[type="submit"],
button[type="button"] {
  margin-right: 10px;
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn {
  display: block;
  width: 500%;
  padding: 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
</style>-->
