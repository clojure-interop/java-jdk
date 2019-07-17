# Bindings for javax.security

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.security "0.1.0-SNAPSHOT"]
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

- class **javax.security.auth.AuthPermission**
- class **javax.security.auth.DestroyFailedException**
- interface **javax.security.auth.Destroyable**
- class **javax.security.auth.Policy**
- class **javax.security.auth.PrivateCredentialPermission**
- class **javax.security.auth.RefreshFailedException**
- interface **javax.security.auth.Refreshable**
- class **javax.security.auth.Subject**
- class **javax.security.auth.SubjectDomainCombiner**
- interface **javax.security.auth.callback.Callback**
- interface **javax.security.auth.callback.CallbackHandler**
- class **javax.security.auth.callback.ChoiceCallback**
- class **javax.security.auth.callback.ConfirmationCallback**
- class **javax.security.auth.callback.LanguageCallback**
- class **javax.security.auth.callback.NameCallback**
- class **javax.security.auth.callback.PasswordCallback**
- class **javax.security.auth.callback.TextInputCallback**
- class **javax.security.auth.callback.TextOutputCallback**
- class **javax.security.auth.callback.UnsupportedCallbackException**
- class **javax.security.auth.kerberos.DelegationPermission**
- class **javax.security.auth.kerberos.KerberosKey**
- class **javax.security.auth.kerberos.KerberosPrincipal**
- class **javax.security.auth.kerberos.KerberosTicket**
- class **javax.security.auth.kerberos.KeyTab**
- class **javax.security.auth.kerberos.ServicePermission**
- class **javax.security.auth.login.AccountException**
- class **javax.security.auth.login.AccountExpiredException**
- class **javax.security.auth.login.AccountLockedException**
- class **javax.security.auth.login.AccountNotFoundException**
- class **javax.security.auth.login.AppConfigurationEntry$LoginModuleControlFlag**
- class **javax.security.auth.login.AppConfigurationEntry**
- interface **javax.security.auth.login.Configuration$Parameters**
- class **javax.security.auth.login.Configuration**
- class **javax.security.auth.login.ConfigurationSpi**
- class **javax.security.auth.login.CredentialException**
- class **javax.security.auth.login.CredentialExpiredException**
- class **javax.security.auth.login.CredentialNotFoundException**
- class **javax.security.auth.login.FailedLoginException**
- class **javax.security.auth.login.LoginContext**
- class **javax.security.auth.login.LoginException**
- interface **javax.security.auth.spi.LoginModule**
- class **javax.security.auth.x500.X500Principal**
- class **javax.security.auth.x500.X500PrivateCredential**
- class **javax.security.cert.Certificate**
- class **javax.security.cert.CertificateEncodingException**
- class **javax.security.cert.CertificateException**
- class **javax.security.cert.CertificateExpiredException**
- class **javax.security.cert.CertificateNotYetValidException**
- class **javax.security.cert.CertificateParsingException**
- class **javax.security.cert.X509Certificate**
- class **javax.security.sasl.AuthenticationException**
- class **javax.security.sasl.AuthorizeCallback**
- class **javax.security.sasl.RealmCallback**
- class **javax.security.sasl.RealmChoiceCallback**
- class **javax.security.sasl.Sasl**
- interface **javax.security.sasl.SaslClient**
- interface **javax.security.sasl.SaslClientFactory**
- class **javax.security.sasl.SaslException**
- interface **javax.security.sasl.SaslServer**
- interface **javax.security.sasl.SaslServerFactory**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
