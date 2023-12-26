import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите нужный Вам пункт");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        while(true) {
            printMenu();
            int input = scanner.nextInt();
            if (input == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (input == 2) {
                stepTracker.changeStepGoal();
            } else if (input == 3) {
                stepTracker.printStatistic();
            } else if (input == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }

        }
    public static void printMenu() {
        System.out.println("1. Добавить количество шагов за определённый день\n2. Изменить цель по количеству шагов");
        System.out.println("3. Напечатать статистику за определённый месяц\n4. Выйти из приложения");
    }

}