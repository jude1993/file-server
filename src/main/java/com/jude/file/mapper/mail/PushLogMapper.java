package com.jude.file.mapper.mail;

import com.jude.file.bean.mail.dao.PushLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PushLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PushLog record);

    int insertSelective(PushLog record);

    PushLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PushLog record);

    int updateByPrimaryKey(PushLog record);

    List<PushLog> queryPage(@Param("index") Integer index, @Param("size") Integer size);
}