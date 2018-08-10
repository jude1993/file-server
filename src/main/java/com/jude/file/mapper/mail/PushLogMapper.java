package com.jude.file.mapper.mail;

import com.jude.file.bean.mail.dao.PushLogDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PushLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PushLogDO record);

    int insertSelective(PushLogDO record);

    PushLogDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PushLogDO record);

    int updateByPrimaryKey(PushLogDO record);

    List<PushLogDO> queryPage(@Param("index") Integer index, @Param("size") Integer size);
}