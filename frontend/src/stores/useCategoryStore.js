import { defineStore } from 'pinia';
import axios from 'axios';

export const useCategoryStore = defineStore('category', {
    state: () => ({
        parentCategory: [],  //부모
        childrenCategory: [], //자식
        parentIdx: 0,
    }),
    actions: {
        async categoryList() {
            try {
                let url = '/api/categories/parent';
                let response = await axios.get(url);
                this.parentCategory = response.data.result;
                console.log("store-parent", response)
            } catch (error) {
                console.log(error)
            }
        },
        async childrenCategoryList(parentIdx) {
            try {
                let url = `/api/categories/child/${parentIdx}`;
                let response = await axios.get(url);
                this.childrenCategory = response.data.result;
                console.log("store-child", response)
            } catch (error) {
                console.log(error)
            }
        },
    },
});