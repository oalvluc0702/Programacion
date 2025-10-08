import java.util.Scanner;

public class ejercicio9 {
    public static void  main(String[] args){
        Scanner s= new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length ; i++) {
            System.out.println("Dime un número entero por pantalla:");
            nums[i] = s.nextInt();
        }
        int max = nums[0];
        int min = nums[0];
        int numPos = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > max){
              max=nums[j];
              numPos=j+1;
            }
        }
        System.out.println("max = "+max+"pos = "+numPos);
        numPos=0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < min){
                min=nums[k];
                numPos=k+2;
            }
        }
        System.out.println("min = "+min+"pos = "+numPos);
    }
}
