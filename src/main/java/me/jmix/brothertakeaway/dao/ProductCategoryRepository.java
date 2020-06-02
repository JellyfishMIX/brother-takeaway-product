package me.jmix.brothertakeaway.dao;

import me.jmix.brothertakeaway.entity.ProductCategory;
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
