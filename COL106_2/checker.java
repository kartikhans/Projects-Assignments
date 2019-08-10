import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker{
  public static void main(String[] args){
    cos job=new cos("CEO",1);
    build g=new build("CEO",1);
    assign2 r = new assign2();
    r.obj.add(job);
    r.AddEmployee("Kartik","CEO");
    r.AddEmployee("viraj","CEO");
    r.AddEmployee("vipin","CEO");
    r.AddEmployee("sapna","Kartik");
    r.AddEmployee("harry","Kartik");
    r.AddEmployee("parth","harry");
    r.AddEmployee("kumar","parth");
    r.AddEmployee("nitin","vipin");
    // r.DeleteEmployee(g,"viraj","CEO");
    r.DeleteEmployee(r.x,"viraj","Kartik");
    // System.out.println(r.x.getchildren().get(0).getchildren().get(1).getchildren().get(0).getchildren().get(0).data());
    // r.LowestCommonBoss(g,"Kartik","viraj");
    r.PrintEmployees();
    }
}
