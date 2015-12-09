
public interface ListInt {
    //adds an item after the last item

    public void add( int newVal );
    
    
    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal );
    
  //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index );
    
    //return number of meaningful items in _data

    public int size();
    
    
    

}