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

import java.nio.ByteBuffer;
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
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;


public class ConsumerProtocolSubscription implements ApiMessage {
    List<String> topics;
    ByteBuffer userData;
    List<TopicPartition> ownedPartitions;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("topics", new ArrayOf(Type.STRING), ""),
            new Field("user_data", Type.NULLABLE_BYTES, "")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("topics", new ArrayOf(Type.STRING), ""),
            new Field("user_data", Type.NULLABLE_BYTES, ""),
            new Field("owned_partitions", new ArrayOf(TopicPartition.SCHEMA_1), "")
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 1;
    
    public ConsumerProtocolSubscription(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ConsumerProtocolSubscription() {
        this.topics = new ArrayList<String>(0);
        this.userData = null;
        this.ownedPartitions = new ArrayList<TopicPartition>(0);
    }
    
    @Override
    public short apiKey() {
        return -1;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 1;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            int arrayLength;
            arrayLength = _readable.readInt();
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field topics was serialized as null");
            } else {
                ArrayList<String> newCollection = new ArrayList<String>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    int length;
                    length = _readable.readShort();
                    if (length < 0) {
                        throw new RuntimeException("non-nullable field topics element was serialized as null");
                    } else if (length > 0x7fff) {
                        throw new RuntimeException("string field topics element had invalid length " + length);
                    } else {
                        newCollection.add(_readable.readString(length));
                    }
                }
                this.topics = newCollection;
            }
        }
        {
            int length;
            length = _readable.readInt();
            if (length < 0) {
                this.userData = null;
            } else {
                this.userData = _readable.readByteBuffer(length);
            }
        }
        if (_version >= 1) {
            int arrayLength;
            arrayLength = _readable.readInt();
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field ownedPartitions was serialized as null");
            } else {
                ArrayList<TopicPartition> newCollection = new ArrayList<TopicPartition>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new TopicPartition(_readable, _version));
                }
                this.ownedPartitions = newCollection;
            }
        } else {
            this.ownedPartitions = new ArrayList<TopicPartition>(0);
        }
        this._unknownTaggedFields = null;
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeInt(topics.size());
        for (String topicsElement : topics) {
            {
                byte[] _stringBytes = _cache.getSerializedValue(topicsElement);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
        }
        if (userData == null) {
            _writable.writeInt(-1);
        } else {
            _writable.writeInt(userData.remaining());
            _writable.writeByteBuffer(userData);
        }
        if (_version >= 1) {
            _writable.writeInt(ownedPartitions.size());
            for (TopicPartition ownedPartitionsElement : ownedPartitions) {
                ownedPartitionsElement.write(_writable, _cache, _version);
            }
        }
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
            _size.addBytes(4);
            for (String topicsElement : topics) {
                byte[] _stringBytes = topicsElement.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topicsElement' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topicsElement, _stringBytes);
                _size.addBytes(_stringBytes.length + 2);
            }
        }
        if (userData == null) {
            _size.addBytes(4);
        } else {
            _size.addZeroCopyBytes(userData.remaining());
            _size.addBytes(4);
        }
        if (_version >= 1) {
            {
                _size.addBytes(4);
                for (TopicPartition ownedPartitionsElement : ownedPartitions) {
                    ownedPartitionsElement.addSize(_size, _cache, _version);
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
        if (_numTaggedFields > 0) {
            throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ConsumerProtocolSubscription)) return false;
        ConsumerProtocolSubscription other = (ConsumerProtocolSubscription) obj;
        if (this.topics == null) {
            if (other.topics != null) return false;
        } else {
            if (!this.topics.equals(other.topics)) return false;
        }
        if (!Objects.equals(this.userData, other.userData)) return false;
        if (this.ownedPartitions == null) {
            if (other.ownedPartitions != null) return false;
        } else {
            if (!this.ownedPartitions.equals(other.ownedPartitions)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (topics == null ? 0 : topics.hashCode());
        hashCode = 31 * hashCode + Objects.hashCode(userData);
        hashCode = 31 * hashCode + (ownedPartitions == null ? 0 : ownedPartitions.hashCode());
        return hashCode;
    }
    
    @Override
    public ConsumerProtocolSubscription duplicate() {
        ConsumerProtocolSubscription _duplicate = new ConsumerProtocolSubscription();
        ArrayList<String> newTopics = new ArrayList<String>(topics.size());
        for (String _element : topics) {
            newTopics.add(_element);
        }
        _duplicate.topics = newTopics;
        if (userData == null) {
            _duplicate.userData = null;
        } else {
            _duplicate.userData = userData.duplicate();
        }
        ArrayList<TopicPartition> newOwnedPartitions = new ArrayList<TopicPartition>(ownedPartitions.size());
        for (TopicPartition _element : ownedPartitions) {
            newOwnedPartitions.add(_element.duplicate());
        }
        _duplicate.ownedPartitions = newOwnedPartitions;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ConsumerProtocolSubscription("
            + "topics=" + MessageUtil.deepToString(topics.iterator())
            + ", userData=" + userData
            + ", ownedPartitions=" + MessageUtil.deepToString(ownedPartitions.iterator())
            + ")";
    }
    
    public List<String> topics() {
        return this.topics;
    }
    
    public ByteBuffer userData() {
        return this.userData;
    }
    
    public List<TopicPartition> ownedPartitions() {
        return this.ownedPartitions;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ConsumerProtocolSubscription setTopics(List<String> v) {
        this.topics = v;
        return this;
    }
    
    public ConsumerProtocolSubscription setUserData(ByteBuffer v) {
        this.userData = v;
        return this;
    }
    
    public ConsumerProtocolSubscription setOwnedPartitions(List<TopicPartition> v) {
        this.ownedPartitions = v;
        return this;
    }
    
    public static class TopicPartition implements Message {
        String topic;
        List<Integer> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("topic", Type.STRING, ""),
                new Field("partitions", new ArrayOf(Type.INT32), "")
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 1;
        
        public TopicPartition(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public TopicPartition() {
            this.topic = "";
            this.partitions = new ArrayList<Integer>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of TopicPartition");
            }
            {
                int length;
                length = _readable.readShort();
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
                arrayLength = _readable.readInt();
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
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of TopicPartition");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(topic);
                _writable.writeShort((short) _stringBytes.length);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(partitions.size());
            for (Integer partitionsElement : partitions) {
                _writable.writeInt(partitionsElement);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of TopicPartition");
            }
            {
                byte[] _stringBytes = topic.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'topic' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(topic, _stringBytes);
                _size.addBytes(_stringBytes.length + 2);
            }
            {
                _size.addBytes(4);
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
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TopicPartition)) return false;
            TopicPartition other = (TopicPartition) obj;
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
        public TopicPartition duplicate() {
            TopicPartition _duplicate = new TopicPartition();
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
            return "TopicPartition("
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
        
        public TopicPartition setTopic(String v) {
            this.topic = v;
            return this;
        }
        
        public TopicPartition setPartitions(List<Integer> v) {
            this.partitions = v;
            return this;
        }
    }
}
