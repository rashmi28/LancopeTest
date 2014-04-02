package org.lancope.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	
	//constructor to create example graph
	public Graph (Node main_node) {
		Node b,c,d,e,f,g,h,i,j;
		e = new Node("e");
		f = new Node("f");
		g = new Node("g");
		h = new Node("h");
		i = new Node("i");
		j = new Node("j");
		b = new Node("b");
		b.addChildren(new Node[]{e,f});
		c = new Node("c");
		c.addChildren(new Node[]{g,h,i});
		d = new Node("d");
		d.addChildren(new Node[]{j});
		main_node.addChildren(new Node[]{b,c,d});
	}
	
	//wrapper method to return nodes in the graph
	public ArrayList walkGraph(GNode node) {
		ArrayList<GNode> allNodes = new ArrayList<GNode>();
		iterGraph(node, allNodes);
		return allNodes;
	}
	
	//method to walk through graph using depth-first search
	private void iterGraph (GNode node, ArrayList<GNode> allNodes) {
		allNodes.add(node);
		GNode[] children = node.getChildren();
		
		for (GNode iter: children) {
			iterGraph(iter, allNodes);
		}
	}
	
	//wrapper method to return paths in the graph
	public ArrayList paths(GNode node) {
		
		ArrayList<ArrayList<GNode>> allPaths = new ArrayList<ArrayList<GNode>>();
		allPaths.addAll(iterPaths(node));
		return allPaths;
		
	}
	
	//method to get all paths from given node in the graph
	private ArrayList<ArrayList<GNode>> iterPaths (GNode node) {
		
		ArrayList<GNode> children = new ArrayList<GNode>(Arrays.asList(node.getChildren()));
		ArrayList<ArrayList<GNode>> currentPaths = new ArrayList<ArrayList<GNode>>();  
		if (children.size()!=0) {
			for (GNode child : children) {
				currentPaths.addAll(iterPaths(child));
			}
			for (ArrayList<GNode> paths: currentPaths) {
				paths.add(0, node);
			}
		}
		else {
			ArrayList<GNode> thisPath = new ArrayList<GNode>();
			thisPath.add(node);
			currentPaths.add(thisPath);
		}
		return currentPaths;	
	}
	
	//helper method to print nodes from walkGraph() method
	private static void printWalk(ArrayList<GNode> nodes) {
		System.out.println("The nodes in the graph are: ");
		for (GNode node: nodes) {
			System.out.print(node.getName()+"\t");
		}
		System.out.println();
	}
	
	//helper method to print paths from paths() method
	private static void printPaths(ArrayList<ArrayList<GNode>> paths) {
		System.out.println("The paths in the graph are: ");
		for (ArrayList<GNode> path: paths) {
			
			for (GNode node: path) {
				System.out.print(node.getName()+"\t");
			}
			
			System.out.println();
		}
	}
	
	//main method
	public static void main(String args[]) {
		Node main_node= new Node("a");
		Graph g = new Graph (main_node);
		System.out.println("Graph created");
		System.out.println();
		printWalk(g.walkGraph(main_node));
		System.out.println();
		printPaths(g.paths(main_node));
	}
}

