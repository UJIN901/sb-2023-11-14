package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(int a, int b){
        return a+b;
    }
    // 함수 리턴 -> SB(번역) -> 브라우저 과정을 거친다. 일반적으로 문자열(JSON)로 번역된다.
    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(int a, int b){
        return a > b;
    }
    @AllArgsConstructor
    class Person{
        public String name;
        public int age;
    }

    @AllArgsConstructor
    @Getter
    class Person2{
        private String name;
        private int age;
    }
    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(String name, int age){
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(String name, int age){
        return new Person2(name, age);
    }
    // json 방식으로는 객체와 Map을 구분할 수 있는 방법이 없다.
    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(String name, int age){
        Map<String, Object> personMap = Map.of("name", name, "age", age);

        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Person2> showCalc11(String name, int age){
        List<Person2> persons = new ArrayList<>(){{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }}; // 첫번째 중괄호 : 내부 클래스임을 정의, 두번째 중괄호 : 객체 초기화
        return persons;
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14(){
        String html = "";
        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\"";
        html += "</div>";

        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15(){
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");

        return sb.toString();
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16(){
        String html = """
                <div>
                    <input type="text" placeholder="내용">
                </div>
                """;
        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17(){
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="안녕하세요">
                </div>
                """;
        return html;
    }

}
