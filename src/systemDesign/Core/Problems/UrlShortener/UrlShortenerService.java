package systemDesign.Core.Problems.UrlShortener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortenerService {
    private Map<String, String> shortToLong;
    private Map<String, String> longToShort;
    private static final String BASEURL = "https://bit.ly/";
    private AtomicLong ID = new AtomicLong(1);
    public UrlShortenerService()
    {
        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();
    }

    public String shorten(String longUrl)
    {
        if(longToShort.containsKey(longUrl))
        {
            return BASEURL + longToShort.get(longUrl);
        }

        long id = ID.getAndIncrement();
        String encodedId = Base62Encoder.encode(id);
        shortToLong.put(encodedId, longUrl);
        longToShort.put(longUrl, encodedId);

        return BASEURL + encodedId;
    }

    public String redirect(String shortUrl)
    {
        String encodedId = shortUrl.replace(BASEURL, "");

        return shortToLong.getOrDefault(encodedId, "");
    }
}
