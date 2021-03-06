
/*
Sachal Malick
APCS1 pd5
HW44
2015-13-08
 */

public class Hexadecimal implements Comparable{
	String s;
    private int _decNum;
    private String _hexNum;
	
private final static String HEXDIGITS = "0123456789ABCDEF";

public Hexadecimal() { 
	
	_decNum = 0;
	_hexNum = "0";
}


/*=====================================
  overloaded constructor
  pre:  n >= 0
  post: sets _decNum to n, _binNum to equiv string of bits
  =====================================*/
public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
}


/*=====================================
  overloaded constructor
  pre:  s is String representing non-negative binary number
  post: sets _binNum to input, _decNum to decimal equiv
  =====================================*/
public Hexadecimal( String s ) {
	_hexNum = s;
	_decNum = Integer.parseInt(hexToDec(s));
}

public static int highPower(int n) {
    
	int count = 0;
	int cop = n;
	while (cop > 15) {
		cop = cop - (cop % 16);
		cop/=16;
		count+=1;
	}
	return count;
	
}



public static String decToHex ( int n) {
	
	int cop = n;
	String count = "";
	while (cop > 15) {
		int s = highPower(cop);
		int temp = (int)(cop / Math.pow(16,s));
		count = count + HEXDIGITS.substring(temp,temp+1); 
		cop = cop - (int)(temp * Math.pow(16,s)); 
		
	}
	
	return "" + (count + HEXDIGITS.substring(cop, cop + 1));	
}

public static String decToHexRecHelp (int n, String count) {
	if (n > 15) {
		int s = highPower(n);
		int temp = (int)(n / Math.pow(16,s));
		count = count + HEXDIGITS.substring(temp,temp+1); 
		n = n - (int)(temp * Math.pow(16,s));
		return decToHexRecHelp(n,count);
		
	}
	
	else {
		return "" + (count + HEXDIGITS.substring(n, n + 1));	

	}
}

public static String decToHexRec(int n){
	return decToHexRecHelp(n,"");
}

public static String hexToDec(String s) {
	int count = 0;
	for (int i = 0; i < s.length(); i++) {
		int temp = s.length() - 1 - i;
		int y = HEXDIGITS.indexOf(s.charAt(i));
		count = count + y * (int)(Math.pow(16,temp));
		
	}
	return "" + count;
}



public static String hexToDecRecHelp(String s, int count){

	 if (s.length() == 0) {
		 return "" + count;
	 }
	 else {
		 
		 int temp = s.length() - 1;
			int y = HEXDIGITS.indexOf(s.substring(0,1));
			count = count + y * (int)(Math.pow(16,temp));

			return hexToDecRecHelp(s.substring(1), count);

	 }
	 
 
	
}

public String toString() {
	return _hexNum;
}

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
	try {
		
		if (other instanceof Hexadecimal) {
		
				Hexadecimal s = (Hexadecimal)other;
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
		
		if (other instanceof Rational) {
			Rational temp = (Rational)other;
			double temp_a = temp.floatValue();
			if((this._decNum == (int)temp_a)) {
			return 0;
			}
			else if(this._decNum > (int)temp_a){
			return 1;
			} 
			else {
			return -1;
			}
		}
		
		else{
			Binary s = (Binary)other;
			if (this._decNum == (s.get_decNum())) {
				return 0;
			}
			if (this._decNum < (s.get_decNum())) {
				return -1;
			}
			else {
				return 1;
			}
			
		}


	}
	
	catch (NullPointerException e) {
		
		System.out.println("ERROR, NO USING NULL THINGIES OKKK???");
		throw new NullPointerException("Null pointer");
	}
	
	catch (ClassCastException e) {
		System.out.println("Wrong casting");
		throw new ClassCastException("class casting");
	}
	

}



public int get_decNum() {
	return _decNum;
}


public void set_decNum(int _decNum) {
	this._decNum = _decNum;
}


public String get_hexNum() {
	return _hexNum;
}


public void set_hexNum(String _hexNum) {
	this._hexNum = _hexNum;
}


public static String getHexdigits() {
	return HEXDIGITS;
}


public static String hexToDecRec(String s) {
	try {
		return hexToDecRecHelp(s,0);

	}
	
	catch (NullPointerException e) {
		
		return "ERROR, NO USING NULL THINGIES OKKK???";
	}
}
public static void main (String[] args){
	Hexadecimal ha = new Hexadecimal();
	
	System.out.println(highPower(70000));

	System.out.println(decToHex(752));
	int temp = (int)(257 / Math.pow(16,2));
	System.out.println(temp);

	System.out.println(decToHexRec(751));
	
	Hexadecimal h = new Hexadecimal(30);
	Hexadecimal e = new Hexadecimal("1E");

	System.out.println(h);
	System.out.println(h.compareTo(e));
	System.out.println(h.equals(e));
	
	
	Hexadecimal dog = new Hexadecimal(8);
	Binary cat = new Binary ("10000");
	System.out.println("Comparing hex to bin");
	System.out.println(dog.compareTo(cat));
	Rational mouse = new Rational (8,1);
	System.out.println("comparing hex to rational");
	System.out.println(dog.compareTo(mouse));
	



}
	
}
