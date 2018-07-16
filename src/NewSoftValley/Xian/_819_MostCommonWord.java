package NewSoftValley.Xian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class _819_MostCommonWord {
    public String mostCommonWord(String paragraph1, String[] banned) {
        String paragraph = paragraph1.toLowerCase();
        if(paragraph.length() == 0 )
            return "";
        String result = "";
        int max = 0;
        Map<String , Integer> hm = new HashMap<>();

        int start = isParagrapgh(paragraph.charAt(0)) ? 1 : 0;
        for(int i = 1 ; i < paragraph.length() ; i++){
            if(isParagrapgh(paragraph.charAt(i)) ){
                if(!isParagrapgh(paragraph.charAt(i - 1))){
                    if(hm.containsKey(paragraph.substring(start,i)))
                        hm.put(paragraph.substring(start,i),hm.get(paragraph.substring(start,i))+ 1);
                    else  hm.put(paragraph.substring(start,i), 1);
                }
                start = i + 1 ;
            }
        }
        if(!paragraph.substring(start,paragraph.length()).equals(""))
            if(hm.containsKey(paragraph.substring(start,paragraph.length())))
                hm.put(paragraph.substring(start,paragraph.length()),hm.get(paragraph.substring(start,paragraph.length()))+ 1);
            else  hm.put(paragraph.substring(start,paragraph.length()), 1);

        for(Map.Entry<String , Integer> entry : hm.entrySet()){
            if(!Arrays.asList(banned).contains(entry.getKey())){
                if(entry.getValue() > max){
                    max = entry.getValue();
                    result = entry.getKey();
                }
            }
        }
        return result;


    }


    private boolean isParagrapgh(char c){
        return c == '!' || c == '?'|| c == ',' || c == ';'|| c == '.'||c == ' '||c == '\'';
    }
}
