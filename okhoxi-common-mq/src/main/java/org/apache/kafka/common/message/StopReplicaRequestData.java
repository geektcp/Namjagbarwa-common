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


public class StopReplicaRequestData implements ApiMessage {
    int controllerId;
    int controllerEpoch;
    long brokerEpoch;
    boolean deletePartitions;
    List<StopReplicaPartitionV0> ungroupedPartitions;
    List<StopReplicaTopicV1> topics;
    List<StopReplicaTopicState> topicStates;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("delete_partitions", Type.BOOLEAN, "Whether these partitions should be deleted."),
            new Field("ungrouped_partitions", new ArrayOf(StopReplicaPartitionV0.SCHEMA_0), "The partitions to stop.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("delete_partitions", Type.BOOLEAN, "Whether these partitions should be deleted."),
            new Field("topics", new ArrayOf(StopReplicaTopicV1.SCHEMA_1), "The topics to stop.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("delete_partitions", Type.BOOLEAN, "Whether these partitions should be deleted."),
            new Field("topics", new CompactArrayOf(StopReplicaTopicV1.SCHEMA_2), "The topics to stop."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("topic_states", new CompactArrayOf(StopReplicaTopicState.SCHEMA_3), "Each topic."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 3;
    
    public StopReplicaRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public StopReplicaRequestData() {
        this.controllerId = 0;
        this.controllerEpoch = 0;
        this.brokerEpoch = -1L;
        this.deletePartitions = false;
        this.ungroupedPartitions = new ArrayList<StopReplicaPartitionV0>(0);
        this.topics = new ArrayList<StopReplicaTopicV1>(0);
        this.topicStates = new ArrayList<StopReplicaTopicState>(0);
    }
    
    @Override
    public short apiKey() {
        return 5;
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
        this.controllerId = _readable.readInt();
        this.controllerEpoch = _readable.readInt();
        if (_version >= 1) {
            this.brokerEpoch = _readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
        if (_version <= 2) {
            this.deletePartitions = _readable.readByte() != 0;
        } else {
            this.deletePartitions = false;
        }
        if (_version <= 0) {
            int arrayLength;
            arrayLength = _readable.readInt();
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field ungroupedPartitions was serialized as null");
            } else {
                ArrayList<StopReplicaPartitionV0> newCollection = new ArrayList<StopReplicaPartitionV0>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new StopReplicaPartitionV0(_readable, _version));
                }
                this.ungroupedPartitions = newCollection;
            }
        } else {
            this.ungroupedPartitions = new ArrayList<StopReplicaPartitionV0>(0);
        }
        if ((_version >= 1) && (_version <= 2)) {
            if (_version >= 2) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<StopReplicaTopicV1> newCollection = new ArrayList<StopReplicaTopicV1>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new StopReplicaTopicV1(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<StopReplicaTopicV1> newCollection = new ArrayList<StopReplicaTopicV1>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new StopReplicaTopicV1(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            }
        } else {
            this.topics = new ArrayList<StopReplicaTopicV1>(0);
        }
        if (_version >= 3) {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topicStates was serialized as null");
            } else {
                ArrayList<StopReplicaTopicState> newCollection = new ArrayList<StopReplicaTopicState>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new StopReplicaTopicState(_readable, _version));
                }
                this.topicStates = newCollection;
            }
        } else {
            this.topicStates = new ArrayList<StopReplicaTopicState>(0);
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
        _writable.writeInt(controllerId);
        _writable.writeInt(controllerEpoch);
        if (_version >= 1) {
            _writable.writeLong(brokerEpoch);
        }
        if (_version <= 2) {
            _writable.writeByte(deletePartitions ? (byte) 1 : (byte) 0);
        } else {
            if (this.deletePartitions) {
                throw new UnsupportedVersionException("Attempted to write a non-default deletePartitions at version " + _version);
            }
        }
        if (_version <= 0) {
            _writable.writeInt(ungroupedPartitions.size());
            for (StopReplicaPartitionV0 ungroupedPartitionsElement : ungroupedPartitions) {
                ungroupedPartitionsElement.write(_writable, _cache, _version);
            }
        } else {
            if (!this.ungroupedPartitions.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default ungroupedPartitions at version " + _version);
            }
        }
        if ((_version >= 1) && (_version <= 2)) {
            if (_version >= 2) {
                _writable.writeUnsignedVarint(topics.size() + 1);
                for (StopReplicaTopicV1 topicsElement : topics) {
                    topicsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(topics.size());
                for (StopReplicaTopicV1 topicsElement : topics) {
                    topicsElement.write(_writable, _cache, _version);
                }
            }
        } else {
            if (!this.topics.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topics at version " + _version);
            }
        }
        if (_version >= 3) {
            _writable.writeUnsignedVarint(topicStates.size() + 1);
            for (StopReplicaTopicState topicStatesElement : topicStates) {
                topicStatesElement.write(_writable, _cache, _version);
            }
        } else {
            if (!this.topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + _version);
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
        _size.addBytes(4);
        _size.addBytes(4);
        if (_version >= 1) {
            _size.addBytes(8);
        }
        if (_version <= 2) {
            _size.addBytes(1);
        }
        if (_version <= 0) {
            {
                _size.addBytes(4);
                for (StopReplicaPartitionV0 ungroupedPartitionsElement : ungroupedPartitions) {
                    ungroupedPartitionsElement.addSize(_size, _cache, _version);
                }
            }
        }
        if ((_version >= 1) && (_version <= 2)) {
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (StopReplicaTopicV1 topicsElement : topics) {
                    topicsElement.addSize(_size, _cache, _version);
                }
            }
        }
        if (_version >= 3) {
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topicStates.size() + 1));
                for (StopReplicaTopicState topicStatesElement : topicStates) {
                    topicStatesElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof StopReplicaRequestData)) return false;
        StopReplicaRequestData other = (StopReplicaRequestData) obj;
        if (controllerId != other.controllerId) return false;
        if (controllerEpoch != other.controllerEpoch) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (deletePartitions != other.deletePartitions) return false;
        if (this.ungroupedPartitions == null) {
            if (other.ungroupedPartitions != null) return false;
        } else {
            if (!this.ungroupedPartitions.equals(other.ungroupedPartitions)) return false;
        }
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (this.topicStates == null) {
            if (other.topicStates != null) return false;
        } else {
            if (!this.topicStates.equals(other.topicStates)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + controllerEpoch;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + (deletePartitions ? 1231 : 1237);
        hashCode = 31 * hashCode + (ungroupedPartitions == null ? 0 : ungroupedPartitions.hashCode());
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + (topicStates == null ? 0 : topicStates.hashCode());
        return hashCode;
    }
    
    @Override
    public StopReplicaRequestData duplicate() {
        StopReplicaRequestData _duplicate = new StopReplicaRequestData();
        _duplicate.controllerId = controllerId;
        _duplicate.controllerEpoch = controllerEpoch;
        _duplicate.brokerEpoch = brokerEpoch;
        _duplicate.deletePartitions = deletePartitions;
        ArrayList<StopReplicaPartitionV0> newUngroupedPartitions = new ArrayList<StopReplicaPartitionV0>(ungroupedPartitions.size());
        for (StopReplicaPartitionV0 _element : ungroupedPartitions) {
            newUngroupedPartitions.add(_element.duplicate());
        }
        _duplicate.ungroupedPartitions = newUngroupedPartitions;
        ArrayList<StopReplicaTopicV1> newTopics = new ArrayList<StopReplicaTopicV1>(topics.size());
        for (StopReplicaTopicV1 _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        ArrayList<StopReplicaTopicState> newTopicStates = new ArrayList<StopReplicaTopicState>(topicStates.size());
        for (StopReplicaTopicState _element : topicStates) {
            newTopicStates.add(_element.duplicate());
        }
        _duplicate.topicStates = newTopicStates;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "StopReplicaRequestData("
            + "controllerId=" + controllerId
            + ", controllerEpoch=" + controllerEpoch
            + ", brokerEpoch=" + brokerEpoch
            + ", deletePartitions=" + (deletePartitions ? "true" : "false")
            + ", ungroupedPartitions=" + MessageUtil.deepToString(ungroupedPartitions.iterator())
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ", topicStates=" + MessageUtil.deepToString(topicStates.iterator())
            + ")";
    }
    
    public int controllerId() {
        return this.controllerId;
    }
    
    public int controllerEpoch() {
        return this.controllerEpoch;
    }
    
    public long brokerEpoch() {
        return this.brokerEpoch;
    }
    
    public boolean deletePartitions() {
        return this.deletePartitions;
    }
    
    public List<StopReplicaPartitionV0> ungroupedPartitions() {
        return this.ungroupedPartitions;
    }
    
    public List<StopReplicaTopicV1> topics() {
        return this.topics;
    }
    
    public List<StopReplicaTopicState> topicStates() {
        return this.topicStates;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public StopReplicaRequestData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public StopReplicaRequestData setControllerEpoch(int v) {
        this.controllerEpoch = v;
        return this;
    }
    
    public StopReplicaRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public StopReplicaRequestData setDeletePartitions(boolean v) {
        this.deletePartitions = v;
        return this;
    }
    
    public StopReplicaRequestData setUngroupedPartitions(List<StopReplicaPartitionV0> v) {
        this.ungroupedPartitions = v;
        return this;
    }
    
    public StopReplicaRequestData setTopics(List<StopReplicaTopicV1> v) {
        this.topics = v;
        return this;
    }
    
    public StopReplicaRequestData setTopicStates(List<StopReplicaTopicState> v) {
        this.topicStates = v;
        return this;
    }
    
    public static class StopReplicaPartitionV0 implements Message {
        String topicName;
        int partitionIndex;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_index", Type.INT32, "The partition index.")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public StopReplicaPartitionV0(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public StopReplicaPartitionV0() {
            this.topicName = "";
            this.partitionIndex = 0;
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
                int length;
                length = _readable.readShort();
                if (length < 0) {
                    throw new RuntimeException("non-nullable field topicName was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field topicName had invalid length " + length);
                } else {
                    this.topicName = _readable.readString(length);
                }
            }
            this.partitionIndex = _readable.readInt();
            this._unknownTaggedFields = null;
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaPartitionV0");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(topicName);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(partitionIndex);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = topicName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topicName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topicName, _stringBytes);
                _size.addBytes(_stringBytes.length + 2);
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
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StopReplicaPartitionV0)) return false;
            StopReplicaPartitionV0 other = (StopReplicaPartitionV0) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            return hashCode;
        }
        
        @Override
        public StopReplicaPartitionV0 duplicate() {
            StopReplicaPartitionV0 _duplicate = new StopReplicaPartitionV0();
            _duplicate.topicName = topicName;
            _duplicate.partitionIndex = partitionIndex;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "StopReplicaPartitionV0("
                + "topicName=" + ((topicName == null) ? "null" : "'" + topicName.toString() + "'")
                + ", partitionIndex=" + partitionIndex
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public StopReplicaPartitionV0 setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public StopReplicaPartitionV0 setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
    }
    
    public static class StopReplicaTopicV1 implements Message {
        String name;
        List<Integer> partitionIndexes;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partition_indexes", new ArrayOf(Type.INT32), "The partition indexes.")
            );
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("partition_indexes", new CompactArrayOf(Type.INT32), "The partition indexes."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public StopReplicaTopicV1(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public StopReplicaTopicV1() {
            this.name = "";
            this.partitionIndexes = new ArrayList<Integer>(0);
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
            {
                int arrayLength;
                if (_version >= 2) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionIndexes was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.partitionIndexes = newCollection;
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
            if ((_version < 1) || (_version > 2)) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaTopicV1");
            }
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
            if (_version >= 2) {
                _writable.writeUnsignedVarint(partitionIndexes.size() + 1);
            } else {
                _writable.writeInt(partitionIndexes.size());
            }
            for (Integer partitionIndexesElement : partitionIndexes) {
                _writable.writeInt(partitionIndexesElement);
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
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionIndexes.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(partitionIndexes.size() * 4);
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
            if (!(obj instanceof StopReplicaTopicV1)) return false;
            StopReplicaTopicV1 other = (StopReplicaTopicV1) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitionIndexes == null) {
                if (other.partitionIndexes != null) return false;
            } else {
                if (!this.partitionIndexes.equals(other.partitionIndexes)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (partitionIndexes == null ? 0 : partitionIndexes.hashCode());
            return hashCode;
        }
        
        @Override
        public StopReplicaTopicV1 duplicate() {
            StopReplicaTopicV1 _duplicate = new StopReplicaTopicV1();
            _duplicate.name = name;
            ArrayList<Integer> newPartitionIndexes = new ArrayList<Integer>(partitionIndexes.size());
            for (Integer _element : partitionIndexes) {
                newPartitionIndexes.add(_element);
            }
            _duplicate.partitionIndexes = newPartitionIndexes;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "StopReplicaTopicV1("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitionIndexes=" + MessageUtil.deepToString(partitionIndexes.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitionIndexes() {
            return this.partitionIndexes;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public StopReplicaTopicV1 setName(String v) {
            this.name = v;
            return this;
        }
        
        public StopReplicaTopicV1 setPartitionIndexes(List<Integer> v) {
            this.partitionIndexes = v;
            return this;
        }
    }
    
    public static class StopReplicaTopicState implements Message {
        String topicName;
        List<StopReplicaPartitionState> partitionStates;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("topic_name", Type.COMPACT_STRING, "The topic name."),
                new Field("partition_states", new CompactArrayOf(StopReplicaPartitionState.SCHEMA_3), "The state of each partition"),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            SCHEMA_3
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 3;
        public static final short HIGHEST_SUPPORTED_VERSION = 3;
        
        public StopReplicaTopicState(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public StopReplicaTopicState() {
            this.topicName = "";
            this.partitionStates = new ArrayList<StopReplicaPartitionState>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of StopReplicaTopicState");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field topicName was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field topicName had invalid length " + length);
                } else {
                    this.topicName = _readable.readString(length);
                }
            }
            {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitionStates was serialized as null");
                } else {
                    ArrayList<StopReplicaPartitionState> newCollection = new ArrayList<StopReplicaPartitionState>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new StopReplicaPartitionState(_readable, _version));
                    }
                    this.partitionStates = newCollection;
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
            if (_version < 3) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of StopReplicaTopicState");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(topicName);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeUnsignedVarint(partitionStates.size() + 1);
            for (StopReplicaPartitionState partitionStatesElement : partitionStates) {
                partitionStatesElement.write(_writable, _cache, _version);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of StopReplicaTopicState");
            }
            {
                byte[] _stringBytes = topicName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topicName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topicName, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionStates.size() + 1));
                for (StopReplicaPartitionState partitionStatesElement : partitionStates) {
                    partitionStatesElement.addSize(_size, _cache, _version);
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
            if (!(obj instanceof StopReplicaTopicState)) return false;
            StopReplicaTopicState other = (StopReplicaTopicState) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (this.partitionStates == null) {
                if (other.partitionStates != null) return false;
            } else {
                if (!this.partitionStates.equals(other.partitionStates)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + (partitionStates == null ? 0 : partitionStates.hashCode());
            return hashCode;
        }
        
        @Override
        public StopReplicaTopicState duplicate() {
            StopReplicaTopicState _duplicate = new StopReplicaTopicState();
            _duplicate.topicName = topicName;
            ArrayList<StopReplicaPartitionState> newPartitionStates = new ArrayList<StopReplicaPartitionState>(partitionStates.size());
            for (StopReplicaPartitionState _element : partitionStates) {
                newPartitionStates.add(_element.duplicate());
            }
            _duplicate.partitionStates = newPartitionStates;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "StopReplicaTopicState("
                + "topicName=" + ((topicName == null) ? "null" : "'" + topicName.toString() + "'")
                + ", partitionStates=" + MessageUtil.deepToString(partitionStates.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public List<StopReplicaPartitionState> partitionStates() {
            return this.partitionStates;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public StopReplicaTopicState setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public StopReplicaTopicState setPartitionStates(List<StopReplicaPartitionState> v) {
            this.partitionStates = v;
            return this;
        }
    }
    
    public static class StopReplicaPartitionState implements Message {
        int partitionIndex;
        int leaderEpoch;
        boolean deletePartition;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("leader_epoch", Type.INT32, "The leader epoch."),
                new Field("delete_partition", Type.BOOLEAN, "Whether this partition should be deleted."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            SCHEMA_3
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 3;
        public static final short HIGHEST_SUPPORTED_VERSION = 3;
        
        public StopReplicaPartitionState(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public StopReplicaPartitionState() {
            this.partitionIndex = 0;
            this.leaderEpoch = -1;
            this.deletePartition = false;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 3;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 3;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of StopReplicaPartitionState");
            }
            this.partitionIndex = _readable.readInt();
            this.leaderEpoch = _readable.readInt();
            this.deletePartition = _readable.readByte() != 0;
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
            _writable.writeInt(partitionIndex);
            _writable.writeInt(leaderEpoch);
            _writable.writeByte(deletePartition ? (byte) 1 : (byte) 0);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 3) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of StopReplicaPartitionState");
            }
            _size.addBytes(4);
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
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StopReplicaPartitionState)) return false;
            StopReplicaPartitionState other = (StopReplicaPartitionState) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (deletePartition != other.deletePartition) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (deletePartition ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public StopReplicaPartitionState duplicate() {
            StopReplicaPartitionState _duplicate = new StopReplicaPartitionState();
            _duplicate.partitionIndex = partitionIndex;
            _duplicate.leaderEpoch = leaderEpoch;
            _duplicate.deletePartition = deletePartition;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "StopReplicaPartitionState("
                + "partitionIndex=" + partitionIndex
                + ", leaderEpoch=" + leaderEpoch
                + ", deletePartition=" + (deletePartition ? "true" : "false")
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public boolean deletePartition() {
            return this.deletePartition;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public StopReplicaPartitionState setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public StopReplicaPartitionState setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public StopReplicaPartitionState setDeletePartition(boolean v) {
            this.deletePartition = v;
            return this;
        }
    }
}
