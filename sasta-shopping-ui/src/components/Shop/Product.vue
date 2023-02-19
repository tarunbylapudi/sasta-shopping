<template>
  <v-card class="pa-5">
    <v-row>
      <v-col cols="12" sm="6">
        <carousel :images="Images.get(currentRouteId)" />
        {{ imgArray }}

        <v-row class="ma-2" no-gutters>
          <v-col
            cols="6"
            class="d-flex text-center justify-center align-center"
          >
            <h3>Add Quantity :</h3>
          </v-col>
          <v-col cols="6">
            <v-text-field
              v-model="addedQuantity"
              :rules="[rules.required, rules.zero, rules.max]"
              :hint="hint"
              label="Quantity"
              variant="underlined"
            >
            </v-text-field>
          </v-col>
        </v-row>

        <div class="d-flex justify-center align-center" style="gap: 3rem">
          <v-btn
            height="40"
            :loading="loading"
            :disabled="loading"
            color="blue-grey"
            prepend-icon="mdi-cart-plus"
            @click="addToCartHandler"
          >
            {{ addToCartText }}
          </v-btn>
          <v-btn
            height="40"
            :loading="loading"
            :disabled="loading"
            color="orange-darken-2"
            prepend-icon="mdi-lightning-bolt"
            @click="load"
          >
            Buy now
          </v-btn>
        </div>
      </v-col>
      <v-col cols="12" sm="6">
        <product-details />
      </v-col>
    </v-row>
  </v-card>
</template>

<script lang="ts">
import { UseFetchProducts, useImageConversion } from "@/store/composables";
import axios from "@/plugins/axios";
import { computed, defineComponent, onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

import Carousel from "../shared/Carousel.vue";

import ProductDetails from "./ProductDetails.vue";

export default defineComponent({
  name: "Product",
  components: { Carousel, ProductDetails },
  setup() {
    const loading = ref(false);
    const addedQuantity = ref(1);
    const addToCartText = ref("Add to Cart");
    const load = () => {
      loading.value = true;
      setTimeout(() => (loading.value = false), 3000);
    };

    const store = useStore();
    const route = useRoute();
    onMounted(UseFetchProducts);
    const Images = useImageConversion();
    const products = computed(() => store.state.products);
    const currentRouteId = +route.params.id;
    //const imgArray = computed(() => Images.value);

    const addToCartHandler = () => {
      loading.value = true;
      axios.post("");
    };

    const rules = {
      required: (value: any) => !!value || "Required.",
      zero: (value: number) => value >= 1 || "Quantity can not be 0!",
      max: (value: number) => value <= 5 || "Maximum Order Quantity is 5",
    };
    const hint: string = ``;

    return {
      load,
      loading,
      Images,
      currentRouteId,
      addedQuantity,
      products,
      rules,
      hint,
      addToCartHandler,
      addToCartText,
    };
  },
});
</script>
<style scoped>
.custom-loader {
  animation: loader 1s infinite;
  display: flex;
}
@-moz-keyframes loader {
  from {
    transform: rotate(0);
  }
  to {
    transform: rotate(360deg);
  }
}
@-webkit-keyframes loader {
  from {
    transform: rotate(0);
  }
  to {
    transform: rotate(360deg);
  }
}
@-o-keyframes loader {
  from {
    transform: rotate(0);
  }
  to {
    transform: rotate(360deg);
  }
}
@keyframes loader {
  from {
    transform: rotate(0);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
