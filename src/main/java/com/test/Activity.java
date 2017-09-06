package com.test;

public class Activity {
	public static void main(String[] args) {
		int argu = 6;
		for(int num = 1 ; num < argu; num++){
			int curr = num;
			while(curr < (argu)) {
				System.out.print(" ");
				curr++;
			}
			for(int x = 0; x < num; x++) {
				System.out.print(num+ " ");
			}
			System.out.println();
		}
	}
	
}
