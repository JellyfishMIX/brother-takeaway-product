package me.jmix.brothertakeaway.service;

import me.jmix.brothertakeaway.dto.CartDTO;
import me.jmix.brothertakeaway.entity.ProductInfo;

import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:57 下午
 */
public interface ProductInfoService {
    /**
     * 获取上架的商品信息列表
     * @return
     */
    List<ProductInfo> getShelvesProductInfo();

    /**
     * 使用ProductIdList查询ProductInfoList
     *
     * @param productIdList productIdList
     * @return
     */
    List<ProductInfo> queryProductInfoListByProductIdList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
