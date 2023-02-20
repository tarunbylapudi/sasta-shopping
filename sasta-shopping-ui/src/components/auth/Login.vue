<template>
  <v-container fluid class="bg-grey-lighten-2 my-16" rounded>
    <v-img cover src="" width="150"></v-img>
    <v-card class="mx-auto px-8 py-8" max-width="344">
      <v-form @submit.prevent="login">
        <v-text-field
          v-model="userName"
          variant="underlined"
          :rules="[rules.required]"
          class="mb-2"
          clearable
          label="Username"
        ></v-text-field>

        <v-text-field
          v-model="password"
          type="password"
          variant="underlined"
          :rules="[rules.required]"
          name="input-10-1"
          label="Password"
          clearable
        ></v-text-field>

        <br />

        <v-btn
          type:submit
          block
          color="success"
          size="large"
          type="submit"
          variant="elevated"
        >
          Sign In
        </v-btn>
      </v-form>
    </v-card>
  </v-container>
  <v-snackbar v-model="snack" :color="snackColor">{{ text }}</v-snackbar>
</template>

<script lang="ts">
import router from "@/router";
import { defineComponent, ref } from "vue";
import { useStore } from "vuex";
import { LOGIN, SET_IS_AUTHENTICATED } from "@/store/constants";

export default defineComponent({
  name: "Login",
  setup() {
    const store = useStore();

    const snack = ref(false);
    const text = ref("");
    const snackColor = ref("");

    const userName = ref("");
    const password = ref("");

    const login = async () => {
      const result = await store.dispatch(LOGIN, {
        userName: userName.value,
        password: password.value,
      });
      if (result) {
        store.commit(SET_IS_AUTHENTICATED, true);
        router.push("/");
      } else {
        text.value = "Some thing is worng, Please try again after sometime!";
        snack.value = true;
        snackColor.value = "red";
        console.log("Login Failed");
      }
    };

    const rules = {
      required: (value: string) => !!value || "Required.",
    };
    return { login, userName, password, rules, snack, text, snackColor };
  },
});
</script>
