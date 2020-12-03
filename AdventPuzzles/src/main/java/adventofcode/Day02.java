package adventofcode;

import com.google.common.flogger.FluentLogger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day02 {
    private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();

    List<Integer> values;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Day02 day01 = new Day02();
    }

    public Day02() throws IOException, URISyntaxException {
        List<String> input = readInputFile("/02/input");

        AtomicInteger validPart1 = new AtomicInteger();
        AtomicInteger validPart2 = new AtomicInteger();
        input.forEach(line -> {
            String[] splitted = line.split(" ");
            char character = splitted[1].replaceAll(":", "").charAt(0);
            String password = splitted[2];
            String cleanedPwd = password.replaceAll("[^" + character + "]", "");
            System.out.println(line);
            String[] validator = splitted[0].split("-");
            int firstNumber = Integer.valueOf(validator[0]);
            int secondNumber = Integer.valueOf(validator[1]);
            if (cleanedPwd.length() >= firstNumber && cleanedPwd.length() <= secondNumber) {
                LOGGER.atInfo().log("Geldig wachtwoord voor part 1: %s", line);
                validPart1.getAndIncrement();
            }
            if ((character == password.charAt(firstNumber - 1)) ^ (character == password.charAt(secondNumber - 1))) {
                LOGGER.atInfo().log("Geldig wachtwoord voor part 2: %s", line);
                validPart2.getAndIncrement();
            }

        });
        LOGGER.atInfo().log("Geldig aantal wachtwoorden part 1: %d", validPart1.get());
        LOGGER.atInfo().log("Geldig aantal wachtwoorden part 2: %d", validPart2.get());
    }

    private List<String> readInputFile(String filename) throws URISyntaxException, IOException {
        URL resource = getClass().getResource(filename);
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath());
        return lines;
    }
}
