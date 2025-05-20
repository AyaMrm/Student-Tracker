package Model;


public class PasswordValidator {
    private static final int minLength = 2;

    // a implementer plus tard !
    private static boolean containUppercase(String password){
        for(char c: password.toCharArray()){
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean containLowercase(String password){
        for(char c: password.toCharArray()){
            if(Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean containDigit(String password){
        for(char c: password.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean containSpecialChar(String password){
        String special = "!@#$%^&*()_-+=|:;<>,.?/'\" {}[]";
        for(char c: password.toCharArray()){
            if(special.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }

    public static boolean isWeak(String password){
        if(password == null || password.length() < 2 || !containUppercase(password)|| !containLowercase(password)|| !containDigit(password)|| !containSpecialChar(password)){
            return true;
        }

        return false;
    }
}
