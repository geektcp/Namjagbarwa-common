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
import java.util.Iterator;
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
import org.apache.kafka.common.utils.ImplicitLinkedHashCollection;
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiCollection;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class DescribeClusterResponseData implements ApiMessage {
    int throttleTimeMs;
    short errorCode;
    String errorMessage;
    String clusterId;
    int controllerId;
    DescribeClusterBrokerCollection brokers;
    int clusterAuthorizedOperations;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The top-level error code, or 0 if there was no error"),
            new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The top-level error message, or null if there was no error."),
            new Field("cluster_id", Type.COMPACT_STRING, "The cluster ID that responding broker belongs to."),
            new Field("controller_id", Type.INT32, "The ID of the controller broker."),
            new Field("brokers", new CompactArrayOf(DescribeClusterBroker.SCHEMA_0), "Each broker in the response."),
            new Field("cluster_authorized_operations", Type.INT32, "32-bit bitfield to represent authorized operations for this cluster."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public DescribeClusterResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DescribeClusterResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.errorMessage = null;
        this.clusterId = "";
        this.controllerId = -1;
        this.brokers = new DescribeClusterBrokerCollection(0);
        this.clusterAuthorizedOperations = -2147483648;
    }
    
    @Override
    public short apiKey() {
        return 60;
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
            int length;
            length = _readable.readUnsignedVarint() - 1;
            if (length < 0) {
                throw new RuntimeException("non-nullable field clusterId was serialized as null");
            } else if (length > 0x7fff) {
                throw new RuntimeException("string field clusterId had invalid length " + length);
            } else {
                this.clusterId = _readable.readString(length);
            }
        }
        this.controllerId = _readable.readInt();
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field brokers was serialized as null");
            } else {
                DescribeClusterBrokerCollection newCollection = new DescribeClusterBrokerCollection(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new DescribeClusterBroker(_readable, _version));
                }
                this.brokers = newCollection;
            }
        }
        this.clusterAuthorizedOperations = _readable.readInt();
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
        {
            byte[] _stringBytes = _cache.getSerializedValue(clusterId);
            _writable.writeUnsignedVarint(_stringBytes.length + 1);
            _writable.writeByteArray(_stringBytes);
        }
        _writable.writeInt(controllerId);
        _writable.writeUnsignedVarint(brokers.size() + 1);
        for (DescribeClusterBroker brokersElement : brokers) {
            brokersElement.write(_writable, _cache, _version);
        }
        _writable.writeInt(clusterAuthorizedOperations);
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
            byte[] _stringBytes = clusterId.getBytes(StandardCharsets.UTF_8);
            if (_stringBytes.length > 0x7fff) {
                throw new RuntimeException("'clusterId' field is too long to be serialized");
            }
            _cache.cacheSerializedValue(clusterId, _stringBytes);
            _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
        }
        _size.addBytes(4);
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(brokers.size() + 1));
            for (DescribeClusterBroker brokersElement : brokers) {
                brokersElement.addSize(_size, _cache, _version);
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
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeClusterResponseData)) return false;
        DescribeClusterResponseData other = (DescribeClusterResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (this.errorMessage == null) {
            if (other.errorMessage != null) return false;
        } else {
            if (!this.errorMessage.equals(other.errorMessage)) return false;
        }
        if (this.clusterId == null) {
            if (other.clusterId != null) return false;
        } else {
            if (!this.clusterId.equals(other.clusterId)) return false;
        }
        if (controllerId != other.controllerId) return false;
        if (this.brokers == null) {
            if (other.brokers != null) return false;
        } else {
            if (!this.brokers.equals(other.brokers)) return false;
        }
        if (clusterAuthorizedOperations != other.clusterAuthorizedOperations) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
        hashCode = 31 * hashCode + (clusterId == null ? 0 : clusterId.hashCode());
        hashCode = 31 * hashCode + controllerId;
        hashCode = 31 * hashCode + (brokers == null ? 0 : brokers.hashCode());
        hashCode = 31 * hashCode + clusterAuthorizedOperations;
        return hashCode;
    }
    
    @Override
    public DescribeClusterResponseData duplicate() {
        DescribeClusterResponseData _duplicate = new DescribeClusterResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        _duplicate.errorCode = errorCode;
        if (errorMessage == null) {
            _duplicate.errorMessage = null;
        } else {
            _duplicate.errorMessage = errorMessage;
        }
        _duplicate.clusterId = clusterId;
        _duplicate.controllerId = controllerId;
        DescribeClusterBrokerCollection newBrokers = new DescribeClusterBrokerCollection(brokers.size());
        for (DescribeClusterBroker _element : brokers) {
            newBrokers.add(_element.duplicate());
        }
        _duplicate.brokers = newBrokers;
        _duplicate.clusterAuthorizedOperations = clusterAuthorizedOperations;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DescribeClusterResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", errorMessage=" + ((errorMessage == null) ? "null" : "'" + errorMessage.toString() + "'")
            + ", clusterId=" + ((clusterId == null) ? "null" : "'" + clusterId.toString() + "'")
            + ", controllerId=" + controllerId
            + ", brokers=" + MessageUtil.deepToString(brokers.iterator())
            + ", clusterAuthorizedOperations=" + clusterAuthorizedOperations
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
    
    public String clusterId() {
        return this.clusterId;
    }
    
    public int controllerId() {
        return this.controllerId;
    }
    
    public DescribeClusterBrokerCollection brokers() {
        return this.brokers;
    }
    
    public int clusterAuthorizedOperations() {
        return this.clusterAuthorizedOperations;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DescribeClusterResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeClusterResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public DescribeClusterResponseData setErrorMessage(String v) {
        this.errorMessage = v;
        return this;
    }
    
    public DescribeClusterResponseData setClusterId(String v) {
        this.clusterId = v;
        return this;
    }
    
    public DescribeClusterResponseData setControllerId(int v) {
        this.controllerId = v;
        return this;
    }
    
    public DescribeClusterResponseData setBrokers(DescribeClusterBrokerCollection v) {
        this.brokers = v;
        return this;
    }
    
    public DescribeClusterResponseData setClusterAuthorizedOperations(int v) {
        this.clusterAuthorizedOperations = v;
        return this;
    }
    
    public static class DescribeClusterBroker implements Message, ImplicitLinkedHashMultiCollection.Element {
        int brokerId;
        String host;
        int port;
        String rack;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("broker_id", Type.INT32, "The broker ID."),
                new Field("host", Type.COMPACT_STRING, "The broker hostname."),
                new Field("port", Type.INT32, "The broker port."),
                new Field("rack", Type.COMPACT_NULLABLE_STRING, "The rack of the broker, or null if it has not been assigned to a rack."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public DescribeClusterBroker(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public DescribeClusterBroker() {
            this.brokerId = 0;
            this.host = "";
            this.port = 0;
            this.rack = null;
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeClusterBroker");
            }
            this.brokerId = _readable.readInt();
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field host was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field host had invalid length " + length);
                } else {
                    this.host = _readable.readString(length);
                }
            }
            this.port = _readable.readInt();
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    this.rack = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field rack had invalid length " + length);
                } else {
                    this.rack = _readable.readString(length);
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
            _writable.writeInt(brokerId);
            {
                byte[] _stringBytes = _cache.getSerializedValue(host);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeInt(port);
            if (rack == null) {
                _writable.writeUnsignedVarint(0);
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(rack);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribeClusterBroker");
            }
            _size.addBytes(4);
            {
                byte[] _stringBytes = host.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'host' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(host, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(4);
            if (rack == null) {
                _size.addBytes(1);
            } else {
                byte[] _stringBytes = rack.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'rack' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(rack, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
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
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof DescribeClusterBroker)) return false;
            DescribeClusterBroker other = (DescribeClusterBroker) obj;
            if (brokerId != other.brokerId) return false;
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeClusterBroker)) return false;
            DescribeClusterBroker other = (DescribeClusterBroker) obj;
            if (brokerId != other.brokerId) return false;
            if (this.host == null) {
                if (other.host != null) return false;
            } else {
                if (!this.host.equals(other.host)) return false;
            }
            if (port != other.port) return false;
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
            hashCode = 31 * hashCode + brokerId;
            return hashCode;
        }
        
        @Override
        public DescribeClusterBroker duplicate() {
            DescribeClusterBroker _duplicate = new DescribeClusterBroker();
            _duplicate.brokerId = brokerId;
            _duplicate.host = host;
            _duplicate.port = port;
            if (rack == null) {
                _duplicate.rack = null;
            } else {
                _duplicate.rack = rack;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribeClusterBroker("
                + "brokerId=" + brokerId
                + ", host=" + ((host == null) ? "null" : "'" + host.toString() + "'")
                + ", port=" + port
                + ", rack=" + ((rack == null) ? "null" : "'" + rack.toString() + "'")
                + ")";
        }
        
        public int brokerId() {
            return this.brokerId;
        }
        
        public String host() {
            return this.host;
        }
        
        public int port() {
            return this.port;
        }
        
        public String rack() {
            return this.rack;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribeClusterBroker setBrokerId(int v) {
            this.brokerId = v;
            return this;
        }
        
        public DescribeClusterBroker setHost(String v) {
            this.host = v;
            return this;
        }
        
        public DescribeClusterBroker setPort(int v) {
            this.port = v;
            return this;
        }
        
        public DescribeClusterBroker setRack(String v) {
            this.rack = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    public static class DescribeClusterBrokerCollection extends ImplicitLinkedHashMultiCollection<DescribeClusterBroker> {
        public DescribeClusterBrokerCollection() {
            super();
        }
        
        public DescribeClusterBrokerCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public DescribeClusterBrokerCollection(Iterator<DescribeClusterBroker> iterator) {
            super(iterator);
        }
        
        public DescribeClusterBroker find(int brokerId) {
            DescribeClusterBroker _key = new DescribeClusterBroker();
            _key.setBrokerId(brokerId);
            return find(_key);
        }
        
        public List<DescribeClusterBroker> findAll(int brokerId) {
            DescribeClusterBroker _key = new DescribeClusterBroker();
            _key.setBrokerId(brokerId);
            return findAll(_key);
        }
        
        public DescribeClusterBrokerCollection duplicate() {
            DescribeClusterBrokerCollection _duplicate = new DescribeClusterBrokerCollection(size());
            for (DescribeClusterBroker _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
