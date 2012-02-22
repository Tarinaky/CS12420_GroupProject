#!/bin/bash
for file in *Test.java
do
	echo " * Compiling ${file}."
	javac -cp .:/usr/lib/junit.jar ${file} || exit 1
	echo " * Running tests, ${file}."
	java -cp .:/usr/lib/junit.jar junit.textui.TestRunner ${file/.java/} || exit 1
done

