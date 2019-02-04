package com.hendisantika.springbootpid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pid
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-04
 * Time: 17:44
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return "foo";
    }
}