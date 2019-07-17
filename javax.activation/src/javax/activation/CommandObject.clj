(ns javax.activation.CommandObject
  "JavaBeans components that are Activation Framework aware implement
  this interface to find out which command verb they're being asked
  to perform, and to obtain the DataHandler representing the
  data they should operate on.  JavaBeans that don't implement
  this interface may be used as well.  Such commands may obtain
  the data using the Externalizable interface, or using an
  application-specific method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation CommandObject]))

(defn set-command-context
  "Initialize the Command with the verb it is requested to handle
   and the DataHandler that describes the data it will
   operate on. NOTE: it is acceptable for the caller
   to pass null as the value for DataHandler.

  verb - The Command Verb this object refers to. - `java.lang.String`
  dh - The DataHandler. - `javax.activation.DataHandler`

  throws: java.io.IOException"
  ([^. this ^java.lang.String verb ^javax.activation.DataHandler dh]
    (-> this (.setCommandContext verb dh))))

