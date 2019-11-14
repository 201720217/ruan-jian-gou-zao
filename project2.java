package 软件构造实验一;

/*project2是将project1分解模块化*/


import java.util.Random;
public class project2 {            
	public static void main(String[] args) {
		short[] x = new short[50];  
		short[] y = new short[50];	 
		short[] ov = new short[50];                               //新建三个存放算式符号串的数组
		printHeader();                                            //简单说明本本程序的作用
		generateEquations(x,y,ov);                                //产生加法或减法算式并存入数组x[i],y[i],ov[i]
		printExercise(x,y,ov);                                    //按照要求打印输出算式
		printCalculations(x,y,ov);                                //计算算式结果并按照要求打印输出
	}
	public static void printHeader() {
		System.out.println("-----------------------------------------");
		System.out.println("-本程序输出50道100以内的加减法算式-");
		System.out.println("-每次运行程序可得到一套50道题的算式的答案-");
		System.out.println("-----------------------------------------");
	}
	public static void generateEquations(short[] x,short[] y,short[] ov) {
		Random random=new Random();
		for(int i=0;i<50;i++) {
			ov[i]=(short)random.nextInt(2);
			if((ov[i])==1) {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1+index2<=100) {
						x[i]=index1;
						y[i]=index2;
						break;                                              //规定算式的和不能超过一百
					}	
				}
			
			}
			else {
				while(true){
					short index1=(short)random.nextInt(101);
					short index2=(short)random.nextInt(101);
					if(index1-index2>0) {
						x[i]=index1;
						y[i]=index2;
						break;                                             //规定算式的差不能小于零
					}	
				}	
			}
			for(int m=0;m<49;m++) {
				for(int n=m+1;n<50;n++) {
					if(x[m]==x[n]&&y[m]==y[n]&&ov[m]==ov[n]||ov[m]==1&&x[m]==y[n]&&y[m]==x[n]) {
						x[m]=(short)random.nextInt(101);
						y[m]=(short)random.nextInt(101);
						ov[m]=(short)random.nextInt(2);
						m=0;
						break;
					}
				}	
			}                                                                //判断生成算式是否重复
		}
	}                                 
   public static void printExercise(short[] x,short[] y,short[] ov) {
	for(int i=0;i<50;i++) {
		if(ov[i]==1) {
			System.out.print("("+(i+1)+")"+":  "+x[i]+'+'+y[i]+"="+"\t");
		}
		else {
			System.out.print("("+(i+1)+")"+":  "+x[i]+'-'+y[i]+"="+"\t");
		}
		if((i+1)%5==0)
			System.out.println();
	   }
   }                                                                       //将生成的算式按照一定的要求打印输出
	
	
	
	
	public static void printCalculations(short[] x,short[] y,short[] ov) {
		System.out.println("-----------------------------------------");
		System.out.println("-下面是算式的参考答案-");
		System.out.println("-----------------------------------------");
		for(int i=0;i<50;i++) {
			if(ov[i]==1) {
				int answer=x[i]+y[i];
				System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();
				}		
			}
			else {
				int answer=x[i]-y[i];
				System.out.print("("+(i+1)+")"+":   "+answer+"\t");
				if((i+1)%5==0) {
					System.out.println();                                //按照要求打印输出算式的答案
				}	
			}
		}
	}
}



