import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class LastCommit {
    private final String owner = "kalenikov";
    private final String repo = "job4j_tracker";
    private final int limit = 10;
    private final String urlString = String.format("https://api.github.com/repos/%s/%s/commits?per_page=%d",
            owner,
            repo,
            limit);

    public void getCommits() throws IOException, ParseException {
        URL url = new URL(urlString);
        Scanner in = new Scanner((InputStream) url.getContent());
        StringBuilder result = new StringBuilder();
        while (in.hasNext()) {
            result.append(in.nextLine());
        }

        Object obj = new JSONParser().parse(result.toString());
        JSONArray commitArray = (JSONArray) obj;
        for (Object commit : commitArray) {
            System.out.println("--------------");
            JSONObject commitJSON = (JSONObject) commit;
            System.out.println(commitJSON.get("html_url"));
            JSONObject commitInfoJSON = (JSONObject) commitJSON.get("commit");
            System.out.println(commitInfoJSON.get("message"));
        }

    }

    public static void main(String[] args) throws IOException, ParseException {
        new LastCommit().getCommits();
    }

}

