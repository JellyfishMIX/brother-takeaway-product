package me.jmix.brothertakeaway.product.controller;

import me.jmix.brothertakeaway.product.dto.CartDTO;
import me.jmix.brothertakeaway.product.entity.ProductCategory;
import me.jmix.brothertakeaway.product.entity.ProductInfo;
import me.jmix.brothertakeaway.product.service.ProductCategoryService;
import me.jmix.brothertakeaway.product.service.ProductInfoService;
import me.jmix.brothertakeaway.product.utils.ResultVOUtil;
import me.jmix.brothertakeaway.product.vo.ProductCategoryVO;
import me.jmix.brothertakeaway.product.vo.ProductInfoVO;
import me.jmix.brothertakeaway.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:19 下午
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productInfoService.getShelvesProductInfo();

        // 2. 获取类目type列表
        List<Integer> productCategoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        // 3. 从数据库查询类目
        List<ProductCategory> productCategoryList = productCategoryService.getListByCategoryTypeIn(productCategoryTypeList);

        // 4. 构造数据
        List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            productCategoryVO.setCategoryName(productCategory.getCategoryName());
            productCategoryVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productCategoryVO.setProductInfoVOList(productInfoVOList);
            productCategoryVOList.add(productCategoryVO);
        }

        return ResultVOUtil.success(productCategoryList);
    }

    /**
     * 获取商品列表（给订单服务使用）
     *
     * @param productInfoList productInfoList
     * @return
     */
    @PostMapping("/list-for-order")
    public List<ProductInfo> listForProduct(@RequestBody List<String> productInfoList) {
        return productInfoService.queryProductInfoListByProductIdList(productInfoList);
    }

    /**
     * 扣库存
     *
     * @param cartDTOList cartDTOList
     */
    @PostMapping("/decrease-stock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productInfoService.decreaseStock(cartDTOList);
    }
}
