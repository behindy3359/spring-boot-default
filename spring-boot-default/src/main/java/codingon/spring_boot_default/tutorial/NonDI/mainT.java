package codingon.spring_boot_default.tutorial.NonDI;

public class mainT {
  public static void main(String[] args) {
    BoardService service = new BoardService();
    service.save();
    service.delete();
  }
}
