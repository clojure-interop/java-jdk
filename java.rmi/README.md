# Bindings for java.rmi

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
[clojure-interop/java.rmi "0.1.0-SNAPSHOT"]
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

- class **java.rmi.AccessException**
- class **java.rmi.AlreadyBoundException**
- class **java.rmi.ConnectException**
- class **java.rmi.ConnectIOException**
- class **java.rmi.MarshalException**
- class **java.rmi.MarshalledObject**
- class **java.rmi.Naming**
- class **java.rmi.NoSuchObjectException**
- class **java.rmi.NotBoundException**
- class **java.rmi.RMISecurityException**
- class **java.rmi.RMISecurityManager**
- interface **java.rmi.Remote**
- class **java.rmi.RemoteException**
- class **java.rmi.ServerError**
- class **java.rmi.ServerException**
- class **java.rmi.ServerRuntimeException**
- class **java.rmi.StubNotFoundException**
- class **java.rmi.UnexpectedException**
- class **java.rmi.UnknownHostException**
- class **java.rmi.UnmarshalException**
- class **java.rmi.activation.Activatable**
- class **java.rmi.activation.ActivateFailedException**
- class **java.rmi.activation.ActivationDesc**
- class **java.rmi.activation.ActivationException**
- class **java.rmi.activation.ActivationGroup**
- class **java.rmi.activation.ActivationGroupDesc$CommandEnvironment**
- class **java.rmi.activation.ActivationGroupDesc**
- class **java.rmi.activation.ActivationGroupID**
- class **java.rmi.activation.ActivationGroup_Stub**
- class **java.rmi.activation.ActivationID**
- interface **java.rmi.activation.ActivationInstantiator**
- interface **java.rmi.activation.ActivationMonitor**
- interface **java.rmi.activation.ActivationSystem**
- interface **java.rmi.activation.Activator**
- class **java.rmi.activation.UnknownGroupException**
- class **java.rmi.activation.UnknownObjectException**
- interface **java.rmi.dgc.DGC**
- class **java.rmi.dgc.Lease**
- class **java.rmi.dgc.VMID**
- class **java.rmi.registry.LocateRegistry**
- interface **java.rmi.registry.Registry**
- interface **java.rmi.registry.RegistryHandler**
- class **java.rmi.server.ExportException**
- interface **java.rmi.server.LoaderHandler**
- class **java.rmi.server.LogStream**
- class **java.rmi.server.ObjID**
- class **java.rmi.server.Operation**
- class **java.rmi.server.RMIClassLoader**
- class **java.rmi.server.RMIClassLoaderSpi**
- interface **java.rmi.server.RMIClientSocketFactory**
- interface **java.rmi.server.RMIFailureHandler**
- interface **java.rmi.server.RMIServerSocketFactory**
- class **java.rmi.server.RMISocketFactory**
- interface **java.rmi.server.RemoteCall**
- class **java.rmi.server.RemoteObject**
- class **java.rmi.server.RemoteObjectInvocationHandler**
- interface **java.rmi.server.RemoteRef**
- class **java.rmi.server.RemoteServer**
- class **java.rmi.server.RemoteStub**
- class **java.rmi.server.ServerCloneException**
- class **java.rmi.server.ServerNotActiveException**
- interface **java.rmi.server.ServerRef**
- interface **java.rmi.server.Skeleton**
- class **java.rmi.server.SkeletonMismatchException**
- class **java.rmi.server.SkeletonNotFoundException**
- class **java.rmi.server.SocketSecurityException**
- class **java.rmi.server.UID**
- class **java.rmi.server.UnicastRemoteObject**
- interface **java.rmi.server.Unreferenced**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
