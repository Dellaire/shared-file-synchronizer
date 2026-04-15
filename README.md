# Shared File Synchronizer

## Calls

### Upload file
```
curl -i -X POST http://localhost:8099/files -F "file=@test.txt" -F 'fileMetadata={"previousHashCode":"1234"};type=application/json'
```

### Download file
```
curl -X GET http://localhost:8099/files/test.txt -o test_output.txt
```