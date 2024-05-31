package com.kawaiiTokioShop.kykshop.responses;
import java.util.List;

import com.kawaiiTokioShop.kykshop.dto.ProductoDto;

public class ProductoResponse {
	
    private List<ProductoDto> products;

    public ProductoResponse(List<ProductoDto> products) {
        this.products = products;
    }

    public List<ProductoDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductoDto> products) {
        this.products = products;
    }
}