(ns jdk.lang.Compiler
  "The Compiler class is provided to support Java-to-native-code
  compilers and related services. By design, the Compiler class does
  nothing; it serves as a placeholder for a JIT compiler implementation.

   When the Java Virtual Machine first starts, it determines if the system
  property java.compiler exists. (System properties are accessible
  through System.getProperty(String) and System.getProperty(String, String).  If so, it is assumed to be the name of
  a library (with a platform-dependent exact location and type); System.loadLibrary(java.lang.String) is called to load that library. If this loading
  succeeds, the function named java_lang_Compiler_start() in that
  library is called.

   If no compiler is available, these methods do nothing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Compiler]))

(defn *compile-class
  "Compiles the specified class.

  clazz - A class - `java.lang.Class<?>`

  returns: true if the compilation succeeded; false if the
            compilation failed or no compiler is available - `boolean`

  throws: java.lang.NullPointerException - If clazz is null"
  ([^java.lang.Class clazz]
    (Compiler/compileClass clazz)))

(defn *compile-classes
  "Compiles all classes whose name matches the specified string.

  string - The name of the classes to compile - `java.lang.String`

  returns: true if the compilation succeeded; false if the
            compilation failed or no compiler is available - `boolean`

  throws: java.lang.NullPointerException - If string is null"
  ([^java.lang.String string]
    (Compiler/compileClasses string)))

(defn *command
  "Examines the argument type and its fields and perform some documented
   operation.  No specific operations are required.

  any - An argument - `java.lang.Object`

  returns: A compiler-specific value, or null if no compiler is
            available - `java.lang.Object`

  throws: java.lang.NullPointerException - If any is null"
  ([^java.lang.Object any]
    (Compiler/command any)))

(defn *enable
  "Cause the Compiler to resume operation."
  ([]
    (Compiler/enable )))

(defn *disable
  "Cause the Compiler to cease operation."
  ([]
    (Compiler/disable )))

