(ns javax.naming.ldap.ControlFactory
  "This abstract class represents a factory for creating LDAPv3 controls.
  LDAPv3 controls are defined in
  RFC 2251.

  When a service provider receives a response control, it uses control
  factories to return the specific/appropriate control class implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap ControlFactory]))

(defn *get-control-instance
  "Creates a control using known control factories.

   The following rule is used to create the control:

    Use the control factories specified in
      the LdapContext.CONTROL_FACTORIES property of the
      environment, and of the provider resource file associated with
      ctx, in that order.
      The value of this property is a colon-separated list of factory
      class names that are tried in order, and the first one that succeeds
      in creating the control is the one used.
      If none of the factories can be loaded,
      return ctl.
      If an exception is encountered while creating the control, the
      exception is passed up to the caller.


   Note that a control factory
   must be public and must have a public constructor that accepts no arguments.

  ctl - The non-null control object containing the OID and BER data. - `javax.naming.ldap.Control`
  ctx - The possibly null context in which the control is being created. If null, no such information is available. - `javax.naming.Context`
  env - The possibly null environment of the context. This is used to find the value of the LdapContext.CONTROL_FACTORIES property. - `java.util.Hashtable<?,?>`

  returns: A control object created using ctl; or
           ctl if a control object cannot be created using
           the algorithm described above. - `javax.naming.ldap.Control`

  throws: javax.naming.NamingException - if a naming exception was encountered while attempting to create the control object. If one of the factories accessed throws an exception, it is propagated up to the caller. If an error was encountered while loading and instantiating the factory and object classes, the exception is wrapped inside a NamingException and then rethrown."
  (^javax.naming.ldap.Control [^javax.naming.ldap.Control ctl ^javax.naming.Context ctx ^java.util.Hashtable env]
    (ControlFactory/getControlInstance ctl ctx env)))

(defn get-control-instance
  "Creates a control using this control factory.

   The factory is used by the service provider to return controls
   that it reads from the LDAP protocol as specialized control classes.
   Without this mechanism, the provider would be returning
   controls that only contained data in BER encoded format.

   Typically, ctl is a `basic` control containing
   BER encoded data. The factory is used to create a specialized
   control implementation, usually by decoding the BER encoded data,
   that provides methods to access that data in a type-safe and friendly
   manner.

   For example, a factory might use the BER encoded data in
   basic control and return an instance of a VirtualListReplyControl.

   If this factory cannot create a control using the argument supplied,
   it should return null.
   A factory should only throw an exception if it is sure that
   it is the only intended factory and that no other control factories
   should be tried. This might happen, for example, if the BER data
   in the control does not match what is expected of a control with
   the given OID. Since this method throws NamingException,
   any other internally generated exception that should be propagated
   must be wrapped inside a NamingException.

  ctl - A non-null control. - `javax.naming.ldap.Control`

  returns: A possibly null Control. - `javax.naming.ldap.Control`

  throws: javax.naming.NamingException - If ctl contains invalid data that prevents it from being used to create a control. A factory should only throw an exception if it knows how to produce the control (identified by the OID) but is unable to because of, for example invalid BER data."
  (^javax.naming.ldap.Control [^javax.naming.ldap.ControlFactory this ^javax.naming.ldap.Control ctl]
    (-> this (.getControlInstance ctl))))

