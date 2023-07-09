package com.daou.product.controller;


import com.daou.product.domain.ProductOption;
import com.daou.product.model.request.ProductRequest;
import com.daou.product.model.response.ProductResponse;
import com.daou.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "상품 API 목록")
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "단일 상품 조회", notes = "상품 ID로 단일 상품을 조회합니다.")
    @GetMapping("/product/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @ApiOperation(value = "전체 상품 조회", notes = "page, size를 활용해 페이지 단위로 조회합니다.")
    @GetMapping("/products")
    public Page<ProductResponse> getProductList(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return productService.getProductList(pageable);
    }

    @ApiOperation(value = "상품 등록", notes = "상품을 등록합니다.")
    @PostMapping("/product")
    public String registerProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.registerProduct(productRequest);
        return "SAVE PRODUCT COMPLETE";
    }

    @ApiOperation(value = "상품 정보 수정", notes = "선택한 상품 정보를 수정합니다.")
    @PatchMapping("/product/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductRequest productRequest) {
        productService.updateProduct(productId, productRequest);
    }

    @ApiOperation(value = "단일 상품 삭제", notes = "선택한 상품을 삭제합니다.")
    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}

