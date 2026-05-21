package com.example.stockservice;


import com.example.stockservice.entity.Product;
import com.example.stockservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Ürün ekleme ucu
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    // STOK DÜŞME UCU (Sipariş servisi buraya istek atacak)
    @PostMapping("/{id}/deduct")
    public ResponseEntity<Boolean> deductStock(@PathVariable Long id, @RequestParam Integer quantity) {
        boolean success = productService.deductStock(id, quantity);
        return ResponseEntity.ok(success);
    }
}