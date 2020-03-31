package stack;

/*
https://cloud.tencent.com/developer/article/1430934
https://www.cnblogs.com/fusiwei/p/11615499.html

后缀表达式，又称逆波兰表达式，

后缀表达式计算顺序是从左至右，具体过程如下：
从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 op 栈顶元素），并将结果入栈；
重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果。

后缀表达式打平了数学表达式（中缀表达式）的计算优先级，（）内优先级最高，乘除优先级次之，加减优先级最低。在后缀表达式中，操作符的出现顺序就是执行顺序。

中缀表达式转换为后缀表达式：
括号内的优先级最高：当有多个括号时，优先执行的是最先闭合的括号。 当 （ 出现时，（入栈， 当）出现时，操作符依次出栈，知道（为止。
乘除的优先级次之：当操作符是乘除时， 如果栈顶操作符是乘除，则栈顶操作符先出栈，然后当前操作符入栈。
加减的优先级最低：当操作符是加减时， 如果栈顶操作符是加减乘除，则栈顶操作符先出栈，然后当前操作符入栈。
 */

public class PostExpression {

    public static String transfer(String mathExpression){
        SqStack<Character> opStack  = new SqStack<>(Character.class);
        validateMathExpression(mathExpression);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < mathExpression.length()){
            char ch = mathExpression.charAt(i);
            if(Character.isDigit(ch)){
                while (Character.isDigit(ch) && i < mathExpression.length()){
                    sb.append(ch);
                    i++;
                    if(i < mathExpression.length()){
                        ch = mathExpression.charAt(i);
                    }

                }
                sb.append('#');
            }else{
                i++;
                if(Character.isWhitespace(ch)){
                    continue;
                }
                if(ch == '('){
                    opStack.push(ch);
                }else if(ch == ')'){
                    while(!opStack.isEmpty() && opStack.top() != '('){
                        sb.append(opStack.top());
                        opStack.pop();

                    }
                    opStack.pop();
                }else if(ch == '+' || ch == '-'){
                    while(!opStack.isEmpty() && (opStack.top() == '+' || opStack.top() == '-'
                            || opStack.top() == '*' || opStack.top() == '/')){
                        sb.append(opStack.top());
                        opStack.pop();
                    }
                    opStack.push(ch);
                }else if(ch == '*' || ch == '/'){
                    while(!opStack.isEmpty() && (opStack.top() == '*' || opStack.top() == '/')){
                        sb.append(opStack.top());
                        opStack.pop();
                    }
                    opStack.push(ch);
                }else{
                    continue;
                }
            }

        }

        while (!opStack.isEmpty()){
            sb.append(opStack.pop());
        }
        return sb.toString();
    }

    public static void validateMathExpression(String mathExpression){


    }

    public static Integer execute(String postExp){
        SqStack<Integer> numberStack  = new SqStack<>(Integer.class);
        int i = 0;
        while (i < postExp.length()){
            if(Character.isDigit(postExp.charAt(i))){
                StringBuilder sb = new StringBuilder();
                while (i < postExp.length() && Character.isDigit(postExp.charAt(i))){
                    char ch = postExp.charAt(i);
                    sb.append(ch);
                    i++;
                }
                Integer param = Integer.parseInt(sb.toString());
                numberStack.push(param);
            }else if(postExp.charAt(i) == '#'){
                i++;
                continue;
            }else{
                Integer top1 = numberStack.pop();
                Integer top2 = numberStack.pop();
                if(postExp.charAt(i) == '+'){
                    numberStack.push(top2 + top1);
                }else if(postExp.charAt(i) == '-'){
                    numberStack.push(top2 - top1);
                }else if(postExp.charAt(i) == '*'){
                    numberStack.push(top2 * top1);
                }else if(postExp.charAt(i) == '/'){
                    numberStack.push(top2 / top1);
                }
                i++;
            }
        }
        return numberStack.pop();
    }


    public static void main(String[] args){

        try{
            String mathExp1 = "11+12*13";
            String postExp1 = transfer(mathExp1);
            System.out.println(postExp1);
            Integer sum1 = execute(postExp1);
            System.out.println(sum1);

            String mathExp2 = "11+(12+13+14*15)-16";
            String postExp2 = transfer(mathExp2);
            System.out.println(postExp2);
            Integer sum2 = execute(postExp2);
            System.out.println(sum2);

            String mathExp3 = "11+12+13-14+15-16*17";
            String postExp3 = transfer(mathExp3);
            System.out.println(postExp3);
            Integer sum3 = execute(postExp3);
            System.out.println(sum3);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
