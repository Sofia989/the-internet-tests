package theinternet.core;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestResultLogger implements TestWatcher {

    Logger logger = LoggerFactory.getLogger(TestResultLogger.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("Test passed: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object instance = context.getRequiredTestInstance();
        if (instance instanceof TestBase) {
            ((TestBase) instance).testPassed = false;
        }
        logger.warn("Test failed: " + context.getDisplayName());
    }
}




