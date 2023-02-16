import axios from "axios";

const getProducts = async () => {
  const url = process.env.VUE_APP_GET_PRODUCTS;
  const respose = await axios.get(url);
  return respose.data;
};

export default getProducts;
