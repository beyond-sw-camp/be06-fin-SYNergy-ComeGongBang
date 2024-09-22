import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[]
    }),
    actions:{
        async searchByCategory(idx, page, size){

            let url = `/api/product/search?categoryIdx=${idx}&page=${page}&size=${size}`;

            let response = await axios.get(url, {withCredentials : false});
            // console.log(response);

            if(response.status===200){
                this.productList = response.data;
            }
        }
    }
})