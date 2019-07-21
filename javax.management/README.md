# Bindings for javax.management

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.management "1.0.5"]
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

- class **javax.management.Attribute**
- class **javax.management.AttributeChangeNotification**
- class **javax.management.AttributeChangeNotificationFilter**
- class **javax.management.AttributeList**
- class **javax.management.AttributeNotFoundException**
- class **javax.management.AttributeValueExp**
- class **javax.management.BadAttributeValueExpException**
- class **javax.management.BadBinaryOpValueExpException**
- class **javax.management.BadStringOperationException**
- class **javax.management.DefaultLoaderRepository**
- interface **javax.management.Descriptor**
- interface **javax.management.DescriptorAccess**
- annotation **javax.management.DescriptorKey**
- interface **javax.management.DescriptorRead**
- interface **javax.management.DynamicMBean**
- class **javax.management.ImmutableDescriptor**
- class **javax.management.InstanceAlreadyExistsException**
- class **javax.management.InstanceNotFoundException**
- class **javax.management.IntrospectionException**
- class **javax.management.InvalidApplicationException**
- class **javax.management.InvalidAttributeValueException**
- class **javax.management.JMException**
- class **javax.management.JMRuntimeException**
- class **javax.management.JMX**
- class **javax.management.ListenerNotFoundException**
- class **javax.management.MBeanAttributeInfo**
- class **javax.management.MBeanConstructorInfo**
- class **javax.management.MBeanException**
- class **javax.management.MBeanFeatureInfo**
- class **javax.management.MBeanInfo**
- class **javax.management.MBeanNotificationInfo**
- class **javax.management.MBeanOperationInfo**
- class **javax.management.MBeanParameterInfo**
- class **javax.management.MBeanPermission**
- interface **javax.management.MBeanRegistration**
- class **javax.management.MBeanRegistrationException**
- interface **javax.management.MBeanServer**
- class **javax.management.MBeanServerBuilder**
- interface **javax.management.MBeanServerConnection**
- class **javax.management.MBeanServerDelegate**
- interface **javax.management.MBeanServerDelegateMBean**
- class **javax.management.MBeanServerFactory**
- class **javax.management.MBeanServerInvocationHandler**
- class **javax.management.MBeanServerNotification**
- class **javax.management.MBeanServerPermission**
- class **javax.management.MBeanTrustPermission**
- annotation **javax.management.MXBean**
- class **javax.management.MalformedObjectNameException**
- class **javax.management.NotCompliantMBeanException**
- class **javax.management.Notification**
- interface **javax.management.NotificationBroadcaster**
- class **javax.management.NotificationBroadcasterSupport**
- interface **javax.management.NotificationEmitter**
- interface **javax.management.NotificationFilter**
- class **javax.management.NotificationFilterSupport**
- interface **javax.management.NotificationListener**
- class **javax.management.ObjectInstance**
- class **javax.management.ObjectName**
- class **javax.management.OperationsException**
- interface **javax.management.PersistentMBean**
- class **javax.management.Query**
- class **javax.management.QueryEval**
- interface **javax.management.QueryExp**
- class **javax.management.ReflectionException**
- class **javax.management.RuntimeErrorException**
- class **javax.management.RuntimeMBeanException**
- class **javax.management.RuntimeOperationsException**
- class **javax.management.ServiceNotFoundException**
- class **javax.management.StandardEmitterMBean**
- class **javax.management.StandardMBean**
- class **javax.management.StringValueExp**
- interface **javax.management.ValueExp**
- interface **javax.management.loading.ClassLoaderRepository**
- class **javax.management.loading.DefaultLoaderRepository**
- class **javax.management.loading.MLet**
- class **javax.management.loading.MLetContent**
- interface **javax.management.loading.MLetMBean**
- interface **javax.management.loading.PrivateClassLoader**
- class **javax.management.loading.PrivateMLet**
- class **javax.management.modelmbean.DescriptorSupport**
- class **javax.management.modelmbean.InvalidTargetObjectTypeException**
- interface **javax.management.modelmbean.ModelMBean**
- class **javax.management.modelmbean.ModelMBeanAttributeInfo**
- class **javax.management.modelmbean.ModelMBeanConstructorInfo**
- interface **javax.management.modelmbean.ModelMBeanInfo**
- class **javax.management.modelmbean.ModelMBeanInfoSupport**
- interface **javax.management.modelmbean.ModelMBeanNotificationBroadcaster**
- class **javax.management.modelmbean.ModelMBeanNotificationInfo**
- class **javax.management.modelmbean.ModelMBeanOperationInfo**
- class **javax.management.modelmbean.RequiredModelMBean**
- class **javax.management.modelmbean.XMLParseException**
- class **javax.management.monitor.CounterMonitor**
- interface **javax.management.monitor.CounterMonitorMBean**
- class **javax.management.monitor.GaugeMonitor**
- interface **javax.management.monitor.GaugeMonitorMBean**
- class **javax.management.monitor.Monitor**
- interface **javax.management.monitor.MonitorMBean**
- class **javax.management.monitor.MonitorNotification**
- class **javax.management.monitor.MonitorSettingException**
- class **javax.management.monitor.StringMonitor**
- interface **javax.management.monitor.StringMonitorMBean**
- class **javax.management.openmbean.ArrayType**
- interface **javax.management.openmbean.CompositeData**
- class **javax.management.openmbean.CompositeDataInvocationHandler**
- class **javax.management.openmbean.CompositeDataSupport**
- interface **javax.management.openmbean.CompositeDataView**
- class **javax.management.openmbean.CompositeType**
- class **javax.management.openmbean.InvalidKeyException**
- class **javax.management.openmbean.InvalidOpenTypeException**
- class **javax.management.openmbean.KeyAlreadyExistsException**
- class **javax.management.openmbean.OpenDataException**
- interface **javax.management.openmbean.OpenMBeanAttributeInfo**
- class **javax.management.openmbean.OpenMBeanAttributeInfoSupport**
- interface **javax.management.openmbean.OpenMBeanConstructorInfo**
- class **javax.management.openmbean.OpenMBeanConstructorInfoSupport**
- interface **javax.management.openmbean.OpenMBeanInfo**
- class **javax.management.openmbean.OpenMBeanInfoSupport**
- interface **javax.management.openmbean.OpenMBeanOperationInfo**
- class **javax.management.openmbean.OpenMBeanOperationInfoSupport**
- interface **javax.management.openmbean.OpenMBeanParameterInfo**
- class **javax.management.openmbean.OpenMBeanParameterInfoSupport**
- class **javax.management.openmbean.OpenType**
- class **javax.management.openmbean.SimpleType**
- interface **javax.management.openmbean.TabularData**
- class **javax.management.openmbean.TabularDataSupport**
- class **javax.management.openmbean.TabularType**
- class **javax.management.relation.InvalidRelationIdException**
- class **javax.management.relation.InvalidRelationServiceException**
- class **javax.management.relation.InvalidRelationTypeException**
- class **javax.management.relation.InvalidRoleInfoException**
- class **javax.management.relation.InvalidRoleValueException**
- class **javax.management.relation.MBeanServerNotificationFilter**
- interface **javax.management.relation.Relation**
- class **javax.management.relation.RelationException**
- class **javax.management.relation.RelationNotFoundException**
- class **javax.management.relation.RelationNotification**
- class **javax.management.relation.RelationService**
- interface **javax.management.relation.RelationServiceMBean**
- class **javax.management.relation.RelationServiceNotRegisteredException**
- class **javax.management.relation.RelationSupport**
- interface **javax.management.relation.RelationSupportMBean**
- interface **javax.management.relation.RelationType**
- class **javax.management.relation.RelationTypeNotFoundException**
- class **javax.management.relation.RelationTypeSupport**
- class **javax.management.relation.Role**
- class **javax.management.relation.RoleInfo**
- class **javax.management.relation.RoleInfoNotFoundException**
- class **javax.management.relation.RoleList**
- class **javax.management.relation.RoleNotFoundException**
- class **javax.management.relation.RoleResult**
- class **javax.management.relation.RoleStatus**
- class **javax.management.relation.RoleUnresolved**
- class **javax.management.relation.RoleUnresolvedList**
- interface **javax.management.remote.JMXAddressable**
- interface **javax.management.remote.JMXAuthenticator**
- class **javax.management.remote.JMXConnectionNotification**
- interface **javax.management.remote.JMXConnector**
- class **javax.management.remote.JMXConnectorFactory**
- interface **javax.management.remote.JMXConnectorProvider**
- class **javax.management.remote.JMXConnectorServer**
- class **javax.management.remote.JMXConnectorServerFactory**
- interface **javax.management.remote.JMXConnectorServerMBean**
- interface **javax.management.remote.JMXConnectorServerProvider**
- class **javax.management.remote.JMXPrincipal**
- class **javax.management.remote.JMXProviderException**
- class **javax.management.remote.JMXServerErrorException**
- class **javax.management.remote.JMXServiceURL**
- interface **javax.management.remote.MBeanServerForwarder**
- class **javax.management.remote.NotificationResult**
- class **javax.management.remote.SubjectDelegationPermission**
- class **javax.management.remote.TargetedNotification**
- interface **javax.management.remote.rmi.RMIConnection**
- class **javax.management.remote.rmi.RMIConnectionImpl**
- class **javax.management.remote.rmi.RMIConnectionImpl_Stub**
- class **javax.management.remote.rmi.RMIConnector**
- class **javax.management.remote.rmi.RMIConnectorServer**
- class **javax.management.remote.rmi.RMIIIOPServerImpl**
- class **javax.management.remote.rmi.RMIJRMPServerImpl**
- interface **javax.management.remote.rmi.RMIServer**
- class **javax.management.remote.rmi.RMIServerImpl**
- class **javax.management.remote.rmi.RMIServerImpl_Stub**
- class **javax.management.timer.Timer**
- interface **javax.management.timer.TimerMBean**
- class **javax.management.timer.TimerNotification**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
