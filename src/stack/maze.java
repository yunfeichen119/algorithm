package stack;

public class maze {

    public static void path(int[][] maze, int x1, int y1, int x2, int y2){
        SqStack<Move> stack = new SqStack<Move>(Move.class);
        int x =0 ,y =0 ,direction = -1;
        boolean find;
        stack.push(new Move(x1, y1, -1));
        maze[x1][y1] = -1;
        while (!stack.isEmpty()){
            Move top = stack.top();
            if(top.getX() == x2 && top.getY() == y2){
                for(int k = 0; k < stack.len(); k++){
                    Move move = stack.index(k);
                    System.out.printf("move x:%d, y:%d, direction:%d\n", move.getX(), move.getY(), move.getDirection());
                }
                return;
            }
            find = false;
            direction = top.getDirection();
            while(direction < 3 && !find){
                direction++;
                switch (direction){
                    case 0:
                        x = top.getX()-1;
                        y = top.getY();
                        direction = 0;
                        break;
                    case 1:
                        x = top.getX();
                        y = top.getY()+1;
                        direction = 1;
                        break;
                    case 2:
                        x = top.getX()+1;
                        y = top.getY();
                        direction = 2;
                        break;
                    default:
                        x = top.getX();
                        y = top.getY()-1;
                        direction = 3;
                        break;
                }
                if(maze[x][y] == 0){
                    find = true;
                }
            }

            if(find){
                top.setDirection(direction);
                maze[x][y] = -1;
                stack.push(new Move(x, y, -1));
            }else{
                maze[top.getX()][top.getY()] = 1;
                stack.pop();
            }
        }
    }


    public static void main(String[] args){
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        path(maze, 1, 1,2,4);

        //path(maze, 1, 1,8,8);

    }


    public static class Move{
        int     x;
        int     y;
        int     direction;//0：上方 1：右方 2：下方 3：左方

        public Move(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }
}
