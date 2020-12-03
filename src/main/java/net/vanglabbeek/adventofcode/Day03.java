package net.vanglabbeek.adventofcode;

import com.google.common.flogger.FluentLogger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day03 {
    private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();

    List<Integer> values;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Day03 day01 = new Day03();
    }

    public Day03() throws IOException, URISyntaxException {
        List<String> input = readInputFile("/03/input");

        int slope_x = 3;
        int slope_y = 1;

        long trees1 = getTreesInSlope(input, 1, 1);
        long trees2 = getTreesInSlope(input, 3, 1);
        long trees3 = getTreesInSlope(input, 5, 1);
        long trees4 = getTreesInSlope(input, 7, 1);
        long trees5 = getTreesInSlope(input, 1, 2);


        LOGGER.atInfo().log("Antwoord part 1: %d", trees2);
        LOGGER.atInfo().log("Antwoord part 2: %d", trees1 * trees2 * trees3 * trees4 * trees5);

    }

    private int getTreesInSlope(List<String> input, int slope_x, int slope_y) {
        int lines = input.size();
        int linelength = input.get(0).length();

        System.out.println(lines + " - " + linelength);


        int x = 0;

        int trees = 0;

        for (int y = 0; y < lines - 1; ) {
            y += slope_y;
            x += slope_x;
            x %= linelength;

            if (input.get(y).charAt(x) == '#') {
                trees++;
            }
        }
        LOGGER.atInfo().log("Aantal bomen voor slope (%d, %d): %d", slope_x, slope_y, trees);
        return trees;
    }

    private List<String> readInputFile(String filename) throws URISyntaxException, IOException {
        URL resource = getClass().getResource(filename);
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath());
        return lines;
    }
}
