(ns javax.lang.model.SourceVersion
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model SourceVersion]))

(def RELEASE_0
  "Enum Constant.

  The original version.

   The language described in
   The Java™ Language Specification, First Edition.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_0)

(def RELEASE_1
  "Enum Constant.

  The version recognized by the Java Platform 1.1.

   The language is RELEASE_0 augmented with nested classes as described in the 1.1 update to
   The Java™ Language Specification, First Edition.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_1)

(def RELEASE_2
  "Enum Constant.

  The version recognized by the Java 2 Platform, Standard Edition,
   v 1.2.

   The language described in
   The Java™ Language Specification,
   Second Edition, which includes the strictfp modifier.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_2)

(def RELEASE_3
  "Enum Constant.

  The version recognized by the Java 2 Platform, Standard Edition,
   v 1.3.

   No major changes from RELEASE_2.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_3)

(def RELEASE_4
  "Enum Constant.

  The version recognized by the Java 2 Platform, Standard Edition,
   v 1.4.

   Added a simple assertion facility.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_4)

(def RELEASE_5
  "Enum Constant.

  The version recognized by the Java 2 Platform, Standard
   Edition 5.0.

   The language described in
   The Java™ Language Specification,
   Third Edition.  First release to support
   generics, annotations, autoboxing, var-args, enhanced for loop, and hexadecimal floating-point literals.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_5)

(def RELEASE_6
  "Enum Constant.

  The version recognized by the Java Platform, Standard Edition
   6.

   No major changes from RELEASE_5.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_6)

(def RELEASE_7
  "Enum Constant.

  The version recognized by the Java Platform, Standard Edition
   7.

   Additions in this release include, diamond syntax for
   constructors, try-with-resources, strings in switch,
   binary literals, and multi-catch.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_7)

(def RELEASE_8
  "Enum Constant.

  The version recognized by the Java Platform, Standard Edition
   8.

   Additions in this release include lambda expressions and default methods.

  type: javax.lang.model.SourceVersion"
  SourceVersion/RELEASE_8)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (SourceVersion c : SourceVersion.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.lang.model.SourceVersion[]`"
  ([]
    (SourceVersion/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.lang.model.SourceVersion`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.lang.model.SourceVersion [^java.lang.String name]
    (SourceVersion/valueOf name)))

(defn *latest
  "Returns the latest source version that can be modeled.

  returns: the latest source version that can be modeled - `javax.lang.model.SourceVersion`"
  (^javax.lang.model.SourceVersion []
    (SourceVersion/latest )))

(defn *latest-supported
  "Returns the latest source version fully supported by the
   current execution environment.  RELEASE_5 or later must
   be returned.

  returns: the latest source version that is fully supported - `javax.lang.model.SourceVersion`"
  (^javax.lang.model.SourceVersion []
    (SourceVersion/latestSupported )))

(defn *identifier?
  "Returns whether or not name is a syntactically valid
   identifier (simple name) or keyword in the latest source
   version.  The method returns true if the name consists
   of an initial character for which Character.isJavaIdentifierStart(int) returns true,
   followed only by characters for which Character.isJavaIdentifierPart(int) returns true.
   This pattern matches regular identifiers, keywords, and the
   literals \"true\", \"false\", and \"null\".
   The method returns false for all other strings.

  name - the string to check - `java.lang.CharSequence`

  returns: true if this string is a
   syntactically valid identifier or keyword, false
   otherwise. - `boolean`"
  (^Boolean [^java.lang.CharSequence name]
    (SourceVersion/isIdentifier name)))

(defn *name?
  "Returns whether or not name is a syntactically valid
    qualified name in the latest source version.  Unlike isIdentifier, this method returns false
    for keywords and literals.

  name - the string to check - `java.lang.CharSequence`

  returns: true if this string is a
   syntactically valid name, false otherwise. - `boolean`"
  (^Boolean [^java.lang.CharSequence name]
    (SourceVersion/isName name)))

(defn *keyword?
  "Returns whether or not s is a keyword or literal in the
    latest source version.

  s - the string to check - `java.lang.CharSequence`

  returns: true if s is a keyword or literal, false otherwise. - `boolean`"
  (^Boolean [^java.lang.CharSequence s]
    (SourceVersion/isKeyword s)))

