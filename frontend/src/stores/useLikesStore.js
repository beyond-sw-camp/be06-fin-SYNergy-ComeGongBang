import { defineStore } from 'pinia';
import axios from 'axios';

export const useLikesStore = defineStore('likes', {
    state: () => ({
        likedProducts: [],
    }),

    actions: {

        async toggleLike(productIdx) {
            try {

                let productIndex = {
                    "productIdx": productIdx
                }
                await axios.post('/api/likes/toggle', productIndex, { withCredentials: true });
                console.log(this.likedProducts)
                console.log("들어오긴하니")
                // 찜 상태 변경: 해당 상품이 이미 찜한 리스트에 있으면 삭제하고, 없으면 추가
                const existingIndex = this.likedProducts.findIndex(product => product.idx === productIdx);
                console.log("찜상태변경idx", existingIndex)

                if (existingIndex >= 0) {
                    this.likedProducts.splice(existingIndex, 1); // 찜한 목록에서 제거
                } else {
                    const product = await this.fetchProduct(productIdx);
                    this.likedProducts.push({ ...product, liked: true }); // 찜한 목록에 추가
                }
            } catch (error) {
                console.error('Error toggling like:', error);
            }
        },

        async getLikedProductsList() {
            try {
                console.log("제발 들어와")
                const response = await axios.get('/api/likes/list', { withCredentials: true });
                this.likedProducts = response.data.result.map(product => ({ ...product, liked: true })); // 응답 데이터로 업데이트
                console.log("찜한 상품목록 리스트 :", response)
            } catch (error) {
                console.error('찜한 상품리스트 조회:', error);
            }
        },

        // 특정 상품 조회 API
        async getProduct(productIdx) {
            const response = await axios.get(`/product/${productIdx}`, { withCredentials: true });
            return response.data.data; // 상품 데이터 반환
        },
    },
});
