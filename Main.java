import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class Main{
	static char originalNum[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			originalNum=sc.next().toCharArray();
			if(getString(originalNum).equals("0")){break;}
			System.out.println("Original number was "+getString(originalNum));
			System.out.println("Chain length "+startChain(originalNum)+"\n");
		}
	}

	static int startChain(char[] num){
		char[] decend, ascend;
		ArrayList resultList=new ArrayList();
		int chanLen=0, last=-1;
		do{
			resultList.add(last);
			Arrays.sort(num);
			decend=num;
			ascend=new StringBuffer(getString(decend)).reverse().toString().toCharArray();
			last=Integer.parseInt(getString(ascend))-Integer.parseInt(getString(decend));
			System.out.println(Integer.parseInt(getString(ascend))+" - "+Integer.parseInt(getString(decend))+" = "+last);
			num=Integer.toString(last).toCharArray();
			chanLen++;

			/*try{
				Thread.sleep(3000);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}*/
		}while(!resultList.contains(last));

		return chanLen;
	}

	static String getString(char[] strList){
		StringBuffer str=new StringBuffer();
		for(int i=0; i<strList.length; i++){
			str.append(strList[i]+"");
		}
		return str.toString();
	}
}