<template>
  <products />
</template>

<script lang="ts">
import { defineComponent } from "vue";

import Products from "@/components/Shop/Products.vue";

export default defineComponent({
  name: "ShopView",
  components: { Products },
  setup() {
    return {};
  },
});
</script>
