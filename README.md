# quarkus-excel-demo

Demo REST endpoint that denerates an excel file for download implemented using

* [Quarkus](https://quarkus.io/)
* [Apache POI](https://poi.apache.org/)
* [RESTEasy](https://resteasy.github.io/)

## Clone the project
```
git clone https://github.com/briantanseng/quarkus-excel-demo.git && cd quarkus-excel-demo
```

## Build and run the project
```
mvn compile quarkus:dev
```

## Make a curl request to generate and download a sample MS Excel file
```
curl -o test.xlsx http://localhost:8080/download
```
