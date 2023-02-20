<template>
  <v-container fluid class="pa-0">
    <div @click="shopHandler">
      <carousel :images="images" width="100px" height="200" />
      <v-row class="my-2">
        <v-col cols="12" md="4"><offers /></v-col>
        <v-col cols="12" md="4"><most-viewed /></v-col>
        <v-col cols="12" md="4"><most-viewed :top="2" /></v-col>
      </v-row>
    </div>
    <div @click="ccHandler">
      <v-img src="images/ccOffer.jpg"></v-img>
    </div>
  </v-container>
</template>
<script lang="ts">
import { defineComponent } from "vue";
import { useRouter } from "vue-router";
import Carousel from "@/components/shared/Carousel.vue";
import Offers from "../shared/HomeCards/Offers.vue";
import MostViewed from "../shared/HomeCards/MostViewed.vue";

export default defineComponent({
  name: "Home",
  components: { Carousel, Offers, MostViewed },
  setup() {
    const router = useRouter();
    const images = ["images/c1.jpg", "images/c2.jpg", "images/c3.jpg"];
    const shopHandler = () => router.push({ name: "shop" });
    const ccHandler = () => router.push({ name: "not-found" });
    return { images, shopHandler, ccHandler };
  },
});
</script>
