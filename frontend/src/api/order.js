import { request } from "./index";

export const addOrder = (payload) => {
  return request.post(`/api/order`, payload);
};

export const getOrderDetails = (orderCode) => {
  return request.get(`/api/order?customerId`, {
    params: {
      orderCode: orderCode,
    },
  });
};
