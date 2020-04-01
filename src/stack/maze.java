package stack;

public class maze {

    public static void path(int[][] maze, int x1, int y1, int x2, int y2){
        SqStack<Move> stack = new SqStack<Move>(Move.class);
        int nx = x1, ny=y1;
        maze[nx][ny] = -1;
        Move move = new Move(nx, ny, 0);
        stack.push(move);
        nx = nx -1;
        while(!(nx == x2 && ny == y2)){
            if(maze[nx][ny] != 0){
                Move top = stack.pop();
                if(top.getDirection() < 3){
                    top.setDirection(top.getDirection()+1);
                }else{

                }
            }else{
                Move step = new Move(nx, ny, 0);
                stack.push(move);
                maze[nx][ny] = -1;
                nx = nx -1;
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

        path(maze, 1, 1,8,8);

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
