package com.zhu.modules.sys.dao;

import com.zhu.modules.sys.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="dictDao")
public interface DictDao {

    //@Select("SELECT * FROM sys_dict WHERE del_flag = '0' ORDER BY type, sort DESC")
    List<Dict> findAllList(Dict dict);

    //@Select("select * from sys_dict where id = #{id}")
    Dict get(@Param("id") String id);

    void insert(Dict entity);

    void update(Dict entity);

}
