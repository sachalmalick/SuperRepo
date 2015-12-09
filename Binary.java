//skeleton file for class Binary
/*
Sachal Malick
APCS1 pd5
HW43
2015-12-08
 */
public class Binary {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
    	
    	_decNum = 0;
    	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
    	_decNum = n;
    	_binNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
    	_binNum = s;
    	_decNum = Integer.parseInt(binToDec(s));
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() {
    	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
	//this is a helper function that returns the highest power of 2 present in an integer n
    public static int highPower(int n) {
    
    	int count = 0;
    	int cop = n;
    	while (cop > 1) {
    		cop = cop - (cop % 2);
    		cop/=2;
    		count+=1;
    	}
    	return count;
    	
    }
    
    
    public static String decToBin( int n ) {
    	int cop = n;
    	int count = 0;
    	while (highPower(cop) > 0) {
    		
    		count = count + (int)Math.pow(10,highPower(cop));
    		cop = cop - (int)Math.pow(2,highPower(cop));
    		
    	}
    	
    	return "" + (count + cop);
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
     
      12 / 2 = 6
      6  / 2 = 3
      
      
      
      
      12
      6
      4
      2
      2
      =====================================*/
    public static String decToBinRR( int n, int count ) {
    	  
    	  if (highPower(n) > 0) {
    		count = count + (int)Math.pow(10,highPower(n));
  		 n = n - (int)Math.pow(2,highPower(n));
  		 return decToBinRR(n,count);
    	  }
    	  
    	  else {
    		  return "" + (count + n);

    	  }
        	
        	
        }
    
    public static String decToBinR( int n ) { 
    	
    	return decToBinRR(n,0);
    	
    	
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static String binToDec( String s ) {
      	int count = 0;
      	for (int i = 0; i < s.length(); i++) {
      		int temp = Integer.parseInt(s.substring(i, i+1));
      		count = count + temp*(int)(Math.pow(2,(s.length() - i - 1)));
      	}
      	return "" + count;
      }


 public static String binToDecRHelp( String s , int count) { 
	 
	 if (s.length() == 0) {
		 return "" + count;
	 }
	 else {
		 int temp = Integer.parseInt(s.substring(0, 1));
   		count = count + temp*(int)(Math.pow(2,(s.length() - 1)));
   		return binToDecRHelp(s.substring(1), count);
	 }
    	
    }
    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static String binToDecR( String s ) { 
    	
    	return binToDecRHelp(s,0);
    	
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
    	if (compareTo(other) == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
    	Binary s = (Binary)other;
    	if (this._decNum == (s._decNum)) {
    		return 0;
    	}
    	if (this._decNum < (s._decNum)) {
    		return -1;
    	}
    	else {
    		return 1;
    	}

    }


    //main method for testing
    public static void main( String[] args ) {

    }//end main()

} //end class