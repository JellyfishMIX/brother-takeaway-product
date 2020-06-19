package me.jmix.brothertakeaway.product.dao;

import me.jmix.brothertakeaway.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:49 下午
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * findByCategoryTypeIn
     * @param categoryTypeList categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
