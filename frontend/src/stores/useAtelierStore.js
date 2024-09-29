import { defineStore } from "pinia";
import axios from "axios";

export const useAtelierStore = defineStore("atelier", {
    state: () => ({
        atelierIdx: "",
        atelierProfileImage: "",
        atelierName: "",
        atelierAverageScore: 0,
        havingProductsReviewCount: 0,
        havingProductsLikeCount: 0,
        havingFollowerCount: 0,
        oneLineDescription: "",
        memberIsFollow: false,

        productList:[] //작가 판매 상품 리스트
    }),
    actions:{
        async getProductList(idx){

            let url = `/api/atelier/products?atelierIdx=${idx}`;

            let response = await axios.get(url,{withCredentials:true});
            console.log(response);

            if(response.status===200){
                this.productList = response.data.result;
                alert(this.productList);
            }
        },
        async getAtelierInfo(atelierIdx){
            let url = `/api/atelier/info?atelierIdx=${atelierIdx}`;

            let response = await axios.get(url, {withCredentials:true});
            console.log(response);

            if(response.status === 200){
                this.atelierIdx = response.data.result.atelierIdx;
                this.atelierProfileImage = response.data.result.atelierProfileImage
                this.atelierName = response.data.result.atelierName
                this.atelierAverageScore = response.data.result.atelierAverageScore
                this.havingProductsReviewCount = response.data.result.havingProductsReviewCount
                this.havingProductsLikeCount = response.data.result.havingProductsLikeCount
                this.havingFollowerCount = response.data.result.havingFollowerCount
                this.oneLineDescription = response.data.result.oneLineDescription
                this.memberIsFollow = response.data.result.memberIsFollow

                console.log(this.atelierName);
            }
        },
        async clickFollowBtn(atelierIdx){
            let url = `/api/follow/click`;

            let atelierInfo = {
                "atelierIdx" : atelierIdx
            };

            let response = await axios.post(url,atelierInfo,{withCredentials:true});
            console.log(response);

            if(response.status === 200){
                this.memberIsFollow = response.data.result.memberIsFollow;
                this.havingFollowerCount = response.data.result.havingFollowerCount;
                console.log(this.memberIsFollow);
                console.log(this.havingFollowerCount);
            }
        }
    }
})