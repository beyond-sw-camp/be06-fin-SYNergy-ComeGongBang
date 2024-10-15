<template>
  <div>
    <!-- <HeaderComponent /> -->
    <TopHeaderComponent/>
    <MiddleHeaderComponent/>
    <BottomHeaderComponent/>
    <HeaderCategoriesComponent />
    <router-view></router-view>
    <FooterComponent />
  </div>
</template>

<script>
import FooterComponent from "./components/common/FooterComponent.vue";
// import HeaderComponent from "./components/common/HeaderComponent.vue";
import TopHeaderComponent from './components/common/TopHeaderComponent.vue';
import MiddleHeaderComponent from './components/common/MiddleHeaderComponent.vue';
import BottomHeaderComponent from './components/common/BottomHeaderComponent.vue';
import HeaderCategoriesComponent from "@/components/common/HeaderCategoriesComponent.vue";

export default {
  name: "App",
  components: {
    FooterComponent,
    // HeaderComponent,
    TopHeaderComponent,
    MiddleHeaderComponent,
    BottomHeaderComponent,
    HeaderCategoriesComponent
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
