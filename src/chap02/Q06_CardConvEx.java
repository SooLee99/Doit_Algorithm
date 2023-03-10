package chap02;

import java.util.Scanner;

public class Q06_CardConvEx {
	//--- 정숫값 x를 r 진수로 변환하여 배열 d에 아랫자리부터 저장하고 자릿수를 반환 ---//
	static int cardConvEx(int x, int r, char[] d) {
		int digits = 0;											// 변환 후의 자릿수 => 진수 변환을 하기 위해 저장하는 변수.
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.println(r + " | " +  x);
		do {
			System.out.println("  +-----");

			// 몫이 0 이 아닐 경우.
			if (x / r != 0)	
				System.out.println(r + " | " + x / r + "    ... " + x % r);	// 진수, 몫, 나머지
			
			// 몫이 0 인 경우.
			else
				System.out.println("    " + x / r + "    ... " + x % r);		// 진수, 몫, 나머지
			
			d[digits++] = dchar.charAt(x % r);   // r 로 나눈 나머지를 저장
			x /= r;
			
		} while (x != 0);

		// 배열 d를 역순으로 정렬
		for (int i = 0; i < digits/ 2; i++) {   // d[0] ~ d[digits-1]
			char temp = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = temp;
		}
		
		return digits;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;										// 변환하는 정수
		int cd;										// 기수
		int dno;										// 변환 후의 자릿수
		int retry;									// 한 번 더?
		char[] cno = new char[32];	// 변환 후의 각자리를 저장할 문자 배열 

		System.out.println("10진수를 기수 변환합니다.");
		do {
			// 정수 입력
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = sc.nextInt();
			} while (no < 0);

			// 진수 입력
			do {
				System.out.print("어떤 진수로 변환할까요? (2-36) : ");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConvEx(no, cd, cno);		// no를 cd진수로 변환

			System.out.print(cd + "진수로는 ");
			// 진수 변환된 결과 값을 순서대로 출력
			for (int i = 0; i < dno; i++)			
				System.out.print(cno[i]);
			
			System.out.println("입니다.");

			System.out.print("한 번 더 할까요? (1 ... 예 / 0 ... 아니오) : ");
			retry = sc.nextInt();
		} while (retry == 1);
		sc.close();
	}
}

