(ns jdk.util.spi.ResourceBundleControlProvider
  "An interface for service providers that provide implementations of ResourceBundle.Control. The default resource bundle loading
  behavior of the ResourceBundle.getBundle factory methods that take
  no ResourceBundle.Control instance can be modified with ResourceBundleControlProvider implementations.

  Provider implementations must be packaged using the Java Extension
  Mechanism as installed extensions. Refer to ServiceLoader
  for the extension packaging. Any installed ResourceBundleControlProvider implementations are loaded using ServiceLoader at the ResourceBundle class loading time."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.spi ResourceBundleControlProvider]))

(defn get-control
  "Returns a ResourceBundle.Control instance that is used
   to handle resource bundle loading for the given baseName. This method must return null if the given
   baseName isn't handled by this provider.

  base-name - the base name of the resource bundle - `java.lang.String`

  returns: a ResourceBundle.Control instance,
           or null if the given baseName is not
           applicable to this provider. - `java.util.ResourceBundle.Control`

  throws: java.lang.NullPointerException - if baseName is null"
  ([this base-name]
    (-> this (.getControl base-name))))

