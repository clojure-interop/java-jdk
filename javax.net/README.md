# Bindings for javax.net

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 

## Clojars

You can find clojars in README of packages.

## Usage

```
(require '[jdk.io.File :as f])

(-> "./resource/MyFile.txt"
  f/->file
  f/exists?)

(-> "./resource/MyAnotherFile.txt"
  f/->file
  f/mkdirs)
```




## Clojars

```
[clojure-interop/javax.net "0.1.0-SNAPSHOT"]
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

- class **javax.net.ServerSocketFactory**
- class **javax.net.SocketFactory**
- class **javax.net.ssl.CertPathTrustManagerParameters**
- class **javax.net.ssl.ExtendedSSLSession**
- class **javax.net.ssl.HandshakeCompletedEvent**
- interface **javax.net.ssl.HandshakeCompletedListener**
- interface **javax.net.ssl.HostnameVerifier**
- class **javax.net.ssl.HttpsURLConnection**
- interface **javax.net.ssl.KeyManager**
- class **javax.net.ssl.KeyManagerFactory**
- class **javax.net.ssl.KeyManagerFactorySpi**
- class **javax.net.ssl.KeyStoreBuilderParameters**
- interface **javax.net.ssl.ManagerFactoryParameters**
- class **javax.net.ssl.SNIHostName**
- class **javax.net.ssl.SNIMatcher**
- class **javax.net.ssl.SNIServerName**
- class **javax.net.ssl.SSLContext**
- class **javax.net.ssl.SSLContextSpi**
- class **javax.net.ssl.SSLEngine**
- enum **javax.net.ssl.SSLEngineResult$HandshakeStatus**
- enum **javax.net.ssl.SSLEngineResult$Status**
- class **javax.net.ssl.SSLEngineResult**
- class **javax.net.ssl.SSLException**
- class **javax.net.ssl.SSLHandshakeException**
- class **javax.net.ssl.SSLKeyException**
- class **javax.net.ssl.SSLParameters**
- class **javax.net.ssl.SSLPeerUnverifiedException**
- class **javax.net.ssl.SSLPermission**
- class **javax.net.ssl.SSLProtocolException**
- class **javax.net.ssl.SSLServerSocket**
- class **javax.net.ssl.SSLServerSocketFactory**
- interface **javax.net.ssl.SSLSession**
- class **javax.net.ssl.SSLSessionBindingEvent**
- interface **javax.net.ssl.SSLSessionBindingListener**
- interface **javax.net.ssl.SSLSessionContext**
- class **javax.net.ssl.SSLSocket**
- class **javax.net.ssl.SSLSocketFactory**
- class **javax.net.ssl.StandardConstants**
- interface **javax.net.ssl.TrustManager**
- class **javax.net.ssl.TrustManagerFactory**
- class **javax.net.ssl.TrustManagerFactorySpi**
- class **javax.net.ssl.X509ExtendedKeyManager**
- class **javax.net.ssl.X509ExtendedTrustManager**
- interface **javax.net.ssl.X509KeyManager**
- interface **javax.net.ssl.X509TrustManager**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
