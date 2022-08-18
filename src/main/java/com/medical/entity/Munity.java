package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.medical.service.MunityService;
    import com.medical.service.UserService;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 社区
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Munity implements Serializable {


    private static final long serialVersionUID = 1L;
    private  int id;
            /**
            * 小标题
            */
    private String subtitle;

            /**
            * 内容
            */
    private String content;

            /**
            * 发布日期
            */
    private LocalDateTime contentDate;

            /**
            * 发布状态
            */
    private String cState;

            /**
            * 用户id
            */
    private Integer uid;

    public String getStatusDesc(){
        String desc ="未知";
        switch(cState){
            case MunityService.getout:
                desc="上架中";
                break;
            case MunityService.soldout:
                desc="已下架";
                break;
            default:
                desc="未知";
        }
        cState = desc;
        return cState;
    }
}
