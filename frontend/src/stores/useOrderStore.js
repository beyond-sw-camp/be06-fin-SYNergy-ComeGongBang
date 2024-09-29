/* global IMP */

import { defineStore } from "pinia";
import axios from "axios";

export const useOrderStore = defineStore("order", {
    state: () => ({
        orderList:[
            {
                idx : 1,
                date : "2024.09.04",
                price : 10500,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 2,
                date : "2023.08.02",
                price : 20000,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 3,
                date : "2023.02.08",
                price : 20500,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 4,
                date : "2022.01.30",
                price : 10800,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            }
        ],
        years:[
            {
                idx : 1,
                year : "전체"
            },
            {
                idx : 2,
                year : 2024
            },
            {
                idx : 3,
                year : 2023
            },
            {
                idx : 4,
                year : 2022
            }
        ]
    }),
    actions:{
        async getOrderList(){
            // let url = `/api/order/list?year=${year}&keyword=${keyword}&page=0&size=10`;

            // let response = await axios.get(url);
            // // console.log(response);

            // if(response.status===200){
            //     this.orderList = response.data;
            // }
        },
        async validation(impUid){
            let url = `/api/order/confirm${impUid}`;

            let response = await axios.get(url, {withCredentials : true});
            console.log(response);

            if(response.status===200){
                // this.orderList = response.data;
                alert("결제가 완료됐습니다.");
            }else{
                //결제 취소
                alert("결제 정보 저장 실패. 주문한 상품이 환불 처리됐습니다.");
            }
        },
        async makePayment(paymentData) {
            //결제 고유 번호
            let makeMerchantUid = new Date().getMilliseconds();

            //결제 초기화
            IMP.init(process.env.VUE_APP_PORTONE_STORE_ID); // 가맹점 식별코드 
            
            //결제 요청
            IMP.request_pay({
                pg: process.env.VUE_APP_KAKAOPAY_CID, // PG사 코드표에서 선택
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품', // 제품명
                amount: paymentData.totalPrice, // 가격
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
                    console.log(rsp);
					//db 저장
                    let url = `/api/order/confirm?impUid=${rsp.imp_uid}`;

                    let response = await axios.get(url, {withCredentials : true});
                    console.log(response);

                    // if(response.status===200){
                    //     // this.orderList = response.data;
                    //     alert("결제가 완료됐습니다.");
                    // }else{
                    //     //결제 취소
                    //     alert("결제 정보 저장 실패. 주문한 상품이 환불 처리됐습니다.");
                    // }
                } else if (rsp.success == false) { // 결제 실패시
                    alert(rsp.error_msg)
                }
            });
        },
    }
})