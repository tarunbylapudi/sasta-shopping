<template>
  <cart />
</template>
<script lang="ts">
import { defineComponent } from "vue";
import Cart from "@/components/cart/Cart.vue";

export default defineComponent({
  name: "CartView",
  components: { Cart },
  setup() {
    return {};
  },
});
</script>
