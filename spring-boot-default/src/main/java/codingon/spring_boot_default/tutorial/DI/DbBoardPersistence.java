package codingon.spring_boot_default.tutorial.DI;

public class DbBoardPersistence implements IBoardPersistence{
  public void save(){
    System.out.println("데이터베이스에 게시글 저장 중");
  }

  public void delete(){
    System.out.println("데이터베이스에 저장된 게시글 삭제 중");
  }
}
