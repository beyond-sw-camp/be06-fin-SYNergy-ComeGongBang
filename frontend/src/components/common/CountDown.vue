<template>
  <span id="app">
    <!-- Countdown 컴포넌트 호출 -->
    <vue-countdown 
      :time="countdownTime"
      :transform="transformSlotProps" 
      v-slot="{ hours, minutes, seconds }"
      class="hotdeal"
    >
    {{ days }}일, {{ hours }}시간, {{ minutes }}분, {{ seconds }}초
    </vue-countdown>
  </span>
</template>

<script>
import Countdown from '@chenfengyuan/vue-countdown';

export default {
  components: {
    'vue-countdown': Countdown,
  },
  data() {
    return {
      countdownTime: this.getTimeUntilMidnight(),
    };
  },
  computed: {
    // 남은 시간을 일로 변환하는 계산 속성
    days() {
      return Math.floor(this.countdownTime / (1000 * 60 * 60 * 24));
    }
  },
  methods: {
    getTimeUntilMidnight() {
      const now = new Date();
      const tomorrow = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 4); // 내일 00시
      return tomorrow - now; // 내일 00시까지 남은 시간을 밀리초로 반환
    },
    // 카운트다운의 숫자가 10보다 작을 경우 앞에 0을 붙이는 함수
    transformSlotProps(props) {
      const formattedProps = {};
      
      Object.entries(props).forEach(([key, value]) => {
        formattedProps[key] = value < 10 ? `0${value}` : String(value);
      });

      return formattedProps;
    },
  },
};
</script>

<style scoped>
.hotdeal{
  color : #de3c3c;
}
</style>