import chainofresponsibility.Handler;
import chainofresponsibility.Handler20;
import chainofresponsibility.Handler5;
import chainofresponsibility.Handler50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CORTest {
    @Test
    public void TestAIN() {
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        Assertions.assertDoesNotThrow(() -> handler50.process(105));
    }
    @Test
    public void TestAINException() {
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> handler50.process(126));
    }
}
