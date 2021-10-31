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

import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class BrokerHeartbeatRequestData implements ApiMessage {
    int brokerId;
    long brokerEpoch;
    long currentMetadataOffset;
    boolean wantFence;
    boolean wantShutDown;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("broker_id", Type.INT32, "The broker ID."),
            new Field("broker_epoch", Type.INT64, "The broker epoch."),
            new Field("current_metadata_offset", Type.INT64, "The highest metadata offset which the broker has reached."),
            new Field("want_fence", Type.BOOLEAN, "True if the broker wants to be fenced, false otherwise."),
            new Field("want_shut_down", Type.BOOLEAN, "True if the broker wants to be shut down, false otherwise."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public BrokerHeartbeatRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public BrokerHeartbeatRequestData() {
        this.brokerId = 0;
        this.brokerEpoch = -1L;
        this.currentMetadataOffset = 0L;
        this.wantFence = false;
        this.wantShutDown = false;
    }
    
    @Override
    public short apiKey() {
        return 63;
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
        this.brokerId = _readable.readInt();
        this.brokerEpoch = _readable.readLong();
        this.currentMetadataOffset = _readable.readLong();
        this.wantFence = _readable.readByte() != 0;
        this.wantShutDown = _readable.readByte() != 0;
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
        _writable.writeLong(brokerEpoch);
        _writable.writeLong(currentMetadataOffset);
        _writable.writeByte(wantFence ? (byte) 1 : (byte) 0);
        _writable.writeByte(wantShutDown ? (byte) 1 : (byte) 0);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _size.addBytes(4);
        _size.addBytes(8);
        _size.addBytes(8);
        _size.addBytes(1);
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
        if (!(obj instanceof BrokerHeartbeatRequestData)) return false;
        BrokerHeartbeatRequestData other = (BrokerHeartbeatRequestData) obj;
        if (brokerId != other.brokerId) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (currentMetadataOffset != other.currentMetadataOffset) return false;
        if (wantFence != other.wantFence) return false;
        if (wantShutDown != other.wantShutDown) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + brokerId;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + ((int) (currentMetadataOffset >> 32) ^ (int) currentMetadataOffset);
        hashCode = 31 * hashCode + (wantFence ? 1231 : 1237);
        hashCode = 31 * hashCode + (wantShutDown ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public BrokerHeartbeatRequestData duplicate() {
        BrokerHeartbeatRequestData _duplicate = new BrokerHeartbeatRequestData();
        _duplicate.brokerId = brokerId;
        _duplicate.brokerEpoch = brokerEpoch;
        _duplicate.currentMetadataOffset = currentMetadataOffset;
        _duplicate.wantFence = wantFence;
        _duplicate.wantShutDown = wantShutDown;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "BrokerHeartbeatRequestData("
            + "brokerId=" + brokerId
            + ", brokerEpoch=" + brokerEpoch
            + ", currentMetadataOffset=" + currentMetadataOffset
            + ", wantFence=" + (wantFence ? "true" : "false")
            + ", wantShutDown=" + (wantShutDown ? "true" : "false")
            + ")";
    }
    
    public int brokerId() {
        return this.brokerId;
    }
    
    public long brokerEpoch() {
        return this.brokerEpoch;
    }
    
    public long currentMetadataOffset() {
        return this.currentMetadataOffset;
    }
    
    public boolean wantFence() {
        return this.wantFence;
    }
    
    public boolean wantShutDown() {
        return this.wantShutDown;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public BrokerHeartbeatRequestData setBrokerId(int v) {
        this.brokerId = v;
        return this;
    }
    
    public BrokerHeartbeatRequestData setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public BrokerHeartbeatRequestData setCurrentMetadataOffset(long v) {
        this.currentMetadataOffset = v;
        return this;
    }
    
    public BrokerHeartbeatRequestData setWantFence(boolean v) {
        this.wantFence = v;
        return this;
    }
    
    public BrokerHeartbeatRequestData setWantShutDown(boolean v) {
        this.wantShutDown = v;
        return this;
    }
}
