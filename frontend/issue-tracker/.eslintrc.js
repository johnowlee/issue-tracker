module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    "plugin:vue/vue3-essential",
    "eslint:recommended",
    "plugin:prettier/recommended",
  ],
  parserOptions: {
    parser: "@babel/eslint-parser",
  },
  rules: {
    "no-console": process.env.NODE_ENV === "production" ? "warn" : "off",
    "no-debugger": process.env.NODE_ENV === "production" ? "warn" : "off",
    "prettier/prettier": "off", // ✅ Prettier 강제 적용 해제
    "quotes": ["warn", "double"], // ✅ 따옴표 강제 대신 경고
    "semi": ["warn", "always"], // ✅ 세미콜론 강제 대신 경고
    "vue/multi-word-component-names": "off" // ✅ Vue 컴포넌트 네이밍 규칙 해제

  },
};
