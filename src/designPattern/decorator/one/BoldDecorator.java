package designPattern.decorator.one;

public class BoldDecorator extends NodeDecorator {

  public BoldDecorator(TextNode target) {
    super(target);
  }

  public String getText() {
    return "<b>" + target.getText() + "</b>";
  }

}
