<!-- BaseTabsComponent.vue -->
<template>
  <div
    class="BaseTabs BaseTabs__size--large BaseTabs--full BaseTabs__style--filled BaseTabs__border--bottom BaseTabs__align--left"
    style="--BaseTabs-item-length: 3; --BaseTabs-margin-x: 0"
    data-v-de0565e1=""
  >
    <div div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
      <div
        v-for="(tab, index) in tabs"
        :key="index"
        :class="[
          'BaseTab BaseTab--divider',
          { 'BaseTab--active': activeTab === index },
        ]"
        style=""
        border-top="false"
        border-bottom="true"
        data-v-47c662bd=""
        data-v-de0565e1=""
        role="tab"
        @click="handleTabClick(index)"
      >
        <div class="BaseTab__contents" data-v-47c662bd="">
          <div class="BaseTab__prefix" data-v-47c662bd=""></div>
          <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
            <div class="BaseFontVariable__text" data-v-9dbc8be1="">
              <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1=""
                >{{ tab.title }} </span
              ><span
                class="BaseFontVariable__text--display"
                data-v-9dbc8be1=""
                >{{ tab.title }}</span
              >
            </div>
            <span
              class="flex-auto inline-flex items-center"
              data-v-9dbc8be1=""
            ></span>
          </div>
        </div>
        <div class="BaseTab__empty" data-v-47c662bd=""></div>
        <div class="BaseTab__activator" data-v-47c662bd=""></div>
      </div>
    </div>
  </div>
</template>
  
  <script>
export default {
  name: "BaseTabsComponent",
  props: {
    tabs: {
      type: Array,
      required: true,
    },
    activeTab: {
      type: Number,
      required: true,
    },
  },
  emits: ["update:activeTab"],
  methods: {
    handleTabClick(index) {
      console.log("Clicked Tab Index:", index);
      this.$emit("update:activeTab", index);
    },
  },
};
</script>
  