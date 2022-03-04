package com.test.tools.dao;

import com.test.tools.entity.DiffyEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiffyDao {

    int addCommitLog(DiffyEntity diffyEntity);

    // 获取diffy的启动命令
    DiffyEntity getCommandParam();

}
