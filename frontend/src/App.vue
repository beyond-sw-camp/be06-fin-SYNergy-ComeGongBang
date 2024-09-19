<template>
  <div>
    <HeaderComponent />
    <router-view></router-view>
    <FooterComponent />
  </div>
</template>

<script>
import FooterComponent from "./components/common/FooterComponent.vue";
import HeaderComponent from "./components/common/HeaderComponent.vue";

export default {
  name: "App",
  components: {
    FooterComponent,
    HeaderComponent,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
