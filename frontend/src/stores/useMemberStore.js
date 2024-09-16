import { defineStore } from "pinia";
import axios from "axios";

export const useMemberStore = defineStore('member', {
    state: () => ({
        member : {
            idx : "",
            nickname : "",
            email : "",
            cellphone : "010-test-test",
            defaultAddress : "",
            profileImageUrl : "",
            isLogined : false,
        },

        newMemberInfo : {
            nickname : "",
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
                // this.member.idx=response.data.idx;
                // this.member.nickname=response.data.nickname;
                // this.member.userEmail=response.data.email;

                console.log(this.member);
            }
            return this.member.isLogined;
        },
        async getMemberInfo(){
            let url = `/api/member/login`;
            let response = await axios.get(url,{withCredentials:true});

            console.log(response);
            this.member.idx = response.data.result.idx;
            this.member.email = response.data.result.email;
            this.member.nickname = response.data.result.nickname;
            this.member.cellPhone = response.data.result.cellPhone;
            this.member.defaultAddress = response.data.result.defaultAddress;
            this.member.profileImageUrl = response.data.result.profileImageUrl;
        },

        async signup(member){
            let url = '/api/member/signup';
            console.log("회원가입 스토어 들어옴")

            let response = await axios.post(url, member, {withCredentials:false});

            if(response.status === 200){
                return true;
            }

            return false;
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

        // async getMemberInfo(){
        //     await axios.get()
        // },

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
        },

        async findEmail(email){
            let url = `/api/member/find/email`;

            let response = await axios.post(url,email);

            console.log(response);
        },
        async updateMemberInfo(req){
            let url = `/api/member/info`;

            console.log(req);
            let response = await axios.put(url,req,{withCredentials:true});
            console.log(response);
            this.member.nickname = response.data.result.nickname;

            return response;
        }
    }
})