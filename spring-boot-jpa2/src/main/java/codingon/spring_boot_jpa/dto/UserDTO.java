package codingon.spring_boot_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // getter 메서드
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder // 빌더 패턴 사용 가능하도록 함
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private int no;
}
