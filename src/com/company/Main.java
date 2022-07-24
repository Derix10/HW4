package com.company;


import java.util.Random;

public class Main {
    public static String[] heroesAttack = {"Physical", "Magical", "Kinetic", "Golem", "Lucky" , "Medical"};
    public static int[] heroHeath = {50, 80, 90, 550, 70, 320};
    public static int[] heroesDamage = {20, 15, 25, 5, 10, 0};
    public static Random r = new Random();
    public static int random = r.nextInt(5); //0,1,2,3,4

    public static int getMedicHealth = 50;

    public static int bossHeath = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";

    public static int roundNum = 0;


    public static void main(String[] args) {

        printStatics();
        while (!isGameFinished()) {
            round();
        }
    }

    public static void round() {
        roundNum++;
        chooseDefenceType();
        bossHits();
        heroesHits();
        // heal();
        medical();
        printStatics();

    }

    public static Boolean isGameFinished() {
        System.out.println("---------");
        if (bossHeath <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDead = true;

        for (int i = 0; i < heroHeath.length; i++) {
            if (heroHeath[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }
        /*if (heroHeath[0] <= 0 && heroHeath[1] <= 0 && heroHeath[2] <= 0) {

            System.out.println("Boss won!");
            return true;
        }
        return false;

    }
       public static void heal() {
        int low = 0;
        int ran = ;
        if (heroHeath[l] <= 100 && heroHeath[random] >= 0) {
            if (heroHeath[5] > 0) {
                for (int k : heroHeath) {
                    for (int j = 0; j < heroHeath.length; j++) {
                        if (k > heroHeath[j]) {
                            low = j;
                        }
                    }
                }
            }
        }
    }



*/


    private static void medical() {
            if (heroHeath[random] < 100 && heroHeath[random] > 0) { // Основа ДЗ:
                if (heroHeath[5] > 0) {
                    System.out.println("++++++++++++");
                    System.out.println("Медик выбрал: " + heroesAttack[random]);
                    System.out.println("Жизнь героя,если бы ударил босс = " + heroHeath[random]);
                    heroHeath[random] += getMedicHealth;
                    System.out.println("Медик применил суперспособность " + heroHeath[random]); // Пополнение здоровья на 50
                    System.out.println("++++++++++++");
                }
            }
        }




    private static void bossHits() {
        boolean ran = r.nextBoolean(); // Доп.задание: Golem and Lucky
        int NewBossAttack = bossDamage / 1/5;// Разделяем атаку босс на 1/5 для команды
        if (heroesAttack[4] == "Lucky"){
            if(ran == true) {
                heroHeath[4] = heroHeath[4] + NewBossAttack; // Уклонение от ударов если true, а если false то Lucky получает урон
            }
        }
        int BossGolemAttack = bossDamage - NewBossAttack; // Это урон Golem от Босса
        if(heroesAttack[3] == "Golem"){
            heroHeath[3] = (heroHeath[3] - BossGolemAttack) + NewBossAttack; // Golem -40
        }

        for (int i = 0; i < heroesAttack.length; i++){
            if (heroHeath[i] < bossDamage) {
                heroHeath[i] = 0;
            }
            else {
                heroHeath[i] = heroHeath[i] - NewBossAttack;
             }
            }
        }


    private static void heroesHits() {
        for (int i = 0; i < heroesDamage.length; i++) {

            if (bossHeath > 0 && heroHeath[i] > 0) {
                if (bossDefenceType.equals(heroesAttack[i])) {
                    Random r = new Random();
                    int coef = r.nextInt(6)+2  ;

                    if (bossHeath < heroesDamage[i] * coef) {
                        bossHeath = 0;

                    } else {
                        bossHeath = bossHeath - heroesDamage[i] * coef;

                    }
                    System.out.println("Critical damage: " + heroesDamage[i] * coef);
                } else {
                    if (bossHeath <= heroesDamage[i]) {
                        bossHeath = 0;
                    } else {
                        bossHeath = bossHeath - heroesDamage[i];
                    }

                }
            }
        }
    }
    private static void printStatics() {
        System.out.println("=============");
        System.out.println("******** " + roundNum + " ROUND ******");
        System.out.println("==============");
        System.out.println("Boss Health: " + bossHeath + " [" + bossDamage + "] ");

        for (int i = 0; i < heroHeath.length; i++) {
            System.out.println("Hero " + heroesAttack[i] + ", Health: " + heroHeath[i] + " [" + heroesDamage[i] + "] ");
        }
    }

    public static void chooseDefenceType() {
        Random random = new Random();
        int randomIndex = random.nextInt(4);  // 0,1,2
        bossDefenceType = heroesAttack[randomIndex];
        System.out.println("Boss choose: " + bossDefenceType);
    }
}




