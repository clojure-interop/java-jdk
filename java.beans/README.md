# Bindings for java.beans

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.beans "1.0.0"]
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

- interface **java.beans.AppletInitializer**
- class **java.beans.BeanDescriptor**
- interface **java.beans.BeanInfo**
- class **java.beans.Beans**
- annotation **java.beans.ConstructorProperties**
- interface **java.beans.Customizer**
- class **java.beans.DefaultPersistenceDelegate**
- interface **java.beans.DesignMode**
- class **java.beans.Encoder**
- class **java.beans.EventHandler**
- class **java.beans.EventSetDescriptor**
- interface **java.beans.ExceptionListener**
- class **java.beans.Expression**
- class **java.beans.FeatureDescriptor**
- class **java.beans.IndexedPropertyChangeEvent**
- class **java.beans.IndexedPropertyDescriptor**
- class **java.beans.IntrospectionException**
- class **java.beans.Introspector**
- class **java.beans.MethodDescriptor**
- class **java.beans.ParameterDescriptor**
- class **java.beans.PersistenceDelegate**
- class **java.beans.PropertyChangeEvent**
- interface **java.beans.PropertyChangeListener**
- class **java.beans.PropertyChangeListenerProxy**
- class **java.beans.PropertyChangeSupport**
- class **java.beans.PropertyDescriptor**
- interface **java.beans.PropertyEditor**
- class **java.beans.PropertyEditorManager**
- class **java.beans.PropertyEditorSupport**
- class **java.beans.PropertyVetoException**
- class **java.beans.SimpleBeanInfo**
- class **java.beans.Statement**
- annotation **java.beans.Transient**
- interface **java.beans.VetoableChangeListener**
- class **java.beans.VetoableChangeListenerProxy**
- class **java.beans.VetoableChangeSupport**
- interface **java.beans.Visibility**
- class **java.beans.XMLDecoder**
- class **java.beans.XMLEncoder**
- interface **java.beans.beancontext.BeanContext**
- interface **java.beans.beancontext.BeanContextChild**
- interface **java.beans.beancontext.BeanContextChildComponentProxy**
- class **java.beans.beancontext.BeanContextChildSupport**
- interface **java.beans.beancontext.BeanContextContainerProxy**
- class **java.beans.beancontext.BeanContextEvent**
- class **java.beans.beancontext.BeanContextMembershipEvent**
- interface **java.beans.beancontext.BeanContextMembershipListener**
- interface **java.beans.beancontext.BeanContextProxy**
- class **java.beans.beancontext.BeanContextServiceAvailableEvent**
- interface **java.beans.beancontext.BeanContextServiceProvider**
- interface **java.beans.beancontext.BeanContextServiceProviderBeanInfo**
- class **java.beans.beancontext.BeanContextServiceRevokedEvent**
- interface **java.beans.beancontext.BeanContextServiceRevokedListener**
- interface **java.beans.beancontext.BeanContextServices**
- interface **java.beans.beancontext.BeanContextServicesListener**
- class **java.beans.beancontext.BeanContextServicesSupport$BCSSServiceProvider**
- class **java.beans.beancontext.BeanContextServicesSupport**
- class **java.beans.beancontext.BeanContextSupport$BCSIterator**
- class **java.beans.beancontext.BeanContextSupport**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
