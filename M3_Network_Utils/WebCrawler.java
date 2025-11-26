import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public static void main(String[] args) {
        //System.setProperty("sun.net.client.defaultConnectTimeout", "500");
        //System.setProperty("sun.net.client.defaultReadTimeout",    "1000");
        String url = "https://www.erciyes.edu.tr/";
        crawler(url); // Traverse the Web from the a starting url
    }
    public static void crawler(String startingURL) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();    //list of URLs to visit
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();  //list of visited URLs

        listOfPendingURLs.add(startingURL);
        //While pending URLs list is not empty. And we set a limit (100)
        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            listOfTraversedURLs.add(urlString);
            System.out.println("Crawl " + urlString);

            //for each url that found in visited url
            for (String s: getSubURLs(urlString)) {
                if (!listOfTraversedURLs.contains(s) && !listOfPendingURLs.contains(s))
                    listOfPendingURLs.add(s);
                //If the finding URL is not in traversed and pending URLs list then add it to the pending list
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();
        //Regular expression that accept valid URLs
        String regexp = "(http|https)://(\\w+\\.)+(edu|com|gov|org)(\\.tr)?";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher;
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                matcher = pattern.matcher(line);
                while (matcher.find()){
                    list.add(matcher.group());
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }

    //This another way to get SubURLs without using regular expressions but not a good one
    public static ArrayList<String> getSubURL2s(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
