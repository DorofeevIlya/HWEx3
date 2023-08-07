package Ex3;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public void contactWrite(ContactData contact) throws IOException {
        String filename = contact.getLastName() + ".txt";
        String data = contact.toString();
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            throw new IOException("Ошибка записи файла", e);
        }
    }
}
