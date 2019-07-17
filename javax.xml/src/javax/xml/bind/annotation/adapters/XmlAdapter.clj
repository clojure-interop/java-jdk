(ns javax.xml.bind.annotation.adapters.XmlAdapter
  "Adapts a Java type for custom marshaling.

    Usage:


  Some Java types do not map naturally to a XML representation, for
  example HashMap or other non JavaBean classes. Conversely,
  a XML repsentation may map to a Java type but an application may
  choose to accesss the XML representation using another Java
  type. For example, the schema to Java binding rules bind
  xs:DateTime by default to XmlGregorianCalendar. But an application
  may desire to bind xs:DateTime to a custom type,
  MyXmlGregorianCalendar, for example. In both cases, there is a
  mismatch between  bound type , used by an application to
  access XML content and the  value type, that is mapped to an
  XML representation.


  This abstract class defines methods for adapting a bound type to a value
  type or vice versa. The methods are invoked by the JAXB binding
  framework during marshaling and unmarshalling:


      XmlAdapter.marshal(...):  During marshalling, JAXB
         binding framework invokes XmlAdapter.marshal(..) to adapt a
         bound type to value type, which is then marshaled to XML
         representation.

      XmlAdapter.unmarshal(...):  During unmarshalling,
         JAXB binding framework first unmarshals XML representation
         to a value type and then invokes XmlAdapter.unmarshal(..) to
         adapt the value type to a bound type.


  Writing an adapter therefore involves the following steps:


     Write an adapter that implements this abstract class.
     Install the adapter using the annotation XmlJavaTypeAdapter


  Example: Customized mapping of HashMap
   The following example illustrates the use of
  @XmlAdapter and @XmlJavaTypeAdapter to
  customize the mapping of a HashMap.

    Step 1:  Determine the desired XML representation for HashMap.



      <hashmap>
          <entry key=`id123`>this is a value</entry>
          <entry key=`id312`>this is another value</entry>
          ...
        </hashmap>

    Step 2:  Determine the schema definition that the
  desired XML representation shown above should follow.



      <xs:complexType name=`myHashMapType`>
        <xs:sequence>
          <xs:element name=`entry` type=`myHashMapEntryType`
                         minOccurs = `0` maxOccurs=`unbounded`/>
        </xs:sequence>
      </xs:complexType>

      <xs:complexType name=`myHashMapEntryType`>
        <xs:simpleContent>
          <xs:extension base=`xs:string`>
            <xs:attribute name=`key` type=`xs:int`/>
          </xs:extension>
        </xs:simpleContent>
      </xs:complexType>

    Step 3:  Write value types that can generate the above
  schema definition.



      public class MyHashMapType {
          List<MyHashMapEntryType> entry;
      }

      public class MyHashMapEntryType {
          @XmlAttribute
          public Integer key;

          @XmlValue
          public String value;
      }

    Step 4:  Write the adapter that adapts the value type,
  MyHashMapType to a bound type, HashMap, used by the application.



      public final class MyHashMapAdapter extends
                         XmlAdapter<MyHashMapType,HashMap> { ... }

    Step 5:  Use the adapter.



      public class Foo {
          @XmlJavaTypeAdapter(MyHashMapAdapter.class)
          HashMap hashmap;
          ...
      }

  The above code fragment will map to the following schema:



      <xs:complexType name=`Foo`>
        <xs:sequence>
          <xs:element name=`hashmap` type=`myHashMapType`
        </xs:sequence>
      </xs:complexType>"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation.adapters XmlAdapter]))

(defn unmarshal
  "Convert a value type to a bound type.

  v - The value to be converted. Can be null. - `XmlAdapter.ValueType`

  returns: `XmlAdapter.BoundType`

  throws: java.lang.Exception - if there's an error during the conversion. The caller is responsible for reporting the error to the user through ValidationEventHandler."
  ([this v]
    (-> this (.unmarshal v))))

(defn marshal
  "Convert a bound type to a value type.

  v - The value to be convereted. Can be null. - `XmlAdapter.BoundType`

  returns: `XmlAdapter.ValueType`

  throws: java.lang.Exception - if there's an error during the conversion. The caller is responsible for reporting the error to the user through ValidationEventHandler."
  ([this v]
    (-> this (.marshal v))))

