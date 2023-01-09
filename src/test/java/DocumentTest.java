import decorator.CachedDocument;
import decorator.Document;
import decorator.SmartDocument;
import decorator.TimedDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DocumentTest {
    @Test
    public void TestSmartDocument() {
        Document document = new SmartDocument("gs://lab_12oop/Screenshot 2022-12-05 105619.png");
        String out = document.parse();
        Assertions.assertEquals(out.substring(0, 10), "9. Власник");
    }

    @Test
    public void TestTimedDocument() {
        Document document = new SmartDocument("gs://lab_12oop/Screenshot 2022-12-05 105619.png");
        document = new TimedDocument(document);
        String out = document.parse();
        Assertions.assertEquals(out.substring(0, 10), "9. Власник");
    }

    @Test
    public void CachedDocument() {
        Document document = new SmartDocument("gs://lab_12oop/Screenshot 2022-12-05 105619.png");
        document = new CachedDocument(document,"gs://lab_12oop/Screenshot 2022-12-05 105619.png");
        String out = document.parse();
        Assertions.assertEquals(out.substring(0, 10), "9. Власник");
    }
}
