package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        int i = 1 / 0;

        Girl girlB = new Girl();
        girlB.setCupSize("A");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }

    public Integer getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
//            throw new Exception("你还在上小学吧");
            throw new GirlException(100,"你还在上小学吧");
        } else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
//            throw new Exception("你可能在上初中");
            throw new GirlException(101,"你可能在上初中");
        }

        //如果>16,加钱
        return 0;
    }
}
