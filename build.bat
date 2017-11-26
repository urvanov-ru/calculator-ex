del mlib/ru.urvanov.calculatorex.jar
del mlib/ru.urvanov.calculatorex.standardplugin.jar

rem Doesn't work. Should remove build content
rem rd \S \Q .\mods\ru.urvanov.calculatorex
rem rd \S \Q .\mods\ru.urvanov.calculatorex.standardplugin

javac -d mods --module-source-path src  src/ru.urvanov.calculatorex/ru/urvanov/calculatorex/Main.java
javac -d mods --module-source-path src  src/ru.urvanov.calculatorex.standardplugin/ru/urvanov/calculatorex/plugin/standard/Sum.java
jar --create --file=mlib/ru.urvanov.calculatorex.jar --module-version=1.0 -C mods/ru.urvanov.calculatorex .
jar --create --file=mlib/ru.urvanov.calculatorex.standardplugin.jar --module-version=1.0 -C mods/ru.urvanov.calculatorex.standardplugin .