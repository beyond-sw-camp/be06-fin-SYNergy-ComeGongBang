  <template>
  <div
    class="DesktopFollowArtistItem"
    data-v-7ab1112c=""
    v-for="products in productList"
    :key="products.idx"
  >
    <div
      class="flex w-[381px] py-[28px] pl-[31px] pr-[36px] cursor-pointer"
      data-v-7ab1112c=""
    >
      <div
        class="flex items-center w-[100px] relative mr-[32px]"
        data-v-7ab1112c=""
      >
        <div
          class="BaseAvatarArtist"
          style="--overlay-size: 134; --overlay-image: url()"
          data-v-7ab1112c=""
          data-v-4bef34a0=""
        >
          <div
            class="BaseAvatar BaseAvatar--border"
            :style="{
              '--BaseAvatar-image': `url(${products.atelierProfileImages[0]})`,
              '--BaseAvatar-size': '96px',
            }"
            data-v-2fc5c54e=""
            data-v-4bef34a0=""
          >
            <div class="BaseAvatar__avatar" data-v-2fc5c54e="">
              <div class="BaseAvatar__avatarImage" data-v-2fc5c54e=""></div>
            </div>
            <div
              class="CoreBadge BaseAvatar__iconDot"
              style="
                --CoreBadge-color-background: #ef7014;
                --CoreBadge-color-outline: #ffffff;
                --CoreBadge-size: 8;
                --CoreBadge-fontSize: 11;
                --CoreBadge-offset-x: 0;
                --CoreBadge-offset-y: 0;
                --CoreBadge-position: relative;
              "
              data-v-8f163f81=""
              data-v-2fc5c54e=""
            ></div>
            <div
              class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
              style="
                --CoreBadge-color-background: #000000;
                --CoreBadge-color-outline: #ffffff;
                --CoreBadge-size: 28;
                --CoreBadge-fontSize: 11;
                --CoreBadge-offset-x: 0;
                --CoreBadge-offset-y: 0;
                --CoreBadge-position: relative;
              "
              data-v-8f163f81=""
              data-v-2fc5c54e=""
            ></div>
          </div>
          <div class="BaseAvatarArtist__overlay" data-v-4bef34a0=""></div>
        </div>
      </div>
      <div class="min-w-[182px] flex flex-col" data-v-7ab1112c="">
        <p
          class="subtitle3_bold_small mb-[8px] line-clamp-1"
          data-v-7ab1112c=""
        >
          <!-- 춘당사 -->
          {{ products.atelierName }}
        </p>
        <p
          class="body3_regular_medium line-clamp-3 mb-[24px] min-h-[54px]"
          data-v-7ab1112c=""
        >
          <!-- 2018년 4월20일에 매장오픈하고, 서울디저트페어(할로윈전),(딸기전)에
          참여해 완판하고 왔습니다. 이때 아이디어스 직원분께서 저희집 디저트를
          드시고 입점제의가 들어왔구요. 그 분의 인연으로 지금까지 아이디어스에서
          다양한 제품을 선보이고 있답니다 -->
          {{ products.atelierDescription }}
        </p>
        <button
          type="outline"
          class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline min-w-[82px] mr-[1px]"
          style="
            background-color: #ffffff;
            color: #333333;
            height: 32px;
            flex-direction: row;
            --core-button-padding-x: 8;
            --button-rectangle-border-color: #acacac;
          "
          data-v-524f63ea=""
          data-v-7940d6dd=""
          data-v-7ab1112c=""
          v-if="!isFollowing"
          @click="clickFollowBtn(products.atelierIdx)"
        >
          <svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            style="
              width: 16px;
              height: 16px;
              opacity: 1;
              fill: currentColor;
              --BaseIcon-color: #333333;
              margin-right: 2px;
            "
            class="BaseIcon CoreButton__icon"
            data-v-6d2bd019=""
            data-v-524f63ea=""
          >
            <g clip-path="url(#clip0_124_2952)">
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M19.4697 5.46973L20.5303 6.53039L9.53033 17.5304C9.26406 17.7967 8.8474 17.8209 8.55378 17.603L8.46967 17.5304L3.46967 12.5304L4.53033 11.4697L9 15.9391L19.4697 5.46973Z"
              ></path>
            </g>
            <defs>
              <clipPath id="clip0_124_2952">
                <rect width="24" height="24"></rect>
              </clipPath>
            </defs>
          </svg>
          <div class="inline-flex items-center" data-v-524f63ea="">
            <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
              >팔로잉</span
            >
          </div>
          <!--]-->
        </button>
        <button
          v-else
          data-v-524f63ea=""
          data-v-7940d6dd=""
          data-v-7ab1112c=""
          type="outline"
          class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline min-w-[82px] mr-[1px]"
          style="
            background-color: rgb(255, 255, 255);
            color: rgb(239, 112, 20);
            height: 32px;
            flex-direction: row;
            --core-button-padding-x: 8;
            --button-rectangle-border-color: #ef7014;
          "
        >
          <!----><svg
            data-v-6d2bd019=""
            data-v-524f63ea=""
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            class="BaseIcon CoreButton__icon"
            style="
              width: 16px;
              height: 16px;
              opacity: 1;
              fill: currentcolor;
              --BaseIcon-color: #333333;
              margin-right: 2px;
            "
          >
            <g clip-path="url(#clip0_124_2960)">
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"
              ></path>
            </g>
            <defs>
              <clipPath id="clip0_124_2960">
                <rect width="24" height="24"></rect>
              </clipPath>
            </defs>
          </svg>
          <div data-v-524f63ea="" class="inline-flex items-center">
            <span data-v-524f63ea="" class="CoreButton__text">팔로우</span>
          </div>
        </button>
      </div>
    </div>
    <div
      class="w-[100%] flex h-[198px] cursor-pointer"
      data-v-7ab1112c=""
      v-for="images in products.atelierProfileImages"
      :key="images.idx"
    >
      <!--[-->
      <div
        class="BaseImage flex-[1_33%]"
        style="
          --BaseImage-width: 0;
          --BaseImage-height: 0;
          --BaseImage-radius: 0;
        "
        data-v-24b1dfb3=""
        data-v-7ab1112c=""
      >
        <div
          class="BaseImage__image"
          style="background-image: url(${images})"
          data-v-24b1dfb3=""
        >
          <img :src="images" class="hidden" loading="lazy" data-v-24b1dfb3="" />
        </div>
      </div>
    </div>
  </div>

  <div style="display: none" class="PaginationMore" data-v-487afb77="">
    <!---->
  </div>
</template>

  <script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useFollowStore } from "@/stores/useFollowStore";
import { useAtelierStore } from "@/stores/useAtelierStore";
export default defineComponent({
  name: "FollowAtelierListComponent",
  props: {
    productList: {
      type: Object,
      required: true,
    },
  },
  computed: {
    ...mapStores(useFollowStore),
    ...mapStores(useAtelierStore),
    isFollowing() {
      return this.atelierStore.memberIsFollow;
    },
  },
  setup() {
    const atelierStore = useAtelierStore();
    console.log("FollowAtelierListComponent", atelierStore.memberIsFollow);

    // 팔로우 버튼 클릭 시 함수
    const clickFollowBtn = (atelierIdx) => {
      atelierStore.clickFollowBtn(atelierIdx); // atelierIdx를 받아서 처리
    };

    return {
      clickFollowBtn,
    };
  },
});
</script>

  <style scoped>
.DesktopFollowArtistItem[data-v-7ab1112c] {
  align-items: center;
  border-radius: 4px;
  box-shadow: 0 0 4px #00000026;
  display: flex;
  margin-bottom: 10px;
  overflow: hidden;
  margin-top: 10px;
}
</style>