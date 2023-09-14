<template>
  <div class="user-info">
    <h2>用户信息</h2>
    <div class="user-details">
      <div><strong>姓名：</strong>{{ userInfo.name }}</div>
      <div><strong>手机号：</strong>{{ userInfo.phonenumber }}</div>
      <div><strong>职业：</strong>{{ userInfo.occupation }}</div>
      <div><strong>id：</strong>{{ userInfo.employeeid }}</div>
      <div><strong>密码：</strong>******</div>
    </div>
    <button @click="editUserInfo">修改信息</button>

    <!-- 编辑弹窗 -->
    <div v-if="editDialogVisible" class="edit-dialog">
      <h2>编辑用户信息</h2>
      <form @submit.prevent="saveEdit">
        <div class="form-group">
          <label for="editedName">姓名：</label>
          <input type="text" id="editedName" v-model="editedUserInfo.name"  required/>
        </div>
        <div class="form-group">
          <label for="editedPhone">手机号：</label>
          <input type="text" id="editedPhone" v-model="editedUserInfo.phonenumber"  required/>
        </div>
        <div class="form-group">
          <label for="editedLocation">职业：</label>
          <input type="text" id="editedLocation" v-model="editedUserInfo.occupation"  required/>
        </div>
        <div class="form-group">
          <label for="editedPassword">密码：</label>
          <input type="password" id="editedPassword" v-model="editedUserInfo.password"  required/>
        </div>
        <div class="form-actions">
          <button type="submit">保存</button>
          <button type="button" @click="cancelEdit">取消</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios, {post} from "axios";
import store from "@/store";

export default {
  data() {
    return {
      userInfo: {
        name: '',
        phonenumber: '',
        occupation: '',
        password: '******', // 原始密码
        employeeid:store.state.userid,
      },
      editDialogVisible: false, // 编辑弹窗可见性
      editedUserInfo: {
        name: '',
        phonenumber: '',
        occupation: '',
        password: '',
      },
      userData: {}, // 存储从后端接收到的数据

    };
  },
  created() {
    // 在页面创建时调用后端接口获取用户信息
    this.fetchUserInfo();




  },
  methods: {

    fetchUserInfo() {
      axios.get('/api/employee/queryById?id='+this.userInfo.employeeid) // 替换为您的后端接口 URL
          .then(response => {
            // 处理成功响应，将数据存储在 userData 中
            this.userInfo = response.data.data;
          })
          .catch(error => {
            // 处理错误响应
            console.error('获取用户数据失败:', error);
          })
    },
    editUserInfo() {
      // 打开编辑弹窗时，将原始信息填充到输入框中
      this.editedUserInfo = { ...this.userInfo };
      this.editDialogVisible = true;
    },
    cancelEdit() {
      // 关闭弹窗时重置输入框
      this.editDialogVisible = false;
      this.editedUserInfo = {
        name: '',
        phonenumber: '',
        occupation: '',
        password: '',
      };
    },
    saveEdit() {

      this.userid=store.state.userid;
      // 向后端发送更新后的用户信息
      // this.editedUserInfo 包含了更新后的信息
      console.log('保存编辑的用户信息:', this.editedUserInfo);

      axios.post('/api/employee/update',this.editedUserInfo)
          .then(response => {
            // 处理成功响应
            console.log('Backend response:', response.data);
            this.fetchUserInfo();
          })
          .catch(error => {
            // 处理错误响应或网络错误
            console.error('Error:', error);
          });
      // 发送数据到后端的逻辑应该在这里处理
      // 之后可以关闭弹窗
      this.editDialogVisible = false;
    },
  },
};
</script>

<style scoped>
.user-info {
  width: 80%;
  margin: 0 auto;
  padding: 20px;
}

.user-details {
  margin-top: 20px;
}

.user-details div {
  margin-bottom: 10px;
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

.edit-dialog {
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
  text-align: left;
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
  text-align: center;
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

strong {
  font-weight: bold;
  margin-right: 5px;
}
</style>
