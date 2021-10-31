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
import org.apache.kafka.common.protocol.types.CompactArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class ListPartitionReassignmentsResponseData implements ApiMessage {
    int throttleTimeMs;
    short errorCode;
    String errorMessage;
    List<OngoingTopicReassignment> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no error"),
            new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The top-level error message, or null if there was no error."),
            new Field("topics", new CompactArrayOf(OngoingTopicReassignment.SCHEMA_0), "The ongoing reassignments for each topic."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public ListPartitionReassignmentsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ListPartitionReassignmentsResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.errorMessage = "";
        this.topics = new ArrayList<OngoingTopicReassignment>(0);
    }
    
    @Override
    public short apiKey() {
        return 46;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        this.throttleTimeMs = _readable.readInt();
        this.errorCode = _readable.readShort();
        {
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                this.errorMessage = null;
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field errorMessage had invalid length " + length);
            } else {
                this.errorMessage = _readable.readString(length);
            }
        }
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topics was serialized as null");
            } else {
                ArrayList<OngoingTopicReassignment> newCollection = new ArrayList<OngoingTopicReassignment>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new OngoingTopicReassignment(_readable, _version));
                }
                this.topics = newCollection;
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
        int _numTaggedFields = 0;
        _writable.writeInt(throttleTimeMs);
        _writable.writeShort(errorCode);
        if (errorMessage == null) {
            _writable.writeUnsignedVarint(0);
        } else {
            byte[] _stringBytes = _cache.getSerializedValue(errorMessage);
            _writable.writeUnsignedVarint(_stringBytes.length + 1);
            _writable.writeByteArray(_stringBytes);
        }
        _writable.writeUnsignedVarint(topics.size() + 1);
        for (OngoingTopicReassignment topicsElement : topics) {
            topicsElement.write(_writable, _cache, _version);
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _size.addBytes(4);
        _size.addBytes(2);
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
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            for (OngoingTopicReassignment topicsElement : topics) {
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
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListPartitionReassignmentsResponseData)) return false;
        ListPartitionReassignmentsResponseData other = (ListPartitionReassignmentsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (this.errorMessage == null) {
            if (other.errorMessage != null) return false;
        } else {
            if (!this.errorMessage.equals(other.errorMessage)) return false;
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
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public ListPartitionReassignmentsResponseData duplicate() {
        ListPartitionReassignmentsResponseData _duplicate = new ListPartitionReassignmentsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        _duplicate.errorCode = errorCode;
        if (errorMessage == null) {
            _duplicate.errorMessage = null;
        } else {
            _duplicate.errorMessage = errorMessage;
        }
        ArrayList<OngoingTopicReassignment> newTopics = new ArrayList<OngoingTopicReassignment>(topics.size());
        for (OngoingTopicReassignment _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ListPartitionReassignmentsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", errorMessage=" + ((errorMessage == null) ? "null" : "'" + errorMessage.toString() + "'")
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public String errorMessage() {
        return this.errorMessage;
    }
    
    public List<OngoingTopicReassignment> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ListPartitionReassignmentsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public ListPartitionReassignmentsResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public ListPartitionReassignmentsResponseData setErrorMessage(String v) {
        this.errorMessage = v;
        return this;
    }
    
    public ListPartitionReassignmentsResponseData setTopics(List<OngoingTopicReassignment> v) {
        this.topics = v;
        return this;
    }
    
    public static class OngoingTopicReassignment implements Message {
        String name;
        List<OngoingPartitionReassignment> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("partitions", new CompactArrayOf(OngoingPartitionReassignment.SCHEMA_0), "The ongoing reassignments for each partition."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public OngoingTopicReassignment(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public OngoingTopicReassignment() {
            this.name = "";
            this.partitions = new ArrayList<OngoingPartitionReassignment>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 0;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of OngoingTopicReassignment");
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
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitions was serialized as null");
                } else {
                    ArrayList<OngoingPartitionReassignment> newCollection = new ArrayList<OngoingPartitionReassignment>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new OngoingPartitionReassignment(_readable, _version));
                    }
                    this.partitions = newCollection;
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
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeUnsignedVarint(partitions.size() + 1);
            for (OngoingPartitionReassignment partitionsElement : partitions) {
                partitionsElement.write(_writable, _cache, _version);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of OngoingTopicReassignment");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                for (OngoingPartitionReassignment partitionsElement : partitions) {
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
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OngoingTopicReassignment)) return false;
            OngoingTopicReassignment other = (OngoingTopicReassignment) obj;
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
        public OngoingTopicReassignment duplicate() {
            OngoingTopicReassignment _duplicate = new OngoingTopicReassignment();
            _duplicate.name = name;
            ArrayList<OngoingPartitionReassignment> newPartitions = new ArrayList<OngoingPartitionReassignment>(partitions.size());
            for (OngoingPartitionReassignment _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "OngoingTopicReassignment("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<OngoingPartitionReassignment> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public OngoingTopicReassignment setName(String v) {
            this.name = v;
            return this;
        }
        
        public OngoingTopicReassignment setPartitions(List<OngoingPartitionReassignment> v) {
            this.partitions = v;
            return this;
        }
    }
    
    public static class OngoingPartitionReassignment implements Message {
        int partitionIndex;
        List<Integer> replicas;
        List<Integer> addingReplicas;
        List<Integer> removingReplicas;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The index of the partition."),
                new Field("replicas", new CompactArrayOf(Type.INT32), "The current replica set."),
                new Field("adding_replicas", new CompactArrayOf(Type.INT32), "The set of replicas we are currently adding."),
                new Field("removing_replicas", new CompactArrayOf(Type.INT32), "The set of replicas we are currently removing."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public OngoingPartitionReassignment(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public OngoingPartitionReassignment() {
            this.partitionIndex = 0;
            this.replicas = new ArrayList<Integer>(0);
            this.addingReplicas = new ArrayList<Integer>(0);
            this.removingReplicas = new ArrayList<Integer>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 0;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of OngoingPartitionReassignment");
            }
            this.partitionIndex = _readable.readInt();
            {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
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
            {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field addingReplicas was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.addingReplicas = newCollection;
                }
            }
            {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field removingReplicas was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.removingReplicas = newCollection;
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
            int _numTaggedFields = 0;
            _writable.writeInt(partitionIndex);
            _writable.writeUnsignedVarint(replicas.size() + 1);
            for (Integer replicasElement : replicas) {
                _writable.writeInt(replicasElement);
            }
            _writable.writeUnsignedVarint(addingReplicas.size() + 1);
            for (Integer addingReplicasElement : addingReplicas) {
                _writable.writeInt(addingReplicasElement);
            }
            _writable.writeUnsignedVarint(removingReplicas.size() + 1);
            for (Integer removingReplicasElement : removingReplicas) {
                _writable.writeInt(removingReplicasElement);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of OngoingPartitionReassignment");
            }
            _size.addBytes(4);
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(replicas.size() + 1));
                _size.addBytes(replicas.size() * 4);
            }
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(addingReplicas.size() + 1));
                _size.addBytes(addingReplicas.size() * 4);
            }
            {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(removingReplicas.size() + 1));
                _size.addBytes(removingReplicas.size() * 4);
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
            if (!(obj instanceof OngoingPartitionReassignment)) return false;
            OngoingPartitionReassignment other = (OngoingPartitionReassignment) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (this.replicas == null) {
                if (other.replicas != null) return false;
            } else {
                if (!this.replicas.equals(other.replicas)) return false;
            }
            if (this.addingReplicas == null) {
                if (other.addingReplicas != null) return false;
            } else {
                if (!this.addingReplicas.equals(other.addingReplicas)) return false;
            }
            if (this.removingReplicas == null) {
                if (other.removingReplicas != null) return false;
            } else {
                if (!this.removingReplicas.equals(other.removingReplicas)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + (replicas == null ? 0 : replicas.hashCode());
            hashCode = 31 * hashCode + (addingReplicas == null ? 0 : addingReplicas.hashCode());
            hashCode = 31 * hashCode + (removingReplicas == null ? 0 : removingReplicas.hashCode());
            return hashCode;
        }
        
        @Override
        public OngoingPartitionReassignment duplicate() {
            OngoingPartitionReassignment _duplicate = new OngoingPartitionReassignment();
            _duplicate.partitionIndex = partitionIndex;
            ArrayList<Integer> newReplicas = new ArrayList<Integer>(replicas.size());
            for (Integer _element : replicas) {
                newReplicas.add(_element);
            }
            _duplicate.replicas = newReplicas;
            ArrayList<Integer> newAddingReplicas = new ArrayList<Integer>(addingReplicas.size());
            for (Integer _element : addingReplicas) {
                newAddingReplicas.add(_element);
            }
            _duplicate.addingReplicas = newAddingReplicas;
            ArrayList<Integer> newRemovingReplicas = new ArrayList<Integer>(removingReplicas.size());
            for (Integer _element : removingReplicas) {
                newRemovingReplicas.add(_element);
            }
            _duplicate.removingReplicas = newRemovingReplicas;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "OngoingPartitionReassignment("
                + "partitionIndex=" + partitionIndex
                + ", replicas=" + MessageUtil.deepToString(replicas.iterator())
                + ", addingReplicas=" + MessageUtil.deepToString(addingReplicas.iterator())
                + ", removingReplicas=" + MessageUtil.deepToString(removingReplicas.iterator())
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public List<Integer> replicas() {
            return this.replicas;
        }
        
        public List<Integer> addingReplicas() {
            return this.addingReplicas;
        }
        
        public List<Integer> removingReplicas() {
            return this.removingReplicas;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public OngoingPartitionReassignment setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public OngoingPartitionReassignment setReplicas(List<Integer> v) {
            this.replicas = v;
            return this;
        }
        
        public OngoingPartitionReassignment setAddingReplicas(List<Integer> v) {
            this.addingReplicas = v;
            return this;
        }
        
        public OngoingPartitionReassignment setRemovingReplicas(List<Integer> v) {
            this.removingReplicas = v;
            return this;
        }
    }
}
