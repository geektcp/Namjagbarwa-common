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
import java.util.Iterator;
import java.util.List;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.CompactArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;
import org.apache.kafka.common.utils.ImplicitLinkedHashCollection;
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiCollection;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class DeleteTopicsResponseData implements ApiMessage {
    int throttleTimeMs;
    DeletableTopicResultCollection responses;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("responses", new ArrayOf(DeletableTopicResult.SCHEMA_0), "The results for each topic we tried to delete.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new ArrayOf(DeletableTopicResult.SCHEMA_0), "The results for each topic we tried to delete.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new CompactArrayOf(DeletableTopicResult.SCHEMA_4), "The results for each topic we tried to delete."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new CompactArrayOf(DeletableTopicResult.SCHEMA_5), "The results for each topic we tried to delete."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new CompactArrayOf(DeletableTopicResult.SCHEMA_6), "The results for each topic we tried to delete."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5,
        SCHEMA_6
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 6;
    
    public DeleteTopicsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DeleteTopicsResponseData() {
        this.throttleTimeMs = 0;
        this.responses = new DeletableTopicResultCollection(0);
    }
    
    @Override
    public short apiKey() {
        return 20;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 6;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 1) {
            this.throttleTimeMs = _readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field responses was serialized as null");
                } else {
                    DeletableTopicResultCollection newCollection = new DeletableTopicResultCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DeletableTopicResult(_readable, _version));
                    }
                    this.responses = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field responses was serialized as null");
                } else {
                    DeletableTopicResultCollection newCollection = new DeletableTopicResultCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DeletableTopicResult(_readable, _version));
                    }
                    this.responses = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 4) {
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
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (_version >= 1) {
            _writable.writeInt(throttleTimeMs);
        }
        if (_version >= 4) {
            _writable.writeUnsignedVarint(responses.size() + 1);
            for (DeletableTopicResult responsesElement : responses) {
                responsesElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(responses.size());
            for (DeletableTopicResult responsesElement : responses) {
                responsesElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 4) {
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (_version >= 1) {
            _size.addBytes(4);
        }
        {
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(responses.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (DeletableTopicResult responsesElement : responses) {
                responsesElement.addSize(_size, _cache, _version);
            }
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        if (_version >= 4) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeleteTopicsResponseData)) return false;
        DeleteTopicsResponseData other = (DeleteTopicsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.responses == null) {
            if (other.responses != null) return false;
        } else {
            if (!this.responses.equals(other.responses)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (responses == null ? 0 : responses.hashCode());
        return hashCode;
    }
    
    @Override
    public DeleteTopicsResponseData duplicate() {
        DeleteTopicsResponseData _duplicate = new DeleteTopicsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        DeletableTopicResultCollection newResponses = new DeletableTopicResultCollection(responses.size());
        for (DeletableTopicResult _element : responses) {
            newResponses.add(_element.duplicate());
        }
        _duplicate.responses = newResponses;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DeleteTopicsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", responses=" + MessageUtil.deepToString(responses.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public DeletableTopicResultCollection responses() {
        return this.responses;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DeleteTopicsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DeleteTopicsResponseData setResponses(DeletableTopicResultCollection v) {
        this.responses = v;
        return this;
    }
    
    public static class DeletableTopicResult implements Message, ImplicitLinkedHashMultiCollection.Element {
        String name;
        Uuid topicId;
        short errorCode;
        String errorMessage;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded."),
                new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The error message, or null if there was no error."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("name", Type.COMPACT_NULLABLE_STRING, "The topic name"),
                new Field("topic_id", Type.UUID, "the unique topic ID"),
                new Field("error_code", Type.INT16, "The deletion error, or 0 if the deletion succeeded."),
                new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The error message, or null if there was no error."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 6;
        
        public DeletableTopicResult(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public DeletableTopicResult() {
            this.name = "";
            this.topicId = Uuid.ZERO_UUID;
            this.errorCode = (short) 0;
            this.errorMessage = null;
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 6;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 6) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DeletableTopicResult");
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    if (_version >= 6) {
                        this.name = null;
                    } else {
                        throw new RuntimeException("non-nullable field name was serialized as null");
                    }
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            if (_version >= 6) {
                this.topicId = _readable.readUuid();
            } else {
                this.topicId = Uuid.ZERO_UUID;
            }
            this.errorCode = _readable.readShort();
            if (_version >= 5) {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    this.errorMessage = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field errorMessage had invalid length " + length);
                } else {
                    this.errorMessage = _readable.readString(length);
                }
            } else {
                this.errorMessage = null;
            }
            this._unknownTaggedFields = null;
            if (_version >= 4) {
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
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (name == null) {
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    throw new NullPointerException();
                }
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 6) {
                _writable.writeUuid(topicId);
            }
            _writable.writeShort(errorCode);
            if (_version >= 5) {
                if (errorMessage == null) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    byte[] _stringBytes = _cache.getSerializedValue(errorMessage);
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    _writable.writeByteArray(_stringBytes);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 4) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 6) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of DeletableTopicResult");
            }
            if (name == null) {
                if (_version >= 4) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(2);
                }
            } else {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version >= 6) {
                _size.addBytes(16);
            }
            _size.addBytes(2);
            if (_version >= 5) {
                if (errorMessage == null) {
                    _size.addBytes(1);
                } else {
                    byte[] _stringBytes = errorMessage.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'errorMessage' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(errorMessage, _stringBytes);
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                }
            }
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof DeletableTopicResult)) return false;
            DeletableTopicResult other = (DeletableTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DeletableTopicResult)) return false;
            DeletableTopicResult other = (DeletableTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (!this.topicId.equals(other.topicId)) return false;
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            return hashCode;
        }
        
        @Override
        public DeletableTopicResult duplicate() {
            DeletableTopicResult _duplicate = new DeletableTopicResult();
            if (name == null) {
                _duplicate.name = null;
            } else {
                _duplicate.name = name;
            }
            _duplicate.topicId = topicId;
            _duplicate.errorCode = errorCode;
            if (errorMessage == null) {
                _duplicate.errorMessage = null;
            } else {
                _duplicate.errorMessage = errorMessage;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DeletableTopicResult("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", topicId=" + topicId.toString()
                + ", errorCode=" + errorCode
                + ", errorMessage=" + ((errorMessage == null) ? "null" : "'" + errorMessage.toString() + "'")
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public Uuid topicId() {
            return this.topicId;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DeletableTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public DeletableTopicResult setTopicId(Uuid v) {
            this.topicId = v;
            return this;
        }
        
        public DeletableTopicResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DeletableTopicResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    public static class DeletableTopicResultCollection extends ImplicitLinkedHashMultiCollection<DeletableTopicResult> {
        public DeletableTopicResultCollection() {
            super();
        }
        
        public DeletableTopicResultCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public DeletableTopicResultCollection(Iterator<DeletableTopicResult> iterator) {
            super(iterator);
        }
        
        public DeletableTopicResult find(String name) {
            DeletableTopicResult _key = new DeletableTopicResult();
            _key.setName(name);
            return find(_key);
        }
        
        public List<DeletableTopicResult> findAll(String name) {
            DeletableTopicResult _key = new DeletableTopicResult();
            _key.setName(name);
            return findAll(_key);
        }
        
        public DeletableTopicResultCollection duplicate() {
            DeletableTopicResultCollection _duplicate = new DeletableTopicResultCollection(size());
            for (DeletableTopicResult _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
