package 面试.车好多;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

class TreeNode {

    int id;
    private String name;
    //上级id
    private int parentId;
    //连接次数
    private int order;
    //儿子列表
    private List<TreeNode> son;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public List<TreeNode> getSon() {
        return son;
    }
    public void setSon(List<TreeNode> son) {
        this.son = son;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", order=" + order +
                ", son=" + son +
                '}';
    }
}
public class A {
    public static void main(String[] args) {
        List<TreeNode> nodeAll = new ArrayList<>();
        TreeNode vo = new TreeNode();
        vo.setId(1);
        vo.setName("node1");
        vo.setOrder(1);
        nodeAll.add(vo);
        TreeNode vo2 = new TreeNode();
        vo2.setId(2);
        vo2.setName("node2");
        vo2.setParentId(1);
        vo2.setOrder(2);
        nodeAll.add(vo2);
        TreeNode vo3 = new TreeNode();
        vo3.setId(3);
        vo3.setName("node3");
        vo3.setParentId(1);
        vo3.setOrder(1);
        nodeAll.add(vo3);
        TreeNode vo4 = new TreeNode();
        vo4.setId(4);
        vo4.setName("node4");
        vo4.setParentId(2);
        vo4.setOrder(1);
        nodeAll.add(vo4);
        HashMap<Integer, TreeNode> map = new LinkedHashMap<>();
        List<TreeNode> rootNode = new ArrayList<>();
        nodeAll.forEach(i -> {
            map.put(i.getId(), i);
            if (i.getParentId() == 0) {
                rootNode.add(i);
            }
        });

        nodeAll.forEach(i -> {
            TreeNode parentNode = null;
            if (i.getParentId() != 0) {
                parentNode = map.get(i.getParentId());
                List<TreeNode> sonList = parentNode.getSon();
                if (sonList == null) {
                    sonList = new ArrayList<>();
                }
                sonList.add(i);
                parentNode.setSon(sonList);
            }
        });
        System.out.println(rootNode);
    }
}
