import axios from "axios";
import {defineStore} from "pinia";

export const useCouponStore = defineStore("coupon", {
    state: () => ({
        couponList: [],
        eventCouponList: [],
        queueIdx: null,
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
                //대기열 진입
                if (response.data.code === 2600) {
                    this.queueIdx = response.data.result.queueIdx;
                    return { inQueue: true, queueIdx: this.queueIdx }

                    //대기열 X
                } else {
                    return { inQueue: false, message: response.data.message };
                }

            } catch (error) {
                if (error.response) {
                    return error.response.data;
                } else {
                    return { isSuccess: false, message: "네트워크 오류가 발생했습니다." };
                }
            }
        },
        async fetchQueueStatus(queueIdx) {
            try {
                const response = await axios.get(`/api/queue/rank?queueIdx=${queueIdx}`, {
                    withCredentials: true,
                });
                console.log("response.data.result", response.data.result);
                return response.data.result;
            } catch (error) {
                console.error("Error fetching queue status:", error);
                return { isQueue: true };
            }
        },

        async removeFromQueue(queueIdx){
            try {
            const response = await axios.delete(`/api/queue/${queueIdx}`);
            return response.data;
            } catch (error) {
                console.error("Error deleting queue:", error);
            }

        }


    },
});
