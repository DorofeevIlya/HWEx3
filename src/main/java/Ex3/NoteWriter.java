package Ex3;

import java.io.IOException;
import java.util.Scanner;

public class NoteWriter {
    String inputData;
    String[] splitData;
    public NoteWriter(String inputData) throws IllegalArgumentException {
        this.inputData = inputData;
        //проверяем на этапе создания noteWriter
        try {
            this.splitData = ContactCheck.check(inputData);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException (e);
        }
    }
    public String[] getSplitData() {
        return splitData;
    }
    public static void run() {
        Scanner scan = new Scanner(System.in);
        String readLine;
        System.out.println("Введите данные контакта через пробел в формате Ф И О датарождения номертелефона пол.\n" +
                "НАПРИМЕР: Иванов Иван Иванович 01.01.1999 1234567890 m.\n" +
                "Для возврата в предыдущее меню введите exit");
        while (true) {
            readLine= scan.nextLine();
            if (!readLine.equalsIgnoreCase("exit")) {
                try {
                    NoteWriter noteWriter = new NoteWriter(readLine);
                    ContactData contact = new ContactData(noteWriter);
                    System.out.println("Создан контакт: "+contact);
                    FileUtil fileUtil = new FileUtil();
                    fileUtil.contactWrite(contact);
                    System.out.println("Контакт записан в файл: "+contact.getLastName() + ".txt");
                }
                catch (IllegalArgumentException e) {
                    System.err.println(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("Введите данные для создания контакта, либо exit чтоб выйти");
                }
            }
            else {
                System.out.println("Возврат");
                return;
            }

        }
    }
}
