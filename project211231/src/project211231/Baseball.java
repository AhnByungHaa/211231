package project211231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baseball {

	public static int creatNum() throws IOException {
		int x, y, z;
		x = (int) (Math.floor(Math.random() * 9 + 1));

		do {
			y = (int) (Math.floor(Math.random() * 9 + 1));
		} while (x == y);

		do {
			z = (int) (Math.floor(Math.random() * 9 + 1));
		} while (z == y || z == x);

		return playGame(x, y, z);
	}

	public static int playGame(int x, int y, int z) throws IOException {
		int count=0;
		int ball;
		int strike;
		int[] userNum = new int[3];
		int[] comNum = {x,y,z};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			count++;
			do{ 
				System.out.println("카운트 : " + count);
				System.out.print("첫번째 숫자 : ");
				String str = br.readLine();
				userNum[0]=Integer.parseInt(str);

				System.out.print("두번째 숫자 : ");
				str=br.readLine();
				userNum[1]=Integer.parseInt(str);
				System.out.print("세번째 숫자 : ");
				str=br.readLine();
				userNum[2]=Integer.parseInt(str);

				if (userNum[0] == 0 || userNum[1] == 0 || userNum[2] == 0 || userNum[0] > 9 || userNum[1] > 9
						|| userNum[2] > 9 || userNum[0] == userNum[1] || userNum[0] == userNum[2]
								|| userNum[1] == userNum[2]) {
					System.out.println("입력숫자오류. 다른숫자를 입력해주세요.");
				}
			}while (userNum[0] == 0 || userNum[1] == 0 || userNum[2] == 0 || userNum[0] > 9 || userNum[1] > 9
					|| userNum[2] > 9 || userNum[0] == userNum[1] || userNum[0] == userNum[2]
							|| userNum[1] == userNum[2]);
			//숫자를 입력받는 부분

			strike = ball = 0;

			if(userNum[0]==comNum[0]) {
				strike++;
			}
			else if(userNum[0]==comNum[1]||userNum[0]==comNum[2]) {
				ball++;
			}

			if(userNum[1]==comNum[1]) {
				strike++;
			}
			else if(userNum[1]==comNum[0]||userNum[1]==comNum[2]) {
				ball++;
			}
			if(userNum[2]==comNum[2]) {
				strike++;
			}
			else if(userNum[2]==comNum[0]||userNum[2]==comNum[1]) {
				ball++;
			}
			System.out.println("strike= "+strike+"ball= "+ball);
		}while(strike<3&&count<11);
		return count;
	}

	public static void main(String[] args) throws IOException {

		int result;
		if (args.length == 3) {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int z = Integer.parseInt(args[2]);

			result = playGame(x, y, z);
		} else {
			result = creatNum();
		}

		System.out.println();
		if (result <= 2) {
			System.out.println("참 잘했어요");
		} else if (result <= 5) {
			System.out.print("잘했어요");
		} else if (result <= 9) {
			System.out.println("보통이네요");
		} else {
			System.out.println("분발하세요");
		}
	}
}