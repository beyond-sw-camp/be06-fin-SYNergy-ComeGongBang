import { defineStore } from 'pinia';

export const useSideBarStore = defineStore('sideBar', {
    state: () => ({
        activeTab: 0, // 사이드바와 탭에서 공통으로 사용하는 상태
    }),
    actions: {
        setActiveTab(index) {
            this.activeTab = index;
        },
    },
});