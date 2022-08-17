package com.medical.entity;

    import java.io.Serializable;

    import com.medical.service.impl.OrdersServiceImpl;
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

    public String getStatusDesc() {
        String desc = "未知";
        switch (orderState) {
            case OrdersServiceImpl.waitPay:
                desc = "待付";
                break;
            case OrdersServiceImpl.waitDelivery:
                desc = "待发";
                break;
            case OrdersServiceImpl.waitConfirm:
                desc = "待收";
                break;
            case OrdersServiceImpl.waitReview:
                desc = "等评";
                break;
            case OrdersServiceImpl.finish:
                desc = "完成";
                break;
            case OrdersServiceImpl.delete:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }

    public String getStatusDesc() {
        String desc = "未知";
        switch (orderState) {
            case OrdersServiceImpl.waitPay:
                desc = "待付";
                break;
            case OrdersServiceImpl.waitDelivery:
                desc = "待发";
                break;
            case OrdersServiceImpl.waitConfirm:
                desc = "待收";
                break;
            case OrdersServiceImpl.waitReview:
                desc = "等评";
                break;
            case OrdersServiceImpl.finish:
                desc = "完成";
                break;
            case OrdersServiceImpl.delete:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }
}
