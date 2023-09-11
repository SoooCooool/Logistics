<template>
  <div class="goods">
    <el-row :gutter="20">
      <el-col
          v-for="(oneGoods) in data.goodsList"
          :key="oneGoods.goodsId"
          :span="6"
          :offset="1.5"
      >
        <AGoodsCard :oneGoods="oneGoods" @has-been-updated="getGoodsList"></AGoodsCard>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AGoodsCard from "@/components/AGoodsCard";
import {inject, onMounted, reactive} from "vue";

export default {
  name: "GoodsView",
  components: {
    AGoodsCard
  },
  setup() {
    onMounted(() => {
      getGoodsList();
    })

    const axios = inject('axios');
    const data = reactive({
      goodsList: []
    });

    const getGoodsList = function() {
      return axios.get('/api/goods/list')
          .then(res => {
            data.goodsList = res.data.extend.goodsList
          })
          .catch(error => {
            console.log(error)
          })
    }



    return {
      axios,
      data,
      getGoodsList
    }
  }
}

</script>