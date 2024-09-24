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
        async getOrderList(year){
            if(year===null){
                alert("nn");
            }else if(year!==null){
                alert(year);
            }
            // let url = `/api/order/list?year=${year}&keyword=${keyword}&page=0&size=10`;

            // let response = await axios.get(url);
            // // console.log(response);

            // if(response.status===200){
            //     this.orderList = response.data;
            // }
        },
        async makePayment() {

            let makeMerchantUid = new Date().getMilliseconds();

            IMP.init(process.env.VUE_APP_PORTONE_STORE_ID); // 가맹점 식별코드 
            IMP.request_pay({
                pg: process.env.VUE_APP_KAKAOPAY_CID, // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품명', // 제품명
                amount: 100, // 가격
                //구매자 정보 ↓
                buyer_email: `qufdl8383@gmail.com`,
                buyer_name: `byul`,
                // buyer_tel : '010-1234-5678',
                // buyer_addr : '서울특별시 강남구 삼성동',
                // buyer_postcode : '123-456'
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
                    console.log(rsp);
					//db 저장
                    this.confirmPayment();
                } else if (rsp.success == false) { // 결제 실패시
                    alert(rsp.error_msg)
                }
            });
        },
        async confirmPayment(){
            let url = `/api/order/confirm`;
            let request = {

            }

            let response = await axios.post(url, request, {withCredentials : true});
            // console.log(response);

            if(response.status===200){
                this.orderList = response.data;
                alert("결제가 완료됐습니다.");
            }else{
                //결제 취소
                alert("결제 정보 저장 실패. 주문한 상품이 환불 처리됐습니다.");
            }
        }
    }
})