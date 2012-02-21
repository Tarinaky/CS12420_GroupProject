OBJ := 
SRC := $(OBJ:.class=.java)


%.class: %.java
	javac -g $<
	
all: ClassDiagram.png

documentation: design.pdf

ClassDiagram.png: ClassDiagram.java
	javadoc -docletpath /usr/local/lib/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -private ClassDiagram.java
	dot -Tpng -oClassDiagram.png graph.dot
	rm -f graph.dot

design.pdf: design.tex UseCase.png ClassDiagram.png
	aspell -c design.tex
	pdflatex -halt-on-error design.tex
	untex design.tex > /tmp/design.txt && wc -w /tmp/design.txt

UseCase.png: UseCase.dia
	dia --export=UseCase.png UseCase.dia

.PHONY: all clean tests documentation objects

tests: $(OBJ)
	bash run_tests.sh
	
objects: $(OBJ)

clean:
	rm -f *.aux
	rm -f *.log
	rm -f *.class
	rm -f UseCase.png
	rm -f design.pdf
	rm -f ClassDiagram.png
	
