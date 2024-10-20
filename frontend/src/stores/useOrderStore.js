/* global IMP */

import { defineStore } from "pinia";
import axios from "axios";
import swal from 'sweetalert2';

export const useOrderStore = defineStore("order", {
    state: () => ({
        orderList: [],
        years: [
            {
                idx: 1,
                year: "전체"
            },
            {
                idx: 2,
                year: 2024
            },
            {
                idx: 3,
                year: 2023
            },
            {
                idx: 4,
                year: 2022
            }
        ]
    }),
    actions: {
        showAlert(content) {
            swal.fire({
                title: "Oops!",
                text: content,
                icon: "error",
            });
        },
        showSuccessAlert(content) {
            swal.fire({
                title: "Success!",
                text: content,
                icon: "success",
            });
        },
        async getOrderList(year) {
            let url = `/api/order/list?year=${year}&page=0&size=10`;

            let response = await axios.get(url);

            if (response.status === 200) {
                this.orderList = response.data.result;
            }
        },
        async validation(impUid) {
            let url = `/api/order/confirm${impUid}`; //Todo 별 : 이거 뭐여

            let response = await axios.get(url, { withCredentials: true });

            if (response.status === 200) {
                // this.orderList = response.data;
                this.showSuccessAlert("결제가 완료됐습니다.");
            } else {
                //결제 취소
                this.showAlert("결제 정보 저장 실패. 주문한 상품이 환불 처리됐습니다.");
            }
        },
        async makePayment(cartIds, paymentPrice, couponIdx) {

            //결제 고유 번호
            let makeMerchantUid = new Date().getMilliseconds();

            //결제 초기화
            IMP.init(process.env.VUE_APP_PORTONE_STORE_ID); // 가맹점 식별코드

            //커스텀 데이타
            let customData={
                cartIds : cartIds,
                couponIdx : couponIdx
            }

            //결제 요청
            IMP.request_pay({
                pg: process.env.VUE_APP_KAKAOPAY_CID, // PG사 코드표에서 선택
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품', // 제품명
                custom_data: customData, //카트 idx 리스트
                amount: paymentPrice, // 가격
            }, async (rsp) => { // callback
                if (rsp.success) { //결제 성공시
                    //db 저장
                    let url = `/api/order/confirm`;
                    let req = {
                        impUid: rsp.imp_uid
                    }
                    
                    await axios.post(url, req, { withCredentials: true });
                    this.showSuccessAlert("결제가 완료되었습니다.");
                    window.location.href = '/order-list';

                } else if (rsp.success == false) { // 결제 실패시
                    this.showAlert(rsp.error_msg)
                }
            });
        },
        async makePresent(cartIds, paymentPrice, couponIdx, present) {
            //결제 고유 번호
            let makeMerchantUid = new Date().getMilliseconds();

            //결제 초기화
            IMP.init(process.env.VUE_APP_PORTONE_STORE_ID); // 가맹점 식별코드

            //커스텀 데이타
            let customData={
                cartIds : cartIds,
                couponIdx : couponIdx
            }

            //결제 요청
            IMP.request_pay({
                pg: process.env.VUE_APP_KAKAOPAY_CID, // PG사 코드표에서 선택
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품', // 제품명
                custom_data: customData,
                amount: paymentPrice, // 가격
            }, async (rsp) => { // callback
                if (rsp.success) { //결제 성공시
                    //db 저장
                    let url = `/api/order/confirm`;
                    let req = {
                        impUid: rsp.imp_uid,
                        present: present
                    }
                    
                    await axios.post(url, req, { withCredentials: true });

                    window.location.href = "/gift/give/list";

                } else if (rsp.success == false) { // 결제 실패시
                    this.showAlert(rsp.error_msg)
                }
            });
        },
        async isOrdered(productIdx) {
            const response = await axios.get(`/api/order/isOrdered?productIdx=${productIdx}`, { withCredentials: true });
            return response.data.result;
        }
    }
})