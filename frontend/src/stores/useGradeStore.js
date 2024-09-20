import { defineStore } from 'pinia';
import axios from 'axios';

export const useGradeStore = defineStore('grade', {
  state: () => ({
    grade: {},
    loading: false,
  }),
  actions: {
    async fetchGrade() {
      try {
        this.loading = true;
        const response = await axios.get('/api/mypage/grade/me', {
          withCredentials: true,
        });
        this.grade = response.data.result;
        console.log(this.grade);
      } catch (error) {
        console.error('Error fetching grade:', error);
      } finally {
        this.loading = false;
      }
    },
  },
});
