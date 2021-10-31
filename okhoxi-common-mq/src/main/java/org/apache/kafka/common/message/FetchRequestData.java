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


public class FetchRequestData implements ApiMessage {
    String clusterId;
    int replicaId;
    int maxWaitMs;
    int minBytes;
    int maxBytes;
    byte isolationLevel;
    int sessionId;
    int sessionEpoch;
    List<FetchTopic> topics;
    List<ForgottenTopic> forgottenTopicsData;
    String rackId;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_0), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_5), "The topics to fetch.")
        );
    
    public static final Schema SCHEMA_6 = SCHEMA_5;
    
    public static final Schema SCHEMA_7 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("session_epoch", Type.INT32, "The fetch session epoch, which is used for ordering requests in a session."),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_5), "The topics to fetch."),
            new Field("forgotten_topics_data", new ArrayOf(ForgottenTopic.SCHEMA_7), "In an incremental fetch request, the partitions to remove.")
        );
    
    public static final Schema SCHEMA_8 = SCHEMA_7;
    
    public static final Schema SCHEMA_9 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("session_epoch", Type.INT32, "The fetch session epoch, which is used for ordering requests in a session."),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_9), "The topics to fetch."),
            new Field("forgotten_topics_data", new ArrayOf(ForgottenTopic.SCHEMA_7), "In an incremental fetch request, the partitions to remove.")
        );
    
    public static final Schema SCHEMA_10 = SCHEMA_9;
    
    public static final Schema SCHEMA_11 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("session_epoch", Type.INT32, "The fetch session epoch, which is used for ordering requests in a session."),
            new Field("topics", new ArrayOf(FetchTopic.SCHEMA_9), "The topics to fetch."),
            new Field("forgotten_topics_data", new ArrayOf(ForgottenTopic.SCHEMA_7), "In an incremental fetch request, the partitions to remove."),
            new Field("rack_id", Type.STRING, "Rack ID of the consumer making this request")
        );
    
    public static final Schema SCHEMA_12 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower, of -1 if this request is from a consumer."),
            new Field("max_wait_ms", Type.INT32, "The maximum time in milliseconds to wait for the response."),
            new Field("min_bytes", Type.INT32, "The minimum bytes to accumulate in the response."),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch.  See KIP-74 for cases where this limit may not be honored."),
            new Field("isolation_level", Type.INT8, "This setting controls the visibility of transactional records. Using READ_UNCOMMITTED (isolation_level = 0) makes all records visible. With READ_COMMITTED (isolation_level = 1), non-transactional and COMMITTED transactional records are visible. To be more concrete, READ_COMMITTED returns all data from offsets smaller than the current LSO (last stable offset), and enables the inclusion of the list of aborted transactions in the result, which allows consumers to discard ABORTED transactional records"),
            new Field("session_id", Type.INT32, "The fetch session ID."),
            new Field("session_epoch", Type.INT32, "The fetch session epoch, which is used for ordering requests in a session."),
            new Field("topics", new CompactArrayOf(FetchTopic.SCHEMA_12), "The topics to fetch."),
            new Field("forgotten_topics_data", new CompactArrayOf(ForgottenTopic.SCHEMA_12), "In an incremental fetch request, the partitions to remove."),
            new Field("rack_id", Type.COMPACT_STRING, "Rack ID of the consumer making this request"),
            TaggedFieldsSection.of(
                0, new Field("cluster_id", Type.COMPACT_NULLABLE_STRING, "The clusterId if known. This is used to validate metadata fetches prior to broker registration.")
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
    
    public FetchRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public FetchRequestData() {
        this.clusterId = null;
        this.replicaId = 0;
        this.maxWaitMs = 0;
        this.minBytes = 0;
        this.maxBytes = 0x7fffffff;
        this.isolationLevel = (byte) 0;
        this.sessionId = 0;
        this.sessionEpoch = -1;
        this.topics = new ArrayList<FetchTopic>(0);
        this.forgottenTopicsData = new ArrayList<ForgottenTopic>(0);
        this.rackId = "";
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
        {
            this.clusterId = null;
        }
        this.replicaId = _readable.readInt();
        this.maxWaitMs = _readable.readInt();
        this.minBytes = _readable.readInt();
        if (_version >= 3) {
            this.maxBytes = _readable.readInt();
        } else {
            this.maxBytes = 0x7fffffff;
        }
        if (_version >= 4) {
            this.isolationLevel = _readable.readByte();
        } else {
            this.isolationLevel = (byte) 0;
        }
        if (_version >= 7) {
            this.sessionId = _readable.readInt();
        } else {
            this.sessionId = 0;
        }
        if (_version >= 7) {
            this.sessionEpoch = _readable.readInt();
        } else {
            this.sessionEpoch = -1;
        }
        {
            if (_version >= 12) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<FetchTopic> newCollection = new ArrayList<FetchTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new FetchTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field topics was serialized as null");
                } else {
                    ArrayList<FetchTopic> newCollection = new ArrayList<FetchTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new FetchTopic(_readable, _version));
                    }
                    this.topics = newCollection;
                }
            }
        }
        if (_version >= 7) {
            if (_version >= 12) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field forgottenTopicsData was serialized as null");
                } else {
                    ArrayList<ForgottenTopic> newCollection = new ArrayList<ForgottenTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ForgottenTopic(_readable, _version));
                    }
                    this.forgottenTopicsData = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field forgottenTopicsData was serialized as null");
                } else {
                    ArrayList<ForgottenTopic> newCollection = new ArrayList<ForgottenTopic>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new ForgottenTopic(_readable, _version));
                    }
                    this.forgottenTopicsData = newCollection;
                }
            }
        } else {
            this.forgottenTopicsData = new ArrayList<ForgottenTopic>(0);
        }
        if (_version >= 11) {
            int length;
            if (_version >= 12) {
                length = _readable.readUnsignedVarint() - 1;
            } else {
                length = _readable.readShort();
            }
            if (length < 0) {
                throw new RuntimeException("non-nullable field rackId was serialized as null");
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field rackId had invalid length " + length);
            } else {
                this.rackId = _readable.readString(length);
            }
        } else {
            this.rackId = "";
        }
        this._unknownTaggedFields = null;
        if (_version >= 12) {
            int _numTaggedFields = _readable.readUnsignedVarint();
            for (int _i = 0; _i < _numTaggedFields; _i++) {
                int _tag = _readable.readUnsignedVarint();
                int _size = _readable.readUnsignedVarint();
                switch (_tag) {
                    case 0: {
                        int length;
                        length = _readable.readUnsignedVarint() - 1;
                        if (length < 0) {
                            this.clusterId = null;
                        } else if (length > 0x7fff) {
                            throw new RuntimeException("string field clusterId had invalid length " + length);
                        } else {
                            this.clusterId = _readable.readString(length);
                        }
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
        if (_version >= 12) {
            if (this.clusterId != null) {
                _numTaggedFields++;
            }
        }
        _writable.writeInt(replicaId);
        _writable.writeInt(maxWaitMs);
        _writable.writeInt(minBytes);
        if (_version >= 3) {
            _writable.writeInt(maxBytes);
        }
        if (_version >= 4) {
            _writable.writeByte(isolationLevel);
        }
        if (_version >= 7) {
            _writable.writeInt(sessionId);
        }
        if (_version >= 7) {
            _writable.writeInt(sessionEpoch);
        }
        if (_version >= 12) {
            _writable.writeUnsignedVarint(topics.size() + 1);
            for (FetchTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(topics.size());
            for (FetchTopic topicsElement : topics) {
                topicsElement.write(_writable, _cache, _version);
            }
        }
        if (_version >= 7) {
            if (_version >= 12) {
                _writable.writeUnsignedVarint(forgottenTopicsData.size() + 1);
                for (ForgottenTopic forgottenTopicsDataElement : forgottenTopicsData) {
                    forgottenTopicsDataElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(forgottenTopicsData.size());
                for (ForgottenTopic forgottenTopicsDataElement : forgottenTopicsData) {
                    forgottenTopicsDataElement.write(_writable, _cache, _version);
                }
            }
        } else {
            if (!this.forgottenTopicsData.isEmpty()) {
                throw new UnsupportedVersionException("Attempted to write a non-default forgottenTopicsData at version " + _version);
            }
        }
        if (_version >= 11) {
            {
                byte[] _stringBytes = _cache.getSerializedValue(rackId);
                if (_version >= 12) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 12) {
            _writable.writeUnsignedVarint(_numTaggedFields);
            if (clusterId != null) {
                _writable.writeUnsignedVarint(0);
                byte[] _stringBytes = _cache.getSerializedValue(this.clusterId);
                _writable.writeUnsignedVarint(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
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
        if (_version >= 12) {
            if (clusterId == null) {
            } else {
                _numTaggedFields++;
                _size.addBytes(1);
                byte[] _stringBytes = clusterId.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'clusterId' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(clusterId, _stringBytes);
                int _stringPrefixSize = ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1);
                _size.addBytes(_stringBytes.length + _stringPrefixSize + ByteUtils.sizeOfUnsignedVarint(_stringPrefixSize));
            }
        }
        _size.addBytes(4);
        _size.addBytes(4);
        _size.addBytes(4);
        if (_version >= 3) {
            _size.addBytes(4);
        }
        if (_version >= 4) {
            _size.addBytes(1);
        }
        if (_version >= 7) {
            _size.addBytes(4);
        }
        if (_version >= 7) {
            _size.addBytes(4);
        }
        {
            if (_version >= 12) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (FetchTopic topicsElement : topics) {
                topicsElement.addSize(_size, _cache, _version);
            }
        }
        if (_version >= 7) {
            {
                if (_version >= 12) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(forgottenTopicsData.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (ForgottenTopic forgottenTopicsDataElement : forgottenTopicsData) {
                    forgottenTopicsDataElement.addSize(_size, _cache, _version);
                }
            }
        }
        if (_version >= 11) {
            {
                byte[] _stringBytes = rackId.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'rackId' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(rackId, _stringBytes);
                if (_version >= 12) {
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
        if (!(obj instanceof FetchRequestData)) return false;
        FetchRequestData other = (FetchRequestData) obj;
        if (this.clusterId == null) {
            if (other.clusterId != null) return false;
        } else {
            if (!this.clusterId.equals(other.clusterId)) return false;
        }
        if (replicaId != other.replicaId) return false;
        if (maxWaitMs != other.maxWaitMs) return false;
        if (minBytes != other.minBytes) return false;
        if (maxBytes != other.maxBytes) return false;
        if (isolationLevel != other.isolationLevel) return false;
        if (sessionId != other.sessionId) return false;
        if (sessionEpoch != other.sessionEpoch) return false;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (this.forgottenTopicsData == null) {
            if (other.forgottenTopicsData != null) return false;
        } else {
            if (!this.forgottenTopicsData.equals(other.forgottenTopicsData)) return false;
        }
        if (this.rackId == null) {
            if (other.rackId != null) return false;
        } else {
            if (!this.rackId.equals(other.rackId)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (clusterId == null ? 0 : clusterId.hashCode());
        hashCode = 31 * hashCode + replicaId;
        hashCode = 31 * hashCode + maxWaitMs;
        hashCode = 31 * hashCode + minBytes;
        hashCode = 31 * hashCode + maxBytes;
        hashCode = 31 * hashCode + isolationLevel;
        hashCode = 31 * hashCode + sessionId;
        hashCode = 31 * hashCode + sessionEpoch;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + (forgottenTopicsData == null ? 0 : forgottenTopicsData.hashCode());
        hashCode = 31 * hashCode + (rackId == null ? 0 : rackId.hashCode());
        return hashCode;
    }
    
    @Override
    public FetchRequestData duplicate() {
        FetchRequestData _duplicate = new FetchRequestData();
        if (clusterId == null) {
            _duplicate.clusterId = null;
        } else {
            _duplicate.clusterId = clusterId;
        }
        _duplicate.replicaId = replicaId;
        _duplicate.maxWaitMs = maxWaitMs;
        _duplicate.minBytes = minBytes;
        _duplicate.maxBytes = maxBytes;
        _duplicate.isolationLevel = isolationLevel;
        _duplicate.sessionId = sessionId;
        _duplicate.sessionEpoch = sessionEpoch;
        ArrayList<FetchTopic> newTopics = new ArrayList<FetchTopic>(topics.size());
        for (FetchTopic _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        ArrayList<ForgottenTopic> newForgottenTopicsData = new ArrayList<ForgottenTopic>(forgottenTopicsData.size());
        for (ForgottenTopic _element : forgottenTopicsData) {
            newForgottenTopicsData.add(_element.duplicate());
        }
        _duplicate.forgottenTopicsData = newForgottenTopicsData;
        _duplicate.rackId = rackId;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "FetchRequestData("
            + "clusterId=" + ((clusterId == null) ? "null" : "'" + clusterId.toString() + "'")
            + ", replicaId=" + replicaId
            + ", maxWaitMs=" + maxWaitMs
            + ", minBytes=" + minBytes
            + ", maxBytes=" + maxBytes
            + ", isolationLevel=" + isolationLevel
            + ", sessionId=" + sessionId
            + ", sessionEpoch=" + sessionEpoch
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ", forgottenTopicsData=" + MessageUtil.deepToString(forgottenTopicsData.iterator())
            + ", rackId=" + ((rackId == null) ? "null" : "'" + rackId.toString() + "'")
            + ")";
    }
    
    public String clusterId() {
        return this.clusterId;
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public int maxWaitMs() {
        return this.maxWaitMs;
    }
    
    public int minBytes() {
        return this.minBytes;
    }
    
    public int maxBytes() {
        return this.maxBytes;
    }
    
    public byte isolationLevel() {
        return this.isolationLevel;
    }
    
    public int sessionId() {
        return this.sessionId;
    }
    
    public int sessionEpoch() {
        return this.sessionEpoch;
    }
    
    public List<FetchTopic> topics() {
        return this.topics;
    }
    
    public List<ForgottenTopic> forgottenTopicsData() {
        return this.forgottenTopicsData;
    }
    
    public String rackId() {
        return this.rackId;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public FetchRequestData setClusterId(String v) {
        this.clusterId = v;
        return this;
    }
    
    public FetchRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public FetchRequestData setMaxWaitMs(int v) {
        this.maxWaitMs = v;
        return this;
    }
    
    public FetchRequestData setMinBytes(int v) {
        this.minBytes = v;
        return this;
    }
    
    public FetchRequestData setMaxBytes(int v) {
        this.maxBytes = v;
        return this;
    }
    
    public FetchRequestData setIsolationLevel(byte v) {
        this.isolationLevel = v;
        return this;
    }
    
    public FetchRequestData setSessionId(int v) {
        this.sessionId = v;
        return this;
    }
    
    public FetchRequestData setSessionEpoch(int v) {
        this.sessionEpoch = v;
        return this;
    }
    
    public FetchRequestData setTopics(List<FetchTopic> v) {
        this.topics = v;
        return this;
    }
    
    public FetchRequestData setForgottenTopicsData(List<ForgottenTopic> v) {
        this.forgottenTopicsData = v;
        return this;
    }
    
    public FetchRequestData setRackId(String v) {
        this.rackId = v;
        return this;
    }
    
    public static class FetchTopic implements Message {
        String topic;
        List<FetchPartition> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("topic", Type.STRING, "The name of the topic to fetch."),
                new Field("partitions", new ArrayOf(FetchPartition.SCHEMA_0), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("topic", Type.STRING, "The name of the topic to fetch."),
                new Field("partitions", new ArrayOf(FetchPartition.SCHEMA_5), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 =
            new Schema(
                new Field("topic", Type.STRING, "The name of the topic to fetch."),
                new Field("partitions", new ArrayOf(FetchPartition.SCHEMA_9), "The partitions to fetch.")
            );
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 = SCHEMA_10;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("topic", Type.COMPACT_STRING, "The name of the topic to fetch."),
                new Field("partitions", new CompactArrayOf(FetchPartition.SCHEMA_12), "The partitions to fetch."),
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
        
        public FetchTopic(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public FetchTopic() {
            this.topic = "";
            this.partitions = new ArrayList<FetchPartition>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of FetchTopic");
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
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<FetchPartition> newCollection = new ArrayList<FetchPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new FetchPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field partitions was serialized as null");
                    } else {
                        ArrayList<FetchPartition> newCollection = new ArrayList<FetchPartition>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new FetchPartition(_readable, _version));
                        }
                        this.partitions = newCollection;
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
                _writable.writeUnsignedVarint(partitions.size() + 1);
                for (FetchPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(partitions.size());
                for (FetchPartition partitionsElement : partitions) {
                    partitionsElement.write(_writable, _cache, _version);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of FetchTopic");
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
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (FetchPartition partitionsElement : partitions) {
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
            if (!(obj instanceof FetchTopic)) return false;
            FetchTopic other = (FetchTopic) obj;
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
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public FetchTopic duplicate() {
            FetchTopic _duplicate = new FetchTopic();
            _duplicate.topic = topic;
            ArrayList<FetchPartition> newPartitions = new ArrayList<FetchPartition>(partitions.size());
            for (FetchPartition _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "FetchTopic("
                + "topic=" + ((topic == null) ? "null" : "'" + topic.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<FetchPartition> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public FetchTopic setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public FetchTopic setPartitions(List<FetchPartition> v) {
            this.partitions = v;
            return this;
        }
    }
    
    public static class FetchPartition implements Message {
        int partition;
        int currentLeaderEpoch;
        long fetchOffset;
        int lastFetchedEpoch;
        long logStartOffset;
        int partitionMaxBytes;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("partition_max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 = SCHEMA_3;
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("log_start_offset", Type.INT64, "The earliest available offset of the follower replica.  The field is only used when the request is sent by the follower."),
                new Field("partition_max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_6 = SCHEMA_5;
        
        public static final Schema SCHEMA_7 = SCHEMA_6;
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch of the partition."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("log_start_offset", Type.INT64, "The earliest available offset of the follower replica.  The field is only used when the request is sent by the follower."),
                new Field("partition_max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored.")
            );
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 = SCHEMA_10;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index."),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch of the partition."),
                new Field("fetch_offset", Type.INT64, "The message offset."),
                new Field("last_fetched_epoch", Type.INT32, "The epoch of the last fetched record or -1 if there is none"),
                new Field("log_start_offset", Type.INT64, "The earliest available offset of the follower replica.  The field is only used when the request is sent by the follower."),
                new Field("partition_max_bytes", Type.INT32, "The maximum bytes to fetch from this partition.  See KIP-74 for cases where this limit may not be honored."),
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
        
        public FetchPartition(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public FetchPartition() {
            this.partition = 0;
            this.currentLeaderEpoch = -1;
            this.fetchOffset = 0L;
            this.lastFetchedEpoch = -1;
            this.logStartOffset = -1L;
            this.partitionMaxBytes = 0;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of FetchPartition");
            }
            this.partition = _readable.readInt();
            if (_version >= 9) {
                this.currentLeaderEpoch = _readable.readInt();
            } else {
                this.currentLeaderEpoch = -1;
            }
            this.fetchOffset = _readable.readLong();
            if (_version >= 12) {
                this.lastFetchedEpoch = _readable.readInt();
            } else {
                this.lastFetchedEpoch = -1;
            }
            if (_version >= 5) {
                this.logStartOffset = _readable.readLong();
            } else {
                this.logStartOffset = -1L;
            }
            this.partitionMaxBytes = _readable.readInt();
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
            _writable.writeInt(partition);
            if (_version >= 9) {
                _writable.writeInt(currentLeaderEpoch);
            }
            _writable.writeLong(fetchOffset);
            if (_version >= 12) {
                _writable.writeInt(lastFetchedEpoch);
            } else {
                if (this.lastFetchedEpoch != -1) {
                    throw new UnsupportedVersionException("Attempted to write a non-default lastFetchedEpoch at version " + _version);
                }
            }
            if (_version >= 5) {
                _writable.writeLong(logStartOffset);
            }
            _writable.writeInt(partitionMaxBytes);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of FetchPartition");
            }
            _size.addBytes(4);
            if (_version >= 9) {
                _size.addBytes(4);
            }
            _size.addBytes(8);
            if (_version >= 12) {
                _size.addBytes(4);
            }
            if (_version >= 5) {
                _size.addBytes(8);
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
            if (!(obj instanceof FetchPartition)) return false;
            FetchPartition other = (FetchPartition) obj;
            if (partition != other.partition) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (fetchOffset != other.fetchOffset) return false;
            if (lastFetchedEpoch != other.lastFetchedEpoch) return false;
            if (logStartOffset != other.logStartOffset) return false;
            if (partitionMaxBytes != other.partitionMaxBytes) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partition;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + ((int) (fetchOffset >> 32) ^ (int) fetchOffset);
            hashCode = 31 * hashCode + lastFetchedEpoch;
            hashCode = 31 * hashCode + ((int) (logStartOffset >> 32) ^ (int) logStartOffset);
            hashCode = 31 * hashCode + partitionMaxBytes;
            return hashCode;
        }
        
        @Override
        public FetchPartition duplicate() {
            FetchPartition _duplicate = new FetchPartition();
            _duplicate.partition = partition;
            _duplicate.currentLeaderEpoch = currentLeaderEpoch;
            _duplicate.fetchOffset = fetchOffset;
            _duplicate.lastFetchedEpoch = lastFetchedEpoch;
            _duplicate.logStartOffset = logStartOffset;
            _duplicate.partitionMaxBytes = partitionMaxBytes;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "FetchPartition("
                + "partition=" + partition
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", fetchOffset=" + fetchOffset
                + ", lastFetchedEpoch=" + lastFetchedEpoch
                + ", logStartOffset=" + logStartOffset
                + ", partitionMaxBytes=" + partitionMaxBytes
                + ")";
        }
        
        public int partition() {
            return this.partition;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public long fetchOffset() {
            return this.fetchOffset;
        }
        
        public int lastFetchedEpoch() {
            return this.lastFetchedEpoch;
        }
        
        public long logStartOffset() {
            return this.logStartOffset;
        }
        
        public int partitionMaxBytes() {
            return this.partitionMaxBytes;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public FetchPartition setPartition(int v) {
            this.partition = v;
            return this;
        }
        
        public FetchPartition setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public FetchPartition setFetchOffset(long v) {
            this.fetchOffset = v;
            return this;
        }
        
        public FetchPartition setLastFetchedEpoch(int v) {
            this.lastFetchedEpoch = v;
            return this;
        }
        
        public FetchPartition setLogStartOffset(long v) {
            this.logStartOffset = v;
            return this;
        }
        
        public FetchPartition setPartitionMaxBytes(int v) {
            this.partitionMaxBytes = v;
            return this;
        }
    }
    
    public static class ForgottenTopic implements Message {
        String topic;
        List<Integer> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_7 =
            new Schema(
                new Field("topic", Type.STRING, "The partition name."),
                new Field("partitions", new ArrayOf(Type.INT32), "The partitions indexes to forget.")
            );
        
        public static final Schema SCHEMA_8 = SCHEMA_7;
        
        public static final Schema SCHEMA_9 = SCHEMA_8;
        
        public static final Schema SCHEMA_10 = SCHEMA_9;
        
        public static final Schema SCHEMA_11 = SCHEMA_10;
        
        public static final Schema SCHEMA_12 =
            new Schema(
                new Field("topic", Type.COMPACT_STRING, "The partition name."),
                new Field("partitions", new CompactArrayOf(Type.INT32), "The partitions indexes to forget."),
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
            SCHEMA_7,
            SCHEMA_8,
            SCHEMA_9,
            SCHEMA_10,
            SCHEMA_11,
            SCHEMA_12
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 7;
        public static final short HIGHEST_SUPPORTED_VERSION = 12;
        
        public ForgottenTopic(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ForgottenTopic() {
            this.topic = "";
            this.partitions = new ArrayList<Integer>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ForgottenTopic");
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
                int arrayLength;
                if (_version >= 12) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitions was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.partitions = newCollection;
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
            if (_version < 7) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of ForgottenTopic");
            }
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
                _writable.writeUnsignedVarint(partitions.size() + 1);
            } else {
                _writable.writeInt(partitions.size());
            }
            for (Integer partitionsElement : partitions) {
                _writable.writeInt(partitionsElement);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of ForgottenTopic");
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
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(partitions.size() * 4);
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
            if (!(obj instanceof ForgottenTopic)) return false;
            ForgottenTopic other = (ForgottenTopic) obj;
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
            hashCode = 31 * hashCode + (partitions == null ? 0 : partitions.hashCode());
            return hashCode;
        }
        
        @Override
        public ForgottenTopic duplicate() {
            ForgottenTopic _duplicate = new ForgottenTopic();
            _duplicate.topic = topic;
            ArrayList<Integer> newPartitions = new ArrayList<Integer>(partitions.size());
            for (Integer _element : partitions) {
                newPartitions.add(_element);
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ForgottenTopic("
                + "topic=" + ((topic == null) ? "null" : "'" + topic.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String topic() {
            return this.topic;
        }
        
        public List<Integer> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ForgottenTopic setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public ForgottenTopic setPartitions(List<Integer> v) {
            this.partitions = v;
            return this;
        }
    }
}
