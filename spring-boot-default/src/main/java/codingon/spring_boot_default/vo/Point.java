package codingon.spring_boot_default.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Point {
  private final int x;
  private final int y;

  public double distanceTo(Point point){
    int dx = this.x - point.x;
    int dy = this.y - point.y;
    return Math.sqrt(dx*dx + dy*dy);
  }

  @Override
  public boolean equals(Object o){
    if( this == o ) return true;
    if( o == null || getClass() != o.getClass()) return false;

    Point point = (Point) o;
    return x== point.x && y == point.y;
  }

  @Override
  public int hashCode(){

    return Objects.hash( x, y );
  }
}
