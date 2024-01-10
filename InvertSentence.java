public class InvertSentence {
    final static String punctuations = "!\"#$%&'()*+,./:;<=>?@[\\]^_`{|}~";

    /*
    *
    Input                               Expected Output
    Good afternoon                      afternoon Good
    Hello, how are you?                 ?you are how, Hello
    Are you twenty-one years old?       ?old years twenty-one you Are
    * */

    public static void main(String[] args) {

        System.out.println(invert("Good afternoon"));
        System.out.println(invert("Hello, how are you?"));
        System.out.println(invert("Are you twenty-one years old?"));
    }

    static String invert(String text) {

        String[] words = text.split("\\s+");

        StringBuilder result = new StringBuilder();

        String word = words[words.length - 1];

        char lastChar = word.charAt(word.length() - 1);
        // need to check last word if there is punctuation so need to move to left
        if (punctuations.contains("" + lastChar)) {
            result.append(lastChar + word.substring(0, word.length() - 1));
        } else {
            // otherwise just add word to main result
            result.append(word);
        }

        // start loop from 2nd last word
        for (int i = words.length - 2; i >= 0; i--) {

            word = words[i];
            lastChar = word.charAt(word.length() - 1);
            // need to check every word if there is punctuation so need to move to last word
            if (punctuations.contains("" + lastChar)) {
                result.append(lastChar + " " + word.substring(0, word.length() - 1));
            } else {
                //otherwise just add word
                result.append(" " + word);
            }

        }

        return result.toString().trim();
    }

    /*
    * RESULTS
    * 
    * afternoon Good
    * ?you are how, Hello
    * ?old years twenty-one you Are
    *
    *
    * */
}
