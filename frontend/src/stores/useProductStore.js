import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[]
    }),
    actions:{
        async searchByCategory(page, size){
            let url = `/api/search?categoryIdx=1&page=${page}&size=${size}`;

            let response = await axios.get(url);
            // console.log(response);

            if(response.status===200){
                // this.productList = response.data;
                this.productList = [...this.productList, ...response.data];
            }
        }
    }
})