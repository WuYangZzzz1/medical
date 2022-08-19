package com.medical.entity;

    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 疫苗信息
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;
        
    private int id;

            /**
            * 疫苗名称
            */
    private String vname;

            /**
            * 疫苗类型
            */
    private String vaccineType;

            /**
            * 生产日期
            */
    private LocalDateTime vaccineDate;

            /**
            * 注意事项
            */
    private String preautions;

            /**
            * 数量
            */
    private Integer number;

            /**
            * 仓库id
            */
    private Integer wid;

            /**
            * 上午接种时间
            */
    private LocalTime amLnoculationDate;

            /**
            * 上午结束接种时间
            */
    private LocalTime amOverDate;

            /**
            * 下午接种时间
            */
    private LocalTime pmLnoculationDate;

            /**
            * 下午结束接种时间
            */
    private LocalTime pmOverDate;


}
