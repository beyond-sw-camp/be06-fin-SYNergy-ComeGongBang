import { defineStore } from "pinia";
import axios from "axios";

export const useAtelierStore = defineStore("atelier", {
    state: () => ({
        productList:[] //작가 판매 상품 리스트
    }),
    actions:{
        async getProductList(idx){

            let url = `/api/atelier/products?idx=${idx}`;

            let response = await axios.get(url);
            console.log(response);

            if(response.status===200){
                this.productList = response.data.result;
            }
        }
    }
})