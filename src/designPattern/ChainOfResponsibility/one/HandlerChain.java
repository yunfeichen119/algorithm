package designPattern.ChainOfResponsibility.one;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

  // 持有所有Handler:
  private List<Handler> handlers = new ArrayList<>();

  public void addHandler(Handler handler) {
    this.handlers.add(handler);
  }

  public boolean process(Request request) {
    // 依次调用每个Handler:
    for (Handler handler : handlers) {
      Boolean r = handler.process(request);
      if (r != null) {
        // 如果返回TRUE或FALSE，处理结束:
        System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
        return r;
      }
    }
    throw new RuntimeException("Could not handle request: " + request);
  }
}
