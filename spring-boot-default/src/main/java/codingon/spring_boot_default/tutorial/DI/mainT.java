package codingon.spring_boot_default.tutorial.DI;

public class mainT {
  public static void main(String[] args) {
    IBoardPersistence persistence = new FileBoardPersistence();
    IBoardPersistence persistence1 = new DbBoardPersistence();
    // 파일에서 데이터베이스로 기획이 변경되었는데, (즉, Persistence 타입이 바뀜)
    // 서비스 코드릴 변경하지 않아도 됨!!

    BoardService service = new BoardService();
    service.setPersistence(persistence1);
    service.save();
    service.delete();
  }
}
