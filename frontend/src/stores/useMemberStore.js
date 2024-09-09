import { defineStore } from "pinia";
import axios from "axios";

export const useMemberStore = defineStore('member', {
    state: () => ({
        member : {
            userIdx : "",
            userName : "",
            password:"",
            email : "",
            isLogined : false,
            uuid:"",
        },

        status : 0, 

        electedMyCategories: [],  // 빈 배열로 초기화
        selectedLikeCategories: [],  // 빈 배열로 초기화

        userCategories:[]
    }),
    // persist: true,
    persist:{
        storage: sessionStorage,
    },
    actions:{
        async login(member){
            console.log(member.email);
            console.log(member.password);

            let url = `/api/login`;
            let response = await axios.post(url, member, {withCredentials:false}); //응답 받아서 저장

            console.log(response);
            
            if(response.status === 200){
                this.member.isLogined=true;
                this.member.userIdx=response.data.idx;
                this.member.userName=response.data.nickname;
                this.member.userEmail=response.data.email;

                console.log(this.member);
            }
            return this.member.isLogined;
        },

        async signup(member){
            let url = '/api/member/signup';

            let response = await axios.post(url, member, {withCredentials:false});
            console.log(response);
        },

        async emailRequest(email){
            console.log(email);
            this.member.email = email;

            let emailAuthReq = {
                email : email,
                uuid : "",
            }
            let url = `/api/email/request`
            let response = await axios.post(url, emailAuthReq);
            this.status = response.status;

            console.log("aaaaa" + this.status);
            return this.status;
        },

        async verifyUuid(email, uuid){
            
            this.member.uuid= uuid;

            let emailAuthReq={
                email: email,
                uuid: uuid,
            };

            let url = `/api/email/verify`;

            let response = await axios.post(url, emailAuthReq);
            console.log(response);
            return response;
        },

        logout() {
            this.member.isLogined = false;
            alert("로그아웃이 완료되었습니다.");
        },
        async getUserCategories(){
            let url = `/proxy/my/category`;

            let response = await axios.get(url,{withCredentials:true});
            console.log(response);
            this.userCategories = response.data.result;
        },
        async modify(member){
            let url = `/proxy/member/modify`;

            let response = await axios.post(url, member);
            console.log(response);
        }
    }
})