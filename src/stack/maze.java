package stack;

public class maze {

    public static void path(Integer[][] maze, Integer x1, Integer y1, Integer x2, Integer y2){

    }


    public static void main(String[] args){
        Integer[][] maze = {
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
}
