package nonleetcode.interviews.inheritThrone;

import java.util.*;

public class Solution {

    final static String KING = "king";
    final static String ARTHUR = "Arthur";
    final static String JOHN = "John";
    final static String DAVID = "David";
    final static String JORDAN = "Jordan";
    final static String PETER = "Peter";
    final static String HARDEN = "Harden";
    final static String IVY = "Ivy";
    final static String SIVA = "Siva";
    final static String YUAN = "Yuan";
    final static String DONGYAN = "Dongyan";
    final static String BRUCE = "Bruce";
    final static String LEE = "Lee";

    public void test() {
        Map<String, List<String>> map = new HashMap<>();
        map.put(KING, new ArrayList<>());
        map.get(KING).add(ARTHUR);
        map.get(KING).add(JOHN);

        map.put(ARTHUR, new ArrayList<>());
        map.put(JOHN, new ArrayList<>());

        map.get(ARTHUR).add(DAVID);
        map.get(ARTHUR).add(JORDAN);
        map.get(ARTHUR).add(PETER);

        map.get(JOHN).add(HARDEN);
        map.get(JOHN).add(IVY);

        String[] tmp = {SIVA, YUAN, DONGYAN, BRUCE, LEE};
        map.put(JORDAN, Arrays.asList(tmp));


    }


    
}
