<template>
  <div class="flex justify-center pt-[118px] pb-[90px]">
    <div data-v-58c5a73f="" class="BaseEmptyStates BaseEmptyStates__buttonStyle--full">
      <div data-v-58c5a73f="" class="BaseEmptyStates__image">
        <svg data-v-6d2bd019="" data-v-58c5a73f="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon" style="width: 80px; height: 80px; opacity: 1; fill: currentcolor; --BaseIcon-color: #999999;">
          <g clip-path="url(#clip0_124_3007)">
            <path fill-rule="evenodd" clip-rule="evenodd" d="M12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2ZM12 3.5C7.30558 3.5 3.5 7.30558 3.5 12C3.5 16.6944 7.30558 20.5 12 20.5C16.6944 20.5 20.5 16.6944 20.5 12C20.5 7.30558 16.6944 3.5 12 3.5ZM12.75 15V17H11.25V15H12.75ZM12.75 7V13H11.25V7H12.75Z">
            </path>
          </g>
          <defs>
            <clipPath id="clip0_124_3007"><rect width="24" height="24"></rect></clipPath>
          </defs>
        </svg>
      </div><!---->
      <div data-v-58c5a73f="" class="BaseEmptyStates__description">
        {{ content }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:{
    content:{
      type:String,
      required:true
    }
  },
  components: {
  },
  methods: {
  },
};
</script>