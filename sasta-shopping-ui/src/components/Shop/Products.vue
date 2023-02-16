<template>
  <v-container class="">
    <v-row>
      <v-col class="" cols="12">
        <strong>Products</strong>
      </v-col>

      <v-col v-for="product in products" :key="product.id" cols="6" md="3">
        <product-card-layout :product="product" />
      </v-col>
    </v-row>
    <!-- <v-row>
        <template v-for="n in 4" :key="n">
          <v-col class="mt-2" cols="12">
            <strong>Category {{ n }}</strong>
          </v-col>

          <v-col v-for="j in products" :key="`${n}${j}`" cols="6" md="2">
            <product-card-layout :product="j" />
          </v-col>
        </template>
      </v-row> -->
  </v-container>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { onMounted } from "vue";

import { UseFetchProducts } from "@/store/composables";

import ProductCardLayout from "./ProductCardLayout.vue";

export default defineComponent({
  name: "Products",
  components: { ProductCardLayout },
  setup() {
    onMounted(UseFetchProducts);
    const products = [
      {
        id: 1,
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
        quantity: 2,
      },
      {
        id: 2,
        name: "sdkbfsdvnljnlfvnlnsvjkf",
        description: "sdjgysd",
        price: 452,
        quantity: 2,
      },
      {
        id: 3,
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
        quantity: 2,
      },
      {
        id: 4,
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
        quantity: 2,
      },
      {
        id: 5,
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
        quantity: 2,
      },
      {
        id: 6,
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
        quantity: 2,
      },
    ];

    return { products };
  },
});
</script>
