<template>
  <v-card class="mx-auto my-auto pa-5" max-width="700">
    <v-form @submit.prevent="contactUsHandler">
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="name"
              label="Name"
              variant="underlined"
              clearable
              :rules="[rules.required]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="email"
              label="Email"
              variant="underlined"
              clearable
              :rules="[rules.required, rules.email]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="phone"
              variant="underlined"
              label="Phone"
              clearable
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <div class="text-center">
              <v-menu open-on-hover>
                <template #activator="{ props }">
                  <!--  -->
                  <v-text-field
                    v-model="issueCategory"
                    variant="underlined"
                    label="Issue Catogeory"
                    append-inner-icon="mdi-chevron-down"
                    clearable
                    v-bind="props"
                    :rules="[rules.required]"
                  ></v-text-field>
                </template>

                <v-list nav>
                  <v-list-item
                    v-for="(item, index) in items"
                    :key="index"
                    :title="item.title"
                    @click="updateIssueCategory(item.title)"
                  >
                  </v-list-item>
                </v-list>
              </v-menu>
            </div>
          </v-col>

          <v-col cols="12" sm="12"
            ><v-textarea
              v-model="issueDiscription"
              counter
              label="Issue Discription"
              clearable
              :rules="[rules.required]"
            ></v-textarea
          ></v-col>
        </v-row>
      </v-container>
    </v-form>
    <v-card-actions>
      <v-btn variant="text" color="teal-accent-4"> Submit </v-btn>
    </v-card-actions>
  </v-card>
</template>
<script lang="ts">
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "ContactUs",
  setup() {
    const name = ref("");
    const email = ref("");
    const phone = ref<number>();
    const issueCategory = ref("");
    const issueDiscription = ref("");

    const rules = {
      required: (value: any) => !!value || "Required.",
      min: (value: string) => value.length >= 8 || "Min 8 characters",
      email: (value: string) => {
        const pattern =
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return pattern.test(value) || "Invalid e-mail.";
      },
    };

    const items = [{ title: "Orders" }, { title: "Returns" }];
    const updateIssueCategory = (title: string) => {
      issueCategory.value = title;
    };

    const contactUsHandler = () => {};

    return {
      items,
      updateIssueCategory,
      name,
      email,
      phone,
      issueCategory,
      issueDiscription,
      contactUsHandler,
      rules,
    };
  },
});
</script>
