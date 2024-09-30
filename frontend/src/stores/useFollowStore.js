import axios from 'axios';
import { defineStore } from 'pinia';

export const useFollowStore = defineStore('review', {
  state: () => ({
    atelierIdx: '', //공방idx
    atelierName: '', //공방이름
    atelierDescription: '', //공방설명
    atelierProfileImage: '', //공방이미지
    productImages: [], //공방상품이미지
    followList: [], //팔로우한 작가들리스트
  }),

  actions: {
    // 팔로우 리스트 조회
    async fetchFollow(page = 0, size = 10) {
      try {
        let url = `/api/follow/list`;
        let response = await axios.get(url, { withCredentials: true },
          { params: { page, size } }
        )
        this.followList = response.data.result;
        this.page = response.data.result.page;
        if (response.status === 200) {
          return this.followList;
        }
      } catch (error) {
        console.error('팔로우 리스트 조회 실패:', error);
      }

    },
  },
});
