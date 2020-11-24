public class UrlFixer {
    public static void main(String... args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        url = url.replaceFirst("s", "s:");
        url = url.replace("bots", "odds");

        String url2 = "https//www.reddit.com/r/nevertellmethebots";
        url2 = url2.substring(0, 5) + ":" + url2.substring(5, 38) + "odds";

        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
        // Also, the URL is missing a crucial component, find out what it is and insert it too!
        // Try to solve it more than once using different String functions!

        System.out.println(url);
        System.out.println(url2);

    }
}