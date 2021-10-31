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
import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class DescribeGroupsResponseData implements ApiMessage {
    int throttleTimeMs;
    List<DescribedGroup> groups;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_0), "Each described group.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_0), "Each described group.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_3), "Each described group.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("groups", new ArrayOf(DescribedGroup.SCHEMA_4), "Each described group.")
        );
    
    public static final Schema SCHEMA_5 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("groups", new CompactArrayOf(DescribedGroup.SCHEMA_5), "Each described group."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4,
        SCHEMA_5
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 5;
    
    public DescribeGroupsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DescribeGroupsResponseData() {
        this.throttleTimeMs = 0;
        this.groups = new ArrayList<DescribedGroup>(0);
    }
    
    @Override
    public short apiKey() {
        return 15;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 5;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        if (_version >= 1) {
            this.throttleTimeMs = _readable.readInt();
        } else {
            this.throttleTimeMs = 0;
        }
        {
            if (_version >= 5) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field groups was serialized as null");
                } else {
                    ArrayList<DescribedGroup> newCollection = new ArrayList<DescribedGroup>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribedGroup(_readable, _version));
                    }
                    this.groups = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field groups was serialized as null");
                } else {
                    ArrayList<DescribedGroup> newCollection = new ArrayList<DescribedGroup>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribedGroup(_readable, _version));
                    }
                    this.groups = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 5) {
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
        if (_version >= 5) {
            _writable.writeUnsignedVarint(groups.size() + 1);
            for (DescribedGroup groupsElement : groups) {
                groupsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(groups.size());
            for (DescribedGroup groupsElement : groups) {
                groupsElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 5) {
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
        {
            if (_version >= 5) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(groups.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (DescribedGroup groupsElement : groups) {
                groupsElement.addSize(_size, _cache, _version);
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
        if (_version >= 5) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeGroupsResponseData)) return false;
        DescribeGroupsResponseData other = (DescribeGroupsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.groups == null) {
            if (other.groups != null) return false;
        } else {
            if (!this.groups.equals(other.groups)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (groups == null ? 0 : groups.hashCode());
        return hashCode;
    }
    
    @Override
    public DescribeGroupsResponseData duplicate() {
        DescribeGroupsResponseData _duplicate = new DescribeGroupsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        ArrayList<DescribedGroup> newGroups = new ArrayList<DescribedGroup>(groups.size());
        for (DescribedGroup _element : groups) {
            newGroups.add(_element.duplicate());
        }
        _duplicate.groups = newGroups;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DescribeGroupsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", groups=" + MessageUtil.deepToString(groups.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DescribedGroup> groups() {
        return this.groups;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DescribeGroupsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeGroupsResponseData setGroups(List<DescribedGroup> v) {
        this.groups = v;
        return this;
    }
    
    public static class DescribedGroup implements Message {
        short errorCode;
        String groupId;
        String groupState;
        String protocolType;
        String protocolData;
        List<DescribedGroupMember> members;
        int authorizedOperations;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The describe error, or 0 if there was no error."),
                new Field("group_id", Type.STRING, "The group ID string."),
                new Field("group_state", Type.STRING, "The group state string, or the empty string."),
                new Field("protocol_type", Type.STRING, "The group protocol type, or the empty string."),
                new Field("protocol_data", Type.STRING, "The group protocol data, or the empty string."),
                new Field("members", new ArrayOf(DescribedGroupMember.SCHEMA_0), "The group members.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("error_code", Type.INT16, "The describe error, or 0 if there was no error."),
                new Field("group_id", Type.STRING, "The group ID string."),
                new Field("group_state", Type.STRING, "The group state string, or the empty string."),
                new Field("protocol_type", Type.STRING, "The group protocol type, or the empty string."),
                new Field("protocol_data", Type.STRING, "The group protocol data, or the empty string."),
                new Field("members", new ArrayOf(DescribedGroupMember.SCHEMA_0), "The group members."),
                new Field("authorized_operations", Type.INT32, "32-bit bitfield to represent authorized operations for this group.")
            );
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("error_code", Type.INT16, "The describe error, or 0 if there was no error."),
                new Field("group_id", Type.STRING, "The group ID string."),
                new Field("group_state", Type.STRING, "The group state string, or the empty string."),
                new Field("protocol_type", Type.STRING, "The group protocol type, or the empty string."),
                new Field("protocol_data", Type.STRING, "The group protocol data, or the empty string."),
                new Field("members", new ArrayOf(DescribedGroupMember.SCHEMA_4), "The group members."),
                new Field("authorized_operations", Type.INT32, "32-bit bitfield to represent authorized operations for this group.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("error_code", Type.INT16, "The describe error, or 0 if there was no error."),
                new Field("group_id", Type.COMPACT_STRING, "The group ID string."),
                new Field("group_state", Type.COMPACT_STRING, "The group state string, or the empty string."),
                new Field("protocol_type", Type.COMPACT_STRING, "The group protocol type, or the empty string."),
                new Field("protocol_data", Type.COMPACT_STRING, "The group protocol data, or the empty string."),
                new Field("members", new CompactArrayOf(DescribedGroupMember.SCHEMA_5), "The group members."),
                new Field("authorized_operations", Type.INT32, "32-bit bitfield to represent authorized operations for this group."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 5;
        
        public DescribedGroup(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribedGroup() {
            this.errorCode = (short) 0;
            this.groupId = "";
            this.groupState = "";
            this.protocolType = "";
            this.protocolData = "";
            this.members = new ArrayList<DescribedGroupMember>(0);
            this.authorizedOperations = -2147483648;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribedGroup");
            }
            this.errorCode = _readable.readShort();
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field groupId was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field groupId had invalid length " + length);
                } else {
                    this.groupId = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field groupState was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field groupState had invalid length " + length);
                } else {
                    this.groupState = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field protocolType was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field protocolType had invalid length " + length);
                } else {
                    this.protocolType = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field protocolData was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field protocolData had invalid length " + length);
                } else {
                    this.protocolData = _readable.readString(length);
                }
            }
            {
                if (_version >= 5) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field members was serialized as null");
                    } else {
                        ArrayList<DescribedGroupMember> newCollection = new ArrayList<DescribedGroupMember>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribedGroupMember(_readable, _version));
                        }
                        this.members = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field members was serialized as null");
                    } else {
                        ArrayList<DescribedGroupMember> newCollection = new ArrayList<DescribedGroupMember>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribedGroupMember(_readable, _version));
                        }
                        this.members = newCollection;
                    }
                }
            }
            if (_version >= 3) {
                this.authorizedOperations = _readable.readInt();
            } else {
                this.authorizedOperations = -2147483648;
            }
            this._unknownTaggedFields = null;
            if (_version >= 5) {
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
            _writable.writeShort(errorCode);
            {
                byte[] _stringBytes = _cache.getSerializedValue(groupId);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(groupState);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(protocolType);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(protocolData);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 5) {
                _writable.writeUnsignedVarint(members.size() + 1);
                for (DescribedGroupMember membersElement : members) {
                    membersElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(members.size());
                for (DescribedGroupMember membersElement : members) {
                    membersElement.write(_writable, _cache, _version);
                }
            }
            if (_version >= 3) {
                _writable.writeInt(authorizedOperations);
            } else {
                if (this.authorizedOperations != -2147483648) {
                    throw new UnsupportedVersionException("Attempted to write a non-default authorizedOperations at version " + _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 5) {
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
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribedGroup");
            }
            _size.addBytes(2);
            {
                byte[] _stringBytes = groupId.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'groupId' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(groupId, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                byte[] _stringBytes = groupState.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'groupState' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(groupState, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                byte[] _stringBytes = protocolType.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'protocolType' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(protocolType, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                byte[] _stringBytes = protocolData.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'protocolData' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(protocolData, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 5) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(members.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (DescribedGroupMember membersElement : members) {
                    membersElement.addSize(_size, _cache, _version);
                }
            }
            if (_version >= 3) {
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
            if (_version >= 5) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedGroup)) return false;
            DescribedGroup other = (DescribedGroup) obj;
            if (errorCode != other.errorCode) return false;
            if (this.groupId == null) {
                if (other.groupId != null) return false;
            } else {
                if (!this.groupId.equals(other.groupId)) return false;
            }
            if (this.groupState == null) {
                if (other.groupState != null) return false;
            } else {
                if (!this.groupState.equals(other.groupState)) return false;
            }
            if (this.protocolType == null) {
                if (other.protocolType != null) return false;
            } else {
                if (!this.protocolType.equals(other.protocolType)) return false;
            }
            if (this.protocolData == null) {
                if (other.protocolData != null) return false;
            } else {
                if (!this.protocolData.equals(other.protocolData)) return false;
            }
            if (this.members == null) {
                if (other.members != null) return false;
            } else {
                if (!this.members.equals(other.members)) return false;
            }
            if (authorizedOperations != other.authorizedOperations) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (groupId == null ? 0 : groupId.hashCode());
            hashCode = 31 * hashCode + (groupState == null ? 0 : groupState.hashCode());
            hashCode = 31 * hashCode + (protocolType == null ? 0 : protocolType.hashCode());
            hashCode = 31 * hashCode + (protocolData == null ? 0 : protocolData.hashCode());
            hashCode = 31 * hashCode + (members == null ? 0 : members.hashCode());
            hashCode = 31 * hashCode + authorizedOperations;
            return hashCode;
        }
        
        @Override
        public DescribedGroup duplicate() {
            DescribedGroup _duplicate = new DescribedGroup();
            _duplicate.errorCode = errorCode;
            _duplicate.groupId = groupId;
            _duplicate.groupState = groupState;
            _duplicate.protocolType = protocolType;
            _duplicate.protocolData = protocolData;
            ArrayList<DescribedGroupMember> newMembers = new ArrayList<DescribedGroupMember>(members.size());
            for (DescribedGroupMember _element : members) {
                newMembers.add(_element.duplicate());
            }
            _duplicate.members = newMembers;
            _duplicate.authorizedOperations = authorizedOperations;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribedGroup("
                + "errorCode=" + errorCode
                + ", groupId=" + ((groupId == null) ? "null" : "'" + groupId.toString() + "'")
                + ", groupState=" + ((groupState == null) ? "null" : "'" + groupState.toString() + "'")
                + ", protocolType=" + ((protocolType == null) ? "null" : "'" + protocolType.toString() + "'")
                + ", protocolData=" + ((protocolData == null) ? "null" : "'" + protocolData.toString() + "'")
                + ", members=" + MessageUtil.deepToString(members.iterator())
                + ", authorizedOperations=" + authorizedOperations
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String groupId() {
            return this.groupId;
        }
        
        public String groupState() {
            return this.groupState;
        }
        
        public String protocolType() {
            return this.protocolType;
        }
        
        public String protocolData() {
            return this.protocolData;
        }
        
        public List<DescribedGroupMember> members() {
            return this.members;
        }
        
        public int authorizedOperations() {
            return this.authorizedOperations;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribedGroup setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DescribedGroup setGroupId(String v) {
            this.groupId = v;
            return this;
        }
        
        public DescribedGroup setGroupState(String v) {
            this.groupState = v;
            return this;
        }
        
        public DescribedGroup setProtocolType(String v) {
            this.protocolType = v;
            return this;
        }
        
        public DescribedGroup setProtocolData(String v) {
            this.protocolData = v;
            return this;
        }
        
        public DescribedGroup setMembers(List<DescribedGroupMember> v) {
            this.members = v;
            return this;
        }
        
        public DescribedGroup setAuthorizedOperations(int v) {
            this.authorizedOperations = v;
            return this;
        }
    }
    
    public static class DescribedGroupMember implements Message {
        String memberId;
        String groupInstanceId;
        String clientId;
        String clientHost;
        byte[] memberMetadata;
        byte[] memberAssignment;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
                new Field("client_id", Type.STRING, "The client ID used in the member's latest join group request."),
                new Field("client_host", Type.STRING, "The client host."),
                new Field("member_metadata", Type.BYTES, "The metadata corresponding to the current group protocol in use."),
                new Field("member_assignment", Type.BYTES, "The current assignment provided by the group leader.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("member_id", Type.STRING, "The member ID assigned by the group coordinator."),
                new Field("group_instance_id", Type.NULLABLE_STRING, "The unique identifier of the consumer instance provided by end user."),
                new Field("client_id", Type.STRING, "The client ID used in the member's latest join group request."),
                new Field("client_host", Type.STRING, "The client host."),
                new Field("member_metadata", Type.BYTES, "The metadata corresponding to the current group protocol in use."),
                new Field("member_assignment", Type.BYTES, "The current assignment provided by the group leader.")
            );
        
        public static final Schema SCHEMA_5 =
            new Schema(
                new Field("member_id", Type.COMPACT_STRING, "The member ID assigned by the group coordinator."),
                new Field("group_instance_id", Type.COMPACT_NULLABLE_STRING, "The unique identifier of the consumer instance provided by end user."),
                new Field("client_id", Type.COMPACT_STRING, "The client ID used in the member's latest join group request."),
                new Field("client_host", Type.COMPACT_STRING, "The client host."),
                new Field("member_metadata", Type.COMPACT_BYTES, "The metadata corresponding to the current group protocol in use."),
                new Field("member_assignment", Type.COMPACT_BYTES, "The current assignment provided by the group leader."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4,
            SCHEMA_5
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 5;
        
        public DescribedGroupMember(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribedGroupMember() {
            this.memberId = "";
            this.groupInstanceId = null;
            this.clientId = "";
            this.clientHost = "";
            this.memberMetadata = Bytes.EMPTY;
            this.memberAssignment = Bytes.EMPTY;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 5;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribedGroupMember");
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field memberId was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field memberId had invalid length " + length);
                } else {
                    this.memberId = _readable.readString(length);
                }
            }
            if (_version >= 4) {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.groupInstanceId = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field groupInstanceId had invalid length " + length);
                } else {
                    this.groupInstanceId = _readable.readString(length);
                }
            } else {
                this.groupInstanceId = null;
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field clientId was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field clientId had invalid length " + length);
                } else {
                    this.clientId = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field clientHost was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field clientHost had invalid length " + length);
                } else {
                    this.clientHost = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readInt();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field memberMetadata was serialized as null");
                } else {
                    byte[] newBytes = new byte[length];
                    _readable.readArray(newBytes);
                    this.memberMetadata = newBytes;
                }
            }
            {
                int length;
                if (_version >= 5) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readInt();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field memberAssignment was serialized as null");
                } else {
                    byte[] newBytes = new byte[length];
                    _readable.readArray(newBytes);
                    this.memberAssignment = newBytes;
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 5) {
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
                byte[] _stringBytes = _cache.getSerializedValue(memberId);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 4) {
                if (groupInstanceId == null) {
                    if (_version >= 5) {
                        _writable.writeUnsignedVarint(0);
                    } else {
                        _writable.writeShort((short) -1);
                    }
                } else {
                    byte[] _stringBytes = _cache.getSerializedValue(groupInstanceId);
                    if (_version >= 5) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
                }
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(clientId);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            {
                byte[] _stringBytes = _cache.getSerializedValue(clientHost);
                if (_version >= 5) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 5) {
                _writable.writeUnsignedVarint(memberMetadata.length + 1);
            } else {
                _writable.writeInt(memberMetadata.length);
            }
            _writable.writeByteArray(memberMetadata);
            if (_version >= 5) {
                _writable.writeUnsignedVarint(memberAssignment.length + 1);
            } else {
                _writable.writeInt(memberAssignment.length);
            }
            _writable.writeByteArray(memberAssignment);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 5) {
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
            if (_version > 5) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribedGroupMember");
            }
            {
                byte[] _stringBytes = memberId.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'memberId' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(memberId, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (_version >= 4) {
                if (groupInstanceId == null) {
                    if (_version >= 5) {
                        _size.addBytes(1);
                    } else {
                        _size.addBytes(2);
                    }
                } else {
                    byte[] _stringBytes = groupInstanceId.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'groupInstanceId' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(groupInstanceId, _stringBytes);
                    if (_version >= 5) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
                }
            }
            {
                byte[] _stringBytes = clientId.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'clientId' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(clientId, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                byte[] _stringBytes = clientHost.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'clientHost' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(clientHost, _stringBytes);
                if (_version >= 5) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                _size.addBytes(memberMetadata.length);
                if (_version >= 5) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(memberMetadata.length + 1));
                } else {
                    _size.addBytes(4);
                }
            }
            {
                _size.addBytes(memberAssignment.length);
                if (_version >= 5) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(memberAssignment.length + 1));
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
            if (_version >= 5) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribedGroupMember)) return false;
            DescribedGroupMember other = (DescribedGroupMember) obj;
            if (this.memberId == null) {
                if (other.memberId != null) return false;
            } else {
                if (!this.memberId.equals(other.memberId)) return false;
            }
            if (this.groupInstanceId == null) {
                if (other.groupInstanceId != null) return false;
            } else {
                if (!this.groupInstanceId.equals(other.groupInstanceId)) return false;
            }
            if (this.clientId == null) {
                if (other.clientId != null) return false;
            } else {
                if (!this.clientId.equals(other.clientId)) return false;
            }
            if (this.clientHost == null) {
                if (other.clientHost != null) return false;
            } else {
                if (!this.clientHost.equals(other.clientHost)) return false;
            }
            if (!Arrays.equals(this.memberMetadata, other.memberMetadata)) return false;
            if (!Arrays.equals(this.memberAssignment, other.memberAssignment)) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (memberId == null ? 0 : memberId.hashCode());
            hashCode = 31 * hashCode + (groupInstanceId == null ? 0 : groupInstanceId.hashCode());
            hashCode = 31 * hashCode + (clientId == null ? 0 : clientId.hashCode());
            hashCode = 31 * hashCode + (clientHost == null ? 0 : clientHost.hashCode());
            hashCode = 31 * hashCode + Arrays.hashCode(memberMetadata);
            hashCode = 31 * hashCode + Arrays.hashCode(memberAssignment);
            return hashCode;
        }
        
        @Override
        public DescribedGroupMember duplicate() {
            DescribedGroupMember _duplicate = new DescribedGroupMember();
            _duplicate.memberId = memberId;
            if (groupInstanceId == null) {
                _duplicate.groupInstanceId = null;
            } else {
                _duplicate.groupInstanceId = groupInstanceId;
            }
            _duplicate.clientId = clientId;
            _duplicate.clientHost = clientHost;
            _duplicate.memberMetadata = MessageUtil.duplicate(memberMetadata);
            _duplicate.memberAssignment = MessageUtil.duplicate(memberAssignment);
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribedGroupMember("
                + "memberId=" + ((memberId == null) ? "null" : "'" + memberId.toString() + "'")
                + ", groupInstanceId=" + ((groupInstanceId == null) ? "null" : "'" + groupInstanceId.toString() + "'")
                + ", clientId=" + ((clientId == null) ? "null" : "'" + clientId.toString() + "'")
                + ", clientHost=" + ((clientHost == null) ? "null" : "'" + clientHost.toString() + "'")
                + ", memberMetadata=" + Arrays.toString(memberMetadata)
                + ", memberAssignment=" + Arrays.toString(memberAssignment)
                + ")";
        }
        
        public String memberId() {
            return this.memberId;
        }
        
        public String groupInstanceId() {
            return this.groupInstanceId;
        }
        
        public String clientId() {
            return this.clientId;
        }
        
        public String clientHost() {
            return this.clientHost;
        }
        
        public byte[] memberMetadata() {
            return this.memberMetadata;
        }
        
        public byte[] memberAssignment() {
            return this.memberAssignment;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribedGroupMember setMemberId(String v) {
            this.memberId = v;
            return this;
        }
        
        public DescribedGroupMember setGroupInstanceId(String v) {
            this.groupInstanceId = v;
            return this;
        }
        
        public DescribedGroupMember setClientId(String v) {
            this.clientId = v;
            return this;
        }
        
        public DescribedGroupMember setClientHost(String v) {
            this.clientHost = v;
            return this;
        }
        
        public DescribedGroupMember setMemberMetadata(byte[] v) {
            this.memberMetadata = v;
            return this;
        }
        
        public DescribedGroupMember setMemberAssignment(byte[] v) {
            this.memberAssignment = v;
            return this;
        }
    }
}
