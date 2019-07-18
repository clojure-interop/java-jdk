(ns jdk.beans.XMLEncoder
  "The XMLEncoder class is a complementary alternative to
  the ObjectOutputStream and can used to generate
  a textual representation of a JavaBean in the same
  way that the ObjectOutputStream can
  be used to create binary representation of Serializable
  objects. For example, the following fragment can be used to create
  a textual representation the supplied JavaBean
  and all its properties:


        XMLEncoder e = new XMLEncoder(
                           new BufferedOutputStream(
                               new FileOutputStream(`Test.xml`)));
        e.writeObject(new JButton(`Hello, world`));
        e.close();
  Despite the similarity of their APIs, the XMLEncoder
  class is exclusively designed for the purpose of archiving graphs
  of JavaBeans as textual representations of their public
  properties. Like Java source files, documents written this way
  have a natural immunity to changes in the implementations of the classes
  involved. The ObjectOutputStream continues to be recommended
  for interprocess communication and general purpose serialization.

  The XMLEncoder class provides a default denotation for
  JavaBeans in which they are represented as XML documents
  complying with version 1.0 of the XML specification and the
  UTF-8 character encoding of the Unicode/ISO 10646 character set.
  The XML documents produced by the XMLEncoder class are:


  Portable and version resilient: they have no dependencies
  on the private implementation of any class and so, like Java source
  files, they may be exchanged between environments which may have
  different versions of some of the classes and between VMs from
  different vendors.

  Structurally compact: The XMLEncoder class
  uses a redundancy elimination algorithm internally so that the
  default values of a Bean's properties are not written to the stream.

  Fault tolerant: Non-structural errors in the file,
  caused either by damage to the file or by API changes
  made to classes in an archive remain localized
  so that a reader can report the error and continue to load the parts
  of the document which were not affected by the error.


  Below is an example of an XML archive containing
  some user interface components from the swing toolkit:


  <?xml version=`1.0` encoding=`UTF-8`?>
  <java version=`1.0` class=`java.beans.XMLDecoder`>
  <object class=`javax.swing.JFrame`>
    <void property=`name`>
      <string>frame1</string>
    </void>
    <void property=`bounds`>
      <object class=`java.awt.Rectangle`>
        <int>0</int>
        <int>0</int>
        <int>200</int>
        <int>200</int>
      </object>
    </void>
    <void property=`contentPane`>
      <void method=`add`>
        <object class=`javax.swing.JButton`>
          <void property=`label`>
            <string>Hello</string>
          </void>
        </object>
      </void>
    </void>
    <void property=`visible`>
      <boolean>true</boolean>
    </void>
  </object>
  </java>
  The XML syntax uses the following conventions:


  Each element represents a method call.

  The `object` tag denotes an expression whose value is
  to be used as the argument to the enclosing element.

  The `void` tag denotes a statement which will
  be executed, but whose result will not be used as an
  argument to the enclosing method.

  Elements which contain elements use those elements as arguments,
  unless they have the tag: `void`.

  The name of the method is denoted by the `method` attribute.

  XML's standard `id` and `idref` attributes are used to make
  references to previous expressions - so as to deal with
  circularities in the object graph.

  The `class` attribute is used to specify the target of a static
  method or constructor explicitly; its value being the fully
  qualified name of the class.

  Elements with the `void` tag are executed using
  the outer context as the target if no target is defined
  by a `class` attribute.

  Java's String class is treated specially and is
  written <string>Hello, world</string> where
  the characters of the string are converted to bytes
  using the UTF-8 character encoding.


  Although all object graphs may be written using just these three
  tags, the following definitions are included so that common
  data structures can be expressed more concisely:



  The default method name is `new`.

  A reference to a java class is written in the form
   <class>javax.swing.JButton</class>.

  Instances of the wrapper classes for Java's primitive types are written
  using the name of the primitive type as the tag. For example, an
  instance of the Integer class could be written:
  <int>123</int>. Note that the XMLEncoder class
  uses Java's reflection package in which the conversion between
  Java's primitive types and their associated `wrapper classes`
  is handled internally. The API for the XMLEncoder class
  itself deals only with Objects.

  In an element representing a nullary method whose name
  starts with `get`, the `method` attribute is replaced
  with a `property` attribute whose value is given by removing
  the `get` prefix and decapitalizing the result.

  In an element representing a monadic method whose name
  starts with `set`, the `method` attribute is replaced
  with a `property` attribute whose value is given by removing
  the `set` prefix and decapitalizing the result.

  In an element representing a method named `get` taking one
  integer argument, the `method` attribute is replaced
  with an `index` attribute whose value the value of the
  first argument.

  In an element representing a method named `set` taking two arguments,
  the first of which is an integer, the `method` attribute is replaced
  with an `index` attribute whose value the value of the
  first argument.

  A reference to an array is written using the `array`
  tag. The `class` and `length` attributes specify the
  sub-type of the array and its length respectively.



  For more information you might also want to check out
  Using XMLEncoder,
  an article in The Swing Connection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans XMLEncoder]))

