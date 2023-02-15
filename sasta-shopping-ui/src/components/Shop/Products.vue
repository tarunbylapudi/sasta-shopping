<template>
  <v-main class="bg-grey-lighten-2">
    <v-container class="">
      <v-row>
        <template v-for="n in 4" :key="n">
          <v-col class="mt-2" cols="12">
            <strong>Category {{ n }}</strong>
          </v-col>

          <v-col v-for="j in products" :key="`${n}${j}`" cols="6" md="2">
            <product-card-layout :product="j" />
          </v-col>
        </template>
      </v-row>
    </v-container>
  </v-main>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ProductCardLayout from "./ProductCardLayout.vue";

export default defineComponent({
  name: "Products",
  components: { ProductCardLayout },
  setup() {
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
        name: "sdkbjkf",
        description: "sdjgysd",
        price: 2,
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
      {
        id: 7,
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
