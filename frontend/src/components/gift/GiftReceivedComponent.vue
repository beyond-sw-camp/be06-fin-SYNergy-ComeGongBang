<template>
  <div class="flex mt-[36px]">
          <div class="w-full pl-6">
            <div class="w-full">
              <div>
                <div
                  class="GiftListCardDesktop__header flex justify-between border-b border-[#333333] items-center py-[12px] border-bottom-black">
                  <div class="flex items-center subtitle2-bold-small gray-333--text"><span
                      class="max-w-[470px] truncate"><span>{{gift.member}}</span></span><span>님에게 받은 선물 ({{gift.count}}건)</span>
                  </div>
                  <router-link to="gift/received/detail">
                    <button
                      data-v-524f63ea="" data-v-8493c3f2="" type="default"
                      class="CoreButton BaseButtonText body1-regular-small !pr-0"
                      style="background-color: transparent; color: rgb(51, 51, 51); height: 32px; flex-direction: row-reverse; --core-button-padding-x: 8; font-weight: normal;"><!----><svg
                        data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                        style="width: 18px; height: 18px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-left: 0px;">
                        <g clip-path="url(#clip0_124_2947)">
                          <path fill-rule="evenodd" clip-rule="evenodd"
                            d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                          </path>
                        </g>
                        <defs>
                          <clippath id="clip0_124_2947">
                            <rect width="24" height="24"></rect>
                          </clippath>
                        </defs>
                      </svg>
                      <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea=""
                          class="CoreButton__text">{{gift.date}}</span></div>
                    </button>
                  </router-link>
                </div>
                <div class="GiftListDesktop mb-[36px]">
                  <table class="min-w-full">
                    <tbody>
                      <tr class="border-b border-[#f5f5f5] border-bottom-gray" v-for="product in gift.products" :key="product.idx">
                        <td class="cursor-pointer">
                          <div data-v-6d999c42=""
                            class="DesktopGiftSendListItemProlduct flex w-full group my-[16px] pr-[16px]"
                            product-state="SHIPPED">
                            <div data-v-6d999c42="" class="mr-[12px] cursor-pointer">
                              <div data-v-24b1dfb3="" data-v-6d999c42=""
                                class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight BaseImage__hover"
                                style="--BaseImage-width: 64; --BaseImage-height: 64; --BaseImage-radius: 2;">
                                <div data-v-24b1dfb3="" class="BaseImage__image">
                                  <img data-v-24b1dfb3=""
                                    :src="product.imageUrl">
                                </div>
                              </div>
                            </div>
                            <div data-v-6d999c42="" class="flex flex-col">
                              <div data-v-6d999c42="" class="flex justify-start mb-[6px]">
                                <div data-v-b6faa6c8="" data-v-6d999c42=""
                                  class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__colorType--gray IDSTooltip__innerPosition--right IDSTooltip__innerAlign--center IDSTooltip__innerCloseAlign--center"
                                  style="--ids-tooltip-full-left: --8px;">
                                  <div data-v-b6faa6c8="" class="IDSTooltip__trigger">
                                    <div data-v-24a9185e="" data-v-6d999c42=""
                                      class="BaseBadgeBusiness BaseBadgeBusiness__colorType--orange-500 BaseBadgeBusiness__size--large BaseBadgeBusiness__style--round"
                                      style="font-weight: normal; color: rgb(102, 102, 102); background-color: rgb(245, 245, 245);">
                                      <!----> {{product.state}} </div>
                                  </div><!---->
                                </div>
                              </div>
                              <p data-v-6d999c42=""
                                class="body1-regular-small gray-333--text cursor-pointer line-clamp-1">
                                {{product.productName}}</p>
                              <p data-v-6d999c42=""
                                class="body3-regular-small gray-999--text mt-[4px] text-align-left">{{product.atelierName}}</p>
                            </div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div><!---->
            </div>
          </div>
        </div>
</template>

<script>

export default {
  props:{
    gift : {
      type : Object,
      required : true
    }
  }
}
</script>

<style scoped>
.border-bottom-black{
    border-bottom: solid black 1px;
}
.border-bottom-gray{
    border-bottom: solid rgb(246, 246, 246) 1px;
}
.text-align-left{
    text-align: left;
}

</style>