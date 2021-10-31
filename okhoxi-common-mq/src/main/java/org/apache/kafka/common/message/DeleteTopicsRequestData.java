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


public class DeleteTopicsRequestData implements ApiMessage {
    List<DeleteTopicState> topics;
    List<String> topicNames;
    int timeoutMs;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topic_names", new ArrayOf(Type.STRING), "The names of the topics to delete"),
            new Field("timeout_ms", Type.INT32, "The length of time in milliseconds to wait for the deletions to complete.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("topic_names", new CompactArrayOf(Type.COMPACT_STRING), "The names of the topics to delete"),
            new Field("timeout_ms", Type.INT32, "The length of time in milliseconds to wait for the deletions to complete."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("topics", new CompactArrayOf(DeleteTopicState.SCHEMA_6), "The name or topic ID of the topic"),
            new Field("timeout_ms", Type.INT32, "The length of time in milliseconds to wait for the deletions to complete."),
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
    
    public DeleteTopicsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DeleteTopicsRequestData() {
        this.topics = new ArrayList<DeleteTopicState>(0);
        this.topicNames = new ArrayList<String>(0);
        this.timeoutMs = 0;
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
        if (_version >= 6) {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topics was serialized as null");
            } else {
                ArrayList<DeleteTopicState> newCollection = new ArrayList<DeleteTopicState>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new DeleteTopicState(_readable, _version));
                }
                this.topics = newCollection;
            }
        } else {
            this.topics = new ArrayList<DeleteTopicState>(0);
        }
        if (_version <= 5) {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topicNames was serialized as null");
                } else {
                    ArrayList<String> newCollection = new ArrayList<String>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        int length;
                        length = _readable.readUnsignedVarint() - 1;
                        if (length < 0) {
                            throw new RuntimeException("non-nullable field topicNames element was serialized as null");
                        } else if (length > 0x7fff) {
                            throw new RuntimeException("string field topicNames element had invalid length " + length);
                        } else {
                            newCollection.add(_readable.readString(length));
                        }
                    }
                    this.topicNames = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topicNames was serialized as null");
                } else {
                    ArrayList<String> newCollection = new ArrayList<String>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        int length;
                        length = _readable.readShort();
                        if (length < 0) {
                            throw new RuntimeException("non-nullable field topicNames element was serialized as null");
                        } else if (length > 0x7fff) {
                            throw new RuntimeException("string field topicNames element had invalid length " + length);
                        } else {
                            newCollection.add(_readable.readString(length));
                        }
                    }
                    this.topicNames = newCollection;
                }
            }
        } else {
            this.topicNames = new ArrayList<String>(0);
        }
        this.timeoutMs = _readable.readInt();
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
        if (_version >= 6) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (DeleteTopicState topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            if (!this.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
            }
        }
        if (_version <= 5) {
            if (_version >= 4) {
                _writable.writeUnsignedVarint(topicNames.size() + 1);
                for (String topicNamesElement : topicNames) {
                    {
                        byte[] _stringBytes = _cache.getSerializedValue(topicNamesElement);
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                        _writable.writeByteArray(_stringBytes);
                    }
                }
            } else {
                _writable.writeInt(topicNames.size());
                for (String topicNamesElement : topicNames) {
                    {
                        byte[] _stringBytes = _cache.getSerializedValue(topicNamesElement);
                        _writable.writeShort((short) _stringBytes.length);
                        _writable.writeByteArray(_stringBytes);
                    }
                }
            }
        }
        _writable.writeInt(timeoutMs);
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
        if (_version >= 6) {
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
                for (DeleteTopicState topicsElement : topics) {
                    topicsElement.addSize(_size, _cache, _version);
                }
            }
        }
        if (_version <= 5) {
            {
                if (_version >= 4) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topicNames.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (String topicNamesElement : topicNames) {
                    byte[] _stringBytes = topicNamesElement.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'topicNamesElement' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(topicNamesElement, _stringBytes);
                    if (_version >= 4) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
                }
            }
        }
        _size.addBytes(4);
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
        if (!(obj instanceof DeleteTopicsRequestData)) return false;
        DeleteTopicsRequestData other = (DeleteTopicsRequestData) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (this.topicNames == null) {
            if (other.topicNames != null) return false;
        } else {
            if (!this.topicNames.equals(other.topicNames)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + (topicNames == null ? 0 : topicNames.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        return hashCode;
    }
    
    @Override
    public DeleteTopicsRequestData duplicate() {
        DeleteTopicsRequestData _duplicate = new DeleteTopicsRequestData();
        ArrayList<DeleteTopicState> newTopics = new ArrayList<DeleteTopicState>(topics.size());
        for (DeleteTopicState _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        ArrayList<String> newTopicNames = new ArrayList<String>(topicNames.size());
        for (String _element : topicNames) {
            newTopicNames.add(_element);
        }
        _duplicate.topicNames = newTopicNames;
        _duplicate.timeoutMs = timeoutMs;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DeleteTopicsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", topicNames=" + MessageUtil.deepToString(topicNames.iterator())
            + ", timeoutMs=" + timeoutMs
            + ")";
    }
    
    public List<DeleteTopicState> topics() {
        return this.topics;
    }
    
    public List<String> topicNames() {
        return this.topicNames;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DeleteTopicsRequestData setTopics(List<DeleteTopicState> v) {
        this.topics = v;
        return this;
    }
    
    public DeleteTopicsRequestData setTopicNames(List<String> v) {
        this.topicNames = v;
        return this;
    }
    
    public DeleteTopicsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public static class DeleteTopicState implements Message {
        String name;
        Uuid topicId;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("name", Type.COMPACT_NULLABLE_STRING, "The topic name"),
                new Field("topic_id", Type.UUID, "The unique topic ID"),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            null,
            null,
            SCHEMA_6
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 6;
        public static final short HIGHEST_SUPPORTED_VERSION = 6;
        
        public DeleteTopicState(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DeleteTopicState() {
            this.name = "";
            this.topicId = Uuid.ZERO_UUID;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of DeleteTopicState");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    this.name = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            this.topicId = _readable.readUuid();
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
            if (_version < 6) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of DeleteTopicState");
            }
            int _numTaggedFields = 0;
            if (name == null) {
                _writable.writeUnsignedVarint(0);
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeUuid(topicId);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 6) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of DeleteTopicState");
            }
            if (name == null) {
                _size.addBytes(1);
            } else {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(16);
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
            if (!(obj instanceof DeleteTopicState)) return false;
            DeleteTopicState other = (DeleteTopicState) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (!this.topicId.equals(other.topicId)) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + topicId.hashCode();
            return hashCode;
        }
        
        @Override
        public DeleteTopicState duplicate() {
            DeleteTopicState _duplicate = new DeleteTopicState();
            if (name == null) {
                _duplicate.name = null;
            } else {
                _duplicate.name = name;
            }
            _duplicate.topicId = topicId;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DeleteTopicState("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", topicId=" + topicId.toString()
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public Uuid topicId() {
            return this.topicId;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DeleteTopicState setName(String v) {
            this.name = v;
            return this;
        }
        
        public DeleteTopicState setTopicId(Uuid v) {
            this.topicId = v;
            return this;
        }
    }
}
