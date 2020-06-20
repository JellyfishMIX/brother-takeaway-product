package me.jmix.brothertakeaway.product.vo;

import lombok.Data;

/**
 * @author JellyfishMIX
 * @date 2020/6/20 8:56 下午
 */
@Data
public class CartVO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartVO() {
    }

    public CartVO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
