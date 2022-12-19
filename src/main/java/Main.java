import java.util.logging.Logger;


class Page {
    public String name;
}

class Registry {
    public int deleteReference(String name) {
        return 1;
    }
}

class ConfigKeys {
    public int deleteKey(String name) {
        return 1;
    }
}

class Processor {
    private static final int E_OK = 1;
    private static final int E_ERROR = 2;
    private final Registry registry = new Registry();
    private final ConfigKeys configKeys = new ConfigKeys();
    private final Logger logger = Logger.getLogger(Processor.class.getName());

    public int delete(Page page) {
        if (deletePage(page) != E_OK) {
            logger.info("delete failed");
            return E_ERROR;
        }

        if (registry.deleteReference(page.name) != E_OK) {
            logger.info("deleteReference from registry failed");
            return E_ERROR;
        }

        if (configKeys.deleteKey(page.name) != E_OK) {
            logger.info("configKey not deleted");
            return E_ERROR;
        }
        logger.info("page deleted");

        return E_OK;
    }

    private int deletePage(Page page) {
        return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%4$s %2$s %5$s%6$s%n");
        Page page = new Page();
        page.name = "Some Info";
        Processor processor = new Processor();
        processor.delete(page);
    }
}