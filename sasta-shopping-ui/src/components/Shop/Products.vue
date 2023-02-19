<template>
  <v-container class="">
    <v-row>
      <v-col class="" cols="12">
        <strong>Products</strong>
      </v-col>

      <v-col v-for="product in products" :key="product.id" cols="6" md="3">
        <product-card-layout :product="product" :images="Images" />
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
import { computed, defineComponent } from "vue";
import { onMounted } from "vue";

import { UseFetchProducts, useImageConversion } from "@/store/composables";
import { useStore } from "vuex";

import ProductCardLayout from "./ProductCardLayout.vue";

export default defineComponent({
  name: "Products",
  components: { ProductCardLayout },
  setup() {
    const store = useStore();
    onMounted(UseFetchProducts);
    const Images = useImageConversion();
    const products = computed(() => store.state.products);

    return { products, Images };
  },
});
</script>
