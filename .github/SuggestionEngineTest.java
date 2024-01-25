import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuggestionEngineTest {

    @Test
    public void testGenerateSuggestions() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        Path testDictionaryFile = Paths.get("src/test/resources/test-words.txt");

        // Load a test dictionary
        suggestionEngine.loadDictionaryData(testDictionaryFile);

        // Test cases
        assertEquals("apple\napply\nappler", suggestionEngine.generateSuggestions("aple"));
        assertEquals("", suggestionEngine.generateSuggestions("apple")); // Known word, should return an empty string
        assertEquals("java", suggestionEngine.generateSuggestions("jvaa")); // Transpose and replace

        // Add more test cases as needed
    }
}