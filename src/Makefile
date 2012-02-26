OBJ := model/Design.class model/Classes.class model/Link.class model/Field.class model/AccessModifier.class model/Method.class ClassBuilder.class GraphicalPanel.class MainFrame.class ToolsPanel.class
SRC := $(OBJ:.class=.java)


%.class: %.java
	javac -g $<
	
all: objects tests

.PHONY: all clean tests documentation objects

tests: $(OBJ)
	bash run_tests.sh
	
objects: $(OBJ)

clean:
	rm -f *.class
	
