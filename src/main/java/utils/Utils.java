package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.cdimascio.dotenv.Dotenv;
import models.LoginUser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {


    public static Dotenv dotEnv(){
        return Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    public static void waitForSeconds(double seconds){
        try {
            Thread.sleep((long)seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LoginUser> getDataFromJson(){
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get("src/test/resources/user.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(reader, new TypeToken<List<LoginUser>>(){}.getType());
    }


}
