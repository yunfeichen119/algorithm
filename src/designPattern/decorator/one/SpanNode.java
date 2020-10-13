package designPattern.decorator.one;

public class SpanNode implements TextNode {

  private String  text;

  public void setText(String text){
    this.text = text;
  }

  public String getText(){
    return "<span>" + text + "</span>";
  }
}
