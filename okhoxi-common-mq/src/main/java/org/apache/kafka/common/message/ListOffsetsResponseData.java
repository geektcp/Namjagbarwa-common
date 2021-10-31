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


public class ListOffsetsResponseData implements ApiMessage {
    int throttleTimeMs;
    List<ListOffsetsTopicResponse> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(ListOffsetsTopicResponse.SCHEMA_0), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(ListOffsetsTopicResponse.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(ListOffsetsTopicResponse.SCHEMA_1), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new ArrayOf(ListOffsetsTopicResponse.SCHEMA_4), "Each topic in the response.")
        );
    
    public static final Schema SCHEMA_5 = SCHEMA_4;
    
    public static final Schema SCHEMA_6 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("topics", new CompactArrayOf(ListOffsetsTopicResponse.SCHEMA_6), "Each topic in the response."),
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
    
    public ListOffsetsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ListOffsetsResponseData() {
        this.throttleTimeMs = 0;
        this.topics = new ArrayList<ListOffsetsTopicResponse>(0);
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
        if (_version >= 2) {
            this.throttleTimeMs = _readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            if (_version >= 6) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<ListOffsetsTopicResponse> newCollection = new ArrayList<ListOffsetsTopicResponse>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ListOffsetsTopicResponse(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<ListOffsetsTopicResponse> newCollection = new ArrayList<ListOffsetsTopicResponse>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ListOffsetsTopicResponse(_readable, _version));
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
        if (_version >= 2) {
            _writable.writeInt(throttleTimeMs);
        }
        if (_version >= 6) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (ListOffsetsTopicResponse topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (ListOffsetsTopicResponse topicsElement : topics) {
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
        if (_version >= 2) {
            _size.addBytes(4);
        }
        {
            if (_version >= 6) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (ListOffsetsTopicResponse topicsElement : topics) {
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
        if (!(obj instanceof ListOffsetsResponseData)) return false;
        ListOffsetsResponseData other = (ListOffsetsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
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
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public ListOffsetsResponseData duplicate() {
        ListOffsetsResponseData _duplicate = new ListOffsetsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        ArrayList<ListOffsetsTopicResponse> newTopics = new ArrayList<ListOffsetsTopicResponse>(topics.size());
        for (ListOffsetsTopicResponse _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ListOffsetsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<ListOffsetsTopicResponse> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ListOffsetsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public ListOffsetsResponseData setTopics(List<ListOffsetsTopicResponse> v) {
        this.topics = v;
        return this;
    }
    
    public static class ListOffsetsTopicResponse implements Message {
        String name;
        List<ListOffsetsPartitionResponse> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetsPartitionResponse.SCHEMA_0), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetsPartitionResponse.SCHEMA_1), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.STRING, "The topic name"),
                new Field("partitions", new ArrayOf(ListOffsetsPartitionResponse.SCHEMA_4), "Each partition in the response.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name"),
                new Field("partitions", new CompactArrayOf(ListOffsetsPartitionResponse.SCHEMA_6), "Each partition in the response."),
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
        
        public ListOffsetsTopicResponse(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ListOffsetsTopicResponse() {
            this.name = "";
            this.partitions = new ArrayList<ListOffsetsPartitionResponse>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ListOffsetsTopicResponse");
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
                        ArrayList<ListOffsetsPartitionResponse> newCollection = new ArrayList<ListOffsetsPartitionResponse>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new ListOffsetsPartitionResponse(_readable, _version));
                        }
                        this.partitions = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<ListOffsetsPartitionResponse> newCollection = new ArrayList<ListOffsetsPartitionResponse>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new ListOffsetsPartitionResponse(_readable, _version));
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
                for (ListOffsetsPartitionResponse partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitions.size());
                for (ListOffsetsPartitionResponse partitionsElement : partitions) {
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ListOffsetsTopicResponse");
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
                for (ListOffsetsPartitionResponse partitionsElement : partitions) {
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
            if (!(obj instanceof ListOffsetsTopicResponse)) return false;
            ListOffsetsTopicResponse other = (ListOffsetsTopicResponse) obj;
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
        public ListOffsetsTopicResponse duplicate() {
            ListOffsetsTopicResponse _duplicate = new ListOffsetsTopicResponse();
            _duplicate.name = name;
            ArrayList<ListOffsetsPartitionResponse> newPartitions = new ArrayList<ListOffsetsPartitionResponse>(partitions.size());
            for (ListOffsetsPartitionResponse _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ListOffsetsTopicResponse("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<ListOffsetsPartitionResponse> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ListOffsetsTopicResponse setName(String v) {
            this.name = v;
            return this;
        }
        
        public ListOffsetsTopicResponse setPartitions(List<ListOffsetsPartitionResponse> v) {
            this.partitions = v;
            return this;
        }
    }
    
    public static class ListOffsetsPartitionResponse implements Message {
        int partitionIndex;
        short errorCode;
        List<Long> oldStyleOffsets;
        long timestamp;
        long offset;
        int leaderEpoch;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("old_style_offsets", new ArrayOf(Type.INT64), "The result offsets.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("timestamp", Type.INT64, "The timestamp associated with the returned offset."),
                new Field("offset", Type.INT64, "The returned offset.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("timestamp", Type.INT64, "The timestamp associated with the returned offset."),
                new Field("offset", Type.INT64, "The returned offset."),
                new Field("leader_epoch", Type.INT32, "")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 =
            new Schema(
                new Field("partition_index", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The partition error code, or 0 if there was no error."),
                new Field("timestamp", Type.INT64, "The timestamp associated with the returned offset."),
                new Field("offset", Type.INT64, "The returned offset."),
                new Field("leader_epoch", Type.INT32, ""),
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
        
        public ListOffsetsPartitionResponse(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ListOffsetsPartitionResponse() {
            this.partitionIndex = 0;
            this.errorCode = (short) 0;
            this.oldStyleOffsets = new ArrayList<Long>(0);
            this.timestamp = -1L;
            this.offset = -1L;
            this.leaderEpoch = -1;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ListOffsetsPartitionResponse");
            }
            this.partitionIndex = _readable.readInt();
            this.errorCode = _readable.readShort();
            if (_version <= 0) {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field oldStyleOffsets was serialized as null");
                } else {
                    ArrayList<Long> newCollection = new ArrayList<Long>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readLong());
                    }
                    this.oldStyleOffsets = newCollection;
                }
            } else {
                this.oldStyleOffsets = new ArrayList<Long>(0);
            }
            if (_version >= 1) {
                this.timestamp = _readable.readLong();
            } else {
                this.timestamp = -1L;
            }
            if (_version >= 1) {
                this.offset = _readable.readLong();
            } else {
                this.offset = -1L;
            }
            if (_version >= 4) {
                this.leaderEpoch = _readable.readInt();
            } else {
                this.leaderEpoch = -1;
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
            _writable.writeShort(errorCode);
            if (_version <= 0) {
                _writable.writeInt(oldStyleOffsets.size());
                for (Long oldStyleOffsetsElement : oldStyleOffsets) {
                    _writable.writeLong(oldStyleOffsetsElement);
                }
            } else {
                if (!this.oldStyleOffsets.isEmpty()) {
                    throw new UnsupportedVersionException("Attempted to write a non-default oldStyleOffsets at version " + _version);
                }
            }
            if (_version >= 1) {
                _writable.writeLong(timestamp);
            } else {
                if (this.timestamp != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default timestamp at version " + _version);
                }
            }
            if (_version >= 1) {
                _writable.writeLong(offset);
            } else {
                if (this.offset != -1L) {
                    throw new UnsupportedVersionException("Attempted to write a non-default offset at version " + _version);
                }
            }
            if (_version >= 4) {
                _writable.writeInt(leaderEpoch);
            } else {
                if (this.leaderEpoch != -1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default leaderEpoch at version " + _version);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ListOffsetsPartitionResponse");
            }
            _size.addBytes(4);
            _size.addBytes(2);
            if (_version <= 0) {
                {
                    _size.addBytes(4);
                    _size.addBytes(oldStyleOffsets.size() * 8);
                }
            }
            if (_version >= 1) {
                _size.addBytes(8);
            }
            if (_version >= 1) {
                _size.addBytes(8);
            }
            if (_version >= 4) {
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
            if (!(obj instanceof ListOffsetsPartitionResponse)) return false;
            ListOffsetsPartitionResponse other = (ListOffsetsPartitionResponse) obj;
            if (partitionIndex != other.partitionIndex) return false;
            if (errorCode != other.errorCode) return false;
            if (this.oldStyleOffsets == null) {
                if (other.oldStyleOffsets != null) return false;
            } else {
                if (!this.oldStyleOffsets.equals(other.oldStyleOffsets)) return false;
            }
            if (timestamp != other.timestamp) return false;
            if (offset != other.offset) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partitionIndex;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (oldStyleOffsets == null ? 0 : oldStyleOffsets.hashCode());
            hashCode = 31 * hashCode + ((int) (timestamp >> 32) ^ (int) timestamp);
            hashCode = 31 * hashCode + ((int) (offset >> 32) ^ (int) offset);
            hashCode = 31 * hashCode + leaderEpoch;
            return hashCode;
        }
        
        @Override
        public ListOffsetsPartitionResponse duplicate() {
            ListOffsetsPartitionResponse _duplicate = new ListOffsetsPartitionResponse();
            _duplicate.partitionIndex = partitionIndex;
            _duplicate.errorCode = errorCode;
            ArrayList<Long> newOldStyleOffsets = new ArrayList<Long>(oldStyleOffsets.size());
            for (Long _element : oldStyleOffsets) {
                newOldStyleOffsets.add(_element);
            }
            _duplicate.oldStyleOffsets = newOldStyleOffsets;
            _duplicate.timestamp = timestamp;
            _duplicate.offset = offset;
            _duplicate.leaderEpoch = leaderEpoch;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ListOffsetsPartitionResponse("
                + "partitionIndex=" + partitionIndex
                + ", errorCode=" + errorCode
                + ", oldStyleOffsets=" + MessageUtil.deepToString(oldStyleOffsets.iterator())
                + ", timestamp=" + timestamp
                + ", offset=" + offset
                + ", leaderEpoch=" + leaderEpoch
                + ")";
        }
        
        public int partitionIndex() {
            return this.partitionIndex;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public List<Long> oldStyleOffsets() {
            return this.oldStyleOffsets;
        }
        
        public long timestamp() {
            return this.timestamp;
        }
        
        public long offset() {
            return this.offset;
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
        
        public ListOffsetsPartitionResponse setPartitionIndex(int v) {
            this.partitionIndex = v;
            return this;
        }
        
        public ListOffsetsPartitionResponse setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public ListOffsetsPartitionResponse setOldStyleOffsets(List<Long> v) {
            this.oldStyleOffsets = v;
            return this;
        }
        
        public ListOffsetsPartitionResponse setTimestamp(long v) {
            this.timestamp = v;
            return this;
        }
        
        public ListOffsetsPartitionResponse setOffset(long v) {
            this.offset = v;
            return this;
        }
        
        public ListOffsetsPartitionResponse setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
    }
}
