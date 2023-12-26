import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();
    MonthData monthData = new MonthData();

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int month = scanner.nextInt();
        if (month <= 0 && month >= 13) {
            System.out.println("Ошибка! Введите номер месяца снова!");
            return;
        } else {
            System.out.println("Введите день от 1 до 30 (включительно)");
        }

        int day = scanner.nextInt();
        if (day <= 0 && day >= 31) {
            System.out.println("Ошибка! Введите номер дня снова!");
            return;
        } else {
            System.out.println("Введите количество шагов");
        }

        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Ошибка! Введите количество шагов снова!");
            return;
        } else {
            System.out.println("Ваши значения сохранены!");
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        int changeGoal = scanner.nextInt();
        if (changeGoal <= 0) {
            System.out.println("Неверное значение, введите повторно!");
        } else {
            goalByStepsPerDay = changeGoal;
            System.out.println("Ваша цель сохранена!");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();

        if (month <= 0 || month >= 13) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Вот статистика за " + month + " месяц:");
        }

        monthData = monthToData[month - 1];
        int SumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("За этот месяц вы прошли " + SumSteps + " шагов");
        int maxSteps = monthData.maxSteps();
        System.out.println("Максимально пройденное количество шагов за месяц составило " + maxSteps);
        int sum = converter.convertToKm(SumSteps);
        System.out.println("За этот месяц вы прошли " + sum + " километров");
        int answer = converter.convertStepsToKilocalories(SumSteps);
        System.out.println("За этот месяц вы сожгли " + answer + " килокалорий");
        int finalSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия шагов за месяц");
        System.out.println(finalSeries);
        System.out.println();

    }
}
