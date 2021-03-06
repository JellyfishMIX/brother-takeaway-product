package me.jmix.brothertakeaway.product.dao;

import me.jmix.brothertakeaway.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:34 下午
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * findByProductStatus
     *
     * @param productStatus productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * findByProductIdIn
     *
     * @param productIdList productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
