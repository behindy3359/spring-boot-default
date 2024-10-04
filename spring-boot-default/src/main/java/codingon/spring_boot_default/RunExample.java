package codingon.spring_boot_default;

import codingon.spring_boot_default.dto.UserDTO;
import codingon.spring_boot_default.vo.Point;

public class RunExample {
  public static void main(String[] args) {
//    UserDTO u1 = new UserDTO();
//    u1.setId(1L);
//    u1.setUsername("kim");
//    u1.setEmail("test@test.com");
//    u1.setAge(30);
//
//    System.out.println("u1 = " + u1);
//
//    UserDTO u2 = new UserDTO(30L, "Lee", "tttt@tttt.ttt", 50);
//    System.out.println("u2 = " + u2);
//    System.out.println("email : " + u2.getEmail());

    Point p1 = new Point(0,0);
    Point p2 = new Point(3, 4);

    System.out.println("p1 = " + p1);
    System.out.println("p2 = " + p2);
    System.out.println("두 점사이의 거리 " +  p1.distanceTo(p2));

    Point p3 = new Point(3, 4);

    System.out.println("p1(0,0) 과 p3(3,4) 는 같은 객체인가? >>> " + p1.equals(p3));
    System.out.println("p2(3,4) 과 p3(3,4) 는 같은 객체인가? >>> " + p2.equals(p3));
  }
}

