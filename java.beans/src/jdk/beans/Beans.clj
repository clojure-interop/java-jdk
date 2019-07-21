(ns jdk.beans.Beans
  "This class provides some general purpose beans control methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Beans]))

(defn ->beans
  "Constructor."
  (^Beans []
    (new Beans )))

(defn *instantiate
  "Instantiate a bean.

   The bean is created based on a name relative to a class-loader.
   This name should be a dot-separated name such as \"a.b.c\".

   In Beans 1.0 the given name can indicate either a serialized object
   or a class.  Other mechanisms may be added in the future.  In
   beans 1.0 we first try to treat the beanName as a serialized object
   name then as a class name.

   When using the beanName as a serialized object name we convert the
   given beanName to a resource pathname and add a trailing \".ser\" suffix.
   We then try to load a serialized object from that resource.

   For example, given a beanName of \"x.y\", Beans.instantiate would first
   try to read a serialized object from the resource \"x/y.ser\" and if
   that failed it would try to load the class \"x.y\" and create an
   instance of that class.

   If the bean is a subtype of java.applet.Applet, then it is given
   some special initialization.  First, it is supplied with a default
   AppletStub and AppletContext.  Second, if it was instantiated from
   a classname the applet's \"init\" method is called.  (If the bean was
   deserialized this step is skipped.)

   Note that for beans which are applets, it is the caller's responsiblity
   to call \"start\" on the applet.  For correct behaviour, this should be done
   after the applet has been added into a visible AWT container.

   Note that applets created via beans.instantiate run in a slightly
   different environment than applets running inside browsers.  In
   particular, bean applets have no access to \"parameters\", so they may
   wish to provide property get/set methods to set parameter values.  We
   advise bean-applet developers to test their bean-applets against both
   the JDK appletviewer (for a reference browser environment) and the
   BDK BeanBox (for a reference bean container).

  cls - the class-loader from which we should create the bean. If this is null, then the system class-loader is used. - `java.lang.ClassLoader`
  bean-name - the name of the bean within the class-loader. For example \"sun.beanbox.foobah\" - `java.lang.String`
  bean-context - The BeanContext in which to nest the new bean - `java.beans.beancontext.BeanContext`
  initializer - The AppletInitializer for the new bean - `java.beans.AppletInitializer`

  returns: a JavaBean - `java.lang.Object`

  throws: java.lang.ClassNotFoundException - if the class of a serialized object could not be found."
  (^java.lang.Object [^java.lang.ClassLoader cls ^java.lang.String bean-name ^java.beans.beancontext.BeanContext bean-context ^java.beans.AppletInitializer initializer]
    (Beans/instantiate cls bean-name bean-context initializer))
  (^java.lang.Object [^java.lang.ClassLoader cls ^java.lang.String bean-name ^java.beans.beancontext.BeanContext bean-context]
    (Beans/instantiate cls bean-name bean-context))
  (^java.lang.Object [^java.lang.ClassLoader cls ^java.lang.String bean-name]
    (Beans/instantiate cls bean-name)))

(defn *get-instance-of
  "From a given bean, obtain an object representing a specified
   type view of that source object.

   The result may be the same object or a different object.  If
   the requested target view isn't available then the given
   bean is returned.

   This method is provided in Beans 1.0 as a hook to allow the
   addition of more flexible bean behaviour in the future.

  bean - Object from which we want to obtain a view. - `java.lang.Object`
  target-type - The type of view we'd like to get. - `java.lang.Class`

  returns: an object representing a specified type view of the
   source object - `java.lang.Object`"
  (^java.lang.Object [^java.lang.Object bean ^java.lang.Class target-type]
    (Beans/getInstanceOf bean target-type)))

(defn *instance-of?
  "Check if a bean can be viewed as a given target type.
   The result will be true if the Beans.getInstanceof method
   can be used on the given bean to obtain an object that
   represents the specified targetType type view.

  bean - Bean from which we want to obtain a view. - `java.lang.Object`
  target-type - The type of view we'd like to get. - `java.lang.Class`

  returns: \"true\" if the given bean supports the given targetType. - `boolean`"
  (^Boolean [^java.lang.Object bean ^java.lang.Class target-type]
    (Beans/isInstanceOf bean target-type)))

(defn *design-time?
  "Test if we are in design-mode.

  returns: True if we are running in an application construction
            environment. - `boolean`"
  (^Boolean []
    (Beans/isDesignTime )))

(defn *gui-available?
  "Determines whether beans can assume a GUI is available.

  returns: True if we are running in an environment where beans
       can assume that an interactive GUI is available, so they
       can pop up dialog boxes, etc.  This will normally return
       true in a windowing environment, and will normally return
       false in a server environment or if an application is
       running as part of a batch job. - `boolean`"
  (^Boolean []
    (Beans/isGuiAvailable )))

(defn *set-design-time
  "Used to indicate whether of not we are running in an application
   builder environment.

   Note that this method is security checked
   and is not available to (for example) untrusted applets.
   More specifically, if there is a security manager,
   its checkPropertiesAccess
   method is called. This could result in a SecurityException.

  is-design-time - True if we're in an application builder tool. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow setting of system properties."
  ([^Boolean is-design-time]
    (Beans/setDesignTime is-design-time)))

(defn *set-gui-available
  "Used to indicate whether of not we are running in an environment
   where GUI interaction is available.

   Note that this method is security checked
   and is not available to (for example) untrusted applets.
   More specifically, if there is a security manager,
   its checkPropertiesAccess
   method is called. This could result in a SecurityException.

  is-gui-available - True if GUI interaction is available. - `boolean`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow setting of system properties."
  ([^Boolean is-gui-available]
    (Beans/setGuiAvailable is-gui-available)))

