package com.mm.service.impl;

import com.mm.dao.CarInfoMapper;
import com.mm.dao.CarTypeMapper;
import com.mm.entity.CarType;
import com.mm.entity.CarTypeExample;
import com.mm.service.CarTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-12 13:45
 */
@Service("CarTypeSeviceImpl")
public class CarTypeSeviceImpl implements CarTypeSevice {

    @Autowired
    CarTypeMapper carTypeMapper;

    @Override
    public List<CarType> selectAllType() {
        return carTypeMapper.selectByExample(new CarTypeExample());
    }

}
