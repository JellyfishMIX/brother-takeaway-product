package me.jmix.brothertakeaway.product.service.impl;

import me.jmix.brothertakeaway.product.BrotherTakeawayProductApplicationTests;
import me.jmix.brothertakeaway.product.dto.CartDTO;
import me.jmix.brothertakeaway.product.entity.ProductInfo;
import me.jmix.brothertakeaway.product.service.ProductInfoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 10:06 下午
 */
class ProductInfoServiceImplTest extends BrotherTakeawayProductApplicationTests {
    @Autowired
    private ProductInfoService productInfoService;

    @Test
    @Disabled
    void getShelvesProductInfo() {
        List<ProductInfo> productInfoList = productInfoService.getShelvesProductInfo();
        assertTrue(productInfoList.size() > 0);
    }

    @Test
    @Disabled
    void queryProductInfoListByProductIdList() {
        List<ProductInfo> productInfoList = productInfoService.queryProductInfoListByProductIdList(Arrays.asList("123456", "123458"));
        assertEquals(2, productInfoList.size());
    }

    @Test
    @Disabled
    void decreaseStock() {
        CartDTO cartDTO = new CartDTO("123456", 2);
        productInfoService.decreaseStock(Arrays.asList(cartDTO));
    }
}