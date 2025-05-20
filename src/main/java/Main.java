import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int autoSpeed = -1;
        String autoName = "";
        String finalWinner = "";
        Auto[] autoList = new Auto[3];
        System.out.println("Welcome to Le-Mans 24");
        for (int i = 0; i < autoList.length;i++) {
            System.out.println("Введите название автомобиля #" + (i + 1) + ":");
            autoName = scanner.next();

            while (true){
                System.out.println("Укажите скорость автомобиля #" + (i + 1) + ": ");
                autoSpeed = scanner.nextInt();
                if (autoSpeed >0 && autoSpeed <=250){
                    break;
                }
            }
            autoList[i] = new Auto(autoName,autoSpeed);
            Race raceCls = new Race();
            finalWinner = raceCls.setRaceWinner(autoName,autoSpeed);
        }
        /*for (int i=0; i <3; i++){
            System.out.println("Атомобиль "+autoList[i].name +" движется со скоростью "+ autoList[i].speed +" км/ч");
        }
         */
        System.out.println("Самый быстрый автомобиль: "+finalWinner);
    }

}
class Auto {
    String name;
    int speed;
    public Auto(String autoName,int autoSpeed) {
        this.name = autoName;
        this.speed = autoSpeed;
    }
}
class Race{
    String winner="";
    int pathLength = 0;

    public String setRaceWinner(String name, int speed){
        if (winner.equals("")){
            pathLength = 24 * speed;
            winner = name;
        } else {
            int newPathLeng = 24 * speed;
            if (newPathLeng>pathLength){
                pathLength = newPathLeng;
                winner = name;
            }
        }
        return winner;
    }
}
