package org.lancope.graph;

class Node implements GNode{
	
	String name;
	Node nodes[];
	private static int node_index = 0;
	
	public Node() {
		this.name = "Node-"+ ++node_index;
		this.nodes = new Node[0];
	}
	
	public Node(String name) {
		this.name = name;
		this.nodes = new Node[0];
	}
	
	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public GNode[] getChildren(){
		return nodes;
	}
	
	public void addChildren(Node[] nodes) {
		this.nodes = nodes;
	}
}
