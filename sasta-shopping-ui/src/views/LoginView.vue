<template>
  <login />
</template>
<script lang="ts">
import { defineComponent } from "vue";
import Login from "@/components/auth/Login.vue";

export default defineComponent({
  name: "LoginView",
  components: { Login },
  setup() {
    return {};
  },
});
</script>
