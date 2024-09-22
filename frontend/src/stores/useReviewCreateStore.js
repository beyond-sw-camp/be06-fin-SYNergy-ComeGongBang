import axios from "axios";
import { defineStore } from "pinia";

export const useReviewCreateStore = defineStore('review', {
    state: () => ({
        review : {
            content : "", // 후기 내용
            score : 0, // 후기 점수
            // images : []
        },
        reviewList:[], // 후기 리스트
    }),

    actions: {
        // 후기 작성
        async createReview(review) {
            let url = `/api/review`;
            console.log("후기 작성 스토어")
            let response = await axios.post(url, review);
            
            if(response.status === 200){
                return true;
            }
            return false;
            
        },

        // 후기 리스트 조회
        async readListReview() {
            let url = `/api/review/list?productIdx=${this.productIdx}`;
            let response = await axios.get(url);
            console.log(response);

            if(response.status === 200) {
                this.reviewList= response.data.result;
            }

        }, 
        
        // 후기 상세 조회
        async readDetailReview() {
            let url = `/api/review/detail?reviewIdx=${this.reviewIdx}`;
            let response = await axios.get(url);
            console.log(response);
            this.review.content = response.data.result.content;
            this.review.score = response.data.result.score;
        }
    }
})