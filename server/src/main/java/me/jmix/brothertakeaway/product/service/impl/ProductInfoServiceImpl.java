package me.jmix.brothertakeaway.product.service.impl;

import me.jmix.brothertakeaway.product.dao.ProductInfoRepository;
import me.jmix.brothertakeaway.product.dto.CartDTO;
import me.jmix.brothertakeaway.product.entity.ProductInfo;
import me.jmix.brothertakeaway.product.enums.ProductEnum;
import me.jmix.brothertakeaway.product.exception.ProductException;
import me.jmix.brothertakeaway.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(ProductEnum.SHELVES.getStateCode());
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

    /**
     * 扣库存
     *
     * @param cartDTOList cartDTOList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ProductEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // 判断商品是否足够
            if (result < 0) {
                throw new ProductException(ProductEnum.INVENTORY_SHORTAGE);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
