:: Author : Water
:: Date   : 2023-04-12
:: Desc   : Build and Run

:: Maven build project
call echo Into folder %cd%
call cd  ../
call mvn -T 4 -q clean package -DskipTests=true
call mkdir -p dist/
call cp note-api/target/note-api-1.0.0.0-SNAPSHOT.jar ./dist/
call cd  bin/
call echo Into folder %cd%
:: Maven build project end

:: Docker start

call docker pull openjdk:17-jdk-alpine
call ./docker-build.bat
call ./docker-run.bat

:: Docker end

:: Clean up start
call cd ../
call echo Into folder %cd%
call mvn clean
call rm dist/*
:: Clean up end
exit
