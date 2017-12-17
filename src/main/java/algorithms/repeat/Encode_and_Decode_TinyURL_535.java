package algorithms.repeat;

import java.util.HashMap;
import java.util.Random;

public class Encode_and_Decode_TinyURL_535 {
  HashMap<String, String> map = new HashMap<String, String>();
  Random rand = new Random();
  String alphas = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private String getCode() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      char c = alphas.charAt(rand.nextInt(62));
      str.append(c);
    }
    if (!map.containsKey(str.toString())) {
      return str.toString();
    } else {
      return getCode();
    }
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String code = getCode();
    map.put(code, longUrl);
    return "https://leetcode.com/" + code;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String code = shortUrl.replace("https://leetcode.com/", "");
    return map.get(code);
  }

}
