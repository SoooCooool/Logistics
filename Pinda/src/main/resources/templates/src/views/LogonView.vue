<!--<template>
  <div class="register">
    <h2>用户注册</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="username">姓名：</label>
        <input type="text" id="name" v-model="userInfo.name" />
      </div>
      <div class="form-group">
        <label for="location">位置：</label>
        <input type="text" id="location" v-model="userInfo.location" />
      </div>
      <div class="form-group">
        <label for="password">密码：</label>
        <input  type="password" id="password" v-model="userInfo.password" />
      </div>
      <div class="form-group">
        <label for="phonenumber">手机号：</label>
        <input type="text" maxlength="11" minlength="11" slot="请输入" id="phonenumber" v-model="userInfo.phonenumber" />
      </div>
      <button type="submit" >注册并登录</button>
    </form>

    &lt;!&ndash; 注册成功弹窗 &ndash;&gt;
    <div v-if="successDialogVisible" class="success-dialog">
      <h2>注册成功</h2>
      <p>用户账号：{{ registeredUsername }}</p>
    </div>
  </div>
</template>-->
<template>
  <div class="register">
    <h2>用户注册</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="username">姓名：</label>
        <input type="text" id="name" v-model="userInfo.name" />
      </div>
      <div class="form-group">
        <label for="location">位置：</label>
        <input type="text" id="location" v-model="userInfo.location" />
      </div>
      <div class="form-group">
        <label for="password">密码：</label>
        <input  type="password" id="password" v-model="userInfo.password" />
      </div>
      <div class="form-group">
        <label for="phonenumber">手机号：</label>
        <input type="text" maxlength="11" minlength="11" id="phonenumber" v-model="userInfo.phonenumber" />
      </div>
      <button type="submit">注册并登录</button>
    </form>

    <!-- 注册成功弹窗 -->
    <div v-if="successDialogVisible" class="success-dialog">
      <h2>注册成功</h2>
      <p>用户账号：{{ registeredUsername }}</p>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import store from "@/store";

export default {
  /*data() {
    return {
      userInfo: {
        name: '',
        location: '',
        password: '',
        phonenumber: '',
        userid:""
      },
      successDialogVisible: false, // 注册成功弹窗可见性
      registeredUsername: '', // 从后端接收到的用户账号
    };
  },*/
  data() {
    return {
      userInfo: {
        name: '',
        location: '',
        password: '',
        phonenumber: '',
      },
      successDialogVisible: false,
      registeredUsername: '',
    };
  },
  methods: {
    submitForm() {
      // 在提交表单之前进行输入字段的验证
      if (this.userInfo.name.trim() === '' || this.userInfo.location.trim() === '' || this.userInfo.password.trim() === '' || this.userInfo.phonenumber.trim() === '') {
        // 如果有任何一个字段为空，显示错误消息或者采取其他适当的操作
        alert('请输入完整的信息');
        return;
      }
      axios.post('/api/log/register', this.userInfo)
          .then(response => {
            // 注册成功后，显示弹窗并接收后端返回的用户账号
            //this.registeredUsername = response.data.uid;
            //this.successDialogVisible = true;
            console.log('store:', store.state.userid);
            this.$store.commit('login', response.data.data);
            this.$message.success('注册成功！')
            this.$router.push('/userset');


          })
          .catch(error => {
            console.error('Error registering user:', error);
          });

      // 如果输入字段都不为空，可以提交表单
      // 向后端发送注册请求并处理成功响应
      // ...

    },
  },

};
</script>

<style scoped>
/* 添加样式以美化界面 */
.register {
  width: 80%;
  margin: 0 auto;
  padding: 20px;
}

h2 {
  text-align: center;
}

form {
  max-width: 400px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 20px;
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

button[type="submit"] {
  width: 100%;
  padding: 10px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

/* 注册成功弹窗样式 */
.success-dialog {
  width: 300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  text-align: center;
  margin-top: 20px;
}
</style>
