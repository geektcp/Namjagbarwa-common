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


public class ListOffsetsRequestData implements ApiMessage {
    int replicaId;
    byte isolationLevel;
    List<ListOffsetsTopic> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("topics", new ArrayOf(ListOffsetsTopic.SCHEMA_0), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("topics", new ArrayOf(ListOffsetsTopic.SCHEMA_1), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(ListOffsetsTopic.SCHEMA_1), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(ListOffsetsTopic.SCHEMA_4), "Each topic in the request.")
        );
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the requestor, or -1 if this request is being made by a normal consumer."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new CompactArrayOf(ListOffsetsTopic.SCHEMA_6), "Each topic in the request."),
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
    
    public ListOffsetsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ListOffsetsRequestData() {
        this.replicaId = 0;
        this.isolationLevel = (byte) 0;
        this.topics = new ArrayList<ListOffsetsTopic>(0);
    }
    
    @Override
    public short apiKey() {
        return 2;
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
        this.replicaId = _readable.readInt();
        if (_version >= 2) {
            this.isolationLevel = _readable.readByte();
        } else {
            this.isolationLevel = (byte) 0;
        }
        {
            if (_version >= 6) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<ListOffsetsTopic> newCollection = new ArrayList<ListOffsetsTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ListOffsetsTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<ListOffsetsTopic> newCollection = new ArrayList<ListOffsetsTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ListOffsetsTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 6) {
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
        _writable.writeInt(replicaId);
        if (_version >= 2) {
            _writable.writeByte(isolationLevel);
        } else {
            if (this.isolationLevel != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default isolationLevel at version " + _version);
            }
        }
        if (_version >= 6) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (ListOffsetsTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (ListOffsetsTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 6) {
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
        _size.addBytes(4);
        if (_version >= 2) {
            _size.addBytes(1);
        }
        {
            if (_version >= 6) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (ListOffsetsTopic topicsElement : topics) {
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
        if (_version >= 6) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListOffsetsRequestData)) return false;
        ListOffsetsRequestData other = (ListOffsetsRequestData) obj;
        if (replicaId != other.replicaId) return false;
        if (isolationLevel != other.isolationLevel) return false;
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
        hashCode = 31 * hashCode + replicaId;
        hashCode = 31 * hashCode + isolationLevel;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public ListOffsetsRequestData duplicate() {
        ListOffsetsRequestData _duplicate = new ListOffsetsRequestData();
        _duplicate.replicaId = replicaId;
        _duplicate.isolationLevel = isolationLevel;
        ArrayList<ListOffsetsTopic> newTopics = new ArrayList<ListOffsetsTopic>(topics.size());
        for (ListOffsetsTopic _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ListOffsetsRequestData("
            + "replicaId=" + replicaId
            + ", isolationLevel=" + isolationLevel
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public byte isolationLevel() {
        return this.isolationLevel;
    }
    
    public List<ListOffsetsTopic> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ListOffsetsRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public ListOffsetsRequestData setIsolationLevel(byte v) {
        this.isolationLevel = v;
        return this;
    }
    
    public ListOffsetsRequestData setTopics(List<ListOffsetsTopic> v) {
        this.topics = v;
        return this;
    }
    
    public static class ListOffsetsTopic implements Message {
        String name;
        List<ListOffsetsPartition> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetsPartition.SCHEMA_0), "Each partition in the request.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetsPartition.SCHEMA_1), "Each partition in the request.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(ListOffsetsPartition.SCHEMA_4), "Each partition in the request.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("partitions", new CompactArrayOf(ListOffsetsPartition.SCHEMA_6), "Each partition in the request."),
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
        
        public ListOffsetsTopic(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ListOffsetsTopic() {
            this.name = "";
            this.partitions = new ArrayList<ListOffsetsPartition>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ListOffsetsTopic");
            }
            {
                int length;
                if (_version >= 6) {
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
            {
                if (_version >= 6) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<ListOffsetsPartition> newCollection = new ArrayList<ListOffsetsPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new ListOffsetsPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<ListOffsetsPartition> newCollection = new ArrayList<ListOffsetsPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new ListOffsetsPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 6) {
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
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 6) {
                _writable.writeUnsignedVarint(partitions.size() + 1);
                for (ListOffsetsPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitions.size());
                for (ListOffsetsPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 6) {
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ListOffsetsTopic");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 6) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 6) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (ListOffsetsPartition partitionsElement : partitions) {
                    partitionsElement.addSize(_size, _cache, _version);
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
            if (_version >= 6) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetsTopic)) return false;
            ListOffsetsTopic other = (ListOffsetsTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitions == null) {
                if (other.partitions != null) return false;
            } else {
                if (!this.partitions.equals(other.partitions)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public ListOffsetsTopic duplicate() {
            ListOffsetsTopic _duplicate = new ListOffsetsTopic();
            _duplicate.name = name;
            ArrayList<ListOffsetsPartition> newPartitions = new ArrayList<ListOffsetsPartition>(partitions.size());
            for (ListOffsetsPartition _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ListOffsetsTopic("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<ListOffsetsPartition> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ListOffsetsTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public ListOffsetsTopic setPartitions(List<ListOffsetsPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    public static class ListOffsetsPartition implements Message {
        int partitionIndex;
        int currentLeaderEpoch;
        long timestamp;
        int maxNumOffsets;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("timestamp", Type.INT64, "The current timestamp."),
                new Field("max_num_offsets", Type.INT32, "The maximum number of offsets to report.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("timestamp", Type.INT64, "The current timestamp.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch."),
                new Field("timestamp", Type.INT64, "The current timestamp.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch."),
                new Field("timestamp", Type.INT64, "The current timestamp."),
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
        
        public ListOffsetsPartition(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ListOffsetsPartition() {
            this.partitionIndex = 0;
            this.currentLeaderEpoch = -1;
            this.timestamp = 0L;
            this.maxNumOffsets = 1;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ListOffsetsPartition");
            }
            this.partitionIndex = _readable.readInt();
            if (_version >= 4) {
                this.currentLeaderEpoch = _readable.readInt();
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.timestamp = _readable.readLong();
            if (_version <= 0) {
                this.maxNumOffsets = _readable.readInt();
            } else {
                this.maxNumOffsets = 1;
            }
            this._unknownTaggedFields = null;
            if (_version >= 6) {
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
            _writable.writeInt(partitionIndex);
            if (_version >= 4) {
                _writable.writeInt(currentLeaderEpoch);
            }
            _writable.writeLong(timestamp);
            if (_version <= 0) {
                _writable.writeInt(maxNumOffsets);
            } else {
                if (this.maxNumOffsets != 1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default maxNumOffsets at version " + _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 6) {
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ListOffsetsPartition");
            }
            _size.addBytes(4);
            if (_version >= 4) {
                _size.addBytes(4);
            }
            _size.addBytes(8);
            if (_version <= 0) {
                _size.addBytes(4);
            }
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 6) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListOffsetsPartition)) return false;
            ListOffsetsPartition other = (ListOffsetsPartition) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (timestamp != other.timestamp) return false;
            if (maxNumOffsets != other.maxNumOffsets) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + ((int) (timestamp >> 32) ^ (int) timestamp);
            hashCode = 31 * hashCode + maxNumOffsets;
            return hashCode;
        }
        
        @Override
        public ListOffsetsPartition duplicate() {
            ListOffsetsPartition _duplicate = new ListOffsetsPartition();
            _duplicate.partitionIndex = partitionIndex;
            _duplicate.currentLeaderEpoch = currentLeaderEpoch;
            _duplicate.timestamp = timestamp;
            _duplicate.maxNumOffsets = maxNumOffsets;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ListOffsetsPartition("
                + "partitionIndex=" + partitionIndex
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", timestamp=" + timestamp
                + ", maxNumOffsets=" + maxNumOffsets
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public long timestamp() {
            return this.timestamp;
        }
        
        public int maxNumOffsets() {
            return this.maxNumOffsets;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ListOffsetsPartition setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public ListOffsetsPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public ListOffsetsPartition setTimestamp(long v) {
            this.timestamp = v;
            return this;
        }
        
        public ListOffsetsPartition setMaxNumOffsets(int v) {
            this.maxNumOffsets = v;
            return this;
        }
    }
}
