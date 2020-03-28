package configs;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public Map<String, String> defaultHeaders() {
        Map<String, String> defaultHeadersObj = new HashMap<String, String>();
        defaultHeadersObj.put("Content-Type", "application/json");

        return defaultHeadersObj;
    }

    public Map<String, String> headersWithToken() {
        Map<String, String> defaultHeadersObj = new HashMap<String, String>();
        defaultHeadersObj.put("Content-Type", "application/json");
        defaultHeadersObj.put("Access_Token", "dlskjfajfkdjsaflkdjsfadkl");
        defaultHeadersObj.put("jwt_Token", "dlskjfajfkdjsaflkdjsfadkl");
        defaultHeadersObj.put("Tenent_Token", "test");

        return defaultHeadersObj;
    }
}