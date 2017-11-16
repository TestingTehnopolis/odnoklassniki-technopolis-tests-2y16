package helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import model.TestBot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by ihb on 11.04.17.
 */
public class ResourceLoader {

    private static final String DATA_OK_USERS_JSON = "testBots.json";

    private static Map<String, TestBot> TestBots;

    static {
        loadBots();
    }

    @SneakyThrows
    private static void loadBots() {
        String rawData = getRawData(DATA_OK_USERS_JSON);
        Type type = new TypeToken<Map<String, TestBot>>() {
        }.getType();
        TestBots = new Gson().fromJson(rawData, type);
    }

    private static String getRawData(String path) throws IOException {
        File file = new File("src/test/resources/" + path);
        return FileUtils.readFileToString(file, "utf-8");
    }

    public static TestBot getTestBot(String key) {
        return TestBots.get(key);
    }
}
