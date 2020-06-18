package builders;

import java.util.HashMap;
import java.util.Map;

public class Builders {

    public Map<String, String> bodyBuilder (String id, String title, String author) {
        Map<String, String> body = new HashMap<String, String>();
        body.put("id", id);
        body.put("title", title);
        body.put("author", author);
        return body;
}
}
