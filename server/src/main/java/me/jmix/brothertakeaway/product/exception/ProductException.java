package me.jmix.brothertakeaway.product.exception;

import me.jmix.brothertakeaway.product.enums.ProductEnum;

/**
 * @author JellyfishMIX
 * @date 2020/6/18 3:58 下午
 */
public class ProductException extends RuntimeException {
    private static final long serialVersionUID = 648161339375831995L;
    private Integer stateCode;
    private String stateMessage;

    public ProductException(Integer stateCode, String stateMessage) {
        super(stateMessage);
        this.stateCode = stateCode;
        this.stateMessage = stateMessage;
    }

    public ProductException(ProductEnum productEnum) {
        super(productEnum.getStateMessage());
        this.stateCode = productEnum.getStateCode();
        this.stateMessage = productEnum.getStateMessage();
    }
}
