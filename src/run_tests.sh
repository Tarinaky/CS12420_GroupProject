#!/bin/bash

error=0

for file in *Test.java
do
	echo " * Compiling ${file}."
	javac -cp .:/usr/lib/junit.jar ${file} || error=1 && continue
	echo " * Running tests, ${file}."
	java -cp .:/usr/lib/junit.jar junit.textui.TestRunner ${file/.java/} || error=1
done

if [ $error -eq 1 ]
then 
	exit 1
fi
