
import java.util.*;
import java.io.*;

class ListNode <Integer> {
    /* data attributes */
    private Integer element;
    private ListNode <Integer> prev;
    private ListNode <Integer> next;
    /* constructors */
    public ListNode(Integer item) { this(item, null, null); }
    public ListNode(Integer item, ListNode <Integer> p, ListNode <Integer> n) {
      element = item;
      prev = p;
      next = n;
    }
    /* get the next ListNode */
    public ListNode <Integer> getNext() { return next; }
    public ListNode <Integer> getPrev() { return prev; }
    /* get the element of the ListNode */
    public Integer getElement() { return element; }
    /* set the next reference */
    public void setNext(ListNode <Integer> n) { next = n; }
    public void setPrev(ListNode <Integer> p) { prev = p; }

    public void setElement(Integer item){ element = item; }
}

class LinkedList <Integer> {
    private ListNode <Integer> head = null;
    private ListNode <Integer> tail = null;

    public ListNode <Integer> getHead() {return head;}
    public ListNode <Integer> getTail() {return tail;}

    public void addLast(Integer item){
        if(head==null) {
            head= new ListNode <Integer>(item,null,null);
            tail=head;
            return;
        }
        ListNode <Integer> x = tail;
        tail = new ListNode <Integer> (item, tail, null);
        x.setNext(tail);
    }

    public void addBefore(ListNode<Integer> node, Integer elem){
        if (node==head){
            head=new ListNode<Integer>(elem,null,head);
            head.getNext().setPrev(head);
            return;
        }
        ListNode <Integer> a = new ListNode<Integer> (elem, node.getPrev(), node);
        node.getPrev().setNext(a);
        node.setPrev(a);
    }

    //change the previous element
    public void setBefore(ListNode<Integer> node, Integer elem){
        if (node==head){
            head =new ListNode<Integer>(elem,null,head);
            head.getNext().setPrev(head);
        }
        node.getPrev().setElement(elem);
    }

    //removeBefore
    public void removeBefore(ListNode<Integer> node){
        if(node==null) {
            return;
        }
        if(node.getPrev()==null) {
            return;
        }
        if(head.getNext()==tail) {
            head=head.getNext();
            return;
        }
        ListNode <Integer> c = node.getPrev().getPrev();
        c.setNext(node);
        node.setPrev(c);
    }

    //remove
    public void remove(ListNode<Integer> node){

        if(node==head) {
            head=head.getNext();
        } else if (node==tail) {
            tail=tail.getPrev();
        } else {
            node.getPrev().setNext(node.getNext());
        }
    }
}

public class LinkedListImage implements CompressedImageInterface {

    private Scanner s;
    public int m,n;
    private int[] black;
    public LinkedList <Integer>[] array1 = new LinkedList[1];
    public int height, width;

