<template>
  <div class="user-info">
    <h2>用户信息</h2>

    <button @click="editUserInfo">修改信息</button>
    <el-button type="primary" plain  @click="dialogVisible = true">新增</el-button>
    <el-dialog
        title="编辑品牌"
        :visible.sync="dialogVisible"
        width="30%"
    >

      <!--弹出的对话框的内容-->
      <el-form ref="form" :model="addForm" label-width="80px">
        <el-form-item label="品牌名称">
          <el-input v-model="addForm.brandName"></el-input>
        </el-form-item>
        <el-form-item label="企业名称">
          <el-input v-model="addForm.companyName"></el-input>
        </el-form-item>
        <el-form-item label="排序">
          <el-input v-model="addForm.ordered"></el-input>
        </el-form-item>
        <el-form-item label="活动形式">
          <el-input type="textarea" v-model="addForm.description"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-switch v-model="addForm.status"
                     active-value="1"
                     inactive-value="0"
          ></el-switch>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addBrand">立即创建</el-button>
          <el-button @click="dialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>


  </div>
</template>

<script>
import { ElDialog, ElForm, ElInput, ElFormItem, ElButton } from 'element-plus'; // 引入Element UI组件

export default {
  components: {
    ElDialog,
    ElForm,
    ElInput,
    ElFormItem,
    ElButton,
  },
  data() {
    return {
      userInfo: {
        name: 'John Doe',
        phone: '123-456-7890',
        location: 'New York',
        password: '******',
      },
      dialogVisible: false,
      editedUserInfo: {
        name: '',
        phone: '',
        location: '',
        password: '',
      },
    };
  },
  methods: {
    editUserInfo() {
      this.editedUserInfo = { ...this.userInfo };
      this.dialogVisible = true;
      console.log("dialogvisible....")
    },
    cancelEdit() {
      this.dialogVisible = false;
      this.$refs.editedUserInfoForm.resetFields();
    },
    saveEdit() {
      console.log('保存编辑的用户信息:', this.editedUserInfo);
      // 发送数据到后端的逻辑应该在这里处理
      this.dialogVisible = false;
    },
  },
};
</script>
