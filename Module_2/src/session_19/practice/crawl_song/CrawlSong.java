package session_19.practice.crawl_song;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSong {
    private static final String REGEX = "name_song\">(.*?)</a>";
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            content = content.replaceAll("\\n","");
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(content);
            int i = 1;
            while (m.find()) {
                System.out.println(i+". "+m.group(1));
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
}










