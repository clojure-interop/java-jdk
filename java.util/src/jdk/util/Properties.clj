(ns jdk.util.Properties
  "The Properties class represents a persistent set of
  properties. The Properties can be saved to a stream
  or loaded from a stream. Each key and its corresponding value in
  the property list is a string.

  A property list can contain another property list as its
  `defaults`; this second property list is searched if
  the property key is not found in the original property list.

  Because Properties inherits from Hashtable, the
  put and putAll methods can be applied to a
  Properties object.  Their use is strongly discouraged as they
  allow the caller to insert entries whose keys or values are not
  Strings.  The setProperty method should be used
  instead.  If the store or save method is called
  on a `compromised` Properties object that contains a
  non-String key or value, the call will fail. Similarly,
  the call to the propertyNames or list method
  will fail if it is called on a `compromised` Properties
  object that contains a non-String key.


  The load(Reader) /
  store(Writer, String)
  methods load and store properties from and to a character based stream
  in a simple line-oriented format specified below.

  The load(InputStream) /
  store(OutputStream, String)
  methods work the same way as the load(Reader)/store(Writer, String) pair, except
  the input/output stream is encoded in ISO 8859-1 character encoding.
  Characters that cannot be directly represented in this encoding can be written using
  Unicode escapes as defined in section 3.3 of
  The Java™ Language Specification;
  only a single 'u' character is allowed in an escape
  sequence. The native2ascii tool can be used to convert property files to and
  from other character encodings.

   The loadFromXML(InputStream) and storeToXML(OutputStream, String, String) methods load and store properties
  in a simple XML format.  By default the UTF-8 character encoding is used,
  however a specific encoding may be specified if required. Implementations
  are required to support UTF-8 and UTF-16 and may support other encodings.
  An XML properties document has the following DOCTYPE declaration:



  <!DOCTYPE properties SYSTEM `http://java.sun.com/dtd/properties.dtd`>
  Note that the system URI (http://java.sun.com/dtd/properties.dtd) is
  not accessed when exporting or importing properties; it merely
  serves as a string to uniquely identify the DTD, which is:


     <?xml version=`1.0` encoding=`UTF-8`?>

     <!-- DTD for properties -->

     <!ELEMENT properties ( comment?, entry* ) >

     <!ATTLIST properties version CDATA #FIXED `1.0`>

     <!ELEMENT comment (#PCDATA) >

     <!ELEMENT entry (#PCDATA) >

     <!ATTLIST entry key CDATA #REQUIRED>

  This class is thread-safe: multiple threads can share a single
  Properties object without the need for external synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Properties]))

(defn ->properties
  "Constructor.

  Creates an empty property list with the specified defaults.

  defaults - the defaults. - `java.util.Properties`"
  ([defaults]
    (new Properties defaults))
  ([]
    (new Properties )))

(defn save
  "Deprecated. This method does not throw an IOException if an I/O error
   occurs while saving the property list.  The preferred way to save a
   properties list is via the store(OutputStream out,
   String comments) method or the
   storeToXML(OutputStream os, String comment) method.

  out - an output stream. - `java.io.OutputStream`
  comments - a description of the property list. - `java.lang.String`

  returns: `java.lang.  void`

  throws: java.lang.ClassCastException - if this Properties object contains any keys or values that are not Strings."
  ([this out comments]
    (-> this (.save out comments))))

(defn list
  "Prints this property list out to the specified output stream.
   This method is useful for debugging.

  out - an output stream. - `java.io.PrintStream`

  throws: java.lang.ClassCastException - if any key in this property list is not a string."
  ([this out]
    (-> this (.list out))))

(defn load
  "Reads a property list (key and element pairs) from the input
   character stream in a simple line-oriented format.

   Properties are processed in terms of lines. There are two
   kinds of line, natural lines and logical lines.
   A natural line is defined as a line of
   characters that is terminated either by a set of line terminator
   characters (\n or \r or \r\n)
   or by the end of the stream. A natural line may be either a blank line,
   a comment line, or hold all or some of a key-element pair. A logical
   line holds all the data of a key-element pair, which may be spread
   out across several adjacent natural lines by escaping
   the line terminator sequence with a backslash character
   \.  Note that a comment line cannot be extended
   in this manner; every natural line that is a comment must have
   its own comment indicator, as described below. Lines are read from
   input until the end of the stream is reached.


   A natural line that contains only white space characters is
   considered blank and is ignored.  A comment line has an ASCII
   '#' or '!' as its first non-white
   space character; comment lines are also ignored and do not
   encode key-element information.  In addition to line
   terminators, this format considers the characters space
   (' ', '\u0020'), tab
   ('\t', '\u0009'), and form feed
   ('\f', '\u000C') to be white
   space.


   If a logical line is spread across several natural lines, the
   backslash escaping the line terminator sequence, the line
   terminator sequence, and any white space at the start of the
   following line have no affect on the key or element values.
   The remainder of the discussion of key and element parsing
   (when loading) will assume all the characters constituting
   the key and element appear on a single natural line after
   line continuation characters have been removed.  Note that
   it is not sufficient to only examine the character
   preceding a line terminator sequence to decide if the line
   terminator is escaped; there must be an odd number of
   contiguous backslashes for the line terminator to be escaped.
   Since the input is processed from left to right, a
   non-zero even number of 2n contiguous backslashes
   before a line terminator (or elsewhere) encodes n
   backslashes after escape processing.


   The key contains all of the characters in the line starting
   with the first non-white space character and up to, but not
   including, the first unescaped '=',
   ':', or white space character other than a line
   terminator. All of these key termination characters may be
   included in the key by escaping them with a preceding backslash
   character; for example,

   \:\=

   would be the two-character key `:=`.  Line
   terminator characters can be included using \r and
   \n escape sequences.  Any white space after the
   key is skipped; if the first non-white space character after
   the key is '=' or ':', then it is
   ignored and any white space characters after it are also
   skipped.  All remaining characters on the line become part of
   the associated element string; if there are no remaining
   characters, the element is the empty string
   ``.  Once the raw character sequences
   constituting the key and element are identified, escape
   processing is performed as described above.


   As an example, each of the following three lines specifies the key
   `Truth` and the associated element value
   `Beauty`:


   Truth = Beauty
    Truth:Beauty
   Truth                    :Beauty
   As another example, the following three lines specify a single
   property:


   fruits                           apple, banana, pear, \
                                    cantaloupe, watermelon, \
                                    kiwi, mango
   The key is `fruits` and the associated element is:


  `apple, banana, pear, cantaloupe, watermelon, kiwi, mango`
   Note that a space appears before each \ so that a space
   will appear after each comma in the final result; the \,
   line terminator, and leading white space on the continuation line are
   merely discarded and are not replaced by one or more other
   characters.

   As a third example, the line:


  cheeses
   specifies that the key is `cheeses` and the associated
   element is the empty string ``.


   Characters in keys and elements can be represented in escape
   sequences similar to those used for character and string literals
   (see sections 3.3 and 3.10.6 of
   The Java™ Language Specification).

   The differences from the character escape sequences and Unicode
   escapes used for characters and strings are:


    Octal escapes are not recognized.

    The character sequence \b does not
   represent a backspace character.

    The method does not treat a backslash character,
   \, before a non-valid escape character as an
   error; the backslash is silently dropped.  For example, in a
   Java string the sequence `\z` would cause a
   compile time error.  In contrast, this method silently drops
   the backslash.  Therefore, this method treats the two character
   sequence `\b` as equivalent to the single
   character 'b'.

    Escapes are not necessary for single and double quotes;
   however, by the rule above, single and double quote characters
   preceded by a backslash still yield single and double quote
   characters, respectively.

    Only a single 'u' character is allowed in a Unicode escape
   sequence.



   The specified stream remains open after this method returns.

  reader - the input character stream. - `java.io.Reader`

  throws: java.io.IOException - if an error occurred when reading from the input stream."
  ([this reader]
    (-> this (.load reader))))

(defn load-from-xml
  "Loads all of the properties represented by the XML document on the
   specified input stream into this properties table.

   The XML document must have the following DOCTYPE declaration:


   <!DOCTYPE properties SYSTEM `http://java.sun.com/dtd/properties.dtd`>
   Furthermore, the document must satisfy the properties DTD described
   above.

    An implementation is required to read XML documents that use the
   `UTF-8` or `UTF-16` encoding. An implementation may
   support additional encodings.

   The specified stream is closed after this method returns.

  in - the input stream from which to read the XML document. - `java.io.InputStream`

  throws: java.io.IOException - if reading from the specified input stream results in an IOException."
  ([this in]
    (-> this (.loadFromXML in))))

(defn property-names
  "Returns an enumeration of all the keys in this property list,
   including distinct keys in the default property list if a key
   of the same name has not already been found from the main
   properties list.

  returns: an enumeration of all the keys in this property list, including
            the keys in the default property list. - `java.util.Enumeration<?>`

  throws: java.lang.ClassCastException - if any key in this property list is not a string."
  ([this]
    (-> this (.propertyNames))))

(defn get-property
  "Searches for the property with the specified key in this property list.
   If the key is not found in this property list, the default property list,
   and its defaults, recursively, are then checked. The method returns the
   default value argument if the property is not found.

  key - the hashtable key. - `java.lang.String`
  default-value - a default value. - `java.lang.String`

  returns: the value in this property list with the specified key value. - `java.lang.String`"
  ([this key default-value]
    (-> this (.getProperty key default-value)))
  ([this key]
    (-> this (.getProperty key))))

(defn store-to-xml
  "Emits an XML document representing all of the properties contained
   in this table, using the specified encoding.

   The XML document will have the following DOCTYPE declaration:


   <!DOCTYPE properties SYSTEM `http://java.sun.com/dtd/properties.dtd`>

   If the specified comment is null then no comment
   will be stored in the document.

    An implementation is required to support writing of XML documents
   that use the `UTF-8` or `UTF-16` encoding. An
   implementation may support additional encodings.

   The specified stream remains open after this method returns.

  os - the output stream on which to emit the XML document. - `java.io.OutputStream`
  comment - a description of the property list, or null if no comment is desired. - `java.lang.String`
  encoding - the name of a supported character encoding - `java.lang.String`

  throws: java.io.IOException - if writing to the specified output stream results in an IOException."
  ([this os comment encoding]
    (-> this (.storeToXML os comment encoding)))
  ([this os comment]
    (-> this (.storeToXML os comment))))

(defn set-property
  "Calls the Hashtable method put. Provided for
   parallelism with the getProperty method. Enforces use of
   strings for property keys and values. The value returned is the
   result of the Hashtable call to put.

  key - the key to be placed into this property list. - `java.lang.String`
  value - the value corresponding to key. - `java.lang.String`

  returns: the previous value of the specified key in this property
               list, or null if it did not have one. - `java.lang.Object`"
  ([this key value]
    (-> this (.setProperty key value))))

(defn string-property-names
  "Returns a set of keys in this property list where
   the key and its corresponding value are strings,
   including distinct keys in the default property list if a key
   of the same name has not already been found from the main
   properties list.  Properties whose key or value is not
   of type String are omitted.

   The returned set is not backed by the Properties object.
   Changes to this Properties are not reflected in the set,
   or vice versa.

  returns: a set of keys in this property list where
            the key and its corresponding value are strings,
            including the keys in the default property list. - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.stringPropertyNames))))

