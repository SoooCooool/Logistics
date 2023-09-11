const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  devServer: {
    port: 80,
    proxy:{
      '/api':{
        target: 'http://buy.csi.cn:8333/api',
        pathRewrite: {
          '/api': ''
        },

      }
    }
  }
}
