package com.mm.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 茂茂
 * @create 2022-02-21 9:22
 */
@ControllerAdvice
public class MyException {
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView doAgeException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "提示信息");
        mv.addObject("ex", exception);
        mv.setViewName("xxxError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "提示信息");
        mv.addObject("ex", exception);
        mv.setViewName("xxxError");
        return mv;
    }
}
