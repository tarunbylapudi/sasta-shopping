<template>
  <v-card class="mx-auto" max-width="434" rounded="0">
    <v-img
      height="100%"
      cover
      src="https://cdn.vuetifyjs.com/images/cards/server-room.jpg"
    >
      <v-avatar color="grey" size="150" rounded="0">
        <v-img
          cover
          src="https://cdn.vuetifyjs.com/images/profiles/marcus.jpg"
        ></v-img>
      </v-avatar>
      <v-list-item
        class="text-white"
        title="Marcus Obrien"
        subtitle="Network Engineer"
      ></v-list-item>
    </v-img>
  </v-card>
</template>
<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "ProfileCard",
  setup() {
    return {};
  },
});
</script>
