import { defineStore } from "pinia";
import axios from "axios";

export const useMemberStore = defineStore('member', {
    state: () => ({
        member : {
            userIdx : "",
            userName : "",
            password:"",
            userEmail : "",
            isLogined : false,
            uuid:"",

            result : false
        },

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
            this.result = true;
            return this.result;
            // let url = `/api/member/login`;

            // let response = await axios.post(url, member, {withCredentials:false}); //응답 받아서 저장
            // if(response.data.isSuccess){
            //     this.member.isLogined=true;
            //     this.member.userIdx=response.data.idx;
            //     this.member.userName=response.data.nickname;
            //     this.member.userEmail=response.data.email;
            //     this.member.isLogined=true;

            //     if(response.data.firstLogin){
            //         let newMember = {
            //             idx:this.member.userIdx,
            //             nickname:this.member.userName,
            //             firstLogin:false
            //         }
            //         this.modify(newMember);
            //     }
            // }
            // return response.data.firstLogin;
        },
        async signup(member){
            let url = '/proxy/member/signup';

            let response = await axios.post(url, member, {withCredentials:false});
            console.log(response);
        },
        async sendEmail(email){

            let emailAuthReq={
                email:email,
                uuid:""
            };

            // console.log(emailAuthReq);

            let url = `/proxy/email/send`

            let response = await axios.post(url, emailAuthReq);
            console.log(response);
        },
        async verify(member){

            let emailAuthReq={
                email:member.email,
                uuid:member.uuid
            }

            let url = `/proxy/email/verify`;

            let response = await axios.post(url, emailAuthReq);
            console.log(response);
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