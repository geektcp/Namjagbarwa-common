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


public class ListPartitionReassignmentsRequestData implements ApiMessage {
    int timeoutMs;
    List<ListPartitionReassignmentsTopics> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("timeout_ms", Type.INT32, "The time in ms to wait for the request to complete."),
            new Field("topics", CompactArrayOf.nullable(ListPartitionReassignmentsTopics.SCHEMA_0), "The topics to list partition reassignments for, or null to list everything."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public ListPartitionReassignmentsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ListPartitionReassignmentsRequestData() {
        this.timeoutMs = 60000;
        this.topics = null;
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
        this.timeoutMs = _readable.readInt();
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                this.topics = null;
            } else {
                ArrayList<ListPartitionReassignmentsTopics> newCollection = new ArrayList<ListPartitionReassignmentsTopics>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new ListPartitionReassignmentsTopics(_readable, _version));
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
        _writable.writeInt(timeoutMs);
        if (topics == null) {
            _writable.writeUnsignedVarint(0);
        } else {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (ListPartitionReassignmentsTopics topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
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
        if (topics == null) {
            _size.addBytes(1);
        } else {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            for (ListPartitionReassignmentsTopics topicsElement : topics) {
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
        if (!(obj instanceof ListPartitionReassignmentsRequestData)) return false;
        ListPartitionReassignmentsRequestData other = (ListPartitionReassignmentsRequestData) obj;
        if (timeoutMs != other.timeoutMs) return false;
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
        hashCode = 31 * hashCode + timeoutMs;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public ListPartitionReassignmentsRequestData duplicate() {
        ListPartitionReassignmentsRequestData _duplicate = new ListPartitionReassignmentsRequestData();
        _duplicate.timeoutMs = timeoutMs;
        if (topics == null) {
            _duplicate.topics = null;
        } else {
            ArrayList<ListPartitionReassignmentsTopics> newTopics = new ArrayList<ListPartitionReassignmentsTopics>(topics.size());
            for (ListPartitionReassignmentsTopics _element : topics) {
                newTopics.add(_element.duplicate());
            }
            _duplicate.topics = newTopics;
        }
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ListPartitionReassignmentsRequestData("
            + "timeoutMs=" + timeoutMs
            + ", topics=" + ((topics == null) ? "null" : MessageUtil.deepToString(topics.iterator()))
            + ")";
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public List<ListPartitionReassignmentsTopics> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ListPartitionReassignmentsRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public ListPartitionReassignmentsRequestData setTopics(List<ListPartitionReassignmentsTopics> v) {
        this.topics = v;
        return this;
    }
    
    public static class ListPartitionReassignmentsTopics implements Message {
        String name;
        List<Integer> partitionIndexes;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name"),
                new Field("partition_indexes", new CompactArrayOf(Type.INT32), "The partitions to list partition reassignments for."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public ListPartitionReassignmentsTopics(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ListPartitionReassignmentsTopics() {
            this.name = "";
            this.partitionIndexes = new ArrayList<Integer>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ListPartitionReassignmentsTopics");
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
            _writable.writeUnsignedVarint(partitionIndexes.size() + 1);
            for (Integer partitionIndexesElement : partitionIndexes) {
                _writable.writeInt(partitionIndexesElement);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ListPartitionReassignmentsTopics");
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
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionIndexes.size() + 1));
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
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListPartitionReassignmentsTopics)) return false;
            ListPartitionReassignmentsTopics other = (ListPartitionReassignmentsTopics) obj;
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
        public ListPartitionReassignmentsTopics duplicate() {
            ListPartitionReassignmentsTopics _duplicate = new ListPartitionReassignmentsTopics();
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
            return "ListPartitionReassignmentsTopics("
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
        
        public ListPartitionReassignmentsTopics setName(String v) {
            this.name = v;
            return this;
        }
        
        public ListPartitionReassignmentsTopics setPartitionIndexes(List<Integer> v) {
            this.partitionIndexes = v;
            return this;
        }
    }
}
