package stack;

//使用栈的方式计算阶乘

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Factorial {

    public static Integer cal1(Integer n){
        if(n == 1){
            return 1;
        }else{
            return n * cal1(n-1);
        }
    }


    public static Integer cal2(Integer n){
        SqStack<FactorialNode> stack = new SqStack<>(FactorialNode.class);
        FactorialNode first = new FactorialNode(n, 0, 0);
        stack.push(first);
        while(!stack.isEmpty()){
            FactorialNode top = stack.top();
            if(top.getN() == 1 && top.getStatus() == 0){
                top.setResult(1);
                top.setStatus(1);
            }else if(top.getStatus() == 1){
                top = stack.pop();
                FactorialNode newTop = stack.top();
                newTop.setStatus(1);
                newTop.setResult(top.getResult() * newTop.getN());
            }else if(top.getStatus() == 0){
                FactorialNode node = new FactorialNode(top.getN() - 1, 0, 0);
                stack.push(node);
            }
            if(stack.len() ==1 && top.getStatus() ==1 ){
                break;
            }
        }

        return stack.top().getResult();
    }

    public static void main(String[] args){
        Integer cal12 = cal1(2);
        System.out.println(cal12);

        Integer cal13 = cal1(3);
        System.out.println(cal13);

        Integer cal21 = cal2(1);
        System.out.println(cal21);

        Integer cal22 = cal2(2);
        System.out.println(cal22);


        Integer cal23 = cal2(3);
        System.out.println(cal23);

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class FactorialNode {

    private     Integer     n;

    private     Integer     result;

    private     Integer     status;
}



