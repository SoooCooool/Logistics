<template>
  <div class="setting">
    <h1>buy-it-now 后端设置</h1>
    <el-form label-width="120px" style="max-width: 600px; margin-top: 20px;">
      <el-form-item label="系统名称">
        <el-input v-model="systemName" placeholder="请输入系统名称"></el-input>
      </el-form-item>
      <el-form-item label="系统 Logo">
        <el-upload
            class="avatar-uploader"
            action=""
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="版权信息">
        <el-input v-model="copyRight" placeholder="请输入版权信息"></el-input>
      </el-form-item>
      <el-form-item label="备案号">
        <el-input v-model="recordNumber" placeholder="请输入备案号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveSettings">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Setting',
  data() {
    return {
      systemName: '',
      imageUrl: '',
      copyRight: '',
      recordNumber: '',
    }
  },
  methods: {
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isPNG = file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
        return false;
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
        return false;
      }
      return true;
    },
    saveSettings() {
      // 将设置保存到后端
      this.$message.success('设置保存成功！');
    }
  }
}
</script>

<style scoped>
.setting {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.el-form-item__label {
  font-weight: bold;
}

.avatar-uploader {
  display: inline-block;
  text-align: center;
  border: 1px dashed #d9d9d9;
  border-radius: 50%;
  cursor: pointer;
  overflow: hidden;
  margin-top: 10px;
}

.avatar {
  width: 100px;
  height: 100px;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
}
</style>

在这里，我们使用了el-form、el-form-item、el-input、el-upload和el-button等Element UI的组件，通过调整样式和添加图片上传功能，让

