package org.example.api;

import org.example.models.OrderRequest;
import org.example.models.Product;

public class OrderRequestBuilder {
    private Product product;
    private int quantity;

    public OrderRequestBuilder() {
    }

    public OrderRequestBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderRequestBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderRequest build() {
        return new OrderRequest(product, quantity);
    }
}