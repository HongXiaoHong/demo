<template>
  <test-app />
</template>

<script lang="ts">
  import Vue from 'vue'
  import TestApp from "@/components/Test.vue";

  export default Vue.extend({
    name: 'Test',

    components: {
      TestApp,
    },
  })
</script>
