javac -classpath libs/isula-2.1.3.jar -d out/production -sourcepath src src/tsp/antcolony/Main.java
java -classpath out/production:libs/isula-2.1.3.jar:libs/commons-math3-3.6.1.jar tsp.antcolony.Main