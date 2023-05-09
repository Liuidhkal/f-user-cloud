package com.lfz.demo.dao;

import com.lfz.demo.pojo.Title;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TitleDao {
    @Select("select * from title")
    public List<Title> select();

    @Delete("delete from title where title_id = #{id}")
    public void delete(Long id);
}
