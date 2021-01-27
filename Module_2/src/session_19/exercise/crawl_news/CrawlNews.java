package session_19.exercise.crawl_news;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    private static final String REGEX = "<a data-utm=\"Cate_TheGioi\\|Box_EUNga\\|[\\d]\" title=\"(.*?)\"";
    public static void getNews(URL url){
        try {
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n", "");
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(content);
            int i = 1;
            while (matcher.find()) {
                System.out.println(i+". "+ matcher.group(1));
                i++;
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        String source = "https://dantri.com.vn/the-gioi.htm";
        URL url = new URL(source);
        getNews(url);
    }
}
