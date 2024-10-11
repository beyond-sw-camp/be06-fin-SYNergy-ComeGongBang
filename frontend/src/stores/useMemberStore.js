import { defineStore } from "pinia";
import axios from "axios";

export const useMemberStore = defineStore('member', {
    state: () => ({
        //초기화용 멤버
        initMember : {
            idx : "",
            nickname : "",
            email : "",
            cellphone : "",
            defaultAddress : "",
            profileImageUrl : "",
            gradeIdx : "",
            gradeName : "",
            gradeImageUrl : "@/assets/cgb.png",
            productsInCartCount : -1,
        },

        member : {
            idx : "",
            nickname : "",
            email : "",
            cellphone : "",
            defaultAddress : "",
            profileImageUrl : "",
            gradeIdx : "",
            gradeName : "",
            gradeImageUrl : "@/assets/cgb.png",
            productsInCartCount : -1,
        },

        newMemberInfo : {
            nickname : "",
        },

        status : 0,
        isLogined : false,

        electedMyCategories: [],  // 빈 배열로 초기화
        selectedLikeCategories: [],  // 빈 배열로 초기화

        userCategories:[]
    }),
    // persist: true,
    persist:{
        storage: localStorage,
    },
    actions:{
        async login(member){
            try {
                let url = `/api/login`;
                let response = await axios.post(url, member, {withCredentials: false}); //응답 받아서 저장

                if(response.status === 200){
                    this.isLogined = true;
                }
            }catch(error){
                console.error('로그인 실패', error);
                return false;
            }

            return this.isLogined;
        },

        async kakaoLogin(){
            // window.location.href = "/social/oauth2/authorization/kakao";
            window.location.href = "/socialtest/oauth2/authorization/kakao"

            // let url = '/api/member/isLogined';
            // try {
            //     await axios.get(url, {withCredentials: true});
            // } catch(error){
            //     let errorResponse = error.response.data;
            //     if(errorResponse.code === 2003) {
            //         alert(errorResponse.message);
            //     }
            // }
        },

        async getMemberInfo(){
            let url = `/api/member/login`;
            let response = await axios.get(url,{withCredentials:true});

            console.log(response);
            this.member.idx = response.data.result.idx;
            this.member.email = response.data.result.email;
            this.member.nickname = response.data.result.nickname;
            this.member.cellphone = response.data.result.cellphone;
            this.member.defaultAddress = response.data.result.defaultAddress;
            this.member.profileImageUrl = response.data.result.profileImageUrl;
            this.member.gradeIdx = response.data.result.gradeIdx;
            this.member.gradeName = response.data.result.gradeName;
            this.member.gradeImageUrl = response.data.result.gradeImageUrl;
            this.member.productsInCartCount = response.data.result.productsInCartCount;
        },

        async signup(member){
            let url = '/api/member/signup';

            let response = await axios.post(url, member, {withCredentials:false});

            if(response.status === 200){
                return true;
            }

            return false;
        },

        async emailRequest(email){
            this.member.email = email;

            let emailAuthReq = {
                email : email,
                uuid : "",
            }
            // let errorResponse;
            try {
                let url = `/api/email/request`
                let response = await axios.post(url, emailAuthReq);

                return response.status;
            }catch (error) {
                let errorResponse = error.response.data;

                console.log(errorResponse);
                if(errorResponse.code === 2003){
                    return errorResponse.message;
                    // return errorResponse.isSuccess;
                }
            }
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

        async logout() {
            let url = '/api/logout';
            await axios.post(url, {withCredentials:true});

            this.isLogined = false;
            this.member = this.initMember;

            sessionStorage.removeItem('member');

            return true;

        },
        async deleteMember(){
            let url = '/api/member';
            try {
                const response = await axios.delete(url, {withCredentials: true});

                await this.logout();

                window.location.href = ""

                return response.data.result;

            } catch(error){
                let errorResponse = error.response.data;
                if(errorResponse.code === 2003){
                    return errorResponse.message;
                }
                if(errorResponse.code === 2004){
                    return errorResponse.message;
                }
            }
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

            await axios.post(url,email);
        },
        async updateMemberInfo(req){
            let url = `/api/member/info`;

            let response = await axios.put(url,req,{withCredentials:true});
            this.member.nickname = response.data.result.nickname;

            return response;
        },
        async getGradePercent(){
            const response = await axios.get(`/api/me/percent`, {withCredentials:true});
            return response;
        },
        async isMember(memberEmail){
            let url = `/api/member`;
            let req ={
                memberEmail : memberEmail
            };

            let response = await axios.post(url, req, {withCredentials:true});
            return response.data.result;
        }
    }
})