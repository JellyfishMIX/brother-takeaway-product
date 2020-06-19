package me.jmix.brothertakeaway.product.dao;

import me.jmix.brothertakeaway.product.BrotherTakeawayProductApplicationTests;
import me.jmix.brothertakeaway.product.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:39 下午
 */
class ProductInfoRepositoryTest extends BrotherTakeawayProductApplicationTests {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    void findByProductStatus() {
        List<ProductInfo> list =  productInfoRepository.findByProductStatus(0);
        assertTrue(list.size() > 0);
    }

    @Test
    void findByProductIdIn() {
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("123456", "123458"));
        assertEquals(2, list.size());
    }
}