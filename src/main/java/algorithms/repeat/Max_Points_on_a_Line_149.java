package algorithms.repeat;

/**
 * Created by Fei Hu on 9/23/17.
 */

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
 }
public class Max_Points_on_a_Line_149 {
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) return 0;
    int max = 1;

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int num = 2;
        for (int p = 0; p < points.length; p++) {
          if (p != i && p != j) {
            if (isSame(points[i], points[j])) {
              if (isSame(points[i], points[p])) {
                num++;
              }
            } else if (isLine(points[i], points[j], points[p])) {
              num++;
            }
          }

        }
        max = Math.max(max, num);
      }
    }
    return max;
  }

  public boolean isSame(Point p1, Point p2) {
    if (p1.x == p2.x && p1.y == p2.y) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isLine(Point p1, Point p2, Point p3) {
    if (p2.y == p1.y) {
      if (p3.y != p1.y) {
        return false;
      } else {
        return true;
      }
    }

    if (p2.x == p1.x) {
      if (p3.x != p1.x) {
        return false;
      } else {
        return true;
      }
    }

    double left = (p3.y - p1.y)*1.0 / (p2.y - p1.y);
    double right = (p3.x - p1.x)*1.0 / (p2.x - p1.x);

    boolean result = ((p3.y - p1.y)*1.0 * (p2.x - p1.x)  == (p3.x - p1.x)*1.0*(p2.y - p1.y)) ;
    return result;
  }

  public static void main(String[] args) {
    Max_Points_on_a_Line_149 solution = new Max_Points_on_a_Line_149();
    Point[] points = new Point[3];
    //Failed to process this case
    //[[0,0],[94911151,94911150],[94911152,94911151]]
    points[0] = new Point(0, 0);
    points[1] = new Point(94911151,94911150);
    points[2] = new Point(94911152,94911151);
    String[] as = "123.23".split("\\.");
    System.out.println(solution.maxPoints(points));


  }

}
