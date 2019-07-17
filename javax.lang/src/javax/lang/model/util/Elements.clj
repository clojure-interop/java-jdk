(ns javax.lang.model.util.Elements
  "Utility methods for operating on program elements.

  Compatibility Note: Methods may be added to this interface
  in future releases of the platform."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.util Elements]))

(defn get-constant-expression
  "Returns the text of a constant expression representing a
   primitive value or a string.
   The text returned is in a form suitable for representing the value
   in source code.

  value - a primitive value or string - `java.lang.Object`

  returns: the text of a constant expression - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the argument is not a primitive value or string"
  ([this value]
    (-> this (.getConstantExpression value))))

(defn get-package-of
  "Returns the package of an element.  The package of a package is
   itself.

  type - the element being examined - `javax.lang.model.element.Element`

  returns: the package of an element - `javax.lang.model.element.PackageElement`"
  ([this type]
    (-> this (.getPackageOf type))))

(defn overrides
  "Tests whether one method, as a member of a given type,
   overrides another method.
   When a non-abstract method overrides an abstract one, the
   former is also said to implement the latter.

    In the simplest and most typical usage, the value of the
   type parameter will simply be the class or interface
   directly enclosing overrider (the possibly-overriding
   method).  For example, suppose m1 represents the method
   String.hashCode and m2 represents Object.hashCode.  We can then ask whether m1 overrides
   m2 within the class String (it does):


   assert elements.overrides(m1, m2,
            elements.getTypeElement(`java.lang.String`));


   A more interesting case can be illustrated by the following example
   in which a method in type A does not override a
   like-named method in type B:


   class A { public void m() {} }
   interface B { void m(); }
   ...
   m1 = ...;  // A.m
   m2 = ...;  // B.m
   assert ! elements.overrides(m1, m2,
            elements.getTypeElement(`A`));


   When viewed as a member of a third type C, however,
   the method in A does override the one in B:


   class C extends A implements B {}
   ...
   assert elements.overrides(m1, m2,
            elements.getTypeElement(`C`));

  overrider - the first method, possible overrider - `javax.lang.model.element.ExecutableElement`
  overridden - the second method, possibly being overridden - `javax.lang.model.element.ExecutableElement`
  type - the type of which the first method is a member - `javax.lang.model.element.TypeElement`

  returns: true if and only if the first method overrides
            the second - `boolean`"
  ([this overrider overridden type]
    (-> this (.overrides overrider overridden type))))

(defn get-all-annotation-mirrors
  "Returns all annotations present on an element, whether
   directly present or present via inheritance.

  e - the element being examined - `javax.lang.model.element.Element`

  returns: all annotations of the element - `java.util.List<? extends javax.lang.model.element.AnnotationMirror>`"
  ([this e]
    (-> this (.getAllAnnotationMirrors e))))

(defn functional-interface?
  "Returns true if the type element is a functional interface, false otherwise.

  type - the type element being examined - `javax.lang.model.element.TypeElement`

  returns: true if the element is a functional interface, false otherwise - `boolean`"
  ([this type]
    (-> this (.isFunctionalInterface type))))

(defn get-element-values-with-defaults
  "Returns the values of an annotation's elements, including defaults.

  a - annotation to examine - `javax.lang.model.element.AnnotationMirror`

  returns: the values of the annotation's elements, including defaults - `java.util.Map<? extends javax.lang.model.element.ExecutableElement,? extends javax.lang.model.element.AnnotationValue>`"
  ([this a]
    (-> this (.getElementValuesWithDefaults a))))

(defn get-all-members
  "Returns all members of a type element, whether inherited or
   declared directly.  For a class the result also includes its
   constructors, but not local or anonymous classes.

   Note that elements of certain kinds can be isolated using
   methods in ElementFilter.

  type - the type being examined - `javax.lang.model.element.TypeElement`

  returns: all members of the type - `java.util.List<? extends javax.lang.model.element.Element>`"
  ([this type]
    (-> this (.getAllMembers type))))

(defn get-type-element
  "Returns a type element given its canonical name.

  name - the canonical name - `java.lang.CharSequence`

  returns: the named type element, or null if it cannot be found - `javax.lang.model.element.TypeElement`"
  ([this name]
    (-> this (.getTypeElement name))))

(defn get-name
  "Return a name with the same sequence of characters as the
   argument.

  cs - the character sequence to return as a name - `java.lang.CharSequence`

  returns: a name with the same sequence of characters as the argument - `javax.lang.model.element.Name`"
  ([this cs]
    (-> this (.getName cs))))

(defn hides
  "Tests whether one type, method, or field hides another.

  hider - the first element - `javax.lang.model.element.Element`
  hidden - the second element - `javax.lang.model.element.Element`

  returns: true if and only if the first element hides
            the second - `boolean`"
  ([this hider hidden]
    (-> this (.hides hider hidden))))

(defn deprecated?
  "Returns true if the element is deprecated, false otherwise.

  e - the element being examined - `javax.lang.model.element.Element`

  returns: true if the element is deprecated, false otherwise - `boolean`"
  ([this e]
    (-> this (.isDeprecated e))))

(defn get-binary-name
  "Returns the binary name of a type element.

  type - the type element being examined - `javax.lang.model.element.TypeElement`

  returns: the binary name - `javax.lang.model.element.Name`"
  ([this type]
    (-> this (.getBinaryName type))))

(defn get-package-element
  "Returns a package given its fully qualified name.

  name - fully qualified package name, or `` for an unnamed package - `java.lang.CharSequence`

  returns: the named package, or null if it cannot be found - `javax.lang.model.element.PackageElement`"
  ([this name]
    (-> this (.getPackageElement name))))

(defn get-doc-comment
  "Returns the text of the documentation (`Javadoc`)
   comment of an element.

    A documentation comment of an element is a comment that
   begins with `/**` , ends with a separate
   `*/`, and immediately precedes the element,
   ignoring white space.  Therefore, a documentation comment
   contains at least three`*` characters.  The text
   returned for the documentation comment is a processed form of
   the comment as it appears in source code.  The leading `/**` and trailing `*/` are removed.  For lines
   of the comment starting after the initial `/**`,
   leading white space characters are discarded as are any
   consecutive `*` characters appearing after the white
   space or starting the line.  The processed lines are then
   concatenated together (including line terminators) and
   returned.

  e - the element being examined - `javax.lang.model.element.Element`

  returns: the documentation comment of the element, or null
            if there is none - `java.lang.String`"
  ([this e]
    (-> this (.getDocComment e))))

(defn print-elements
  "Prints a representation of the elements to the given writer in
   the specified order.  The main purpose of this method is for
   diagnostics.  The exact format of the output is not
   specified and is subject to change.

  w - the writer to print the output to - `java.io.Writer`
  elements - the elements to print - `javax.lang.model.element.Element`"
  ([this w elements]
    (-> this (.printElements w elements))))

