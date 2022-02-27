package com.mm.dao;

import com.mm.entity.CarInfo;
import com.mm.entity.CarInfoExample;
import com.mm.entity.vo.CarInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoMapper {
    int countByExample(CarInfoExample example);

    int deleteByExample(CarInfoExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    List<CarInfo> selectByExample(CarInfoExample example);

    CarInfo selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByExample(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    int deleteCarBatch(String[] cars);

    List<CarInfo> selectConditions(CarInfoVo carInfoVo);
}