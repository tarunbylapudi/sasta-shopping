<template>
  <home />
</template>
<script lang="ts">
import { defineComponent } from "vue";
import Home from "@/components/home/Home.vue";

export default defineComponent({
  name: "HomeView",
  components: { Home },
  setup() {
    return {};
  },
});
</script>
