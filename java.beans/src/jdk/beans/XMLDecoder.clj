(ns jdk.beans.XMLDecoder
  "The XMLDecoder class is used to read XML documents
  created using the XMLEncoder and is used just like
  the ObjectInputStream. For example, one can use
  the following fragment to read the first object defined
  in an XML document written by the XMLEncoder
  class:


        XMLDecoder d = new XMLDecoder(
                           new BufferedInputStream(
                               new FileInputStream(`Test.xml`)));
        Object result = d.readObject();
        d.close();


  For more information you might also want to check out
  Long Term Persistence of JavaBeans Components: XML Schema,
  an article in The Swing Connection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans XMLDecoder]))

(defn ->xml-decoder
  "Constructor.

  Creates a new input stream for reading archives
   created by the XMLEncoder class.

  in - the underlying stream. null may be passed without error, though the resulting XMLDecoder will be useless - `java.io.InputStream`
  owner - the owner of this stream. null is a legal value - `java.lang.Object`
  exception-listener - the exception handler for the stream, or null to use the default - `java.beans.ExceptionListener`
  cl - the class loader used for instantiating objects. null indicates that the default class loader should be used - `java.lang.ClassLoader`"
  (^XMLDecoder [^java.io.InputStream in ^java.lang.Object owner ^java.beans.ExceptionListener exception-listener ^java.lang.ClassLoader cl]
    (new XMLDecoder in owner exception-listener cl))
  (^XMLDecoder [^java.io.InputStream in ^java.lang.Object owner ^java.beans.ExceptionListener exception-listener]
    (new XMLDecoder in owner exception-listener))
  (^XMLDecoder [^java.io.InputStream in ^java.lang.Object owner]
    (new XMLDecoder in owner))
  (^XMLDecoder [^java.io.InputStream in]
    (new XMLDecoder in)))

(defn *create-handler
  "Creates a new handler for SAX parser
   that can be used to parse embedded XML archives
   created by the XMLEncoder class.

   The owner should be used if parsed XML document contains
   the method call within context of the <java> element.
   The null value may cause illegal parsing in such case.
   The same problem may occur, if the owner class
   does not contain expected method to call. See details here.

  owner - the owner of the default handler that can be used as a value of <java> element - `java.lang.Object`
  el - the exception handler for the parser, or null to use the default exception handler - `java.beans.ExceptionListener`
  cl - the class loader used for instantiating objects, or null to use the default class loader - `java.lang.ClassLoader`

  returns: an instance of DefaultHandler for SAX parser - `org.xml.sax.helpers.DefaultHandler`"
  (^org.xml.sax.helpers.DefaultHandler [^java.lang.Object owner ^java.beans.ExceptionListener el ^java.lang.ClassLoader cl]
    (XMLDecoder/createHandler owner el cl)))

(defn close
  "This method closes the input stream associated
   with this stream."
  ([^XMLDecoder this]
    (-> this (.close))))

(defn set-exception-listener
  "Sets the exception handler for this stream to exceptionListener.
   The exception handler is notified when this stream catches recoverable
   exceptions.

  exception-listener - The exception handler for this stream; if null the default exception listener will be used. - `java.beans.ExceptionListener`"
  ([^XMLDecoder this ^java.beans.ExceptionListener exception-listener]
    (-> this (.setExceptionListener exception-listener))))

(defn get-exception-listener
  "Gets the exception handler for this stream.

  returns: The exception handler for this stream.
       Will return the default exception listener if this has not explicitly been set. - `java.beans.ExceptionListener`"
  (^java.beans.ExceptionListener [^XMLDecoder this]
    (-> this (.getExceptionListener))))

(defn read-object
  "Reads the next object from the underlying input stream.

  returns: the next object read - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the stream contains no objects (or no more objects)"
  (^java.lang.Object [^XMLDecoder this]
    (-> this (.readObject))))

(defn set-owner
  "Sets the owner of this decoder to owner.

  owner - The owner of this decoder. - `java.lang.Object`"
  ([^XMLDecoder this ^java.lang.Object owner]
    (-> this (.setOwner owner))))

(defn get-owner
  "Gets the owner of this decoder.

  returns: The owner of this decoder. - `java.lang.Object`"
  (^java.lang.Object [^XMLDecoder this]
    (-> this (.getOwner))))

