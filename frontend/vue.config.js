const { defineConfig } = require('@vue/cli-service');
module.exports = defineConfig({
  devServer: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080', //localhost:8080
        changeOrigin: true,
        pathRewrite: { '^/api': '' },
      },
      '/social': {
        target: 'http://localhost:8080', //localhost:8080
        changeOrigin: true,
        pathRewrite: { '^/social': '' },
      },
    },
  },
  transpileDependencies: true,
});