	public LinkedListImage(String filename)
	{
		try {
                FileInputStream fstream = new FileInputStream(filename);
                s = new Scanner(fstream);
                height = s.nextInt();
                width = s.nextInt();
                LinkedList <Integer>[] array = new LinkedList[height];
                int i=0,j=0;
                black = new int[height];

                while(j<height){
                    array[j] = new LinkedList<Integer>();
                    i=0;
                    while(i<width){

                        int temp = s.nextInt();
                         
                        if(temp==1){
                            i++;
                        } 
                        else if(temp==0){

                            array[j].addLast(i);
                            if (i==width-1)
                            {
                                array[j].addLast(width-1);
                            }
                            i++;
                            for(int k =i;k<width;k++){
                                int x=s.nextInt();

                                if(x==0)
                                {
                                if(i==width-1) {array[j].addLast(width-1);}
                                i++;
                                }
                                else
                                {

                                    array[j].addLast(i-1);
                                    i++;
                                    break;
                                }
                            }
                        }
                    }

                    array[j].addLast(-1);

                    j++;
                }
               array1=array;
        }
        catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

    public LinkedListImage(boolean[][] grid, int width, int height)
    {
		this.height=height;
        this.width=width;
        LinkedList <Integer>[] array = new LinkedList[height];
        int j=0,i=0;

        black = new int[height];

        while(j<height){
            array[j] = new LinkedList<Integer>();
            i=0;
            while(i<width){
                if(grid[j][i]==true){
                    i++;
                    continue;
                } else if(grid[j][i]==false){
                    black[j]++;
                    //add i to list j
                    array[j].addLast(i);
                    while( grid[j][i]!=true){
                        i++;
                        if(i==width){
                           break; 
                        }
                    }
                    //add i-1 to list j
                    array[j].addLast(i-1);
                }
            }
            array[j].addLast(-1);
            j++;
        }
        array1=array;
    }

    public boolean getPixelValue(int x, int y) throws PixelOutOfBoundException
    {
		ListNode <Integer> current = array1[x].getHead();
        int counter;

        if (x>=height || y>=width){
            throw new PixelOutOfBoundException("hello world"+x +" "+y);
        }

        for(counter=0; current.getElement()<=y ; ){
            if(current.getElement()==y) return false;
            if(current.getElement() == -1) break;
            counter++;
            current = current.getNext();
        }

        if(counter%2==0){
            return true;
        } else {return false;}
    }

    public void setPixelValue(int x, int y, boolean val) throws PixelOutOfBoundException
    {
		LinkedList <Integer>[] array = new LinkedList[height];
            array=array1;
            ListNode <Integer> current = array[x].getHead();

            if (x>=height || y>=width) {
                throw new PixelOutOfBoundException("Hello World set" );
            }
            while(current.getElement()!=-1 && y>current.getElement()  ){
                current = current.getNext();
            }
            if (getPixelValue(x,y) != val){
                if(getPixelValue(x,y)==true){
                    //black[x]++;
                    if (y==0) {
                        //11..
                        if (getPixelValue(x,y+1)==true) {
                            array[x].addBefore(current, y);
                            array[x].addBefore(current, y);
                        }
                        //10..
                        else {
                            current.setElement(y);
                        }
                    }
                    else if (y==width-1) /* current=head */{
                        //..11
                        if (getPixelValue(x,y-1)==true) {
                            array[x].addBefore(array[x].getTail(),y);
                            array[x].addBefore(array[x].getTail(),y);
                        }
                        //..01
                        else {
                            array[x].getTail().getPrev().setElement(y);
                        }
                    }
                    else if(getPixelValue(x,y-1)==true){
                        if(getPixelValue(x,y+1)==true){
                            //111
                            array[x].addBefore(current, y);
                            array[x].addBefore(current, y);

                        } else {
                            //110
                            current.setElement(y);
                        }
                    } else {
                        if(getPixelValue(x,y+1)==true){
                            //011
                            array[x].setBefore(current,y);

                        } else {
                            //010
                            array[x].removeBefore(current);
                            array[x].removeBefore(current.getNext());
                        }
                    }
                } else {
                    if (y==0) {
                        //01..
                        if (getPixelValue(x,y+1)==true) {
                            array[x].remove(current.getNext());
                            array[x].remove(current);
                        }
                        //00..
                        else {
                            current.setElement(y+1);
                        }
                    }
                    else if (y==width-1) {
                        //..10
                        if (getPixelValue(x,y-1)==true) {
                            array[x].removeBefore(array[x].getTail());
                            array[x].removeBefore(array[x].getTail());
                        }
                        //..00
                        else {
                            array[x].setBefore(array[x].getTail(), y-1);
                        }
                    }
                    else if(getPixelValue(x,y-1)==true){
                        if(getPixelValue(x,y+1)==true){
                            //101
                            array[x].remove(current);
                            array[x].remove(array[x].getHead());
                        }
                            //100
                            current.setElement(y+1);
                        }
                     else {
                        if(getPixelValue(x,y+1)==true){
                            //001
                            current.setElement(y-1);

                        } else {
                            //000
                            array[x].addBefore(current, y-1);
                            array[x].addBefore(current, y+1);
                        }
                    }
                }
            }
    }

    public int[] numberOfBlackPixels()
    {
		try{
            int[] black = new int[height];
            for(int x=0;x<height;x++)
            {   black[x]=0;
                for(int y=0;y<width;y++)
                {
                    if(getPixelValue(x,y)==false)
                    {
                        black[x]++;
                    }
                }
            }
            return black;
        } catch (PixelOutOfBoundException p) {
            System.out.println(" ");
        }
            return black;
    }
    
    public void invert()
    {
		try{
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    setPixelValue(i,j,!getPixelValue(i,j));
                }
            }
        } catch(PixelOutOfBoundException g) {
            System.out.println("Pixel out of bounds!!");
        }
    }
    
    public void performAnd(CompressedImageInterface img) throws BoundsMismatchException
    {
		try{
            LinkedListImage image= (LinkedListImage) img;
            if (height!=image.height || width!=image.width) {
                throw new BoundsMismatchException("");
            }
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    if (getPixelValue(i,j)==true && image.getPixelValue(i,j)==false) {
                        setPixelValue(i,j,false);
                    }
                }
            }
        } catch(PixelOutOfBoundException g) {
            System.out.println("Pixel out of bounds!");            
        }
    }
    
    public void performOr(CompressedImageInterface img) throws BoundsMismatchException
    {
		try{
            LinkedListImage image= (LinkedListImage) img;
            if (height!=image.height || width!=image.width) {
                    throw new BoundsMismatchException("");
                }
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    if (getPixelValue(i,j)==false && image.getPixelValue(i,j)==true) {
                        setPixelValue(i,j,true);
                    }
                }
            }
        } catch(PixelOutOfBoundException g) {
            System.out.println("Pixel out of bounds!");            
        }
    }
    
    public void performXor(CompressedImageInterface img) throws BoundsMismatchException
    {
		try{
            LinkedListImage image= (LinkedListImage) img;
            if (height!=image.height || width!=image.width) {
                    throw new BoundsMismatchException("");
                }
                int i,j;
            for ( m=0; m<height; m++) {
                for (n=0; n<width; n++) {
                    i=m;
                    j=n;
                    if ((getPixelValue(i,j)==true && image.getPixelValue(i,j)==false) || (getPixelValue(i,j)==false && image.getPixelValue(i,j)==true)) {
                        setPixelValue(i,j,true);
                    }
                    if (getPixelValue(i,j)==true && image.getPixelValue(i,j)==true || getPixelValue(i,j)==false && image.getPixelValue(i,j)==false ) {
                        setPixelValue(i,j,false);
                    }
                }
            }
        } catch(PixelOutOfBoundException g) {
            System.out.println("Pixel out of bounds!");            
        }
    }
    
    public String toStringUnCompressed()
    {
		try{
            String str = height+" "+width;
            int y;
            for(int i=0; i<height; i++){
                str = str + ",";
                for(Integer j=0; j<width; j++){
                    if(getPixelValue(i,j)) str+=" 1";
                    else str+=" 0";
                }
            }
        return str;
        }catch(PixelOutOfBoundException e){}
        return "";
    }
    
    public String toStringCompressed()
    {
		String str = height+" "+width;
        for(int i=0; i<height; i++){
            str = str + ",";
            ListNode<Integer> current = array1[i].getHead();

            for(int j=0; current.getElement()!=-1; j++){
                str = str + " " + current.getElement();
                current = current.getNext();
                if(current==null)
                {
                    break;
                }
            }
            str = str + " -1";
        }
        return str;
    }

    public static void main(String[] args) {
    	// testing all methods here :
    	boolean success = true;

    	// check constructor from file
    	CompressedImageInterface img1 = new LinkedListImage("sampleInputFile.txt");

    	// check toStringCompressed
    	String img1_compressed = img1.toStringCompressed();
    	String img_ans = "16 16, -1, 5 7 -1, 3 7 -1, 2 7 -1, 2 2 6 7 -1, 6 7 -1, 6 7 -1, 4 6 -1, 2 4 -1, 2 3 14 15 -1, 2 2 13 15 -1, 11 13 -1, 11 12 -1, 10 11 -1, 9 10 -1, 7 9 -1";
    	success = success && (img_ans.equals(img1_compressed));

    	if (!success)
    	{
    		System.out.println("Constructor (file) or toStringCompressed ERROR");
    		return;
    	}

    	// check getPixelValue
    	boolean[][] grid = new boolean[16][16];
    	for (int i = 0; i < 16; i++)
    		for (int j = 0; j < 16; j++)
    		{
                try
                {
        			grid[i][j] = img1.getPixelValue(i, j);                
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
    		}

    	// check constructor from grid
    	CompressedImageInterface img2 = new LinkedListImage(grid, 16, 16);
    	String img2_compressed = img2.toStringCompressed();
    	success = success && (img2_compressed.equals(img_ans));

    	if (!success)
    	{
    		System.out.println("Constructor (array) or toStringCompressed ERROR");
    		return;
    	}

    	// check Xor
        try
        {
        	img1.performXor(img2);       
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
    	for (int i = 0; i < 16; i++)
    		for (int j = 0; j < 16; j++)
    		{
                try
                {
        			success = success && (!img1.getPixelValue(i,j));                
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
    		}

    	if (!success)
    	{
    		System.out.println("performXor or getPixelValue ERROR");
    		return;
    	}

    	// check setPixelValue
    	for (int i = 0; i < 16; i++)
        {
            try
            {
    	    	img1.setPixelValue(i, 0, true);            
            }
            catch (PixelOutOfBoundException e)
            {
                System.out.println("Errorrrrrrrr");
            }
        }

    	// check numberOfBlackPixels
    	int[] img1_black = img1.numberOfBlackPixels();
    	success = success && (img1_black.length == 16);
    	for (int i = 0; i < 16 && success; i++)
    		success = success && (img1_black[i] == 15);
    	if (!success)
    	{
    		System.out.println("setPixelValue or numberOfBlackPixels ERROR");
    		return;
    	}

    	// check invert
        img1.invert();
        for (int i = 0; i < 16; i++)
        {
            try
            {
                success = success && !(img1.getPixelValue(i, 0));            
            }
            catch (PixelOutOfBoundException e)
            {
                System.out.println("Errorrrrrrrr");
            }
        }
        if (!success)
        {
            System.out.println("invert or getPixelValue ERROR");
            return;
        }

    	// check Or
        try
        {
            img1.performOr(img2);        
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
            {
                try
                {
                    success = success && img1.getPixelValue(i,j);
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
            }
        if (!success)
        {
            System.out.println("performOr or getPixelValue ERROR");
            return;
        }

        // check And
        try
        {
            img1.performAnd(img2);    
        }
        catch (BoundsMismatchException e)
        {
            System.out.println("Errorrrrrrrr");
        }
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
            {
                try
                {
                    success = success && (img1.getPixelValue(i,j) == img2.getPixelValue(i,j));             
                }
                catch (PixelOutOfBoundException e)
                {
                    System.out.println("Errorrrrrrrr");
                }
            }
        if (!success)
        {
            System.out.println("performAnd or getPixelValue ERROR");
            return;
        }

    	// check toStringUnCompressed
        String img_ans_uncomp = "16 16, 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1, 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1, 1 1 1 0 0 0 0 0 1 1 1 1 1 1 1 1, 1 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1, 1 1 0 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1, 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 1, 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1, 1 1 0 0 1 1 1 1 1 1 1 1 1 1 0 0, 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0 0, 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 1, 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1, 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1, 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1, 1 1 1 1 1 1 1 0 0 0 1 1 1 1 1 1";
        success = success && (img1.toStringUnCompressed().equals(img_ans_uncomp)) && (img2.toStringUnCompressed().equals(img_ans_uncomp));
        if (!success)
        {
            System.out.println("toStringUnCompressed ERROR");
            return;
        }
        else
            System.out.println("ALL TESTS SUCCESSFUL! YAYY!");
    }
}