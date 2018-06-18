package restService.jersey.bean;

import restService.jersey.common.BaseBean;

public class Node extends BaseBean{
	
	private String NodeName;
	private Integer NodeType;


	public String getNodeName() {
		return NodeName;
	}
	public Integer getNodeType() {
		return NodeType;
	}

	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}
	public void setNodeType(Integer nodeType) {
		NodeType = nodeType;
	}
	
}
