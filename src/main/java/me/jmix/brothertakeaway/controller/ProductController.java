package me.jmix.brothertakeaway.controller;

import me.jmix.brothertakeaway.entity.ProductCategory;
import me.jmix.brothertakeaway.entity.ProductInfo;
import me.jmix.brothertakeaway.service.ProductCategoryService;
import me.jmix.brothertakeaway.service.ProductService;
import me.jmix.brothertakeaway.utils.ResultVOUtil;
import me.jmix.brothertakeaway.vo.ProductCategoryVO;
import me.jmix.brothertakeaway.vo.ProductInfoVO;
import me.jmix.brothertakeaway.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private ProductService productService;
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
        List<ProductInfo> productInfoList = productService.getShelvesProductInfo();

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
}
