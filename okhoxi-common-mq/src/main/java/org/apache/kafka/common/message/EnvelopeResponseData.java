/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class EnvelopeResponseData implements ApiMessage {
    ByteBuffer responseData;
    short errorCode;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("response_data", Type.COMPACT_NULLABLE_BYTES, "The embedded response header and data."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public EnvelopeResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public EnvelopeResponseData() {
        this.responseData = null;
        this.errorCode = (short) 0;
    }
    
    @Override
    public short apiKey() {
        return 58;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                this.responseData = null;
            } else {
                this.responseData = _readable.readByteBuffer(length);
            }
        }
        this.errorCode = _readable.readShort();
        this._unknownTaggedFields = null;
        int _numTaggedFields = _readable.readUnsignedVarint();
        for (int _i = 0; _i < _numTaggedFields; _i++) {
            int _tag = _readable.readUnsignedVarint();
            int _size = _readable.readUnsignedVarint();
            switch (_tag) {
                default:
                    this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                    break;
            }
        }
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (responseData == null) {
            _writable.writeUnsignedVarint(0);
        } else {
            _writable.writeUnsignedVarint(responseData.remaining() + 1);
            _writable.writeByteBuffer(responseData);
        }
        _writable.writeShort(errorCode);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (responseData == null) {
            _size.addBytes(1);
        } else {
            _size.addZeroCopyBytes(responseData.remaining());
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(responseData.remaining() + 1));
        }
        _size.addBytes(2);
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EnvelopeResponseData)) return false;
        EnvelopeResponseData other = (EnvelopeResponseData) obj;
        if (!Objects.equals(this.responseData, other.responseData)) return false;
        if (errorCode != other.errorCode) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + Objects.hashCode(responseData);
        hashCode = 31 * hashCode + errorCode;
        return hashCode;
    }
    
    @Override
    public EnvelopeResponseData duplicate() {
        EnvelopeResponseData _duplicate = new EnvelopeResponseData();
        if (responseData == null) {
            _duplicate.responseData = null;
        } else {
            _duplicate.responseData = responseData.duplicate();
        }
        _duplicate.errorCode = errorCode;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "EnvelopeResponseData("
            + "responseData=" + responseData
            + ", errorCode=" + errorCode
            + ")";
    }
    
    public ByteBuffer responseData() {
        return this.responseData;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public EnvelopeResponseData setResponseData(ByteBuffer v) {
        this.responseData = v;
        return this;
    }
    
    public EnvelopeResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
}
