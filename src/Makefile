OBJ := Design.class Classes.class Link.class Field.class AccessModifier.class Method.class
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
	
