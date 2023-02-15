<template>
  <profile />
</template>
<script lang="ts">
import { defineComponent } from "vue";
import Profile from "@/components/Profile/Profile.vue";

export default defineComponent({
  name: "ProfileView",
  components: { Profile },
  setup() {
    return {};
  },
});
</script>
