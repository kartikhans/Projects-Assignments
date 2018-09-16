//package COL106_A4;
import java.util.*;
import java.io.*;
public class Anagram {
	public static int c2=0;
	static LinkedList[] b=new LinkedList[40000];
	public static LinkedList dq1=new LinkedList();
	public static LinkedList<String> finalprint=new LinkedList();
	public static LinkedList<String> ab=new LinkedList<String>();
	public static LinkedList<String> ekspacevali=new LinkedList<String>();
	public static LinkedList<String> dospacevali1=new LinkedList<String>();
	public static LinkedList<String> dospacevali2=new LinkedList<String>();
	public static LinkedList<String> dospacevali3=new LinkedList<String>();
	public static int hash(String g) {
		int hashe=0;
		for(int i=0;i<g.length();i++) {
			hashe = (33*hashe + g.charAt(i))%c2;
		}
		return (hashe)%c2; 
	}
	public static String sorted(String x) {
		char[] vc=x.toCharArray();
		//System.out.println(vc.toString());
		Arrays.sort(vc);
		//System.out.println(vc.toString());
		String temp=String.valueOf(vc);
		return temp;
	}
	
	
	static void Combinationbanade(char arr[], int n, int r)
    {
        char data[]=new char[r];   
        combinationUtil(arr, data, 0, n-1, 0, r);
    }
	static void combinationUtil(char arr[], char data[], int start,
            int end, int index, int r)
	{
		if (index == r)
		{
			String ff="";
			for (int j=0; j<r; j++) {
				ff=ff+data[j];
			}
			ekspacevali.add(ff);
			return;
		}
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
			while(i!=arr.length-1 && arr[i]==arr[i+1]) {
				i++;
			}
		}
	}
	//ye wale do space1 ke lie hain
	static void Combinationbanade(char arr[], int n, int r,String s)
    {
        char data[]=new char[r];   
        combinationUtil(arr, data, 0, n-1, 0, r,"");
    }
	static void combinationUtil(char arr[], char data[], int start,
            int end, int index, int r,String s)
	{
		if (index == r)
		{
			String ff="";
			for (int j=0; j<r; j++) {
				ff=ff+data[j];
			}
			dospacevali1.add(ff);
			return;
		}
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r,"");
			while(i!=arr.length-1 && arr[i]==arr[i+1]) {
				i++;
			}
		}
	}
	//yahan tak hain do space1 ke
	//ye wale do space2 ke lie hain
	static void Combinationbanade(char arr[], int n, int r,String s1,String s2)
    {
        char data[]=new char[r];   
        combinationUtil(arr, data, 0, n-1, 0, r,"","");
    }
	static void combinationUtil(char arr[], char data[], int start,
            int end, int index, int r,String s1,String s2)
	{
		if (index == r)
		{
			String ff="";
			for (int j=0; j<r; j++) {
				ff=ff+data[j];
			}
			dospacevali2.add(ff);
			return;
		}
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r,"","");
			while(i!=arr.length-1 && arr[i]==arr[i+1]) {
				i++;
			}
		}
	}
	//yahan tak hain do space2 ke
	//ye wale do space3 ke lie hain
	static void Combinationbanade(char arr[], int n, int r,String s1,String s2,String s3)
    {
        char data[]=new char[r];   
        combinationUtil(arr, data, 0, n-1, 0, r,"","","");
    }
	static void combinationUtil(char arr[], char data[], int start,
            int end, int index, int r,String s1,String s2,String s3)
	{
		if (index == r)
		{
			String ff="";
			for (int j=0; j<r; j++) {
				ff=ff+data[j];
			}
			dospacevali3.add(ff);
			return;
		}
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r,"","","");
		}
	}
	//yahan tak hain do space3 ke
	
	
	public static void dospacekelie(String schoti,String sbadi) {
		
		char arr9[] = sbadi.toCharArray();
        int n = arr9.length;
		
		if(sbadi.length()==9) {
			//char arr9[] = s.toCharArray();
	        //int n = arr9.length;
			
			//System.out.println(((String)c.get(0)).split(" ")[1]+"what");
				String s1="";
				s1=baakistring(sbadi,schoti);
				s1=sorted(s1);
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,3,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));								
								}
							}
							//
						}		
				}
		        	
				}
				dospacevali1.clear();
				
				
			
		}
	        
		if(sbadi.length()==10) {
				String s1="";
				s1=baakistring(sbadi,schoti);
				s1=sorted(s1);
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,3,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									dq1.add(schoti+" "+b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh)+" "+schoti);
									
								}
							}
							//
						}		
				}
		        	
					
				}
				dospacevali1.clear();
				
		}
			
			
			
		
		if(sbadi.length()==11) {
			String s1="";
			s1=baakistring(sbadi,schoti);
			s1=sorted(s1);
			if(schoti.length()==3) {
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,4,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									dq1.add(b[hash(zz)].get(fg)+" "+schoti+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh)+" "+schoti);
									
								}
							}
							//
						}		
				}
		        	
					
				}
				dospacevali1.clear();
				
			}
			if(schoti.length()==5){
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,3,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									dq1.add(b[hash(zz)].get(fg)+" "+schoti+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh)+" "+schoti);
									
								}
							}
							//
						}		
				}
		        	
					
				}
				
				dospacevali1.clear();
				
			}
			
		}
		if(sbadi.length()==12) {
			String s1="";
			s1=baakistring(sbadi,schoti);
			s1=sorted(s1);
			if(schoti.length()==6) {
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,3,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									dq1.add(b[hash(zz)].get(fg)+" "+schoti+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh)+" "+schoti);
								}
							}
							//
						}		
				}
		        	
					
				}
				dospacevali1.clear();
				
			}
			if(schoti.length()==4) {
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,4,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									//this next line is what i want to do
									//vvv.add(b[hash(zx)].get(jh)+" "+b[hash(z1x)].get(hh)+" "+b[hash(z1z)].get(fg));
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									
									
								}
							}
							//
						}		
				}
		        	
					
				}
				dospacevali1.clear();
				
			}
			if(schoti.length()==5) {
				Combinationbanade(s1.toCharArray(),s1.toCharArray().length,3,"");
				for(int ii=0;ii<dospacevali1.size();ii++) {
					String zx=dospacevali1.get(ii);
					String zz=s1;
					zz=baakistring(zz,zx);
		        	zz=sorted(zz);
		        	for(int hh=0;hh<b[hash(zx)].size();hh++) {
		        		String et;
						et=sorted((String)b[hash(zx)].get(hh));
						if(et.compareTo(zx)==0) {
							//
							for(int fg=0;fg<b[hash(zz)].size();fg++) {
								String eii;
								eii=sorted((String)b[hash(zz)].get(fg));
								if(eii.compareTo(zz)==0) {
									dq1.add(schoti+" "+b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg));
									dq1.add(schoti+" "+b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+schoti+" "+b[hash(zx)].get(hh));
									dq1.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(hh)+" "+schoti);
									
									dq1.add(b[hash(zx)].get(hh)+" "+schoti+" "+b[hash(zz)].get(fg));
									dq1.add(b[hash(zx)].get(hh)+" "+b[hash(zz)].get(fg)+" "+schoti);
								}
							}
							//
						}		
				}
		        	
					
				}
				dospacevali1.clear();
				
			}
		}
	}
			
		
		
		
	
	public static String baakistring(String c,String ic) {
		String zx=ic;
    	String zz=c;
    	zz=sorted(zz);
    	char[] zc=c.toCharArray();
    	char[] zic=ic.toCharArray();
    	for(int ut=0;ut<ic.length();ut++) {
    		for(int ui=0;ui<c.length();ui++) {
    			if(zic[ut]==zc[ui]) {
    				zc[ui]='&';
    				break;
    			}
    		}
    	}
    	String cd="";
    	for(int i=0;i<zz.length();i++) {
    		if(zc[i]!='&') {
    			cd=cd+zc[i];
    		}
    	}
    	if(cd.length()==zz.length()-zx.length()) {
    		return cd;	
    	}
    	else {
    		return "qq";
    	}
    	
	}
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		Scanner sa=new Scanner(System.in);
		try {
			Scanner sb=new Scanner(new File(args[0]));
			int c1=sb.nextInt();
			c2=c1;
			for(int yt=0;yt<c1;yt++) {
				b[yt]=new LinkedList();
				}
			for(int k=0;k<c1;k++) {
				String bn=sb.nextLine();
				String temp=sorted(bn);
				int m=hash(temp);
				//System.out.println(m);
				b[m].add(bn);
		}
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		try {
			Scanner sb=new Scanner(new File(args[1]));
			int numberofwords=Integer.parseInt(sb.nextLine());
			for(int y=0;y<numberofwords;y++) {
				String qs=sb.nextLine();
				LinkedList vvv=new LinkedList();
				LinkedList vvvnew =new LinkedList();
				LinkedList tempo=new LinkedList();
				qs=spaceremover(qs);
				//yahan bina space vale anagrams honge
				String temp1=sorted(qs);
				for(int sd=0;sd<b[hash(temp1)].size();sd++) {
					String e;
					e=sorted((String)b[hash(temp1)].get(sd));
					if(e.compareTo(temp1)==0) {
						vvv.add(b[hash(temp1)].get(sd));
					}
				}
				if(temp1.length()>5) {
					if(temp1.length()==6 ) {
						for(int r=3;r<4;r++) {
							char arr6[] = temp1.toCharArray();
					        int n = arr6.length;
					        Combinationbanade(arr6, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
											}
										}
										
									
									}
					        		
					        	}
					        }  
					        ekspacevali.clear();
				
						}
						
				}
					if(temp1.length()==7 ) {
						for(int r=3;r<4;r++) {
							char arr7[] = temp1.toCharArray();
					        int n = arr7.length;
					        Combinationbanade(arr7, n, r);
					        
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=sorted(zz);
					        	zz=baakistring(zz,zx);
					        	
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
											}
										}	
									}
					        	}
					        }  
					        ekspacevali.clear();  
						}
				}
					if(temp1.length()==8 ) {
						for(int r=3;r<5;r++) {
							char arr8[] = temp1.toCharArray();
					        int n = arr8.length;
					        Combinationbanade(arr8, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												if(r!=4) {
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
													vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
												}
												else{
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												}
												
											}
										}	
									}	
					        	}
					        }  
					        ekspacevali.clear();
						}	
				}
					if(temp1.length()==9) {
						for(int r=3;r<5;r++) {
							char arr9[] = temp1.toCharArray();
					        int n = arr9.length;
					        Combinationbanade(arr9, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										dospacekelie((String)b[hash(zx)].get(jh),temp1);
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												
												vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
											}
										}	
									}	
					        	}
					        }  
					        ekspacevali.clear();
						}
						
						
						
							
					}
					if(temp1.length()==10) {
						
						for(int r=3;r<6;r++) {
							char arr10[] = temp1.toCharArray();
					        int n = arr10.length;
					        Combinationbanade(arr10, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										if(r==3) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												if(r!=5) {
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
													vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
												}
												else {
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												}
												
											}
										}
										
										
									}
					        		
					        	}
					        	
					        }  
					        ekspacevali.clear();   
						}

						
					}
					if(temp1.length()==11) {
						
						for(int r=3;r<6;r++) {
							char arr11[] = temp1.toCharArray();
					        int n = arr11.length;
					        Combinationbanade(arr11, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										if(r==3) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										if(r==5) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												vvvnew.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
											}
										}
									}	
					        	}
					        }  
					        ekspacevali.clear();
					        
						}
						
						
						
					}
					if(temp1.length()==12) {
						for(int r=3;r<7;r++) {
							char arr12[] = temp1.toCharArray();
					        int n = arr12.length;
					        Combinationbanade(arr12, n, r);
					        for(int ii=0;ii<ekspacevali.size();ii++) {
					        	String zx=ekspacevali.get(ii);
					        	String zz=qs;
					        	zz=baakistring(zz,zx);
					        	zz=sorted(zz);
					        	for(int jh=0;jh<b[hash(zx)].size();jh++) {
					        		String e;
									e=sorted((String)b[hash(zx)].get(jh));
									if(e.compareTo(zx)==0) {
										if(r==4) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										if(r==5) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										if(r==6) {
											dospacekelie((String)b[hash(zx)].get(jh),temp1);
										}
										for(int fg=0;fg<b[hash(zz)].size();fg++) {
											String ei;
											ei=sorted((String)b[hash(zz)].get(fg));
											if(ei.compareTo(zz)==0) {
												if(r!=6) {
													vvvnew.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
													vvv.add(b[hash(zz)].get(fg)+" "+b[hash(zx)].get(jh));
												}
												else {
													vvvnew.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
													vvv.add(b[hash(zx)].get(jh)+" "+b[hash(zz)].get(fg));
												}
												
											}
										}
										
										
									}
					        		
					        	}
					        	
					        }  
					        ekspacevali.clear();   
						}
						
						
					}
					
					
			}
				int uo=0;	
				
				for(int ur=0;ur<vvv.size();ur++) {
					dq1.add(vvv.get(ur));
				}
				Collections.sort(dq1);
				
				int tr=0;
				while(tr<dq1.size()-1) {
					if(dq1.get(tr).equals(dq1.get(tr+1))) {
						dq1.remove(tr+1);
					}
					else {
						tr++;
					}	
				}
				for(int yp=0;yp<dq1.size();yp++) {
					System.out.println(dq1.get(yp));
				}
				dq1.clear();
				System.out.println("-1");
				
		}
			
		}catch(FileNotFoundException e) {
			System.out.println("input.txt not found");
		}
			
			
			
			
			
			
			
		
		
		
		
		
	}
	public static String spaceremover(String a) {
		String k="";
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)!=32) {
				k=k+a.charAt(i);
				
			}
		}
		return k;
	}
	
	
}
