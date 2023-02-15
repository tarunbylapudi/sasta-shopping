<template>
  <div class="text-center">
    <v-rating v-model="rating" readonly half-increments></v-rating>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Rating",
  setup() {
    return {};
  },
  data() {
    return {
      rating: 3.5,
    };
  },
});
</script>
