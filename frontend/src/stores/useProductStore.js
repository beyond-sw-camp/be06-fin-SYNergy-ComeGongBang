import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[],
        hashTagProductList:[],
        keyword:"",
        hashtagIdx : null,

        //카테고리 리스트에서 사용
        selectedPriceIndex : 0,
        selectedSortIndex : 0,

        //------------------상품 상세 조회 결과---------------------
        productDetail : {},

        //------------------상품 옵션 선택 정보---------------------
        selectedOptions : [],

    }),
    actions:{
        //키워드 검색
        async searchByKeyword(keyword, page, size, price, sort){

            let req={
                keyword : keyword,
                page : page,
                size : size,
                price : price,
                sort : sort
            }

            let url = `/api/product/search`;

            let response = await axios.post(url, req, {withCredentials : false});

            if(response.status===200){
                // this.productList = response.data;
                this.productList.push(...response.data);
            }
        },
        // 상품 카테고리 검색
        async searchByCategory(idx, page, size, price, sort){
            // console.log(idx);
            let req={
                categoryIdx : idx,
                page : page,
                size : size,
                price : price,
                sort : sort
            }

            let url = `/api/product/search/category`;

            let response = await axios.post(url, req,{withCredentials : true});

            if(response.status===200){
                // this.productList = response.data;
                this.productList.push(...response.data.result);
            }
        },
        //상품 해시태그 검색
        async searchByHashTag(idx, page, size, price, sort){
            let req={
                idx : idx,
                page : page,
                size : size,
                price : price,
                sort : sort
            }


            let url = `/api/product/search/hashtag`;

            let response = await axios.post(url, req, {withCredentials : false});

            if(response.status===200){
                // this.hashTagProductList = response.data;
                this.hashTagProductList.push(...response.data.result);
                // console.log(response.data.result);
                return response.data.result;
            }
            return [];
        },
        //상품 상세 검색
        async getProductDetail(params){
            let url = `/api/product/detail/${params}`;

            let response = await axios.get(url, {withCredentials : false});

            if(response.status===200){
                this.productDetail = response.data.result;
            }
        }
    }
})
