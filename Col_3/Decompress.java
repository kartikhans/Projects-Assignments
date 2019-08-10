import java.util.*;
public class Decompress{
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
  public static int binaryToDecimal(String n){
    int dec_value = 0;

    // Initializing base
    // value to 1, i.e 2^0
    int base = 1;

    String temp = n;

    while (temp.length()>0) {
        int last_digit = Character.getNumericValue(temp.charAt(temp.length()-1));
        temp = temp.substring(0,temp.length()-1);
        dec_value += last_digit * base;

        base = base * 2;
    }

    return dec_value;
  }
  public static String Decompress(ArrayList<String> x){
    chomu[] hash = new chomu[65963];
    Integer[] clash = new Integer[65963];
    for (int i = 0; i <= 127; i++) {
       String ch = "";
       ch += (char)i;
       ch = String.valueOf(ch);
       int y=ownhash(ch);
       chomu cap = new chomu(ch,i);
       clash[i]=y;
       hash[y]=cap;
   }
    int ishq=128;
    String kaim="";
    String old = x.get(0);
    String n="";
    String s = hash[clash[binaryToDecimal((old))]].SeeS();
    String c = "";
    c =c+s.charAt(0);
    kaim=kaim+s;
    for (int i = 0; i < x.size() - 1; i++) {
            n = x.get(i+1);
            if (clash[binaryToDecimal((n))] == null) {
              s = hash[clash[binaryToDecimal((old))]].SeeS();
              s = s + c;
            }
            else {
                s = hash[clash[binaryToDecimal((n))]].SeeS();
            }
            kaim=kaim+s;
            c = "";
            c =c+ s.charAt(0);
            clash[ishq]=ownhash(hash[clash[binaryToDecimal((old))]].SeeS() + c);
            chomu sam =  new chomu(hash[clash[binaryToDecimal(old)]].SeeS() + c,ishq);
            ishq=ishq+1;
            hash[ownhash(hash[clash[binaryToDecimal((old))]].SeeS() + c)]=sam;
            old = n;
        }
        return kaim;
  }
  public static void main (String[] args)
	{
    ArrayList<String> output_code = new ArrayList<String>();
    output_code.add("0000000001101011");
    output_code.add("0000000001100001");
    output_code.add("0000000001110010");
    output_code.add("0000000001110100");
    output_code.add("0000000001101001");
    output_code.add("0000000001101011");
    // output_code.add("0000000010000101");
    String s = Decompress(output_code);
      System.out.println(s);
	}
}
