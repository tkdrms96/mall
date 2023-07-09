import { request } from "./index";

export const getProducts = (pageModel) => {
  const res = request.get(`/api/products`, {
    params: pageModel,
  });
  return res;
};

export const getProduct = (id) => {
  return request.get(`/api/product/${id}`);
};
