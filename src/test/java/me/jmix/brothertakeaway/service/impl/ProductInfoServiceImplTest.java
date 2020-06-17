package me.jmix.brothertakeaway.service.impl;

import me.jmix.brothertakeaway.BrotherTakeawayProductApplicationTests;
import me.jmix.brothertakeaway.entity.ProductInfo;
import me.jmix.brothertakeaway.service.ProductInfoService;
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
    void getShelvesProductInfo() {
        List<ProductInfo> productInfoList = productInfoService.getShelvesProductInfo();
        assertTrue(productInfoList.size() > 0);
    }

    @Test
    void queryProductInfoListByProductIdList() {
        List<ProductInfo> productInfoList = productInfoService.queryProductInfoListByProductIdList(Arrays.asList("123456", "123458"));
        assertEquals(2, productInfoList.size());
    }
}