package nonleetcode.interviews.inheritThrone;

import java.util.ArrayList;
import java.util.List;

public class MemberNode {

    String name;
    List<MemberNode> inheritanOrder;
    boolean throneEligible;
    MemberNode(String name) {
        this.name = name;
        inheritanOrder = new ArrayList<>();
        throneEligible = false;
    }
}
