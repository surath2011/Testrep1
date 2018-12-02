package datasheet.handeler;

public class ColumnByAlphabet {
	public String getExcelColumnName(int number) 
	{
        final StringBuilder sb = new StringBuilder();

        int num = number - 1;
        while (num >=  0) {
            int numChar = (num % 26)  + 65;
            sb.append((char)numChar);
            num = (num  / 26) - 1;
        }
        return sb.reverse().toString();
    }
}
