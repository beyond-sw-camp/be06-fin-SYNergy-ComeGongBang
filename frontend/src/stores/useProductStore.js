import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[]
    }),
    actions:{
        async searchByCategory(){
            let url = '/api/search?categoryIdx=1&page=0&size=10';

            let response = await axios.get(url);
            // console.log(response);

            if(response.status===200){
                this.productList = response.data;
            }
        }
    }
})