<template>
  <div class="sidebar">
    <ul>
      <li v-for="category in categoryList" :key="category.idx">
        <div @click="toggleCategory(category)" class="top-category" :class="{ active: isActiveCategory(category) }">
          {{ category.name }}
          <!-- 화살표 아이콘 (SVG) -->
          <svg
            class="arrow"
            :class="{ open: category.isOpen }"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            stroke-width="2"
          >
            <path stroke-linecap="round" stroke-linejoin="round" d="M19 9l-7 7-7-7" />
          </svg>
        </div>
        <ul v-show="category.isOpen">
          <li
            v-for="subCategory in category.categories"
            :key="subCategory.idx"
            class="sub-category"
            :class="{ active: isSelectedSubCategory(subCategory) }"
          >
            <div @click="toggleSubCategory(subCategory)" class="sub-category-header">
              {{ subCategory.name }}
              <svg
                class="arrow"
                :class="{ open: subCategory.isOpen }"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
              >
                <path stroke-linecap="round" stroke-linejoin="round" d="M19 9l-7 7-7-7" />
              </svg>
            </div>
            <ul v-show="subCategory.isOpen">
              <li
                v-for="subSubCategory in subCategory.subCategories"
                :key="subSubCategory.idx"
                class="sub-sub-category"
                :class="{ selected: isSelectedSubSubCategory(subSubCategory) }"
                @click="selectSubSubCategory(subSubCategory)"
              >
                {{ subSubCategory.name }}
              </li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedSubSubCategory: null,
      selectedSubCategory: null,
      categoryList: [
        {
          idx: 1,
          name: "디저트/음료",
          isOpen: false,
          categories: [
            {
              idx: 1,
              name: "디저트/베이커리",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "디저트/과자" },
                { idx: 2, name: "빵" },
                { idx: 3, name: "케이크/파이" },
                { idx: 4, name: "잼/스프레드" },
              ],
            },
            {
              idx: 2,
              name: "떡/전통간식",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "떡" },
                { idx: 2, name: "전통간식" },
              ],
            },
            {
              idx: 3,
              name: "초콜릿/사탕",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "초콜릿" },
                { idx: 2, name: "사탕" },
                { idx: 3, name: "젤리/케러멜" },
              ],
            },
            {
              idx: 4,
              name: "음료/커피/차",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "커피/원두" },
                { idx: 2, name: "차" },
                { idx: 3, name: "수제청/코디얼" },
                { idx: 4, name: "주스" },
                { idx: 5, name: "즙" },
                { idx: 6, name: "전통음료" },
              ],
            },
            {
              idx: 5,
              name: "전통주",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "소주/증류주" },
                { idx: 2, name: "막걸리" },
                { idx: 3, name: "과실주" },
                { idx: 4, name: "약주" },
                { idx: 5, name: "기타 전통주" },
              ],
            },
          ],
        },
        {
          idx: 2,
          name: "수제먹거리",
          isOpen: false,
          categories: [
            {
              idx: 1,
              name: "건강식품",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "건강식품" },
                { idx: 2, name: "홍삼/인삼/산삼" },
                { idx: 3, name: "건강환" },
              ],
            },
            {
              idx: 2,
              name: "간편식/요리",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "밥/죽" },
                { idx: 2, name: "국/탕/찌개" },
                { idx: 3, name: "면류" },
                { idx: 4, name: "분식" },
                { idx: 5, name: "양식/세계요리" },
                { idx: 6, name: "간편요리" },
              ],
            },
            {
              idx: 3,
              name: "식사대용",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "샐러드" },
                { idx: 2, name: "선식" },
                { idx: 3, name: "시리얼/그래놀라" },
              ],
            },
            {
              idx: 4,
              name: "가공식품",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "양념육/가공육" },
                { idx: 2, name: "수산물" },
                { idx: 3, name: "과채류" },
              ],
            },
            {
              idx: 5,
              name: "김치",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "배추김치" },
                { idx: 2, name: "무/열무김치" },
                { idx: 3, name: "물김치/별미김치" },
              ],
            },
            {
              idx: 6,
              name: "반찬",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "무침/절임" },
                { idx: 2, name: "조림/찜" },
                { idx: 3, name: "볶음" },
                { idx: 4, name: "전/부침" },
                { idx: 5, name: "젓갈" },
                { idx: 6, name: "기타 반찬" },
              ],
            },
            {
              idx: 7,
              name: "소스/장류",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "장류" },
                { idx: 2, name: "소금/조미료" },
                { idx: 3, name: "소스/오일" },
              ],
            },
          ],
        },
        {
          idx: 3,
          name: "농축수산물",
          isOpen: false,
          categories: [
            {
              idx: 1,
              name: "과일/채소",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "전체" },
                { idx: 2, name: "과일" },
                { idx: 3, name: "채소" },
                { idx: 4, name: "쌈/샐러드" },
              ],
            },
            {
              idx: 2,
              name: "잡곡/견과/꿀",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "전체" },
                { idx: 2, name: "곡물" },
                { idx: 3, name: "견과/건과" },
                { idx: 4, name: "꿀/화분" },
              ],
            },
            {
              idx: 3,
              name: "정육/계란",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "전체" },
                { idx: 2, name: "돼지고기" },
                { idx: 3, name: "소고기" },
                { idx: 4, name: "닭/오리고기" },
                { idx: 5, name: "양고기/기타육류" },
                { idx: 6, name: "계란/알류" },
              ],
            },
            {
              idx: 4,
              name: "수산물",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "전체" },
                { idx: 2, name: "생선" },
                { idx: 3, name: "굴비/반건류" },
                { idx: 4, name: "새우/갑각류" },
                { idx: 5, name: "오징어/문어" },
                { idx: 6, name: "해산물/조개" },
                { idx: 7, name: "해조류" },
              ],
            },
            {
              idx: 5,
              name: "유제품",
              isOpen: false,
              subCategories: [
                { idx: 1, name: "전체" },
                { idx: 2, name: "요거트" },
                { idx: 3, name: "우유" },
                { idx: 4, name: "치즈/기타 유제품" },
              ],
            },
          ],
        },
      ],
    };
  },
  methods: {
    toggleCategory(category) {
      category.isOpen = !category.isOpen;
    },
    toggleSubCategory(subCategory) {
      subCategory.isOpen = !subCategory.isOpen;
    },
    selectSubSubCategory(subSubCategory) {
      this.selectedSubSubCategory = subSubCategory;
      this.selectedSubCategory = this.findSubCategory(subSubCategory);
    },
    findSubCategory(subSubCategory) {
      // 선택된 최하위 카테고리의 상위 카테고리를 찾는 함수
      for (let category of this.categoryList) {
        for (let subCategory of category.categories) {
          if (subCategory.subCategories.includes(subSubCategory)) {
            return subCategory;
          }
        }
      }
      return null;
    },
    isActiveCategory(category) {
      // 상위 카테고리가 선택된 최하위 카테고리를 포함하는지 확인
      return category.categories.some((subCategory) => subCategory === this.selectedSubCategory);
    },
    isSelectedSubCategory(subCategory) {
      // 선택된 상위 카테고리인지 확인
      return this.selectedSubCategory === subCategory;
    },
    isSelectedSubSubCategory(subSubCategory) {
      // 최하위 카테고리는 색상이 변하지 않도록 함
      return this.selectedSubSubCategory === subSubCategory;
    },
  },
};
</script>

<style scoped>
.sidebar {
  width: 250px;
  /* background-color: #f9f9f9; */
  padding: 10px;
}

ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

li {
  margin-bottom: 5px;
}

.top-category{
  font-weight: bold;
  text-align: left;
  cursor: pointer;
  display: flex; /* 수평 정렬 */
  justify-content: space-between;
  align-items: center;
}

.sub-category-header {
  text-align: left;
  cursor: pointer;
  display: flex; /* 수평 정렬 */
  justify-content: space-between;
  align-items: center;
}

.sub-category {
  padding-left: 10px;
  font-weight: normal;
  text-align: left;
}

.sub-sub-category {
  padding-left: 20px;
  cursor: pointer;
  text-align: left;
}

.top-category.active {
  font-weight: bold;
}

.sub-category.active {
  font-weight: bold;
}

.sub-sub-category.selected {
  color: orange;
  font-weight: normal; /* 최하위 카테고리는 진해지지 않음 */
}

.arrow {
  transition: transform 0.3s ease;
}

.arrow.open {
  transform: rotate(180deg);
}
svg{
    width: 20px;
}
</style>
