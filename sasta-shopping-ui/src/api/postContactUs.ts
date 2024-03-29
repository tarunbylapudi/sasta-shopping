import axios from "@/plugins/axios";
import { contactUspayload } from "./types";

const postContactUs = async (payload: contactUspayload) => {
  try {
    const baseurl = process.env.VUE_APP_API_URL;
    const response = await axios.post(`${baseurl}/contactQueries`, payload);
    console.log(response);
    return true;
  } catch (error) {
    console.error(error);
    return false;
  }
};

export default postContactUs;
