(ns jdk.beans.Introspector
  "The Introspector class provides a standard way for tools to learn about
  the properties, events, and methods supported by a target Java Bean.

  For each of those three kinds of information, the Introspector will
  separately analyze the bean's class and superclasses looking for
  either explicit or implicit information and use that information to
  build a BeanInfo object that comprehensively describes the target bean.

  For each class `Foo`, explicit information may be available if there exists
  a corresponding `FooBeanInfo` class that provides a non-null value when
  queried for the information.   We first look for the BeanInfo class by
  taking the full package-qualified name of the target bean class and
  appending `BeanInfo` to form a new class name.  If this fails, then
  we take the final classname component of this name, and look for that
  class in each of the packages specified in the BeanInfo package search
  path.

  Thus for a class such as `sun.xyz.OurButton` we would first look for a
  BeanInfo class called `sun.xyz.OurButtonBeanInfo` and if that failed we'd
  look in each package in the BeanInfo search path for an OurButtonBeanInfo
  class.  With the default search path, this would mean looking for
  `sun.beans.infos.OurButtonBeanInfo`.

  If a class provides explicit BeanInfo about itself then we add that to
  the BeanInfo information we obtained from analyzing any derived classes,
  but we regard the explicit information as being definitive for the current
  class and its base classes, and do not proceed any further up the superclass
  chain.

  If we don't find explicit BeanInfo on a class, we use low-level
  reflection to study the methods of the class and apply standard design
  patterns to identify property accessors, event sources, or public
  methods.  We then proceed to analyze the class's superclass and add
  in the information from it (and possibly on up the superclass chain).

  For more information about introspection and design patterns, please
  consult the
   JavaBeans™ specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans Introspector]))

(def *-use-all-beaninfo
  "Static Constant.

  Flag to indicate to use of all beaninfo.

  type: int"
  Introspector/USE_ALL_BEANINFO)

(def *-ignore-immediate-beaninfo
  "Static Constant.

  Flag to indicate to ignore immediate beaninfo.

  type: int"
  Introspector/IGNORE_IMMEDIATE_BEANINFO)

(def *-ignore-all-beaninfo
  "Static Constant.

  Flag to indicate to ignore all beaninfo.

  type: int"
  Introspector/IGNORE_ALL_BEANINFO)

(defn *get-bean-info
  "Introspect on a Java Bean and learn about all its properties,
   exposed methods and events, below a given stopClass point
   subject to some control flags.

    USE_ALL_BEANINFO
    Any BeanInfo that can be discovered will be used.
    IGNORE_IMMEDIATE_BEANINFO
    Any BeanInfo associated with the specified beanClass will be ignored.
    IGNORE_ALL_BEANINFO
    Any BeanInfo associated with the specified beanClass
        or any of its parent classes will be ignored.

   Any methods/properties/events in the stopClass
   or in its parent classes will be ignored in the analysis.

   If the BeanInfo class for a Java Bean has been
   previously introspected based on the same arguments then
   the BeanInfo class is retrieved from the BeanInfo cache.

  bean-class - the bean class to be analyzed - `java.lang.Class<?>`
  stop-class - the parent class at which to stop the analysis - `java.lang.Class<?>`
  flags - flags to control the introspection - `int`

  returns: a BeanInfo object describing the target bean - `java.beans.BeanInfo`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection"
  ([bean-class stop-class flags]
    (Introspector/getBeanInfo bean-class stop-class flags))
  ([bean-class flags]
    (Introspector/getBeanInfo bean-class flags))
  ([bean-class]
    (Introspector/getBeanInfo bean-class)))

(defn *decapitalize
  "Utility method to take a string and convert it to normal Java variable
   name capitalization.  This normally means converting the first
   character from upper case to lower case, but in the (unusual) special
   case when there is more than one character and both the first and
   second characters are upper case, we leave it alone.

   Thus `FooBah` becomes `fooBah` and `X` becomes `x`, but `URL` stays
   as `URL`.

  name - The string to be decapitalized. - `java.lang.String`

  returns: The decapitalized version of the string. - `java.lang.String`"
  ([name]
    (Introspector/decapitalize name)))

(defn *get-bean-info-search-path
  "Gets the list of package names that will be used for
            finding BeanInfo classes.

  returns: The array of package names that will be searched in
            order to find BeanInfo classes. The default value
            for this array is implementation-dependent; e.g.
            Sun implementation initially sets to {`sun.beans.infos`}. - `java.lang.String[]`"
  ([]
    (Introspector/getBeanInfoSearchPath )))

(defn *set-bean-info-search-path
  "Change the list of package names that will be used for
            finding BeanInfo classes.  The behaviour of
            this method is undefined if parameter path
            is null.

   First, if there is a security manager, its checkPropertiesAccess
   method is called. This could result in a SecurityException.

  path - Array of package names. - `java.lang.String[]`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow setting of system properties."
  ([path]
    (Introspector/setBeanInfoSearchPath path)))

(defn *flush-caches
  "Flush all of the Introspector's internal caches.  This method is
   not normally required.  It is normally only needed by advanced
   tools that update existing `Class` objects in-place and need
   to make the Introspector re-analyze existing Class objects."
  ([]
    (Introspector/flushCaches )))

(defn *flush-from-caches
  "Flush the Introspector's internal cached information for a given class.
   This method is not normally required.  It is normally only needed
   by advanced tools that update existing `Class` objects in-place
   and need to make the Introspector re-analyze an existing Class object.

   Note that only the direct state associated with the target Class
   object is flushed.  We do not flush state for other Class objects
   with the same name, nor do we flush state for any related Class
   objects (such as subclasses), even though their state may include
   information indirectly obtained from the target Class object.

  clz - Class object to be flushed. - `java.lang.Class<?>`

  throws: java.lang.NullPointerException - If the Class object is null."
  ([clz]
    (Introspector/flushFromCaches clz)))

