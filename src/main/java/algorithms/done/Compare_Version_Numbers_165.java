package algorithms.done;

/**
 * Created by Fei Hu on 9/24/17.
 */
public class Compare_Version_Numbers_165 {
  public int compareVersion(String version1, String version2) {
    if (version1 == null || version2 == null) return 0;

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    if (v1.length == 0) {
      v1 = new String[] {version1};
    }

    if (v2.length == 0) {
      v2 = new String[] {version2};
    }

    int len = Math.max(v1.length, v2.length);

    for (int i = 0; i < len; i++) {
      int n1 = v1.length > i? Integer.parseInt(v1[i]) : 0;
      int n2 = v2.length > i? Integer.parseInt(v2[i]) : 0;
      if (n1 > n2) {
        return 1;
      } else if (n1 < n2){
        return -1;
      }
    }

    return 0;
  }

}
