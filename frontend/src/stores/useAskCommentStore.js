import axios from "axios";
import { defineStore } from "pinia";

export const useAskCommentStore = defineStore('askComment', {
    state: () => ({
        request: {
            productIdx: 0,
            askCommentListAll: [],//문의목록리스트
            totalListCount: 0, //전체목록리스트갯수
            isSecret: 0,    //비밀댓글유무

            currentPage: 0,   // 현재 페이지 번호
            pageSize: 10,     // 페이지당 받을 아이템 수 
            hasMore: true,      //리스트가 더 남아있는지 여부

        },

    }),
    actions: {
        // 문의작성
        async createAskComment(textData) {
            // const url = 'https://d792dcd9-e7f7-4d13-9b15-ec2699a9e775.mock.pstmn.io/ask/comment/create';
            const url = 'proxy/ask/create';
            const req = {
                idx: this.request.productIdx,
                content: textData,
                isSecret: this.isSecret
            }
            try {
                const response = await axios.post(url, req);
                console.log(response)
            } catch (error) {
                console.error('Error creating post:', error);
            }
        },

        //문의 목록 조회
        //페이징처리
        async readAllAskCommentList(page, size) {
            if (this.hasMore) {
                try {
                    let url = `proxy/ask/list/read?idx=${this.request.productIdx}&page=${page}&size=${size}`;
                    // let url = `https://d792dcd9-e7f7-4d13-9b15-ec2699a9e775.mock.pstmn.io/ask/comment/read?idx=${this.request.productIdx}`;
                    const response = await axios.get(url);

                    //받아온 데이터의 길이가 size보다 작을때
                    if (response.data.result.length < size) {
                        this.hasMore = false;
                    }

                    //더보기를 누르면 보여줄 아이템이 쌓이므로 객체에 담아준다.
                    this.askCommentListAll = [...response.data.result, ...this.askCommentListAll]
                    this.currentPage++;
                    console.log("store에서 commentList", this.askCommentListAll)

                } catch (error) {
                    console.log(error);
                }
            }

        }
    }
})

