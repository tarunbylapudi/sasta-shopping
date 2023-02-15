<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="6">
        <carousel />
      </v-col>
      <v-col cols="12" sm="6">
        <carousel />
        <rating />
      </v-col>
    </v-row>
  </v-container>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Carousel from "../shared/Carousel.vue";
import Rating from "../shared/Rating.vue";

export default defineComponent({
  name: "Product",
  components: { Carousel, Rating },
  setup() {
    return {};
  },
});
</script>
