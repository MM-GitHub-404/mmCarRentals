package com.mm.listener;

/**
 * @author 茂茂
 * @create 2022-02-12 13:48
 */

import com.mm.entity.CarType;
import com.mm.service.CarTypeSevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.applet.AppletContext;
import java.util.List;

@WebListener
public class CarTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //由于项目已经注册过监听器,本类去创建监听器时不能再使用自动注入,
        //因此需手工从Spring容器中取出全局作用域对象.
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_*.xml");
        CarTypeSevice carTypeSevice = (CarTypeSevice) applicationContext.getBean("CarTypeSeviceImpl");
        List<CarType> carTypeList = carTypeSevice.selectAllType();
        //将查询到的车辆类型装入全局作用域中,提供前端使用
        servletContextEvent.getServletContext().setAttribute("carTypeList", carTypeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
