export interface Product {
  id: number;
  name: string;
  description: String;
  price: number;
  quantity: number;
  images: Image[];
}

export interface Image {
  id: number;
  name: string;
  type: string;
  bytes: string;
}
export interface contactUs {
  name: string;
  email: string;
  mobile: string;
  type: string;
  description: string;
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
