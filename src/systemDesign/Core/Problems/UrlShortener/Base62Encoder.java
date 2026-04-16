package systemDesign.Core.Problems.UrlShortener;

public class Base62Encoder {
    private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long num)
    {
        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while(num > 0)
        {
            int temp = (int) (num % 62);
            sb.append(CHARS.charAt((temp)));
            num /= 62;
        }
        return sb.reverse().toString();
    }
}
