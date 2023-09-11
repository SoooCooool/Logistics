<template>
  <div class="upload-image">
    <el-form :model="form">
      <div>
        <el-upload
            class="avatar-uploader"
            action="https://pic.csicn.cn/api/index.php"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
        >
          <img v-if="imageUrl" :src="imageUrl" class="avatar"/>
          <el-icon v-else class="avatar-uploader-icon">
            <Plus/>
          </el-icon>
        </el-upload>
      </div>
    </el-form>
  </div>
</template>

<script>
import {ref, inject, getCurrentInstance} from 'vue'
import {ElMessage, ElUpload} from 'element-plus'


export default {
  name: 'UploadImage',
  components: {
    ElUpload,
  },
  setup() {
    let imageUrl = ref('');
    const axios = inject('axios');
    const {emit} = getCurrentInstance();

    const handleAvatarSuccess = (response, uploadFile) => {
      if (response.data.code === 200) {
        imageUrl.value = response.data.url;
        ElMessage.success('上传图片成功');
        sendNewUrl();
      } else {
        ElMessage.error(response.data.message);
      }
    };

    const beforeAvatarUpload = function (rawFile) {
      const form = new FormData();
      form.append('token', 'ca25e59c321feef41fb05bde4df09aa3');
      form.append('image', rawFile);
      const settings = {
        url: 'https://pic.csicn.cn/api/index.php',
        method: 'POST',
        headers: {},
        processData: false,
        contentType: false,
        data: form,
      };
      return axios(settings).then((response) => {
        handleAvatarSuccess(response);
        return false;
      });
    };

    const sendNewUrl = function () {
      emit('sendNewUrl', imageUrl);
    }

    return {
      imageUrl,
      beforeAvatarUpload,
      handleAvatarSuccess,
      sendNewUrl,
    };
  },
};
</script>


<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}

.upload-image {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>