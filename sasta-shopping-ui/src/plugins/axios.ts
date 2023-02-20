import axios from "axios";
import { User } from "@/store/types";

const instance = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
  timeout: 50000,
});

// Add an interceptor to add the `Authorization` header to every request
instance.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  const user: User = JSON.parse(localStorage.getItem("user") as string);

  // if (token) config.headers.Authorization = `Bearer ${token}`;

  if (user) config.headers.userId = user.userId;

  return config;
});

export default instance;
