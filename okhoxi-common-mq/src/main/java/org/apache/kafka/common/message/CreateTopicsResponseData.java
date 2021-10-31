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


public class CreateTopicsResponseData implements ApiMessage {
    int throttleTimeMs;
    CreatableTopicResultCollection topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_0), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_1), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(CreatableTopicResult.SCHEMA_1), "Results for each topic we tried to create.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 = SCHEMA_3;
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new CompactArrayOf(CreatableTopicResult.SCHEMA_5), "Results for each topic we tried to create."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new CompactArrayOf(CreatableTopicResult.SCHEMA_7), "Results for each topic we tried to create."),
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
        SCHEMA_6,
        SCHEMA_7
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 7;
    
    public CreateTopicsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public CreateTopicsResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new CreatableTopicResultCollection(0);
    }
    
    @Override
    public short apiKey() {
        return 19;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 7;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 2) {
            this.throttleTimeMs = _readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            if (_version >= 5) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    CreatableTopicResultCollection newCollection = new CreatableTopicResultCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new CreatableTopicResult(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    CreatableTopicResultCollection newCollection = new CreatableTopicResultCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new CreatableTopicResult(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 5) {
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
        if (_version >= 2) {
            _writable.writeInt(throttleTimeMs);
        }
        if (_version >= 5) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (CreatableTopicResult topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (CreatableTopicResult topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 5) {
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
        if (_version >= 2) {
            _size.addBytes(4);
        }
        {
            if (_version >= 5) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (CreatableTopicResult topicsElement : topics) {
                topicsElement.addSize(_size, _cache, _version);
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
        if (_version >= 5) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreateTopicsResponseData)) return false;
        CreateTopicsResponseData other = (CreateTopicsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public CreateTopicsResponseData duplicate() {
        CreateTopicsResponseData _duplicate = new CreateTopicsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        CreatableTopicResultCollection newTopics = new CreatableTopicResultCollection(topics.size());
        for (CreatableTopicResult _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "CreateTopicsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public CreatableTopicResultCollection topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public CreateTopicsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public CreateTopicsResponseData setTopics(CreatableTopicResultCollection v) {
        this.topics = v;
        return this;
    }
    
    public static class CreatableTopicResult implements Message, ImplicitLinkedHashMultiCollection.Element {
        String name;
        Uuid topicId;
        short errorCode;
        String errorMessage;
        short topicConfigErrorCode;
        int numPartitions;
        short replicationFactor;
        List<CreatableTopicConfigs> configs;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if there was no error.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The error message, or null if there was no error."),
                new Field("num_partitions", Type.INT32, "Number of partitions of the topic."),
                new Field("replication_factor", Type.INT16, "Replication factor of the topic."),
                new Field("configs", CompactArrayOf.nullable(CreatableTopicConfigs.SCHEMA_5), "Configuration of the topic."),
                TaggedFieldsSection.of(
                    0, new Field("topic_config_error_code", Type.INT16, "Optional topic config error returned if configs are not returned in the response.")
                )
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("topic_id", Type.UUID, "The unique topic ID"),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
                new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The error message, or null if there was no error."),
                new Field("num_partitions", Type.INT32, "Number of partitions of the topic."),
                new Field("replication_factor", Type.INT16, "Replication factor of the topic."),
                new Field("configs", CompactArrayOf.nullable(CreatableTopicConfigs.SCHEMA_5), "Configuration of the topic."),
                TaggedFieldsSection.of(
                    0, new Field("topic_config_error_code", Type.INT16, "Optional topic config error returned if configs are not returned in the response.")
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 7;
        
        public CreatableTopicResult(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public CreatableTopicResult() {
            this.name = "";
            this.topicId = Uuid.ZERO_UUID;
            this.errorCode = (short) 0;
            this.errorMessage = "";
            this.topicConfigErrorCode = (short) 0;
            this.numPartitions = -1;
            this.replicationFactor = (short) -1;
            this.configs = new ArrayList<CreatableTopicConfigs>(0);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatableTopicResult");
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field name was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            if (_version >= 7) {
                this.topicId = _readable.readUuid();
            } else {
                this.topicId = Uuid.ZERO_UUID;
            }
            this.errorCode = _readable.readShort();
            if (_version >= 1) {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.errorMessage = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field errorMessage had invalid length " + length);
                } else {
                    this.errorMessage = _readable.readString(length);
                }
            } else {
                this.errorMessage = "";
            }
            this.topicConfigErrorCode = (short) 0;
            if (_version >= 5) {
                this.numPartitions = _readable.readInt();
            } else {
                this.numPartitions = -1;
            }
            if (_version >= 5) {
                this.replicationFactor = _readable.readShort();
            } else {
                this.replicationFactor = (short) -1;
            }
            if (_version >= 5) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    this.configs = null;
                } else {
                    ArrayList<CreatableTopicConfigs> newCollection = new ArrayList<CreatableTopicConfigs>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new CreatableTopicConfigs(_readable, _version));
                    }
                    this.configs = newCollection;
                }
            } else {
                this.configs = new ArrayList<CreatableTopicConfigs>(0);
            }
            this._unknownTaggedFields = null;
            if (_version >= 5) {
                int _numTaggedFields = _readable.readUnsignedVarint();
                for (int _i = 0; _i < _numTaggedFields; _i++) {
                    int _tag = _readable.readUnsignedVarint();
                    int _size = _readable.readUnsignedVarint();
                    switch (_tag) {
                        case 0: {
                            this.topicConfigErrorCode = _readable.readShort();
                            break;
                        }
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
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 7) {
                _writable.writeUuid(topicId);
            }
            _writable.writeShort(errorCode);
            if (_version >= 1) {
                if (errorMessage == null) {
                    if (_version >= 5) {
                        _writable.writeUnsignedVarint(0);
                    } else {
                        _writable.writeShort((short) -1);
                    }
                } else {
                    byte[] _stringBytes = _cache.getSerializedValue(errorMessage);
                    if (_version >= 5) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
                }
            }
            if (_version >= 5) {
                if (this.topicConfigErrorCode != (short) 0) {
                    _numTaggedFields++;
                }
            }
            if (_version >= 5) {
                _writable.writeInt(numPartitions);
            }
            if (_version >= 5) {
                _writable.writeShort(replicationFactor);
            }
            if (_version >= 5) {
                if (configs == null) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeUnsignedVarint(configs.size() + 1);
                    for (CreatableTopicConfigs configsElement : configs) {
                        configsElement.write(_writable, _cache, _version);
                    }
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 5) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                {
                    if (this.topicConfigErrorCode != (short) 0) {
                        _writable.writeUnsignedVarint(0);
                        _writable.writeUnsignedVarint(2);
                        _writable.writeShort(topicConfigErrorCode);
                    }
                }
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
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of CreatableTopicResult");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version >= 7) {
                _size.addBytes(16);
            }
            _size.addBytes(2);
            if (_version >= 1) {
                if (errorMessage == null) {
                    if (_version >= 5) {
                        _size.addBytes(1);
                    } else {
                        _size.addBytes(2);
                    }
                } else {
                    byte[] _stringBytes = errorMessage.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'errorMessage' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(errorMessage, _stringBytes);
                    if (_version >= 5) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
                }
            }
            if (_version >= 5) {
                if (this.topicConfigErrorCode != (short) 0) {
                    _numTaggedFields++;
                    _size.addBytes(1);
                    _size.addBytes(1);
                    _size.addBytes(2);
                }
            }
            if (_version >= 5) {
                _size.addBytes(4);
            }
            if (_version >= 5) {
                _size.addBytes(2);
            }
            if (_version >= 5) {
                if (configs == null) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(configs.size() + 1));
                    for (CreatableTopicConfigs configsElement : configs) {
                        configsElement.addSize(_size, _cache, _version);
                    }
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
            if (_version >= 5) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof CreatableTopicResult)) return false;
            CreatableTopicResult other = (CreatableTopicResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatableTopicResult)) return false;
            CreatableTopicResult other = (CreatableTopicResult) obj;
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
            if (topicConfigErrorCode != other.topicConfigErrorCode) return false;
            if (numPartitions != other.numPartitions) return false;
            if (replicationFactor != other.replicationFactor) return false;
            if (this.configs == null) {
                if (other.configs != null) return false;
            } else {
                if (!this.configs.equals(other.configs)) return false;
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
        public CreatableTopicResult duplicate() {
            CreatableTopicResult _duplicate = new CreatableTopicResult();
            _duplicate.name = name;
            _duplicate.topicId = topicId;
            _duplicate.errorCode = errorCode;
            if (errorMessage == null) {
                _duplicate.errorMessage = null;
            } else {
                _duplicate.errorMessage = errorMessage;
            }
            _duplicate.topicConfigErrorCode = topicConfigErrorCode;
            _duplicate.numPartitions = numPartitions;
            _duplicate.replicationFactor = replicationFactor;
            if (configs == null) {
                _duplicate.configs = null;
            } else {
                ArrayList<CreatableTopicConfigs> newConfigs = new ArrayList<CreatableTopicConfigs>(configs.size());
                for (CreatableTopicConfigs _element : configs) {
                    newConfigs.add(_element.duplicate());
                }
                _duplicate.configs = newConfigs;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "CreatableTopicResult("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", topicId=" + topicId.toString()
                + ", errorCode=" + errorCode
                + ", errorMessage=" + ((errorMessage == null) ? "null" : "'" + errorMessage.toString() + "'")
                + ", topicConfigErrorCode=" + topicConfigErrorCode
                + ", numPartitions=" + numPartitions
                + ", replicationFactor=" + replicationFactor
                + ", configs=" + ((configs == null) ? "null" : MessageUtil.deepToString(configs.iterator()))
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
        
        public short topicConfigErrorCode() {
            return this.topicConfigErrorCode;
        }
        
        public int numPartitions() {
            return this.numPartitions;
        }
        
        public short replicationFactor() {
            return this.replicationFactor;
        }
        
        public List<CreatableTopicConfigs> configs() {
            return this.configs;
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
        
        public CreatableTopicResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatableTopicResult setTopicId(Uuid v) {
            this.topicId = v;
            return this;
        }
        
        public CreatableTopicResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public CreatableTopicResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        public CreatableTopicResult setTopicConfigErrorCode(short v) {
            this.topicConfigErrorCode = v;
            return this;
        }
        
        public CreatableTopicResult setNumPartitions(int v) {
            this.numPartitions = v;
            return this;
        }
        
        public CreatableTopicResult setReplicationFactor(short v) {
            this.replicationFactor = v;
            return this;
        }
        
        public CreatableTopicResult setConfigs(List<CreatableTopicConfigs> v) {
            this.configs = v;
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
    
    public static class CreatableTopicConfigs implements Message {
        String name;
        String value;
        boolean readOnly;
        byte configSource;
        boolean isSensitive;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The configuration name."),
                new Field("value", Type.COMPACT_NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("config_source", Type.INT8, "The configuration source."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 5;
        public static final short HIGHEST_SUPPORTED_VERSION = 7;
        
        public CreatableTopicConfigs(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public CreatableTopicConfigs() {
            this.name = "";
            this.value = "";
            this.readOnly = false;
            this.configSource = (byte) -1;
            this.isSensitive = false;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 7;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatableTopicConfigs");
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
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    this.value = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field value had invalid length " + length);
                } else {
                    this.value = _readable.readString(length);
                }
            }
            this.readOnly = _readable.readByte() != 0;
            this.configSource = _readable.readByte();
            this.isSensitive = _readable.readByte() != 0;
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
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of CreatableTopicConfigs");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            if (value == null) {
                _writable.writeUnsignedVarint(0);
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(value);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(readOnly ? (byte) 1 : (byte) 0);
            _writable.writeByte(configSource);
            _writable.writeByte(isSensitive ? (byte) 1 : (byte) 0);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of CreatableTopicConfigs");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            if (value == null) {
                _size.addBytes(1);
            } else {
                byte[] _stringBytes = value.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'value' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(value, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(1);
            _size.addBytes(1);
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
            if (!(obj instanceof CreatableTopicConfigs)) return false;
            CreatableTopicConfigs other = (CreatableTopicConfigs) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.value == null) {
                if (other.value != null) return false;
            } else {
                if (!this.value.equals(other.value)) return false;
            }
            if (readOnly != other.readOnly) return false;
            if (configSource != other.configSource) return false;
            if (isSensitive != other.isSensitive) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
            hashCode = 31 * hashCode + (readOnly ? 1231 : 1237);
            hashCode = 31 * hashCode + configSource;
            hashCode = 31 * hashCode + (isSensitive ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public CreatableTopicConfigs duplicate() {
            CreatableTopicConfigs _duplicate = new CreatableTopicConfigs();
            _duplicate.name = name;
            if (value == null) {
                _duplicate.value = null;
            } else {
                _duplicate.value = value;
            }
            _duplicate.readOnly = readOnly;
            _duplicate.configSource = configSource;
            _duplicate.isSensitive = isSensitive;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "CreatableTopicConfigs("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", value=" + ((value == null) ? "null" : "'" + value.toString() + "'")
                + ", readOnly=" + (readOnly ? "true" : "false")
                + ", configSource=" + configSource
                + ", isSensitive=" + (isSensitive ? "true" : "false")
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        public boolean readOnly() {
            return this.readOnly;
        }
        
        public byte configSource() {
            return this.configSource;
        }
        
        public boolean isSensitive() {
            return this.isSensitive;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public CreatableTopicConfigs setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatableTopicConfigs setValue(String v) {
            this.value = v;
            return this;
        }
        
        public CreatableTopicConfigs setReadOnly(boolean v) {
            this.readOnly = v;
            return this;
        }
        
        public CreatableTopicConfigs setConfigSource(byte v) {
            this.configSource = v;
            return this;
        }
        
        public CreatableTopicConfigs setIsSensitive(boolean v) {
            this.isSensitive = v;
            return this;
        }
    }
    
    public static class CreatableTopicResultCollection extends ImplicitLinkedHashMultiCollection<CreatableTopicResult> {
        public CreatableTopicResultCollection() {
            super();
        }
        
        public CreatableTopicResultCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public CreatableTopicResultCollection(Iterator<CreatableTopicResult> iterator) {
            super(iterator);
        }
        
        public CreatableTopicResult find(String name) {
            CreatableTopicResult _key = new CreatableTopicResult();
            _key.setName(name);
            return find(_key);
        }
        
        public List<CreatableTopicResult> findAll(String name) {
            CreatableTopicResult _key = new CreatableTopicResult();
            _key.setName(name);
            return findAll(_key);
        }
        
        public CreatableTopicResultCollection duplicate() {
            CreatableTopicResultCollection _duplicate = new CreatableTopicResultCollection(size());
            for (CreatableTopicResult _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