(defn ->xml-encoder
  "Constructor.

  Creates a new XML encoder to write out JavaBeans
   to the stream out using the given charset
   starting from the given indentation.

  out - the stream to which the XML representation of the objects will be written - `java.io.OutputStream`
  charset - the name of the requested charset; may be either a canonical name or an alias - `java.lang.String`
  declaration - whether the XML declaration should be generated; set this to false when embedding the contents in another XML document - `boolean`
  indentation - the number of space characters to indent the entire XML document by - `int`

  throws: java.lang.IllegalArgumentException - if out or charset is null, or if indentation is less than 0"
  (^XMLEncoder [^java.io.OutputStream out ^java.lang.String charset ^Boolean declaration ^Integer indentation]
    (new XMLEncoder out charset declaration indentation))
  (^XMLEncoder [^java.io.OutputStream out]
    (new XMLEncoder out)))

(defn set-owner
  "Sets the owner of this encoder to owner.

  owner - The owner of this encoder. - `java.lang.Object`"
  ([^XMLEncoder this ^java.lang.Object owner]
    (-> this (.setOwner owner))))

(defn get-owner
  "Gets the owner of this encoder.

  returns: The owner of this encoder. - `java.lang.Object`"
  (^java.lang.Object [^XMLEncoder this]
    (-> this (.getOwner))))

(defn write-object
  "Write an XML representation of the specified object to the output.

  o - The object to be written to the stream. - `java.lang.Object`"
  ([^XMLEncoder this ^java.lang.Object o]
    (-> this (.writeObject o))))

(defn write-statement
  "Records the Statement so that the Encoder will
   produce the actual output when the stream is flushed.

   This method should only be invoked within the context
   of initializing a persistence delegate.

  old-stm - The statement that will be written to the stream. - `java.beans.Statement`"
  ([^XMLEncoder this ^java.beans.Statement old-stm]
    (-> this (.writeStatement old-stm))))

(defn write-expression
  "Records the Expression so that the Encoder will
   produce the actual output when the stream is flushed.

   This method should only be invoked within the context of
   initializing a persistence delegate or setting up an encoder to
   read from a resource bundle.

   For more information about using resource bundles with the
   XMLEncoder, see
   http://java.sun.com/products/jfc/tsc/articles/persistence4/#i18n

  old-exp - The expression that will be written to the stream. - `java.beans.Expression`"
  ([^XMLEncoder this ^java.beans.Expression old-exp]
    (-> this (.writeExpression old-exp))))

(defn flush
  "This method writes out the preamble associated with the
   XML encoding if it has not been written already and
   then writes out all of the values that been
   written to the stream since the last time flush
   was called. After flushing, all internal references to the
   values that were written to this stream are cleared."
  ([^XMLEncoder this]
    (-> this (.flush))))

(defn close
  "This method calls flush, writes the closing
   postamble and then closes the output stream associated
   with this stream."
  ([^XMLEncoder this]
    (-> this (.close))))

