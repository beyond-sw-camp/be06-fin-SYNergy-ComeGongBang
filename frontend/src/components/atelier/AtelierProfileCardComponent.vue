<template>
  <div>
    <section
      data-v-10e70ab3=""
      class="quick-profile"
      style="width: 526px; padding: 55px 0px 36px; "
    >
      <div data-v-10e70ab3="" class="profile-area" style="border:0px;">
        <div
          data-v-10e70ab3=""
          href="/profile"
          target="_blank:"
          style="
            width: 108px;
            height: 108px;
            margin-right: 33px;
            position: relative;
          "
          ><img
            data-v-10e70ab3=""
            :src="atelierStore.atelierProfileImage"
            alt="artist thumbnail"
            class="artist-thumbnail"
          />
          <!----></div
        >
        <div data-v-10e70ab3="" class="artist-info">
          <div data-v-10e70ab3="" class="artist-info__head">
            <div data-v-10e70ab3="">
<!--              <a data-v-10e70ab3="" href="/profile" target="_blank">-->
                <p data-v-10e70ab3="" class="artist-info__name">
                  {{ atelierStore.atelierName }}
                  <!---->
                </p>
<!--              </a>-->
              <div data-v-10e70ab3="" class="artist-info__rate star-width">
<!--                별점 컴포넌트-->
                <StarComponent :score="atelierStore.atelierAverageScore"/>
                <span data-v-10e70ab3="" class="marginleft">
                  {{ atelierStore.atelierAverageScore }}
                </span>
                <span data-v-10e70ab3="">
                  ({{ atelierStore.havingProductsReviewCount }})
                </span>
              </div>
            </div>
          </div>
          <div data-v-10e70ab3="" class="artist-info__statistics">
            <div data-v-10e70ab3="" class="data-area">
              <p data-v-10e70ab3="" class="title">작품 찜</p>
              <span data-v-10e70ab3="" class="data">
                {{ atelierStore.havingProductsLikeCount }}
              </span>
            </div>
            <div data-v-10e70ab3="" class="data-area">
              <p data-v-10e70ab3="" class="title">팔로워</p>
              <span data-v-10e70ab3="" class="data">
                {{ atelierStore.havingFollowerCount }}
              </span>
            </div>
            <div data-v-10e70ab3="" class="data-area">
              <p data-v-10e70ab3="" class="title">후원해주신 분들</p>
              <span data-v-10e70ab3="" class="data"> 1.2천 </span>
            </div>
          </div>
        </div>
      </div>
      <div
        data-v-10e70ab3=""
        class="profile-contents"
        style="margin-left: 143px"
      >
        <div data-v-10e70ab3="" class="introduce-area">
          <p data-v-10e70ab3="" class="introduce-txt">
            {{ atelierStore.oneLineDescription }}
          </p>
          <!---->
        </div>
        <div data-v-10e70ab3="" class="btn-group">
          <button
            v-if="!atelierStore.memberIsFollow"
            @click="clickFollowBtn"
            data-v-6271e2da=""
            data-v-10e70ab3=""
            type="button"
            class="follow"
            style="
              background-color: #000;
              height: 36px;
              width: 100%;
              font-size: 14px;
              color: #fff;
              border: 1px solid #000;
              border-radius: 4px;
            "
          >
            <i
              data-v-6271e2da=""
              class="idus-icon-plus"
              style="font-size: 16px"
            ></i>
            팔로우
          </button>
          <button
            v-else
            data-v-6271e2da=""
            @click="clickFollowBtn"
            data-v-10e70ab3=""
            type="button"
            class="following"
            style="
              background-color: rgb(255, 255, 255);
              height: 36px;
              width: 100%;
              font-size: 14px;
              color: rgb(51, 51, 51);
              border: 1px solid rgb(217, 217, 217);
              border-radius: 4px;
            "
          >
            <i
              data-v-6271e2da=""
              class="idus-icon-check"
              style="font-size: 16px"
            ></i>
            팔로우하는 작가
          </button>

          <span
            data-v-2e8f9cd0=""
            data-v-10e70ab3=""
            id="affiliateShare"
            class="ArtistAffiliateShareTooltip"
          >
            <div
              data-v-895af704=""
              data-v-2e8f9cd0=""
              class="ArtistAffiliateShareTooltip__tooltip tooltip"
              style="visibility: hidden"
            >
              <span data-v-2e8f9cd0="" data-v-895af704=""
                ><strong
                  data-v-2e8f9cd0=""
                  data-v-895af704=""
                  class="ArtistAffiliateShareTooltip__tooltipMessageStrong"
                >
                  공유하고 적립금
                </strong>
                받기!
              </span>
              <!---->
              <div data-v-895af704="" class="triangle bottom end">
                <div data-v-895af704="" class="before"></div>
                <div data-v-895af704="" class="after"></div>
              </div>
            </div>
          </span>
          <!---->
          <!---->
        </div>
        <div data-v-10e70ab3="" class="coupon-area"></div>
      </div>
      <!---->
      <div
        data-v-10e70ab3=""
        data-modal-root=""
        data-modal-id="support-artist"
        class="modal root"
        style="display: none"
      >
        <div
          data-v-10e70ab3=""
          data-modal-overlay=""
          class="modal overlay"
        ></div>
        <div
          data-v-10e70ab3=""
          class="modal wrap modal-m donation_content_modal"
        >
          <div data-v-10e70ab3="" class="modal head">
            <h1 data-v-10e70ab3="">후원하기</h1>
            <div
              data-v-10e70ab3=""
              data-modal="close"
              class="modal close"
            ></div>
          </div>
          <section data-v-10e70ab3="" class="modal body">
            <form
              data-v-10e70ab3=""
              data-ui="form-support"
              action="/support/payment"
              class="inner"
            >
              <fieldset data-v-10e70ab3="" class="donation_content bg">
                <label data-v-10e70ab3="" class="flex-span space-between">
                  <div data-v-10e70ab3="" class="flex-span">
                    <input
                      data-v-10e70ab3=""
                      type="radio"
                      name="support"
                      value="1000"
                      checked="checked"
                      class="idus-icon-radio"
                    />
                    <p
                      data-v-10e70ab3=""
                      class="flex-span"
                      style="margin-left: 13px"
                    >
                      <i
                        data-v-10e70ab3=""
                        class="donation_icon idus-icon-donation-01"
                      ></i
                      >시원한 캔음료
                    </p>
                  </div>
                  <p data-v-10e70ab3="">1,000원</p>
                </label>
                <label data-v-10e70ab3="" class="flex-span space-between">
                  <div data-v-10e70ab3="" class="flex-span">
                    <input
                      data-v-10e70ab3=""
                      type="radio"
                      name="support"
                      value="3000"
                      class="idus-icon-radio"
                    />
                    <p
                      data-v-10e70ab3=""
                      class="flex-span"
                      style="margin-left: 13px"
                    >
                      <i
                        data-v-10e70ab3=""
                        class="donation_icon idus-icon-donation-02"
                      ></i
                      >따뜻한 커피
                    </p>
                  </div>
                  <p data-v-10e70ab3="">3,000원</p>
                </label>
                <label data-v-10e70ab3="" class="flex-span space-between">
                  <div data-v-10e70ab3="" class="flex-span">
                    <input
                      data-v-10e70ab3=""
                      type="radio"
                      name="support"
                      value="5000"
                      class="idus-icon-radio"
                    />
                    <p
                      data-v-10e70ab3=""
                      class="flex-span"
                      style="margin-left: 13px"
                    >
                      <i
                        data-v-10e70ab3=""
                        class="donation_icon idus-icon-donation-03"
                      ></i
                      >달콤한 디저트
                    </p>
                  </div>
                  <p data-v-10e70ab3="">5,000원</p>
                </label>
                <label data-v-10e70ab3="" class="flex-span space-between">
                  <div data-v-10e70ab3="" class="flex-span">
                    <input
                      data-v-10e70ab3=""
                      type="radio"
                      name="support"
                      value="10000"
                      class="idus-icon-radio"
                    />
                    <p
                      data-v-10e70ab3=""
                      class="flex-span"
                      style="margin-left: 13px"
                    >
                      <i
                        data-v-10e70ab3=""
                        class="donation_icon idus-icon-donation-04"
                      ></i
                      >든든한 식사
                    </p>
                  </div>
                  <p data-v-10e70ab3="">10,000원</p>
                </label>
              </fieldset>
              <div data-v-10e70ab3="" class="donation_content_bottom flex-span">
                <legend data-v-10e70ab3="" class="donation_content_color">
                  결제방법
                </legend>
                <label data-v-10e70ab3="" style="margin-left: 16px"
                  ><input
                    data-v-10e70ab3=""
                    type="radio"
                    name="payment_type"
                    value="CARD"
                    checked="checked"
                    class="idus-icon-radio"
                  />
                  <span
                    data-v-10e70ab3=""
                    class="donation_content_color"
                    style="padding-left: 2px"
                    >신용카드</span
                  ></label
                >
                <label data-v-10e70ab3="" style="margin-left: 16px"
                  ><input
                    data-v-10e70ab3=""
                    type="radio"
                    name="payment_type"
                    value="CELLPHONE"
                    class="idus-icon-radio"
                  />
                  <span
                    data-v-10e70ab3=""
                    class="donation_content_color"
                    style="padding-left: 2px"
                    >휴대폰</span
                  ></label
                >
              </div>
              <input
                data-v-10e70ab3=""
                type="hidden"
                name="artist_uuid"
                value="503a1b15-8a20-4986-81fd-27b22853c400"
              />
              <input
                data-v-10e70ab3=""
                type="hidden"
                name="call_uri"
                value="https://www.idus.com/w/artist/503a1b15-8a20-4986-81fd-27b22853c400/product"
              />
              <div data-v-10e70ab3="" class="btn-center">
                <button
                  data-v-10e70ab3=""
                  type="submit"
                  class="btn btn-s btn-point"
                >
                  후원하기
                </button>
              </div>
            </form>
          </section>
        </div>
      </div>
    </section>
    <!---->
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useAtelierStore } from "@/stores/useAtelierStore";

import StarComponent from "@/components/common/StarComponent.vue";

export default {
  data() {},
  props: {
    atelierIdx: {
      type: Number,
      required: true,
    },
  },
  components:{
    StarComponent
  },
  computed: {
    ...mapStores(useAtelierStore),
  },
  async mounted() {
    // const atelierIdx = this.getAtelierIdx(); // AtelierIdx 가져오는 로직 추가 (필요 시)
    // if (atelierIdx) {
    await this.atelierStore.getAtelierInfo(this.atelierIdx);
    // }
  },
  methods: {
    async clickFollowBtn() {
      await this.atelierStore.clickFollowBtn(this.atelierIdx);
    },
  },
};
</script>

<style scoped>
.profile-card{
  display : flex;
  padding : 0 6px;
  padding : 25px 0 28px;
  width : 100%;
  border : 1px solid #666666;
}
.marginleft{
  margin-left: 5px;
}
.star-width{
  width: 120px;
}
</style>