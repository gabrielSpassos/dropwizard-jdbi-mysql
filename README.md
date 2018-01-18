# DropWizard
## Database Poc

### Build

``` 

$ gradle clean fatJar
$ java -jar build/libs/poc-dropwizard-jdbi-mysql.all-1.0-SNAPSHOT.jar server config.yml

```
### Usage

```
[method] GET
$ curl http://localhost:8080/pessoas
Result: return all people from database

[method] GET
$ curl http://localhost:8080/pessoas/[id from person]
Result: return unique person from database


[method] POST
$ curl http://localhost:8080/pessoas
Result: send one person to the database
Json Expected
{
    "nome":"nome"
}

[method] DELETE
$ curl http://localhost:8080/pessoas/[id from person]
Result: delete one person of database

[method] PUT
$ curl http://localhost:8080/pessoas/[id from person]
Result: Updates one person of database


```

### References

* [Dropwizard.io](http://www.dropwizard.io/1.2.2/docs/getting-started.html)

* [dropwizard-guice](https://github.com/ragnarokkrr/rgn-doodling/tree/master/dropwizard-guice)

* [dropwizard-guice-jdbi](https://github.com/xvik/dropwizard-guicey-examples)

* [dropwizard-jdbi](https://github.com/stevenalexander/dropwizard-jdbi)
