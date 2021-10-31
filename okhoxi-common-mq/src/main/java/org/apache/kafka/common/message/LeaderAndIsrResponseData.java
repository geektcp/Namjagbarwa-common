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

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class LeaderAndIsrResponseData implements ApiMessage {
    short errorCode;
    List<LeaderAndIsrPartitionError> partitionErrors;
    List<LeaderAndIsrTopicError> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("partition_errors", new ArrayOf(LeaderAndIsrPartitionError.SCHEMA_0), "Each partition in v0 to v4 message.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("partition_errors", new CompactArrayOf(LeaderAndIsrPartitionError.SCHEMA_4), "Each partition in v0 to v4 message."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("topics", new CompactArrayOf(LeaderAndIsrTopicError.SCHEMA_5), "Each topic"),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 5;
    
    public LeaderAndIsrResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public LeaderAndIsrResponseData() {
        this.errorCode = (short) 0;
        this.partitionErrors = new ArrayList<LeaderAndIsrPartitionError>(0);
        this.topics = new ArrayList<LeaderAndIsrTopicError>(0);
    }
    
    @Override
    public short apiKey() {
        return 4;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 5;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        this.errorCode = _readable.readShort();
        if (_version <= 4) {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionErrors was serialized as null");
                } else {
                    ArrayList<LeaderAndIsrPartitionError> newCollection = new ArrayList<LeaderAndIsrPartitionError>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new LeaderAndIsrPartitionError(_readable, _version));
                    }
                    this.partitionErrors = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionErrors was serialized as null");
                } else {
                    ArrayList<LeaderAndIsrPartitionError> newCollection = new ArrayList<LeaderAndIsrPartitionError>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new LeaderAndIsrPartitionError(_readable, _version));
                    }
                    this.partitionErrors = newCollection;
                }
            }
        } else {
            this.partitionErrors = new ArrayList<LeaderAndIsrPartitionError>(0);
        }
        if (_version >= 5) {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topics was serialized as null");
            } else {
                ArrayList<LeaderAndIsrTopicError> newCollection = new ArrayList<LeaderAndIsrTopicError>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new LeaderAndIsrTopicError(_readable, _version));
                }
                this.topics = newCollection;
            }
        } else {
            this.topics = new ArrayList<LeaderAndIsrTopicError>(0);
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
        _writable.writeShort(errorCode);
        if (_version <= 4) {
            if (_version >= 4) {
                _writable.writeUnsignedVarint(partitionErrors.size() + 1);
                for (LeaderAndIsrPartitionError partitionErrorsElement : partitionErrors) {
                    partitionErrorsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitionErrors.size());
                for (LeaderAndIsrPartitionError partitionErrorsElement : partitionErrors) {
                    partitionErrorsElement.write(_writable, _cache, _version);
                }
            }
        } else {
            if (!this.partitionErrors.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default partitionErrors at version " + _version);
            }
        }
        if (_version >= 5) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (LeaderAndIsrTopicError topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            if (!this.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
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
        _size.addBytes(2);
        if (_version <= 4) {
            {
                if (_version >= 4) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionErrors.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (LeaderAndIsrPartitionError partitionErrorsElement : partitionErrors) {
                    partitionErrorsElement.addSize(_size, _cache, _version);
                }
            }
        }
        if (_version >= 5) {
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
                for (LeaderAndIsrTopicError topicsElement : topics) {
                    topicsElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof LeaderAndIsrResponseData)) return false;
        LeaderAndIsrResponseData other = (LeaderAndIsrResponseData) obj;
        if (errorCode != other.errorCode) return false;
        if (this.partitionErrors == null) {
            if (other.partitionErrors != null) return false;
        } else {
            if (!this.partitionErrors.equals(other.partitionErrors)) return false;
        }
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
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (partitionErrors == null ? 0 : partitionErrors.hashCode());
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public LeaderAndIsrResponseData duplicate() {
        LeaderAndIsrResponseData _duplicate = new LeaderAndIsrResponseData();
        _duplicate.errorCode = errorCode;
        ArrayList<LeaderAndIsrPartitionError> newPartitionErrors = new ArrayList<LeaderAndIsrPartitionError>(partitionErrors.size());
        for (LeaderAndIsrPartitionError _element : partitionErrors) {
            newPartitionErrors.add(_element.duplicate());
        }
        _duplicate.partitionErrors = newPartitionErrors;
        ArrayList<LeaderAndIsrTopicError> newTopics = new ArrayList<LeaderAndIsrTopicError>(topics.size());
        for (LeaderAndIsrTopicError _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "LeaderAndIsrResponseData("
            + "errorCode=" + errorCode
            + ", partitionErrors=" + MessageUtil.deepToString(partitionErrors.iterator())
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public List<LeaderAndIsrPartitionError> partitionErrors() {
        return this.partitionErrors;
    }
    
    public List<LeaderAndIsrTopicError> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public LeaderAndIsrResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public LeaderAndIsrResponseData setPartitionErrors(List<LeaderAndIsrPartitionError> v) {
        this.partitionErrors = v;
        return this;
    }
    
    public LeaderAndIsrResponseData setTopics(List<LeaderAndIsrTopicError> v) {
        this.topics = v;
        return this;
    }
    
    public static class LeaderAndIsrTopicError implements Message {
        Uuid topicId;
        List<LeaderAndIsrPartitionError> partitionErrors;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("topic_id", Type.UUID, "The unique topic ID"),
                new Field("partition_errors", new CompactArrayOf(LeaderAndIsrPartitionError.SCHEMA_5), "Each partition."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            SCHEMA_5
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 5;
        public static final short HIGHEST_SUPPORTED_VERSION = 5;
        
        public LeaderAndIsrTopicError(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public LeaderAndIsrTopicError() {
            this.topicId = Uuid.ZERO_UUID;
            this.partitionErrors = new ArrayList<LeaderAndIsrPartitionError>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of LeaderAndIsrTopicError");
            }
            this.topicId = _readable.readUuid();
            {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionErrors was serialized as null");
                } else {
                    ArrayList<LeaderAndIsrPartitionError> newCollection = new ArrayList<LeaderAndIsrPartitionError>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new LeaderAndIsrPartitionError(_readable, _version));
                    }
                    this.partitionErrors = newCollection;
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
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of LeaderAndIsrTopicError");
            }
            int _numTaggedFields = 0;
            _writable.writeUuid(topicId);
            _writable.writeUnsignedVarint(partitionErrors.size() + 1);
            for (LeaderAndIsrPartitionError partitionErrorsElement : partitionErrors) {
                partitionErrorsElement.write(_writable, _cache, _version);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of LeaderAndIsrTopicError");
            }
            _size.addBytes(16);
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionErrors.size() + 1));
                for (LeaderAndIsrPartitionError partitionErrorsElement : partitionErrors) {
                    partitionErrorsElement.addSize(_size, _cache, _version);
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
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LeaderAndIsrTopicError)) return false;
            LeaderAndIsrTopicError other = (LeaderAndIsrTopicError) obj;
            if (!this.topicId.equals(other.topicId)) return false;
            if (this.partitionErrors == null) {
                if (other.partitionErrors != null) return false;
            } else {
                if (!this.partitionErrors.equals(other.partitionErrors)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + topicId.hashCode();
            hashCode = 31 * hashCode + (partitionErrors == null ? 0 : partitionErrors.hashCode());
            return hashCode;
        }
        
        @Override
        public LeaderAndIsrTopicError duplicate() {
            LeaderAndIsrTopicError _duplicate = new LeaderAndIsrTopicError();
            _duplicate.topicId = topicId;
            ArrayList<LeaderAndIsrPartitionError> newPartitionErrors = new ArrayList<LeaderAndIsrPartitionError>(partitionErrors.size());
            for (LeaderAndIsrPartitionError _element : partitionErrors) {
                newPartitionErrors.add(_element.duplicate());
            }
            _duplicate.partitionErrors = newPartitionErrors;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrTopicError("
                + "topicId=" + topicId.toString()
                + ", partitionErrors=" + MessageUtil.deepToString(partitionErrors.iterator())
                + ")";
        }
        
        public Uuid topicId() {
            return this.topicId;
        }
        
        public List<LeaderAndIsrPartitionError> partitionErrors() {
            return this.partitionErrors;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public LeaderAndIsrTopicError setTopicId(Uuid v) {
            this.topicId = v;
            return this;
        }
        
        public LeaderAndIsrTopicError setPartitionErrors(List<LeaderAndIsrPartitionError> v) {
            this.partitionErrors = v;
            return this;
        }
    }
    
    public static class LeaderAndIsrPartitionError implements Message {
        String topicName;
        int partitionIndex;
        short errorCode;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("topic_name", Type.COMPACT_STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 5;
        
        public LeaderAndIsrPartitionError(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public LeaderAndIsrPartitionError() {
            this.topicName = "";
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 32767;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version <= 4) {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field topicName was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field topicName had invalid length " + length);
                } else {
                    this.topicName = _readable.readString(length);
                }
            } else {
                this.topicName = "";
            }
            this.partitionIndex = _readable.readInt();
            this.errorCode = _readable.readShort();
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
            if (_version <= 4) {
                {
                    byte[] _stringBytes = _cache.getSerializedValue(topicName);
                    if (_version >= 4) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
                }
            }
            _writable.writeInt(partitionIndex);
            _writable.writeShort(errorCode);
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
            if (_version <= 4) {
                {
                    byte[] _stringBytes = topicName.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'topicName' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(topicName, _stringBytes);
                    if (_version >= 4) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
                }
            }
            _size.addBytes(4);
            _size.addBytes(2);
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
            if (!(obj instanceof LeaderAndIsrPartitionError)) return false;
            LeaderAndIsrPartitionError other = (LeaderAndIsrPartitionError) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            return hashCode;
        }
        
        @Override
        public LeaderAndIsrPartitionError duplicate() {
            LeaderAndIsrPartitionError _duplicate = new LeaderAndIsrPartitionError();
            _duplicate.topicName = topicName;
            _duplicate.partitionIndex = partitionIndex;
            _duplicate.errorCode = errorCode;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "LeaderAndIsrPartitionError("
                + "topicName=" + ((topicName == null) ? "null" : "'" + topicName.toString() + "'")
                + ", partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
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
        
        public LeaderAndIsrPartitionError setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public LeaderAndIsrPartitionError setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public LeaderAndIsrPartitionError setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
    }
}
