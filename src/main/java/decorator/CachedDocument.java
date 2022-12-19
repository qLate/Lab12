package decorator;

public class CachedDocument implements Document {
    private final Document document;
    public String gcsPath;

    public CachedDocument(Document document, String gcsPath) {
        this.document = document;
        this.gcsPath = gcsPath;
    }
    @Override
    public String parse() {
        var cachedDocuments = Database.instance.getCachedDocuments();
        if (cachedDocuments.containsKey(gcsPath)) {
            System.out.println("Returning cached version...");
            return cachedDocuments.get(gcsPath);
        }

        System.out.println("Parsing and caching the document...");
        String parsed = document.parse();
        cachedDocuments.put(gcsPath, parsed);
        return parsed;
    }
}
