(ns javax.annotation.processing.ProcessingEnvironment
  "An annotation processing tool framework will provide an annotation processor with an object
  implementing this interface so the processor can use facilities
  provided by the framework to write new files, report error
  messages, and find other utilities.

  Third parties may wish to provide value-add wrappers around the
  facility objects from this interface, for example a Filer
  extension that allows multiple processors to coordinate writing out
  a single source file.  To enable this, for processors running in a
  context where their side effects via the API could be visible to
  each other, the tool infrastructure must provide corresponding
  facility objects that are .equals, Filers that are
  .equals, and so on.  In addition, the tool invocation must
  be able to be configured such that from the perspective of the
  running annotation processors, at least the chosen subset of helper
  classes are viewed as being loaded by the same class loader.
  (Since the facility objects manage shared state, the implementation
  of a wrapper class must know whether or not the same base facility
  object has been wrapped before.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing ProcessingEnvironment]))

(defn get-options
  "Returns the processor-specific options passed to the annotation
   processing tool.  Options are returned in the form of a map from
   option name to option value.  For an option with no value, the
   corresponding value in the map is null.

   See documentation of the particular tool infrastructure
   being used for details on how to pass in processor-specific
   options.  For example, a command-line implementation may
   distinguish processor-specific options by prefixing them with a
   known string like \"-A\"; other tool implementations may
   follow different conventions or provide alternative mechanisms.
   A given implementation may also provide implementation-specific
   ways of finding options passed to the tool in addition to the
   processor-specific options.

  returns: the processor-specific options passed to the tool - `java.util.Map<java.lang.String,java.lang.String>`"
  (^java.util.Map [^ProcessingEnvironment this]
    (-> this (.getOptions))))

(defn get-messager
  "Returns the messager used to report errors, warnings, and other
   notices.

  returns: the messager - `javax.annotation.processing.Messager`"
  (^javax.annotation.processing.Messager [^ProcessingEnvironment this]
    (-> this (.getMessager))))

(defn get-filer
  "Returns the filer used to create new source, class, or auxiliary
   files.

  returns: the filer - `javax.annotation.processing.Filer`"
  (^javax.annotation.processing.Filer [^ProcessingEnvironment this]
    (-> this (.getFiler))))

(defn get-element-utils
  "Returns an implementation of some utility methods for
   operating on elements

  returns: element utilities - `javax.lang.model.util.Elements`"
  (^javax.lang.model.util.Elements [^ProcessingEnvironment this]
    (-> this (.getElementUtils))))

(defn get-type-utils
  "Returns an implementation of some utility methods for
   operating on types.

  returns: type utilities - `javax.lang.model.util.Types`"
  (^javax.lang.model.util.Types [^ProcessingEnvironment this]
    (-> this (.getTypeUtils))))

(defn get-source-version
  "Returns the source version that any generated source and class files should conform to.

  returns: the source version to which generated source and class
           files should conform to - `javax.lang.model.SourceVersion`"
  (^javax.lang.model.SourceVersion [^ProcessingEnvironment this]
    (-> this (.getSourceVersion))))

(defn get-locale
  "Returns the current locale or null if no locale is in
   effect.  The locale can be be used to provide localized
   javax.annotation.processing.messages.

  returns: the current locale or null if no locale is in
   effect - `java.util.Locale`"
  (^java.util.Locale [^ProcessingEnvironment this]
    (-> this (.getLocale))))

