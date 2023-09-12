<template>
  <div class="register-form">
    <h2>注册</h2>
    <form @submit.prevent="register">
      <div class="form-group">
        <label for="username">用户名：</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div class="form-group">
        <label for="password">密码：</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <div class="form-group">
        <label for="location">位置：</label>
        <input type="text" id="location" v-model="location" required />
      </div>
      <div class="form-group">
        <label for="phone">手机号码：</label>
        <input type="number" id="phone" v-model="phone" required />
      </div>
      <div class="form-actions">
        <button type="submit">注册</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: '',
      password: '',
      location: '', // 更改为位置
      phone: '',
    };
  },
  methods: {
    register() {
      // 构造要发送给后端的注册数据
      const registrationData = {
        username: this.username,
        password: this.password,
        location: this.location, // 更改为位置
        phone: this.phone,
      };

      // 使用axios或其他HTTP库发送POST请求将数据发送给后端
      // 请将'/api/register'替换为实际的后端注册接口URL
      axios.post('/api/register', registrationData)
          .then(response => {
            // 处理后端响应，例如显示成功消息或导航到登录页面
            console.log('注册成功：', response.data);
          })
          .catch(error => {
            // 处理错误，例如显示错误消息或重置表单
            console.error('注册失败：', error);
          });
    },
  },
};
</script>

<style scoped>
/* 添加样式以美化注册界面 */
.register-form {
  width: 300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  text-align: center;
}

.form-group {
  margin-bottom: 10px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.form-actions {
  margin-top: 20px;
}

button {
  margin-right: 10px;
}
</style>
