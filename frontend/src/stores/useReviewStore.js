import axios from "axios";
import { defineStore } from "pinia";

export const useReviewStore = defineStore("review", {
  state: () => ({
    review: {
      content: "", // 후기 내용
      score: 0, // 후기 점수
      // images : []
    },
    reviewList: [],
    page: [],
    avgScore: 0,
    writableReviewList:[]
  }),

  actions: {
    // 후기 작성
    async createReview(review) {
      let response = await axios.post("/api/review", review, {
        withCredentials: true,
      });
      if (response.status === 200) {
        return true;
      }
      return false;
    },

    // 후기 리스트 조회
    async fetchReviews(productIdx, page = 0, size = 10) {
      try {
        const response = await axios.get(`/api/review/${productIdx}`, {
          params: {
            page,
            size,
          },
          withCredentials: true,
        });

        this.reviewList = response.data.result.reviewList.content;
        this.page = response.data.result.reviewList.page;
        this.avgScore = response.data.result.avgScore;
      } catch (error) {
        console.error("Failed to fetch review List:", error);
      }
    },

    //내가 작성한 후기
    async fetchMyReviews(page = 0, size = 10) {
      try {
        const response = await axios.get("/api/review/me", {
          params: {
            page,
            size,
          },
          withCredentials: true,
        });

        this.reviewList = response.data.result.content;
        this.page = response.data.result.page;
      } catch (error) {
        console.error("Failed to fetch review List:", error);
      }
    },

    // 후기 상세 조회
    async readDetailReview() {
      let url = `/api/review/detail?reviewIdx=${this.reviewIdx}`;
      let response = await axios.get(url, { withCredentials: true });
      this.review.content = response.data.result.content;
      this.review.score = response.data.result.score;
    },

    //작성 가능한 후기 목록
    async writableReviewList(page, size){
      let url = `/api/review/writable?page=${page}&size=${size}`;
      const response = await axios.get(url, {withCredentials:true});
      this.writableReviewList = response.data.result;
      console.log(response.data.result);
    }
  },
});

