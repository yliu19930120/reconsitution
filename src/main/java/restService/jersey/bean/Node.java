package restService.jersey.bean;


import restService.jersey.common.BaseBean;

public class Node extends BaseBean{
	
	private String nodeName;
	private Integer nodeType;
	private String tag;
	private String description;
	private String content;
	private String firstChild;
	private String nextBrother;
	private String father;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	
}
