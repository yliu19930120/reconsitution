package restService.jersey.bean;

import java.util.List;

import restService.jersey.common.BaseBean;

public class Node extends BaseBean{
	
	private String nodeName;
	private Integer nodeType;
	private String tag;
	private String description;
	private String pid;
	private String path;
	private List<Node> children;


	
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
	public String getPid() {
		return pid;
	}
	public String getPath() {
		return path;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
}
