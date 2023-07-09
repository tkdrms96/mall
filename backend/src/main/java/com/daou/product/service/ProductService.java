package com.daou.product.service;

import com.daou.product.model.request.ProductRequest;
import com.daou.product.model.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductResponse getProduct(Long id);

    Page<ProductResponse> getProductList(Pageable pageable);

    void registerProduct(ProductRequest productRequest);

    void updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long productId);
}
