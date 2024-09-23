<template>
  <div
    v-if="isCategoryOpen"
    @click.self="closeCategory"
    class="modal-container"
  >
    <div
      style=""
      class="modal-content w-screen white--background left-0 flex flex-col justify-center items-center gray-d9--text border-current"
      data-v-8659a67b=""
      @click.stop
    >
      <div class="w-desktop flex min-h-[390px] pt-[12px]">
        <!-----------------대분류-------------------->
        <div class="flex flex-col w-[220px]">
          <div
            v-for="parent in topCategories"
            :key="parent.idx"
            :class="[
              'w-full h-[48px] flex flex-row items-center justify-between cursor-pointer gray-333--text rounded-[10px] hover:orange-50--background',
              activeTopId === parent.idx
                ? 'orange-500--text orange-50--background'
                : '',
            ]"
            @click="getMiddleCategories(parent.idx)"
          >
            <div class="flex items-center body1-bold-small ml-[12px]">
              {{ parent.categoryName }}
            </div>
            <svg
              data-v-6d2bd019=""
              width="24"
              height="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
              class="BaseIcon mr-[13px]"
              style="
                width: 24px;
                height: 24px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #ffc6a0;
              "
            >
              <g clip-path="url(#clip0_124_2947)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2947">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
          </div>
        </div>
        <div class="white--background pl-[20px]">
          <div class="flex flex-wrap items-start w-[1059px]">
            <div class="w-full grid grid-cols-5 auto-cols-max">
              <div
                v-for="middle in middleCategories"
                :key="middle.idx"
                class="flex flex-col w-[202px] w-full"
              >
                <div
                  class="w-full shrink-0 p-[10px] flex items-center gray-ac--text caption1-bold-small"
                >
                  <span v-if="middle.categoryLevel === 1">
                    {{ middle.categoryName }}
                  </span>
                </div>
              </div>
            </div>
            <div class="w-full grid grid-cols-5 auto-cols-max">
              <div
                v-for="(bottoms, index) in bottomCategoriesLists"
                :key="index"
              >
                <router-link
                  v-for="bottom in bottoms"
                  :key="bottom.idx"
                  :to="{ name: 'categoryProductList', params: { categoryIdx: bottom.idx },}">
                  <span
                    class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                    >{{ bottom.categoryName }}</span
                  >
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="border-b border-current gray-f5--text w-screen h-[1px]"></div>
    </div>
  </div>
</template>

<script>
import { useCategoryStore } from "@/stores/useCategoryStore";
import { defineComponent, onMounted, ref, computed } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "HeaderCategoriesComponent",
  props: {
    isCategoryOpen: {
      type: Boolean,
      required: true,
    },
  },
  setup(props, { emit }) {
    const categoryStore = useCategoryStore();
    const router = useRouter();

    //대분류,중분류,소분류
    const TopCategoryList = ref([]);
    const MiddleCategoryList = ref([]);
    const BottomCategoryLists = ref([]);

    const activeTopId = ref(null); // 현재 선택된 top 카테고리 ID
    const activeMidId = ref(null); // 현재 선택된 middle 카테고리 ID

    const topCategories = computed(() => TopCategoryList.value);
    const middleCategories = computed(() => MiddleCategoryList.value);
    const bottomCategoriesList = computed(() => BottomCategoryLists.value);

    onMounted(async () => {
      try {
        // 부모 카테고리 로드
        await categoryStore.loadTopCategories(); // 대분류 카테고리 리스트 불러오기
        TopCategoryList.value = categoryStore.topCategoriesList || []; // 데이터를 스토어에서 가져옴
        console.log("대분류 카테고리 로드 완료:", TopCategoryList.value);
        const activeTopId = ref(null); // 현재 선택된 대분류 카테고리 ID

        // 첫 번째 대분류 카테고리의 하위 카테고리 자동 로드
        if (categoryStore.topCategoriesList.length > 0) {
          const firstTopIdx = categoryStore.topCategoriesList[0].idx;
          activeTopId.value = firstTopIdx;
          await getMiddleCategories(firstTopIdx);
        }

        // 첫 번째 중분류 선택 후 소분류 로드
        if (MiddleCategoryList.value.length > 0) {
          const firstMidIdx = MiddleCategoryList.value[0].idx;
          activeMidId.value = firstMidIdx;
          await getBottomCategories(firstMidIdx);
        }
      } catch (error) {
        console.error("카테고리 로드 중 오류 발생:", error);
      }
    });

    // 특정 대분류 카테고리의 중분류 카테고리 로드
    const getMiddleCategories = async (parentIdx) => {
      activeTopId.value = parentIdx;
      await categoryStore.loadMiddleCategories(parentIdx);
      MiddleCategoryList.value = categoryStore.middleCategoriesList || [];
      BottomCategoryLists.value = []; // 중분류 클릭 시 소분류 초기화

      // 모든 중분류의 소분류 로드
      const bottomCategoriesPromises = MiddleCategoryList.value.map(
        (middleCategory) => getBottomCategories(middleCategory.idx)
      );

      await Promise.all(bottomCategoriesPromises); // 모든 소분류 로드가 완료될 때까지 대기
      // console.log(
      //   "중분류 카테고리 로드 완료:",
      //   categoryStore.middleCategoriesList
      // );
    };

    const getBottomCategories = async (middleIdx) => {
      activeMidId.value = middleIdx;
      await categoryStore.loadBottomCategories(middleIdx);
      const BottomCategoryList = categoryStore.bottomCategoriesList || [];

      // 중복 체크 후 추가
      const newBottoms = BottomCategoryList.filter(
        (bottom) =>
          !BottomCategoryLists.value
            .flat()
            .some((existing) => existing.idx === bottom.idx)
      );

      if (newBottoms.length > 0) {
        BottomCategoryLists.value.push(newBottoms);
      }
      console.log("소분류 카테고리 로드 완료:", BottomCategoryLists.value);
      console.log("소분류 카테고리 로드 완료:", newBottoms);
    };

    // console.log("선택된 부모카테고리", activeTopId.value);
    // console.log("부모카테고리", categoryStore.parentCategory);

    //소분류 클릭시 이동하기
    // const moveToProductDetail = async (categoryIdx) => {
    //   router.push(`/category/${categoryIdx}`);
    //   closeCategory();
    // };
    

    const closeCategory = () => {
      emit("closeCategory");
    };

    return {
      //selectedChildrenCategories, // 현재 선택된 부모 카테고리의 하위 카테고리 리스트
      topCategories,
      middleCategories,
      bottomCategoriesList,
      bottomCategoriesLists: BottomCategoryLists,
      activeTopId, // 추가: activeParentId를 반환
      closeCategory,
      getMiddleCategories,
      getBottomCategories,
      moveToProductDetail,
    };
  },
});
</script>

<style scoped>
.modal-container {
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 반투명 흰색 배경 */
  z-index: 1200; /* 모달이 다른 콘텐츠 위에 오도록 설정 */
  display: flex;
  justify-content: center;
  align-items: flex-start; /* 상단에 정렬 */
  top: 105px;
}

.modal-content {
  width: 100%;
  padding: 20px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: absolute;
}

.hover\:orange-50--background:hover {
  background-color: #fff7f2; /* hover시 오렌지색 배경 */
  color: #f5923f;
}
</style>