package j01_출력;

import java.util.Scanner;
public class HelloJava {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int cnt = 0;
       int n = sc.nextInt();
        int[] arr = new int[n]; //크기가n인 배열 선언 및 할당
       for(int i = 0; i<arr.length; i++){ // 0~ 배열의 길이 만큼 반복
           arr[i] = sc.nextInt();   //4 6 3 8 2 1 10   -> 4 6 8 2 10
           if(arr[i] % 2 ==0){                   //index  0 1 2 3 4
               cnt++;
               //System.out.print(arr[i]+" ");
               for(int j = cnt-1; j>=0; j++){
                   System.out.print(arr[j]+" ");
               }
           }
            // System.out.print(cnt); //5
//           for(int j = cnt-1; j>=0; j++){
//               System.out.print(arr[j]+" ");
//           }
        }

    }
}







