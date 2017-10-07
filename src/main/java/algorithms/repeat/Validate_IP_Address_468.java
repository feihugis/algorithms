package algorithms.repeat;

import java.util.ArrayList;

public class Validate_IP_Address_468 {
  public String validIPAddress(String IP) {
    if (isIPV4(IP)) return "IPV4";
    if (isIPV6(IP)) return "IPV6";
    return "Neither";
  }

  public boolean isIPV6(String IP) {
    if (!IP.contains(":")) return false;
    String[] tokens = IP.split(":");
    if (tokens.length != 8) {
      return false;
    } else {
      for (String token : tokens) {
        if (!isValidIPV6Token(token)) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isValidIPV6Token(String token) {
    if (token.length() > 4) {
      return false;
    } else {
      for (int i = 0; i < token.length(); i++) {
        char c = token.charAt(i);
        if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'e') && !(c >= 'A' && c <= 'E')) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isIPV4(String IP) {
    if (!IP.contains(".")) return false;
    String[] sections = IP.split("\\.");
    if(sections.length != 4) {
      return false;
    } else {
      for (String token : sections) {
        if (!isValidIPV4Token(token)) {
          return false;
        }
      }
      return true;
    }
  }

  public boolean isValidIPV4Token(String token) {
    if (token.length() == 0) return false;
    if (token.length() > 1 && token.startsWith("0")) return false;
    try {
      int num = Integer.parseInt(token);
      if (num >= 0 && num <= 255) {
        return true;
      } else {
        return false;
      }
    } catch(IllegalArgumentException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    Validate_IP_Address_468 solution = new Validate_IP_Address_468();
    String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
    String[] s1 = ip.split("\\.");
    String[] s2 = ip.split(".");
    System.out.println(solution.validIPAddress(ip));
    int[][] a = {{1, 2}, {2, 3}};

  }

}
