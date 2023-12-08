package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 컨트롤러 입니다.
@Controller
public class HomeController {
    // 해당 url과 연결
    @GetMapping("/")
    // 함수의 리턴값을 그대로 브라우저에 출력
    @ResponseBody
    String showMain(){
        return "메인 화면";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }

}
