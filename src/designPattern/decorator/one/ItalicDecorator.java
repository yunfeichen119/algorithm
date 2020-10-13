package designPattern.decorator.one;

public class ItalicDecorator extends NodeDecorator {

  public ItalicDecorator(TextNode target){
    super(target);
  }


  public String getText() {
    return "<I>" + target.getText() + "</I>";
  }
}
