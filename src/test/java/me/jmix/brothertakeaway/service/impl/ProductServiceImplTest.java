package me.jmix.brothertakeaway.service.impl;

import me.jmix.brothertakeaway.BrotherTakeawayProductApplicationTests;
import me.jmix.brothertakeaway.entity.ProductInfo;
import me.jmix.brothertakeaway.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 10:06 下午
 */
class ProductServiceImplTest extends BrotherTakeawayProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    void getShelvesProductInfo() {
        List<ProductInfo> productInfoList = productService.getShelvesProductInfo();
        assertTrue(productInfoList.size() > 0);
    }
}