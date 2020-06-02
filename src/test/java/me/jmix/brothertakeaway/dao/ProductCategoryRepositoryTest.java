package me.jmix.brothertakeaway.dao;

import me.jmix.brothertakeaway.BrotherTakeawayProductApplicationTests;
import me.jmix.brothertakeaway.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:52 下午
 */
class ProductCategoryRepositoryTest extends BrotherTakeawayProductApplicationTests {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(2, 9));
        assertTrue(list.size() > 0);
    }
}