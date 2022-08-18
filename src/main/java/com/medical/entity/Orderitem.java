package com.medical.entity;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotation.TableField;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 订单项
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Orderitme implements Serializable {

    private static final long serialVersionUID = 1L;
    private  int id;
            /**
            * 药品id
            */
    private Integer drid;

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

    @TableField(exist = false)
    private Orders orders;
}
