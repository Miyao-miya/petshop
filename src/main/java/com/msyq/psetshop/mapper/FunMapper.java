package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Fun;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FunMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Fun record);

    int insertSelective(Fun record);

    Fun selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Fun record);

    int updateByPrimaryKey(Fun record);

    List<Fun> findAllByFkUIdAndFPassword(@Param("fkUId")Integer fkUId,@Param("fPassword")String fPassword);

    List<Fun> findAllByFkUIdAndFPasswordAndFNumber(@Param("fkUId")Integer fkUId,@Param("fPassword")String fPassword,@Param("fNumber")Integer fNumber);

    int updateByFkUIdAndFPasswordAndFNumber(@Param("updated")Fun updated,
                                            @Param("fkUId")Integer fkUId,
                                            @Param("fPassword")String fPassword);


}