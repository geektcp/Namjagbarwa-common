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
import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class EnvelopeRequestData implements ApiMessage {
    ByteBuffer requestData;
    byte[] requestPrincipal;
    byte[] clientHostAddress;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("request_data", Type.COMPACT_BYTES, "The embedded request header and data."),
            new Field("request_principal", Type.COMPACT_NULLABLE_BYTES, "Value of the initial client principal when the request is redirected by a broker."),
            new Field("client_host_address", Type.COMPACT_BYTES, "The original client's address in bytes."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public EnvelopeRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public EnvelopeRequestData() {
        this.requestData = ByteUtils.EMPTY_BUF;
        this.requestPrincipal = Bytes.EMPTY;
        this.clientHostAddress = Bytes.EMPTY;
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
                throw new RuntimeException("non-nullable field requestData was serialized as null");
            } else {
                this.requestData = _readable.readByteBuffer(length);
            }
        }
        {
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                this.requestPrincipal = null;
            } else {
                byte[] newBytes = new byte[length];
                _readable.readArray(newBytes);
                this.requestPrincipal = newBytes;
            }
        }
        {
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                throw new RuntimeException("non-nullable field clientHostAddress was serialized as null");
            } else {
                byte[] newBytes = new byte[length];
                _readable.readArray(newBytes);
                this.clientHostAddress = newBytes;
            }
        }
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
        _writable.writeUnsignedVarint(requestData.remaining() + 1);
        _writable.writeByteBuffer(requestData);
        if (requestPrincipal == null) {
            _writable.writeUnsignedVarint(0);
        } else {
            _writable.writeUnsignedVarint(requestPrincipal.length + 1);
            _writable.writeByteArray(requestPrincipal);
        }
        _writable.writeUnsignedVarint(clientHostAddress.length + 1);
        _writable.writeByteArray(clientHostAddress);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        {
            _size.addZeroCopyBytes(requestData.remaining());
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(requestData.remaining() + 1));
        }
        if (requestPrincipal == null) {
            _size.addBytes(1);
        } else {
            _size.addBytes(requestPrincipal.length);
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(requestPrincipal.length + 1));
        }
        {
            _size.addBytes(clientHostAddress.length);
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(clientHostAddress.length + 1));
        }
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
        if (!(obj instanceof EnvelopeRequestData)) return false;
        EnvelopeRequestData other = (EnvelopeRequestData) obj;
        if (!Objects.equals(this.requestData, other.requestData)) return false;
        if (!Arrays.equals(this.requestPrincipal, other.requestPrincipal)) return false;
        if (!Arrays.equals(this.clientHostAddress, other.clientHostAddress)) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + Objects.hashCode(requestData);
        hashCode = 31 * hashCode + Arrays.hashCode(requestPrincipal);
        hashCode = 31 * hashCode + Arrays.hashCode(clientHostAddress);
        return hashCode;
    }
    
    @Override
    public EnvelopeRequestData duplicate() {
        EnvelopeRequestData _duplicate = new EnvelopeRequestData();
        _duplicate.requestData = requestData.duplicate();
        if (requestPrincipal == null) {
            _duplicate.requestPrincipal = null;
        } else {
            _duplicate.requestPrincipal = MessageUtil.duplicate(requestPrincipal);
        }
        _duplicate.clientHostAddress = MessageUtil.duplicate(clientHostAddress);
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "EnvelopeRequestData("
            + "requestData=" + requestData
            + ", requestPrincipal=" + Arrays.toString(requestPrincipal)
            + ", clientHostAddress=" + Arrays.toString(clientHostAddress)
            + ")";
    }
    
    public ByteBuffer requestData() {
        return this.requestData;
    }
    
    public byte[] requestPrincipal() {
        return this.requestPrincipal;
    }
    
    public byte[] clientHostAddress() {
        return this.clientHostAddress;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public EnvelopeRequestData setRequestData(ByteBuffer v) {
        this.requestData = v;
        return this;
    }
    
    public EnvelopeRequestData setRequestPrincipal(byte[] v) {
        this.requestPrincipal = v;
        return this;
    }
    
    public EnvelopeRequestData setClientHostAddress(byte[] v) {
        this.clientHostAddress = v;
        return this;
    }
}
