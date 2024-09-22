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
    }),
    actions: {
        // 대분류 불러오기
        async loadTopCategories() {
            try {
                let url = '/api/categories/top';
                let response = await axios.get(url);
                this.topCategoriesList = response.data.result;  // 상태 업데이트
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
