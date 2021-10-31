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


public class UpdateMetadataRequestData implements ApiMessage {
    int controllerId;
    int controllerEpoch;
    long brokerEpoch;
    List<UpdateMetadataPartitionState> ungroupedPartitionStates;
    List<UpdateMetadataTopicState> topicStates;
    List<UpdateMetadataBroker> liveBrokers;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("ungrouped_partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_0), "In older versions of this RPC, each partition that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_0), "")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("ungrouped_partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_0), "In older versions of this RPC, each partition that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_1), "")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("ungrouped_partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_0), "In older versions of this RPC, each partition that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_2), "")
        );
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("ungrouped_partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_0), "In older versions of this RPC, each partition that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_3), "")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("ungrouped_partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_4), "In older versions of this RPC, each partition that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_3), "")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("topic_states", new ArrayOf(UpdateMetadataTopicState.SCHEMA_5), "In newer versions of this RPC, each topic that we would like to update."),
            new Field("live_brokers", new ArrayOf(UpdateMetadataBroker.SCHEMA_3), "")
        );
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("topic_states", new CompactArrayOf(UpdateMetadataTopicState.SCHEMA_6), "In newer versions of this RPC, each topic that we would like to update."),
            new Field("live_brokers", new CompactArrayOf(UpdateMetadataBroker.SCHEMA_6), ""),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("controller_id", Type.INT32, "The controller id."),
            new Field("controller_epoch", Type.INT32, "The controller epoch."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("topic_states", new CompactArrayOf(UpdateMetadataTopicState.SCHEMA_7), "In newer versions of this RPC, each topic that we would like to update."),
            new Field("live_brokers", new CompactArrayOf(UpdateMetadataBroker.SCHEMA_6), ""),
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
    
    public UpdateMetadataRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public UpdateMetadataRequestData() {
        this.controllerId = 0;
        this.controllerEpoch = 0;
        this.brokerEpoch = -1L;
        this.ungroupedPartitionStates = new ArrayList<UpdateMetadataPartitionState>(0);
        this.topicStates = new ArrayList<UpdateMetadataTopicState>(0);
        this.liveBrokers = new ArrayList<UpdateMetadataBroker>(0);
    }
    
    @Override
    public short apiKey() {
        return 6;
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
        this.controllerId = _readable.readInt();
        this.controllerEpoch = _readable.readInt();
        if (_version >= 5) {
            this.brokerEpoch = _readable.readLong();
        } else {
            this.brokerEpoch = -1L;
        }
        if (_version <= 4) {
            int arrayLength;
            arrayLength = _readable.readInt();
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field ungroupedPartitionStates was serialized as null");
            } else {
                ArrayList<UpdateMetadataPartitionState> newCollection = new ArrayList<UpdateMetadataPartitionState>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new UpdateMetadataPartitionState(_readable, _version));
                }
                this.ungroupedPartitionStates = newCollection;
            }
        } else {
            this.ungroupedPartitionStates = new ArrayList<UpdateMetadataPartitionState>(0);
        }
        if (_version >= 5) {
            if (_version >= 6) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topicStates was serialized as null");
                } else {
                    ArrayList<UpdateMetadataTopicState> newCollection = new ArrayList<UpdateMetadataTopicState>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new UpdateMetadataTopicState(_readable, _version));
                    }
                    this.topicStates = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topicStates was serialized as null");
                } else {
                    ArrayList<UpdateMetadataTopicState> newCollection = new ArrayList<UpdateMetadataTopicState>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new UpdateMetadataTopicState(_readable, _version));
                    }
                    this.topicStates = newCollection;
                }
            }
        } else {
            this.topicStates = new ArrayList<UpdateMetadataTopicState>(0);
        }
        {
            if (_version >= 6) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field liveBrokers was serialized as null");
                } else {
                    ArrayList<UpdateMetadataBroker> newCollection = new ArrayList<UpdateMetadataBroker>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new UpdateMetadataBroker(_readable, _version));
                    }
                    this.liveBrokers = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field liveBrokers was serialized as null");
                } else {
                    ArrayList<UpdateMetadataBroker> newCollection = new ArrayList<UpdateMetadataBroker>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new UpdateMetadataBroker(_readable, _version));
                    }
                    this.liveBrokers = newCollection;
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
        _writable.writeInt(controllerId);
        _writable.writeInt(controllerEpoch);
        if (_version >= 5) {
            _writable.writeLong(brokerEpoch);
        }
        if (_version <= 4) {
            _writable.writeInt(ungroupedPartitionStates.size());
            for (UpdateMetadataPartitionState ungroupedPartitionStatesElement : ungroupedPartitionStates) {
                ungroupedPartitionStatesElement.write(_writable, _cache, _version);
            }
        } else {
            if (!this.ungroupedPartitionStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default ungroupedPartitionStates at version " + _version);
            }
        }
        if (_version >= 5) {
            if (_version >= 6) {
                _writable.writeUnsignedVarint(topicStates.size() + 1);
                for (UpdateMetadataTopicState topicStatesElement : topicStates) {
                    topicStatesElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(topicStates.size());
                for (UpdateMetadataTopicState topicStatesElement : topicStates) {
                    topicStatesElement.write(_writable, _cache, _version);
                }
            }
        } else {
            if (!this.topicStates.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default topicStates at version " + _version);
            }
        }
        if (_version >= 6) {
            _writable.writeUnsignedVarint(liveBrokers.size() + 1);
            for (UpdateMetadataBroker liveBrokersElement : liveBrokers) {
                liveBrokersElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(liveBrokers.size());
            for (UpdateMetadataBroker liveBrokersElement : liveBrokers) {
                liveBrokersElement.write(_writable, _cache, _version);
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
        _size.addBytes(4);
        if (_version >= 5) {
            _size.addBytes(8);
        }
        if (_version <= 4) {
            {
                _size.addBytes(4);
                for (UpdateMetadataPartitionState ungroupedPartitionStatesElement : ungroupedPartitionStates) {
                    ungroupedPartitionStatesElement.addSize(_size, _cache, _version);
                }
            }
        }
        if (_version >= 5) {
            {
                if (_version >= 6) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topicStates.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (UpdateMetadataTopicState topicStatesElement : topicStates) {
                    topicStatesElement.addSize(_size, _cache, _version);
                }
            }
        }
        {
            if (_version >= 6) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(liveBrokers.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (UpdateMetadataBroker liveBrokersElement : liveBrokers) {
                liveBrokersElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof UpdateMetadataRequestData)) return false;
        UpdateMetadataRequestData other = (UpdateMetadataRequestData) obj;
        if (controllerId != other.controllerId) return false;
        if (controllerEpoch != other.controllerEpoch) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (this.ungroupedPartitionStates == null) {
            if (other.ungroupedPartitionStates != null) return false;
        } else {
            if (!this.ungroupedPartitionStates.equals(other.ungroupedPartitionStates)) return false;
        }
        if (this.topicStates == null) {
            if (other.topicStates != null) return false;
        } else {
            if (!this.topicStates.equals(other.topicStates)) return false;
        }
        if (this.liveBrokers == null) {
            if (other.liveBrokers != null) return false;
        } else {
            if (!this.liveBrokers.equals(other.liveBrokers)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + controllerEpoch;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + (ungroupedPartitionStates == null ? 0 : ungroupedPartitionStates.hashCode());
        hashCode = 31 * hashCode + (topicStates == null ? 0 : topicStates.hashCode());
        hashCode = 31 * hashCode + (liveBrokers == null ? 0 : liveBrokers.hashCode());
        return hashCode;
    }
    
    @Override
    public UpdateMetadataRequestData duplicate() {
        UpdateMetadataRequestData _duplicate = new UpdateMetadataRequestData();
        _duplicate.controllerId = controllerId;
        _duplicate.controllerEpoch = controllerEpoch;
        _duplicate.brokerEpoch = brokerEpoch;
        ArrayList<UpdateMetadataPartitionState> newUngroupedPartitionStates = new ArrayList<UpdateMetadataPartitionState>(ungroupedPartitionStates.size());
        for (UpdateMetadataPartitionState _element : ungroupedPartitionStates) {
            newUngroupedPartitionStates.add(_element.duplicate());
        }
        _duplicate.ungroupedPartitionStates = newUngroupedPartitionStates;
        ArrayList<UpdateMetadataTopicState> newTopicStates = new ArrayList<UpdateMetadataTopicState>(topicStates.size());
        for (UpdateMetadataTopicState _element : topicStates) {
            newTopicStates.add(_element.duplicate());
        }
        _duplicate.topicStates = newTopicStates;
        ArrayList<UpdateMetadataBroker> newLiveBrokers = new ArrayList<UpdateMetadataBroker>(liveBrokers.size());
        for (UpdateMetadataBroker _element : liveBrokers) {
            newLiveBrokers.add(_element.duplicate());
        }
        _duplicate.liveBrokers = newLiveBrokers;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "UpdateMetadataRequestData("
            + "controllerId=" + controllerId
            + ", controllerEpoch=" + controllerEpoch
            + ", brokerEpoch=" + brokerEpoch
            + ", ungroupedPartitionStates=" + MessageUtil.deepToString(ungroupedPartitionStates.iterator())
            + ", topicStates=" + MessageUtil.deepToString(topicStates.iterator())
            + ", liveBrokers=" + MessageUtil.deepToString(liveBrokers.iterator())
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
    
    public List<UpdateMetadataPartitionState> ungroupedPartitionStates() {
        return this.ungroupedPartitionStates;
    }
    
    public List<UpdateMetadataTopicState> topicStates() {
        return this.topicStates;
    }
    
    public List<UpdateMetadataBroker> liveBrokers() {
        return this.liveBrokers;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public UpdateMetadataRequestData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public UpdateMetadataRequestData setControllerEpoch(int v) {
        this.controllerEpoch = v;
        return this;
    }
    
    public UpdateMetadataRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public UpdateMetadataRequestData setUngroupedPartitionStates(List<UpdateMetadataPartitionState> v) {
        this.ungroupedPartitionStates = v;
        return this;
    }
    
    public UpdateMetadataRequestData setTopicStates(List<UpdateMetadataTopicState> v) {
        this.topicStates = v;
        return this;
    }
    
    public UpdateMetadataRequestData setLiveBrokers(List<UpdateMetadataBroker> v) {
        this.liveBrokers = v;
        return this;
    }
    
    public static class UpdateMetadataTopicState implements Message {
        String topicName;
        Uuid topicId;
        List<UpdateMetadataPartitionState> partitionStates;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("topic_name", Type.STRING, "The topic name."),
                new Field("partition_states", new ArrayOf(UpdateMetadataPartitionState.SCHEMA_5), "The partition that we would like to update.")
            );
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("topic_name", Type.COMPACT_STRING, "The topic name."),
                new Field("partition_states", new CompactArrayOf(UpdateMetadataPartitionState.SCHEMA_6), "The partition that we would like to update."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("topic_name", Type.COMPACT_STRING, "The topic name."),
                new Field("topic_id", Type.UUID, "The topic id."),
                new Field("partition_states", new CompactArrayOf(UpdateMetadataPartitionState.SCHEMA_6), "The partition that we would like to update."),
                TaggedFieldsSection.of(
                )
            );
        
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
        
        public UpdateMetadataTopicState(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public UpdateMetadataTopicState() {
            this.topicName = "";
            this.topicId = Uuid.ZERO_UUID;
            this.partitionStates = new ArrayList<UpdateMetadataPartitionState>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of UpdateMetadataTopicState");
            }
            {
                int length;
                if (_version >= 6) {
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
            }
            if (_version >= 7) {
                this.topicId = _readable.readUuid();
            } else {
                this.topicId = Uuid.ZERO_UUID;
            }
            {
                if (_version >= 6) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitionStates was serialized as null");
                    } else {
                        ArrayList<UpdateMetadataPartitionState> newCollection = new ArrayList<UpdateMetadataPartitionState>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new UpdateMetadataPartitionState(_readable, _version));
                        }
                        this.partitionStates = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitionStates was serialized as null");
                    } else {
                        ArrayList<UpdateMetadataPartitionState> newCollection = new ArrayList<UpdateMetadataPartitionState>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new UpdateMetadataPartitionState(_readable, _version));
                        }
                        this.partitionStates = newCollection;
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
            if (_version < 5) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of UpdateMetadataTopicState");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(topicName);
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 7) {
                _writable.writeUuid(topicId);
            }
            if (_version >= 6) {
                _writable.writeUnsignedVarint(partitionStates.size() + 1);
                for (UpdateMetadataPartitionState partitionStatesElement : partitionStates) {
                    partitionStatesElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitionStates.size());
                for (UpdateMetadataPartitionState partitionStatesElement : partitionStates) {
                    partitionStatesElement.write(_writable, _cache, _version);
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
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of UpdateMetadataTopicState");
            }
            {
                byte[] _stringBytes = topicName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topicName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topicName, _stringBytes);
                if (_version >= 6) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version >= 7) {
                _size.addBytes(16);
            }
            {
                if (_version >= 6) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionStates.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (UpdateMetadataPartitionState partitionStatesElement : partitionStates) {
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
            if (!(obj instanceof UpdateMetadataTopicState)) return false;
            UpdateMetadataTopicState other = (UpdateMetadataTopicState) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (!this.topicId.equals(other.topicId)) return false;
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
            hashCode = 31 * hashCode + topicId.hashCode();
            hashCode = 31 * hashCode + (partitionStates == null ? 0 : partitionStates.hashCode());
            return hashCode;
        }
        
        @Override
        public UpdateMetadataTopicState duplicate() {
            UpdateMetadataTopicState _duplicate = new UpdateMetadataTopicState();
            _duplicate.topicName = topicName;
            _duplicate.topicId = topicId;
            ArrayList<UpdateMetadataPartitionState> newPartitionStates = new ArrayList<UpdateMetadataPartitionState>(partitionStates.size());
            for (UpdateMetadataPartitionState _element : partitionStates) {
                newPartitionStates.add(_element.duplicate());
            }
            _duplicate.partitionStates = newPartitionStates;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataTopicState("
                + "topicName=" + ((topicName == null) ? "null" : "'" + topicName.toString() + "'")
                + ", topicId=" + topicId.toString()
                + ", partitionStates=" + MessageUtil.deepToString(partitionStates.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public Uuid topicId() {
            return this.topicId;
        }
        
        public List<UpdateMetadataPartitionState> partitionStates() {
            return this.partitionStates;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public UpdateMetadataTopicState setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public UpdateMetadataTopicState setTopicId(Uuid v) {
            this.topicId = v;
            return this;
        }
        
        public UpdateMetadataTopicState setPartitionStates(List<UpdateMetadataPartitionState> v) {
            this.partitionStates = v;
            return this;
        }
    }
    
    public static class UpdateMetadataBroker implements Message {
        int id;
        String v0Host;
        int v0Port;
        List<UpdateMetadataEndpoint> endpoints;
        String rack;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("id", Type.INT32, "The broker id."),
                new Field("v0_host", Type.STRING, "The broker hostname."),
                new Field("v0_port", Type.INT32, "The broker port.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("id", Type.INT32, "The broker id."),
                new Field("endpoints", new ArrayOf(UpdateMetadataEndpoint.SCHEMA_1), "The broker endpoints.")
            );
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("id", Type.INT32, "The broker id."),
                new Field("endpoints", new ArrayOf(UpdateMetadataEndpoint.SCHEMA_1), "The broker endpoints."),
                new Field("rack", Type.NULLABLE_STRING, "The rack which this broker belongs to.")
            );
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("id", Type.INT32, "The broker id."),
                new Field("endpoints", new ArrayOf(UpdateMetadataEndpoint.SCHEMA_3), "The broker endpoints."),
                new Field("rack", Type.NULLABLE_STRING, "The rack which this broker belongs to.")
            );
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("id", Type.INT32, "The broker id."),
                new Field("endpoints", new CompactArrayOf(UpdateMetadataEndpoint.SCHEMA_6), "The broker endpoints."),
                new Field("rack", Type.COMPACT_NULLABLE_STRING, "The rack which this broker belongs to."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
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
        
        public UpdateMetadataBroker(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public UpdateMetadataBroker() {
            this.id = 0;
            this.v0Host = "";
            this.v0Port = 0;
            this.endpoints = new ArrayList<UpdateMetadataEndpoint>(0);
            this.rack = "";
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of UpdateMetadataBroker");
            }
            this.id = _readable.readInt();
            if (_version <= 0) {
                int length;
                length = _readable.readShort();
                if (length < 0) {
                    throw new RuntimeException("non-nullable field v0Host was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field v0Host had invalid length " + length);
                } else {
                    this.v0Host = _readable.readString(length);
                }
            } else {
                this.v0Host = "";
            }
            if (_version <= 0) {
                this.v0Port = _readable.readInt();
            } else {
                this.v0Port = 0;
            }
            if (_version >= 1) {
                if (_version >= 6) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field endpoints was serialized as null");
                    } else {
                        ArrayList<UpdateMetadataEndpoint> newCollection = new ArrayList<UpdateMetadataEndpoint>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new UpdateMetadataEndpoint(_readable, _version));
                        }
                        this.endpoints = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field endpoints was serialized as null");
                    } else {
                        ArrayList<UpdateMetadataEndpoint> newCollection = new ArrayList<UpdateMetadataEndpoint>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new UpdateMetadataEndpoint(_readable, _version));
                        }
                        this.endpoints = newCollection;
                    }
                }
            } else {
                this.endpoints = new ArrayList<UpdateMetadataEndpoint>(0);
            }
            if (_version >= 2) {
                int length;
                if (_version >= 6) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.rack = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field rack had invalid length " + length);
                } else {
                    this.rack = _readable.readString(length);
                }
            } else {
                this.rack = "";
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
            _writable.writeInt(id);
            if (_version <= 0) {
                {
                    byte[] _stringBytes = _cache.getSerializedValue(v0Host);
                    _writable.writeShort((short) _stringBytes.length);
                    _writable.writeByteArray(_stringBytes);
                }
            }
            if (_version <= 0) {
                _writable.writeInt(v0Port);
            }
            if (_version >= 1) {
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(endpoints.size() + 1);
                    for (UpdateMetadataEndpoint endpointsElement : endpoints) {
                        endpointsElement.write(_writable, _cache, _version);
                    }
                } else {
                    _writable.writeInt(endpoints.size());
                    for (UpdateMetadataEndpoint endpointsElement : endpoints) {
                        endpointsElement.write(_writable, _cache, _version);
                    }
                }
            }
            if (_version >= 2) {
                if (rack == null) {
                    if (_version >= 6) {
                        _writable.writeUnsignedVarint(0);
                    } else {
                        _writable.writeShort((short) -1);
                    }
                } else {
                    byte[] _stringBytes = _cache.getSerializedValue(rack);
                    if (_version >= 6) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
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
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of UpdateMetadataBroker");
            }
            _size.addBytes(4);
            if (_version <= 0) {
                {
                    byte[] _stringBytes = v0Host.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'v0Host' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(v0Host, _stringBytes);
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version <= 0) {
                _size.addBytes(4);
            }
            if (_version >= 1) {
                {
                    if (_version >= 6) {
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(endpoints.size() + 1));
                    } else {
                        _size.addBytes(4);
                    }
                    for (UpdateMetadataEndpoint endpointsElement : endpoints) {
                        endpointsElement.addSize(_size, _cache, _version);
                    }
                }
            }
            if (_version >= 2) {
                if (rack == null) {
                    if (_version >= 6) {
                        _size.addBytes(1);
                    } else {
                        _size.addBytes(2);
                    }
                } else {
                    byte[] _stringBytes = rack.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'rack' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(rack, _stringBytes);
                    if (_version >= 6) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
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
            if (!(obj instanceof UpdateMetadataBroker)) return false;
            UpdateMetadataBroker other = (UpdateMetadataBroker) obj;
            if (id != other.id) return false;
            if (this.v0Host == null) {
                if (other.v0Host != null) return false;
            } else {
                if (!this.v0Host.equals(other.v0Host)) return false;
            }
            if (v0Port != other.v0Port) return false;
            if (this.endpoints == null) {
                if (other.endpoints != null) return false;
            } else {
                if (!this.endpoints.equals(other.endpoints)) return false;
            }
            if (this.rack == null) {
                if (other.rack != null) return false;
            } else {
                if (!this.rack.equals(other.rack)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + id;
            hashCode = 31 * hashCode + (v0Host == null ? 0 : v0Host.hashCode());
            hashCode = 31 * hashCode + v0Port;
            hashCode = 31 * hashCode + (endpoints == null ? 0 : endpoints.hashCode());
            hashCode = 31 * hashCode + (rack == null ? 0 : rack.hashCode());
            return hashCode;
        }
        
        @Override
        public UpdateMetadataBroker duplicate() {
            UpdateMetadataBroker _duplicate = new UpdateMetadataBroker();
            _duplicate.id = id;
            _duplicate.v0Host = v0Host;
            _duplicate.v0Port = v0Port;
            ArrayList<UpdateMetadataEndpoint> newEndpoints = new ArrayList<UpdateMetadataEndpoint>(endpoints.size());
            for (UpdateMetadataEndpoint _element : endpoints) {
                newEndpoints.add(_element.duplicate());
            }
            _duplicate.endpoints = newEndpoints;
            if (rack == null) {
                _duplicate.rack = null;
            } else {
                _duplicate.rack = rack;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataBroker("
                + "id=" + id
                + ", v0Host=" + ((v0Host == null) ? "null" : "'" + v0Host.toString() + "'")
                + ", v0Port=" + v0Port
                + ", endpoints=" + MessageUtil.deepToString(endpoints.iterator())
                + ", rack=" + ((rack == null) ? "null" : "'" + rack.toString() + "'")
                + ")";
        }
        
        public int id() {
            return this.id;
        }
        
        public String v0Host() {
            return this.v0Host;
        }
        
        public int v0Port() {
            return this.v0Port;
        }
        
        public List<UpdateMetadataEndpoint> endpoints() {
            return this.endpoints;
        }
        
        public String rack() {
            return this.rack;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public UpdateMetadataBroker setId(int v) {
            this.id = v;
            return this;
        }
        
        public UpdateMetadataBroker setV0Host(String v) {
            this.v0Host = v;
            return this;
        }
        
        public UpdateMetadataBroker setV0Port(int v) {
            this.v0Port = v;
            return this;
        }
        
        public UpdateMetadataBroker setEndpoints(List<UpdateMetadataEndpoint> v) {
            this.endpoints = v;
            return this;
        }
        
        public UpdateMetadataBroker setRack(String v) {
            this.rack = v;
            return this;
        }
    }
    
    public static class UpdateMetadataEndpoint implements Message {
        int port;
        String host;
        String listener;
        short securityProtocol;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("port", Type.INT32, "The port of this endpoint"),
                new Field("host", Type.STRING, "The hostname of this endpoint"),
                new Field("security_protocol", Type.INT16, "The security protocol type.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("port", Type.INT32, "The port of this endpoint"),
                new Field("host", Type.STRING, "The hostname of this endpoint"),
                new Field("listener", Type.STRING, "The listener name."),
                new Field("security_protocol", Type.INT16, "The security protocol type.")
            );
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("port", Type.INT32, "The port of this endpoint"),
                new Field("host", Type.COMPACT_STRING, "The hostname of this endpoint"),
                new Field("listener", Type.COMPACT_STRING, "The listener name."),
                new Field("security_protocol", Type.INT16, "The security protocol type."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 7;
        
        public UpdateMetadataEndpoint(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public UpdateMetadataEndpoint() {
            this.port = 0;
            this.host = "";
            this.listener = "";
            this.securityProtocol = (short) 0;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of UpdateMetadataEndpoint");
            }
            this.port = _readable.readInt();
            {
                int length;
                if (_version >= 6) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field host was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field host had invalid length " + length);
                } else {
                    this.host = _readable.readString(length);
                }
            }
            if (_version >= 3) {
                int length;
                if (_version >= 6) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field listener was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field listener had invalid length " + length);
                } else {
                    this.listener = _readable.readString(length);
                }
            } else {
                this.listener = "";
            }
            this.securityProtocol = _readable.readShort();
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
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of UpdateMetadataEndpoint");
            }
            int _numTaggedFields = 0;
            _writable.writeInt(port);
            {
                byte[] _stringBytes = _cache.getSerializedValue(host);
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 3) {
                {
                    byte[] _stringBytes = _cache.getSerializedValue(listener);
                    if (_version >= 6) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
                }
            }
            _writable.writeShort(securityProtocol);
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
            if (_version > 7) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of UpdateMetadataEndpoint");
            }
            _size.addBytes(4);
            {
                byte[] _stringBytes = host.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'host' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(host, _stringBytes);
                if (_version >= 6) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version >= 3) {
                {
                    byte[] _stringBytes = listener.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'listener' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(listener, _stringBytes);
                    if (_version >= 6) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
                }
            }
            _size.addBytes(2);
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
            if (!(obj instanceof UpdateMetadataEndpoint)) return false;
            UpdateMetadataEndpoint other = (UpdateMetadataEndpoint) obj;
            if (port != other.port) return false;
            if (this.host == null) {
                if (other.host != null) return false;
            } else {
                if (!this.host.equals(other.host)) return false;
            }
            if (this.listener == null) {
                if (other.listener != null) return false;
            } else {
                if (!this.listener.equals(other.listener)) return false;
            }
            if (securityProtocol != other.securityProtocol) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + port;
            hashCode = 31 * hashCode + (host == null ? 0 : host.hashCode());
            hashCode = 31 * hashCode + (listener == null ? 0 : listener.hashCode());
            hashCode = 31 * hashCode + securityProtocol;
            return hashCode;
        }
        
        @Override
        public UpdateMetadataEndpoint duplicate() {
            UpdateMetadataEndpoint _duplicate = new UpdateMetadataEndpoint();
            _duplicate.port = port;
            _duplicate.host = host;
            _duplicate.listener = listener;
            _duplicate.securityProtocol = securityProtocol;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataEndpoint("
                + "port=" + port
                + ", host=" + ((host == null) ? "null" : "'" + host.toString() + "'")
                + ", listener=" + ((listener == null) ? "null" : "'" + listener.toString() + "'")
                + ", securityProtocol=" + securityProtocol
                + ")";
        }
        
        public int port() {
            return this.port;
        }
        
        public String host() {
            return this.host;
        }
        
        public String listener() {
            return this.listener;
        }
        
        public short securityProtocol() {
            return this.securityProtocol;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public UpdateMetadataEndpoint setPort(int v) {
            this.port = v;
            return this;
        }
        
        public UpdateMetadataEndpoint setHost(String v) {
            this.host = v;
            return this;
        }
        
        public UpdateMetadataEndpoint setListener(String v) {
            this.listener = v;
            return this;
        }
        
        public UpdateMetadataEndpoint setSecurityProtocol(short v) {
            this.securityProtocol = v;
            return this;
        }
    }
    
    public static class UpdateMetadataPartitionState implements Message {
        String topicName;
        int partitionIndex;
        int controllerEpoch;
        int leader;
        int leaderEpoch;
        List<Integer> isr;
        int zkVersion;
        List<Integer> replicas;
        List<Integer> offlineReplicas;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic_name", Type.STRING, "In older versions of this RPC, the topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("topic_name", Type.STRING, "In older versions of this RPC, the topic name."),
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The replicas of this partition which are offline.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new ArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new ArrayOf(Type.INT32), "All the replicas of this partition."),
                new Field("offline_replicas", new ArrayOf(Type.INT32), "The replicas of this partition which are offline.")
            );
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("controller_epoch", Type.INT32, "The controller epoch."),
                new Field("leader", Type.INT32, "The ID of the broker which is the current partition leader."),
                new Field("leader_epoch", Type.INT32, "The leader epoch of this partition."),
                new Field("isr", new CompactArrayOf(Type.INT32), "The brokers which are in the ISR for this partition."),
                new Field("zk_version", Type.INT32, "The Zookeeper version."),
                new Field("replicas", new CompactArrayOf(Type.INT32), "All the replicas of this partition."),
                new Field("offline_replicas", new CompactArrayOf(Type.INT32), "The replicas of this partition which are offline."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
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
        
        public UpdateMetadataPartitionState(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public UpdateMetadataPartitionState() {
            this.topicName = "";
            this.partitionIndex = 0;
            this.controllerEpoch = 0;
            this.leader = 0;
            this.leaderEpoch = 0;
            this.isr = new ArrayList<Integer>(0);
            this.zkVersion = 0;
            this.replicas = new ArrayList<Integer>(0);
            this.offlineReplicas = new ArrayList<Integer>(0);
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
                length = _readable.readShort();
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
            this.controllerEpoch = _readable.readInt();
            this.leader = _readable.readInt();
            this.leaderEpoch = _readable.readInt();
            {
                int arrayLength;
                if (_version >= 6) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field isr was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.isr = newCollection;
                }
            }
            this.zkVersion = _readable.readInt();
            {
                int arrayLength;
                if (_version >= 6) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field replicas was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.replicas = newCollection;
                }
            }
            if (_version >= 4) {
                int arrayLength;
                if (_version >= 6) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field offlineReplicas was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.offlineReplicas = newCollection;
                }
            } else {
                this.offlineReplicas = new ArrayList<Integer>(0);
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
            if (_version <= 4) {
                {
                    byte[] _stringBytes = _cache.getSerializedValue(topicName);
                    _writable.writeShort((short) _stringBytes.length);
                    _writable.writeByteArray(_stringBytes);
                }
            }
            _writable.writeInt(partitionIndex);
            _writable.writeInt(controllerEpoch);
            _writable.writeInt(leader);
            _writable.writeInt(leaderEpoch);
            if (_version >= 6) {
                _writable.writeUnsignedVarint(isr.size() + 1);
            } else {
                _writable.writeInt(isr.size());
            }
            for (Integer isrElement : isr) {
                _writable.writeInt(isrElement);
            }
            _writable.writeInt(zkVersion);
            if (_version >= 6) {
                _writable.writeUnsignedVarint(replicas.size() + 1);
            } else {
                _writable.writeInt(replicas.size());
            }
            for (Integer replicasElement : replicas) {
                _writable.writeInt(replicasElement);
            }
            if (_version >= 4) {
                if (_version >= 6) {
                    _writable.writeUnsignedVarint(offlineReplicas.size() + 1);
                } else {
                    _writable.writeInt(offlineReplicas.size());
                }
                for (Integer offlineReplicasElement : offlineReplicas) {
                    _writable.writeInt(offlineReplicasElement);
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
            if (_version <= 4) {
                {
                    byte[] _stringBytes = topicName.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'topicName' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(topicName, _stringBytes);
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(4);
            _size.addBytes(4);
            _size.addBytes(4);
            _size.addBytes(4);
            {
                if (_version >= 6) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(isr.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(isr.size() * 4);
            }
            _size.addBytes(4);
            {
                if (_version >= 6) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(replicas.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(replicas.size() * 4);
            }
            if (_version >= 4) {
                {
                    if (_version >= 6) {
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(offlineReplicas.size() + 1));
                    } else {
                        _size.addBytes(4);
                    }
                    _size.addBytes(offlineReplicas.size() * 4);
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
            if (!(obj instanceof UpdateMetadataPartitionState)) return false;
            UpdateMetadataPartitionState other = (UpdateMetadataPartitionState) obj;
            if (this.topicName == null) {
                if (other.topicName != null) return false;
            } else {
                if (!this.topicName.equals(other.topicName)) return false;
            }
            if (partitionIndex != other.partitionIndex) return false;
            if (controllerEpoch != other.controllerEpoch) return false;
            if (leader != other.leader) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            if (this.isr == null) {
                if (other.isr != null) return false;
            } else {
                if (!this.isr.equals(other.isr)) return false;
            }
            if (zkVersion != other.zkVersion) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (this.offlineReplicas == null) {
                if (other.offlineReplicas != null) return false;
            } else {
                if (!this.offlineReplicas.equals(other.offlineReplicas)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topicName == null ? 0 : topicName.hashCode());
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + controllerEpoch;
            hashCode = 31 * hashCode + leader;
            hashCode = 31 * hashCode + leaderEpoch;
            hashCode = 31 * hashCode + (isr == null ? 0 : isr.hashCode());
            hashCode = 31 * hashCode + zkVersion;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (offlineReplicas == null ? 0 : offlineReplicas.hashCode());
            return hashCode;
        }
        
        @Override
        public UpdateMetadataPartitionState duplicate() {
            UpdateMetadataPartitionState _duplicate = new UpdateMetadataPartitionState();
            _duplicate.topicName = topicName;
            _duplicate.partitionIndex = partitionIndex;
            _duplicate.controllerEpoch = controllerEpoch;
            _duplicate.leader = leader;
            _duplicate.leaderEpoch = leaderEpoch;
            ArrayList<Integer> newIsr = new ArrayList<Integer>(isr.size());
            for (Integer _element : isr) {
                newIsr.add(_element);
            }
            _duplicate.isr = newIsr;
            _duplicate.zkVersion = zkVersion;
            ArrayList<Integer> newReplicas = new ArrayList<Integer>(replicas.size());
            for (Integer _element : replicas) {
                newReplicas.add(_element);
            }
            _duplicate.replicas = newReplicas;
            ArrayList<Integer> newOfflineReplicas = new ArrayList<Integer>(offlineReplicas.size());
            for (Integer _element : offlineReplicas) {
                newOfflineReplicas.add(_element);
            }
            _duplicate.offlineReplicas = newOfflineReplicas;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "UpdateMetadataPartitionState("
                + "topicName=" + ((topicName == null) ? "null" : "'" + topicName.toString() + "'")
                + ", partitionIndex=" + partitionIndex
                + ", controllerEpoch=" + controllerEpoch
                + ", leader=" + leader
                + ", leaderEpoch=" + leaderEpoch
                + ", isr=" + MessageUtil.deepToString(isr.iterator())
                + ", zkVersion=" + zkVersion
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", offlineReplicas=" + MessageUtil.deepToString(offlineReplicas.iterator())
                + ")";
        }
        
        public String topicName() {
            return this.topicName;
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public int controllerEpoch() {
            return this.controllerEpoch;
        }
        
        public int leader() {
            return this.leader;
        }
        
        public int leaderEpoch() {
            return this.leaderEpoch;
        }
        
        public List<Integer> isr() {
            return this.isr;
        }
        
        public int zkVersion() {
            return this.zkVersion;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public List<Integer> offlineReplicas() {
            return this.offlineReplicas;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public UpdateMetadataPartitionState setTopicName(String v) {
            this.topicName = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setControllerEpoch(int v) {
            this.controllerEpoch = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setLeader(int v) {
            this.leader = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setIsr(List<Integer> v) {
            this.isr = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setZkVersion(int v) {
            this.zkVersion = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public UpdateMetadataPartitionState setOfflineReplicas(List<Integer> v) {
            this.offlineReplicas = v;
            return this;
        }
    }
}
