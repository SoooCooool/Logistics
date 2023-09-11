<template>
  <el-form :model="form" label-width="120px">
    <el-form-item label="商品名">
      <el-input v-model="form.goodsName" />
    </el-form-item>
    <el-form-item label="种类">
      <el-select v-model="form.type" placeholder="请选择商品的种类">
        <el-option label="饮料" value="1" />
        <el-option label="其他" value="2" />
      </el-select>
    </el-form-item>
    <el-form-item label="进货价">
      <el-input v-model="form.purchasePrice" />
    </el-form-item>
    <el-form-item label="建议零售价">
      <el-input v-model="form.retailPrice" />
    </el-form-item>
    <el-form-item label="请上传商品图片">
      <upload-image @send-new-url="getImgUrl"></upload-image>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="addGoods">添加</el-button>
      <el-button>重置</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
import {inject, reactive} from "vue";
import UploadImage from "@/components/Upload/UploadImage.vue";
import {ElMessage} from "element-plus";

export default {
  name:"AddGoodsForm",
  components: {UploadImage},
  setup(){
    const axios = inject('axios');
    const form = reactive({
    })
    const getImgUrl = function (url) {
      form.url = url;
    }

    const addGoods = function (){
      const data = JSON.stringify(form);

      const config = {
        method: 'post',
        url: '/api/goods/add',
        headers: {
          'Content-Type': 'application/json'
        },
        data : data
      };

      axios(config)
          .then(function (response) {
            ElMessage.success('添加商品成功');
          })
          .catch(function (error) {
            ElMessage.error('添加商品失败');
            console.log(error);
          });

    }

    return{
      form,
      getImgUrl,
      addGoods
    }
  }
}



</script>