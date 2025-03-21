/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kafmongo.kafmongo.utils;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class DailyIndex extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4902540788308362883L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DailyIndex\",\"namespace\":\"com.kafmongo.kafmongo.utils\",\"fields\":[{\"name\":\"symbol\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"},{\"name\":\"index\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<DailyIndex> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<DailyIndex> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<DailyIndex> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<DailyIndex> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<DailyIndex> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this DailyIndex to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a DailyIndex from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a DailyIndex instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static DailyIndex fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence symbol;
  private java.lang.CharSequence date;
  private java.lang.CharSequence index;
  private java.lang.CharSequence value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DailyIndex() {}

  /**
   * All-args constructor.
   * @param symbol The new value for symbol
   * @param date The new value for date
   * @param index The new value for index
   * @param value The new value for value
   */
  public DailyIndex(java.lang.CharSequence symbol, java.lang.CharSequence date, java.lang.CharSequence index, java.lang.CharSequence value) {
    this.symbol = symbol;
    this.date = date;
    this.index = index;
    this.value = value;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return symbol;
    case 1: return date;
    case 2: return index;
    case 3: return value;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: symbol = (java.lang.CharSequence)value$; break;
    case 1: date = (java.lang.CharSequence)value$; break;
    case 2: index = (java.lang.CharSequence)value$; break;
    case 3: value = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }


  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public java.lang.CharSequence getDate() {
    return date;
  }


  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.CharSequence value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'index' field.
   * @return The value of the 'index' field.
   */
  public java.lang.CharSequence getIndex() {
    return index;
  }


  /**
   * Sets the value of the 'index' field.
   * @param value the value to set.
   */
  public void setIndex(java.lang.CharSequence value) {
    this.index = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.lang.CharSequence getValue() {
    return value;
  }


  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.lang.CharSequence value) {
    this.value = value;
  }

  /**
   * Creates a new DailyIndex RecordBuilder.
   * @return A new DailyIndex RecordBuilder
   */
  public static com.kafmongo.kafmongo.utils.DailyIndex.Builder newBuilder() {
    return new com.kafmongo.kafmongo.utils.DailyIndex.Builder();
  }

  /**
   * Creates a new DailyIndex RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DailyIndex RecordBuilder
   */
  public static com.kafmongo.kafmongo.utils.DailyIndex.Builder newBuilder(com.kafmongo.kafmongo.utils.DailyIndex.Builder other) {
    if (other == null) {
      return new com.kafmongo.kafmongo.utils.DailyIndex.Builder();
    } else {
      return new com.kafmongo.kafmongo.utils.DailyIndex.Builder(other);
    }
  }

  /**
   * Creates a new DailyIndex RecordBuilder by copying an existing DailyIndex instance.
   * @param other The existing instance to copy.
   * @return A new DailyIndex RecordBuilder
   */
  public static com.kafmongo.kafmongo.utils.DailyIndex.Builder newBuilder(com.kafmongo.kafmongo.utils.DailyIndex other) {
    if (other == null) {
      return new com.kafmongo.kafmongo.utils.DailyIndex.Builder();
    } else {
      return new com.kafmongo.kafmongo.utils.DailyIndex.Builder(other);
    }
  }

  /**
   * RecordBuilder for DailyIndex instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DailyIndex>
    implements org.apache.avro.data.RecordBuilder<DailyIndex> {

    private java.lang.CharSequence symbol;
    private java.lang.CharSequence date;
    private java.lang.CharSequence index;
    private java.lang.CharSequence value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafmongo.kafmongo.utils.DailyIndex.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.symbol)) {
        this.symbol = data().deepCopy(fields()[0].schema(), other.symbol);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.date)) {
        this.date = data().deepCopy(fields()[1].schema(), other.date);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.index)) {
        this.index = data().deepCopy(fields()[2].schema(), other.index);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing DailyIndex instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafmongo.kafmongo.utils.DailyIndex other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.symbol)) {
        this.symbol = data().deepCopy(fields()[0].schema(), other.symbol);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.date)) {
        this.date = data().deepCopy(fields()[1].schema(), other.date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.index)) {
        this.index = data().deepCopy(fields()[2].schema(), other.index);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }


    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.symbol = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public java.lang.CharSequence getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder setDate(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.date = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder clearDate() {
      date = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'index' field.
      * @return The value.
      */
    public java.lang.CharSequence getIndex() {
      return index;
    }


    /**
      * Sets the value of the 'index' field.
      * @param value The value of 'index'.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder setIndex(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.index = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'index' field has been set.
      * @return True if the 'index' field has been set, false otherwise.
      */
    public boolean hasIndex() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'index' field.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder clearIndex() {
      index = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.lang.CharSequence getValue() {
      return value;
    }


    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder setValue(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.value = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public com.kafmongo.kafmongo.utils.DailyIndex.Builder clearValue() {
      value = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DailyIndex build() {
      try {
        DailyIndex record = new DailyIndex();
        record.symbol = fieldSetFlags()[0] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.date = fieldSetFlags()[1] ? this.date : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.index = fieldSetFlags()[2] ? this.index : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.value = fieldSetFlags()[3] ? this.value : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<DailyIndex>
    WRITER$ = (org.apache.avro.io.DatumWriter<DailyIndex>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<DailyIndex>
    READER$ = (org.apache.avro.io.DatumReader<DailyIndex>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.symbol);

    out.writeString(this.date);

    out.writeString(this.index);

    out.writeString(this.value);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);

      this.date = in.readString(this.date instanceof Utf8 ? (Utf8)this.date : null);

      this.index = in.readString(this.index instanceof Utf8 ? (Utf8)this.index : null);

      this.value = in.readString(this.value instanceof Utf8 ? (Utf8)this.value : null);

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);
          break;

        case 1:
          this.date = in.readString(this.date instanceof Utf8 ? (Utf8)this.date : null);
          break;

        case 2:
          this.index = in.readString(this.index instanceof Utf8 ? (Utf8)this.index : null);
          break;

        case 3:
          this.value = in.readString(this.value instanceof Utf8 ? (Utf8)this.value : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










