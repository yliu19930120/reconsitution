package restService.jersey.common.builder;

import restService.jersey.bean.Node;
import restService.jersey.constant.Constant;
import restService.jersey.constant.NodeType;

public class RootNodeBuilder extends BaseBeanBuilder<Node>{

	@Override
	public Node buildDefaultBeab() {
		Node node = new Node();
		node.setNodeName(Constant.ROOT_FOLDER_NAME);
		node.setDescription(Constant.DEFAULT_PLACE);
		node.setTag(Constant.ROOT_FOLDER_TAG);
		node.setNodeType(NodeType.ROOT.getTypeCode());
		return node;
	}
	
	public static Node build(){
		return new RootNodeBuilder().getDefauleBean();
	}
}
