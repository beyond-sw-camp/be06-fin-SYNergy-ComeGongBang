import axios from "axios";
import {defineStore} from "pinia";

export const useCouponStore = defineStore("coupon", {
    state: () => ({
        couponList: [],
        eventCouponList: [],
    }),
    actions: {
        async fetchMyCouponList() {
            try {
                const response = await axios.get("/api/mypage/coupon/me", {
                    withCredentials: true,
                });

                this.couponList = response.data.result;
                console.log(this.couponList);
            } catch (error) {
                console.error("Error fetching myCoupons:", error);
            }
        },

        async fetchEventCouponList() {
            try {
                const response = await axios.get("/api/mypage/coupon/event", {
                    withCredentials: true,
                });

                this.eventCouponList = response.data.result;
            } catch (error) {
                console.error("Error fetching eventCouponList:", error);
            }
        },

        async getEventCoupon(couponIdx) {

            try {
                const response = await axios.post(
                    `/api/mypage/coupon/${couponIdx}/issue`
                    ,
                    {
                        withCredentials: true,
                    }
                );
                return response.data;
            } catch (error) {
                if (error.response) {
                    return error.response.data;
                } else {
                    return { isSuccess: false, message: "네트워크 오류가 발생했습니다." };
                }
            }
        },
    },
});
