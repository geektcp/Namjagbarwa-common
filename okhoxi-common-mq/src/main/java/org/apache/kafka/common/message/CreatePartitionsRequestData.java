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


public class CreatePartitionsRequestData implements ApiMessage {
    CreatePartitionsTopicCollection topics;
    int timeoutMs;
    boolean validateOnly;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(CreatePartitionsTopic.SCHEMA_0), "Each topic that we want to create new partitions inside."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the partitions to be created."),
            new Field("validate_only", Type.BOOLEAN, "If true, then validate the request, but don't actually increase the number of partitions.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("topics", new CompactArrayOf(CreatePartitionsTopic.SCHEMA_2), "Each topic that we want to create new partitions inside."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the partitions to be created."),
            new Field("validate_only", Type.BOOLEAN, "If true, then validate the request, but don't actually increase the number of partitions."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 3;
    
    public CreatePartitionsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public CreatePartitionsRequestData() {
        this.topics = new CreatePartitionsTopicCollection(0);
        this.timeoutMs = 0;
        this.validateOnly = false;
    }
    
    @Override
    public short apiKey() {
        return 37;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 3;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            if (_version >= 2) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    CreatePartitionsTopicCollection newCollection = new CreatePartitionsTopicCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new CreatePartitionsTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    CreatePartitionsTopicCollection newCollection = new CreatePartitionsTopicCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new CreatePartitionsTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            }
        }
        this.timeoutMs = _readable.readInt();
        this.validateOnly = _readable.readByte() != 0;
        this._unknownTaggedFields = null;
        if (_version >= 2) {
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
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (CreatePartitionsTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (CreatePartitionsTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        }
        _writable.writeInt(timeoutMs);
        _writable.writeByte(validateOnly ? (byte) 1 : (byte) 0);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 2) {
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
        {
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (CreatePartitionsTopic topicsElement : topics) {
                topicsElement.addSize(_size, _cache, _version);
            }
        }
        _size.addBytes(4);
        _size.addBytes(1);
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        if (_version >= 2) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreatePartitionsRequestData)) return false;
        CreatePartitionsRequestData other = (CreatePartitionsRequestData) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        if (validateOnly != other.validateOnly) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        hashCode = 31 * hashCode + (validateOnly ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public CreatePartitionsRequestData duplicate() {
        CreatePartitionsRequestData _duplicate = new CreatePartitionsRequestData();
        CreatePartitionsTopicCollection newTopics = new CreatePartitionsTopicCollection(topics.size());
        for (CreatePartitionsTopic _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        _duplicate.timeoutMs = timeoutMs;
        _duplicate.validateOnly = validateOnly;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "CreatePartitionsRequestData("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", timeoutMs=" + timeoutMs
            + ", validateOnly=" + (validateOnly ? "true" : "false")
            + ")";
    }
    
    public CreatePartitionsTopicCollection topics() {
        return this.topics;
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public boolean validateOnly() {
        return this.validateOnly;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public CreatePartitionsRequestData setTopics(CreatePartitionsTopicCollection v) {
        this.topics = v;
        return this;
    }
    
    public CreatePartitionsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public CreatePartitionsRequestData setValidateOnly(boolean v) {
        this.validateOnly = v;
        return this;
    }
    
    public static class CreatePartitionsTopic implements Message, ImplicitLinkedHashMultiCollection.Element {
        String name;
        int count;
        List<CreatePartitionsAssignment> assignments;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("count", Type.INT32, "The new partition count."),
                new Field("assignments", ArrayOf.nullable(CreatePartitionsAssignment.SCHEMA_0), "The new partition assignments.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("count", Type.INT32, "The new partition count."),
                new Field("assignments", CompactArrayOf.nullable(CreatePartitionsAssignment.SCHEMA_2), "The new partition assignments."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 3;
        
        public CreatePartitionsTopic(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public CreatePartitionsTopic() {
            this.name = "";
            this.count = 0;
            this.assignments = new ArrayList<CreatePartitionsAssignment>(0);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatePartitionsTopic");
            }
            {
                int length;
                if (_version >= 2) {
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
            this.count = _readable.readInt();
            {
                if (_version >= 2) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        this.assignments = null;
                    } else {
                        ArrayList<CreatePartitionsAssignment> newCollection = new ArrayList<CreatePartitionsAssignment>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new CreatePartitionsAssignment(_readable, _version));
                        }
                        this.assignments = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        this.assignments = null;
                    } else {
                        ArrayList<CreatePartitionsAssignment> newCollection = new ArrayList<CreatePartitionsAssignment>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new CreatePartitionsAssignment(_readable, _version));
                        }
                        this.assignments = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 2) {
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
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                if (_version >= 2) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(count);
            if (_version >= 2) {
                if (assignments == null) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeUnsignedVarint(assignments.size() + 1);
                    for (CreatePartitionsAssignment assignmentsElement : assignments) {
                        assignmentsElement.write(_writable, _cache, _version);
                    }
                }
            } else {
                if (assignments == null) {
                    _writable.writeInt(-1);
                } else {
                    _writable.writeInt(assignments.size());
                    for (CreatePartitionsAssignment assignmentsElement : assignments) {
                        assignmentsElement.write(_writable, _cache, _version);
                    }
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 2) {
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
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of CreatePartitionsTopic");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 2) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(4);
            if (assignments == null) {
                if (_version >= 2) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(4);
                }
            } else {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(assignments.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (CreatePartitionsAssignment assignmentsElement : assignments) {
                    assignmentsElement.addSize(_size, _cache, _version);
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
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof CreatePartitionsTopic)) return false;
            CreatePartitionsTopic other = (CreatePartitionsTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatePartitionsTopic)) return false;
            CreatePartitionsTopic other = (CreatePartitionsTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (count != other.count) return false;
            if (this.assignments == null) {
                if (other.assignments != null) return false;
            } else {
                if (!this.assignments.equals(other.assignments)) return false;
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
        public CreatePartitionsTopic duplicate() {
            CreatePartitionsTopic _duplicate = new CreatePartitionsTopic();
            _duplicate.name = name;
            _duplicate.count = count;
            if (assignments == null) {
                _duplicate.assignments = null;
            } else {
                ArrayList<CreatePartitionsAssignment> newAssignments = new ArrayList<CreatePartitionsAssignment>(assignments.size());
                for (CreatePartitionsAssignment _element : assignments) {
                    newAssignments.add(_element.duplicate());
                }
                _duplicate.assignments = newAssignments;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "CreatePartitionsTopic("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", count=" + count
                + ", assignments=" + ((assignments == null) ? "null" : MessageUtil.deepToString(assignments.iterator()))
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public int count() {
            return this.count;
        }
        
        public List<CreatePartitionsAssignment> assignments() {
            return this.assignments;
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
        
        public CreatePartitionsTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public CreatePartitionsTopic setCount(int v) {
            this.count = v;
            return this;
        }
        
        public CreatePartitionsTopic setAssignments(List<CreatePartitionsAssignment> v) {
            this.assignments = v;
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
    
    public static class CreatePartitionsAssignment implements Message {
        List<Integer> brokerIds;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("broker_ids", new ArrayOf(Type.INT32), "The assigned broker IDs.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("broker_ids", new CompactArrayOf(Type.INT32), "The assigned broker IDs."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 3;
        
        public CreatePartitionsAssignment(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public CreatePartitionsAssignment() {
            this.brokerIds = new ArrayList<Integer>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of CreatePartitionsAssignment");
            }
            {
                int arrayLength;
                if (_version >= 2) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field brokerIds was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.brokerIds = newCollection;
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 2) {
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
                _writable.writeUnsignedVarint(brokerIds.size() + 1);
            } else {
                _writable.writeInt(brokerIds.size());
            }
            for (Integer brokerIdsElement : brokerIds) {
                _writable.writeInt(brokerIdsElement);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 2) {
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
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of CreatePartitionsAssignment");
            }
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(brokerIds.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(brokerIds.size() * 4);
            }
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CreatePartitionsAssignment)) return false;
            CreatePartitionsAssignment other = (CreatePartitionsAssignment) obj;
            if (this.brokerIds == null) {
                if (other.brokerIds != null) return false;
            } else {
                if (!this.brokerIds.equals(other.brokerIds)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (brokerIds == null ? 0 : brokerIds.hashCode());
            return hashCode;
        }
        
        @Override
        public CreatePartitionsAssignment duplicate() {
            CreatePartitionsAssignment _duplicate = new CreatePartitionsAssignment();
            ArrayList<Integer> newBrokerIds = new ArrayList<Integer>(brokerIds.size());
            for (Integer _element : brokerIds) {
                newBrokerIds.add(_element);
            }
            _duplicate.brokerIds = newBrokerIds;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "CreatePartitionsAssignment("
                + "brokerIds=" + MessageUtil.deepToString(brokerIds.iterator())
                + ")";
        }
        
        public List<Integer> brokerIds() {
            return this.brokerIds;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public CreatePartitionsAssignment setBrokerIds(List<Integer> v) {
            this.brokerIds = v;
            return this;
        }
    }
    
    public static class CreatePartitionsTopicCollection extends ImplicitLinkedHashMultiCollection<CreatePartitionsTopic> {
        public CreatePartitionsTopicCollection() {
            super();
        }
        
        public CreatePartitionsTopicCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public CreatePartitionsTopicCollection(Iterator<CreatePartitionsTopic> iterator) {
            super(iterator);
        }
        
        public CreatePartitionsTopic find(String name) {
            CreatePartitionsTopic _key = new CreatePartitionsTopic();
            _key.setName(name);
            return find(_key);
        }
        
        public List<CreatePartitionsTopic> findAll(String name) {
            CreatePartitionsTopic _key = new CreatePartitionsTopic();
            _key.setName(name);
            return findAll(_key);
        }
        
        public CreatePartitionsTopicCollection duplicate() {
            CreatePartitionsTopicCollection _duplicate = new CreatePartitionsTopicCollection(size());
            for (CreatePartitionsTopic _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
