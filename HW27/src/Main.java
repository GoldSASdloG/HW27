import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        //todo Тут протестить работу метода
        try {
            System.out.println(confirmPassword("sag__", "3456", "3451"));
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
    //todo тут создать метод confirmPassword()
    public static boolean confirmPassword (String login,
                                           String password,
                                           String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (validateLoginOrPassword(login)) {
            throw new WrongLoginException("Логин не соответствует требованиям!");
        }
        if (validateLoginOrPassword(password) || !password.equals(confirmPassword)) {
            throw  new WrongPasswordException("Пароль не верен!");
        }
        return true;
    }

    private static boolean validateLoginOrPassword (String loginOrPass){
        return (!loginOrPass.matches("\\w+") || loginOrPass.length() >= 20);
    }
}