# Bindings for javax.sql

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.sql "1.0.1"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- interface **javax.sql.CommonDataSource**
- class **javax.sql.ConnectionEvent**
- interface **javax.sql.ConnectionEventListener**
- interface **javax.sql.ConnectionPoolDataSource**
- interface **javax.sql.DataSource**
- interface **javax.sql.PooledConnection**
- interface **javax.sql.RowSet**
- class **javax.sql.RowSetEvent**
- interface **javax.sql.RowSetInternal**
- interface **javax.sql.RowSetListener**
- interface **javax.sql.RowSetMetaData**
- interface **javax.sql.RowSetReader**
- interface **javax.sql.RowSetWriter**
- class **javax.sql.StatementEvent**
- interface **javax.sql.StatementEventListener**
- interface **javax.sql.XAConnection**
- interface **javax.sql.XADataSource**
- class **javax.sql.rowset.BaseRowSet**
- interface **javax.sql.rowset.CachedRowSet**
- interface **javax.sql.rowset.FilteredRowSet**
- interface **javax.sql.rowset.JdbcRowSet**
- interface **javax.sql.rowset.JoinRowSet**
- interface **javax.sql.rowset.Joinable**
- interface **javax.sql.rowset.Predicate**
- interface **javax.sql.rowset.RowSetFactory**
- class **javax.sql.rowset.RowSetMetaDataImpl**
- class **javax.sql.rowset.RowSetProvider**
- class **javax.sql.rowset.RowSetWarning**
- interface **javax.sql.rowset.WebRowSet**
- class **javax.sql.rowset.serial.SQLInputImpl**
- class **javax.sql.rowset.serial.SQLOutputImpl**
- class **javax.sql.rowset.serial.SerialArray**
- class **javax.sql.rowset.serial.SerialBlob**
- class **javax.sql.rowset.serial.SerialClob**
- class **javax.sql.rowset.serial.SerialDatalink**
- class **javax.sql.rowset.serial.SerialException**
- class **javax.sql.rowset.serial.SerialJavaObject**
- class **javax.sql.rowset.serial.SerialRef**
- class **javax.sql.rowset.serial.SerialStruct**
- class **javax.sql.rowset.spi.SyncFactory**
- class **javax.sql.rowset.spi.SyncFactoryException**
- class **javax.sql.rowset.spi.SyncProvider**
- class **javax.sql.rowset.spi.SyncProviderException**
- interface **javax.sql.rowset.spi.SyncResolver**
- interface **javax.sql.rowset.spi.TransactionalWriter**
- interface **javax.sql.rowset.spi.XmlReader**
- interface **javax.sql.rowset.spi.XmlWriter**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
