package designPattern.decorator.one;

public abstract class NodeDecorator implements TextNode {

  protected final TextNode target;

  protected NodeDecorator(TextNode target) {
    this.target = target;
  }

  public void setText(String text) {
    this.target.setText(text);
  }

}
