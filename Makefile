MOD_PATH=--module-path
MOD_ADD=--add-modules
CONTROLS=javafx.controls

all: RandomMathGenerator.java
	javac $(MOD_PATH) $(PATH_TO_FX) $(MOD_ADD) $(CONTROLS) *.java

run: RandomMathGenerator.class
	java $(MOD_PATH) $(PATH_TO_FX) $(MOD_ADD) $(CONTROLS) RandomMathGenerator
