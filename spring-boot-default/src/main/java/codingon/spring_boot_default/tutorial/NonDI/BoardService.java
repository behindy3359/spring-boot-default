package codingon.spring_boot_default.tutorial.NonDI;

public class BoardService {
//  private final FileBoardPersistence persistence;
  private final DbBoardPersistence persistence;

  public BoardService(){
//    this.persistence = new FileBoardPersistence();
    this.persistence = new DbBoardPersistence();
  }

  public void save(){
    persistence.save();
  }

  public void delete(){
    persistence.delete();
  }
}
