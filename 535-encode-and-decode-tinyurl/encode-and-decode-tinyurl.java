public class Codec {
    private static int MOD = 10_001;
    private Map<Long, String> map;

    public Codec() {
        this.map = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String baseUrl = longUrl.replaceFirst("^(.*?//[^/]+/).*", "$1");
        String route = longUrl.replaceFirst("^.*?//[^/]+/", "");

        long key = hash(route);

        map.put(key, route);

        return baseUrl + key;
    }

    public String decode(String shortUrl) {
        String baseUrl = shortUrl.replaceFirst("^(.*?//[^/]+/).*", "$1");
        String key = shortUrl.replaceFirst("^.*?//[^/]+/", "");

        return baseUrl + map.get(Long.parseLong(key));
    }

    static long hash(String s) {
        long hash = 0;

        long base = 31;
        long mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * base + s.charAt(i)) % mod;
        }

        return hash;
    }

    // Decodes a shortened URL to its original URL.
    // public String decode(String shortUrl) {
    //     String baseUrl = shortUrl.replaceFirst("^(https?://[^/]+/).*", "$1");
    //     String key = shortUrl.replaceFirst("^https?://[^/]+/", "");

    //     return baseUrl + map.get(Long.parseLong(key));
    // }
}