# Bindings for java.sql

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.sql "1.0.3"]
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

- interface **java.sql.Array**
- class **java.sql.BatchUpdateException**
- interface **java.sql.Blob**
- interface **java.sql.CallableStatement**
- enum **java.sql.ClientInfoStatus**
- interface **java.sql.Clob**
- interface **java.sql.Connection**
- class **java.sql.DataTruncation**
- interface **java.sql.DatabaseMetaData**
- class **java.sql.Date**
- interface **java.sql.Driver**
- interface **java.sql.DriverAction**
- class **java.sql.DriverManager**
- class **java.sql.DriverPropertyInfo**
- enum **java.sql.JDBCType**
- interface **java.sql.NClob**
- interface **java.sql.ParameterMetaData**
- interface **java.sql.PreparedStatement**
- enum **java.sql.PseudoColumnUsage**
- interface **java.sql.Ref**
- interface **java.sql.ResultSet**
- interface **java.sql.ResultSetMetaData**
- interface **java.sql.RowId**
- enum **java.sql.RowIdLifetime**
- class **java.sql.SQLClientInfoException**
- interface **java.sql.SQLData**
- class **java.sql.SQLDataException**
- class **java.sql.SQLException**
- class **java.sql.SQLFeatureNotSupportedException**
- interface **java.sql.SQLInput**
- class **java.sql.SQLIntegrityConstraintViolationException**
- class **java.sql.SQLInvalidAuthorizationSpecException**
- class **java.sql.SQLNonTransientConnectionException**
- class **java.sql.SQLNonTransientException**
- interface **java.sql.SQLOutput**
- class **java.sql.SQLPermission**
- class **java.sql.SQLRecoverableException**
- class **java.sql.SQLSyntaxErrorException**
- class **java.sql.SQLTimeoutException**
- class **java.sql.SQLTransactionRollbackException**
- class **java.sql.SQLTransientConnectionException**
- class **java.sql.SQLTransientException**
- interface **java.sql.SQLType**
- class **java.sql.SQLWarning**
- interface **java.sql.SQLXML**
- interface **java.sql.Savepoint**
- interface **java.sql.Statement**
- interface **java.sql.Struct**
- class **java.sql.Time**
- class **java.sql.Timestamp**
- class **java.sql.Types**
- interface **java.sql.Wrapper**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
