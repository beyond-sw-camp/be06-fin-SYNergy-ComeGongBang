/* global IMP */

import { defineStore } from "pinia";
import axios from "axios";

export const useOrderStore = defineStore("order", {
    state: () => ({
        orderList:[],
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
            let url = `/api/order/list?year=${year}&page=0&size=10`;

            let response = await axios.get(url);

            if(response.status===200){
                this.orderList = response.data.result;
            }
        },
        async validation(impUid){
            let url = `/api/order/confirm${impUid}`; //Todo 별 : 이거 뭐여

            let response = await axios.get(url, {withCredentials : true});

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
                custom_data : paymentData.customData,
                amount: paymentData.totalPrice, // 가격
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
					//db 저장
                    let url = `/api/order/confirm`;
                    let req={
                        impUid : rsp.imp_uid
                    }

                    await axios.post(url, req,{withCredentials : true});
                    alert("결제가 완료되었습니다.");
                    // window.location.href = '/order-list';

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
        async makePresent(paymentData, present) {
            //결제 고유 번호
            let makeMerchantUid = new Date().getMilliseconds();

            //결제 초기화
            IMP.init(process.env.VUE_APP_PORTONE_STORE_ID); // 가맹점 식별코드

            //결제 요청
            IMP.request_pay({
                pg: process.env.VUE_APP_KAKAOPAY_CID, // PG사 코드표에서 선택
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품', // 제품명
                custom_data : paymentData.customData,
                amount: paymentData.totalPrice, // 가격
            }, async function (rsp) { // callback
                if (rsp.success) { //결제 성공시
                    //db 저장
                    let url = `/api/order/confirm`;
                    let req={
                        impUid : rsp.imp_uid,
                        present : present
                    }

                    await axios.post(url, req,{withCredentials : true});

                } else if (rsp.success == false) { // 결제 실패시
                    alert(rsp.error_msg)
                }
            });
        },
    }
})