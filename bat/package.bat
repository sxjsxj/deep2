set C_DIR=%~dp0
set C_D=%~d0
%C_D%
cd %C_DIR%\..\
call mvn clean package -Dmaven.test.skip=true
pause
@echo.