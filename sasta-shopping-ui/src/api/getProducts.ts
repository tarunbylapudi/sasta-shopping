import axios from "@/plugins/axios";

const getProducts = async () => {
  const baseUrl = process.env.VUE_APP_API_URL;
  const respose = await axios.get(`${baseUrl}/api/products`);
  return respose.data;
};

// state.isLoading = true;
// axios
//   .get("/api/users")
//   .then((response) => {
//     state.users = response.data;
//     state.isLoading = false;
//   })
//   .catch((error) => {
//     console.error(error);
//     state.isLoading = false;
//   });

export default getProducts;
