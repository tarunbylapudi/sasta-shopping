<template>
  <v-container fluid class="bg-grey-lighten-2" rounded>
    <v-card class="mx-auto mt-8 px-8 py-8" max-width="650">
      <v-form v-model="valid" @submit.prevent="signUp">
        <v-row class="px-3">
          <v-col cols="12" md="6">
            <v-text-field
              v-model="firstName"
              variant="underlined"
              :rules="[rules.required]"
              class="mb-2"
              clearable
              label="First Name"
            ></v-text-field>
            <v-text-field
              v-model="userName"
              variant="underlined"
              :rules="[rules.required]"
              class="mb-2"
              clearable
              label="User Name"
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
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="lastName"
              variant="underlined"
              :rules="[rules.required]"
              class="mb-2"
              clearable
              label="Last Name"
            ></v-text-field>
            <v-text-field
              v-model="email"
              variant="underlined"
              :rules="[rules.required]"
              class="mb-2"
              clearable
              label="Email"
            ></v-text-field>
          </v-col>
        </v-row>

        <br />

        <v-btn
          type:submit
          block
          :disabled="!valid"
          color="blue"
          size="large"
          type="submit"
          variant="elevated"
        >
          Sign Up
        </v-btn>
      </v-form>
      <div class="d-flex justify-center align-center mt-4">
        <v-text class=""
          >Already have an account?
          <span class="text-blue Link" @click="goTosignUpHandller">
            Sign In
          </span></v-text
        >
      </div>
    </v-card>
  </v-container>
  <v-snackbar v-model="snack" :color="snackColor">{{ text }}</v-snackbar>
</template>

<script lang="ts">
import router from "@/router";
import { defineComponent, ref } from "vue";
import { useStore } from "vuex";
import { SIGN_UP } from "@/store/constants";

export default defineComponent({
  name: "SignUp",
  setup() {
    const store = useStore();

    const snack = ref(false);
    const text = ref("Signup Successfull !, Please login to continue.");
    const snackColor = ref("green");
    const valid = ref(false);

    const firstName = ref("");
    const lastName = ref("");
    const userName = ref("");
    const email = ref("");
    const password = ref("");

    const signUp = async () => {
      console.log(
        firstName.value,
        lastName.value,
        email.value,
        userName.value,
        password.value
      );
      const result = await store.dispatch(SIGN_UP, {
        firstname: firstName.value,
        lastname: lastName.value,
        email: email.value,
        userName: userName.value,
        password: password.value,
      });
      if (result) {
        snack.value = true;
        setTimeout(() => {
          router.push("/login");
        }, 2000);
      } else {
        text.value = "Some thing is worng, Please try again after sometime!";
        snackColor.value = "red";
        snack.value = true;
        console.log("SignUp Failed");
      }
    };
    const goTosignUpHandller = () => router.push({ name: "login" });

    const rules = {
      required: (value: string) => !!value || "Required.",
    };
    return {
      signUp,
      valid,
      userName,
      password,
      email,
      lastName,
      firstName,
      rules,
      snack,
      text,
      snackColor,
      goTosignUpHandller,
    };
  },
});
</script>
<style scoped>
.Link:hover {
  cursor: pointer;
}
</style>
