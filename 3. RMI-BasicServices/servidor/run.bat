@echo off
del *.class
javac ServerClass.java
start rmiregistry
start java ServerClass