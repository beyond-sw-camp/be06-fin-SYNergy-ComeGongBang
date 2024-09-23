<template>
  <span id="app">
    <!-- Countdown 컴포넌트 호출 -->
    <vue-countdown 
      :time="2 * 24 * 60 * 60 * 1000" 
      :transform="transformSlotProps" 
      v-slot="{ hours, minutes, seconds }"
    >
    {{ hours }}시간, {{ minutes }}분, {{ seconds }}초
    </vue-countdown>
  </span>
</template>

<script>
import Countdown from '@chenfengyuan/vue-countdown';

export default {
  components: {
    'vue-countdown': Countdown,
  },
  methods: {
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