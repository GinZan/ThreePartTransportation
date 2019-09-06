package util.demo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Random;

import com.mysql.fabric.xmlrpc.base.Array;

public class RandomStuff {

	static Random random=new Random();
	public RandomStuff() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String args[]){
		String phone=getRandomTel();
		System.out.println(phone);
	}
	public static String getRandomTel(){
		String tel="13";
		for (int i = 0; i < 9; i++) {
			tel+=random.nextInt(10);
		}
		return tel;
	}
	public static  String getRandomPlate(){
		Random random=new Random();
		String ram="粤";
		int length=6;
		//随机粤后面的一个字母
		String diqu="QWERTYUIOPLKJHGFDSAZXCVBNM";
		char yue=diqu.charAt(random.nextInt(diqu.length()));
		ram=ram+yue;
		for(int i=0;i<length-1;i++){
			//是字母还是数字
			String charOrNum=random.nextInt(2)==0 ? "char":"num";
			//System.out.println("随机数字字母是："+charOrNum);
			if (charOrNum.equalsIgnoreCase("char")) {
				ram+=(char)(random.nextInt(26)+65);
			}else if (charOrNum.equalsIgnoreCase("num")) {
				ram+=String.valueOf(random.nextInt(10));
			}
		}
		//System.out.println("组装后的号码是："+ram);
		return ram; 
	}
	public static Timestamp getCurrentTime(){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	public static String getRandomSex(){
		String[] sex={"男","女","未知"};
		int temp=random.nextInt(3);
		return sex[temp].toString();
	}
	public static String getRandomName(){
		String[] xing={"赵","钱","孙","李","周","吴","郑","王","冯","陈"};
		String[] mid={"寻","根","问","祖","追","根","溯","源","是","人","的","天","性"};
		String[] lat={"两","者","之","间","的","区","别","还","是","很","明","显","的","嘛"};
		int a=random.nextInt(xing.length);
		int b=random.nextInt(mid.length);
		int c=random.nextInt(lat.length);
		return xing[a]+mid[b]+lat[c];
	}
	public static String getRandomEmail(){
		String[] cate={"@163.com","@qq.com","@hotmail.com","@foxmail.com","@gmail.com","@139.com"};
		Random random =new Random();
		String randomStr=getRandomString(5);
		int random_index=random.nextInt(cate.length);
		return randomStr+cate[random_index];
		
	}
	public static String getRandomString(int length){
		
		//数字 part
		char[] numArray=new char[10];
		int num=48;
		for (int j = 0; j < numArray.length; j++) {
			numArray[j]=(char)num;
			num++;
			//System.out.println(numArray[j]);
		}
		
		//字符串 part
		char[] str=new char[26];
		int char_low=97;
		for (int j = 0; j < str.length; j++) {
			str[j]=(char)char_low;
			char_low++;
			//System.out.println(str[j]);
		}
		
		//组装
		StringBuilder sb=new StringBuilder();
		Random random =new Random();
		for (int i = 0; i < length; i++) {
			int random_num_index=random.nextInt(10);
			sb.append(numArray[random_num_index]);
		}
		for (int i = 0; i < 4; i++) {
			int random_char_index=random.nextInt(26);
			sb.append(str[random_char_index]);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
