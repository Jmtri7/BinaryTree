// Binary Tree
import binarytree.*;

// Application
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.scene.control.ScrollPane;

public class BinaryTreeApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		// Build a tree
		Integer[] values = new Integer[] {
			1,
			2, 3,
			4, null, 6, 7,
			8, 9, null, null, 12, null, 14, 15
		};
		BinaryTree<Integer> tree = new BinaryTree<Integer>(values);

		// Create group for tree
		Group treeGroup = BinaryTreeDrawer.buildTreeGroup(tree, 0, 0, 25);

		ScrollPane scrollPane = new ScrollPane();
 		scrollPane.setPrefSize(1000, 1000);
 		scrollPane.setContent(treeGroup);

 		Scene scene = new Scene(scrollPane, Color.WHITE);

 		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}