import axios from "axios";
import { defineStore } from "pinia";

export const useAskCommentStore = defineStore('askComment', {
    state: () => ({
        request: {
            productIdx: 0,
            content: "",
            userProfileImg: "",
            atelierProfileImg: "",
            askCommentListAll: [],//문의목록리스트
        },

    }),
    actions: {
        // 문의작성
        async createAskComment() {
            const url = '/proxy/ask/comment/create';

            const req = {
                idx: this.request.productIdx,
                content: this.request.content,
            };

            try {
                // console.log(req);
                const response = await axios.post(url, req);
                console.log('Post created successfully:', response.data);
                // if (response.data.code === 2101) {
                //     alert(response.data.message);
                // } else if (response.data.code === 2102) {
                //     alert(response.data.message);
                // }
            } catch (error) {
                console.error('Error creating post:', error);
            }
        },

        //문의 목록 조회
        async readAllAskCommentList() {
            let url = `/proxy/ask/comment/read?idx=${productIdx}`;
            const response = await axios.get(url);
            try {
                this.askCommentListAll = response.data.result;
                // console.log(response.data.result);

            } catch (error) {
                console.log(error);
            }
        }
    }
})