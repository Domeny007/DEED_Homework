import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Main {
     private static int answer;
     private static int rep;
     private static int risk;
     private static int time = 10;
    public static void main(String[] args) {

        playMeetingWithCustomerCase(rep,risk,time);
    }

    private static void playMeetingWithCustomerCase(int rep,int risk,int time) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Вы на встрече с заказчиком. " +
                "Вам необходимо договориться о стоимости проекта. " +
                "Бюджет заказчика = 100 рублей. " +
                "Но Вы рассчитали приблизительную стоимость, и она оказалась равна 200. " +
                "Данная сумма рассчитана с учетом возникновения возможных рисков.");
        System.out.println("Ваши действия?");
        System.out.println("1. Предложить сумму в 200 р.\n " +
                "2. Предложить сумму в 150р., поскольку для вас это выгодно \n" +
                "3. Согласиться на бюджет в 100р.");
        answer = sc.nextInt();
        if (answer == 1) {
            int a = 0;
            int b = 10;
            int random_number1 = a + (int) (Math.random() * b);
            if (random_number1 >=5) {
                rep = rep + 3;
                time = time - 1;
                System.out.println("rep: " + rep);
                System.out.println("time: " + time);
                playCommunicationWithTeamCase(time,risk,rep);
            } else {
                System.out.println("Вам не повезло, заказчик отказался, вы потеряли проект.\n GAME OVER");
                exit(0);
            }
        }
        if (answer == 2) {
            int a = 0;
            int b = 10;
            int random_number1 = a + (int) (Math.random() * b);
            if (random_number1 >=5) {
                rep += 1;
                time -= 1;
                risk += 2;
                System.out.println(rep);
                System.out.println(time);
                playCommunicationWithTeamCase(time,risk,rep);
            } else {
                System.out.println("Вам не повезло, заказчик отказался, вы потеряли проект.\n GAME OVER");
                exit(0);
            }
        }
        if (answer == 3) {
            rep = rep - 1;
            risk = risk + 2;
            time = time - 1;
            playCommunicationWithTeamCase(time,risk,rep);
        }
    }

    private static void playCommunicationWithTeamCase(int time,int risk,int rep) {
        Scanner sc = new Scanner(System.in);

        System.out.println("2. Вы понимаете, что успеваете реализовать проект раньше срока и у вас есть запас времени. " +
                "При этом у вас низкий уровень коммуникации с командой. " +
                "Есть возможность выехать вместе за город, чтобы отдохнуть и пообщаться.");
        System.out.println("Ваши действия?");
        System.out.println(" 1.Выехать за город для сплочения с командой \n" +
                " 2. Остаться работать");
        answer = sc.nextInt();
        if (answer == 1) {
            int a = 0;
            int b = 10;
            int random_number1 = a + (int) (Math.random() * b);
            if (random_number1 >=5) {
                System.out.println("Сплотиться удалось");
                rep = rep + 2;
                time = time - 2;
                risk = risk + 1;
                playDeveloperGetSickCase(time,risk,rep);

            } else {
                System.out.println("Сплотиться не удалось:(");
                rep = rep - 2;
                risk = risk + 2;
                time = time - 2;
                playDeveloperGetSickCase(time,risk,rep);
            }
        }
        if (answer == 2) {
            rep = rep - 1;
            risk = risk - 1;
            time = time - 1;
            System.out.println("risk: " + risk);
            System.out.println("rep: "+ rep);
            System.out.println("\n");
            playDeveloperGetSickCase(time,risk,rep);
        }
    }

    private static void playDeveloperGetSickCase(int time,int risk,int rep) {
        Scanner sc = new Scanner(System.in);

        System.out.println("3. В процессе разработки проекта ушел Senior разработчик. \n");
        System.out.println("Ваши действия?");
        System.out.println(" 1) Нанять нового сотрудника\n" +
                " 2) Повысить middle - разработчика. Без найма нового сотрудника ");
        answer = sc.nextInt();
        if (answer == 1) {
            risk = risk + 2;
            time = time - 2;
            playTroubleWithBetaCase(time,risk,rep);
        }
        if (answer == 2) {
            rep = rep + 2;
            risk = risk + 3;
            time = time - 1;
            playTroubleWithBetaCase(time,risk,rep);
        }
    }

    private static void playTroubleWithBetaCase(int time,int risk,int rep) {
        Scanner sc = new Scanner(System.in);

        System.out.println("4. Вы выкатили бета-версию проекта. " +
                "От пользователей поступило много жалоб. " +
                "Вы сообщили об этих проблемах команде, и каждый снимает с себя ответственность.");
        System.out.println("Ваши действия?");
        System.out.println(" 1) Наложить штраф за провал. -5р каждому.\n" +
                " 2) Уволить тестировщика за плохо проделанную работу.");
        answer = sc.nextInt();
        if (answer == 1) {
            rep = rep - 3;
            time = time - 1;
            risk = risk - 1;
            check(time,risk,rep);
        }
        if (answer == 2) {
            rep = rep - 2;
            risk = risk + 2;
            time = time - 1;
            check(time,risk,rep);
        }
    }
    
    //checking that parameters are good
    private static void check(int time,int risk,int rep) {
        if (rep >=0 && risk < 7 && time >= 5) {
            System.out.println("Вы победили. CONGRATS");
            exit(0);
        } else {
            System.out.println("Вы проиграли :(");
            System.out.println("Репутация: " + rep);
            System.out.println("Риски: " + risk);
            System.out.println("Время: " + time);
            exit(0);
        }
    }
}
