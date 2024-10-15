import { defineStore } from "pinia";
import axios from "axios";
import swal from "sweetalert2";

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
        showAlert(content) {
            swal.fire({
                title: "Oops!",
                text: content,
                icon: "error",
            });
        },
        async getProductList(idx){

            let url = `/api/atelier/products?atelierIdx=${idx}`;

            let response = await axios.get(url,{withCredentials:true});
            console.log(response);

            if(response.status===200){
                this.productList = response.data.result;
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

            }
        },
        async clickFollowBtn(atelierIdx){
            let url = `/api/follow/click`;

            let atelierInfo = {
                "atelierIdx" : atelierIdx
            };

            try {
                let response = await axios.post(url, atelierInfo, {withCredentials: true});

                this.memberIsFollow = response.data.result.memberIsFollow;
                this.havingFollowerCount = response.data.result.havingFollowerCount;
                return this.memberIsFollow;

            } catch(error){
                this.showAlert(error.response.data.message);
                return false;
            }
        }
    }
})