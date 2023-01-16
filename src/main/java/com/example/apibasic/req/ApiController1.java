package com.example.apibasic.req;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/param1")
    public String param1(String username //파라미터 키 값과 변수명이 같으면 어노테이션 생략가능
            , @RequestParam("age") int  userAge){

        log.info("/param1?username{}&age={} GET!!",username,userAge);
        log.info("내 이름은 {}, 나이는 {}세",username,userAge);
        return "";
    }

    @GetMapping("/param2")
    public String param2(OrderInfo orderInfo){
        log.info("/param2?orderNo={}&goodsName={}&goodsAmount={}"
        ,orderInfo.getOrderNo(),orderInfo.getGoodsName(),orderInfo.getGoodsAmount());
        return "";
    }

    // 커맨드 객체 : 클라이언트가 보낸 파라미터 이름과 필드명이 정확히 일치해야함.
    @Setter @Getter
    @ToString
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class OrderInfo {
        private Long orderNo;
        private String goodsName;
        private Integer goodsAmount;

    }

    @PostMapping("/req-body")
    public String reqBody(@RequestBody OrderInfo orderInfo){
        log.info("=========주문 정보=========");
        log.info("# 주문번호: {}",orderInfo.getOrderNo());
        log.info("# 상품명: {}",orderInfo.getGoodsName());
        log.info("# 수량: {}",orderInfo.getGoodsAmount());

        return "";
    }
}
