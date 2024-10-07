import axios from "axios";
import {defineStore} from "pinia";

export const useCouponStore = defineStore("coupon", {
    state: () => ({
        couponList: [],
    }),
    actions: {
        async fetchMyCouponList() {
            try {
                const response = await axios.get("/api/mypage/coupon/me", {
                    withCredentials: true,
                });

                this.couponList = response.data.result;
            } catch (error) {
                console.error("Error fetching myCoupons:", error);
            }
        },
        async getCoupon(couponIdx) {

            try {
                let response = await axios.post(
                    `/api/mypage/coupon/${couponIdx}/issue`
                    ,
                    {
                        withCredentials: true,
                    }
                );

                return response.data.isSuccess;
            } catch (error) {
                console.error("Error get coupon:", error);
            }
        },
    },
});
