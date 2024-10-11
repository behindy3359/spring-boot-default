package codingon.spring_boot_default.tutorial.DI;

public class BoardService {
//  //생성자를 통해 의존성 주입하기
//  private final IBoardPersistence persistence;
//
//  public BoardService(IBoardPersistence persistence) {
//    this.persistence = persistence;
//  }

  // setter 를 이용한 의존성 주입
  private IBoardPersistence persistence; // final 키워드는 사용하지 않아야함

  public void setPersistence(IBoardPersistence persistence) {
    this.persistence = persistence;
  }

  public void save() {
    persistence.save();
  }

  public void delete() {
    persistence.delete();
  }
}
