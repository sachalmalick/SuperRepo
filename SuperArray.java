
public class SuperArray  {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;
  //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
	Comparable temp = _data[index];
	if(index <= _lastPos){
	    _data[index] = newVal;
	    return temp;
	}
	else{
	    return temp;
	}
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) { 
	if(_size == _data.length){
	    expand();
	    _data[_size] = newVal;
	    _lastPos++;
	    _size++;
	}
	else{
	    _data[_size] = newVal;
	    _lastPos++;
	    _size++;
	}

    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
	if(index <= _size){//The if of chris's stupidity ~Chris. Checks if the insertion index is after lastpos. If it is, it shouldn't work
	    if(_size == _data.length){
		expand();
	    }
	    for(int i = _lastPos; i >= index; i--){
		_data[i + 1] = _data[i];
	    }
	    _lastPos++;
	    _size++;
	    _data[index] = newVal;
	}
	else {
		System.out.println("");
	}
    }

    // a, b, c, d, f
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
    	for (int i = index + 1; i < this._size; i++) {
    		this._data[i-1] = this._data[i];
    	}
	this._lastPos--;
    	this._size--;
    }


    //return number of meaningful items in _data
    public int size() { 
    	
    	return this._size;
    }
    
	public static int linSearch(SuperArray a, Comparable target) {
		
		for (int i = 0; i < a._data.length; i++) {
			if (a._data[i] == target) {
				return i;
			}
		}
		
		return -1;
		}
	
	
	
	
    public static boolean isSorted (SuperArray a) {
    	for (int i = 0; i < a._data.length; i++) {
    		if (a._data[i].compareTo(a._data[i+1]) == -1) {
    			
    		}
    		
    		else {
    			return false;
    		}
    	}
    	
    	return true;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
		int temp = (int)(Math.random() * 3);
		if (temp == 0) {
			Binary a = new Binary(i);
			curtis.add(i,a);	}
	
		else if (temp == 1) {
			Hexadecimal a = new Hexadecimal(i);
			curtis.add(i,a);


	}
	else  {
		
		Rational r = new Rational(i,i+7);
		curtis.add(i,r);



	}
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);


	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);
/*
	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****
	
	
	System.out.println("_____TEST CALLS FOR LINSEARCH AND OTHERS_____");
	
	Binary as = new Binary("101");
	curtis._data[0] = as;
	System.out.println(linSearch(curtis,as));
	System.out.println(isSorted(curtis));
	

    }//end main

		
}//end class