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


public class BrokerHeartbeatResponseData implements ApiMessage {
    int throttleTimeMs;
    short errorCode;
    boolean isCaughtUp;
    boolean isFenced;
    boolean shouldShutDown;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "Duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("error_code", Type.INT16, "The error code, or 0 if there was no error."),
            new Field("is_caught_up", Type.BOOLEAN, "True if the broker has approximately caught up with the latest metadata."),
            new Field("is_fenced", Type.BOOLEAN, "True if the broker is fenced."),
            new Field("should_shut_down", Type.BOOLEAN, "True if the broker should proceed with its shutdown."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public BrokerHeartbeatResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public BrokerHeartbeatResponseData() {
        this.throttleTimeMs = 0;
        this.errorCode = (short) 0;
        this.isCaughtUp = false;
        this.isFenced = true;
        this.shouldShutDown = false;
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
        this.throttleTimeMs = _readable.readInt();
        this.errorCode = _readable.readShort();
        this.isCaughtUp = _readable.readByte() != 0;
        this.isFenced = _readable.readByte() != 0;
        this.shouldShutDown = _readable.readByte() != 0;
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
        _writable.writeByte(isCaughtUp ? (byte) 1 : (byte) 0);
        _writable.writeByte(isFenced ? (byte) 1 : (byte) 0);
        _writable.writeByte(shouldShutDown ? (byte) 1 : (byte) 0);
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
        _size.addBytes(1);
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
        if (!(obj instanceof BrokerHeartbeatResponseData)) return false;
        BrokerHeartbeatResponseData other = (BrokerHeartbeatResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (errorCode != other.errorCode) return false;
        if (isCaughtUp != other.isCaughtUp) return false;
        if (isFenced != other.isFenced) return false;
        if (shouldShutDown != other.shouldShutDown) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + errorCode;
        hashCode = 31 * hashCode + (isCaughtUp ? 1231 : 1237);
        hashCode = 31 * hashCode + (isFenced ? 1231 : 1237);
        hashCode = 31 * hashCode + (shouldShutDown ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public BrokerHeartbeatResponseData duplicate() {
        BrokerHeartbeatResponseData _duplicate = new BrokerHeartbeatResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        _duplicate.errorCode = errorCode;
        _duplicate.isCaughtUp = isCaughtUp;
        _duplicate.isFenced = isFenced;
        _duplicate.shouldShutDown = shouldShutDown;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "BrokerHeartbeatResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", errorCode=" + errorCode
            + ", isCaughtUp=" + (isCaughtUp ? "true" : "false")
            + ", isFenced=" + (isFenced ? "true" : "false")
            + ", shouldShutDown=" + (shouldShutDown ? "true" : "false")
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public short errorCode() {
        return this.errorCode;
    }
    
    public boolean isCaughtUp() {
        return this.isCaughtUp;
    }
    
    public boolean isFenced() {
        return this.isFenced;
    }
    
    public boolean shouldShutDown() {
        return this.shouldShutDown;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public BrokerHeartbeatResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public BrokerHeartbeatResponseData setErrorCode(short v) {
        this.errorCode = v;
        return this;
    }
    
    public BrokerHeartbeatResponseData setIsCaughtUp(boolean v) {
        this.isCaughtUp = v;
        return this;
    }
    
    public BrokerHeartbeatResponseData setIsFenced(boolean v) {
        this.isFenced = v;
        return this;
    }
    
    public BrokerHeartbeatResponseData setShouldShutDown(boolean v) {
        this.shouldShutDown = v;
        return this;
    }
}
