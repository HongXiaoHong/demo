const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: [
    'vuetify'
  ], // 跨域解决 https://www.jb51.net/article/226137.htm
  devServer: {
    proxy: {
      '^/apis': {
        target: 'http://localhost:8080/',//接口的前缀
        changeOrigin:true,//虚拟的站点需要更管origin
        pathRewrite:{
          '^/apis':''//重写路径
        }
      }
    }
  }
})
