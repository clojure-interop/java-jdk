# Bindings for java.lang

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.lang "1.0.0"]
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

- class **java.lang.AbstractMethodError**
- interface **java.lang.Appendable**
- class **java.lang.ArithmeticException**
- class **java.lang.ArrayIndexOutOfBoundsException**
- class **java.lang.ArrayStoreException**
- class **java.lang.AssertionError**
- interface **java.lang.AutoCloseable**
- class **java.lang.Boolean**
- class **java.lang.BootstrapMethodError**
- class **java.lang.Byte**
- interface **java.lang.CharSequence**
- class **java.lang.Character$Subset**
- class **java.lang.Character$UnicodeBlock**
- enum **java.lang.Character$UnicodeScript**
- class **java.lang.Character**
- class **java.lang.Class**
- class **java.lang.ClassCastException**
- class **java.lang.ClassCircularityError**
- class **java.lang.ClassFormatError**
- class **java.lang.ClassLoader**
- class **java.lang.ClassNotFoundException**
- class **java.lang.ClassValue**
- class **java.lang.CloneNotSupportedException**
- interface **java.lang.Cloneable**
- interface **java.lang.Comparable**
- class **java.lang.Compiler**
- annotation **java.lang.Deprecated**
- class **java.lang.Double**
- class **java.lang.Enum>**
- class **java.lang.EnumConstantNotPresentException**
- class **java.lang.Error**
- class **java.lang.Exception**
- class **java.lang.ExceptionInInitializerError**
- class **java.lang.Float**
- annotation **java.lang.FunctionalInterface**
- class **java.lang.IllegalAccessError**
- class **java.lang.IllegalAccessException**
- class **java.lang.IllegalArgumentException**
- class **java.lang.IllegalMonitorStateException**
- class **java.lang.IllegalStateException**
- class **java.lang.IllegalThreadStateException**
- class **java.lang.IncompatibleClassChangeError**
- class **java.lang.IndexOutOfBoundsException**
- class **java.lang.InheritableThreadLocal**
- class **java.lang.InstantiationError**
- class **java.lang.InstantiationException**
- class **java.lang.Integer**
- class **java.lang.InternalError**
- class **java.lang.InterruptedException**
- interface **java.lang.Iterable**
- class **java.lang.LinkageError**
- class **java.lang.Long**
- class **java.lang.Math**
- class **java.lang.NegativeArraySizeException**
- class **java.lang.NoClassDefFoundError**
- class **java.lang.NoSuchFieldError**
- class **java.lang.NoSuchFieldException**
- class **java.lang.NoSuchMethodError**
- class **java.lang.NoSuchMethodException**
- class **java.lang.NullPointerException**
- class **java.lang.Number**
- class **java.lang.NumberFormatException**
- class **java.lang.Object**
- class **java.lang.OutOfMemoryError**
- annotation **java.lang.Override**
- class **java.lang.Package**
- class **java.lang.Process**
- enum **java.lang.ProcessBuilder$Redirect$Type**
- class **java.lang.ProcessBuilder$Redirect**
- class **java.lang.ProcessBuilder**
- interface **java.lang.Readable**
- class **java.lang.ReflectiveOperationException**
- interface **java.lang.Runnable**
- class **java.lang.Runtime**
- class **java.lang.RuntimeException**
- class **java.lang.RuntimePermission**
- annotation **java.lang.SafeVarargs**
- class **java.lang.SecurityException**
- class **java.lang.SecurityManager**
- class **java.lang.Short**
- class **java.lang.StackOverflowError**
- class **java.lang.StackTraceElement**
- class **java.lang.StrictMath**
- class **java.lang.String**
- class **java.lang.StringBuffer**
- class **java.lang.StringBuilder**
- class **java.lang.StringIndexOutOfBoundsException**
- annotation **java.lang.SuppressWarnings**
- class **java.lang.System**
- enum **java.lang.Thread$State**
- interface **java.lang.Thread$UncaughtExceptionHandler**
- class **java.lang.Thread**
- class **java.lang.ThreadDeath**
- class **java.lang.ThreadGroup**
- class **java.lang.ThreadLocal**
- class **java.lang.Throwable**
- class **java.lang.TypeNotPresentException**
- class **java.lang.UnknownError**
- class **java.lang.UnsatisfiedLinkError**
- class **java.lang.UnsupportedClassVersionError**
- class **java.lang.UnsupportedOperationException**
- class **java.lang.VerifyError**
- class **java.lang.VirtualMachineError**
- class **java.lang.Void**
- interface **java.lang.annotation.Annotation**
- class **java.lang.annotation.AnnotationFormatError**
- class **java.lang.annotation.AnnotationTypeMismatchException**
- annotation **java.lang.annotation.Documented**
- enum **java.lang.annotation.ElementType**
- class **java.lang.annotation.IncompleteAnnotationException**
- annotation **java.lang.annotation.Inherited**
- annotation **java.lang.annotation.Native**
- annotation **java.lang.annotation.Repeatable**
- annotation **java.lang.annotation.Retention**
- enum **java.lang.annotation.RetentionPolicy**
- annotation **java.lang.annotation.Target**
- class **java.lang.instrument.ClassDefinition**
- interface **java.lang.instrument.ClassFileTransformer**
- class **java.lang.instrument.IllegalClassFormatException**
- interface **java.lang.instrument.Instrumentation**
- class **java.lang.instrument.UnmodifiableClassException**
- class **java.lang.invoke.CallSite**
- class **java.lang.invoke.ConstantCallSite**
- class **java.lang.invoke.LambdaConversionException**
- class **java.lang.invoke.LambdaMetafactory**
- class **java.lang.invoke.MethodHandle**
- interface **java.lang.invoke.MethodHandleInfo**
- class **java.lang.invoke.MethodHandleProxies**
- class **java.lang.invoke.MethodHandles$Lookup**
- class **java.lang.invoke.MethodHandles**
- class **java.lang.invoke.MethodType**
- class **java.lang.invoke.MutableCallSite**
- class **java.lang.invoke.SerializedLambda**
- class **java.lang.invoke.SwitchPoint**
- class **java.lang.invoke.VolatileCallSite**
- class **java.lang.invoke.WrongMethodTypeException**
- interface **java.lang.management.BufferPoolMXBean**
- interface **java.lang.management.ClassLoadingMXBean**
- interface **java.lang.management.CompilationMXBean**
- interface **java.lang.management.GarbageCollectorMXBean**
- class **java.lang.management.LockInfo**
- class **java.lang.management.ManagementFactory**
- class **java.lang.management.ManagementPermission**
- interface **java.lang.management.MemoryMXBean**
- interface **java.lang.management.MemoryManagerMXBean**
- class **java.lang.management.MemoryNotificationInfo**
- interface **java.lang.management.MemoryPoolMXBean**
- enum **java.lang.management.MemoryType**
- class **java.lang.management.MemoryUsage**
- class **java.lang.management.MonitorInfo**
- interface **java.lang.management.OperatingSystemMXBean**
- interface **java.lang.management.PlatformLoggingMXBean**
- interface **java.lang.management.PlatformManagedObject**
- interface **java.lang.management.RuntimeMXBean**
- class **java.lang.management.ThreadInfo**
- interface **java.lang.management.ThreadMXBean**
- class **java.lang.ref.PhantomReference**
- class **java.lang.ref.Reference**
- class **java.lang.ref.ReferenceQueue**
- class **java.lang.ref.SoftReference**
- class **java.lang.ref.WeakReference**
- class **java.lang.reflect.AccessibleObject**
- interface **java.lang.reflect.AnnotatedArrayType**
- interface **java.lang.reflect.AnnotatedElement**
- interface **java.lang.reflect.AnnotatedParameterizedType**
- interface **java.lang.reflect.AnnotatedType**
- interface **java.lang.reflect.AnnotatedTypeVariable**
- interface **java.lang.reflect.AnnotatedWildcardType**
- class **java.lang.reflect.Array**
- class **java.lang.reflect.Constructor**
- class **java.lang.reflect.Executable**
- class **java.lang.reflect.Field**
- interface **java.lang.reflect.GenericArrayType**
- interface **java.lang.reflect.GenericDeclaration**
- class **java.lang.reflect.GenericSignatureFormatError**
- interface **java.lang.reflect.InvocationHandler**
- class **java.lang.reflect.InvocationTargetException**
- class **java.lang.reflect.MalformedParameterizedTypeException**
- class **java.lang.reflect.MalformedParametersException**
- interface **java.lang.reflect.Member**
- class **java.lang.reflect.Method**
- class **java.lang.reflect.Modifier**
- class **java.lang.reflect.Parameter**
- interface **java.lang.reflect.ParameterizedType**
- class **java.lang.reflect.Proxy**
- class **java.lang.reflect.ReflectPermission**
- interface **java.lang.reflect.Type**
- interface **java.lang.reflect.TypeVariable**
- class **java.lang.reflect.UndeclaredThrowableException**
- interface **java.lang.reflect.WildcardType**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
