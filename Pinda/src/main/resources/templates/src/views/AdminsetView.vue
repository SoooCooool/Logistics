<template>
  <div class="user-info">
    <h2>用户信息</h2>
    <div class="user-details">
      <div><strong>姓名：</strong>{{ adminInfo.name }}</div>
      <div><strong>id：</strong>{{ adminInfo.administratorid }}</div>
      <div><strong>密码：</strong>******</div>
    </div>
    <button @click="editAdminInfo">修改信息</button>

    <!-- 编辑弹窗 -->
    <div v-if="editDialogVisible" class="edit-dialog">
      <h2>编辑用户信息</h2>
      <form @submit.prevent="saveEdit">
        <div class="form-group">
          <label for="editedName">姓名：</label>
          <input type="text" id="editedName" v-model="editedAdminInfo.name"  required/>
        </div>
        <div class="form-group">
          <label for="editedPassword">密码：</label>
          <input type="password" id="editedPassword" v-model="editedAdminInfo.password"  required/>
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
      adminInfo: {
        name: '',
        password: '******', // 原始密码
        administratorid:store.state.userid,
      },
      editDialogVisible: false, // 编辑弹窗可见性
      editedAdminInfo: {
        name: '',
        password: '',
        administratorid:'',
      },
      adminData: {}, // 存储从后端接收到的数据

    };
  },
  created() {
    // 在页面创建时调用后端接口获取用户信息
    this.fetchUserInfo();

  },
  methods: {

    fetchUserInfo() {
      axios.get('/api/administrator/getbyId?id='+this.adminInfo.administratorid) // 替换为您的后端接口 URL
          .then(response => {
            // 处理成功响应，将数据存储在 userData 中
            this.adminInfo = response.data.data;
          })
          .catch(error => {
            // 处理错误响应
            console.error('获取用户数据失败:', error);
          })
    },
    editAdminInfo() {
      // 打开编辑弹窗时，将原始信息填充到输入框中
      this.editedAdminInfo = { ...this.adminInfo };
      this.editDialogVisible = true;
    },
    cancelEdit() {
      // 关闭弹窗时重置输入框
      this.editDialogVisible = false;
      this.editedUserInfo = {
        name: '',
        password: '',
      };
    },
    saveEdit() {

      this.administratorid=store.state.userid;
      // 向后端发送更新后的用户信息
      // this.editedUserInfo 包含了更新后的信息
      console.log('保存编辑的用户信息:', this.editedAdminInfo);
      axios.post('/api/administrator/updateById',this.editedAdminInfo)
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
