import java.util.*;
public class TowerOfHanoi{
  public static void toh_with_recursion(int num_disks,int start_pos,int end_pos){
      int aux= 6 - start_pos - end_pos;
      if(num_disks==1){
        System.out.println(Integer.toString(start_pos)+" "+Integer.toString(end_pos));
        return;
      }

        toh_with_recursion(num_disks-1,start_pos,aux);
        System.out.println(Integer.toString(start_pos)+" "+Integer.toString(end_pos));
        toh_with_recursion(num_disks-1,aux,end_pos);

    }
    public static void toh_without_recursion(int num_disks,int start_pos,int end_pos){
      int i, moves,temp;
      int aux=6-start_pos-end_pos;
      MyStack<Integer> s_pos= new MyStack<Integer>();
      MyStack<Integer> auxi= new MyStack<Integer>();
      MyStack<Integer> e_pos= new MyStack<Integer>();
      for (i=num_disks;i>0;i--){
        s_pos.push(i);
      }
      if(num_disks%2==0){
        temp=end_pos;
        end_pos=aux;
        aux=temp;
      }
      moves= (int) (Math.pow(2,num_disks));
      for(i=1;i<=moves;i++){
        if(i%3==1){
          //move s_pos to e_pos
          if(s_pos.empty()){
            s_pos.push(e_pos.pop());
            System.out.println(Integer.toString(end_pos)+" "+Integer.toString(start_pos));
          }
          else if(e_pos.empty()){
            e_pos.push(s_pos.pop());
            System.out.println(Integer.toString(start_pos)+" "+Integer.toString(end_pos));
          }
          else if(s_pos.peek()>e_pos.peek()){
            s_pos.push(s_pos.pop());
            s_pos.push(e_pos.pop());
            System.out.println(Integer.toString(end_pos)+" "+Integer.toString(start_pos));
          }
          else{
            e_pos.push(e_pos.pop());
            e_pos.push(s_pos.pop());
            System.out.println(Integer.toString(start_pos)+" "+Integer.toString(end_pos));
          }
        }
        else if(i%3==2){
          //move s_pos to auxi
          if(s_pos.empty()){
            s_pos.push(auxi.pop());
            System.out.println(Integer.toString(aux)+" "+Integer.toString(start_pos));
          }
          else if(auxi.empty()){
            auxi.push(s_pos.pop());
            System.out.println(Integer.toString(start_pos)+" "+Integer.toString(aux));
          }
          else if(s_pos.peek()>auxi.peek()){
            s_pos.push(s_pos.pop());
            s_pos.push(auxi.pop());
            System.out.println(Integer.toString(aux)+" "+Integer.toString(start_pos));
          }
          else{
            auxi.push(auxi.pop());
            auxi.push(s_pos.pop());
            System.out.println(Integer.toString(start_pos)+" "+Integer.toString(aux));
          }
        }
        else if(i%3==0){
          //move auxi to e_pos
          if(auxi.empty()){
            auxi.push(e_pos.pop());
            System.out.println(Integer.toString(end_pos)+" "+Integer.toString(aux));
          }
          else if(e_pos.empty()){
            e_pos.push(auxi.pop());
            System.out.println(Integer.toString(aux)+" "+Integer.toString(end_pos));
          }
          else if(auxi.peek()>e_pos.peek()){
            auxi.push(auxi.pop());
            auxi.push(e_pos.pop());
            System.out.println(Integer.toString(end_pos)+" "+Integer.toString(aux));
          }
          else{
            e_pos.push(e_pos.pop());
            e_pos.push(auxi.pop());
            System.out.println(Integer.toString(aux)+" "+Integer.toString(end_pos));
          }
        }

        }
      }


  public static void main(String args[]){
    toh_without_recursion(3,1,3);
  }
}
