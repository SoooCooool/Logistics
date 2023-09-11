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
        <button @click="loginClick">登录</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name:'loginForm',
  data() {
    return {
      username: '',
      password: '',
      type: '',
    };
  },
  methods: {
      loginClick() {
        console.log("11");
             if (!this.username || !this.password ) {
               alert('用户名和密码不能为空');
               return;
             }
             axios.post('http://localhost:8080/log/logon', this.password,this.username,this.type)
             // axios.post('http://localhost:8080/log/logon', this.username)
             // axios.post('http://localhost:8080/log/logon', this.type)
             //axios.post('http://localhost:8080/log/login', this.formData)
                 .then(response => {
                   // Handle success response from the backend
                   console.log('Backend response:', response.data);
                 })
                 .catch(error => {
                   // Handle error response or network error
                   console.error('Error:', error);
                 });
      },
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

.btn {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
</style>