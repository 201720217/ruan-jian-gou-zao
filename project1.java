package 软件构造实验一;
import java.util.Random;
public class project1 {
	public static void main(String[] args) {
			short m = 0, n = 0, ov = 0;
			char o = '+';
			Random random = new Random();
			for (int i=0;i<50;i++) {
				ov = (short)random.nextInt(2);
				m = (short)random.nextInt(100);
				n = (short)random.nextInt(100);
				if (ov == 1) {
					o = '+';
				}else {
					o = '-';
				}
				System.out.println(""+(i+1)+":\t"+m+o+n+"=");
			}
			
	}

}
