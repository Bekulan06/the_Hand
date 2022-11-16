import java.util.Random;

public class Main {
    public static int DioHealth = 800;
    public static int DioDamage = 65;
    public static String DioDefenceType;
    public static int[] JoestarsHealth = {310, 330, 330, 400};
    public static int[] JoestarsDamage = {40, 35, 70, 0};
    public static String[] JoestarsAttackTypes = {"Physical","Hamon","Stand", "Healing"};
    public static String[] Jojo = {"Jonathan", "Joseph", "Jotaro", "Josuke"};
    public static int roundNum;
    public static void main(String[] args) {
        Statistics();
        while (!GameOver()){
            rounds();

        }

    }
    public static void chooseDioDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(JoestarsAttackTypes.length);
        DioDefenceType = JoestarsAttackTypes[randomIndex];
    }
    public static void rounds(){
        roundNum++;

        chooseDioDefence();
        dioHits();
        joestarsHit();
        Statistics();

    }
    public static void dioHits(){
        for (int i = 0; i < JoestarsHealth.length; i++) {
            if (JoestarsHealth[i] > 0){
                if (JoestarsHealth[i] - DioDamage < 0){
                    JoestarsHealth[i] = 0;
                } else {
                    JoestarsHealth[i] = JoestarsHealth[i] - DioDamage;
                }
            }

        }
        JoestarsHealing();
    } 
    public static void JoestarsHealing(){
        for (int i = 0; i < JoestarsHealth.length; i++) {
            int healing = 50;
            if (JoestarsHealth[3] == 0){
                break;
            } else if (DioDefenceType=="Healing") {
                break;
            } else if (JoestarsHealth[i] > 100) {
                continue;
            } else if (JoestarsHealth[i] < 100 && JoestarsHealth[i]!=JoestarsHealth[3]) {
                JoestarsHealth[i]+= healing;
                break;
            }

        } 



        
    }
    public static void joestarsHit(){
        Random random = new Random(2);
        for (int i = 0; i < JoestarsAttackTypes.length; i++) {
            if (JoestarsHealth[i] > 0 && DioHealth > 0 ) {

                int damage = JoestarsDamage[i];
                if (DioDefenceType == JoestarsAttackTypes[i]){
                    Random ra = new Random();
                    int coff = random.nextInt(2); // 2, 3, 4, 5, 6, 7, 8, 9, 10,
                    damage = JoestarsDamage[i] * coff;
                    System.out.println("Critical damage: " + damage);
                }
                if (DioHealth - damage < 0){
                    DioHealth = 0;
                } else
                    DioHealth = DioHealth - damage;

            }
            }
            
        }

   
    public static void Statistics(){
        System.out.println("ROUND " + roundNum + " --------------");
        System.out.println("Dio Health: " + DioHealth + " Damage: " + DioDamage+
                "\nhealing: 50"+
                "\nDefend Type: "+ DioDefenceType);
        for (int i = 0; i < JoestarsHealth.length; i++) {
            System.out.println(Jojo[i] + " health: "
                    + JoestarsHealth[i] + " damage: " + JoestarsDamage[i]);
        }

    }
    public static boolean GameOver(){
        if (DioHealth <= 0){
            System.out.println("Joestars won!");
            return true;
        }
        boolean allJojoDead = true;
        for (int i = 0; i < JoestarsHealth.length; i++) {
            if (JoestarsHealth[i] > 0){
                allJojoDead = false;
                break;
            }
        }
        if (allJojoDead){
            System.out.println("Dio won!");
        }
        return allJojoDead;

    }


}