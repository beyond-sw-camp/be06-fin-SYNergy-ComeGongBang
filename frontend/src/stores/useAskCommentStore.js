import axios from "axios";
import { defineStore } from "pinia";
// import { useMemberStore } from "./useMemberStore";
// import { useProductStore } from "./useProductStore";


export const useAskCommentStore = defineStore('askComment', {
    state: () => ({
        productIdx: 0,       // 추후 수정
        askCommentListAll: [],//문의목록리스트
        totalListCount: 0, //전체목록리스트갯수
        isSecret: false,    //비밀댓글유무

        currentPage: 0,   // 현재 페이지 번호
        pageSize: 10,     // 페이지당 받을 아이템 수 
        hasMore: true,      //리스트가 더 남아있는지 여부
        isClickMore: false,    //더보기클릭여부


    }),
    // getters: {
    //     userIdx: () => {
    //         const memberStore = useMemberStore();
    //         return memberStore.member.idx;
    //     },

    //     productIdx: () => {
    //         const productStore = useProductStore();
    //         return productStore.product.idx;
    //     }
    // },
    actions: {
        // 문의작성
        async createAskComment(productIdx, textData) {
            const url = '/api/ask/create';
            const req = {
                // memberIdx: this.userIdx,
                productIdx: productIdx,
                content: textData,
                isSecret: this.isSecret
            }

            try {
                const response = await axios.post(url, req, { withCredential: true });

                // 새 댓글을 목록의 맨 위에 삽입하고, 기존 목록 초기화
                this.askCommentListAll = [response.data.result];

                // 페이지 번호를 0으로 리셋해서, 새로 추가된 댓글이 반영된 목록을 처음부터 불러오게 설정
                this.currentPage = 0;
                console.log(response)
            } catch (error) {
                console.error('Error creating post:', error);
            }
        },

        //문의 목록 조회
        //페이징처리
        async readAllAskCommentList(productIdx, page, size) {
            try {
                let url = `/api/ask/list/read?productIdx=${productIdx}&page=${this.currentPage}&size=${this.pageSize}`;
                const response = await axios.get(url);
                // console.log("store", response);

                // 받아온 데이터가 배열인지 확인
                const responseData = Array.isArray(response.data.result) ? response.data.result : [];

                //받아온 데이터의 길이가 size보다 작을때
                if (responseData.length < size) {
                    this.hasMore = false;
                } else {
                    this.hasMore = true; // 더보기 가능 여부 업데이트
                }
                console.log("this.hasMore", this.hasMore)
                console.log("this.isSecret", this.isSecret)

                // request.askCommentListAll이 배열인지 확인
                this.askCommentListAll = Array.isArray(this.askCommentListAll) ? this.askCommentListAll : [];

                //더보기를 누르면 보여줄 아이템이 쌓이므로 객체에 담아준다.
                // this.askCommentListAll = [...this.askCommentListAll, ...responseData]

                // 받은 데이터를 기존 리스트에 추가하는 로직
                if (page === 0) {
                    this.askCommentListAll = responseData;  // 페이지 0일 때 기존 목록 초기화
                } else {
                    this.askCommentListAll = [...this.askCommentListAll, ...responseData];
                    // console.log("store에서 commentList", this.askCommentListAll, this.currentPage);
                }

                // 페이지 번호 증가
                this.currentPage = page + 1;




                // if (this.hasMore) {
                //     console.log("readAllAskCOmmentList : hasMOre까지")

                //     console.log("hasMore", this.hasMore)

                //     try {
                //         console.log("readAllAskCOmmentList : try")

                //         let url = `/api/ask/list/read?idx=${this.request.productIdx}&page=${page}&size=${size}`;
                //         const response = await axios.get(url);
                //         console.log("댓글storeurl", url)

                //         //받아온 데이터의 길이가 size보다 작을때
                //         if (response.data.result.length < size) {
                //             this.hasMore = false;
                //         }

                //         //더보기를 누르면 보여줄 아이템이 쌓이므로 객체에 담아준다.
                //         this.askCommentListAll = [...response.data.result, ...this.askCommentListAll]
                //         this.currentPage++;
                //         console.log("store에서 commentList", this.askCommentListAll)

                //     } catch (error) {
                //         console.log("readAllAskCOmmentList : catch")

                //         console.log(error);
                //     }
                // }

            } catch (error) {
                console.log(error);
            }
        }
    }
})
