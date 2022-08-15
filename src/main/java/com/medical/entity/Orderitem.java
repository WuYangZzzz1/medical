package com.medical.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 订单项
    * </p>
*
* @author JiaJieTang
* @since 2022-08-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 药品id
            */
    private Integer drid;
    private Drug drug;

            /**
            * 用户id
            */
    private Integer uid;

            /**
            * 购买数量
            */
    private Integer number;

            /**
            * 订单id
            */
    private Integer oid;
    private Orders orders;
    private float totalPrice;
}
