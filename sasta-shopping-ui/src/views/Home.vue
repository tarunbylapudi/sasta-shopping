<template>
  <carousel :images="images" width="100px" height="200" />
  <div class="d-flex align-center justify-center mt-15">
    <v-btn @click="shopHandler">Shop Now</v-btn>
  </div>
</template>
<script lang="ts">
import { defineComponent } from "vue";
import { useRouter } from "vue-router";
import Carousel from "@/components/shared/Carousel.vue";

export default defineComponent({
  name: "Home",
  components: { Carousel },
  setup() {
    const router = useRouter();
    const images = ["images/c1.jpg", "images/c2.jpg", "images/c3.jpg"];
    const shopHandler = () => router.push({ name: "shop" });
    return { images, shopHandler };
  },
});
</script>
