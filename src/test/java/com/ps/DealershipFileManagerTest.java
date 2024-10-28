package com.ps;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {
    import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class DealershipFileManagerTest {

        @Test
        void testSaveDealership() {
            // Arrange
            Dealership dealership = new Dealership("Sample Dealership", "123 Sample St.", "555-5555");

            // Act
            DealershipFileManager.saveDealership(dealership);

            // Assert
            try (BufferedReader reader = new BufferedReader(new FileReader("inventoryTest.csv"))) {
                String line = reader.readLine();
                assertEquals("Sample Dealership|123 Sample St.|555-5555", line,
                        "File content did not match the expected output.");
            } catch (IOException e) {
                e.printStackTrace();
                fail("Exception thrown while reading the file.");
            }
        }
    }


}