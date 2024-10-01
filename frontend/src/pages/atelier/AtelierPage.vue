<template>
  <div id="content" class="content" data-gnb-show="true">
    <div class="artist-home">

      <!-- Profile -->
      <AtelierProfileCardComponent :atelierIdx="atelierIdx"></AtelierProfileCardComponent>

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
<!--            Todo 일단 중간발표때문에 가려둠-->
<!--            <router-link to="/profile"-->
<!--              data-v-336f120c=""-->
<!--              class="tab"-->
<!--              active-class="active"-->
<!--              >프로필-->
<!--            </router-link>-->
<!--            <router-link to="/products"-->
<!--              data-v-336f120c=""-->
<!--              class="tab"-->
<!--              active-class="active"-->
<!--              >-->
<!--              판매작품-->
<!--            </router-link>-->
          </nav>
        </div>
        <!-- 탭 router-view -->
        <div class="contents-container">
            <router-view></router-view>
          <AtelierProductListComponent :atelierIdx="atelierIdx"/>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import AtelierProfileCardComponent from "@/components/atelier/AtelierProfileCardComponent.vue";
import AtelierProductListComponent from "@/components/atelier/AtelierProductListComponent.vue";
export default {
    components:{
      AtelierProfileCardComponent,
      AtelierProductListComponent
    },
  data(){
      return{
        atelierIdx: null,
      }
  }
  ,created() {
      this.atelierIdx = this.$route.params.idx;
  }
};
</script>

<style>
.tab-group .tab{
   /* width: 50% !important;*/ /* todo 작가 프로필 주석 없애면 다시 이걸로 */
  width: 100% !important;
}
</style>