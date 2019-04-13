package cn.dazhiyy.high.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.controller
 * @className TestController
 * @description TODO
 * @date 2019/4/8 22:14
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(){
        System.out.println(11);
        return "hello word";
    }
}
