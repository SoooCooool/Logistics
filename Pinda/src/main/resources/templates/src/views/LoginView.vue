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
        <div class="form-group">
          <button class="btn" type="submit">登录</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name:'loginForm',
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    submitForm() {
      if (!this.username || !this.password) {
        alert('用户名和密码不能为空');
        return;
      }
      // 在这里提交表单
      console.log(`用户名：${this.username}，密码：${this.password}`);
      this.$router.push({ path: '/data' });
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