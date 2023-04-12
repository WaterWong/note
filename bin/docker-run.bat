docker stop note-api
docker rm note-api
echo %USERNAME%
set root=/c/Users/
set data=/h2/data
set dbpath=%root%%USERNAME%%data%

start /B cmd /C docker run  -it ^
    --rm ^
    --name note-api  ^
    -p 8000:8000 ^
    -v %dbpath%:/root/h2/data ^
    note-api    ^