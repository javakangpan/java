package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Tree {

	private Map<Integer, List<Node>> treeMap = new HashMap<Integer, List<Node>>();
	private List<Node> tree = new ArrayList<Node>();
	private Set<Integer> lev = new TreeSet<Integer>();
	private List<Integer> treeLev = new ArrayList<Integer>();

	public List<Node> getTree() {
		return tree;
	}

	public void setTree(List<Node> tree) {
		this.tree = tree;
	}

	private void getLev() {
		for(Node node : this.tree) {
			this.lev.add(node.getLev());
		}
	}

	private void getTreeLev() {
		Iterator<Integer> it = lev.iterator();	
		while(it.hasNext()) {
			treeLev.add((Integer) it.next());
		}
	}
	private void getTreeMap() {
		Iterator<Integer> it = lev.iterator();	
		while(it.hasNext()) {
			List<Node> temp = new ArrayList<Node>();
			int n = (int) it.next();
			for(Node node : this.tree) {
				if(node.getLev() == n) {
					temp.add(node);
				}			
			}
			treeMap.put(n, temp);
		}

	}
	private void getNewTree() {
		int max = treeLev.get(treeLev.size() - 1);
		int min =treeLev.get(0);
		for(int i = min; i <= max; i++) {
			int n = i + 1;
			while(n <= max) {
				if(null == treeMap.get(i) && treeMap.get(i).size() < 0 ) {
					break;
				}
				if(null == treeMap.get(n) && treeMap.get(n).size() < 0 ) {
					n ++;
					continue;
				}
				getResult(treeMap.get(i),treeMap.get(n));
				n ++;
			}
		}	
	}
	
	private void getResult(List<Node> nowlist,List<Node> nextlist) {
		if(null != nowlist && nowlist.size() > 0 && null != nextlist && nextlist.size() > 0) {
			for(Node now : nowlist) {
				List<Node> child = new ArrayList<Node>();
				if(now.getHasChildren().equals("false")) {
					continue;
				}
				for(Node next : nextlist) {
					if(next.getPid() == now.getId()) {
						child.add(next);
					}
				}
				if(child.size() > 0)
				now.setTreeNode(child);
			}
		}
	}
	
	//非递归方法获取
	public Node getNodeTree(){
		if(null != this.getTree() && this.getTree().size() > 0) {
			getLev();
			getTreeLev();
			getTreeMap();
			getNewTree();
		}
		return this.tree.get(0);
	}
	
	//递归方法
	public List<Node> getNodeTree(String id,List<Node> rootTree){
		List<Node> tree = new ArrayList<Node>();
		for(Node node : rootTree) {
			if(node.getPid().equals(id)) {
				tree.add(node);
			}
		}
		if(tree.size() < 0) {
			return null;
		}
		for(Node node : tree) {
			node.setTreeNode(getNodeTree(node.getId(),rootTree));
		}
		return tree;
	}
	public static void main(String[] args) {
		List<Node> list = new ArrayList<Node>();
		Node node$1 = new Node("node1","一级","",1,"true",1);
		Node node$2 = new Node("node2","二级","node1",2,"true",2);
		Node node$3 = new Node("node3","三级","node2",3,"true",3);
		Node node$4 = new Node("node4","四级","node3",4,"false",4);
		Node node$5 = new Node("node5","五级","node2",3,"false",5);
		
		list.add(node$1);list.add(node$2);list.add(node$3);list.add(node$4);list.add(node$5);
		Tree tree = new Tree();
		tree.setTree(list);
		System.out.println(tree.getNodeTree("",list).toString());
		System.out.println(tree.getNodeTree().toString());
	}
}
