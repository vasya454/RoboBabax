import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String proga = scanner.nextLine(); // читаем файл
        int l = proga.length();
        char[] cmdArray = proga.toCharArray();
        int n = 1001;
        int[][] matrix = new int[n][n]; // создаем матрицу;
        int result = -1;
        // задать координаты;
        Robot rob = new Robot(n/2, n/2, 0, matrix);

        // запускаем робота;
        for (char cmd : cmdArray) {
            rob.executeCommand(cmd);
            if ( matrix[ rob.getX() ][ rob.getY() ] > 1) {
                result = rob.getStepCounter();
                break;
            }
        }

        Scanner roboScanner = new Scanner(new File("RobotsAndHisProgs.txt"));
        int countOfRobots = 2;
        Robot[] robots = new Robot[countOfRobots];
        String[] progs = new String[countOfRobots];
        for (int i = 0; i < countOfRobots; i++) {
            robots[i] = new Robot (roboScanner.nextInt(),roboScanner.nextInt(),roboScanner.nextInt(),matrix);
            roboScanner.nextLine();
            progs[i] = roboScanner.nextLine();
        }
        roboScanner.close();

        for (int i = 0; i < Math.max(progs[0].toCharArray().length,progs[1].toCharArray().length); i++) {
            if (robots[0].getX() == robots[1].getX() && robots[0].getY() == robots[1].getY()) { //если бабах до начала движения
                System.out.println("Бабах");
                break;
            }
            if (i<progs[0].toCharArray().length) {
                robots[0].executeCommand(progs[0].toCharArray()[i]);
            }
            if (i<progs[1].toCharArray().length) {
                robots[1].executeCommand(progs[1].toCharArray()[i]);
            }
            if (robots[0].getX() == robots[1].getX() && robots[0].getY() == robots[1].getY()) {
                System.out.println("Бабах");
                break;
            }
        }


        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(Integer.toString(result));
        fileWriter.close();

    }
}


