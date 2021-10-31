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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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


public class DefaultPrincipalData implements ApiMessage {
    String type;
    String name;
    boolean tokenAuthenticated;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("type", Type.COMPACT_STRING, "The principal type"),
            new Field("name", Type.COMPACT_STRING, "The principal name"),
            new Field("token_authenticated", Type.BOOLEAN, "Whether the principal was authenticated by a delegation token on the forwarding broker."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public DefaultPrincipalData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DefaultPrincipalData() {
        this.type = "";
        this.name = "";
        this.tokenAuthenticated = false;
    }
    
    @Override
    public short apiKey() {
        return -1;
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
                throw new RuntimeException("non-nullable field type was serialized as null");
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field type had invalid length " + length);
            } else {
                this.type = _readable.readString(length);
            }
        }
        {
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                throw new RuntimeException("non-nullable field name was serialized as null");
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field name had invalid length " + length);
            } else {
                this.name = _readable.readString(length);
            }
        }
        this.tokenAuthenticated = _readable.readByte() != 0;
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
        {
            byte[] _stringBytes = _cache.getSerializedValue(type);
            _writable.writeUnsignedVarint(_stringBytes.length + 1);
            _writable.writeByteArray(_stringBytes);
        }
        {
            byte[] _stringBytes = _cache.getSerializedValue(name);
            _writable.writeUnsignedVarint(_stringBytes.length + 1);
            _writable.writeByteArray(_stringBytes);
        }
        _writable.writeByte(tokenAuthenticated ? (byte) 1 : (byte) 0);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        {
            byte[] _stringBytes = type.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'type' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(type, _stringBytes);
            _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
        }
        {
            byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'name' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(name, _stringBytes);
            _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
        }
        _size.addBytes(1);
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
        if (!(obj instanceof DefaultPrincipalData)) return false;
        DefaultPrincipalData other = (DefaultPrincipalData) obj;
        if (this.type == null) {
            if (other.type != null) return false;
        } else {
            if (!this.type.equals(other.type)) return false;
        }
        if (this.name == null) {
            if (other.name != null) return false;
        } else {
            if (!this.name.equals(other.name)) return false;
        }
        if (tokenAuthenticated != other.tokenAuthenticated) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (type == null ? 0 : type.hashCode());
        hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
        hashCode = 31 * hashCode + (tokenAuthenticated ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public DefaultPrincipalData duplicate() {
        DefaultPrincipalData _duplicate = new DefaultPrincipalData();
        _duplicate.type = type;
        _duplicate.name = name;
        _duplicate.tokenAuthenticated = tokenAuthenticated;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DefaultPrincipalData("
            + "type=" + ((type == null) ? "null" : "'" + type.toString() + "'")
            + ", name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
            + ", tokenAuthenticated=" + (tokenAuthenticated ? "true" : "false")
            + ")";
    }
    
    public String type() {
        return this.type;
    }
    
    public String name() {
        return this.name;
    }
    
    public boolean tokenAuthenticated() {
        return this.tokenAuthenticated;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DefaultPrincipalData setType(String v) {
        this.type = v;
        return this;
    }
    
    public DefaultPrincipalData setName(String v) {
        this.name = v;
        return this;
    }
    
    public DefaultPrincipalData setTokenAuthenticated(boolean v) {
        this.tokenAuthenticated = v;
        return this;
    }
}
