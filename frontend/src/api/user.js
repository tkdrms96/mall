import { request } from "./index";

export const login = () => {
  return request.get(`/api/login`);
};

export const getUser = () => {
  return request.get(`/api/customer`);
};
