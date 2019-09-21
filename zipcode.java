
public class Zipcode {
	private int zip;
	private String barcode;
	
	
	public Zipcode(int zziipp) {
		this.zip = zziipp;
		this.zip2bar();
	}
	
	public Zipcode (String bbb) {
		this.barcode = bbb;
		this.bar2zip();
	}
	
	
	public void zip2bar() {
		int sum = 0;
		int zip2 = zip;
		String[] barraaayyy = new String[6];
		for (int i = 0; i < 5; i++) {
			int s = zip2 % 10;
			zip2 = zip2 / 10;
			barraaayyy[i] = dig2bar(s);
			sum += s;
		}
		int checksum = (10 - (sum % 10)) % 10;
		barraaayyy[5] = dig2bar(checksum);
		barcode = "|" + barraaayyy[4] + barraaayyy[3] + barraaayyy[2] + barraaayyy[1] + barraaayyy[0] + barraaayyy[5] + "|";
	}
	
	private String dig2bar(int digit) {
		switch (digit) {
		case 1 : return ":::||";
		case 2 : return "::|:|";
		case 3 : return "::||:";
		case 4 : return ":|::|";
		case 5 : return ":|:|:";
		case 6 : return ":||::";
		case 7 : return "|:::|";
		case 8 : return "|::|:";
		case 9 : return "|:|::";
		case 0 : return "||:::";
		default : return "";
		}
	}
	
	public String getBarcode() {
		return barcode;
	}
	
	
	public void bar2zip() {
		if (barcode.length() != 32) {
			System.out.println("The barcode is faulty.");
			return;
		}
		String barcode2 = barcode;
		barcode2 = barcode2.substring(1, 31);
		int zip2 = 0;
		int sum = 0;
		for (int i = 1; i < 6; i++) {
			String a = barcode2.substring((i-1)*5, i*5);
			int l = bar2dig(a);
			zip2 = zip2*10 + l;
			sum += l;
		}
		int checksum = (10 - (sum % 10)) % 10;
		String g = barcode2.substring(25, 30);
		int h = bar2dig(g);
		if (h == checksum) {
			zip = zip2;
		}
		else {
			System.out.println("The barcode is a faulty one.");
		}
	}
	
	private int bar2dig(String barcode) {
		switch (barcode) {
		case ":::||" : return 1;
		case "::|:|" : return 2;
		case "::||:" : return 3;
		case ":|::|" : return 4;
		case ":|:|:" : return 5;
		case ":||::" : return 6;
		case "|:::|" : return 7;
		case "|::|:" : return 8;
		case "|:|::" : return 9;
		case "||:::" : return 0;
		default : return -1;
		}
	}
	
	public int getZIPcode() {
		return zip;
	}
}
