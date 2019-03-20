import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Main {
     private static int answer;
     private static int rep;
     private static int risk;
     private static int time = 10;

     private static int min = 1;
     private static int max = 10;
    private static Random random = new Random();

    public static void main(String[] args) {
        playMeetingWithCustomerCase();
    }

    private static void playMeetingWithCustomerCase() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Вы на встрече с заказчиком. " +
                "Вам необходимо договориться о стоимости проекта.\n" +
                "Бюджет заказчика = 100 рублей. \n" +
                "Но Вы рассчитали приблизительную стоимость, и она оказалась равна 200.\n" +
                "Данная сумма рассчитана с учетом возникновения возможных рисков.");
        System.out.println("Ваши действия?");
        System.out.println("1. Предложить сумму в 200 р.\n" +
                "2. Предложить сумму в 150р., поскольку для вас это выгодно \n" +
                "3. Согласиться на бюджет в 100р.");
        answer = sc.nextInt();
        if (answer == 1) {
            if (getRandomBool()) {
                rep = rep + 3;
                time = time - 1;
                showParams();
                playCommunicationWithTeamCase();
            } else {
                System.out.println("Вам не повезло, заказчик отказался, вы потеряли проект.\n GAME OVER");
                exit(0);
            }
        }
        if (answer == 2) {
            if (getRandomBool() && getRandomBool()) {
                rep += 1;
                time -= 1;
                risk += 2;
                showParams();
                playCommunicationWithTeamCase();
            } else {
                System.out.println("Вам не повезло, заказчик отказался, вы потеряли проект.\n GAME OVER");
                exit(0);
            }
        }
        if (answer == 3) {
            rep = rep - 1;
            risk = risk + 2;
            time = time - 1;
            showParams();
            playCommunicationWithTeamCase();
        }
    }

    private static void playCommunicationWithTeamCase() {
        Scanner sc = new Scanner(System.in);

        System.out.println("2. Вы понимаете, что успеваете реализовать проект раньше срока и у вас есть запас времени.\n" +
                "При этом у вас низкий уровень коммуникации с командой.\n" +
                "Есть возможность выехать вместе за город, чтобы отдохнуть и пообщаться.");
        System.out.println("Ваши действия?");
        System.out.println(" 1.Выехать за город для сплочения с командой \n" +
                " 2. Остаться работать");
        answer = sc.nextInt();
        if (answer == 1) {
            if (getRandomBool()) {
                System.out.println("Сплотиться удалось");
                rep = rep + 2;
                time = time - 2;
                risk = risk + 1;
                showParams();
                playDeveloperGetSickCase();

            } else {
                System.out.println("Сплотиться не удалось.Все переругались :(");
                rep = rep - 2;
                risk = risk + 2;
                time = time - 2;
                showParams();
                playDeveloperGetSickCase();
            }
        }
        if (answer == 2) {
            rep = rep - 1;
            risk = risk - 1;
            time = time - 1;
            showParams();
            playDeveloperGetSickCase();
        }
    }

    private static void playDeveloperGetSickCase() {
        Scanner sc = new Scanner(System.in);

        System.out.println("3. В процессе разработки проекта ушел Senior разработчик.\n");
        System.out.println("Ваши действия?");
        System.out.println(" 1) Нанять нового сотрудника\n" +
                " 2) Повысить middle - разработчика. Без найма нового сотрудника ");
        answer = sc.nextInt();
        if (answer == 1) {
            risk = risk + 2;
            time = time - 2;
            showParams();
            playTroubleWithBetaCase();
        }
        if (answer == 2) {
            rep = rep + 2;
            risk = risk + 3;
            time = time - 1;
            showParams();
            playTroubleWithBetaCase();
        }
    }

    private static void playTroubleWithBetaCase() {
        Scanner sc = new Scanner(System.in);

        System.out.println("4. Вы выкатили бета-версию проекта.\n" +
                "От пользователей поступило много жалоб.\n" +
                "Вы сообщили об этих проблемах команде, и каждый снимает с себя ответственность.");
        System.out.println("Ваши действия?");
        System.out.println(" 1) Наложить штраф за провал. -5р каждому.\n" +
                " 2) Уволить тестировщика за плохо проделанную работу.");
        answer = sc.nextInt();
        if (answer == 1) {
            rep = rep - 3;
            time = time - 1;
            risk = risk - 1;
            showParams();
            check();
        }
        if (answer == 2) {
            rep = rep - 2;
            risk = risk + 2;
            time = time - 1;
            showParams();
            check();
        }
    }
    
    //checking that parameters are good
    private static void check() {
        if (rep >=0 && risk < 7 && time >= 5) {
            System.out.println("Вы победили. CONGRATS");
            exit(0);
        } else {
            System.out.println("Вы проиграли :(");
            exit(0);
        }
    }

    private static void showParams() {
        System.out.println("Риски: " + risk);
        System.out.println("Репутация: "+ rep);
        System.out.println("Время: "+ time);
    }

    private static int getRandom() {
        return random.nextInt(max - min + 1) + min;
    }

    private static boolean getRandomBool() {
        return random.nextBoolean();
    }
}
