# Bindings for javax.naming

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.naming "1.0.4"]
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

- class **javax.naming.AuthenticationException**
- class **javax.naming.AuthenticationNotSupportedException**
- class **javax.naming.BinaryRefAddr**
- class **javax.naming.Binding**
- class **javax.naming.CannotProceedException**
- class **javax.naming.CommunicationException**
- class **javax.naming.CompositeName**
- class **javax.naming.CompoundName**
- class **javax.naming.ConfigurationException**
- interface **javax.naming.Context**
- class **javax.naming.ContextNotEmptyException**
- class **javax.naming.InitialContext**
- class **javax.naming.InsufficientResourcesException**
- class **javax.naming.InterruptedNamingException**
- class **javax.naming.InvalidNameException**
- class **javax.naming.LimitExceededException**
- class **javax.naming.LinkException**
- class **javax.naming.LinkLoopException**
- class **javax.naming.LinkRef**
- class **javax.naming.MalformedLinkException**
- interface **javax.naming.Name**
- class **javax.naming.NameAlreadyBoundException**
- class **javax.naming.NameClassPair**
- class **javax.naming.NameNotFoundException**
- interface **javax.naming.NameParser**
- interface **javax.naming.NamingEnumeration**
- class **javax.naming.NamingException**
- class **javax.naming.NamingSecurityException**
- class **javax.naming.NoInitialContextException**
- class **javax.naming.NoPermissionException**
- class **javax.naming.NotContextException**
- class **javax.naming.OperationNotSupportedException**
- class **javax.naming.PartialResultException**
- class **javax.naming.RefAddr**
- class **javax.naming.Reference**
- interface **javax.naming.Referenceable**
- class **javax.naming.ReferralException**
- class **javax.naming.ServiceUnavailableException**
- class **javax.naming.SizeLimitExceededException**
- class **javax.naming.StringRefAddr**
- class **javax.naming.TimeLimitExceededException**
- interface **javax.naming.directory.Attribute**
- class **javax.naming.directory.AttributeInUseException**
- class **javax.naming.directory.AttributeModificationException**
- interface **javax.naming.directory.Attributes**
- class **javax.naming.directory.BasicAttribute**
- class **javax.naming.directory.BasicAttributes**
- interface **javax.naming.directory.DirContext**
- class **javax.naming.directory.InitialDirContext**
- class **javax.naming.directory.InvalidAttributeIdentifierException**
- class **javax.naming.directory.InvalidAttributeValueException**
- class **javax.naming.directory.InvalidAttributesException**
- class **javax.naming.directory.InvalidSearchControlsException**
- class **javax.naming.directory.InvalidSearchFilterException**
- class **javax.naming.directory.ModificationItem**
- class **javax.naming.directory.NoSuchAttributeException**
- class **javax.naming.directory.SchemaViolationException**
- class **javax.naming.directory.SearchControls**
- class **javax.naming.directory.SearchResult**
- interface **javax.naming.event.EventContext**
- interface **javax.naming.event.EventDirContext**
- interface **javax.naming.event.NamespaceChangeListener**
- class **javax.naming.event.NamingEvent**
- class **javax.naming.event.NamingExceptionEvent**
- interface **javax.naming.event.NamingListener**
- interface **javax.naming.event.ObjectChangeListener**
- class **javax.naming.ldap.BasicControl**
- interface **javax.naming.ldap.Control**
- class **javax.naming.ldap.ControlFactory**
- interface **javax.naming.ldap.ExtendedRequest**
- interface **javax.naming.ldap.ExtendedResponse**
- interface **javax.naming.ldap.HasControls**
- class **javax.naming.ldap.InitialLdapContext**
- interface **javax.naming.ldap.LdapContext**
- class **javax.naming.ldap.LdapName**
- class **javax.naming.ldap.LdapReferralException**
- class **javax.naming.ldap.ManageReferralControl**
- class **javax.naming.ldap.PagedResultsControl**
- class **javax.naming.ldap.PagedResultsResponseControl**
- class **javax.naming.ldap.Rdn**
- class **javax.naming.ldap.SortControl**
- class **javax.naming.ldap.SortKey**
- class **javax.naming.ldap.SortResponseControl**
- class **javax.naming.ldap.StartTlsRequest**
- class **javax.naming.ldap.StartTlsResponse**
- interface **javax.naming.ldap.UnsolicitedNotification**
- class **javax.naming.ldap.UnsolicitedNotificationEvent**
- interface **javax.naming.ldap.UnsolicitedNotificationListener**
- interface **javax.naming.spi.DirObjectFactory**
- class **javax.naming.spi.DirStateFactory$Result**
- interface **javax.naming.spi.DirStateFactory**
- class **javax.naming.spi.DirectoryManager**
- interface **javax.naming.spi.InitialContextFactory**
- interface **javax.naming.spi.InitialContextFactoryBuilder**
- class **javax.naming.spi.NamingManager**
- interface **javax.naming.spi.ObjectFactory**
- interface **javax.naming.spi.ObjectFactoryBuilder**
- class **javax.naming.spi.ResolveResult**
- interface **javax.naming.spi.Resolver**
- interface **javax.naming.spi.StateFactory**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
