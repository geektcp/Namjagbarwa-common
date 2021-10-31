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
import java.util.Objects;
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
import org.apache.kafka.common.record.BaseRecords;
import org.apache.kafka.common.record.MemoryRecords;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class FetchResponseData implements ApiMessage {
    int throttleTimeMs;
    short errorCode;
    int sessionId;
    List<FetchableTopicResponse> responses;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_0), "The response topics.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_0), "The response topics.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 = SCHEMA_2;
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_4), "The response topics.")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_5), "The response topics.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top level response error code."),
            new Field("session_id", Type.INT32, "The fetch session ID, or 0 if this is not part of a fetch session."),
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_5), "The response topics.")
        );
    
    public static final Schema SCHEMA_8 = SCHEMA_7;
    
    public static final Schema SCHEMA_9 = SCHEMA_8;
    
    public static final Schema SCHEMA_10 = SCHEMA_9;
    
    public static final Schema SCHEMA_11 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top level response error code."),
            new Field("session_id", Type.INT32, "The fetch session ID, or 0 if this is not part of a fetch session."),
            new Field("responses", new ArrayOf(FetchableTopicResponse.SCHEMA_11), "The response topics.")
        );
    
    public static final Schema SCHEMA_12 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top level response error code."),
            new Field("session_id", Type.INT32, "The fetch session ID, or 0 if this is not part of a fetch session."),
            new Field("responses", new CompactArrayOf(FetchableTopicResponse.SCHEMA_12), "The response topics."),
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
        SCHEMA_7,
        SCHEMA_8,
        SCHEMA_9,
        SCHEMA_10,
        SCHEMA_11,
        SCHEMA_12
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 12;
    
    public FetchResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public FetchResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.sessionId = 0;
        this.responses = new ArrayList<FetchableTopicResponse>(0);
    }
    
    @Override
    public short apiKey() {
        return 1;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 12;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 1) {
            this.throttleTimeMs = _readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        if (_version >= 7) {
            this.errorCode = _readable.readShort();
        } else {
            this.errorCode = (short) 0;
        }
        if (_version >= 7) {
            this.sessionId = _readable.readInt();
        } else {
            this.sessionId = 0;
        }
        {
            if (_version >= 12) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field responses was serialized as null");
                } else {
                    ArrayList<FetchableTopicResponse> newCollection = new ArrayList<FetchableTopicResponse>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new FetchableTopicResponse(_readable, _version));
                    }
                    this.responses = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field responses was serialized as null");
                } else {
                    ArrayList<FetchableTopicResponse> newCollection = new ArrayList<FetchableTopicResponse>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new FetchableTopicResponse(_readable, _version));
                    }
                    this.responses = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 12) {
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
            _writable.writeInt(throttleTimeMs);
        }
        if (_version >= 7) {
            _writable.writeShort(errorCode);
        }
        if (_version >= 7) {
            _writable.writeInt(sessionId);
        } else {
            if (this.sessionId != 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default sessionId at version " + _version);
            }
        }
        if (_version >= 12) {
            _writable.writeUnsignedVarint(responses.size() + 1);
            for (FetchableTopicResponse responsesElement : responses) {
                responsesElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(responses.size());
            for (FetchableTopicResponse responsesElement : responses) {
                responsesElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 12) {
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
            _size.addBytes(4);
        }
        if (_version >= 7) {
            _size.addBytes(2);
        }
        if (_version >= 7) {
            _size.addBytes(4);
        }
        {
            if (_version >= 12) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(responses.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (FetchableTopicResponse responsesElement : responses) {
                responsesElement.addSize(_size, _cache, _version);
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
        if (_version >= 12) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FetchResponseData)) return false;
        FetchResponseData other = (FetchResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (sessionId != other.sessionId) return false;
        if (this.responses == null) {
            if (other.responses != null) return false;
        } else {
            if (!this.responses.equals(other.responses)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + sessionId;
        hashCode = 31 * hashCode + (responses == null ? 0 : responses.hashCode());
        return hashCode;
    }
    
    @Override
    public FetchResponseData duplicate() {
        FetchResponseData _duplicate = new FetchResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        _duplicate.errorCode = errorCode;
        _duplicate.sessionId = sessionId;
        ArrayList<FetchableTopicResponse> newResponses = new ArrayList<FetchableTopicResponse>(responses.size());
        for (FetchableTopicResponse _element : responses) {
            newResponses.add(_element.duplicate());
        }
        _duplicate.responses = newResponses;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "FetchResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", sessionId=" + sessionId
            + ", responses=" + MessageUtil.deepToString(responses.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public int sessionId() {
        return this.sessionId;
    }
    
    public List<FetchableTopicResponse> responses() {
        return this.responses;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public FetchResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public FetchResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public FetchResponseData setSessionId(int v) {
        this.sessionId = v;
        return this;
    }
    
    public FetchResponseData setResponses(List<FetchableTopicResponse> v) {
        this.responses = v;
        return this;
    }
    
    public static class FetchableTopicResponse implements Message {
        String topic;
        List<FetchablePartitionResponse> partitionResponses;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partition_responses", new ArrayOf(FetchablePartitionResponse.SCHEMA_0), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partition_responses", new ArrayOf(FetchablePartitionResponse.SCHEMA_4), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partition_responses", new ArrayOf(FetchablePartitionResponse.SCHEMA_5), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 =
            new Schema(
                new Field("topic", Type.STRING, "The topic name."),
                new Field("partition_responses", new ArrayOf(FetchablePartitionResponse.SCHEMA_11), "The topic partitions.")
            );
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("topic", Type.COMPACT_STRING, "The topic name."),
                new Field("partition_responses", new CompactArrayOf(FetchablePartitionResponse.SCHEMA_12), "The topic partitions."),
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
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10,
            SCHEMA_11,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public FetchableTopicResponse(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public FetchableTopicResponse() {
            this.topic = "";
            this.partitionResponses = new ArrayList<FetchablePartitionResponse>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of FetchableTopicResponse");
            }
            {
                int length;
                if (_version >= 12) {
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
                if (_version >= 12) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitionResponses was serialized as null");
                    } else {
                        ArrayList<FetchablePartitionResponse> newCollection = new ArrayList<FetchablePartitionResponse>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new FetchablePartitionResponse(_readable, _version));
                        }
                        this.partitionResponses = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitionResponses was serialized as null");
                    } else {
                        ArrayList<FetchablePartitionResponse> newCollection = new ArrayList<FetchablePartitionResponse>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new FetchablePartitionResponse(_readable, _version));
                        }
                        this.partitionResponses = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 12) {
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
                if (_version >= 12) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 12) {
                _writable.writeUnsignedVarint(partitionResponses.size() + 1);
                for (FetchablePartitionResponse partitionResponsesElement : partitionResponses) {
                    partitionResponsesElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitionResponses.size());
                for (FetchablePartitionResponse partitionResponsesElement : partitionResponses) {
                    partitionResponsesElement.write(_writable, _cache, _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 12) {
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
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of FetchableTopicResponse");
            }
            {
                byte[] _stringBytes = topic.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topic' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topic, _stringBytes);
                if (_version >= 12) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 12) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitionResponses.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (FetchablePartitionResponse partitionResponsesElement : partitionResponses) {
                    partitionResponsesElement.addSize(_size, _cache, _version);
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
            if (_version >= 12) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchableTopicResponse)) return false;
            FetchableTopicResponse other = (FetchableTopicResponse) obj;
            if (this.topic == null) {
                if (other.topic != null) return false;
            } else {
                if (!this.topic.equals(other.topic)) return false;
            }
            if (this.partitionResponses == null) {
                if (other.partitionResponses != null) return false;
            } else {
                if (!this.partitionResponses.equals(other.partitionResponses)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (topic == null ? 0 : topic.hashCode());
            hashCode = 31 * hashCode + (partitionResponses == null ? 0 : partitionResponses.hashCode());
            return hashCode;
        }
        
        @Override
        public FetchableTopicResponse duplicate() {
            FetchableTopicResponse _duplicate = new FetchableTopicResponse();
            _duplicate.topic = topic;
            ArrayList<FetchablePartitionResponse> newPartitionResponses = new ArrayList<FetchablePartitionResponse>(partitionResponses.size());
            for (FetchablePartitionResponse _element : partitionResponses) {
                newPartitionResponses.add(_element.duplicate());
            }
            _duplicate.partitionResponses = newPartitionResponses;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "FetchableTopicResponse("
                + "topic=" + ((topic == null) ? "null" : "'" + topic.toString() + "'")
                + ", partitionResponses=" + MessageUtil.deepToString(partitionResponses.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<FetchablePartitionResponse> partitionResponses() {
            return this.partitionResponses;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public FetchableTopicResponse setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public FetchableTopicResponse setPartitionResponses(List<FetchablePartitionResponse> v) {
            this.partitionResponses = v;
            return this;
        }
    }
    
    public static class FetchablePartitionResponse implements Message {
        int partition;
        short errorCode;
        long highWatermark;
        long lastStableOffset;
        long logStartOffset;
        EpochEndOffset divergingEpoch;
        LeaderIdAndEpoch currentLeader;
        SnapshotId snapshotId;
        List<AbortedTransaction> abortedTransactions;
        int preferredReadReplica;
        BaseRecords recordSet;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("record_set", Type.RECORDS, "The record data.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("aborted_transactions", ArrayOf.nullable(AbortedTransaction.SCHEMA_4), "The aborted transactions."),
                new Field("record_set", Type.RECORDS, "The record data.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("log_start_offset", Type.INT64, "The current log start offset."),
                new Field("aborted_transactions", ArrayOf.nullable(AbortedTransaction.SCHEMA_4), "The aborted transactions."),
                new Field("record_set", Type.RECORDS, "The record data.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("log_start_offset", Type.INT64, "The current log start offset."),
                new Field("aborted_transactions", ArrayOf.nullable(AbortedTransaction.SCHEMA_4), "The aborted transactions."),
                new Field("preferred_read_replica", Type.INT32, "The preferred read replica for the consumer to use on its next fetch request"),
                new Field("record_set", Type.RECORDS, "The record data.")
            );
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("error_code", Type.INT16, "The error code, or 0 if there was no fetch error."),
                new Field("high_watermark", Type.INT64, "The current high water mark."),
                new Field("last_stable_offset", Type.INT64, "The last stable offset (or LSO) of the partition. This is the last offset such that the state of all transactional records prior to this offset have been decided (ABORTED or COMMITTED)"),
                new Field("log_start_offset", Type.INT64, "The current log start offset."),
                new Field("aborted_transactions", CompactArrayOf.nullable(AbortedTransaction.SCHEMA_12), "The aborted transactions."),
                new Field("preferred_read_replica", Type.INT32, "The preferred read replica for the consumer to use on its next fetch request"),
                new Field("record_set", Type.COMPACT_RECORDS, "The record data."),
                TaggedFieldsSection.of(
                    0, new Field("diverging_epoch", EpochEndOffset.SCHEMA_12, "In case divergence is detected based on the `LastFetchedEpoch` and `FetchOffset` in the request, this field indicates the largest epoch and its end offset such that subsequent records are known to diverge"),
                    1, new Field("current_leader", LeaderIdAndEpoch.SCHEMA_12, ""),
                    2, new Field("snapshot_id", SnapshotId.SCHEMA_12, "In the case of fetching an offset less than the LogStartOffset, this is the end offset and epoch that should be used in the FetchSnapshot request.")
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
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10,
            SCHEMA_11,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public FetchablePartitionResponse(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public FetchablePartitionResponse() {
            this.partition = 0;
            this.errorCode = (short) 0;
            this.highWatermark = 0L;
            this.lastStableOffset = -1L;
            this.logStartOffset = -1L;
            this.divergingEpoch = new EpochEndOffset();
            this.currentLeader = new LeaderIdAndEpoch();
            this.snapshotId = new SnapshotId();
            this.abortedTransactions = new ArrayList<AbortedTransaction>(0);
            this.preferredReadReplica = -1;
            this.recordSet = null;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of FetchablePartitionResponse");
            }
            this.partition = _readable.readInt();
            this.errorCode = _readable.readShort();
            this.highWatermark = _readable.readLong();
            if (_version >= 4) {
                this.lastStableOffset = _readable.readLong();
            } else {
                this.lastStableOffset = -1L;
            }
            if (_version >= 5) {
                this.logStartOffset = _readable.readLong();
            } else {
                this.logStartOffset = -1L;
            }
            {
                this.divergingEpoch = new EpochEndOffset();
            }
            {
                this.currentLeader = new LeaderIdAndEpoch();
            }
            {
                this.snapshotId = new SnapshotId();
            }
            if (_version >= 4) {
                if (_version >= 12) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        this.abortedTransactions = null;
                    } else {
                        ArrayList<AbortedTransaction> newCollection = new ArrayList<AbortedTransaction>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new AbortedTransaction(_readable, _version));
                        }
                        this.abortedTransactions = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        this.abortedTransactions = null;
                    } else {
                        ArrayList<AbortedTransaction> newCollection = new ArrayList<AbortedTransaction>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new AbortedTransaction(_readable, _version));
                        }
                        this.abortedTransactions = newCollection;
                    }
                }
            } else {
                this.abortedTransactions = new ArrayList<AbortedTransaction>(0);
            }
            if (_version >= 11) {
                this.preferredReadReplica = _readable.readInt();
            } else {
                this.preferredReadReplica = -1;
            }
            {
                int length;
                if (_version >= 12) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readInt();
                }
                if (length < 0) {
                    this.recordSet = null;
                } else {
                    this.recordSet = _readable.readRecords(length);
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 12) {
                int _numTaggedFields = _readable.readUnsignedVarint();
                for (int _i = 0; _i < _numTaggedFields; _i++) {
                    int _tag = _readable.readUnsignedVarint();
                    int _size = _readable.readUnsignedVarint();
                    switch (_tag) {
                        case 0: {
                            this.divergingEpoch = new EpochEndOffset(_readable, _version);
                            break;
                        }
                        case 1: {
                            this.currentLeader = new LeaderIdAndEpoch(_readable, _version);
                            break;
                        }
                        case 2: {
                            this.snapshotId = new SnapshotId(_readable, _version);
                            break;
                        }
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
            _writable.writeShort(errorCode);
            _writable.writeLong(highWatermark);
            if (_version >= 4) {
                _writable.writeLong(lastStableOffset);
            }
            if (_version >= 5) {
                _writable.writeLong(logStartOffset);
            }
            if (_version >= 12) {
                if (!this.divergingEpoch.equals(new EpochEndOffset())) {
                    _numTaggedFields++;
                }
            } else {
                if (!this.divergingEpoch.equals(new EpochEndOffset())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default divergingEpoch at version " + _version);
                }
            }
            if (_version >= 12) {
                if (!this.currentLeader.equals(new LeaderIdAndEpoch())) {
                    _numTaggedFields++;
                }
            } else {
                if (!this.currentLeader.equals(new LeaderIdAndEpoch())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default currentLeader at version " + _version);
                }
            }
            if (_version >= 12) {
                if (!this.snapshotId.equals(new SnapshotId())) {
                    _numTaggedFields++;
                }
            } else {
                if (!this.snapshotId.equals(new SnapshotId())) {
                    throw new UnsupportedVersionException("Attempted to write a non-default snapshotId at version " + _version);
                }
            }
            if (_version >= 4) {
                if (_version >= 12) {
                    if (abortedTransactions == null) {
                        _writable.writeUnsignedVarint(0);
                    } else {
                        _writable.writeUnsignedVarint(abortedTransactions.size() + 1);
                        for (AbortedTransaction abortedTransactionsElement : abortedTransactions) {
                            abortedTransactionsElement.write(_writable, _cache, _version);
                        }
                    }
                } else {
                    if (abortedTransactions == null) {
                        _writable.writeInt(-1);
                    } else {
                        _writable.writeInt(abortedTransactions.size());
                        for (AbortedTransaction abortedTransactionsElement : abortedTransactions) {
                            abortedTransactionsElement.write(_writable, _cache, _version);
                        }
                    }
                }
            }
            if (_version >= 11) {
                _writable.writeInt(preferredReadReplica);
            } else {
                if (this.preferredReadReplica != -1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default preferredReadReplica at version " + _version);
                }
            }
            if (recordSet == null) {
                if (_version >= 12) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeInt(-1);
                }
            } else {
                if (_version >= 12) {
                    _writable.writeUnsignedVarint(recordSet.sizeInBytes() + 1);
                } else {
                    _writable.writeInt(recordSet.sizeInBytes());
                }
                _writable.writeRecords(recordSet);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 12) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                {
                    if (!this.divergingEpoch.equals(new EpochEndOffset())) {
                        _writable.writeUnsignedVarint(0);
                        _writable.writeUnsignedVarint(this.divergingEpoch.size(_cache, _version));
                        divergingEpoch.write(_writable, _cache, _version);
                    }
                }
                {
                    if (!this.currentLeader.equals(new LeaderIdAndEpoch())) {
                        _writable.writeUnsignedVarint(1);
                        _writable.writeUnsignedVarint(this.currentLeader.size(_cache, _version));
                        currentLeader.write(_writable, _cache, _version);
                    }
                }
                {
                    if (!this.snapshotId.equals(new SnapshotId())) {
                        _writable.writeUnsignedVarint(2);
                        _writable.writeUnsignedVarint(this.snapshotId.size(_cache, _version));
                        snapshotId.write(_writable, _cache, _version);
                    }
                }
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
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of FetchablePartitionResponse");
            }
            _size.addBytes(4);
            _size.addBytes(2);
            _size.addBytes(8);
            if (_version >= 4) {
                _size.addBytes(8);
            }
            if (_version >= 5) {
                _size.addBytes(8);
            }
            if (_version >= 12) {
                {
                    if (!this.divergingEpoch.equals(new EpochEndOffset())) {
                        _numTaggedFields++;
                        _size.addBytes(1);
                        int _sizeBeforeStruct = _size.totalSize();
                        this.divergingEpoch.addSize(_size, _cache, _version);
                        int _structSize = _size.totalSize() - _sizeBeforeStruct;
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_structSize));
                    }
                }
            }
            if (_version >= 12) {
                {
                    if (!this.currentLeader.equals(new LeaderIdAndEpoch())) {
                        _numTaggedFields++;
                        _size.addBytes(1);
                        int _sizeBeforeStruct = _size.totalSize();
                        this.currentLeader.addSize(_size, _cache, _version);
                        int _structSize = _size.totalSize() - _sizeBeforeStruct;
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_structSize));
                    }
                }
            }
            if (_version >= 12) {
                {
                    if (!this.snapshotId.equals(new SnapshotId())) {
                        _numTaggedFields++;
                        _size.addBytes(1);
                        int _sizeBeforeStruct = _size.totalSize();
                        this.snapshotId.addSize(_size, _cache, _version);
                        int _structSize = _size.totalSize() - _sizeBeforeStruct;
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_structSize));
                    }
                }
            }
            if (_version >= 4) {
                if (abortedTransactions == null) {
                    if (_version >= 12) {
                        _size.addBytes(1);
                    } else {
                        _size.addBytes(4);
                    }
                } else {
                    if (_version >= 12) {
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(abortedTransactions.size() + 1));
                    } else {
                        _size.addBytes(4);
                    }
                    for (AbortedTransaction abortedTransactionsElement : abortedTransactions) {
                        abortedTransactionsElement.addSize(_size, _cache, _version);
                    }
                }
            }
            if (_version >= 11) {
                _size.addBytes(4);
            }
            if (recordSet == null) {
                if (_version >= 12) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(4);
                }
            } else {
                _size.addZeroCopyBytes(recordSet.sizeInBytes());
                if (_version >= 12) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(recordSet.sizeInBytes() + 1));
                } else {
                    _size.addBytes(4);
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
            if (_version >= 12) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FetchablePartitionResponse)) return false;
            FetchablePartitionResponse other = (FetchablePartitionResponse) obj;
            if (partition != other.partition) return false;
            if (errorCode != other.errorCode) return false;
            if (highWatermark != other.highWatermark) return false;
            if (lastStableOffset != other.lastStableOffset) return false;
            if (logStartOffset != other.logStartOffset) return false;
            if (this.divergingEpoch == null) {
                if (other.divergingEpoch != null) return false;
            } else {
                if (!this.divergingEpoch.equals(other.divergingEpoch)) return false;
            }
            if (this.currentLeader == null) {
                if (other.currentLeader != null) return false;
            } else {
                if (!this.currentLeader.equals(other.currentLeader)) return false;
            }
            if (this.snapshotId == null) {
                if (other.snapshotId != null) return false;
            } else {
                if (!this.snapshotId.equals(other.snapshotId)) return false;
            }
            if (this.abortedTransactions == null) {
                if (other.abortedTransactions != null) return false;
            } else {
                if (!this.abortedTransactions.equals(other.abortedTransactions)) return false;
            }
            if (preferredReadReplica != other.preferredReadReplica) return false;
            if (!Objects.equals(this.recordSet, other.recordSet)) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partition;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + ((int) (highWatermark >> 32) ^ (int) highWatermark);
            hashCode = 31 * hashCode + ((int) (lastStableOffset >> 32) ^ (int) lastStableOffset);
            hashCode = 31 * hashCode + ((int) (logStartOffset >> 32) ^ (int) logStartOffset);
            hashCode = 31 * hashCode + (divergingEpoch == null ? 0 : divergingEpoch.hashCode());
            hashCode = 31 * hashCode + (currentLeader == null ? 0 : currentLeader.hashCode());
            hashCode = 31 * hashCode + (snapshotId == null ? 0 : snapshotId.hashCode());
            hashCode = 31 * hashCode + (abortedTransactions == null ? 0 : abortedTransactions.hashCode());
            hashCode = 31 * hashCode + preferredReadReplica;
            hashCode = 31 * hashCode + Objects.hashCode(recordSet);
            return hashCode;
        }
        
        @Override
        public FetchablePartitionResponse duplicate() {
            FetchablePartitionResponse _duplicate = new FetchablePartitionResponse();
            _duplicate.partition = partition;
            _duplicate.errorCode = errorCode;
            _duplicate.highWatermark = highWatermark;
            _duplicate.lastStableOffset = lastStableOffset;
            _duplicate.logStartOffset = logStartOffset;
            _duplicate.divergingEpoch = divergingEpoch.duplicate();
            _duplicate.currentLeader = currentLeader.duplicate();
            _duplicate.snapshotId = snapshotId.duplicate();
            if (abortedTransactions == null) {
                _duplicate.abortedTransactions = null;
            } else {
                ArrayList<AbortedTransaction> newAbortedTransactions = new ArrayList<AbortedTransaction>(abortedTransactions.size());
                for (AbortedTransaction _element : abortedTransactions) {
                    newAbortedTransactions.add(_element.duplicate());
                }
                _duplicate.abortedTransactions = newAbortedTransactions;
            }
            _duplicate.preferredReadReplica = preferredReadReplica;
            if (recordSet == null) {
                _duplicate.recordSet = null;
            } else {
                _duplicate.recordSet = MemoryRecords.readableRecords(((MemoryRecords) recordSet).buffer().duplicate());
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "FetchablePartitionResponse("
                + "partition=" + partition
                + ", errorCode=" + errorCode
                + ", highWatermark=" + highWatermark
                + ", lastStableOffset=" + lastStableOffset
                + ", logStartOffset=" + logStartOffset
                + ", divergingEpoch=" + divergingEpoch.toString()
                + ", currentLeader=" + currentLeader.toString()
                + ", snapshotId=" + snapshotId.toString()
                + ", abortedTransactions=" + ((abortedTransactions == null) ? "null" : MessageUtil.deepToString(abortedTransactions.iterator()))
                + ", preferredReadReplica=" + preferredReadReplica
                + ", recordSet=" + recordSet
                + ")";
        }
        
        public int partition() {
            return this.partition;
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public long highWatermark() {
            return this.highWatermark;
        }
        
        public long lastStableOffset() {
            return this.lastStableOffset;
        }
        
        public long logStartOffset() {
            return this.logStartOffset;
        }
        
        public EpochEndOffset divergingEpoch() {
            return this.divergingEpoch;
        }
        
        public LeaderIdAndEpoch currentLeader() {
            return this.currentLeader;
        }
        
        public SnapshotId snapshotId() {
            return this.snapshotId;
        }
        
        public List<AbortedTransaction> abortedTransactions() {
            return this.abortedTransactions;
        }
        
        public int preferredReadReplica() {
            return this.preferredReadReplica;
        }
        
        public BaseRecords recordSet() {
            return this.recordSet;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public FetchablePartitionResponse setPartition(int v) {
            this.partition = v;
            return this;
        }
        
        public FetchablePartitionResponse setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public FetchablePartitionResponse setHighWatermark(long v) {
            this.highWatermark = v;
            return this;
        }
        
        public FetchablePartitionResponse setLastStableOffset(long v) {
            this.lastStableOffset = v;
            return this;
        }
        
        public FetchablePartitionResponse setLogStartOffset(long v) {
            this.logStartOffset = v;
            return this;
        }
        
        public FetchablePartitionResponse setDivergingEpoch(EpochEndOffset v) {
            this.divergingEpoch = v;
            return this;
        }
        
        public FetchablePartitionResponse setCurrentLeader(LeaderIdAndEpoch v) {
            this.currentLeader = v;
            return this;
        }
        
        public FetchablePartitionResponse setSnapshotId(SnapshotId v) {
            this.snapshotId = v;
            return this;
        }
        
        public FetchablePartitionResponse setAbortedTransactions(List<AbortedTransaction> v) {
            this.abortedTransactions = v;
            return this;
        }
        
        public FetchablePartitionResponse setPreferredReadReplica(int v) {
            this.preferredReadReplica = v;
            return this;
        }
        
        public FetchablePartitionResponse setRecordSet(BaseRecords v) {
            this.recordSet = v;
            return this;
        }
    }
    
    public static class EpochEndOffset implements Message {
        int epoch;
        long endOffset;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("epoch", Type.INT32, ""),
                new Field("end_offset", Type.INT64, ""),
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
            null,
            null,
            null,
            null,
            null,
            null,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 12;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public EpochEndOffset(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public EpochEndOffset() {
            this.epoch = -1;
            this.endOffset = -1L;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of EpochEndOffset");
            }
            this.epoch = _readable.readInt();
            this.endOffset = _readable.readLong();
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
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of EpochEndOffset");
            }
            int _numTaggedFields = 0;
            _writable.writeInt(epoch);
            _writable.writeLong(endOffset);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of EpochEndOffset");
            }
            _size.addBytes(4);
            _size.addBytes(8);
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
            if (!(obj instanceof EpochEndOffset)) return false;
            EpochEndOffset other = (EpochEndOffset) obj;
            if (epoch != other.epoch) return false;
            if (endOffset != other.endOffset) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + epoch;
            hashCode = 31 * hashCode + ((int) (endOffset >> 32) ^ (int) endOffset);
            return hashCode;
        }
        
        @Override
        public EpochEndOffset duplicate() {
            EpochEndOffset _duplicate = new EpochEndOffset();
            _duplicate.epoch = epoch;
            _duplicate.endOffset = endOffset;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "EpochEndOffset("
                + "epoch=" + epoch
                + ", endOffset=" + endOffset
                + ")";
        }
        
        public int epoch() {
            return this.epoch;
        }
        
        public long endOffset() {
            return this.endOffset;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public EpochEndOffset setEpoch(int v) {
            this.epoch = v;
            return this;
        }
        
        public EpochEndOffset setEndOffset(long v) {
            this.endOffset = v;
            return this;
        }
    }
    
    public static class LeaderIdAndEpoch implements Message {
        int leaderId;
        int leaderEpoch;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("leader_id", Type.INT32, "The ID of the current leader or -1 if the leader is unknown."),
                new Field("leader_epoch", Type.INT32, "The latest known leader epoch"),
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
            null,
            null,
            null,
            null,
            null,
            null,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 12;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public LeaderIdAndEpoch(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public LeaderIdAndEpoch() {
            this.leaderId = -1;
            this.leaderEpoch = -1;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of LeaderIdAndEpoch");
            }
            this.leaderId = _readable.readInt();
            this.leaderEpoch = _readable.readInt();
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
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of LeaderIdAndEpoch");
            }
            int _numTaggedFields = 0;
            _writable.writeInt(leaderId);
            _writable.writeInt(leaderEpoch);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of LeaderIdAndEpoch");
            }
            _size.addBytes(4);
            _size.addBytes(4);
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
            if (!(obj instanceof LeaderIdAndEpoch)) return false;
            LeaderIdAndEpoch other = (LeaderIdAndEpoch) obj;
            if (leaderId != other.leaderId) return false;
            if (leaderEpoch != other.leaderEpoch) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + leaderId;
            hashCode = 31 * hashCode + leaderEpoch;
            return hashCode;
        }
        
        @Override
        public LeaderIdAndEpoch duplicate() {
            LeaderIdAndEpoch _duplicate = new LeaderIdAndEpoch();
            _duplicate.leaderId = leaderId;
            _duplicate.leaderEpoch = leaderEpoch;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "LeaderIdAndEpoch("
                + "leaderId=" + leaderId
                + ", leaderEpoch=" + leaderEpoch
                + ")";
        }
        
        public int leaderId() {
            return this.leaderId;
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
        
        public LeaderIdAndEpoch setLeaderId(int v) {
            this.leaderId = v;
            return this;
        }
        
        public LeaderIdAndEpoch setLeaderEpoch(int v) {
            this.leaderEpoch = v;
            return this;
        }
    }
    
    public static class SnapshotId implements Message {
        long endOffset;
        int epoch;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("end_offset", Type.INT64, ""),
                new Field("epoch", Type.INT32, ""),
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
            null,
            null,
            null,
            null,
            null,
            null,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 12;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public SnapshotId(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public SnapshotId() {
            this.endOffset = -1L;
            this.epoch = -1;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of SnapshotId");
            }
            this.endOffset = _readable.readLong();
            this.epoch = _readable.readInt();
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
            if (_version < 12) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of SnapshotId");
            }
            int _numTaggedFields = 0;
            _writable.writeLong(endOffset);
            _writable.writeInt(epoch);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of SnapshotId");
            }
            _size.addBytes(8);
            _size.addBytes(4);
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
            if (!(obj instanceof SnapshotId)) return false;
            SnapshotId other = (SnapshotId) obj;
            if (endOffset != other.endOffset) return false;
            if (epoch != other.epoch) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + ((int) (endOffset >> 32) ^ (int) endOffset);
            hashCode = 31 * hashCode + epoch;
            return hashCode;
        }
        
        @Override
        public SnapshotId duplicate() {
            SnapshotId _duplicate = new SnapshotId();
            _duplicate.endOffset = endOffset;
            _duplicate.epoch = epoch;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "SnapshotId("
                + "endOffset=" + endOffset
                + ", epoch=" + epoch
                + ")";
        }
        
        public long endOffset() {
            return this.endOffset;
        }
        
        public int epoch() {
            return this.epoch;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public SnapshotId setEndOffset(long v) {
            this.endOffset = v;
            return this;
        }
        
        public SnapshotId setEpoch(int v) {
            this.epoch = v;
            return this;
        }
    }
    
    public static class AbortedTransaction implements Message {
        long producerId;
        long firstOffset;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("producer_id", Type.INT64, "The producer id associated with the aborted transaction."),
                new Field("first_offset", Type.INT64, "The first offset in the aborted transaction.")
            );
        
        public static final Schema SCHEMA_5 = SCHEMA_4;
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 = SCHEMA_10;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("producer_id", Type.INT64, "The producer id associated with the aborted transaction."),
                new Field("first_offset", Type.INT64, "The first offset in the aborted transaction."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            null,
            null,
            null,
            SCHEMA_4,
            SCHEMA_5,
            SCHEMA_6,
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10,
            SCHEMA_11,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 4;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public AbortedTransaction(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public AbortedTransaction() {
            this.producerId = 0L;
            this.firstOffset = 0L;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 12;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of AbortedTransaction");
            }
            this.producerId = _readable.readLong();
            this.firstOffset = _readable.readLong();
            this._unknownTaggedFields = null;
            if (_version >= 12) {
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
            if (_version < 4) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of AbortedTransaction");
            }
            int _numTaggedFields = 0;
            _writable.writeLong(producerId);
            _writable.writeLong(firstOffset);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 12) {
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
            if (_version > 12) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of AbortedTransaction");
            }
            _size.addBytes(8);
            _size.addBytes(8);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 12) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AbortedTransaction)) return false;
            AbortedTransaction other = (AbortedTransaction) obj;
            if (producerId != other.producerId) return false;
            if (firstOffset != other.firstOffset) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + ((int) (producerId >> 32) ^ (int) producerId);
            hashCode = 31 * hashCode + ((int) (firstOffset >> 32) ^ (int) firstOffset);
            return hashCode;
        }
        
        @Override
        public AbortedTransaction duplicate() {
            AbortedTransaction _duplicate = new AbortedTransaction();
            _duplicate.producerId = producerId;
            _duplicate.firstOffset = firstOffset;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "AbortedTransaction("
                + "producerId=" + producerId
                + ", firstOffset=" + firstOffset
                + ")";
        }
        
        public long producerId() {
            return this.producerId;
        }
        
        public long firstOffset() {
            return this.firstOffset;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public AbortedTransaction setProducerId(long v) {
            this.producerId = v;
            return this;
        }
        
        public AbortedTransaction setFirstOffset(long v) {
            this.firstOffset = v;
            return this;
        }
    }
}
