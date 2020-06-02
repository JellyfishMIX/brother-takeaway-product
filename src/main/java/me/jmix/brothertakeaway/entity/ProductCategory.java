package me.jmix.brothertakeaway.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author JellyfishMIX
 * @date 2020/6/1 9:47 下午
 */
@Data
@Table(name = "tb_product_category")
@Entity
public class ProductCategory {
    /**
     * 类目Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目分类
     */
    private Integer categoryType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
