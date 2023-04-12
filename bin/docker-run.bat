docker stop note-api
docker rm note-api
start /B cmd /C docker run  -it ^
    --rm ^
    --name note-api  ^
    -p 8000:8000 ^
    note-api    ^