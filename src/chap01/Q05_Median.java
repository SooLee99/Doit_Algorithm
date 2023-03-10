package chap01;
// 3개의 정숫값을 입력하고 중앙값을 구하여 출력

import java.util.Scanner;

class Q05_Median {
    static int med3(int a, int b, int c) {
        /*if (a >= b)
            if (b >= c)
                return b;
            else if (c >= a)
                return a;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
        */
    	// 위 코드의 경우의 수는 13가지이다.
    	
    	if((b >= a && a >= c) || (a >= b && c >= a))	// "b >= a >= c" : 경우의 수 4개?	// "c >= a >= b" : 경우의 수 3개 인데, 중복 포함 4개
    		return a;									// (중복의 경우의 수도 포함됨.) => 8개?
    	else if((a > b && c < b) || (a < b && c > b))	// "a > b > c" : 1개				// "c > b > a" : 1개
    		return b;									// (중복의 경우의 수도 포함됨.) => 2개?
    	return c;										// 
    	
    	/* <위의 코드보다 효율이 떨어지는 이유>
    	 * 처음 if 문의 판단
    	 * 		if ((b >= a && c<= a) || (b <= a && c >= a)
    	 * 에 주목합니다.
    	 *  
    	 * 여기서 b >= a 및 b <= a의 판단을 뒤집은 판단
    	 * (실질적으로 동일한 판단)이, 계속하여  else 이후에서
    	 * 		else if ((a > b && c < b) || (b <= a && c > b)로 수행됩니다. 
    	 * 
    	 * 즉, 처음 if가 성립하지 않는 경우,
    	 * 2번째 if에서도 (실질적으로) 같은 판단을 수행하므로,
    	 * 효율이 나빠집니다.
    	 * 
    	 * + 암튼 중복의 경우의 수도 포함하기 때문에 if문이 돌아가는 횟수가 더 많아지는 듯
    	*/
    	
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a 값 : ");  
        int a = sc.nextInt();
        System.out.print("b 값 : ");  
        int b = sc.nextInt();
        System.out.print("c 값 : ");  
        int c = sc.nextInt();
        sc.close();

        System.out.println("중앙값은 " + med3(a, b, c) + "입니다.");
    }
}