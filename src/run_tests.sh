#!/bin/bash

error=0


junit() {
	for file in *Test.java
	do
		compileError=0
		echo " * Compiling ${file}."
		javac -cp .:/usr/lib/junit.jar ${file} || compileError=1
		if [ $compileError -eq 0 ]
		then
			echo " * Running tests, ${file}."
			java -cp .:/usr/lib/junit.jar junit.textui.TestRunner ${file/.java/} || error=1
		else
			error=1
		fi
	done

}

recurse() {
	for file in *
	do
		if [ -d ${file} ]
		then
			echo " Recursing into package ${file}."
			cd ${file}
			recurse
			junit
			cd ..
		fi
	done
}

recurse
junit


if [ $error -eq 1 ]
then 
	exit 1
fi
