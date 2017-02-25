set C_DIR=%~dp0
set C_D=%~d0
%C_D%
cd %C_DIR%\..\
xcopy "src\main\webapp" "deep2" /s/h/c/y 
pause
@echo.