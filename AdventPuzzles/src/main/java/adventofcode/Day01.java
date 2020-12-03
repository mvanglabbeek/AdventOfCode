package adventofcode;

import com.google.common.flogger.FluentLogger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {
    private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();

    List<Integer> values;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Day01 day01 = new Day01();
    }

    public Day01() throws IOException, URISyntaxException {
        List<String> input = readInputFile("/01/input");
        List<Integer> values = input.stream().map(Integer::valueOf).collect(Collectors.toList());

        values.forEach(value -> {
            values.forEach(value2 -> {
                values.forEach(value3 -> {
                    if (value + value2 + value3 == 2020) {
                        LOGGER.atInfo().log("Gevonden getallen: %d, %d en %d. Vermenigvuldigd: %d", value, value2, value3, (value * value2 * value3));
                    }
                });
            });
        });
    }

    private List<String> readInputFile(String filename) throws URISyntaxException, IOException {
        URL resource = getClass().getResource(filename);
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath());
        return lines;
    }
}
