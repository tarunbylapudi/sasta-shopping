import axios from "@/plugins/axios";

const getProductDetails = async (productId: string) => {
  const baseUrl = process.env.VUE_APP_GET_PRODUCTS;
  const respose = await axios.get(`${baseUrl}/${productId}`);
  return respose.data;
};

export default getProductDetails;
