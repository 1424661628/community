package com.lvmen.community.dto;

import com.lvmen.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * index页面需要用到的分页问题模型
 * Created by lvmen on 2019/11/2
 */
@Data
public class PaginationDTO {

    private List<QuestionDTO> questions;
    private Boolean showPrevious; // 向前按钮
    private Boolean showFirstPage; // 第一页
    private Boolean showNext; // 向后按钮
    private Boolean showEndPage; // 最后一页
    private Integer totalPage; // 总页数
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) { // 根据totalCount，当前页，分页大小来确定展示效果

        this.page = page;

        if (totalCount % size == 0){
            totalPage = totalCount/size;
        }else {
            totalPage = totalCount/size + 1;
        }



        pages.add(page);
        for (int i = 1; i <= 3; i++){
            if (page - i > 0){
                pages.add(0,page - i);
            }
            if (page + i <= totalPage){
                pages.add(page + i);
            }
        }


        // 是否展示及上一页
        if (page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }
        // 是否展示下一页
        if (page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        // 是否展示第一页
        if (pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalCount)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }

    }
}
