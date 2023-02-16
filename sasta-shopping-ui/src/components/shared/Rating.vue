<template>
  <v-rating
    :model-value="4.5"
    color="amber"
    density="compact"
    half-increments
    readonly
    size="small"
  ></v-rating>
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
