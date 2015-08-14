package HDOJ;

import java.util.Scanner;

public class _2005 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int year=0,month=0,day=0,countDay=0;
			String input=sc.nextLine();
			String[] data=input.split("/");
			year=Integer.parseInt(data[0]);
			month=Integer.parseInt(data[1]);
			day=Integer.parseInt(data[2]);
			boolean isRun=false;
			if(year%400==0||(year%4==0&&year%100!=0)){
				isRun=true;
			}
			switch (month) {
			case 12:
				countDay+=day;
			case 11:
				if(countDay>0){
					countDay+=30;
				}else {
					countDay+=day;
				}
			case 10:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			case 9:
				if(countDay>0){
					countDay+=30;
				}else {
					countDay+=day;
				}
			case 8:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			case 7:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			case 6:
				if(countDay>0){
					countDay+=30;
				}else {
					countDay+=day;
				}
			case 5:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			case 4:
				if(countDay>0){
					countDay+=30;
				}else {
					countDay+=day;
				}
			case 3:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			case 2:
				if(countDay>0){
					if(isRun==true){
						countDay+=29;
					}else {
						countDay+=28;
					}
				}else {
					countDay+=day;
				}
			case 1:
				if(countDay>0){
					countDay+=31;
				}else {
					countDay+=day;
				}
			default:
				break;
			}//switch
			System.out.println(countDay);
		}//while
	}//main
}
