package com.lvmen.community.dto;

import com.lvmen.community.model.Question;
import com.lvmen.community.model.User;
import lombok.Data;

/**
 * Created by lvmen on 2019/10/31
 */
@Data
public class QuestionDTO extends Question {

    private User user;
}
