@echo off
echo Compiling...
javac -cp ".;lib\sqlite-jdbc-3.36.0.3.jar" Main.java database\DatabaseManager.java models\*.java services\*.java ui\MainMenu.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b
)
echo Running...
java -cp ".;lib\sqlite-jdbc-3.36.0.3.jar" Main
pause