package com.test.tools.service;

import com.test.tools.dao.TestDao;
import com.test.tools.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public TestEntity getById(Integer id){

        return testDao.getById(id);
    }
}

