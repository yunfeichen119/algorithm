package designPattern.visitor.one;

import java.io.File;

public class Test {

  public static void main(String[] args) {

    FileStructure fileStructure = new FileStructure(new File("/Users/didi/code/github/algorithm"));

    fileStructure.handle(new JavaFileVisitor());

  }
}
