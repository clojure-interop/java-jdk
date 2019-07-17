(ns javax.print.attribute.TextSyntax
  "Class TextSyntax is an abstract base class providing the common
  implementation of all attributes whose value is a string. The text attribute
  includes a locale to indicate the natural language. Thus, a text attribute
  always represents a localized string. Once constructed, a text attribute's
  value is immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute TextSyntax]))

(defn get-value
  "Returns this text attribute's text string.

  returns: the text string. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.TextSyntax this]
    (-> this (.getValue))))

(defn get-locale
  "Returns this text attribute's text string's natural language (locale).

  returns: the locale - `java.util.Locale`"
  (^java.util.Locale [^javax.print.attribute.TextSyntax this]
    (-> this (.getLocale))))

(defn hash-code
  "Returns a hashcode for this text attribute.

  returns: A hashcode value for this object. - `int`"
  (^Integer [^javax.print.attribute.TextSyntax this]
    (-> this (.hashCode))))

(defn equals
  "Returns whether this text attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class TextSyntax.

   This text attribute's underlying string and object's
   underlying string are equal.

   This text attribute's locale and object's locale are
   equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this text
            attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.TextSyntax this ^java.lang.Object object]
    (-> this (.equals object))))

(defn to-string
  "Returns a String identifying this text attribute. The String is
   the attribute's underlying text string.

  returns: A String identifying this object. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.TextSyntax this]
    (-> this (.toString))))

