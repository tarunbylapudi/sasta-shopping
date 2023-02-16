<template>
  <v-container>
    <v-card class="pa-5">
      <v-row>
        <v-col cols="12" sm="6">
          <carousel />
          <v-row class="ma-2" no-gutters>
            <v-col
              cols="6"
              class="d-flex text-center justify-center align-center"
            >
              <h3>Add Quantity :</h3>
            </v-col>
            <v-col cols="6">
              <v-text-field
                label="Quantity"
                model-value=""
                variant="underlined"
              ></v-text-field>
            </v-col>
          </v-row>

          <div class="d-flex justify-center align-center" style="gap: 3rem">
            <v-btn
              height="40"
              :loading="loading"
              :disabled="loading"
              color="blue-grey"
              prepend-icon="mdi-cart-plus"
              @click="load"
            >
              Add to cart
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
  </v-container>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import Carousel from "../shared/Carousel.vue";
//import Rating from "../shared/Rating.vue";
import ProductDetails from "./ProductDetails.vue";

export default defineComponent({
  name: "Product",
  components: { Carousel, ProductDetails },
  setup() {
    const loading = ref(false);
    const load = () => {
      loading.value = true;
      setTimeout(() => (loading.value = false), 3000);
    };
    return { load, loading };
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
