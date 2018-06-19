package Tree;

import java.util.List;

public class Node {
	
	private String id;
	private String name;
	private String pid;
	private int lev;
	private String hasChildren;
	private int order;
	private List<Node> treeNode;
	
	public Node() {
		super();
	}
	public Node(String id, String name, String pid, int lev, String hasChildren, int order) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.lev = lev;
		this.hasChildren = hasChildren;
		this.order = order;
	}
	public List<Node> getTreeNode() {
		return treeNode;
	}
	public void setTreeNode(List<Node> treeNode) {
		this.treeNode = treeNode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}
	
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", treeNode=" + treeNode + "]";
	}	
}
