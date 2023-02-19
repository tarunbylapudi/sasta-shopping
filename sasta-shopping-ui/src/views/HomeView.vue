<template>
  <home />
</template>
<script lang="ts">
import { defineComponent } from "vue";
import Home from "./Home.vue";

export default defineComponent({
  name: "HomeView",
  components: { Home },
  setup() {
    return {};
  },
});
</script>
