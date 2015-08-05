package leetcodeOJ;

public class _171ExcelSheetColumnNumber {
	public static void main(String[] args) {
		_171ExcelSheetColumnNumber es = new _171ExcelSheetColumnNumber();
		System.out.println(es.titleToNumber("A"));
		System.out.println(es.titleToNumber("AB"));
		System.out.println(es.titleToNumber("AA"));
	}

	public int titleToNumber(String s) {
        int len = s.length(), value = 0;
        for (int i = 0; i < s.length();) {
        	switch (s.charAt(i)) {
			case 'A': value+=(len==1)?1:Math.pow(26, len-1); len--; i++; continue;
			case 'B': value+=(len==1)?2:Math.pow(26, len-1)*2; len--; i++; continue;
			case 'C': value+=(len==1)?3:Math.pow(26, len-1)*3; len--; i++; continue;
			case 'D': value+=(len==1)?4:Math.pow(26, len-1)*4; len--; i++; continue;
			case 'E': value+=(len==1)?5:Math.pow(26, len-1)*5; len--; i++; continue;
			case 'F': value+=(len==1)?6:Math.pow(26, len-1)*6; len--; i++; continue;
			case 'G': value+=(len==1)?7:Math.pow(26, len-1)*7; len--; i++; continue;
			case 'H': value+=(len==1)?8:Math.pow(26, len-1)*8; len--; i++; continue;
			case 'I': value+=(len==1)?9:Math.pow(26, len-1)*9; len--; i++; continue;
			case 'J': value+=(len==1)?10:Math.pow(26, len-1)*10; len--; i++; continue;
			case 'K': value+=(len==1)?11:Math.pow(26, len-1)*11; len--; i++; continue;
			case 'L': value+=(len==1)?12:Math.pow(26, len-1)*12; len--; i++; continue;
			case 'M': value+=(len==1)?13:Math.pow(26, len-1)*13; len--; i++; continue;
			case 'N': value+=(len==1)?14:Math.pow(26, len-1)*14; len--; i++; continue;
			case 'O': value+=(len==1)?15:Math.pow(26, len-1)*15; len--; i++; continue;
			case 'P': value+=(len==1)?16:Math.pow(26, len-1)*16; len--; i++; continue;
			case 'Q': value+=(len==1)?17:Math.pow(26, len-1)*17; len--; i++; continue;
			case 'R': value+=(len==1)?18:Math.pow(26, len-1)*18; len--; i++; continue;
			case 'S': value+=(len==1)?19:Math.pow(26, len-1)*19; len--; i++; continue;
			case 'T': value+=(len==1)?20:Math.pow(26, len-1)*20; len--; i++; continue;
			case 'U': value+=(len==1)?21:Math.pow(26, len-1)*21; len--; i++; continue;
			case 'V': value+=(len==1)?22:Math.pow(26, len-1)*22; len--; i++; continue;
			case 'W': value+=(len==1)?23:Math.pow(26, len-1)*23; len--; i++; continue;
			case 'X': value+=(len==1)?24:Math.pow(26, len-1)*24; len--; i++; continue;
			case 'Y': value+=(len==1)?25:Math.pow(26, len-1)*25; len--; i++; continue;
			case 'Z': value+=(len==1)?26:Math.pow(26, len-1)*26; len--; i++; continue;
			default:;
			}
		}
        return value;
    }
}
