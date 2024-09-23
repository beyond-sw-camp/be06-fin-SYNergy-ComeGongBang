<template>
  <div id="content" class="content" data-gnb-show="true">
    <div class="artist-home">

      <!-- Profile -->
      <AtelierProfileCardComponent></AtelierProfileCardComponent>

      <!-- bottom -->

      <section class="artist-contents">
        <div data-v-336f120c="">
          <div data-v-336f120c="" data-trigger-detail="true"></div>
          <div
            data-v-336f120c=""
            data-trigger="fixposition"
            style="height: 0px"
          ></div>
          <nav
            data-v-336f120c=""
            data-ui="artist-home-tab-control"
            class="tab-group"
            data-ui-position="default"
          >
            <router-link to="/profile"
              data-v-336f120c=""
              class="tab"
              active-class="active"
              >프로필
            </router-link>
            <router-link to="/products"
              data-v-336f120c=""
              class="tab"
              active-class="active"
              >판매작품
            </router-link>
          </nav>
        </div>
        <!-- 탭 router-view -->
        <div class="contents-container">
            <router-view></router-view>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import AtelierProfileCardComponent from "@/components/atelier/AtelierProfileCardComponent";
export default {
    components:{
      AtelierProfileCardComponent
    }
};
</script>

<style>
.tab-group .tab{
    width: 50% !important;
}
</style>