# Bindings for java.net

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.net "1.0.0"]
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

- enum **java.net.Authenticator$RequestorType**
- class **java.net.Authenticator**
- class **java.net.BindException**
- class **java.net.CacheRequest**
- class **java.net.CacheResponse**
- class **java.net.ConnectException**
- class **java.net.ContentHandler**
- interface **java.net.ContentHandlerFactory**
- class **java.net.CookieHandler**
- class **java.net.CookieManager**
- interface **java.net.CookiePolicy**
- interface **java.net.CookieStore**
- class **java.net.DatagramPacket**
- class **java.net.DatagramSocket**
- class **java.net.DatagramSocketImpl**
- interface **java.net.DatagramSocketImplFactory**
- interface **java.net.FileNameMap**
- class **java.net.HttpCookie**
- class **java.net.HttpRetryException**
- class **java.net.HttpURLConnection**
- class **java.net.IDN**
- class **java.net.Inet4Address**
- class **java.net.Inet6Address**
- class **java.net.InetAddress**
- class **java.net.InetSocketAddress**
- class **java.net.InterfaceAddress**
- class **java.net.JarURLConnection**
- class **java.net.MalformedURLException**
- class **java.net.MulticastSocket**
- class **java.net.NetPermission**
- class **java.net.NetworkInterface**
- class **java.net.NoRouteToHostException**
- class **java.net.PasswordAuthentication**
- class **java.net.PortUnreachableException**
- class **java.net.ProtocolException**
- interface **java.net.ProtocolFamily**
- enum **java.net.Proxy$Type**
- class **java.net.Proxy**
- class **java.net.ProxySelector**
- class **java.net.ResponseCache**
- class **java.net.SecureCacheResponse**
- class **java.net.ServerSocket**
- class **java.net.Socket**
- class **java.net.SocketAddress**
- class **java.net.SocketException**
- class **java.net.SocketImpl**
- interface **java.net.SocketImplFactory**
- interface **java.net.SocketOption**
- interface **java.net.SocketOptions**
- class **java.net.SocketPermission**
- class **java.net.SocketTimeoutException**
- enum **java.net.StandardProtocolFamily**
- class **java.net.StandardSocketOptions**
- class **java.net.URI**
- class **java.net.URISyntaxException**
- class **java.net.URL**
- class **java.net.URLClassLoader**
- class **java.net.URLConnection**
- class **java.net.URLDecoder**
- class **java.net.URLEncoder**
- class **java.net.URLPermission**
- class **java.net.URLStreamHandler**
- interface **java.net.URLStreamHandlerFactory**
- class **java.net.UnknownHostException**
- class **java.net.UnknownServiceException**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
