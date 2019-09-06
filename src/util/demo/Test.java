package util.demo;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String str=df.format(new Date()).toString();
		System.err.println(str);
	}
}
