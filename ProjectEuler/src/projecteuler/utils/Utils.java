package projecteuler.utils;

public class Utils {
	
    public static int intFromChar(char c)
    {
        return ((int)c) - 48;
    }
    
    public static String zeros(int n)
    {
    	String zeros = "";
        for (int i = 0; i < n; i++)
        {
            zeros += "0";
        }

        return zeros;
    }

    public static int signum(String str)
    {
        if (str.charAt(0) == '-')
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    
    public static String[] prepareStrings(String a, String b)
    {
        if (a.length() != b.length())
        {
            if (a.length() > b.length())
            {
                b = zeros(a.length() - b.length()) + b;
            }
            if (b.length() > a.length())
            {
                a = zeros(b.length() - a.length()) + a;
            }
        }
        
        return new String[] {a, b};
    }
    
    public static String[] prepareStringsMult(String a, String b)
    {
        String temp;
        if (b.length() > a.length())
        {
            temp = b;
            b = a;
            a = temp;
        }
        
        return new String[] {a, b};
    }

    public static String removeFirst(String str, char c)
    {
        if (str.charAt(0) == c)
        {
            int count = 0;
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == c)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }

            str = str.substring(count);

        }
        
        return str;
    }
	
    public static int compare(String a, String b)
    {
        if (a.length() != b.length())
        {
            if (a.length() > b.length())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            for (int i = 0; i < a.length(); i++)
            {
                int p1 = intFromChar(a.charAt(i));
                int p2 = intFromChar(b.charAt(i));

                if (p1 > p2) return -1;
                else if (p1 < p2) return 1;
            }

            return 0;
        }
    }
    
    public static String integerDiv(String a, String b)
    {
    	String counter = "0";

        while (compare(a, b) == -1 || compare(a, b) == 0)
        {
            a = StringMath.sub(a, b);
            counter = StringMath.add(counter, "1");
        }

        return counter;
    }
}
