export interface Product {
  id: number;
  name: string;
  description: String;
  price: number;
  quantity: number;
  images: Image[];
  rating: number;
}

export interface Image {
  id: number;
  name: string;
  type: string;
  bytes: string;
}
export interface contactUspayload {
  name: string;
  email: string;
  mobile: string;
  type: string;
  description: string;
}

export interface addToCartPayload {
  productId: number;
  quantity: number;
}

export interface signUp {
  firstName: string;
  lastName: string;
  email: string;
  userName: string;
  password: string;
}

export interface LoginPayload {
  userName: string;
  password: string;
}
export interface LoginResponse {
  token: string;
  isAdmin: boolean;
}

export interface snackBar {
  snack: boolean;
  text: string;
  color: string;
}
