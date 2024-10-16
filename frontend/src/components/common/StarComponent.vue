<template>
  <div data-v-bc9f5992="" class="ATFArtist__review star-container" data-v-1ef4b2e1="">
    <div data-v-bc9f5992="" class="BaseRating BaseRating__sizeText--medium" data-v-2c82c531="" data-v-1ef4b2e1="" style="--BaseRating-color: #505fcd; --BaseRating-gap: 0;">
      <div data-v-bc9f5992="" class="BaseRating__rangeList" data-v-2c82c531=""><!--[-->
<!--        full star-->
        <svg v-for="n in fullStars" :key="n" width="current" height="current" viewBox="0 0 18 17" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M7.41935 0.77025C7.84635 -0.25675 9.29935 -0.25675 9.72735 0.77025L11.4704 4.96025L15.9944 5.32325C17.1024 5.41225 17.5524 6.79525 16.7074 7.51825L13.2604 10.4712L14.3134 14.8862C14.5714 15.9672 13.3954 16.8222 12.4464 16.2432L8.57335 13.8773L4.70035 16.2432C3.75035 16.8232 2.57435 15.9672 2.83235 14.8862L3.88535 10.4712L0.438352 7.51825C-0.405648 6.79525 0.0433519 5.41225 1.15235 5.32325L5.67635 4.96025L7.41935 0.77025Z" fill="#FFAF01"/>
        </svg>
<!--        half star-->
        <svg v-if="halfStar" width="current" height="current" viewBox="0 0 18 17" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M2.83235 14.8862C2.57435 15.9672 3.75035 16.8232 4.70035 16.2432L8.57335 13.8773V5.44546e-08C8.1031 -0.000136517 7.63291 0.256613 7.41935 0.77025L5.67635 4.96025L1.15235 5.32325C0.0433519 5.41225 -0.405648 6.79525 0.438352 7.51825L3.88535 10.4712L2.83235 14.8862Z" fill="#FFAF01"/>
          <path d="M11.4704 4.96025L9.72735 0.77025C9.51341 0.256887 9.04335 0.000136553 8.57335 5.44546e-08V13.8773L12.4464 16.2432C13.3954 16.8222 14.5714 15.9672 14.3134 14.8862L13.2604 10.4712L16.7074 7.51825C17.5524 6.79525 17.1024 5.41225 15.9944 5.32325L11.4704 4.96025Z" fill="#D9D9D9"/>
        </svg>
        <!--        emptystar-->
        <svg  v-for="n in emptyStars" :key="'empty' + n" width="current" height="current" viewBox="0 0 18 17" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M7.41935 0.77025C7.84635 -0.25675 9.29935 -0.25675 9.72735 0.77025L11.4704 4.96025L15.9944 5.32325C17.1024 5.41225 17.5524 6.79525 16.7074 7.51825L13.2604 10.4712L14.3134 14.8862C14.5714 15.9672 13.3954 16.8222 12.4464 16.2432L8.57335 13.8773L4.70035 16.2432C3.75035 16.8232 2.57435 15.9672 2.83235 14.8862L3.88535 10.4712L0.438352 7.51825C-0.405648 6.79525 0.0433519 5.41225 1.15235 5.32325L5.67635 4.96025L7.41935 0.77025Z" fill="#D9D9D9"/>
        </svg>

      </div>
<!--      <div data-v-bc9f5992="" class="BaseRating__label" data-v-2c82c531="">-->
<!--        <div data-v-bc9f5992="" class="BaseRating__labelRate" data-v-2c82c531=""> ({{ score }}) </div>-->
<!--        <div data-v-bc9f5992="" class="BaseRating__labelAppned" data-v-2c82c531="">&lt;!&ndash;[&ndash;&gt; </div>-->
<!--      </div>-->
    </div>
  </div>

</template>

<script>
export default {
  props:{
    score:{
      type:Number,
      required:true
    }
  },
  computed: {
    fullStars() {
      return Math.floor(this.score+0.4);
    },
    halfStar() {
      return this.score % 1 >= 0.1 && this.score % 1 <= 0.5;
    },
    emptyStars() {
      return 5 - Math.ceil(this.score);
    }
  },
  components: {
  },
  methods: {
  },
};
</script>
<style scoped>
.star-container{
  width: 100%;
}
</style>