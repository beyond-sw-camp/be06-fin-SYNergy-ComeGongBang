<template>
    <div id="app">
    <div id="__nuxt">
      <div
        class="appContainer"
        style="
          --desktop-header-menu-top: 75px;
          --desktop-header-sticky-height: 124px;
        "
        data-v-4e58ad83=""
      >
      <!-- 후기 작성하기 버튼 -->
      <div class="IDSTooltip__trigger" data-v-b6faa6c8="">
        <!--[-->
        <button @click="openModal" type="outline"
          class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline"
          style="
            background-color: #ffffff;
            color: #ef7014;
            height: 44px;
            width: 200px;
            flex-direction: row;
            --core-button-padding-x: 16;
            --button-rectangle-border-color: #ef7014;
                "
            data-v-524f63ea=""
            data-v-7940d6dd=""
            data-v-14aa7a1c=""
            >
        <!----><!--[--><!---->
        <div
          class="inline-flex items-center"
          data-v-524f63ea=""
        >
        <!--[--><!--]-->
        <span
          class="CoreButton__text"
          data-v-524f63ea=""
          >후기 작성하기
          </span>
        </div>
        <!--]-->
        </button>
        <!--]-->
      </div>
      <!-- 후기 작성 모달 -->
      <div class="modal" :class="{'modalOff': !isClick}">
        <div>
          <div class="ProductDetail" data-v-6da505b4="">
            <div class="flex pb-[40px]" data-v-6da505b4="">
              <div class="min-w-[680px] w-[680px] mt-[16px]" data-v-6da505b4="">
                <div id="REVIEW" data-v-6da505b4="">
                  <div data-v-6da505b4="">
                    <div data-v-60bedabc="" class="BaseDialog flex justify-center items-center fixed top-0 left-0"
                      style="--dialog-footer: 64;">
                      <div data-v-60bedabc="" class="BaseDialog__scrim"></div>
                      <div data-v-60bedabc="" class="BaseDialog__wrapper--medium--basic BaseDialog__container"
                        tabindex="0">
                        <div data-v-899a28fb="" data-v-60bedabc="">
                          <div data-v-899a28fb="" class="BaseCommonHeader w-full flex justify-center items-center"><span
                              data-v-899a28fb=""
                              class="BaseCommonHeader__slot flex shrink-0 items-center justify-center grow-0 mx-[8px]"><span
                                data-v-60bedabc="" class="BaseDialog__close flex justify-center items-center">
                                <!-- X 버튼 -->
                                <button @click="closeModal"
                                  data-v-524f63ea="" data-v-778c1d9b="" data-v-60bedabc="" type="button"
                                  class="CoreButton BaseButtonIcon"
                                  style="background-color: transparent; color: rgb(51, 51, 51); height: 40px; width: 40px; flex-direction: column;"><!---->
                                  <svg
                                    data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                                    xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                                    style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                    <g clip-path="url(#clip0_124_2945)">
                                      <path fill-rule="evenodd" clip-rule="evenodd"
                                        d="M18.4697 4.46973L19.5303 5.53039L13.0597 11.9997L19.5303 18.4697L18.4697 19.5304L11.9997 13.0597L5.53033 19.5304L4.46967 18.4697L10.9397 11.9997L4.46967 5.53039L5.53033 4.46973L11.9997 10.9397L18.4697 4.46973Z">
                                      </path>
                                    </g>
                                    <defs>
                                      <clippath id="clip0_124_2945">
                                        <rect width="24" height="24"></rect>
                                      </clippath>
                                    </defs>
                                  </svg>
                                  <div data-v-524f63ea="" class="inline-flex items-center"><!----></div>
                                </button>
                              </span>
                            </span>
                            <span data-v-899a28fb="" class="flex items-center grow">
                              <span
                                data-v-899a28fb=""
                                class="subtitle3-bold-small grow gray-333--text text-center break-all line-clamp-1">후기 작성</span>
                              </span>
                            <span data-v-899a28fb=""
                              class="BaseCommonHeader__slot flex shrink-0 items-center justify-center grow-0 mx-[8px]">
                            </span>
                          </div>
                        </div>
                        <div data-v-60bedabc="" class="BaseDialog__contents"><!---->
                          <div data-v-60bedabc="" class="BaseDialog__contentsInner"><!---->
                            <div class="pb-[16px]">
                              <div class="flex flex-row px-[16px] py-[8px]">
                                <div class="w-[60px] h-[60px] shrink-0">
                                  <div data-v-eee6c6ce="" class="BaseProductCardImage BaseProductCardImage__size--large"
                                    style="--product-card-round: 8;">
                                    <div data-v-eee6c6ce="" class="BaseProductCardImage__image">
                                      <div data-v-db6621f4="" data-v-eee6c6ce=""
                                        class="CoreImageRatio__loadStatus--success CoreImageRatio" radius="8"
                                        style="--ids-image-background: url(https://image.idus.com/image/files/c77e09f10fcd446bb1214326fc89e8a6.jpg); --ids-image-ratio: 1;">
                                        <div data-v-db6621f4="" class="CoreImageRatio__image" role="img" alt=""></div>
                                        <div data-v-dfe5a850="" data-v-db6621f4=""
                                          class="CoreImageDefault CoreImageDefault__display--none"
                                          style="--ids-image-default-size: 100%;">
                                          <svg data-v-6d2bd019=""
                                            data-v-dfe5a850="" width="24" height="24" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreImageDefault__icon"
                                            style="width: 30%; height: 30%; opacity: 1; fill: currentcolor; --BaseIcon-color: #ffffff;">
                                            <path
                                              d="M9.98878 22C8.00515 22 6.20082 21.0922 4.92883 19.4213C3.54252 17.599 3.12786 15.0371 3.84847 12.7341C4.77753 9.75972 7.76195 7.01737 12.3355 7.59565C12.8174 7.65617 13.2993 7.74919 13.7745 7.87134V2H17.2229V9.35067C18.6148 10.1553 19.879 11.0721 21.0008 12.0919L18.9252 14.748C18.4209 14.275 17.6925 13.6911 17.1164 13.2776C17.0761 13.9803 16.9808 14.7659 16.8576 15.4641C16.5594 17.153 15.8254 18.7903 14.6184 20.0253C13.3655 21.3063 11.7797 21.9989 9.9899 21.9989L9.98878 22ZM11.1297 10.8883C8.12842 10.8883 7.23186 13.2361 7.07385 13.7416C6.59531 15.2724 7.04135 16.6262 7.61738 17.3838C8.03653 17.9341 8.96895 18.8239 10.4942 18.5875C12.1786 18.3263 13.2489 16.5388 13.5425 14.8757C13.7353 13.7842 13.8115 12.6803 13.8417 11.415C12.9867 11.0945 12.0453 10.8883 11.1297 10.8883Z">
                                            </path>
                                          </svg>
                                        </div>
                                      </div><!----><!----><!----><!---->
                                    </div>
                                  </div>
                                </div>
                                <div class="pl-[8px] flex-grow">
                                  <div class="body1_regular_small gray-333--text line-clamp-1 text-ellipsis break-all">
                                    무료배송6일발송)1.5L대용량&amp;소분머랭쿠키
                                  </div>
                                  <div class="flex flex-row align-center items-end">
                                    <div
                                      class="text-clamp pt-[4px] flex-grow body3_regular_small gray-999--text whitespace-pre-wrap"
                                      autoresize="" style="overflow: hidden;">
                                      <span>
                                        <span aria-label="• 머랭쿠키 : 대용량1.5L 프레첼머랭 • 수량 : 1">
                                          • 머랭쿠키 : 대용량1.5L 프레첼머랭
                                          • 수량 : 1
                                        </span>
                                      </span>
                                    </div>
                                    <div id="textclamp-after" class="shrink-0 w-[24px] h-[24px]"></div>
                                  </div>
                                </div>
                              </div>
                              <hr data-v-6ef4cf18="" class="BaseDivider w-full !border-t-[1px]"
                                style="--border-color: #f5f5f5;">
                              <div class="flex flex-col items-center p-[16px]">
                                <div class="subtitle2_bold_small gray-333--text pb-[12px]"> 작품은 만족하셨나요? </div>
                                <!-- 별점 체크 -->
                                <div data-v-2c82c531=""
                                  class="BaseRating BaseRating__mode--input BaseRating__sizeText--small"
                                  style="--BaseRating-gap: 6;">
                                  <div data-v-2c82c531="" class="BaseRating__rangeList">
                                    <div v-for="(star, idx) in stars" :key="idx" @click="starCheck(idx + 1)">
                                      <svg
                                      v-if="idx < rating"
                                      data-v-6d2bd019=""
                                      data-v-2c82c531="" width="24" height="24" viewBox="0 0 24 24"
                                      xmlns="http://www.w3.org/2000/svg"
                                      class="BaseIcon star_click BaseRating__rangeListItem"
                                      style="width: 48px; height: 48px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                      <g clip-path="url(#clip0_124_2995)">
                                        <path fill-rule="evenodd" clip-rule="evenodd"
                                          d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z">
                                        </path>
                                      </g>
                                      <defs>
                                        <clippath id="clip0_124_2995">
                                          <rect width="24" height="24"></rect>
                                        </clippath>
                                      </defs> 
                                    </svg>
                                    <svg
                                      v-else
                                      data-v-6d2bd019=""
                                      data-v-2c82c531="" width="24" height="24" viewBox="0 0 24 24"
                                      xmlns="http://www.w3.org/2000/svg"
                                      class="BaseIcon star BaseRating__rangeListItem"
                                      style="width: 48px; height: 48px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                      <g clip-path="url(#clip0_124_2995)">
                                        <path fill-rule="evenodd" clip-rule="evenodd"
                                          d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z">
                                        </path>
                                      </g>
                                      <defs>
                                        <clippath id="clip0_124_2995">
                                          <rect width="24" height="24"></rect>
                                        </clippath>
                                      </defs> 
                                    </svg>
                                    </div> 
                                  </div>
                                  <div data-v-2c82c531="" class="BaseRating__label"><!----><!----></div>
                                </div>
                                <div class="body1_regular_small gray-999--text mt-[12px]">별점을 선택해서 알려주세요</div>
                              </div>
                              <hr data-v-6ef4cf18="" class="BaseDivider w-full !border-t-[4px]"
                                style="--border-color: #f5f5f5;">
                              <div class="p-[16px]">
                                <h5 class="body1_bold_small">사진 후기</h5><!---->
                                <!-- 후기 이미지 업로드 버튼 -->
                                <div class="mt-[8px]">
                                  <input data-v-503775b4="" id="imageUploader"
                                      type="file" name="imageUploader" accept="image/jpeg, image/png"
                                      class="ImageUploader__input" @change="imageUpload" multiple/>
                                  <label data-v-503775b4="" for="imageUploader" class="ImageUploader w-full"> 
                                    <div data-v-503775b4="" class="ImageUploader__viewer">
                                      <button data-v-524f63ea=""
                                        data-v-7940d6dd="" type="outline"
                                        class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline"
                                        style="background-color: rgb(255, 255, 255); color: rgb(239, 112, 20); height: 40px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #ef7014;"><!---->
                                        <svg
                                          data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24"
                                          viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                          class="BaseIcon CoreButton__icon"
                                          style="width: 18px; height: 18px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-right: 2px;">
                                          <g clip-path="url(#clip0_6644_26666)">
                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                              d="M14.0801 2C14.664 2 15.2187 2.25513 15.5986 2.69842L16.714 4H20C21.1046 4 22 4.89543 22 6V18C22 19.1046 21.1046 20 20 20H4C2.89543 20 2 19.1046 2 18V6C2 4.89543 2.89543 4 4 4H7.285L8.40136 2.69842C8.78132 2.25513 9.33602 2 9.91987 2H14.0801ZM12 7C14.7614 7 17 9.23858 17 12C17 14.7614 14.7614 17 12 17C9.23858 17 7 14.7614 7 12C7 9.23858 9.23858 7 12 7ZM12 8.5C10.067 8.5 8.5 10.067 8.5 12C8.5 13.933 10.067 15.5 12 15.5C13.933 15.5 15.5 13.933 15.5 12C15.5 10.067 13.933 8.5 12 8.5Z">
                                            </path>
                                          </g>
                                          <defs>
                                            <clippath id="clip0_6644_26666">
                                              <rect width="24" height="24"></rect>
                                            </clippath>
                                          </defs>
                                        </svg>
                                        <div data-v-524f63ea="" class="inline-flex items-center"><span
                                            data-v-524f63ea="" class="CoreButton__text">사진 첨부하기 </span>
                                            <!-- ({{ images.length }}/6) -->
                                          </div>
                                      </button>
                                    </div>
                                  </label><!---->
                                  <ul class="list-disc body3-regular-medium mt-[12px] ml-[16px] gray-666--text">
                                    <li>사진은 jpg, jpeg, png 형식으로 6개까지 등록가능합니다.</li>
                                    <li>등록된 사진은 드래그하면 순서 변경이 되고, 클릭하면 삭제할 수 있습니다.</li>
                                  </ul>
                                </div>
                                <h5 class="body1_bold_small mt-[16px]">텍스트 후기</h5>
                                <div data-v-be77401d=""
                                  class="BaseTextarea BaseTextarea__type--outline BaseTextarea__fixedSize--small mt-[8px]"
                                  style="--BaseTextarea-min-height: 0; --BaseTextarea-max-height: 0; --BaseTextarea-radius: 2;">
                                  <div data-v-e2593c18="" data-v-be77401d="" class="BaseLabelText BaseTextarea__label"
                                    style="display: none;">
                                    <span data-v-e2593c18="" class="BaseLabelText__text"></span>
                                  <!---->
                                  </div>
                                  <!-- 후기 내용 작성칸 -->
                                  <textarea v-model="reviewText" data-v-be77401d=""
                                    placeholder="최소 15자 이상 작성해주세요." maxlength="1000"
                                    class="BaseTextarea__textarea"></textarea>
                                  <div data-v-be77401d="" class="BaseTextarea__assistiveArea">
                                    <div data-v-86c06fc2="" data-v-be77401d=""
                                      class="BaseTextHelper BaseTextHelper--default"><!---->
                                      <div data-v-86c06fc2="" class="inline-flex items-center"></div>
                                    </div>
                                    <div data-v-612abd8a="" data-v-be77401d=""
                                      class="BaseTextCounter BaseTextCounter--default">
                                      <span data-v-612abd8a="">{{ reviewText.length }}/1000</span>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div data-v-60bedabc=""
                          class="px-[16px] flex justify-center shrink-0 overflow-y-auto BaseDialog__footer pt-[8px] pb-[16px]">
                          <div data-v-60bedabc="" class="grow BaseDialog__footerWrapper">
                            <div class="flex justify-center">
                              <!-- 후기 등록 버튼. 별점과 후기가 15글자 이상일때만 활성화 -->
                              <button 
                                data-v-524f63ea="" data-v-7940d6dd="" type="fill"
                                class="CoreButton BaseButtonRectangle body1-bold-small BaseButtonRectangle__fill BaseButtonRectangle--disabled"
                                style="background-color: rgb(239, 112, 20); height: 40px; width: 328px; flex-direction: row; --core-button-padding-x: 16;"
                                :class="{'CoreButton--disabled' : !canSubmit}" @click="createReview"><!----><!---->
                                <div data-v-524f63ea="" class="inline-flex items-center">
                                  <span data-v-524f63ea="" class="CoreButton__text">
                                    후기 등록하기
                                  </span>
                                </div>
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </div>
</template>
  
<script>
import { mapStores } from "pinia";
import { useReviewCreateStore } from "@/stores/useReviewCreateStore";

export default {
    props: {
    modelValue: {
      type: Number,
      default: 0,
    },
  },
    data() {
        return {
            isClick:false,
            isStarClick:false,
            stars: new Array(5),
            rating: this.modelValue,
            reviewText: '',
            // image: null,
            // images: [],
            // files: [],
            // imageUploaded: null,
        }
    },
    watch: {
      modelValue(val) {
        this.rating = val;
      },
    },
    computed: {
      canSubmit() {
        return this.reviewText.length >= 15 && this.rating > 0;
      },
      ...mapStores(useReviewCreateStore)
    },
    methods: {
      openModal(){
        this.isClick = true;
      },
      closeModal() {
        this.isClick = false;
      },
      starCheck(starCheckIdx){
        this.rating = starCheckIdx;
        this.$emit('update:modelValue', this.rating); 
      },
      // 이미지 업로드. 주석 처리
    
    //   imageUpload(event) {
    //     alert("호출됨");
    //     const files = event.target.files;
    //     const maxFiles = 6;

    //     const files = Array.from(event.target.files);
    // if (files.length + this.images.length <= 6) {
    //   this.images.push(...files);
    // } else {
    //   alert("사진은 최대 6장까지 첨부할 수 있습니다.");
    // }

    //     // 현재 업로드된 파일 수와 새로 업로드하는 파일 수의 합을 계산
    //     const totalFiles = this.images.length + files.length;

    //     // 최대 파일 수를 초과할 경우 경고 메시지를 출력하고 중단
    //     if (totalFiles > maxFiles) {
    //       alert(`최대 ${maxFiles}개의 이미지만 등록할 수 있습니다.`);
    //       return;
    //     }

    //     // 기존 업로드된 파일에 새 파일을 추가 (배열 병합)
    //     const newFiles = Array.from(files);
    //     this.images = [...this.images, ...newFiles].slice(0, maxFiles);

    //     console.log(this.images);
    //   },

      async createReview() {
        console.log("들어오다");
        const review = {
          content : this.reviewText,
          score : this.rating
        }
        const reviewCreateStore = useReviewCreateStore();

        const response = await reviewCreateStore.createReview(review);
        console.log(response);
        if(response === true) {
          alert("후기가 제출되었습니다!");
        } else {
          alert("별점과 리뷰를 입력해주세요.");
        }
      },
      },
    name : 'app',
    components: {

  }
}
</script>
<style scoped>
.modalOff {
  display: none;
}

.star[data-v-2c82c531]{
    color: gray;
}

.star_click[data-v-2c82c531]{
    color: #f2cb61;
}
</style>