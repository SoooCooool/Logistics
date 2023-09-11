<template>
  <div class="login-form">
    <h2>登录</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">用户名：</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div class="form-group">
        <label for="password">密码：</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <div class="form-actions">
        <button type="submit">登录</button>
        <button @click="register">注册</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    login() {
      // 在这里添加处理登录逻辑的代码
      // 您可以使用axios或其他HTTP库向后端发送登录请求
    },
    register() {
      // 在这里添加处理注册逻辑的代码
      // 可以导航到注册页面或者弹出注册模态框
    },
  },
};
</script>

<style scoped>
/* 添加样式以美化登录界面 */
.login-form {
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