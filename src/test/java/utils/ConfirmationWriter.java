package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ConfirmationWriter {

    public static void saveConfirmationId(String confirmationId) {
        try {
            Path folder = Paths.get("target", "confirmation");
            Files.createDirectories(folder);

            Path file = folder.resolve("confirmation-id.txt");
            Files.writeString(
                    file,
                    confirmationId,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to save confirmation ID to file.", e);
        }
    }
}
