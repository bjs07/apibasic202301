package com.example.apibasic.req;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpHeaders;
import java.util.Enumeration;

@Controller
@ResponseBody
@Slf4j
@RequestMapping("say")
public class ApiController1 {
    @RequestMapping(value="/hello",method={RequestMethod.GET,RequestMethod.POST})
    public String hello(HttpServletRequest request){
       log.trace("trace log");
       log.debug("debug log");
       log.info("hello spring",request.getMethod());
       log.warn("warn log");
       log.error("error log");
        return "";
    }

    @RequestMapping(value = "/greet",method = RequestMethod.GET)
    public String greet(){
        log.info("/greet get 요청");
        return "";
    }
    @RequestMapping(value = "/greet",method = RequestMethod.POST)
    public String greet2(){
        log.info("/greet post 요청");
        return "";
    }
    @GetMapping("/header")
    public String header(HttpServletRequest request){
        String host = request.getHeader("Host");
        String accept = request.getHeader("Accept");
        String pet = request.getHeader("pet");
        log.info("======host info=====");
        log.info("# host : {}", host);
        log.info("# accept : {}", accept);
        log.info("# pet : {}", pet);

        return "";
    }
}
