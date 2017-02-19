set C_DIR=%~dp0
set C_D=%~d0
%C_D%
cd %C_DIR%\..\
call mvn eclipse:clean
call mvn eclipse:eclipse
call mvn dependency:sources
call mvn dependency:resolve -Dclassifier=javadoc
call mvn compile
pause
@echo.