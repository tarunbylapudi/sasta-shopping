import axios from "axios";

const instance = axios.create({
  baseURL: process.env.VUE_APP_API_URL,
  timeout: 5000,
});

// Add an interceptor to add the `Authorization` header to every request
instance.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }

  return config;
});

export default instance;
