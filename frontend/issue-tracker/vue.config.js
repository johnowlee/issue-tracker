const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081,
    client: {
      overlay: false, // ESLint 오류가 브라우저 화면을 막지 않도록 설정
    },
  },
});
