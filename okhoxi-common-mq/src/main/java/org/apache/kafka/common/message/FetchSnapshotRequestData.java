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


public class FetchSnapshotRequestData implements ApiMessage {
    String clusterId;
    int replicaId;
    int maxBytes;
    List<TopicSnapshot> topics;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("replica_id", Type.INT32, "The broker ID of the follower"),
            new Field("max_bytes", Type.INT32, "The maximum bytes to fetch from all of the snapshots"),
            new Field("topics", new CompactArrayOf(TopicSnapshot.SCHEMA_0), "The topics to fetch"),
            TaggedFieldsSection.of(
                0, new Field("cluster_id", Type.COMPACT_NULLABLE_STRING, "The clusterId if known, this is used to validate metadata fetches prior to broker registration")
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public FetchSnapshotRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public FetchSnapshotRequestData() {
        this.clusterId = null;
        this.replicaId = -1;
        this.maxBytes = 0x7fffffff;
        this.topics = new ArrayList<TopicSnapshot>(0);
    }
    
    @Override
    public short apiKey() {
        return 59;
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
        {
            this.clusterId = null;
        }
        this.replicaId = _readable.readInt();
        this.maxBytes = _readable.readInt();
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topics was serialized as null");
            } else {
                ArrayList<TopicSnapshot> newCollection = new ArrayList<TopicSnapshot>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new TopicSnapshot(_readable, _version));
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
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (this.clusterId != null) {
            _numTaggedFields++;
        }
        _writable.writeInt(replicaId);
        _writable.writeInt(maxBytes);
        _writable.writeUnsignedVarint(topics.size() + 1);
        for (TopicSnapshot topicsElement : topics) {
            topicsElement.write(_writable, _cache, _version);
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        if (clusterId != null) {
            _writable.writeUnsignedVarint(0);
            byte[] _stringBytes = _cache.getSerializedValue(this.clusterId);
            _writable.writeUnsignedVarint(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            _writable.writeUnsignedVarint(_stringBytes.length + 1);
            _writable.writeByteArray(_stringBytes);
        }
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
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
        _size.addBytes(4);
        _size.addBytes(4);
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
            for (TopicSnapshot topicsElement : topics) {
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
        if (!(obj instanceof FetchSnapshotRequestData)) return false;
        FetchSnapshotRequestData other = (FetchSnapshotRequestData) obj;
        if (this.clusterId == null) {
            if (other.clusterId != null) return false;
        } else {
            if (!this.clusterId.equals(other.clusterId)) return false;
        }
        if (replicaId != other.replicaId) return false;
        if (maxBytes != other.maxBytes) return false;
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
        hashCode = 31 * hashCode + (clusterId == null ? 0 : clusterId.hashCode());
        hashCode = 31 * hashCode + replicaId;
        hashCode = 31 * hashCode + maxBytes;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        return hashCode;
    }
    
    @Override
    public FetchSnapshotRequestData duplicate() {
        FetchSnapshotRequestData _duplicate = new FetchSnapshotRequestData();
        if (clusterId == null) {
            _duplicate.clusterId = null;
        } else {
            _duplicate.clusterId = clusterId;
        }
        _duplicate.replicaId = replicaId;
        _duplicate.maxBytes = maxBytes;
        ArrayList<TopicSnapshot> newTopics = new ArrayList<TopicSnapshot>(topics.size());
        for (TopicSnapshot _element : topics) {
            newTopics.add(_element.duplicate());
        }
        _duplicate.topics = newTopics;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "FetchSnapshotRequestData("
            + "clusterId=" + ((clusterId == null) ? "null" : "'" + clusterId.toString() + "'")
            + ", replicaId=" + replicaId
            + ", maxBytes=" + maxBytes
            + ", topics=" + MessageUtil.deepToString(topics.iterator())
            + ")";
    }
    
    public String clusterId() {
        return this.clusterId;
    }
    
    public int replicaId() {
        return this.replicaId;
    }
    
    public int maxBytes() {
        return this.maxBytes;
    }
    
    public List<TopicSnapshot> topics() {
        return this.topics;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public FetchSnapshotRequestData setClusterId(String v) {
        this.clusterId = v;
        return this;
    }
    
    public FetchSnapshotRequestData setReplicaId(int v) {
        this.replicaId = v;
        return this;
    }
    
    public FetchSnapshotRequestData setMaxBytes(int v) {
        this.maxBytes = v;
        return this;
    }
    
    public FetchSnapshotRequestData setTopics(List<TopicSnapshot> v) {
        this.topics = v;
        return this;
    }
    
    public static class TopicSnapshot implements Message {
        String name;
        List<PartitionSnapshot> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The name of the topic to fetch"),
                new Field("partitions", new CompactArrayOf(PartitionSnapshot.SCHEMA_0), "The partitions to fetch"),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public TopicSnapshot(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public TopicSnapshot() {
            this.name = "";
            this.partitions = new ArrayList<PartitionSnapshot>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of TopicSnapshot");
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
                    ArrayList<PartitionSnapshot> newCollection = new ArrayList<PartitionSnapshot>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new PartitionSnapshot(_readable, _version));
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
            for (PartitionSnapshot partitionsElement : partitions) {
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of TopicSnapshot");
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
                for (PartitionSnapshot partitionsElement : partitions) {
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
            if (!(obj instanceof TopicSnapshot)) return false;
            TopicSnapshot other = (TopicSnapshot) obj;
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
        public TopicSnapshot duplicate() {
            TopicSnapshot _duplicate = new TopicSnapshot();
            _duplicate.name = name;
            ArrayList<PartitionSnapshot> newPartitions = new ArrayList<PartitionSnapshot>(partitions.size());
            for (PartitionSnapshot _element : partitions) {
                newPartitions.add(_element.duplicate());
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "TopicSnapshot("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<PartitionSnapshot> partitions() {
            return this.partitions;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public TopicSnapshot setName(String v) {
            this.name = v;
            return this;
        }
        
        public TopicSnapshot setPartitions(List<PartitionSnapshot> v) {
            this.partitions = v;
            return this;
        }
    }
    
    public static class PartitionSnapshot implements Message {
        int partition;
        int currentLeaderEpoch;
        SnapshotId snapshotId;
        long position;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("partition", Type.INT32, "The partition index"),
                new Field("current_leader_epoch", Type.INT32, "The current leader epoch of the partition, -1 for unknown leader epoch"),
                new Field("snapshot_id", SnapshotId.SCHEMA_0, "The snapshot endOffset and epoch to fetch"),
                new Field("position", Type.INT64, "The byte position within the snapshot to start fetching from"),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public PartitionSnapshot(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public PartitionSnapshot() {
            this.partition = 0;
            this.currentLeaderEpoch = 0;
            this.snapshotId = new SnapshotId();
            this.position = 0L;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of PartitionSnapshot");
            }
            this.partition = _readable.readInt();
            this.currentLeaderEpoch = _readable.readInt();
            {
                this.snapshotId = new SnapshotId(_readable, _version);
            }
            this.position = _readable.readLong();
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
            _writable.writeInt(partition);
            _writable.writeInt(currentLeaderEpoch);
            snapshotId.write(_writable, _cache, _version);
            _writable.writeLong(position);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of PartitionSnapshot");
            }
            _size.addBytes(4);
            _size.addBytes(4);
            {
                int _sizeBeforeStruct = _size.totalSize();
                this.snapshotId.addSize(_size, _cache, _version);
                int _structSize = _size.totalSize() - _sizeBeforeStruct;
            }
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
            if (!(obj instanceof PartitionSnapshot)) return false;
            PartitionSnapshot other = (PartitionSnapshot) obj;
            if (partition != other.partition) return false;
            if (currentLeaderEpoch != other.currentLeaderEpoch) return false;
            if (this.snapshotId == null) {
                if (other.snapshotId != null) return false;
            } else {
                if (!this.snapshotId.equals(other.snapshotId)) return false;
            }
            if (position != other.position) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + partition;
            hashCode = 31 * hashCode + currentLeaderEpoch;
            hashCode = 31 * hashCode + (snapshotId == null ? 0 : snapshotId.hashCode());
            hashCode = 31 * hashCode + ((int) (position >> 32) ^ (int) position);
            return hashCode;
        }
        
        @Override
        public PartitionSnapshot duplicate() {
            PartitionSnapshot _duplicate = new PartitionSnapshot();
            _duplicate.partition = partition;
            _duplicate.currentLeaderEpoch = currentLeaderEpoch;
            _duplicate.snapshotId = snapshotId.duplicate();
            _duplicate.position = position;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "PartitionSnapshot("
                + "partition=" + partition
                + ", currentLeaderEpoch=" + currentLeaderEpoch
                + ", snapshotId=" + snapshotId.toString()
                + ", position=" + position
                + ")";
        }
        
        public int partition() {
            return this.partition;
        }
        
        public int currentLeaderEpoch() {
            return this.currentLeaderEpoch;
        }
        
        public SnapshotId snapshotId() {
            return this.snapshotId;
        }
        
        public long position() {
            return this.position;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public PartitionSnapshot setPartition(int v) {
            this.partition = v;
            return this;
        }
        
        public PartitionSnapshot setCurrentLeaderEpoch(int v) {
            this.currentLeaderEpoch = v;
            return this;
        }
        
        public PartitionSnapshot setSnapshotId(SnapshotId v) {
            this.snapshotId = v;
            return this;
        }
        
        public PartitionSnapshot setPosition(long v) {
            this.position = v;
            return this;
        }
    }
    
    public static class SnapshotId implements Message {
        long endOffset;
        int epoch;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("end_offset", Type.INT64, ""),
                new Field("epoch", Type.INT32, ""),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public SnapshotId(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public SnapshotId() {
            this.endOffset = 0L;
            this.epoch = 0;
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
            if (_version > 0) {
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
}
