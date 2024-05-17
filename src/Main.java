import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа с арифмитическим действием: ");
        String input = scanner.nextLine();

        System.out.println(calc(input));

        scanner.close();
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        int res = 0;
        String oper;
        String result;
        String str = "";

        // избовляемся от пробелов
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
        }


        String[] operands = str.split("[+\\-*/]");// проверяем правильность введенных данных
        if (operands.length != 2) throw new Exception("Формат математической операции не удовлетворяет заданию");

        oper = detectOperation(str); // находим математическую операцию
        if (oper == null) throw new Exception("Неподдерживаемая математическая операция");

        // присваеваем числа переменым для вычисления
        num1 = Integer.parseInt(operands[0]);
        num2 = Integer.parseInt(operands[1]);

        // проверяем удовлетворяет ли числа условию
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть меньше 10");
        }

        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }

        result = String.valueOf(res);
        return result;
    }

    public static String detectOperation(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }
}
