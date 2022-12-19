package decorator;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://lab_12oop/Screenshot 2022-12-05 105619.png");
//        document = new TimedDocument(document);
        document = new CachedDocument(document, "gs://lab_12oop/Screenshot 2022-12-05 105619.png");
        System.out.println(document.parse());
        System.out.println(document.parse());
    }
}
