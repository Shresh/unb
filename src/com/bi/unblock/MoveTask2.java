package com.bi.unblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bi.unblock.model.Block;

public class MoveTask2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of blocks");
		int b = sc.nextInt();
		System.out.println("Enter the horizontal axis");
		int hor = sc.nextInt();
		System.out.println("Enter the vertical axis");
		int ver = sc.nextInt();
		List<Block> blocks = new ArrayList<>();
		int[][] box = new int[hor][ver];
		for (int i = 0; i < hor; i++) {
			for (int j = 0; j < ver; j++) {
				box[i][j] = 0;
			}
		}
		for (int j = (ver - 1); j >= 0; j--) {
			for (int i = 0; i < hor; i++) {
				System.out.print(box[i][j] + "\t");
			}
			System.out.println();
		}

		for (int i = 0; i < b; i++) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter the id");
			int id = sc1.nextInt();
			System.out.println("Enter the x-Component");
			int xcom = sc1.nextInt();
			System.out.println("Enter the y-Component");
			int ycom = sc1.nextInt();
			System.out.println("Enter the width");
			int width = sc1.nextInt();
			System.out.println("Enter the axis");
			String axis = sc1.next();
			Block block = new Block(id, xcom, ycom, width, axis);
			blocks.add(block);
			switch (axis) {
			case "v":
				vertical(width, xcom, ycom, box);
				break;
			case "h":
				horizontal(width, xcom, ycom, box);
				break;
			default:
				System.out.println("Error");
				break;
			}
		}
		System.out.println(blocks);

		for (int j = (ver - 1); j >= 0; j--) {
			for (int i = 0; i < hor; i++) {
				System.out.print(box[i][j] + "\t");
			}
			System.out.println();
		}
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Choose the piece id to move:");
		int moveId = sc2.nextInt();
		int move = moveId;
		System.out.println("Move position:");
		int mposition = sc.nextInt();
		String ax = blocks.get(move).getAxis();
		int width = blocks.get(move).getWidth();
		int xcom = blocks.get(move).getxComponent();
		int ycom = blocks.get(move).getyComponent();
		System.out.println(move + "" +ax + ""+width + ""+ xcom + ""+ycom);

		switch (ax) {
		case "v":
			vmove(width, xcom, ycom, mposition, box);
			break;
		case "h":
			hmove(width, xcom, ycom, mposition, box);
			break;
		default:
			System.out.println("Error value");
			break;
		}
		System.out.println(blocks);

		for (int j = (ver - 1); j >= 0; j--) {
			for (int i = 0; i < hor; i++) {
				System.out.print(box[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void hmove(int width, int xcom, int ycom, int mposition, int[][] box) {

		if (mposition >= 1) {
			for (int mo = 1; mo <= mposition; mo++) {
				if (box[xcom + width + mo][ycom] == 1) {
					for (int m = 0; m < mo; m++) {

						box[xcom + m][ycom] = 0;
						box[xcom + width + m][ycom] = 1;
					}
				} else {
					for (int m = 0; m < mo; m++) {

						box[xcom + m][ycom] = 0;
						box[xcom + width + m][ycom] = 2;
						System.out.println("true");
					}

				}
			}
		} else {
			for (int mo = mposition; mo < 1; mo++) {
				if (box[xcom + mo][ycom] != 1) {
					for (int m = mo; m < 0; m++) {

						box[xcom + m][ycom] = 1;
						box[xcom + width + m][ycom] = 0;
					}
				} else {
					for (int m = mo; m < 0; m++) {

						box[xcom + m][ycom] = 2;
						box[xcom + width + m][ycom] = 0;
						System.out.println("true");
					}
				}

			}
		}

	}

	private static void vmove(int width, int xcom, int ycom, int mposition, int[][] box) {

		if (mposition >= 1) {
			for (int mo = 1; mo <= mposition; mo++) {
				if (box[xcom][ycom + width + mo] != 1) {
					for (int m = 0; m < mo; m++) {

						box[xcom][ycom + m] = 0;
						box[xcom][ycom + width + m] = 1;
					}
				} else {
					for (int m = 0; m < mo; m++) {

						box[xcom][ycom + m] = 0;
						box[xcom][ycom + width + m] = 2;
						System.out.println("true");
					}

				}
			}
		} else {
			for (int mo = mposition; mo < 1; mo++) {
				if (box[xcom][ycom + (mo)] != 1) {
					for (int m = mo; m < 0; m++) {

						box[xcom][ycom + m] = 1;
						box[xcom][ycom + width + m] = 0;
					}
				} else {
					for (int m = mo; m < 0; m++) {

						box[xcom][ycom + m] = 2;
						box[xcom][ycom + width + m] = 0;
						System.out.println("true");
					}
				}

			}
		}

	}

	private static void vertical(int width, int xcom, int ycom, int[][] box) {
		for (int w = 0; w < width; w++) {

			if (box[xcom][ycom + w] != 1) {
				box[xcom][ycom + w] = 1;
			} else {
				box[xcom][ycom + w] = 2;
				System.out.println("true");

			}
		}
	}

	private static void horizontal(int width, int xcom, int ycom, int[][] box) {
		for (int w = 0; w < width; w++) {

			if (box[xcom + w][ycom] != 1) {
				box[xcom + w][ycom] = 1;
			} else {
				box[xcom + w][ycom] = 2;
				System.out.println("true");

			}
		}
	}

}
