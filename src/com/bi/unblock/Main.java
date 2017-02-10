package com.bi.unblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bi.unblock.model.Block;


public class Main {

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
	}

	private static void vertical(int width, int xcom, int ycom, int[][] box) {
		for (int w = 0; w < width; w++) {

			if (box[xcom][ycom + w] != 1) {
				box[xcom][ycom + w] = 1;
			} else {
				box[xcom][ycom + w] = 2;
				System.out.println("false");

			}
		}
	}

	private static void horizontal(int width, int xcom, int ycom, int[][] box) {
		for (int w = 0; w < width; w++) {

			if (box[xcom + w][ycom] != 1) {
				box[xcom + w][ycom] = 1;
			} else {
				box[xcom + w][ycom] = 2;
				System.out.println("false");

			}
		}
	}

}
