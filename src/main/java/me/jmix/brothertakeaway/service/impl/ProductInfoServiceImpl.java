package me.jmix.brothertakeaway.service.impl;

import me.jmix.brothertakeaway.dao.ProductInfoRepository;
import me.jmix.brothertakeaway.entity.ProductInfo;
import me.jmix.brothertakeaway.enums.ProductStateEnum;
import me.jmix.brothertakeaway.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:59 下午
 */
@Service("productService")
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 获取上架的商品信息列表
     *
     * @return
     */
    @Override
    public List<ProductInfo> getShelvesProductInfo() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(ProductStateEnum.SHELVES.getStateCode());
        return productInfoList;
    }

    /**
     * 使用ProductIdList查询ProductInfoList
     *
     * @param productIdList productIdList
     * @return
     */
    @Override
    public List<ProductInfo> queryProductInfoListByProductIdList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }
}
