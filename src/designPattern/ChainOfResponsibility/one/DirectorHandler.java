package designPattern.ChainOfResponsibility.one;

import java.math.BigDecimal;

public class DirectorHandler implements  Handler {

  public Boolean process(Request request) {
    // 如果超过10000元，处理不了，交下一个处理:
    if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
      return null;
    }
    // 对Bob有偏见:
    return !request.getName().equalsIgnoreCase("tom");
  }
}
