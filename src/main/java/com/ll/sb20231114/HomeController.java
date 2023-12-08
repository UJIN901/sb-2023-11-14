package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 컨트롤러 입니다.
@Controller
public class HomeController {
    // 해당 url과 연결
    @GetMapping("/")
    // 함수의 리턴값을 그대로 브라우저에 출력
    @ResponseBody
    String showMain() {
        return "메인 화면";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc2")
    @ResponseBody
        //Integer의 경우 null을 담을 수 있다.
    String showCalc2(Integer a, Integer b) {
        return "계산기";
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(@RequestParam(defaultValue = "0") double a, @RequestParam(defaultValue = "0") double b) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(@RequestParam(defaultValue = "0") String a, @RequestParam(defaultValue = "0") String b) {
        return "계산 결과 : %s".formatted(a + b);
    }
}
