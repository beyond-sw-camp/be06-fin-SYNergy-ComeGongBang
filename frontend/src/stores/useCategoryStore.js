import { defineStore } from 'pinia';
import axios from 'axios';

export const useCategoryStore = defineStore('category', {
    state: () => ({
        topCategoriesList: [],       // 대분류 리스트
        middleCategoriesList: [],    // 중분류 리스트
        bottomCategoriesList: [],    // 소분류 리스트
        selectedTopCategory: null,    // 선택된 대분류
        selectedMiddleCategory: null, // 선택된 중분류
        selectedBottomCategory: null, // 선택된 소분류
        parentIdx: 0,
        isCategoryVisible : false,
        currentCategoryIdx : null,

        isTopLoaded: false, // 대분류 데이터가 로드되었는지 확인
        isMiddleLoaded: {}, // 중분류 데이터가 로드되었는지 확인 (카테고리별로)
        isBottomLoaded: {}, // 소분류 데이터가 로드되었는지 확인 (중분류별로)

    }),
    actions: {
        //category on off
        openCategory() {
            this.isCategoryVisible = !this.isCategoryVisible;
        },
        closeCategory(){
            this.isCategoryVisible = false;
        },
        // 대분류 불러오기
        async loadTopCategories() {
            try {
                let url = '/api/categories/top';
                let response = await axios.get(url);
                this.topCategoriesList = response.data.result;  // 상태 업데이트
                this.isTopLoaded = true; // 데이터가 로드되었음을 표시

            } catch (error) {
                console.log(error);
            }
        },

        // 중분류 불러오기
        async loadMiddleCategories(topIdx) {
            try {
                let url = `/api/categories/middle/${topIdx}`;
                let response = await axios.get(url);
                this.middleCategoriesList = response.data.result;  // 상태 업데이트
                this.selectedTopCategory = topIdx;  // 대분류 선택 시 상태 저장
                this.isMiddleLoaded[topIdx] = true; // 해당 대분류의 중분류가 로드되었음을 표시

            } catch (error) {
                console.log(error);
            }
        },

        // 소분류 불러오기
        async loadBottomCategories(middleIdx) {
            try {
                let url = `/api/categories/bottom/${middleIdx}`;
                let response = await axios.get(url);
                this.bottomCategoriesList = response.data.result;  // 상태 업데이트
                this.selectedMiddleCategory = middleIdx;  // 중분류 선택 시 상태 저장
                this.isBottomLoaded[middleIdx] = true; // 해당 중분류의 소분류가 로드되었음을 표시

            } catch (error) {
                console.log(error);
            }
        },

        // 대분류 선택
        selectTopCategory(categoryIdx) {
            this.selectedTopCategory = categoryIdx;
            this.loadMiddleCategories(categoryIdx);  // 중분류 불러오기
        },

        // 중분류 선택
        selectMiddleCategory(categoryIdx) {
            this.selectedMiddleCategory = categoryIdx;
            this.loadBottomCategories(categoryIdx);  // 소분류 불러오기
        },
    },
});
