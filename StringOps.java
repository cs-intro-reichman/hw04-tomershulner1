public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
    }

    public static String capVowelsLowRest (String string) {
        String result_str = "";
        char current_char;
        boolean is_current_char_vowel;
        for (int i = 0; i < string.length(); i++) {
            current_char = string.charAt(i);
            if (current_char ==  32) {
                result_str += current_char;
                continue;
            }
            is_current_char_vowel = isVowel(current_char);
            if (is_current_char_vowel && current_char >= 90) {
                current_char = (char)(current_char - 32);

            }
            else if (!is_current_char_vowel && (current_char < 97)) {
                current_char = (char)(current_char + 32);
            }
            result_str += current_char;
        }
        return result_str;
    }

    public static String camelCase (String string) {
        int index = 0;

        char last_char = string.charAt(index);
        char current_char;

        while (last_char == 32){
            index++;
            last_char = string.charAt(index);
        }

        String new_str = "" + toLower(last_char);

        for (int i = index + 1; i < string.length(); i++) {
            current_char = string.charAt(i);
            if (current_char == 32) {
                last_char = current_char;
                continue;
            }
            else if (last_char == 32) {
                new_str += toUpper(current_char);
            }
            else {
                new_str += toLower(current_char);
            }
            last_char = current_char;
        }
        return new_str;
    }

    public static int[] allIndexOf (String string, char chr) {
        int how_much = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) how_much++; 
        }

        int[] indexes = new int[how_much];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                indexes[index] = i;
                index++;
            }
        }
        return indexes;
    }

    public static boolean isVowel(char chr) {
        boolean result = false;
        String vowels = "aeiou";
        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.charAt(i) == chr) result = true;
        }
        return result;
    }

    public static char toLower(char chr) {
        char new_c;
        if (65 <= chr && chr <= 90) {
            new_c = (char)(chr + 32);
        }
        else {
            new_c = chr;
        }
        return new_c;
    }

    public static char toUpper(char chr) {
        char new_c;
        if (97 <= chr && chr <= 122) {
            new_c = (char)(chr - 32);
        }
        else {
            new_c = chr;
        }
        return new_c;
    }
}
