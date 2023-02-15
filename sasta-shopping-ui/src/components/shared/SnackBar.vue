<template>
  <div class="text-center">
    <v-btn color="orange-darken-2" @click="snackbar = true">
      Open Snackbar
    </v-btn>

    <v-snackbar v-model="snackbar" :timeout="timeout">
      {{ text }}

      <template v-slot:actions>
        <v-btn color="blue" variant="text" @click="snackbar = false">
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "SnackBar",
  setup() {
    return {};
  },
  data() {
    return {
      snackbar: false,
      text: "My timeout is set to 2000.",
      timeout: 2000,
    };
  },
});
</script>
