package restService.jersey.bean;


import restService.jersey.common.BaseBean;

public class Node extends BaseBean{
	
	private String nodeName;
	private Integer nodeType;
	private String tag;
	private String description;
	private String path;
	private String firstChild;
	private String nextBrother;
	public String getNodeName() {
		return nodeName;
	}
	public Integer getNodeType() {
		return nodeType;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}
	public String getTag() {
		return tag;
	}
	public String getDescription() {
		return description;
	}
	public String getPath() {
		return path;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFirstChild() {
		return firstChild;
	}
	public String getNextBrother() {
		return nextBrother;
	}
	public void setFirstChild(String firstChild) {
		this.firstChild = firstChild;
	}
	public void setNextBrother(String nextBrother) {
		this.nextBrother = nextBrother;
	}
	
}
