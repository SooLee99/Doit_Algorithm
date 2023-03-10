package chap01;
// 1-3. 입력한 정숫값의 부호(양수/음수/0)를 판단

/* (1) 입력 : n
 * (2) 양수 : n > 0
 * (3) 음수 : n < 0
 * (4) 나머지
 */

import java.util.Scanner;

class Ex03_JudgeSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int n = sc.nextInt();
        sc.close();
        
        if (n > 0)
            System.out.println("이 수는 양수입니다.");
        else if (n < 0)
            System.out.println("이 수는 음수입니다.");
        else
            System.out.println("이 수는 0입니다.");
    }
}