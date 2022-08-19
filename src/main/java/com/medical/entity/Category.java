package com.medical.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 药品分类
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
        
    private int classes;

            /**
            * 类别
            */
    private String classes;


}
