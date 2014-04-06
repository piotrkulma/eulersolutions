package projecteuler.utils;

public class StringMath {
	
	public static final String ZERO = "0";
	public static final String EMPTY_STRING = "";
	
    public static String add(String a, String b)
    {
        int memory = 0;
        int par1, par2, res;

        String result = EMPTY_STRING;

        String ps[] = Utils.prepareStrings(a, b);
        a = ps[0];
        b = ps[1];

        for (int i = 0; i < a.length(); i++)
        {
            par1 = Utils.intFromChar(a.charAt((a.length() - 1) - i));
            par2 = Utils.intFromChar(b.charAt((b.length() - 1) - i));

            res = memory + par1 + par2;
            memory = 0;

            if (res >= 10 && i < (a.length() - 1))
            {
                memory = 1;
                res = res - 10;
            }

            result = res + result;
        }

        return result;
    }
	
    public static String sub(String a, String b)
    {
        int memory = 0;
        int par1, par2, res;            

        String result = "";

        String ps[] = Utils.prepareStrings(a, b);
        a = ps[0];
        b = ps[1];

        for (int i = 0; i < a.length(); i++)
        {
            par1 = Utils.intFromChar(a.charAt((a.length() - 1) - i));
            par2 = Utils.intFromChar(b.charAt((b.length() - 1) - i));

            if (memory > 0)
            {
                if (par1 > 0)
                {
                    par1 = par1 - memory;
                    memory = 0;
                }
                else
                {
                    par1 = 9;
                    memory = 1;
                }
            }

            if (par1 < par2)
            {                   
                par1 += 10;
                memory = 1;
            }

            res = (par1 - par2);
            result = res + result;
        }

        return Utils.removeFirst(result, '0');
    }
	
    public static String multiply(String a, String b)
    {
        int memory = 0;
        int par1, par2, res, temp;

        String ret = "0";
        String result = "";
        String[] results;

        String[] psm = Utils.prepareStringsMult(a, b);
        a = psm[0];
        b = psm[1];
        
        results = new String[b.length()];

        for (int i = 0; i < b.length(); i++)
        {
            memory = 0;
            result = "";
            par2 = Utils.intFromChar(b.charAt((b.length() - 1) - i));

            for (int j = 0; j < a.length(); j++)
            {
                par1 = Utils.intFromChar(a.charAt((a.length() - 1) - j));

                res = memory + (par1 * par2);
                memory = 0;

                if (res >= 10 && j < (a.length() - 1))
                {
                    temp = res % 10;
                    memory = (res - memory) / 10;
                    res = temp;
                }

                result = res + result;
            }

            results[i] = result + Utils.zeros(i);
        }

        for (int i = 0; i < results.length; i++)
        {
            if (results[i] != null)
                ret = add(results[i], ret);
        }

        return ret;
    }
    
    public static String naiveIntegerDivision(String a, String b)
    {
    	int i = 0;
    	
    	char actual;
    	
    	String sub, res = "";
    	String temp = EMPTY_STRING;
    	String result = EMPTY_STRING;
    	String decimal;
	
        while(i < 100){      	
        	if(i >= a.length()) {           	
        		if(temp.equals(ZERO)) {
        			break;
        		} else {
        			if(result.equals(EMPTY_STRING)) {
        				result = "0.";
        			}
        			actual = '0';
        		}
        	} else {
        		actual = a.charAt(i);
        	}
        	
            if (!temp.equals(ZERO))
            {
                temp += actual;
            }
            res = Utils.integerDiv(temp, b);
                        
            if (!res.equals(ZERO))
            {
                result += res;
                sub = OperationSub(temp, multiply(res, b));
                temp = "";
                
                if(!sub.equals(ZERO)) {
                	temp += sub;
                }
            } else if (res.equals(ZERO) && !result.equals(EMPTY_STRING) && !temp.equals("0"))
            {
                result += ZERO;
            }
            
            i++;
            
            if(result.length() > 2) {
            	decimal = result.substring(2);
            	System.out.println(result.split(decimal).length);
            }
            
        }

        return result;
    }
    
    public static String OperationSub(String a, String b)
    {
        int cmp;
        int siga = Utils.signum(a);
        int sigb = Utils.signum(b);
        String minus = "-";

        a = Utils.removeFirst(a, '-');
        b = Utils.removeFirst(b, '-');

        cmp = Utils.compare(a, b);           

        if (siga > 0 && sigb > 0)
        {
            if (cmp < 0) return sub(a, b);
            else if (cmp > 0) return minus + sub(b, a);
            else return ZERO;
        }
        else if (siga < 0 && sigb < 0)
        {
            if (cmp < 0) return minus + sub(a, b);
            else if (cmp > 0) return sub(b, a);
            else return ZERO;
        }
        else if (siga > 0 && sigb < 0)
        {
            return add(a, b);
        }
        else if (siga < 0 && sigb > 0)
        {
            return minus + add(a, b);
        }

        return ZERO;
    }
}
