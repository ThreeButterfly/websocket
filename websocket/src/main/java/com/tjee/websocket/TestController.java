package com.tjee.websocket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("index")
    public String getInfo2()   {

        return "/websocket";
    }
  
}
