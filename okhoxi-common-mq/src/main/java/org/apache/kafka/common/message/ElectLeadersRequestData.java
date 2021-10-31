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


public class ElectLeadersRequestData implements ApiMessage {
    byte electionType;
    List<TopicPartitions> topicPartitions;
    int timeoutMs;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topic_partitions", ArrayOf.nullable(TopicPartitions.SCHEMA_0), "The topic partitions to elect leaders."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the election to complete.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("election_type", Type.INT8, "Type of elections to conduct for the partition. A value of '0' elects the preferred replica. A value of '1' elects the first live replica if there are no in-sync replica."),
            new Field("topic_partitions", ArrayOf.nullable(TopicPartitions.SCHEMA_0), "The topic partitions to elect leaders."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the election to complete.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("election_type", Type.INT8, "Type of elections to conduct for the partition. A value of '0' elects the preferred replica. A value of '1' elects the first live replica if there are no in-sync replica."),
            new Field("topic_partitions", CompactArrayOf.nullable(TopicPartitions.SCHEMA_2), "The topic partitions to elect leaders."),
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the election to complete."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 2;
    
    public ElectLeadersRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ElectLeadersRequestData() {
        this.electionType = (byte) 0;
        this.topicPartitions = new ArrayList<TopicPartitions>(0);
        this.timeoutMs = 60000;
    }
    
    @Override
    public short apiKey() {
        return 43;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 2;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 1) {
            this.electionType = _readable.readByte();
        } else {
            this.electionType = (byte) 0;
        }
        {
            if (_version >= 2) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    this.topicPartitions = null;
                } else {
                    ArrayList<TopicPartitions> newCollection = new ArrayList<TopicPartitions>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new TopicPartitions(_readable, _version));
                    }
                    this.topicPartitions = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    this.topicPartitions = null;
                } else {
                    ArrayList<TopicPartitions> newCollection = new ArrayList<TopicPartitions>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new TopicPartitions(_readable, _version));
                    }
                    this.topicPartitions = newCollection;
                }
            }
        }
        this.timeoutMs = _readable.readInt();
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
        if (_version >= 1) {
            _writable.writeByte(electionType);
        } else {
            if (this.electionType != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default electionType at version " + _version);
            }
        }
        if (_version >= 2) {
            if (topicPartitions == null) {
                _writable.writeUnsignedVarint(0);
            } else {
                _writable.writeUnsignedVarint(topicPartitions.size() + 1);
                for (TopicPartitions topicPartitionsElement : topicPartitions) {
                    topicPartitionsElement.write(_writable, _cache, _version);
                }
            }
        } else {
            if (topicPartitions == null) {
                _writable.writeInt(-1);
            } else {
                _writable.writeInt(topicPartitions.size());
                for (TopicPartitions topicPartitionsElement : topicPartitions) {
                    topicPartitionsElement.write(_writable, _cache, _version);
                }
            }
        }
        _writable.writeInt(timeoutMs);
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
        if (_version >= 1) {
            _size.addBytes(1);
        }
        if (topicPartitions == null) {
            if (_version >= 2) {
                _size.addBytes(1);
            } else {
                _size.addBytes(4);
            }
        } else {
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topicPartitions.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (TopicPartitions topicPartitionsElement : topicPartitions) {
                topicPartitionsElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof ElectLeadersRequestData)) return false;
        ElectLeadersRequestData other = (ElectLeadersRequestData) obj;
        if (electionType != other.electionType) return false;
        if (this.topicPartitions == null) {
            if (other.topicPartitions != null) return false;
        } else {
            if (!this.topicPartitions.equals(other.topicPartitions)) return false;
        }
        if (timeoutMs != other.timeoutMs) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + electionType;
        hashCode = 31 * hashCode + (topicPartitions == null ? 0 : topicPartitions.hashCode());
        hashCode = 31 * hashCode + timeoutMs;
        return hashCode;
    }
    
    @Override
    public ElectLeadersRequestData duplicate() {
        ElectLeadersRequestData _duplicate = new ElectLeadersRequestData();
        _duplicate.electionType = electionType;
        if (topicPartitions == null) {
            _duplicate.topicPartitions = null;
        } else {
            ArrayList<TopicPartitions> newTopicPartitions = new ArrayList<TopicPartitions>(topicPartitions.size());
            for (TopicPartitions _element : topicPartitions) {
                newTopicPartitions.add(_element.duplicate());
            }
            _duplicate.topicPartitions = newTopicPartitions;
        }
        _duplicate.timeoutMs = timeoutMs;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ElectLeadersRequestData("
            + "electionType=" + electionType
            + ", topicPartitions=" + ((topicPartitions == null) ? "null" : MessageUtil.deepToString(topicPartitions.iterator()))
            + ", timeoutMs=" + timeoutMs
            + ")";
    }
    
    public byte electionType() {
        return this.electionType;
    }
    
    public List<TopicPartitions> topicPartitions() {
        return this.topicPartitions;
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
    
    public ElectLeadersRequestData setElectionType(byte v) {
        this.electionType = v;
        return this;
    }
    
    public ElectLeadersRequestData setTopicPartitions(List<TopicPartitions> v) {
        this.topicPartitions = v;
        return this;
    }
    
    public ElectLeadersRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public static class TopicPartitions implements Message {
        String topic;
        List<Integer> partitionId;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The name of a topic."),
                new Field("partition_id", new ArrayOf(Type.INT32), "The partitions of this topic whose leader should be elected.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("topic", Type.COMPACT_STRING, "The name of a topic."),
                new Field("partition_id", new CompactArrayOf(Type.INT32), "The partitions of this topic whose leader should be elected."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public TopicPartitions(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public TopicPartitions() {
            this.topic = "";
            this.partitionId = new ArrayList<Integer>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of TopicPartitions");
            }
            {
                int length;
                if (_version >= 2) {
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
                int arrayLength;
                if (_version >= 2) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionId was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.partitionId = newCollection;
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
                byte[] _stringBytes = _cache.getSerializedValue(topic);
                if (_version >= 2) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 2) {
                _writable.writeUnsignedVarint(partitionId.size() + 1);
            } else {
                _writable.writeInt(partitionId.size());
            }
            for (Integer partitionIdElement : partitionId) {
                _writable.writeInt(partitionIdElement);
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
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of TopicPartitions");
            }
            {
                byte[] _stringBytes = topic.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topic' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topic, _stringBytes);
                if (_version >= 2) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionId.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(partitionId.size() * 4);
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
            if (!(obj instanceof TopicPartitions)) return false;
            TopicPartitions other = (TopicPartitions) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
            }
            if (this.partitionId == null) {
                if (other.partitionId != null) return false;
            } else {
                if (!this.partitionId.equals(other.partitionId)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topic == null ? 0 : topic.hashCode());
            hashCode = 31 * hashCode + (partitionId == null ? 0 : partitionId.hashCode());
            return hashCode;
        }
        
        @Override
        public TopicPartitions duplicate() {
            TopicPartitions _duplicate = new TopicPartitions();
            _duplicate.topic = topic;
            ArrayList<Integer> newPartitionId = new ArrayList<Integer>(partitionId.size());
            for (Integer _element : partitionId) {
                newPartitionId.add(_element);
            }
            _duplicate.partitionId = newPartitionId;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "TopicPartitions("
                + "topic=" + ((topic == null) ? "null" : "'" + topic.toString() + "'")
                + ", partitionId=" + MessageUtil.deepToString(partitionId.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<Integer> partitionId() {
            return this.partitionId;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public TopicPartitions setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public TopicPartitions setPartitionId(List<Integer> v) {
            this.partitionId = v;
            return this;
        }
    }
}
