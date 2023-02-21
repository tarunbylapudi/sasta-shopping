import axios from "@/plugins/axios";
import { signUp } from "./types";

const postSignUp = async (payload: signUp) => {
  console.log(payload);
  try {
    const baseurl = process.env.VUE_APP_API_URL;
    console.log(payload);
    const response = await axios.post(`${baseurl}/api/auth/register`, payload);
    console.log(response);
    return true;
  } catch (error) {
    console.error(error);
    return false;
  }
};

export default postSignUp;
