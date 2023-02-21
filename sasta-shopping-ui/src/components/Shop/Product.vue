<template>
  <v-card class="pa-5">
    <v-row>
      <v-col cols="12" sm="6" class="my-auto">
        <carousel :images="Images.get(currentRouteId)" />
      </v-col>
      <v-col cols="12" sm="6" class="my-auto">
        <v-container class="m-0 p-0">
          <product-details />
          <v-row class="my-5" no-gutters>
            <v-text class="mx-2 font-weight-bold">Add Quantity :</v-text>
            <v-btn
              size="medium"
              variant="text"
              icon="mdi-minus-circle"
              @click="addedQuantity >= 2 ? addedQuantity-- : addedQuantity"
            ></v-btn>
            <v-text class="mx-2">{{ addedQuantity }}</v-text>
            <v-btn
              size="medium"
              variant="text"
              icon="mdi-plus-circle"
              @click="addedQuantity++"
            ></v-btn>
          </v-row>
          <v-row>
            <v-col
              ><div
                class="d-flex justify-center align-center"
                style="gap: 3rem"
              >
                <v-btn
                  height="40"
                  :loading="loading1"
                  :disabled="loading1"
                  color="blue-grey"
                  prepend-icon="mdi-cart-plus"
                  @click="addToCartHandler"
                >
                  {{ addToCartText }}
                </v-btn>
                <v-btn
                  height="40"
                  :loading="loading2"
                  :disabled="loading2"
                  color="orange-darken-2"
                  prepend-icon="mdi-lightning-bolt"
                  @click="buyNowHandler"
                >
                  Buy now
                </v-btn>
              </div></v-col
            >
          </v-row>
        </v-container>
      </v-col>
    </v-row>
  </v-card>
  <v-snackbar v-model="snack" :color="snackColor">{{ text }}</v-snackbar>
</template>

<script lang="ts">
import router from "@/router";
import { UseFetchProducts, useImageConversion } from "@/store/composables";
import { ADD_TO_CART } from "@/store/constants";
import { computed, defineComponent, onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

import Carousel from "../shared/Carousel.vue";

import ProductDetails from "./ProductDetails.vue";

export default defineComponent({
  name: "Product",
  components: { Carousel, ProductDetails },
  setup() {
    const snack = ref(false);
    const text = ref("Product added to cart!");
    const snackColor = ref("green");

    const loading1 = ref(false);
    const loading2 = ref(false);
    const addedQuantity = ref(1);
    const addToCartText = ref("Add to Cart");
    const load = () => {
      loading1.value = true;
      setTimeout(() => (loading1.value = false), 3000);
    };

    const store = useStore();
    const route = useRoute();
    onMounted(UseFetchProducts);
    const Images = useImageConversion();
    const products = computed(() => store.state.products);
    const currentRouteId = +route.params.id;
    const productId = currentRouteId;

    //const imgArray = computed(() => Images.value);

    const addToCartHandler = async () => {
      loading1.value = true;
      const result = await store.dispatch(ADD_TO_CART, {
        productId: productId,
        quantity: addedQuantity.value,
      });
      if (result) {
        loading1.value = false;
        snack.value = true;
        setTimeout(() => {
          router.back();
        }, 2000);
      } else {
        loading1.value = false;
        text.value = "Some thing is worng, Please try again after sometime!";
        snack.value = true;
        snackColor.value = "red";
        setTimeout(() => {
          router.back();
        }, 1500);
        console.log("Add to cart failed");
      }
    };

    const buyNowHandler = () => {
      loading2.value = true;
    };

    const rules = {
      required: (value: any) => !!value || "Required.",
      zero: (value: number) => value >= 1 || "Quantity can not be 0!",
      max: (value: number) => value <= 5 || "Maximum Order Quantity is 5",
    };
    const hint: string = ``;
    return {
      load,
      loading1,
      loading2,
      Images,
      currentRouteId,
      addedQuantity,
      products,
      rules,
      hint,
      addToCartHandler,
      addToCartText,
      buyNowHandler,
      snack,
      snackColor,
      text,
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
