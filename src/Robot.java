public class Robot {
    private int x,y, direction;
    int[][] matrix;
    private int stepCounter=0;

    public Robot(){//конструктор без праметров, т.е. default constructor
        x = 50;
        y = 50;
        direction = 0;
        matrix = null;
    }

    public Robot(int x0, int y0, int direction, int[][] matrix) {
        this.matrix = matrix;
        setXY(x0, y0);
        this.direction = direction;

    }

    public int getDirection(){
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int newX, int newY) {
        if(matrix == null ||
                x>=0 && y>=0 && y < matrix.length && x < matrix[0].length){
            x = newX;
            y = newY;
            if (matrix != null)
                matrix[x][y]++;
        }
    }

    public void setDirection(int direction) {
        if(direction == 360)
            direction = 0;
        if (direction == -90)
            direction = 270;
        if (direction == 0   || direction == 90  || direction == 180 || direction == 270)
            this.direction = direction;
    }

    protected void turnRight(){
        setDirection( direction+90);
    }
    protected void turnLeft(){
        setDirection( direction-90);
    }

    public int getStepCounter() {
        return stepCounter;
    }

    protected void stepForward()
    {
        stepCounter++;
        switch (direction) {
            case   0: setXY(x,  y+1); break;
            case  90: setXY(x+1,  y); break;
            case 180: setXY(x,  y-1); break;
            case 270: setXY(x-1,  y); break;
        }

    }

    public void executeCommand(char cmd)
    {
        switch (cmd){
            case 'S': stepForward(); break;
            case 'R': turnRight();   break;
            case 'L': turnLeft();    break;
        }
    }
}
