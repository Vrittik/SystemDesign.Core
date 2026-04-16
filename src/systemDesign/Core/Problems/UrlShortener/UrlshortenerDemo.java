package systemDesign.Core.Problems.UrlShortener;

public class UrlshortenerDemo {
    public static void main(String[] args)
    {
        UrlShortenerService urlShortenerService = new UrlShortenerService();

        String longUrl = "https://google.com/search?q=system+design";

        String tinyUrl = urlShortenerService.shorten(longUrl);

        System.out.println("The tiny url = " + tinyUrl);

        String originalUrl = urlShortenerService.redirect(tinyUrl);
        System.out.println("The original url = " + originalUrl);
    }
}
