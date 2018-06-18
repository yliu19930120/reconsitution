package restService.jersey.bean;

import java.util.List;

public class RootNode extends Node{

	private List<Node> children;

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
}
