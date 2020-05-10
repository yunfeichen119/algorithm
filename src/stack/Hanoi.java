package stack;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Hanoi {

    public static void recursion(Integer n, Character x, Character y, Character z){
        if(n == 1){
            move(n, x, z);
        }else{
            recursion(n-1, x, z, y);
            move(n, x, z);
            recursion(n-1, y, x, z);
        }
    }


    public static void move(Integer n, Character from, Character to){
        System.out.printf("number:%d, form:%c, to:%c\n", n, from, to);
    }


    public static void simulate(Integer n, Character x, Character y, Character z){
        SqStack<HanoiNode> stack = new SqStack<>(HanoiNode.class);
        HanoiNode first = new HanoiNode(n, x, y, z, 0);
        stack.push(first);
        while (!stack.isEmpty()){
            HanoiNode top = stack.top();
            if(top.getStatus() == 0){
                if(top.getNumber() ==1){
                    top.setStatus(1);
                }else{
                    stack.pop();
                    Integer newNumber = top.getNumber();
                    Character newX = top.getFrom();
                    Character newY = top.getBy();
                    Character newZ = top.getTo();
                    HanoiNode node1 = new HanoiNode(newNumber -1, newY, newX, newZ, 0);
                    HanoiNode node2 = new HanoiNode(newNumber, newX, null, newZ, 1);
                    HanoiNode node3 = new HanoiNode(newNumber -1, newX, newZ, newY, 0);
                    stack.push(node1);
                    stack.push(node2);
                    stack.push(node3);
                }

            }else{
                move(top.getNumber(), top.getFrom(), top.getTo());
                stack.pop();
            }
        }

    }



    public static void main(String[] args){
        recursion(3, 'x', 'y', 'z');
        System.out.println("=========================");
        simulate(3, 'x', 'y', 'z');

    }
}

@Data
@AllArgsConstructor
class HanoiNode {
    private Integer     number;
    private Character   from;
    private Character   by;
    private Character   to;
    private Integer     status;
}
