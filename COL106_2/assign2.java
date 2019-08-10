import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class assign2{
  LinkedList<cos> obj = new LinkedList<cos>();
  build x = new build("CEO",1);
  cos node;
  cos jump;
  public Boolean search(build x,String S){
    if(x.data().equals(S)){
      sample=true;
    }
    else if(x.getchildren().size()==0){
      sample=false;
    }
    else{
      for (int i=0;i<x.getchildren().size();i++){
        sample=search(x.getchildren().get(i),S);
        if(sample){
          return sample;
        }
      }
    }
    return(sample);
  }
  Boolean stud=false;
  public Boolean searchp(build x,String T, String S){
    if(x.data().equals(S) && search(x,T)){
      stud=true;
      return stud;
    }
    else if(x.getchildren().size()==0){
      stud=false;
    }
    else{
      for(int i=0;i<x.getchildren().size();i++){
        stud=searchp(x.getchildren().get(i),T,S);
        if(stud){
          return stud;
        }
      }
    }
    return stud;
  }
  Boolean sample=false;
  public void Add(build x,String T,String S){
    int y;
    Boolean state=false;
    if(x.data().equals(S)){
      x.child(T);
      state=true;
      return;
    }
    else if(x.getchildren().size()==0){
      state=false;
    }
    else{
      for (int i=0;i<x.getchildren().size();i++){
        Add(x.getchildren().get(i),T,S);
        if(state==true){
          return;
        }
      }
    }
  }

  public void AddEmployee(String T, String S){
    int index=0;
    int level=0;
    for (int i=0;i<obj.size();i++){
      if(obj.get(i).data().equals(S)){
        index=i;
        break;
      }
    }
    node = obj.get(index);
    level=node.level();
    cos nap= new cos(T,level+1);
    if(obj.getLast().level()==level){
      obj.addLast(nap);
    }
    else{
      for (int i=0;i<obj.size();i++){
        if(obj.get(i).level()>level){
          obj.add(i,nap);
          break;
        }
      }
    }
    Add(x,T,S);

  }
  public void DeleteEmployee(build x,String T, String S){
    if(search(x,S)){
      int ind=0;
      for (int i=0;i<obj.size();i++){
        if(obj.get(i).data().equals(T)){
          ind=i;
        }
      }
      if(ind!=0){
        obj.remove(ind);
      }
}
    // state=false;
    // int l=0;
    // build com;
    // for (int m=0;m<x.getchildren().size();m++){
    //   if(x.getchildren().get(m).data().equals(T)){
    //     com=x.getchildren().get(m).getchildren().get(0);
    //     AddEmployee(com.data(),S);
    //     l=m;
    //     break;
    //   }
    // }
    // if(l!=0){
    //   x.getchildren().remove(l);
    //   state=true;
    //   return;
    // }
    //
    // else if(x.getchildren().size()==0){
    //   state=false;
    // }
    // else{
    //   for(int i=0;i<x.getchildren().size();i++){
    //     DeleteEmployee(x.getchildren().get(i),T,S);
    //     if(state==true){
    //       return;
    //     }
    //   }
    // }
    return;
  }
  public static void main(String args[]){
    cos job=new cos("CEO",1);
    build g=new build("CEO",1);
    assign2 f = new assign2();
    f.obj.add(job);
    int t;
    File file = new File("smalltest.txt");
    try {
        Scanner sc = new Scanner(file);
        t=Integer.parseInt(sc.nextLine());
        for(int m=0;m<t-1;m++) {
          String j=sc.nextLine();
          String[] splitStr = j.split("\\s+");
          f.AddEmployee(splitStr[0],splitStr[1]);
        }
        t=Integer.parseInt(sc.nextLine());
        for(int m=0;m<t;m++){
          String j=sc.nextLine();
            String[] splitStr = j.split("\\s+");
            if(splitStr[0].equals("3")){
              f.PrintEmployees();
            }
            else if(splitStr[0].equals("0")){
              f.AddEmployee(splitStr[1],splitStr[2]);
            }
            else if(splitStr[0].equals("1")){
              f.DeleteEmployee(g,splitStr[1],splitStr[2]);
            }
            else if(splitStr[0].equals("2")){
              f.LowestCommonBoss(g,splitStr[1],splitStr[2]);
            }
        }
        sc.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    }

  public String LowestCommonBoss(build x,String T, String S){
    cos fight=new cos("34",0);
    Boolean stat=false;
    if(search(x,S)&&search(x,T)){
        if(x.level()>fight.level()){
          fight.level=x.level();
          fight.dat=x.data();
      }
    }
    else if(x.getchildren().size()==0){
      stat=false;
    }
    else{
      for(int i=0;i<x.getchildren().size();i++){
        LowestCommonBoss(x.getchildren().get(i),T,S);
      }
    }
    return (fight.data());
  }
  public void PrintEmployees(){
    for (int i=0;i<obj.size();i++){
      node=obj.get(i);
      System.out.println(node.data());
    }
  }
}
