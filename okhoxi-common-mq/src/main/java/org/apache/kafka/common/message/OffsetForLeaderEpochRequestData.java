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


public class OffsetForLeaderEpochRequestData implements ApiMessage {
    int replicaId;
    OffsetForLeaderTopicCollection topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopic.SCHEMA_0), "Each topic to get offsets for.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("topics", new ArrayOf(OffsetForLeaderTopic.SCHEMA_2), "Each topic to get offsets for.")
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("topics", new ArrayOf(OffsetForLeaderTopic.SCHEMA_2), "Each topic to get offsets for.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("topics", new CompactArrayOf(OffsetForLeaderTopic.SCHEMA_4), "Each topic to get offsets for."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 4;
    
    public OffsetForLeaderEpochRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public OffsetForLeaderEpochRequestData() {
        this.replicaId = -2;
        this.topics = new OffsetForLeaderTopicCollection(0);
    }
    
    @Override
    public short apiKey() {
        return 23;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 4;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 3) {
            this.replicaId = _readable.readInt();
        } else {
            this.replicaId = -2;
        }
        {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    OffsetForLeaderTopicCollection newCollection = new OffsetForLeaderTopicCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new OffsetForLeaderTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    OffsetForLeaderTopicCollection newCollection = new OffsetForLeaderTopicCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new OffsetForLeaderTopic(_readable, _version));
                    }
                    this.topics = newCollection;
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
        if (_version >= 3) {
            _writable.writeInt(replicaId);
        }
        if (_version >= 4) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (OffsetForLeaderTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (OffsetForLeaderTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
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
        if (_version >= 3) {
            _size.addBytes(4);
        }
        {
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (OffsetForLeaderTopic topicsElement : topics) {
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
        if (!(obj instanceof OffsetForLeaderEpochRequestData)) return false;
        OffsetForLeaderEpochRequestData other = (OffsetForLeaderEpochRequestData) obj;
        if (replicaId != other.replicaId) return false;
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
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public OffsetForLeaderEpochRequestData duplicate() {
        OffsetForLeaderEpochRequestData _duplicate = new OffsetForLeaderEpochRequestData();
        _duplicate.replicaId = replicaId;
        OffsetForLeaderTopicCollection newTopics = new OffsetForLeaderTopicCollection(topics.size());
        for (OffsetForLeaderTopic _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "OffsetForLeaderEpochRequestData("
            + "replicaId=" + replicaId
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public OffsetForLeaderTopicCollection topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public OffsetForLeaderEpochRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public OffsetForLeaderEpochRequestData setTopics(OffsetForLeaderTopicCollection v) {
        this.topics = v;
        return this;
    }
    
    public static class OffsetForLeaderTopic implements Message, ImplicitLinkedHashMultiCollection.Element {
        String topic;
        List<OffsetForLeaderPartition> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartition.SCHEMA_0), "Each partition to get offsets for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(OffsetForLeaderPartition.SCHEMA_2), "Each partition to get offsets for.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("topic", Type.COMPACT_STRING, "The topic name."),
                new Field("partitions", new CompactArrayOf(OffsetForLeaderPartition.SCHEMA_4), "Each partition to get offsets for."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 4;
        
        public OffsetForLeaderTopic(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public OffsetForLeaderTopic() {
            this.topic = "";
            this.partitions = new ArrayList<OffsetForLeaderPartition>(0);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 4;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of OffsetForLeaderTopic");
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field topic was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field topic had invalid length " + length);
                } else {
                    this.topic = _readable.readString(length);
                }
            }
            {
                if (_version >= 4) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<OffsetForLeaderPartition> newCollection = new ArrayList<OffsetForLeaderPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new OffsetForLeaderPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<OffsetForLeaderPartition> newCollection = new ArrayList<OffsetForLeaderPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new OffsetForLeaderPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
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
            {
                byte[] _stringBytes = _cache.getSerializedValue(topic);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 4) {
                _writable.writeUnsignedVarint(partitions.size() + 1);
                for (OffsetForLeaderPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitions.size());
                for (OffsetForLeaderPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
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
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of OffsetForLeaderTopic");
            }
            {
                byte[] _stringBytes = topic.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topic' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topic, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 4) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (OffsetForLeaderPartition partitionsElement : partitions) {
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
            if (!(obj instanceof OffsetForLeaderTopic)) return false;
            OffsetForLeaderTopic other = (OffsetForLeaderTopic) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetForLeaderTopic)) return false;
            OffsetForLeaderTopic other = (OffsetForLeaderTopic) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
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
            hashCode = 31 * hashCode + (topic == null ? 0 : topic.hashCode());
            return hashCode;
        }
        
        @Override
        public OffsetForLeaderTopic duplicate() {
            OffsetForLeaderTopic _duplicate = new OffsetForLeaderTopic();
            _duplicate.topic = topic;
            ArrayList<OffsetForLeaderPartition> newPartitions = new ArrayList<OffsetForLeaderPartition>(partitions.size());
            for (OffsetForLeaderPartition _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "OffsetForLeaderTopic("
                + "topic=" + ((topic == null) ? "null" : "'" + topic.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<OffsetForLeaderPartition> partitions() {
            return this.partitions;
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
        
        public OffsetForLeaderTopic setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public OffsetForLeaderTopic setPartitions(List<OffsetForLeaderPartition> v) {
            this.partitions = v;
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
    
    public static class OffsetForLeaderPartition implements Message {
        int partition;
        int currentLeaderEpoch;
        int leaderEpoch;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("leader_epoch", Type.INT32, "The epoch to look up an offset for.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "An epoch used to fence consumers/replicas with old metadata. If the epoch provided by the client is larger than the current epoch known to the broker, then the UNKNOWN_LEADER_EPOCH error code will be returned. If the provided epoch is smaller, then the FENCED_LEADER_EPOCH error code will be returned."),
                new Field("leader_epoch", Type.INT32, "The epoch to look up an offset for.")
            );
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "An epoch used to fence consumers/replicas with old metadata. If the epoch provided by the client is larger than the current epoch known to the broker, then the UNKNOWN_LEADER_EPOCH error code will be returned. If the provided epoch is smaller, then the FENCED_LEADER_EPOCH error code will be returned."),
                new Field("leader_epoch", Type.INT32, "The epoch to look up an offset for."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 4;
        
        public OffsetForLeaderPartition(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public OffsetForLeaderPartition() {
            this.partition = 0;
            this.currentLeaderEpoch = -1;
            this.leaderEpoch = 0;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 4;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of OffsetForLeaderPartition");
            }
            this.partition = _readable.readInt();
            if (_version >= 2) {
                this.currentLeaderEpoch = _readable.readInt();
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.leaderEpoch = _readable.readInt();
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
            _writable.writeInt(partition);
            if (_version >= 2) {
                _writable.writeInt(currentLeaderEpoch);
            }
            _writable.writeInt(leaderEpoch);
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
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of OffsetForLeaderPartition");
            }
            _size.addBytes(4);
            if (_version >= 2) {
                _size.addBytes(4);
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
            if (!(obj instanceof OffsetForLeaderPartition)) return false;
            OffsetForLeaderPartition other = (OffsetForLeaderPartition) obj;
            if (partition != other.partition) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partition;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + leaderEpoch;
            return hashCode;
        }
        
        @Override
        public OffsetForLeaderPartition duplicate() {
            OffsetForLeaderPartition _duplicate = new OffsetForLeaderPartition();
            _duplicate.partition = partition;
            _duplicate.currentLeaderEpoch = currentLeaderEpoch;
            _duplicate.leaderEpoch = leaderEpoch;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "OffsetForLeaderPartition("
                + "partition=" + partition
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", leaderEpoch=" + leaderEpoch
                + ")";
        }
        
        public int partition() {
            return this.partition;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public OffsetForLeaderPartition setPartition(int v) {
            this.partition = v;
            return this;
        }
        
        public OffsetForLeaderPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public OffsetForLeaderPartition setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
    }
    
    public static class OffsetForLeaderTopicCollection extends ImplicitLinkedHashMultiCollection<OffsetForLeaderTopic> {
        public OffsetForLeaderTopicCollection() {
            super();
        }
        
        public OffsetForLeaderTopicCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public OffsetForLeaderTopicCollection(Iterator<OffsetForLeaderTopic> iterator) {
            super(iterator);
        }
        
        public OffsetForLeaderTopic find(String topic) {
            OffsetForLeaderTopic _key = new OffsetForLeaderTopic();
            _key.setTopic(topic);
            return find(_key);
        }
        
        public List<OffsetForLeaderTopic> findAll(String topic) {
            OffsetForLeaderTopic _key = new OffsetForLeaderTopic();
            _key.setTopic(topic);
            return findAll(_key);
        }
        
        public OffsetForLeaderTopicCollection duplicate() {
            OffsetForLeaderTopicCollection _duplicate = new OffsetForLeaderTopicCollection(size());
            for (OffsetForLeaderTopic _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
