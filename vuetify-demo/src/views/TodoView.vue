<template>
  <todo-app />
</template>

<script lang="ts">
  import Vue from 'vue'
  import TodoApp from "@/components/todo/Todo.vue";

  export default Vue.extend({
    name: 'todo',

    components: {
      TodoApp,
    },
  })
</script>
