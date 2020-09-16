package binarytree;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class BinaryTreeDrawer {

	public BinaryTreeDrawer() {
		
	}

	public static Group buildTreeGroup(BinaryTree tree, int x, int y, int nodeRadius) {
		int numberOfLayers = tree.countLayers(tree.getRoot());
		int initialSpread = (int) (1.5 * nodeRadius * Math.pow(2, numberOfLayers - 1));

		Group treeGroup = buildNodeGroup(tree.getRoot(), x, y, initialSpread, nodeRadius);
		
		return treeGroup;
	}

	private static Group buildNodeGroup(BinaryTree.Node root, int x, int y, int spread, int nodeRadius) {
		Group rootGroup = new Group(new Circle(x, y, nodeRadius));

		if(root.getLeftChild() != null) {
			int leftChildX = x - spread / 2;
			int leftChildY = y + 2 * nodeRadius;

			Line leftChildLine = new Line(x, y, leftChildX, leftChildY);
			Group leftChildGroup = buildNodeGroup(root.getLeftChild(), leftChildX, leftChildY, spread / 2, nodeRadius);

			rootGroup.getChildren().add(leftChildLine);
			rootGroup.getChildren().add(leftChildGroup);
		}

		if(root.getRightChild() != null) {
			int rightChildX = x + spread / 2;
			int rightChildY = y + 2 * nodeRadius;

			Line rightChildLine = new Line(x, y, rightChildX, rightChildY);
			Group rightChildGroup = buildNodeGroup(root.getRightChild(), rightChildX, rightChildY, spread / 2, nodeRadius);
			
			rootGroup.getChildren().add(rightChildLine);
			rootGroup.getChildren().add(rightChildGroup);
		}

		String rootString = root.getValue().toString();

		Text rootText = new Text(x, y, rootString);
		rootText.setTextOrigin(VPos.CENTER);
		rootText.setFont(new Font(nodeRadius));
		rootText.setX(x - rootText.getFont().getSize() * root.getValue().toString().length() / 4);
		rootText.setFill(Color.WHITE);
		rootGroup.getChildren().add(rootText);
		
		return rootGroup;
	}
}