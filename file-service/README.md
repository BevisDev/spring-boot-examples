# File Service

This repository is responsible for:

* read or write data to file
* get or do something relevant to file

### Build the application

You can build the project and run the tests by running

```shell
mvn clean package
```

Or you can build without running unit tests

```shell 
mvn clean package -Dmaven.test.skip=true
```

### Start application

```shell
mvn spring-boot:run
```

### Get information system health

```
http://{host}/status
```

### Get detail information system health

```
http://{host}/status?isDetail=true
```
