const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  devServer: {
    port: 80,
    proxy:{
      '/api':{
        target: 'http://buy.csicn.cn:8333/api',
        pathRewrite: {
          '/api': ''
        },

      }
    }
  }
}
