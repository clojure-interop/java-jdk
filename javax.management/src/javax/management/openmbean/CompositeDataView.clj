(ns javax.management.openmbean.CompositeDataView
  "A Java class can implement this interface to indicate how it is
  to be converted into a CompositeData by the MXBean framework.

  A typical way to use this class is to add extra items to the
  CompositeData in addition to the ones that are declared in the
  CompositeType supplied by the MXBean framework.  To do this,
  you must create another CompositeType that has all the same items,
  plus your extra items.

  For example, suppose you have a class Measure that consists of
  a String called units and a value that is either a
  long or a double.  It might look like this:



  public class Measure implements CompositeDataView {
      private String units;
      private Number value; // a Long or a Double

      public Measure(String units, Number value) {
          this.units = units;
          this.value = value;
      }

      public static Measure from(CompositeData cd) {
          return new Measure((String) cd.get(`units`),
                             (Number) cd.get(`value`));
      }

      public String getUnits() {
          return units;
      }

      // Can't be called getValue(), because Number is not a valid type
      // in an MXBean, so the implied `value` property would be rejected.
      public Number _getValue() {
          return value;
      }

      public CompositeData toCompositeData(CompositeType ct) {
          try {
               List<String> itemNames = new ArrayList<String>(ct.keySet());
               List<String> itemDescriptions = new ArrayList<String>();
               List<OpenType<?>> itemTypes = new ArrayList<OpenType<?>>();
              for (String item : itemNames) {
                  itemDescriptions.add(ct.getDescription(item));
                  itemTypes.add(ct.getType(item));
              }
              itemNames.add(`value`);
              itemDescriptions.add(`long or double value of the measure`);
              itemTypes.add((value instanceof Long) ? SimpleType.LONG :
                            SimpleType.DOUBLE);
              CompositeType xct =
                  new CompositeType(ct.getTypeName(),
                                    ct.getDescription(),
                                    itemNames.toArray(new String[0]),
                                    itemDescriptions.toArray(new String[0]),
                                    itemTypes.toArray(new OpenType<?>[0]));
              CompositeData cd =
                  new CompositeDataSupport(xct,
                                           new String[] {`units`, `value`},
                                           new Object[] {units, value});
              assert ct.isValue(cd);  // check we've done it right
              return cd;
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
  }

  The CompositeType that will appear in the openType field
  of the Descriptor for an attribute or
  operation of this type will show only the units item, but the actual
  CompositeData that is generated will have both units and
  value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean CompositeDataView]))

(defn to-composite-data
  "Return a CompositeData corresponding to the values in
   this object.  The returned value should usually be an instance of
   CompositeDataSupport, or a class that serializes as a
   CompositeDataSupport via a writeReplace method.
   Otherwise, a remote client that receives the object might not be
   able to reconstruct it.

  ct - The expected CompositeType of the returned value. If the returned value is cd, then cd.getCompositeType().equals(ct) should be true. Typically this will be because cd is a CompositeDataSupport constructed with ct as its CompositeType. - `javax.management.openmbean.CompositeType`

  returns: the CompositeData. - `javax.management.openmbean.CompositeData`"
  (^javax.management.openmbean.CompositeData [^CompositeDataView this ^javax.management.openmbean.CompositeType ct]
    (-> this (.toCompositeData ct))))

