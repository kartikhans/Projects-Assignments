import java.util.*;
public class MyStack<T> {
  LinkedList<T> object = new LinkedList<T>();
  public void push(T item){
    object.addLast(item);
  }
  public T pop(){
    if(object.size()==0){
      throw new EmptyStackException();
    }
    else
      return(object.removeLast());
  }
  public T peek(){
    if(object.size()==0){
      throw new EmptyStackException();
    }
    else
      return(object.getLast());
  }
  public boolean empty(){
    return (object.size()==0);
  }
}
