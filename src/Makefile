OBJ := 
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
	
