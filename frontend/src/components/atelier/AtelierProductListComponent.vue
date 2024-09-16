<template>
  <div data-v-47adc72d="">
    <div
      data-v-86e49a34=""
      data-v-47adc72d=""
      class="ArtistDesktopProductFilter"
    >
      <div
        data-v-86e49a34=""
        class="ArtistDesktopProductFilte__filterTop"
        style="border-bottom: none"
      >
        <!---->
        <div data-v-86e49a34="" class="ArtistDesktopProductFilter_Right">
          <div
            data-v-86e49a34=""
            class="ArtistDesktopProductFilter__sortSelector"
          >
            <div data-v-4dfbe33c="" data-v-86e49a34="" class="SingleSelector">
              <div data-v-4b6162e7="" data-v-4dfbe33c="" class="BaseSelector">
                <select
                  data-v-4b6162e7=""
                  class="BaseSelector__selector"
                ></select>
                <button
                  data-v-4b6162e7=""
                  type="button"
                  class="BaseSelector__triggerButton BaseSelector__triggerButton--active"
                >
                  <span data-v-4b6162e7="" class="BaseSelector__selectedItem"
                    >인기순</span
                  >
                  <i data-v-4b6162e7="" class="ui-icon fa fa-chevron-up"></i>
                </button>
                <ul
                  data-v-4b6162e7=""
                  class="BaseSelector__optionItemList BaseSelector__optionItemList--active"
                >
                  <li
                    data-v-4b6162e7=""
                    value="sort=-POPULAR"
                    class="BaseSelector__optionItem"
                  >
                    인기순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-CREATED_AT"
                    class="BaseSelector__optionItem"
                  >
                    최신순 (NEW)
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-FAVORITE"
                    class="BaseSelector__optionItem"
                  >
                    찜 많은 순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-REVIEW"
                    class="BaseSelector__optionItem"
                  >
                    구매후기가 많은 순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-PURCHASE"
                    class="BaseSelector__optionItem"
                  >
                    판매수가 많은 순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-SALE_RATE"
                    class="BaseSelector__optionItem"
                  >
                    할인 높은순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=PRICE"
                    class="BaseSelector__optionItem"
                  >
                    낮은 가격순
                  </li>
                  <li
                    data-v-4b6162e7=""
                    value="sort=-PRICE"
                    class="BaseSelector__optionItem"
                  >
                    높은 가격순
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <button
            data-v-86e49a34=""
            class="ArtistDesktopProductFilter__filterBtn"
            style="border: 1px solid rgb(51, 51, 51)"
          >
            필터
            <i data-v-86e49a34="" class="idus-icon-filter"></i>
            <i data-v-86e49a34="" class="idus-icon-arrow up"></i>
            <!---->
          </button>
        </div>
      </div>
      <div data-v-86e49a34="" class="ArtistDesktopProductFilter__filterGroup">
        <div
          data-v-86e49a34=""
          class="ArtistDesktopProductFilter__filterColumn"
        >
          <!---->
          <div
            data-v-17b4f712=""
            data-v-86e49a34=""
            class="DesktopRadioFilterRow"
            style="padding-left: 12px"
          >
            <div data-v-17b4f712="" class="DesktopRadioFilterRow__head">
              배송비
              <!---->
            </div>
            <div data-v-17b4f712="" class="DesktopRadioFilterRow__body">
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name=""
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >전체</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="is_delivery_free=1"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <div data-v-cac2c13c="" data-v-17b4f712="" class="FilterBadge">
                  <div
                    data-v-1c596c18=""
                    data-v-cac2c13c=""
                    class="badge"
                    type="DELIVERY"
                    style="
                      color: rgb(102, 102, 102);
                      background-color: rgb(245, 245, 245);
                    "
                  >
                    <!---->
                    무료배송
                  </div>
                </div>
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >만 보기</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="artist_delivery_style=0&amp;artist_delivery_fee__lte=2500"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >2,500원 이하만 보기</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="artist_delivery_style=0&amp;artist_delivery_fee__lte=3000"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >3,000원 이하만 보기</span
                >
              </div>
            </div>
          </div>
          <!---->
          <div
            data-v-17b4f712=""
            data-v-86e49a34=""
            class="DesktopRadioFilterRow"
            style="padding-left: 12px"
          >
            <div data-v-17b4f712="" class="DesktopRadioFilterRow__head">
              할인율
              <!---->
            </div>
            <div data-v-17b4f712="" class="DesktopRadioFilterRow__body">
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name=""
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >전체</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="sale_state=1&amp;sale_rate__gte=50"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >50% 이상 할인</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="sale_state=1&amp;sale_rate__gte=30"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >30% 이상 할인</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="sale_state=1&amp;sale_rate__gte=20"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >20% 이상 할인</span
                >
              </div>
              <div data-v-17b4f712="" class="DesktopRadioFilterRow__item">
                <label
                  data-v-5476b3d4=""
                  data-v-17b4f712=""
                  type="radio"
                  class="BaseRadio"
                  ><input
                    data-v-5476b3d4=""
                    type="radio"
                    name="sale_state=1&amp;sale_rate__gte=10"
                    autocomplete="off"
                    class="BaseRadio__button idus-icon-radio" />
                  <span data-v-5476b3d4="" class="BaseRadio__label"> </span
                ></label>
                <!---->
                <span data-v-17b4f712="" class="DesktopRadioFilterRow__label"
                  >10% 이상 할인</span
                >
              </div>
            </div>
          </div>
        </div>
        <!---->
      </div>
    </div>
    <div data-v-47adc72d="" class="SearchArea">
      <p data-v-47adc72d="" class="items-size">
        <strong data-v-47adc72d="">6</strong>개의 판매작품
      </p>
      <div data-v-47adc72d="" class="search-section">
        <input
          data-v-47adc72d=""
          type="text"
          placeholder="작가님의 작품 검색"
          class="search-input"
        />
        <i data-v-47adc72d="" class="idus-icon-search"></i>
      </div>
    </div>
    <!-- 상품 리스트 -->
    <ProductList/>
  </div>
</template>

<script>
import ProductList from '../product/ProductListComponent.vue';

export default {
    components:{
        ProductList
    }
};
</script>

<style>
</style>