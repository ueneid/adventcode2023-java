package com.ueneid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Resource {

    public static String resourceAsText(String fileName) {
        URI uri = toURI(fileName);
        try (InputStream inputStream = uri.toURL().openStream()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator())).trim();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource file: " + fileName, e);
        }
    }

    public static List<String> resourceAsListOfString(String fileName) {
        URI uri = toURI(fileName);
        try (InputStream inputStream = uri.toURL().openStream()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource file: " + fileName, e);
        }
    }

    public static List<String> resourceAsListOfBunchOfString(String fileName, String separator) {
        String content = resourceAsText(fileName);
        return Arrays.asList(content.split(separator));
    }

    public static List<Integer> resourceAsListOfInt(String fileName) {
        List<String> lines = resourceAsListOfString(fileName);
        return lines.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<String> resourceAsListOfBunchOfString(String fileName) {
        return resourceAsListOfBunchOfString(fileName, "\n\n");
    }

    private static URI toURI(String resourcePath) {
        try {
            URI uri = Resource.class.getClassLoader().getResource(resourcePath).toURI();
            return uri;
        } catch (URISyntaxException | NullPointerException e) {
            throw new IllegalArgumentException("Cannot find resource: " + resourcePath);
        }
    }
}
