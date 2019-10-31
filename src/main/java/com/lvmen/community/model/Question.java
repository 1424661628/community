package com.lvmen.community.model;

import lombok.Data;

/**
 * Created by lvmen on 2019/10/30
 */
@Data
public class Question {

    private Integer id;
    private String title;
    public String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;

}
