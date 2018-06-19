package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
/**
 * 实现层级关系数
 * @author kangpan
 *
 */
public class Tree {
	//封装层级对应的Node
	private Map<Integer, List<Node>> treeMap = new HashMap<Integer, List<Node>>();
	//接收未处理的List<Node> 和　返回处理后的List<Node>
	private List<Node> tree = new ArrayList<Node>();
	//数的层级 set去重　排序
	private Set<Integer> lev = new TreeSet<Integer>();
	//数的层级转换ArrayList
	private List<Integer> treeLev = new ArrayList<Integer>();

	public List<Node> getTree() {
		return tree;
	}

	public void setTree(List<Node> tree) {
		this.tree = tree;
	}
	//获取不同层级　比如有１级 ２级　３级　［1,2,3］
	private void getLev() {
		for(Node node : this.tree) {
			this.lev.add(node.getLev());
		}
	}
	//set转换list
	private void getTreeLev() {
		Iterator<Integer> it = lev.iterator();	
		while(it.hasNext()) {
			treeLev.add((Integer) it.next());
		}
	}
	//获取对应层级的数据　比如１级有几个对应的Node　２级有几个对应的Node(也就是Node.getLev == 对应的层级，封装在一个Ｍap)
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
	//循环往下层找对应的子级　　比如１级去找２级有没有子级　有的话就赋值　没有继续第３级...4级　５级．．．一直到最大的级别
	//１级结束后　接着开始2级找３级的...４级．．．一直到最大的级别(最小级别的数据在数的顶层)
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
	//比较下一个的子级跟当前级别 是否下一个级别的数据挂在当前级别下
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
		//[Node [name=一级, treeNode=[Node [name=二级, treeNode=[Node [name=三级, treeNode=[Node [name=四级, treeNode=[]]]], Node [name=五级, treeNode=[]]]]]]]
		//Node [name=一级, treeNode=[Node [name=二级, treeNode=[Node [name=三级, treeNode=[Node [name=四级, treeNode=[]]]], Node [name=五级, treeNode=[]]]]]]
	}
}
