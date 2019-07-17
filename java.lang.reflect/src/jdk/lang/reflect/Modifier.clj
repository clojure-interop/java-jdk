(ns jdk.lang.reflect.Modifier
  "The Modifier class provides static methods and
  constants to decode class and member access modifiers.  The sets of
  modifiers are represented as integers with distinct bit positions
  representing different modifiers.  The values for the constants
  representing the modifiers are taken from the tables in sections 4.1, 4.4, 4.5, and 4.7 of
  The Java™ Virtual Machine Specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Modifier]))

(defn ->modifier
  "Constructor."
  ([]
    (new Modifier )))

(def *-public
  "Static Constant.

  The int value representing the public
   modifier.

  type: int"
  Modifier/PUBLIC)

(def *-private
  "Static Constant.

  The int value representing the private
   modifier.

  type: int"
  Modifier/PRIVATE)

(def *-protected
  "Static Constant.

  The int value representing the protected
   modifier.

  type: int"
  Modifier/PROTECTED)

(def *-static
  "Static Constant.

  The int value representing the static
   modifier.

  type: int"
  Modifier/STATIC)

(def *-final
  "Static Constant.

  The int value representing the final
   modifier.

  type: int"
  Modifier/FINAL)

(def *-synchronized
  "Static Constant.

  The int value representing the synchronized
   modifier.

  type: int"
  Modifier/SYNCHRONIZED)

(def *-volatile
  "Static Constant.

  The int value representing the volatile
   modifier.

  type: int"
  Modifier/VOLATILE)

(def *-transient
  "Static Constant.

  The int value representing the transient
   modifier.

  type: int"
  Modifier/TRANSIENT)

(def *-native
  "Static Constant.

  The int value representing the native
   modifier.

  type: int"
  Modifier/NATIVE)

(def *-interface
  "Static Constant.

  The int value representing the interface
   modifier.

  type: int"
  Modifier/INTERFACE)

(def *-abstract
  "Static Constant.

  The int value representing the abstract
   modifier.

  type: int"
  Modifier/ABSTRACT)

(def *-strict
  "Static Constant.

  The int value representing the strictfp
   modifier.

  type: int"
  Modifier/STRICT)

(defn *native?
  "Return true if the integer argument includes the
   native modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   native modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isNative mod)))

(defn *parameter-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to a parameter.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to a parameter. - `int`"
  ([]
    (Modifier/parameterModifiers )))

(defn *private?
  "Return true if the integer argument includes the
   private modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   private modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isPrivate mod)))

(defn *static?
  "Return true if the integer argument includes the
   static modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   static modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isStatic mod)))

(defn *field-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to a field.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to a field. - `int`"
  ([]
    (Modifier/fieldModifiers )))

(defn *abstract?
  "Return true if the integer argument includes the
   abstract modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   abstract modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isAbstract mod)))

(defn *to-string
  "Return a string describing the access modifier flags in
   the specified modifier. For example:


      public final synchronized strictfp
   The modifier names are returned in an order consistent with the
   suggested modifier orderings given in sections 8.1.1, 8.3.1, 8.4.3, 8.8.3, and 9.1.1 of
   The Java™ Language Specification.
   The full modifier ordering used by this method is:
    public protected private abstract static final transient
   volatile synchronized native strictfp
   interface
   The interface modifier discussed in this class is
   not a true modifier in the Java language and it appears after
   all other modifiers listed by this method.  This method may
   return a string of modifiers that are not valid modifiers of a
   Java entity; in other words, no checking is done on the
   possible validity of the combination of modifiers represented
   by the input.

   Note that to perform such checking for a known kind of entity,
   such as a constructor or method, first AND the argument of
   toString with the appropriate mask from a method like
   constructorModifiers() or methodModifiers().

  mod - a set of modifiers - `int`

  returns: a string representation of the set of modifiers
   represented by mod - `java.lang.String`"
  ([mod]
    (Modifier/toString mod)))

(defn *class-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to a class.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to a class. - `int`"
  ([]
    (Modifier/classModifiers )))

(defn *strict?
  "Return true if the integer argument includes the
   strictfp modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   strictfp modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isStrict mod)))

(defn *interface?
  "Return true if the integer argument includes the
   interface modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   interface modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isInterface mod)))

(defn *constructor-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to a constructor.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to a constructor. - `int`"
  ([]
    (Modifier/constructorModifiers )))

(defn *method-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to a method.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to a method. - `int`"
  ([]
    (Modifier/methodModifiers )))

(defn *synchronized?
  "Return true if the integer argument includes the
   synchronized modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   synchronized modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isSynchronized mod)))

(defn *interface-modifiers
  "Return an int value OR-ing together the source language
   modifiers that can be applied to an interface.

  returns: an int value OR-ing together the source language
   modifiers that can be applied to an interface. - `int`"
  ([]
    (Modifier/interfaceModifiers )))

(defn *transient?
  "Return true if the integer argument includes the
   transient modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   transient modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isTransient mod)))

(defn *volatile?
  "Return true if the integer argument includes the
   volatile modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   volatile modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isVolatile mod)))

(defn *final?
  "Return true if the integer argument includes the
   final modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   final modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isFinal mod)))

(defn *protected?
  "Return true if the integer argument includes the
   protected modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   protected modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isProtected mod)))

(defn *public?
  "Return true if the integer argument includes the
   public modifier, false otherwise.

  mod - a set of modifiers - `int`

  returns: true if mod includes the
   public modifier; false otherwise. - `boolean`"
  ([mod]
    (Modifier/isPublic mod)))

