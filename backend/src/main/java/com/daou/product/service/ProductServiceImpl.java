package com.daou.product.service;

import com.daou.product.constant.OptionType;
import com.daou.product.domain.Product;
import com.daou.product.domain.ProductEditor;
import com.daou.product.domain.ProductOption;
import com.daou.product.model.request.ProductRequest;
import com.daou.product.model.response.ProductResponse;
import com.daou.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public ProductResponse getProduct(Long id) {
        //createOption
        this.createOption(id);

        Product product = productRepository.findById(id).orElseThrow();

        ProductResponse response = ProductResponse.from(product);

        return response;
    }

    private void createOption(Long id) {
        Product product = productRepository.getReferenceById(id);

        for (int i = 0; i < 5; i++) {
            ProductOption productOption = new ProductOption();
            ProductOption option = productOption.createOption(OptionType.ADD, product, "추가 상품" + i, i * 1000);
            product.getProductOptions().add(option);
        }

        for (int i = 0; i < 5; i++) {
            ProductOption productOption = new ProductOption();
            ProductOption option = productOption.createOption(OptionType.OPTION, product, "옵션" + i, i * 1000);
            product.getProductOptions().add(option);
        }
        productRepository.saveAndFlush(product);

    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductResponse> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductResponse::new);
    }

    @Transactional
    @Override
    public void registerProduct(ProductRequest productRequest) {
        Product product = Product.of(productRequest);

        productRepository.save(product);
    }

    @Transactional
    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.getReferenceById(id);

        ProductEditor.ProductEditorBuilder productEditorBuilder = product.toEditor();

        ProductEditor productEditor = productEditorBuilder
                .name(productRequest.getName())
                .summary(productRequest.getSummary())
                .price(productRequest.getPrice())
                .content(productRequest.getContent())
                .build();

        product.edit(productEditor);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow();

        productRepository.delete(product);
    }
}



