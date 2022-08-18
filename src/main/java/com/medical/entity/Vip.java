package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Vip implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
            /**
            * 注册时间
            */
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate;

            /**
            * 会员到期时间
            */
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireDate;

    private User user;

}
