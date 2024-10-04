package codingon.spring_boot_default.controller;


import codingon.spring_boot_default.utils.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;


// @Controller
// - Spring MVC 에 Controller 클래스로 인식되어 Spring MVC 가 제공하는 다양한 어노테이션 사용 가능
@Controller
public class HelloController {
  // 클라이언트 요청에 대한 처리를 각 메서드에서 작성

  //@GetMapping 어노테이션
  // - GET 요청에 대한 URL 을 매핑
  // GET localhost:PORT/hi
  @GetMapping("/hi")
  public String getHi(Model model) {
    // Model model
    // - Spring MVC 가 제공하는 타입 (View 에 값을 전달하는 상자 역할, MVC 의 Model 을 의미 x)
    // - View 에서 참조할 수 있는 객체 저장
    // - Controller 클래스의 메서드가 파라미터로 받을 수 있는 객체

    // View 에 값을 전달하기 위해 model 상자에 데이터(속성-값) 추가
    model.addAttribute("msg", "Hi~");

    // 템플릿 파일명 반환
    // src/resources/templates/_01_thymeleaf/hi.html 을 반환
    return "day01/hi";
  }
  @GetMapping("/tutorial")
  public String getTuroeial(Model model) {

    // Model model
    // - Spring MVC 가 제공하는 타입 (View 에 값을 전달하는 상자 역할, MVC 의 Model 을 의미 x)
    // - View 에서 참조할 수 있는 객체 저장
    // - Controller 클래스의 메서드가 파라미터로 받을 수 있는 객체

    // #1. Thymeleaf 템플릿 소개
    // View 에 값을 전달하기 위해 model 상자에 데이터(속성-값) 추가
//        model.addAttribute("msg", "Hi~");

    // #2. Thymeleaf 표현식과 문법
    model.addAttribute("hello", "Spring World!");
    model.addAttribute("uText", "<strong>Spring World!</strong>");
    model.addAttribute("value", "이름을 입력하세요.");
    model.addAttribute("withValue", "hello");
    model.addAttribute("link", "hi");
    model.addAttribute("imgSrc", "image4.jpg");
    model.addAttribute("userRole", "admin");
    model.addAttribute("isAdmin", false);

    // 템플릿 파일명 반환
    // src/resources/templates/_01_thymeleaf/hi.html 을 반환
    return "day01/tutorial";
  }

  @GetMapping("/ex01")
  public String getEx01(Model model) {

    model.addAttribute("age", "25");

    return "day01/ex01";
  }

  @GetMapping("/ex02")
  public String getEx02(Model model) {
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(new Person("kim", 10));
    persons.add(new Person("Lee", 20));
    persons.add(new Person("park", 30));
    persons.add(new Person("choi", 40));
    persons.add(new Person("han", 50));

    model.addAttribute("persons", persons);
    return "day01/ex02";
  }
}
