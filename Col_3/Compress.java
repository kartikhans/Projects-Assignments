import java.util.*;
public class Compress{
  public static String bin(int n){
		int[] binaryNum = new int[1000];

		// counter for binary array
		int i = 0;
		while (n > 0)
		{
			// storing remainder in binary array
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}
		String x="";
		String y="";
		// printing binary array in reverse order
		for (int j = i - 1; j >= 0; j--){
			x=x+binaryNum[j];
		}
		int siz=16-x.length();
		for (i=0;i<siz;i++){
			y=y+0;
		}
		y=y+x;
		return y;
	}
  public static Integer ownhash(String x){
    int sume=0;
    int c=0;
    int l=41;
    for (int i=0;i<x.length();i++){
      c=x.charAt(i);
      sume=sume+(int)(c*(Math.pow(l,i)));
    }
    sume=sume % 65963;
    return sume;
  }
  public static ArrayList<String> Compress(String x){

    // HashMap<String, Integer> map = new HashMap<>();
    chomu[] hash = new chomu[65963];
    ArrayList<String> output= new ArrayList<String>();
    for (int i = 0; i <= 127; i++) {
       String ch = "";
       ch += (char)i;
       ch = String.valueOf(ch);
       int y=ownhash(ch);
       chomu cap = new chomu(ch,i);
       hash[y]=cap;
   }
   int count=128;
   String p = "", c = "";
   p += x.charAt(0);
   for (int i = 0; i < x.length(); i++) {
        if (i != x.length() - 1)
            c += x.charAt(i+1);
        if (hash[ownhash(p+c)] != null) {
            p = p + c;
        }
        else {
          output.add(bin(hash[ownhash(p)].SeeIndex()));
          chomu sam =  new chomu(p+c,count);
          count = count+1;
          hash[ownhash(p+c)]=sam;
          p = c;
        }
        c = "";
    }
    output.add(bin(hash[ownhash(p)].SeeIndex()));
    return output;
  }
  public static void main (String[] args)
	{
    String s = "kartik";
    ArrayList<String> output_code = Compress(s);
        System.out.println(output_code);
	}
}
