package restService.jersey.constant;

public enum NodeType {

	ROOT("用户根目录",0),
	FOLDER("文件夹",1),
	FILE("文件",2);
	
	private NodeType(String name, Integer typeCode) {
		this.name = name;
		this.typeCode = typeCode;
	}

	private String name;
	private Integer typeCode;

	public String getName() {
		return name;
	}

	public Integer getTypeCode() {
		return typeCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

}
