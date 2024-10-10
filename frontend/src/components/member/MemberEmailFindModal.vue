<template>

  <div data-v-60bedabc="" class="BaseDialog flex justify-center items-center fixed top-0 left-0"
       style="--dialog-footer: 64;">
    <div data-v-60bedabc="" class="BaseDialog__scrim"></div>
    <div data-v-60bedabc="" class="BaseDialog__wrapper--small--basic BaseDialog__container" tabindex="0">
      <div data-v-60bedabc="" class="BaseDialog__contents">
        <div data-v-60bedabc="" class="BaseDialog__contentsInner">
          <div class="px-[16px] pt-[24px] pb-[16px]">
            <div class="text-center">
              <h3 class="subtitle3-bold-medium mb-[10px] gray-333--text whitespace-pre-wrap">이메일을 발송했습니다.</h3>
              <p class="body1-regular-medium gray-666--text whitespace-pre-line">{{ email }}에서 계정 정보를 확인해주세요.
              </p>
            </div>
          </div>
        </div>
      </div>

      <div data-v-60bedabc=""
           class="px-[16px] flex justify-center shrink-0 overflow-y-auto BaseDialog__footer pt-[8px] pb-[16px]">
        <div data-v-60bedabc="" class="grow BaseDialog__footerWrapper--fixed">
          <div>
            <button
                @click="closeModal"
                data-v-524f63ea="" data-v-7940d6dd="" type="fill"
                       class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__fill"
                       style="background-color: rgb(27, 27, 27); color: rgb(255, 255, 255); height: 40px; flex-direction: row; --core-button-padding-x: 16;">
            <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">확인</span></div>
          </button>
          </div>
        </div>
      </div>

    </div>
  </div><!---->
  <div class="BaseSnackbar__fadeOut !hidden BaseSnackbar" data-v-ac6313c6="">
    <div class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]" data-v-ac6313c6=""><!---->
      <div class="body1-regular-medium line-clamp-2 whitespace-pre-line" data-v-ac6313c6=""></div><!---->
    </div>
  </div>

</template>

<script>
export default {
  props: {
    email: String
  },

  methods: {
    closeModal() {
      this.$emit('close');
    },
  },
}
</script>

<style scoped>

</style>