<template>
  <v-card class="mx-auto" max-width="auto">
    <v-card-title>{{ ProductDetails.name }}</v-card-title>

    <v-card-subtitle>
      <span class="me-1">Ratings</span>
      <v-icon color="error" icon="mdi-fire" size="small"></v-icon>
    </v-card-subtitle>

    <v-card-text>
      <v-row align="center" class="mx-0">
        <rating />

        <div class="text-grey ms-4">4.5 (413)</div>
      </v-row>

      <div class="my-4 text-subtitle-1">₹ {{ ProductDetails.price }} /-</div>

      <div>{{ ProductDetails.description }}</div>
    </v-card-text>
  </v-card>

  <!-- <v-img :src="url"></v-img> -->
</template>

<script lang="ts">
import { computed, defineComponent, onMounted } from "vue";
//import { useRoute } from "vue-router";

import { UseFetchProductDetails } from "@/store/composables";
import { useImageConversion } from "@/store/composables";
//import ImageByteProcesser from "@/Utils/ImageByteProcesser";

import Rating from "../shared/Rating.vue";
import { useStore } from "vuex";
import { useRoute } from "vue-router";

export default defineComponent({
  name: "ProductDetails",
  components: { Rating },
  setup() {
    const route = useRoute();
    const store = useStore();

    const getProductDetails = () => {
      const productId: string = route.params.id as string;

      UseFetchProductDetails(productId);
    };

    onMounted(getProductDetails);
    onMounted(useImageConversion);

    const ProductDetails = computed(() => store.state.ProductDetails);

    return { ProductDetails };
  },
});
</script>
