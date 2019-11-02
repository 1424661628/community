package com.lvmen.community.mapper;

import com.lvmen.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lvmen on 2019/10/30
 */
@Mapper
public interface QuestionMapper {

    /**
     * 插入问题
     * @param question
     */
    @Insert("insert into question (title, description, gmt_create, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    void create(Question question);

    /**
     * 分页查询问题
     * @param offset
     * @param size
     * @return
     */
    @Select("select * from question limit #{offset}, #{size} ")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size); // 需要绑定参数

    /**
     * 查询问题总数
     * @return
     */
    @Select("select count(1) from question")
    Integer count();
}
