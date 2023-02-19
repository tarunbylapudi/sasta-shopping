import jwt_decode from "jwt-decode";

const TOKEN_KEY = "token";

const setToken = (token: string) => {
  localStorage.setItem(TOKEN_KEY, token);
};

const getToken = (): string | null => {
  return localStorage.getItem(TOKEN_KEY);
};

const removeToken = () => {
  localStorage.removeItem(TOKEN_KEY);
};

const decodeToken = (token: string) => {
  return jwt_decode(token);
};

export { setToken, getToken, removeToken, decodeToken };
