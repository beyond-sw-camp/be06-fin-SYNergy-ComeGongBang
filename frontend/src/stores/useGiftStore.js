import { defineStore } from "pinia";
import axios from "axios";

export const useGiftStore = defineStore("gift", {
    state: () => ({
        giftGiveList:[],
        giftReceivedList:[],
        giftGiveDetailInfo:{
            idx : 1,
            count : 2,
            date : "2024.09.12",
            toUser : "요아정완",
            toPhone : "010-7280-0916",
            message : "for you~~~",
            price : 12000,
            discount : 300,
            savings : 100,
            deliveryFee : 2500,
            totalPrice : 14100,
            payment : "카카오페이",
            products:[
                {
                    idx : 1,
                    state : "취소 완료",
                    name : "도라지 정과",
                    atelier : "한길로 그대로",
                    image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-09-12+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+4.11.19.png"
                },
                {
                    idx : 2,
                    state : "취소 완료",
                    name : "머랭쿠키",
                    atelier : "짱맛있어",
                    image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png"
                }
            ]
        },
        giftReceivedDetailInfo:{
            idx : 1,
            count : 2,
            date : "2024.09.12",
            fromUser : "요아정완",
            message : "for you~~~",
            price : 12000,
            discount : 300,
            savings : 100,
            deliveryFee : 2500,
            totagitlPrice : 14100,
            payment : "카카오페이",
            status : 1, //선물받기 완료된 상태 - 임시
            deliveryStatus : "작가 발송 완료",
            deliveryInfo:{
                toUser : "한별",
                phone : "01072800916",
                post : 1234,
                address : "서울시 관악구 어쩌고",
                addressDetail : "4층"
            },
            products:[
                {
                    idx : 1,
                    state : "취소 완료",
                    name : "도라지 정과",
                    atelier : "한길로 그대로",
                    count : 1,
                    image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-09-12+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+4.11.19.png"
                },
                {
                    idx : 2,
                    state : "취소 완료",
                    name : "머랭쿠키",
                    atelier : "짱맛있어",
                    count : 1,
                    image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png"
                }
            ]
        }

    }),
    actions:{
        async getGiftGiveList(){
            let url = '/social/present/give';

            try {
                let response = await axios.get(url, {withCredentials: true});
                console.log(response);

                if (response.data.isSuccess) {
                    this.giftGiveList = response.data.result;
                }
            } catch(error){
                // 401 에러 체크
                if (error.response && error.response.status === 401) {
                    const redirectUrl = error.response.data.redirectUrl; // 리다이렉트 URL 가져오기
                    if (redirectUrl) {
                        window.location.href = redirectUrl; // 로그인 페이지로 리다이렉트
                    }
                }
            }
        },
        async getGiftReceivedList(){
            let url = '/social/present/take';

            try {
                let response = await axios.get(url, {withCredentials: true});

                if (response.data.isSuccess) {
                    this.giftReceivedList = response.data.result;
                }
            } catch (error){
                // 401 에러 체크
                if (error.response && error.response.status === 401) {
                    const redirectUrl = error.response.data.redirectUrl; // 리다이렉트 URL 가져오기
                    if (redirectUrl) {
                        window.location.href = redirectUrl; // 로그인 페이지로 리다이렉트
                    }
                }
            }
        },

    }
})