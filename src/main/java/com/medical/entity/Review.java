package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.List;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 评论
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private String review;

    private LocalDateTime reviewDate;

            /**
            * 社区id
            */
    private Integer mid;

            /**
            * 药品id
            */
    private String drid;
    private Drug drug;
    private Munity munity;
}
