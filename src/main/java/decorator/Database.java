package decorator;

import lombok.Getter;

import java.util.HashMap;

public class Database {
    public static Database instance = new Database();

    @Getter
    private final HashMap<String, String> cachedDocuments = new HashMap<>();
}
