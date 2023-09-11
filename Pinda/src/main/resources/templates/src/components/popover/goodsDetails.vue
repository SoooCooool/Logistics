<template>
  <el-descriptions
      title="商品详情"
      :column="1"
  >
    <el-descriptions-item label="商品编号">{{ oneGoods.goodsId }}</el-descriptions-item>
    <el-descriptions-item label="商品名称">{{ oneGoods.goodsName }}</el-descriptions-item>
    <el-descriptions-item label="种类">{{ oneGoods.type }}</el-descriptions-item>
    <el-descriptions-item label="平均进货单价">{{ oneGoods.purchasePrice.toFixed(2) }}</el-descriptions-item>
    <el-descriptions-item label="建议零售价">{{ oneGoods.retailPrice.toFixed(2) }}</el-descriptions-item>
    <el-descriptions-item label="总进货量">{{ oneGoods.purchaseQuantity }}</el-descriptions-item>
    <el-descriptions-item label="总销售量">{{ oneGoods.soldQuantity }}</el-descriptions-item>
  </el-descriptions>


</template>

<script>

export default {
  name: "GoodsDetails",
  props: {
    oneGoods:  Object
  }
}
</script>