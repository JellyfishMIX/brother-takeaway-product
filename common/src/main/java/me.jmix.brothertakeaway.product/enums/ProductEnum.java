package me.jmix.brothertakeaway.product.enums;

import lombok.Getter;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:16 下午
 */
@Getter
public enum ProductEnum {
    // 商品状态
    SHELVES(0, "上架"),
    DISCONTINUED(1, "下架"),

    // 执行结果
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    INVENTORY_SHORTAGE(2, "库存不足");

    private Integer stateCode;
    private String stateMessage;

    ProductEnum(Integer stateCode, String stateMessage) {
        this.stateCode = stateCode;
        this.stateMessage = stateMessage;
    }
}
