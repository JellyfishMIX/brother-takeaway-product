package me.jmix.brothertakeaway.service;

import me.jmix.brothertakeaway.entity.ProductInfo;

import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:57 下午
 */
public interface ProductService {
    /**
     * 获取上架的商品信息列表
     * @return
     */
    List<ProductInfo> getShelvesProductInfo();
}
