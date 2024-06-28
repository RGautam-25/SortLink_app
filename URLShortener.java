import java.util.HashMap;
import java.util.Map;

public class URLShortener{
    private Map<String, String> shortToLongURLs;
    private Map<String, String> longToShortURLs;

    public URLShortener() {
        shortToLongURLs = new HashMap<>();
        longToShortURLs = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        if (longToShortURLs.containsKey(longURL)) {
            return longToShortURLs.get(longURL);
        }

        String shortURL = generateShortURL();
        shortToLongURLs.put(shortURL, longURL);
        longToShortURLs.put(longURL, shortURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        if (!shortToLongURLs.containsKey(shortURL)) {
            throw new IllegalArgumentException("Invalid short URL");
        }
        return shortToLongURLs.get(shortURL);
    }

    private String generateShortURL() {
        // Simple hash function to generate a short URL
        int hashCode = (int) (Math.random() * Integer.MAX_VALUE);
        return "http://short.url/" + Integer.toHexString(hashCode);
    }
}