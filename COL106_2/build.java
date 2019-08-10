import java.util.*;
public class build{
  LinkedList<build> object = new LinkedList<build>();
  String dat="";
  int level;
  public String data(){
    return(dat);
  }
  public LinkedList<build> getchildren(){
    return (object);
  }
  public build(String x,int y){
    dat=x;
    level=y;
    object = new LinkedList<build>();
  }
  public int level(){
    return(level);
  }
  public void child(String y){
    build bead = new build(y, level+1);
    object.addLast(bead);
  }
}
