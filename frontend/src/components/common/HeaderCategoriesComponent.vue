<template>
  <div v-if="isCategoryVisible" @click="closeCategory" class="modal-container">
    <div
      style=""
      class="modal-content w-screen white--background left-0 flex flex-col justify-center items-center gray-d9--text border-current"
      data-v-8659a67b=""
    >
      <div class="w-desktop flex min-h-[390px] pt-[12px]">
        <div class="flex flex-col w-[220px]">
          <div
            v-for="parent in parentCategoryList"
            :key="parent.idx"
            :class="[
              'w-full h-[48px] flex flex-row items-center justify-between cursor-pointer gray-333--text rounded-[10px] hover:orange-50--background',
              activeParentId === parent.idx
                ? 'orange-500--text orange-50--background'
                : '',
            ]"
            @click="childrenCategories(parent.idx)"
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
            <div class="w-full grid grid-cols-1 auto-cols-max">
              <div class="flex flex-col w-[202px] w-full">
                <span
                  v-for="children in selectedChildrenCategories"
                  :key="children.idx"
                  class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                >
                  <!-- @click="moveToProductDetails(children.idx)" -->
                  {{ children.categoryName }}
                </span>
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
// import { useProductStore } from "@/stores/useProductStore";
import { defineComponent, onMounted, ref, computed } from "vue";

export default defineComponent({
  name: "HeaderCategoriesComponent",
  props: {
    isCategoryVisible: {
      type: Boolean,
      required: true,
    },
  },
  setup(props, { emit }) {
    const categoryStore = useCategoryStore();
    // const productStore = useProductStore();
    const parentCategoryList = ref([]);
    const activeParentId = ref(null); // 현재 선택된 부모 카테고리 ID
    console.log("선택된 부모카테고리", activeParentId.value);

    onMounted(async () => {
      try {
        // 부모 카테고리 로드
        await categoryStore.categoryList(); // 부모 카테고리 리스트 불러오기
        parentCategoryList.value = categoryStore.parentCategory || []; // 데이터를 스토어에서 가져옴
        console.log("부모 카테고리 로드 완료:", parentCategoryList.value);
        const activeParentId = ref(null); // 현재 선택된 부모 카테고리 ID

        // 첫 번째 부모 카테고리의 하위 카테고리 자동 로드
        if (categoryStore.parentCategory.length > 0) {
          // 첫 번째 부모 카테고리 선택
          const firstParentIdx = categoryStore.parentCategory[0].idx;
          activeParentId.value = firstParentIdx;
          console.log("선택된 부모카테고리", activeParentId.value);

          // 첫 번째 부모 카테고리의 하위 카테고리 로드
          await categoryStore.childrenCategoryList(firstParentIdx);
          console.log(
            "첫 번째 부모 카테고리 하위 카테고리 로드 완료:",
            categoryStore.childrenCategory
          );
        }
      } catch (error) {
        console.error("카테고리 로드 중 오류 발생:", error);
      }
    });

    // 특정 부모 카테고리의 하위 카테고리를 로드
    const childrenCategories = async (parentIdx) => {
      activeParentId.value = parentIdx;
      console.log(parentIdx);
      await categoryStore.childrenCategoryList(parentIdx);
      console.log("클릭시 하위카테고리", categoryStore.childrenCategory);
    };

    // 선택된 부모 카테고리의 하위 카테고리 리스트를 반환
    const selectedChildrenCategories = computed(() => {
      // activeParentId가 존재할 경우 해당 부모 카테고리의 하위 카테고리 반환
      return categoryStore.childrenCategory || [];
    });

    console.log("선택된 부모카테고리", activeParentId.value);
    console.log("부모카테고리", categoryStore.parentCategory);

    // 클릭시 해당
    // const moveToProductDetail = async (idx) => {
    //   console.log(idx);
    // };

    const closeCategory = () => {
      emit("closeCategory");
    };

    return {
      parentCategoryList, // 기본값 빈 배열, // 부모 카테고리 리스트
      selectedChildrenCategories, // 현재 선택된 부모 카테고리의 하위 카테고리 리스트
      childrenCategories, // 부모 카테고리 선택시 하위 카테고리 변경 함수
      activeParentId, // 추가: activeParentId를 반환
      closeCategory,
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