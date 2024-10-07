package codingon.spring_boot_default.controller;

import codingon.spring_boot_default.dto.UserDTOEX;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestController {
  @GetMapping("/day02/req")
  public String getReq(){ return "day02/req";}

  @GetMapping("/day02/get/res1")
  public String getMethodQueryString(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "age" ) int age,
      Model model
  ){

    System.out.println("[GET], request query string (name) = " + name);
    System.out.println("[GET], request query string (age) = " + age);

    model.addAttribute("name", name);
    model.addAttribute("age", age);

    return "day02/res";
  }

  @GetMapping("/day02/get/res2")
  public String getMethodQueryStringRequiredFalse(
      @RequestParam(value = "name", required = false) String name,
      Model model
  ){
    System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    model.addAttribute("name", name);

    return "day02/res";
  }

  @GetMapping("/day02/get/res3/{param1}/{param2}")
  public String getMethodPathVariable(
      @PathVariable String param1,
      @PathVariable("param2") int age,
      Model model
  ){
    model.addAttribute("name", param1);
    model.addAttribute("age", age);

    return "day02/res";
  }

  @GetMapping({"/day02/get/res4/{name}/{age}", "/day02/get/res4/{name}"})
  public String getMethodPathVariableOptional(
      @PathVariable String name,
      @PathVariable(required = false) Integer age,
      Model model
  ){
    model.addAttribute("name", name);
    model.addAttribute("age", age);

    return "day02/res";
  }

  @PostMapping("/post/res1")
  public String postRes1 (
      @RequestParam String name,
      @RequestParam int age,
      Model model
  ){
    System.out.println("[POST] request body form data (name) = " + name);
    System.out.println("[POST] request body form data (age) = " + age);

    model.addAttribute("name", name); // 성춘향
    model.addAttribute("age", age); // null

    return "day02/res";
  }

  @PostMapping("/post/res2")
  public String postRes2 (
      @RequestParam String name,
      @RequestParam( required = false ) Integer age,
      Model model
  ){
    System.out.println("[POST] request body form data (name) = " + name);
    System.out.println("[POST] request body form data (age) = " + age);

    model.addAttribute("name", name); // 성춘향
    model.addAttribute("age", age); // null

    return "day02/res";
  }

  @PostMapping("/post/res3")
  @ResponseBody
  public String postRes3 (
      @RequestParam String name,
      @RequestParam int age,
      Model model
  ){
    System.out.println("[POST] request body form data (name) = " + name);
    System.out.println("[POST] request body form data (age) = " + age);

    model.addAttribute("name", name); // 성춘향
    model.addAttribute("age", age); // null

    return name + " [ 빈 공간입니다. ]  " + age;
  }

  @PostMapping("/post/res4")
  @ResponseBody
  public String postRes4 (
      @RequestParam String name,
      @RequestParam int age,
      Model model
  ){
    System.out.println("[POST] request body form data (name) = " + name);
    System.out.println("[POST] request body form data (age) = " + age);

    model.addAttribute("name", name); // 성춘향
    model.addAttribute("age", age); // null

    return name + " [ 빈 공간입니다. ]  " + age;
  }

  @GetMapping("/dto/res1")
  @ResponseBody
  public String dtoRes1(@ModelAttribute UserDTOEX userDTO){
    System.out.println("[GET] userDTO (name) = " + userDTO.getName());
    System.out.println("[GET] userDTO (age) = " + userDTO.getAge());
    return userDTO.getName() + "    " + userDTO.getAge();
  }

  @PostMapping("/dto/res2")
  @ResponseBody
  public String dtoRes2(UserDTOEX userDTO){
    System.out.println("[POST] userDTO (name) = " + userDTO.getName());
    System.out.println("[POST] userDTO (age) = " + userDTO.getAge());
    return userDTO.getName() + "    " + userDTO.getAge();
  }

  @PostMapping("/dto/res3")
  @ResponseBody
  public String dtoRes3(@RequestBody UserDTOEX userDTO){
    System.out.println("[POST] userDTO (name) = " + userDTO.getName());
    System.out.println("[POST] userDTO (age) = " + userDTO.getAge());
    return userDTO.getName() + "    " + userDTO.getAge();
  }
}
