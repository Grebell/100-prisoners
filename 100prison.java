import java.util.Random;
public class 100prison {

    public static void main(String[] args) {
        int wintotal = 0;
        int totalboxes = 0;
        String input = args[0];
        int boxtosearch = Integer.parseInt(args[1]);
        input = input.toLowerCase();
        for (int k = 0;k < 1000;k++) {
            int[] boxes = new int[100];
            boolean[] deduplicator = new boolean[100];
            Random rand = new Random();
            for (int i = 0; i<100 ;i++) {
                int number = rand.nextInt(100);
                if (deduplicator[number] == false) {
                    boxes[i] = number;
                    deduplicator[number] = true;
                }else {
                    i--;
                }

            }
            //my oh my, i have 100 boxes!
            int win = 0;
            if (input.equals("random")) {
                for(int j = 0; j<100;j++) {
                    boolean[] deduplicator2 = new boolean[100];
                    for (int l = 1; l <= boxtosearch; l++) {
                        totalboxes++;
                        int guess;
                        while (true) {
                            guess = rand.nextInt(100);
                            if (deduplicator2[guess] == false) {
                                deduplicator2[guess] = true;
                                break;
                            }
                        }
                        if (boxes[guess] == j) {
                            win++;
                            break;//you did it
                        }
                    }
                }
            }
            if (input.equals("logical")) {
                for (int m = 0; m < 100; m++) {
                    int guess = m;
                    int boxeschecked = 0;
                    while (boxeschecked < boxtosearch) {
                        totalboxes++;
                        boxeschecked++;
                        if (boxes[guess] == m) {
                            win++;
                            break;
                        }
                        else {
                            guess = boxes[guess];
                        }
                    }
                    if (boxeschecked >= boxtosearch) {
                    }
                }
            }
            if (win == 100){
                wintotal++;
            }
        }
        System.out.println(input + " strategy");
        System.out.println("total boxes searched: " + totalboxes);
        System.out.println((float)wintotal/10 + "% winrate");
        System.out.println(100 - (float)wintotal/10 + "% failrate");
    }
}