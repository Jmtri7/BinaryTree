@echo off

javac -d classes sources/BinaryTreeApp.java sources/binarytree/*.java
java -cp classes BinaryTreeApp

@echo @echo off > ./classes/BinaryTreeApp.bat
@echo java -cp . BinaryTreeApp >> ./classes/BinaryTreeApp.bat