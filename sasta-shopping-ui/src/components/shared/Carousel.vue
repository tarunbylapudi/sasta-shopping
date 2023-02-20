<template>
  <v-card
    ><v-carousel
      class=""
      cycle
      interval="2000"
      :height="height"
      :width="width"
      hide-delimiter-background
      show-arrows="hover"
    >
      <v-carousel-item v-for="image in images" :key="image">
        <div class="d-flex fill-height justify-center align-center">
          <v-img :aspect-ratio="1" :src="image" cover></v-img>
        </div>
      </v-carousel-item> </v-carousel
  ></v-card>
</template>

<script lang="ts">
import { defineComponent, PropType } from "vue";

export default defineComponent({
  name: "Carousel",
  props: {
    images: {
      type: Array as PropType<string[]>,
      required: true,
    },
    width: {
      type: String,
      required: false,
      default: "auto",
    },
    height: {
      type: String,
      required: false,
      default: "370",
    },
  },
  setup() {},
});
</script>
