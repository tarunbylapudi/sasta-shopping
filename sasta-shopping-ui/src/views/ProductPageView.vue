<template>
  <product />
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Product from "@/components/Shop/Product.vue";

export default defineComponent({
  name: "ProductPageView",
  components: { Product },
  setup() {
    return {};
  },
});
</script>
