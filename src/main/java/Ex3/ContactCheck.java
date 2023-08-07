package Ex3;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactCheck  {
    protected static String[] check (String inputData) throws IllegalArgumentException {
        String[] outputData = inputData.split(" ");
        if (outputData.length!=6) {
            throw new IllegalArgumentException("Некорректное число аргументов");
        }
        if (outputData[3].length()==10) {
            if (isDateNotCorrect(outputData[3])) {
                throw new IllegalArgumentException("Некорректная дата");
            }
        } else {
            throw new IllegalArgumentException("Некорректный формат даты - число символов не равно 10");
        }

        if (outputData[4].length()==10) {
            if (isPhoneNotCorrect(outputData[4])) {
                throw new IllegalArgumentException("Некорректный телефонный номер - допускаются только цифры");
            }
        } else {
            throw new IllegalArgumentException("Некорректный формат телефонного номера - число символов не равно 10");
        }

        if (outputData[5].length()==1) {
            if (isSexIndexNotCorrect(outputData[5])) {
                throw new IllegalArgumentException("Некорректное обозначение пола - допускаются только 'm', 'f'");
            }
        } else {
            throw new IllegalArgumentException("Некорректный формат обозначения пола - число символов не равно 10");
        }
        return outputData;
    }
    protected static boolean isDateNotCorrect (String dateString) {
        boolean incorrectDate = false;
        String [] splitDateString = dateString.split("\\.");
        if (splitDateString.length!=3) {
            incorrectDate = true;
        } else {
            if (!Arrays.stream(splitDateString)
                    .allMatch(str -> str.matches("\\d+"))) {
                incorrectDate = true;
            }
            if (Integer.parseInt(splitDateString[0])>31 || Integer.parseInt(splitDateString[1])>12
                    || Integer.parseInt(splitDateString[2])>2023 || Integer.parseInt(splitDateString[2])<1900) {
                incorrectDate = true;
            }
        }
        return incorrectDate;
    }
    protected static boolean isPhoneNotCorrect (String phoneString) {
        boolean incorrectPhone = false;
        if (!phoneString.chars().allMatch(Character::isDigit)) {
            incorrectPhone = true;
        }

        return incorrectPhone;
    }
    protected static boolean isSexIndexNotCorrect (String sexIndexString) {
        boolean incorrectSexIndex = false;
        if (sexIndexString.toLowerCase().charAt(0)!='m' && sexIndexString.toLowerCase().charAt(0)!='f') {
            incorrectSexIndex = true;
        }

        return incorrectSexIndex;
    }
}
