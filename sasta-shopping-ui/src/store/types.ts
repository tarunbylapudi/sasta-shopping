import { Product } from "@/api/types";
import { Image } from "@/api/types";

export interface GlobalState {
  user: null | object;
  isAuthenticated: boolean;
  products: Product[];
  ProductDetails: {
    id: number;
    name: string;
    description: String;
    price: number;
    quantity: number;
    images: Image[];
  };
  cart: Cart[];
}

export interface Cart {
  cartId: number;
  quantity: number;
  product: Product;
}

export interface User {
  exp: number;
  firstName: string;
  iat: number;
  role: string;
  sub: string;
  userId: number;
}