(defn store
  "Writes this property list (key and element pairs) in this
   Properties table to the output character stream in a
   format suitable for using the load(Reader)
   method.

   Properties from the defaults table of this Properties
   table (if any) are not written out by this method.

   If the comments argument is not null, then an ASCII #
   character, the comments string, and a line separator are first written
   to the output stream. Thus, the comments can serve as an
   identifying comment. Any one of a line feed ('\n'), a carriage
   return ('\r'), or a carriage return followed immediately by a line feed
   in comments is replaced by a line separator generated by the Writer
   and if the next character in comments is not character # or
   character ! then an ASCII # is written out
   after that line separator.

   Next, a comment line is always written, consisting of an ASCII
   # character, the current date and time (as if produced
   by the toString method of Date for the
   current time), and a line separator as generated by the Writer.

   Then every entry in this Properties table is
   written out, one per line. For each entry the key string is
   written, then an ASCII =, then the associated
   element string. For the key, all space characters are
   written with a preceding \ character.  For the
   element, leading space characters, but not embedded or trailing
   space characters, are written with a preceding \
   character. The key and element characters #,
   !, =, and : are written
   with a preceding backslash to ensure that they are properly loaded.

   After the entries have been written, the output stream is flushed.
   The output stream remains open after this method returns.

  writer - an output character stream writer. - `java.io.Writer`
  comments - a description of the property list. - `java.lang.String`

  throws: java.io.IOException - if writing this property list to the specified output stream throws an IOException."
  ([this writer comments]
    (-> this (.store writer comments))))

