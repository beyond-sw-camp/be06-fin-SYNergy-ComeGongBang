<template>
    <div ref="observerElement"></div>
</template>
 
<script>
export default {
  data() {
    return {
      observer: null,
      observerOptions: {
        rootMargin: '0px',
        threshold: 1.0
      }
    };
  },
  mounted() {
    this.createObserver();
  },
  // beforeDestroy() {
  //   if (this.observer) {
  //     this.observer.disconnect();
  //   }
  // },
  methods: {
    createObserver() {
      this.observer = new IntersectionObserver((entries) => {
        if (entries[0].isIntersecting) {
          // 관찰 대상이 교차되었을 때 intersect 이벤트를 호출합니다.
          this.$emit('show');
        } else {
          this.$emit('hidden');	
        }
      }, this.observerOptions);
 
      const observerElement = this.$refs.observerElement;
      this.observer.observe(observerElement);
    }
  }
};
</script>