package designPattern.ChainOfResponsibility.one;

import java.math.BigDecimal;

public class CEOHandler implements  Handler {

  public Boolean process(Request request) {

    // 对Bob有偏见:
    return !request.getName().equalsIgnoreCase("jim");
  }
}
