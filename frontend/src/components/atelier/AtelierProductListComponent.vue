<template>
  <div data-v-47adc72d="">
<!--    <div-->
<!--      data-v-86e49a34=""-->
<!--      data-v-47adc72d=""-->
<!--      class="ArtistDesktopProductFilter"-->
<!--    >-->
<!--      <div-->
<!--        data-v-86e49a34=""-->
<!--        class="ArtistDesktopProductFilte__filterTop"-->
<!--        style="border-bottom: none"-->
<!--      >-->
<!--        &lt;!&ndash;&ndash;&gt;-->
<!--        <div data-v-86e49a34="" class="ArtistDesktopProductFilter_Right">-->
<!--          <div-->
<!--            data-v-86e49a34=""-->
<!--            class="ArtistDesktopProductFilter__sortSelector"-->
<!--          >-->
<!--            <div-->
<!--              data-v-4dfbe33c=""-->
<!--              data-v-86e49a34=""-->
<!--              class="SingleSelector"-->
<!--              @click="sortModalClick"-->
<!--            >-->
<!--              <div data-v-4b6162e7="" data-v-4dfbe33c="" class="BaseSelector">-->
<!--                <select-->
<!--                  data-v-4b6162e7=""-->
<!--                  class="BaseSelector__selector"-->
<!--                ></select>-->
<!--                <button-->
<!--                  data-v-4b6162e7=""-->
<!--                  type="button"-->
<!--                  class="BaseSelector__triggerButton BaseSelector__triggerButton&#45;&#45;active"-->
<!--                >-->
<!--                  <span data-v-4b6162e7="" class="BaseSelector__selectedItem"-->
<!--                    >{{sortType}}</span-->
<!--                  >-->
<!--                  <svg-->
<!--                    data-v-6d2bd019=""-->
<!--                    data-v-2d1923b8=""-->
<!--                    width="24"-->
<!--                    height="24"-->
<!--                    viewBox="0 0 24 24"-->
<!--                    xmlns="http://www.w3.org/2000/svg"-->
<!--                    class="BaseIcon"-->
<!--                    :class="{ rotate: sortModalOn }"-->
<!--                    colors="#999999"-->
<!--                    style="-->
<!--                      width: 20px;-->
<!--                      height: 20px;-->
<!--                      opacity: 1;-->
<!--                      fill: currentcolor;-->
<!--                      &#45;&#45;BaseIcon-color: #333333;-->
<!--                    "-->
<!--                  >-->
<!--                    <g clip-path="url(#clip0_124_2949)">-->
<!--                      <path-->
<!--                        fill-rule="evenodd"-->
<!--                        clip-rule="evenodd"-->
<!--                        d="M17.4697 8.46973L18.5304 9.53039L12.5304 15.5304C12.2641 15.7967 11.8475 15.8209 11.5538 15.603L11.4697 15.5304L5.46973 9.53039L6.53039 8.46973L12.0001 13.9391L17.4697 8.46973Z"-->
<!--                      ></path>-->
<!--                    </g>-->
<!--                    <defs>-->
<!--                      <clipPath id="clip0_124_2949">-->
<!--                        <rect width="24" height="24"></rect>-->
<!--                      </clipPath>-->
<!--                    </defs>-->
<!--                  </svg>-->
<!--                  &lt;!&ndash; <i data-v-4b6162e7="" class="ui-icon fa fa-chevron-up"></i> &ndash;&gt;-->
<!--                </button>-->
<!--                <ul-->
<!--                  data-v-4b6162e7=""-->
<!--                  class="BaseSelector__optionItemList BaseSelector__optionItemList&#45;&#45;active"-->
<!--                  :class="{ 'modal-off': !sortModalOn }"-->
<!--                >-->
<!--                  <li-->
<!--                    data-v-4b6162e7=""-->
<!--                    value="sort=-POPULAR"-->
<!--                    class="BaseSelector__optionItem"-->
<!--                    v-for="(sort, index) in sorts" :key="index"-->
<!--                    @click="sortTypeClick(sort)"-->
<!--                  >-->
<!--                    {{sort}}-->
<!--                  </li>-->
<!--                </ul>-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--          <button-->
<!--            data-v-86e49a34=""-->
<!--            class="ArtistDesktopProductFilter__filterBtn"-->
<!--            style="border: 1px solid rgb(51, 51, 51)"-->
<!--            @click="filterModalClick"-->
<!--          >-->
<!--            필터-->
<!--            &lt;!&ndash; <i data-v-86e49a34="" class="idus-icon-filter"></i>-->
<!--            <i data-v-86e49a34="" class="idus-icon-arrow up"></i> &ndash;&gt;-->
<!--            &lt;!&ndash;&ndash;&gt;-->
<!--            <svg-->
<!--              data-v-6d2bd019=""-->
<!--              data-v-2d1923b8=""-->
<!--              width="24"-->
<!--              height="24"-->
<!--              viewBox="0 0 24 24"-->
<!--              xmlns="http://www.w3.org/2000/svg"-->
<!--              class="BaseIcon" :class="{'rotate':filterModalOn}"-->
<!--              colors="#999999"-->
<!--              style="-->
<!--                width: 20px;-->
<!--                height: 20px;-->
<!--                opacity: 1;-->
<!--                fill: currentcolor;-->
<!--                &#45;&#45;BaseIcon-color: #333333;-->
<!--              "-->
<!--            >-->
<!--              <g clip-path="url(#clip0_124_2949)">-->
<!--                <path-->
<!--                  fill-rule="evenodd"-->
<!--                  clip-rule="evenodd"-->
<!--                  d="M17.4697 8.46973L18.5304 9.53039L12.5304 15.5304C12.2641 15.7967 11.8475 15.8209 11.5538 15.603L11.4697 15.5304L5.46973 9.53039L6.53039 8.46973L12.0001 13.9391L17.4697 8.46973Z"-->
<!--                ></path>-->
<!--              </g>-->
<!--              <defs>-->
<!--                <clipPath id="clip0_124_2949">-->
<!--                  <rect width="24" height="24"></rect>-->
<!--                </clipPath>-->
<!--              </defs>-->
<!--            </svg>-->
<!--          </button>-->
<!--        </div>-->
<!--      </div>-->
<!--      <div-->
<!--        data-v-86e49a34=""-->
<!--        class="ArtistDesktopProductFilter__filterGroup"-->
<!--        :class="{ 'modal-off': !filterModalOn }"-->
<!--      >-->
<!--        <div-->
<!--          data-v-86e49a34=""-->
<!--          class="ArtistDesktopProductFilter__filterColumn"-->
<!--        >-->
<!--          &lt;!&ndash;&ndash;&gt;-->
<!--          <div-->
<!--            data-v-17b4f712=""-->
<!--            data-v-86e49a34=""-->
<!--            class="DesktopRadioFilterRow"-->
<!--            style="padding-left: 12px"-->
<!--          >-->
<!--            <div data-v-17b4f712="" class="DesktopRadioFilterRow__head">-->
<!--              배송비-->
<!--              &lt;!&ndash;&ndash;&gt;-->
<!--            </div>-->
<!--            <div data-v-17b4f712="" class="DesktopRadioFilterRow__body">-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name=""-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >전체</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="is_delivery_free=1"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                <div data-v-cac2c13c="" data-v-17b4f712="" class="FilterBadge">-->
<!--                  <div-->
<!--                    data-v-1c596c18=""-->
<!--                    data-v-cac2c13c=""-->
<!--                    class="badge"-->
<!--                    type="DELIVERY"-->
<!--                    style="-->
<!--                      color: rgb(102, 102, 102);-->
<!--                      background-color: rgb(245, 245, 245);-->
<!--                    "-->
<!--                  >-->
<!--                    &lt;!&ndash;&ndash;&gt;-->
<!--                    무료배송-->
<!--                  </div>-->
<!--                </div>-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >만 보기</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="artist_delivery_style=0&amp;artist_delivery_fee__lte=2500"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >2,500원 이하만 보기</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="artist_delivery_style=0&amp;artist_delivery_fee__lte=3000"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >3,000원 이하만 보기</span-->
<!--                >-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--          &lt;!&ndash;&ndash;&gt;-->
<!--          <div-->
<!--            data-v-17b4f712=""-->
<!--            data-v-86e49a34=""-->
<!--            class="DesktopRadioFilterRow"-->
<!--            style="padding-left: 12px"-->
<!--          >-->
<!--            <div data-v-17b4f712="" class="DesktopRadioFilterRow__head">-->
<!--              할인율-->
<!--              &lt;!&ndash;&ndash;&gt;-->
<!--            </div>-->
<!--            <div data-v-17b4f712="" class="DesktopRadioFilterRow__body">-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name=""-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >전체</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="sale_state=1&amp;sale_rate__gte=50"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >50% 이상 할인</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="sale_state=1&amp;sale_rate__gte=30"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >30% 이상 할인</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="sale_state=1&amp;sale_rate__gte=20"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >20% 이상 할인</span-->
<!--                >-->
<!--              </div>-->
<!--              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">-->
<!--                <label-->
<!--                  data-v-5476b3d4=""-->
<!--                  data-v-17b4f712=""-->
<!--                  type="radio"-->
<!--                  class="BaseRadio"-->
<!--                  ><input-->
<!--                    data-v-5476b3d4=""-->
<!--                    type="radio"-->
<!--                    name="sale_state=1&amp;sale_rate__gte=10"-->
<!--                    autocomplete="off"-->
<!--                    class="BaseRadio__button idus-icon-radio" />-->
<!--                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span-->
<!--                ></label>-->
<!--                &lt;!&ndash;&ndash;&gt;-->
<!--                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"-->
<!--                  >10% 이상 할인</span-->
<!--                >-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--        &lt;!&ndash;&ndash;&gt;-->
<!--      </div>-->
<!--    </div>-->
<!--    <div data-v-47adc72d="" class="SearchArea">-->
<!--      <p data-v-47adc72d="" class="items-size">-->
<!--        <strong data-v-47adc72d="">6</strong>개의 판매작품-->
<!--      </p>-->
<!--      <div data-v-47adc72d="" class="search-section">-->
<!--        <input-->
<!--          data-v-47adc72d=""-->
<!--          type="text"-->
<!--          placeholder="작가님의 작품 검색"-->
<!--          class="search-input"-->
<!--        />-->
<!--        <i data-v-47adc72d="" class="idus-icon-search"></i>-->
<!--      </div>-->
<!--    </div>-->
    <!-- 상품 리스트 -->
    <ProductList :productList="atelierStore.productList"/>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useAtelierStore } from "@/stores/useAtelierStore";
import ProductList from '../product/ProductList4LayoutComponent.vue';

export default {
  data() {
    return {
      sortModalOn: false,
      filterModalOn: false,
      sorts  : ["인기순", "최신순(NEW)", "찜 많은 순", "구매 후기가 많은 순", "판매자 수가 많은 순", "할인 높은순", "낮은 가격순","높은 가격순" ],
      sortType : "인기순"
    };
  },
  props:{
    atelierIdx:{
      type: Number,
      required : true
    }
  },
  components: {
    ProductList,
  },
  computed:{
    ...mapStores(useAtelierStore)
  },
  created(){
    this.getProductList()
  },
  methods: {
    sortModalClick() {
      this.sortModalOn = !this.sortModalOn;
    },
    filterModalClick() {
      this.filterModalOn = !this.filterModalOn;
    },
    sortTypeClick(sort){
        this.sortType = sort;
    },
    async getProductList(){
      await this.atelierStore.getProductList(this.atelierIdx);
    }
  },
};
</script>

<style scoped>
.modal-off {
  display: none;
}
.rotate {
  transform: rotate(180deg);
  transition: transform 0.1s ease-in-out;
}
</style>