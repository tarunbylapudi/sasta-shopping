import axios from "@/plugins/axios";

const getCart = async () => {
  const baseUrl = process.env.VUE_APP_API_URL;
  const respose = await axios.get(`${baseUrl}/cartitems`);
  return respose.data;
};

export default getCart;
