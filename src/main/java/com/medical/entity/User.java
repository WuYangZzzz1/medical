package com.medical.entity;


    import java.time.LocalDate;
    import java.io.Serializable;
    import java.util.Date;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户表
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String username;

    private String password;

            /**
            * 姓名
            */
    private String name;

            /**
            * 出生日期
            */
    private LocalDate brithday;

            /**
            * 年龄
            */
    private Integer age;

            /**
            * 性别
            */
    private String sex;

            /**
            * 联系方式
            */
    private Integer tel;

            /**
            * 身份证
            */
    private String idcard;

            /**
            * 注册时间
            */
    private Date enrollDate;

            /**
            * 医生外键
            */
    private Integer doid;

            /**
            * 封号状态
            */
    private String uState;


            /**
             * 收货地址
             */
    private String harvestAddress;
             /**
             * 会员id
             */

    private Integer vipId;

}
