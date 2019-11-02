package com.lvmen.community.service;

import com.lvmen.community.dto.PaginationDTO;
import com.lvmen.community.dto.QuestionDTO;
import com.lvmen.community.mapper.QuestionMapper;
import com.lvmen.community.mapper.UserMapper;
import com.lvmen.community.model.Question;
import com.lvmen.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvmen on 2019/10/31
 */
@Service // 请求需要组装 user和question的时候。我们需要引入service层
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;


    /**
     * 分页查询问题
     * @param page
     * @param size
     * @return
     */
    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1){
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        // size*(page-1)
        Integer offset = (page - 1) * size;
        List<Question> questionList = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO); // Spring内置的BeanUtils快速拷贝一个对象到另一个对象（通过属性名）
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
