package com.mm.test;

import com.mm.dao.CarInfoMapper;
import com.mm.entity.CarInfo;
import com.mm.entity.vo.CarInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-12 23:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_dao.xml", "classpath:spring_service.xml"})
public class TwoTEst {
    @Autowired
    CarInfoMapper carInfoMapper;

    @Test
    public void oneTest() {
        CarInfoVo vo = new CarInfoVo();
        //vo.setVoName("s");
        //vo.setVoTypeId(1);
        vo.setLowestPrice(19);
        vo.setHighestPrice(3999);
        List<CarInfo> list = carInfoMapper.selectConditions(vo);
        list.forEach(productInfo -> System.out.println(productInfo));
    }

    @Test
    public void twoTest() {
        String s = "";
        if (s.equals("")) {
            System.out.println("dkfj");
        }
    }
}
