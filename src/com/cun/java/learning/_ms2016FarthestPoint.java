package com.cun.java.learning;

import java.util.Scanner;

public class _ms2016FarthestPoint {
	public static float getDistance(float x, float y, int x1, int y1) {
		return (float) Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		float x = cin.nextFloat(), y = cin.nextFloat(), r = cin.nextFloat();
		int lx = (int) Math.floor(x - r), ly = (int) Math.floor(y - r);
		int rx = (int) Math.ceil(x + r), ry = (int) Math.ceil(y + r);
		int resx1 = 0, resy1 = 0;
		float t, min_dist = 0.0f;
		if ((x + r - rx) == 0 && y - Math.ceil(y) == 0) {
			System.out.println((int) (x + r) + " " + (int) y);
			return;
		}
		for (int i = lx; i <= rx; i++) {
			for (int j = ly; j <= ry; j++) {
				t = getDistance(x, y, i, j);
				if (t - r <= 0) {// in or on
					if (t - min_dist > 0) {// bigger one
						min_dist = t;
						resx1 = i;
						resy1 = j;
					} else if (t - min_dist == 0) {
						if (i > resx1) {// bigger x
							resx1 = i;
							resy1 = j;
						}
						if (i == resx1) {
							if (j > resy1) {// bigger y
								resx1 = i;
								resy1 = j;
							}
						}
					} else if (j - y < 0) {
						j = (int) Math.floor(y + Math.abs(y - j));
					}
				}
			}
		}
		System.out.println(resx1 + " " + resy1);
	}
}