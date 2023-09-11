<template>
  <el-card :body-style="{ padding: '5%' }">
    <img
        :src="oneGoods.url"
        class="image"
    />
    <div style="padding: 15px">
      <span>{{ oneGoods.goodsName }}</span>
      <div class="bottom">
        <div class="soldInfo">
          累计已售卖:{{ oneGoods.soldQuantity }}<br>
          建议售卖价格:{{ oneGoods.retailPrice.toFixed(2) }}
        </div>
        <div>
          <div style="display: flex; align-items: center">
            <!--点击出现商品详情(气泡)-->
            <el-popover placement="right" :width="400" trigger="click">
              <template #reference>
                <el-button style="margin-right: 16px" type="primary">
                  <el-icon>
                    <View/>
                  </el-icon>
                  详情
                </el-button>
              </template>
              <GoodsDetails :oneGoods="oneGoods"></GoodsDetails>
            </el-popover>
            <div>
              <el-button @click="data.uploadImageFormVisible = true;hasBeenUpdated;data.newRetailPrice=oneGoods.retailPrice" style="margin-right: 16px" type="warning">
                <el-icon><Edit /></el-icon>
                编辑
              </el-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </el-card>

  <el-dialog v-model="data.uploadImageFormVisible" title="编辑" width="25%">
    <el-form :model="oneGoods" label-width="120px">
      <el-form-item label="更改零售价">
        <el-input v-model="data.newRetailPrice"/>
      </el-form-item>
      <el-form-item label="上传替换图片" >
        <upload-image @send-new-url="getNewUrl"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="data.uploadImageFormVisible = false;data.newImageUrl=null">关闭</el-button>
        <el-button type="primary"
                   @click="data.uploadImageFormVisible = false;uploadNewImage(oneGoods.goodsId,oneGoods.url);data.newImageUrl=null;hasBeenUpdated">
          确认提交并更改
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>


</template>

<script>
//引入popover 气泡卡片
import GoodsDetails from "@/components/popover/goodsDetails";
import UploadImage from "@/components/Upload/UploadImage.vue";
import {getCurrentInstance, inject, reactive} from "vue";
import {ElMessage} from "element-plus";

export default {
  name: "AGoodsCard",
  components: {UploadImage, GoodsDetails},
  props: {
    oneGoods: Object
  },
  setup(props) {
    const axios = inject('axios');
    const {emit} = getCurrentInstance();
    const data = reactive({
      uploadImageFormVisible: false,
      newImageUrl: null,
      newRetailPrice:null
    })

    const hasBeenUpdated = function () {
      emit('hasBeenUpdated',"true")
    }
    const getNewUrl = function (newImageUrl) {
      data.newImageUrl = newImageUrl;
    }

    const uploadNewImage = function (goodsId,goodsUrl) {
      if (data.newImageUrl==null){
        data.newImageUrl=goodsUrl
      }
      const js = JSON.stringify({
        "goodsId": goodsId,
        "retailPrice": data.newRetailPrice,
        "url": data.newImageUrl
      });
      const config = {
        method: 'post',
        url: '/api/goods/update',
        headers: {
          'Content-Type': 'application/json'
        },
        data: js
      };
      axios(config)
          .then(function (response) {
            hasBeenUpdated();
            ElMessage.success('修改成功');
          })
          .catch(function (error) {
            console.log(error);
            ElMessage.error('修改失败');
          });

    }


    return {
      axios,
      hasBeenUpdated,
      data,
      getNewUrl,
      uploadNewImage
    }
  }
}
</script>

<style>
.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.image {
  width: 100%;
  aspect-ratio: 1 / 1;
  object-fit: fill;
}

.soldInfo {
  font-size: 12px;
  color: #999;
}
</style>