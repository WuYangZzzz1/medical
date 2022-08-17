package com.medical.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 订单
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private Integer uid;

            /**
            * 订单状态
            */
    private String orderState;

            /**
            * 订单编号
            */
    private Integer orderNumber;


}
