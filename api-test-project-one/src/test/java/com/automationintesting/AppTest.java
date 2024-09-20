package com.automationintesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    
    @Test
    public void testApp() {
        App app = new App();
        assertTrue(app.isWorking(), "アプリが動作しています");
    }
}

