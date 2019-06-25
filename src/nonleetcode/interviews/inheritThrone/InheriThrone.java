package nonleetcode.interviews.inheritThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InheriThrone {

    private MemberNode root;
    private List<String> order;

    public InheriThrone(String kingName) {
        root = new MemberNode(kingName);
        root.throneEligible = true;
        order = new ArrayList<>();
        order.add(kingName);
    }


    public void birth(String membername, String childname) {
        // dfs to the person, add a new child memeber
        MemberNode child = new MemberNode(childname);
        if (membername.equals(this.root.name)) {
            if (root.inheritanOrder.size() == 0) {
                child.throneEligible = true;
            }
            root.inheritanOrder.add(child);
            return;
        }
        MemberNode member = search(membername, root);
        if (member.throneEligible && member.inheritanOrder.size() == 0) {
            child.throneEligible = true;
        }
        member.inheritanOrder.add(child);
        if (child.throneEligible) {
            order.add(childname);
        }
    }

    public void death(String membername) {
        root = remove(membername, root);
    }

    public List<String> getOrder() {
        return this.order;
    }

    private MemberNode remove(String memberName, MemberNode memberNode) {
        if (memberName.equals(memberNode.name)) {
            List<MemberNode> inheritantOrder = memberNode.inheritanOrder;
            if (inheritantOrder.size() == 0) {
                return null;
            }
            MemberNode inheritant = inheritantOrder.get(0);
            inheritantOrder.remove(inheritant);
            inheritant.inheritanOrder = inheritantOrder;

            return inheritant;
        }

        MemberNode node = null;
        for (MemberNode m : memberNode.inheritanOrder) {
            MemberNode res = remove(memberName, m);
            if (res != null) {
                node = res;
                break;
            }
        }
        return node;
    }

    private MemberNode search(String name, MemberNode node) {
        if (node == null) {
            return null;
        }

        if (name.equals(node.name)) {
            return node;
        }

        List<MemberNode> children = node.inheritanOrder;
        for (MemberNode child : children) {
            MemberNode res = search(name, child);
            if (res != null) {
                return res;
            }
        }

        return null;
    }

}
